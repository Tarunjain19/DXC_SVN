package flow;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.utilities.StackTrace;
import com.rcom.otherflows.model.IVRRoutingInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.rcom.utilities.IVR_Utilities;
import com.rcom.utilities.IVRConstants;
import com.rcom.utilities.IVRProperties;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.util.IVRDataBean;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: 2016-JAN-19  04:25:08 PM
 */
public class Dat_initializaVariables extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		
		
		Logger logger = Logger.getLogger("Dialog.Designer.TraceWriter.RCOM_CF_GPON_IVR");
		
		String projectFilePath		=	IVRConstants.EMPTY_QUOTES;
		String configFilePath		=	IVRConstants.EMPTY_QUOTES;
		String MPP_IPAddress		=	IVRConstants.EMPTY_QUOTES;
		String ani					=	IVRConstants.EMPTY_QUOTES;
		String dnis					=	IVRConstants.EMPTY_QUOTES;
		String MPP_IP_Address		=	IVRConstants.EMPTY_QUOTES;
		String sessionID            = 	IVRConstants.EMPTY_QUOTES;
		String circleID	 			=	IVRConstants.EMPTY_QUOTES;
		String strLanguages			=	IVRConstants.EMPTY_QUOTES;
		String strDefaultLanguage	=	IVRConstants.EMPTY_QUOTES;
		String[] languageArray		=   null;
		int total_Langs				=	0;
		//Retries and counts
		int default_Value			= IVRConstants.TWO; // this value will be set if fails to load
		String max_no_input			= IVRConstants.EMPTY_QUOTES;
		String max_no_match			= IVRConstants.EMPTY_QUOTES;
		String max_invalid_retry	= IVRConstants.EMPTY_QUOTES;
		String time_out_second		= IVRConstants.EMPTY_QUOTES;
				
		String rcom_static_phrasepath		= IVRConstants.EMPTY_QUOTES;
		String waveFileName					= IVRConstants.EMPTY_QUOTES;
		String press_wav_filename			= IVRConstants.EMPTY_QUOTES;//This will store the starting press 0 file name with last digit missing. Eg. 45100.wave will be saved 4510. 
		//IVR will append what ever values are requred 1 or 2 so that it will play Press 1 or press 2 accordingly.
		String number_wav_filename			= IVRConstants.EMPTY_QUOTES;
		
		
		
		IVRProperties ivrProp		=	null;
		ITraceInfo itraceInfo		=	null;
		IVR_Utilities ivrUtilities	=	null;
		
		/**Declaration for Reporting **/
		String PropertyKey= IVRConstants.EMPTY_QUOTES;
		String appName = IVRConstants.EMPTY_QUOTES,PropertyLocation= IVRConstants.EMPTY_QUOTES,defaultLanguage = IVRConstants.EMPTY_QUOTES;
		
		IVRREPORTDATA ivrreportdata = null;
		InetAddress ip			    = null;
		CALLINFO callInfo           = null;
		IVRRoutingInfo objIVRRoutingInfo = null;
		SimpleDateFormat dateFormat = null;
		
		try{
			
			
			itraceInfo 				= mySession.getTraceOutput();
			ivrUtilities			= new IVR_Utilities();
			
			ani = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			dnis = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#Incoming ANI: " + ani);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#Incoming DNIS: " + dnis);
			
			//Load the config.properties
			
			projectFilePath				 = getServletContext().getInitParameter(IVRConstants.PROPERTY_FILE_PATH);
			String ivrConfigFileName	 = getServletContext().getInitParameter(IVRConstants.IVR_CONFIG);
			
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# ProjectFilePath: " + projectFilePath);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# IVRConfigFileName: " + ivrConfigFileName);
			
			configFilePath				 = projectFilePath +ivrConfigFileName ;
			
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# IVRConfigFile Path: " + configFilePath);
			ivrProp = IVRProperties.getInstance(configFilePath, mySession);
			
			mySession.getVariableField(IProjectVariables.VAR__CONFIG,IProjectVariables.VAR__CONFIG_FIELD_CONFIG_FILE_PATH).setValue(configFilePath);
			
			// Fetching the IP Address of the VoicePortal that handled the call - this helps in identifying the VoicePortal region
			
			MPP_IP_Address				 = mySession.getRequest().getRemoteAddr();
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# MPP IP: " + MPP_IP_Address);
						
			// Incoming CLI correction
			
			if(ani != null && (ani.length() > 10)){
				
				ani = ani.trim();
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#CLI from ACD::" + ani);
				ani = ivrUtilities.getLastTenDigits(ani);
				mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).setValue(ani);
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#CLI after Correction::" +ani);
				}

			//Loading retries and counters
			max_no_input = ivrProp.getProperty(mySession,IVRConstants.MAX_NO_INPUT).trim();
		
			max_no_match = ivrProp.getProperty(mySession,IVRConstants.MAX_NO_NOMATCH).trim();
			max_invalid_retry = ivrProp.getProperty(mySession,IVRConstants.MAX_INVALID_RETRY).trim();
			time_out_second = ivrProp.getProperty(mySession,IVRConstants.TIME_OUT_SECOND).trim();
			rcom_static_phrasepath = ivrProp.getProperty(mySession,IVRConstants.STATIC_PHRASE_PATH).trim();
			waveFileName	=	ivrProp.getProperty(mySession,IVRConstants.LANGUAGE_WAVE_FILENAME).trim();
			press_wav_filename	=	ivrProp.getProperty(mySession,IVRConstants.PRESS_WAVE_FILE_NAME).trim();
			number_wav_filename	=	ivrProp.getProperty(mySession,IVRConstants.NUMBER_WAVE_FILE_NAME).trim();
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Language wave fileName- " +waveFileName);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# press_wav_filename- " +press_wav_filename);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# number_wav_filename- " +number_wav_filename);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Config Values: max_no_input- " + max_no_input+", max_no_match-"+ max_no_match +
					", max_invalid_retry-" + max_invalid_retry + ", time_out_second-" + time_out_second);
			
			//loading config values to OD session 
			if(max_no_input != null && max_no_input.length() > 0){ 
								
				mySession.getVariableField(IProjectVariables.VAR__CONFIG, IProjectVariables.VAR__CONFIG_FIELD_MAX__NOINPUT).setValue(Integer.parseInt(max_no_input.trim()));
			}
			
			if(max_no_match != null && max_no_match.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__CONFIG, IProjectVariables.VAR__CONFIG_FIELD_MAX__NOMATCH).setValue(Integer.parseInt(max_no_match.trim()));
			}
			
			if(max_invalid_retry != null && max_invalid_retry.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__CONFIG, IProjectVariables.VAR__CONFIG_FIELD_MAX__INVALIDTRY).setValue(Integer.parseInt(max_invalid_retry.trim()));
			}
			
			if(time_out_second != null && time_out_second.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__CONFIG, IProjectVariables.VAR__CONFIG_FIELD_MAX__TIMEOUT).setValue(Integer.parseInt(time_out_second.trim()));
			}
			
			if(rcom_static_phrasepath != null && rcom_static_phrasepath.length() > 0){ 
				
				// Appending backslash  if not given in URL.
				if(!rcom_static_phrasepath.endsWith("/")) rcom_static_phrasepath += "/";
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# rcom_static_phrasepath: " + rcom_static_phrasepath);
				
				mySession.getVariableField(IProjectVariables.VAR__PHRASES, IProjectVariables.VAR__PHRASES_FIELD_STATIC__URL).setValue(rcom_static_phrasepath.trim());
			}
			

			/**Reporting**/
			
			sessionID 	= mySession.getSessionId();
			ivrProp 	= IVRProperties.getInstance((mySession.getVariableField(IProjectVariables.VAR__CONFIG,IProjectVariables.VAR__CONFIG_FIELD_CONFIG_FILE_PATH).getStringValue()),mySession);	

			appName		= ivrProp.getProperty(mySession, IVRConstants.APPLICATION_NAME).trim();
			dateFormat 	=  new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#Application Name :"+appName);
			
			mySession.getVariableField(IProjectVariables.APP_NAME).setValue(appName);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "#Application Name from OD Var :"+mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue());
			/**Create IVR Bean Object**/
			IVRDataBean objIVRDataBean = new IVRDataBean(); 
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Session ID :"+sessionID);
			objIVRDataBean.setLogger(logger);
			objIVRDataBean.setSessionID(sessionID);
			
						
			GetReportObject objGetReportObject = new GetReportObject();
			objGetReportObject.createIVRReportObject();
			objIVRDataBean.setGetReportObject(objGetReportObject);
			mySession.setProperty(IVRConstants.IVRDATABEAN,objIVRDataBean);
			
			ivrreportdata = objGetReportObject.createIVRReportObject();
			mySession.setProperty(IVRConstants.BEANREPORTDATA, objGetReportObject);
			objGetReportObject.setIvrreportdata(ivrreportdata);
			objIVRDataBean.setGetReportObject(objGetReportObject);
			
			/**Assigning call info data for report*/
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_INFO,"/*** Call Info Reporting is started ***/");
			ip= InetAddress.getLocalHost();
			callInfo  = ivrreportdata.getCALLINFO();
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_INFO,"AAAAAAAAA");
			callInfo.setUNIQUECALLID(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			callInfo.setSESSIONID(mySession.getSessionId());
			callInfo.setVXMLIP(String.valueOf(ip));
			callInfo.setSTARTDATETIME(dateFormat.format(new Date()));
			callInfo.setAPPNAME(appName);
			callInfo.setCALLERTYPE(IVRConstants.NA);
			callInfo.setCATEGORY(IVRConstants.NA);
			callInfo.setCIRCLEID(IVRConstants.NA);
			callInfo.setCLI(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			callInfo.setDNIS(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			callInfo.setDNISTYPE(IVRConstants.NA);
			callInfo.setHUB(ivrProp.getProperty(mySession, IVRConstants.HUB).trim());
			callInfo.setAGENTID(IVRConstants.NA);
			callInfo.setAGENTEXTN(IVRConstants.NA);
			callInfo.setTRANSCODE(IVRConstants.NA);
			callInfo.setTRANSCODE(IVRConstants.NA);
			callInfo.setLANGUAGEFROM(IVRConstants.NA);
			callInfo.setLANGUAGETO(IVRConstants.NA);
			callInfo.setTAGGING(IVRConstants.NA);
			callInfo.setTRANSFERVDN(IVRConstants.NA);
			callInfo.setUUIDATA(IVRConstants.NA);
			callInfo.setABANDONEDFLAG(IVRConstants.NA);
			callInfo.setTRANSTOIVR(IVRConstants.NA);
			callInfo.setSKILLNAME(IVRConstants.NA);
			callInfo.setLANGCODE(IVRConstants.NA);
			callInfo.setENDDATETIME(IVRConstants.NA);
			callInfo.setDTMFPATH(IVRConstants.NA);
			callInfo.setMENUPATH(IVRConstants.NA);
			callInfo.setCALLERPATH(IVRConstants.NA);
			callInfo.setLASTMENUACCESSED(IVRConstants.NA);
			callInfo.setDISPOSITION(IVRConstants.CD);
			callInfo.setCALLENDREASON(IVRConstants.IVR_DISCONNECT);
			callInfo.setHOWCALLENDED(IVRConstants.DISCONNECT);
			callInfo.setERRREASON(IVRConstants.NA);
			ivrreportdata.setCALLINFO(callInfo);
			objIVRDataBean.setGetReportObject(objGetReportObject);
			
			/**Setting Bean in Session **/
			mySession.setProperty(IVRConstants.IVRDATABEAN,objIVRDataBean);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_INFO,"GGGGGGGGG");
			objIVRRoutingInfo = new IVRRoutingInfo();
			
			
			objIVRRoutingInfo.setDnis(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			objIVRRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(objIVRDataBean,objIVRRoutingInfo);
			  if(objIVRRoutingInfo!=null){
				  
				  itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"In IVR routing Info");
				  
					circleID	=	objIVRRoutingInfo.getCircle();
					if(circleID!=null&&circleID.length()>0)
					{
					callInfo.setCIRCLEID(circleID);
					ivrreportdata.setCALLINFO(callInfo);
					}
					else
					{
						circleID	  = "NA";
					}
					//trunkID= objIVRRoutingInfo.getTrunkGroup();
					if(objIVRRoutingInfo.getLanguage()!=null&& objIVRRoutingInfo.getLanguage().length()>0)
						strLanguages	   = objIVRRoutingInfo.getLanguage();
					else
						strLanguages		 = ivrProp.getProperty(mySession,IVRConstants.DEFAULT_LANGUAGES).trim();
					if(objIVRRoutingInfo.getDefaultLanguage()!=null&&objIVRRoutingInfo.getDefaultLanguage().length()>0)
						strDefaultLanguage = objIVRRoutingInfo.getDefaultLanguage();
					else
						strDefaultLanguage = IVRConstants.ENG;
					
					 
			  }
			  else
			 {
				  strLanguages		 = ivrProp.getProperty(mySession,IVRConstants.DEFAULT_LANGUAGES).trim();
				  itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"strLanguages"+strLanguages);
				  strDefaultLanguage = IVRConstants.ENG;
			 }
			  itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language Set for Circle "+circleID+ " -"+strLanguages);
			  itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Default Lang Set for Circle "+circleID+ " -"+strDefaultLanguage);
		
			 //Setting success java execute signal to OD code
			mySession.getVariableField(IProjectVariables.VAR__GPON, IProjectVariables.VAR__GPON_FIELD_JAVA__ERROR).setValue(false);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# InitializaVariable.java Java_Error is set to false");

			
		}
		catch(Exception e)
		{
			//Setting failure java execute signal to OD code
			strLanguages		 = ivrProp.getProperty(mySession,IVRConstants.DEFAULT_LANGUAGES).trim();
		    strDefaultLanguage 	 = IVRConstants.ENG;
		 
			mySession.getVariableField(IProjectVariables.VAR__GPON, IProjectVariables.VAR__GPON_FIELD_JAVA__ERROR).setValue(true);
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# InitializaVariable.java Java_Error is set to: " + true );
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "# ERROR: Exception - Srv_ReadConfig.java:- " + e.getMessage());
			StackTrace.PrintException(e);
	
		}
		finally
		{
		 itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language Set for Circle "+circleID+ " -"+strLanguages);
			languageArray = strLanguages.split(",");
			total_Langs = languageArray.length;
			itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Total languages: " + total_Langs );
			//Setting default Lang& circle
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANG).setValue(strDefaultLanguage);
			mySession.getVariableField(IProjectVariables.CALL_DATA, IProjectVariables.CALL_DATA_FIELD_CIRCLE).setValue(circleID);
			//Setting the languages on OD session variable
			
			for(int count = 0;count < total_Langs;count++){
				itraceInfo.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "# Copying language to OD session variable: " + languageArray[count] );
				mySession.getVariableField(IProjectVariables.VAR__LANG, IVRConstants.LANG_ + Integer.toString(count + 1)).setValue(languageArray[count].trim());
			}
			//Setting total languages
			
			mySession.getVariableField(IProjectVariables.VAR__LANG, IProjectVariables.VAR__LANG_FIELD_TOTAL__LANG).setValue(total_Langs);
			
			if(waveFileName != null && waveFileName.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__LANG, IProjectVariables.VAR__LANG_FIELD_WAVFILE__NAME).setValue(waveFileName);
			}
			
			if(press_wav_filename != null && press_wav_filename.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__LANG, IProjectVariables.VAR__LANG_FIELD_PRESS__WAVFILE__NAME).setValue(press_wav_filename);
			}
			if(number_wav_filename != null && number_wav_filename.length() > 0){ 
				
				mySession.getVariableField(IProjectVariables.VAR__LANG, IProjectVariables.VAR__LANG_FIELD_NUMBER__WAVFILE__NAME).setValue(number_wav_filename);
			}
			
			
		}
		
		
		
	}

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JAN-19  04:25:08 PM
	 */
	public Dat_initializaVariables() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:47 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Ann_Welcome", "Default");
		next.setDebugId(9);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:47 PM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:47 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Lang WavefileName", "VAR_LANG:wavfile_name").setDebugId(146));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "VAR_GPON:JAVA_ERROR", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(15)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("SetLinkDown", "LinkDown").setDebugId(16));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
