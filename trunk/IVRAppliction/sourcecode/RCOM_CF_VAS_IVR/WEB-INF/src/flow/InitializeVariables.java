package flow;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.Data.utils.Constants;
import com.rcom.Data.utils.StackTrace;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.rcom.vas.model.IVRRoutingInfo;
import com.rcom.vas.resource.IVRDBServiceInstance;

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
 * Last generated by Orchestration Designer at: 2015-APR-02  12:34:25 PM
 */
public class InitializeVariables extends com.avaya.sce.runtime.Data {

	//private static Logger logger = Logger.getLogger("Dialog.Designer.TraceWriter.RCOM_CF_Televerification_IVR");
	private static Logger logger = Logger.getLogger("Dialog.Designer.TraceWriter.RCOM_CF_VAS_IVR");
	
	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-02  12:34:25 PM
	 */
	public InitializeVariables() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		super.requestBegin(mySession);
		
		ITraceInfo info = null;
		IVRDataBean ivrDataBean = null;
	    
		String strInitialAudios = Constants.BLANK;
		String propertiesFilePath = Constants.BLANK,ivrConfigFileName = Constants.BLANK,dynamicConfigFileName = Constants.BLANK;
		String strLanguages = Constants.BLANK;
		String strDefaultLanguage = Constants.ENG;
		GetReportObject getReportObject = null;
		IVRREPORTDATA ivrreportdata = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		InetAddress ip = null;
		CALLINFO callInfo  = null;
		String ani = Constants.BLANK,dnis = Constants.BLANK,appName = Constants.BLANK;;
		String propertyKey = Constants.BLANK,propertyLocation = Constants.BLANK,hostresult = Constants.Success;
		info = mySession.getTraceOutput();
		
			
		/*Setting logger and sesion id */
		ivrDataBean = new IVRDataBean();
		ivrDataBean.setLogger(logger);
		ivrDataBean.setSessionID(mySession.getSessionId());
		mySession.setProperty(Constants.IVRDataBean, (IVRDataBean) ivrDataBean);
		IVRRoutingInfo objIVRRoutingInfo = null;
		
		ani 	= mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_ANI).getStringValue().trim();
		dnis 	= mySession.getVariableField(IProjectVariables.SESSION,IProjectVariables.SESSION_FIELD_DNIS).getStringValue().trim();
		appName = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(Constants.ApplicationName).trim();
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Application name ::"+appName);
		mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_APP_NAME).setValue(appName);
		
		if(AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(ani).trim()!= null && AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(ani).trim()!="N")
			ani = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(ani).trim();
		info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Masked Ani ::"+ani);	
		/* Test Configuration */
			
		try{
			
			
			getReportObject = new GetReportObject();
			ivrreportdata = getReportObject.createIVRReportObject();
			getReportObject.setIvrreportdata(ivrreportdata);
			ivrDataBean.setGetReportObject(getReportObject);
			
			mySession.setProperty("BEANREPORTDATA", getReportObject);
			
			mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_ANI).setValue(ani);
			mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_DNIS).setValue(dnis);
			

			/*Assigning call info data for report*/
			
			ip= InetAddress.getLocalHost();
			callInfo  = ivrreportdata.getCALLINFO();
			callInfo.setUNIQUECALLID(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			callInfo.setSESSIONID(mySession.getSessionId());
			callInfo.setVXMLIP(String.valueOf(ip));
			callInfo.setSTARTDATETIME(dateFormat.format(new Date()));
			callInfo.setAPPNAME(mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_APP_NAME).getStringValue());
			callInfo.setCALLERTYPE("NA");
			callInfo.setCATEGORY("NA");
			callInfo.setCIRCLEID("NA");
			callInfo.setCLI(ani);
			callInfo.setDNIS(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			callInfo.setDNISTYPE("NA");
			callInfo.setHUB(AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp("HUB"));
			callInfo.setAGENTID("NA");
			callInfo.setAGENTEXTN("NA");
			callInfo.setTRANSCODE("NA");
			callInfo.setTRANSFERVDN("NA");
			callInfo.setUUIDATA("NA");
			callInfo.setABANDONEDFLAG("NA");
			callInfo.setTRANSTOIVR("NA");
			callInfo.setSKILLNAME("NA");
			callInfo.setLANGCODE("ENG");
			callInfo.setENDDATETIME("NA");
			callInfo.setDTMFPATH("NA");
			callInfo.setMENUPATH("NA");
			callInfo.setCALLERPATH("NA");
			callInfo.setLASTMENUACCESSED("NA");
			callInfo.setDISPOSITION("ID");
			callInfo.setCALLENDREASON("IVR_DISCONNECT");
			callInfo.setHOWCALLENDED("DISCONNECT");
			callInfo.setERRREASON("NA");
			callInfo.setLANGUAGEFROM("NA");
			callInfo.setLANGUAGETO("NA");
			callInfo.setTAGGING("NA");
			callInfo.setLASTNODEACCESSED("NA");
			ivrreportdata.setCALLINFO(callInfo);
			
			ivrDataBean.setGetReportObject(getReportObject);
			
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Application Name:: "+mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_APP_NAME).getStringValue());
			
			
			objIVRRoutingInfo = new IVRRoutingInfo();
			
			String circleID="NAA";
				
				  objIVRRoutingInfo.setDnis(dnis);
				  try{
				 
					  objIVRRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(ivrDataBean, objIVRRoutingInfo);
				  }catch(Exception e){
					  info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Exception in calling IVRRouting info"+e.getMessage());
					  StackTrace.PrintException(e);
					  strDefaultLanguage = Constants.ENG;
					  strLanguages ="ENG,HIN";
				  }
				  if(objIVRRoutingInfo!=null){
					    hostresult = Constants.Success;
						circleID=objIVRRoutingInfo.getCircle();
						callInfo.setCIRCLEID(circleID);
						ivrreportdata.setCALLINFO(callInfo);
						//trunkID= objIVRRoutingInfo.getTrunkGroup();
						strLanguages = objIVRRoutingInfo.getLanguage();
						strDefaultLanguage = objIVRRoutingInfo.getDefaultLanguage();
						
						  info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "strDefaultLanguage after hit DB :"+strDefaultLanguage);
						  info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "language list after hit DB :"+strLanguages);
						  if(strLanguages==null || Constants.EMPTY_STRING.equals(strLanguages)){
								info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language List is Empty");
								strLanguages = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(Constants.LANGUAGE_LIST);
								
								if(!Constants.N.equalsIgnoreCase(strLanguages)){
									mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_REGIONAL_LANG).setValue(strLanguages);
								}else{
									String defaultList = Constants.ENG+Constants.COMMA+Constants.HIN;
									mySession.getVariableField(IProjectVariables.APP__VARIABLES,IProjectVariables.APP__VARIABLES_FIELD_REGIONAL_LANG).setValue(defaultList);	
								}
						  }
				  }
				  else
				 {
						strDefaultLanguage = Constants.ENG;
						strLanguages ="ENG,HIN";
				 }
				  /**Default Property File Location**/
					
					propertyKey = Constants.PROPERTY+appName+Constants.UNDERSCORE+strDefaultLanguage;
					
				
					
					propertyLocation = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(propertyKey).trim();
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Property Location :"+propertyLocation);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Language List* :"+strLanguages);
					
					if(propertyLocation!=null && !"N".equalsIgnoreCase(propertyLocation))
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertyLocation);
					else{
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
						propertyLocation = AppProperties.GetInstance(Constants.VAS_CONFIG).getIVRProp(Constants.DEFAULT_PROPERTY_LOCATION);
						info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"default properties Location :"+propertyLocation);
						mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertyLocation);
					}
					
					
					
					
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "default Language :"+strDefaultLanguage);
					info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Language list :"+strLanguages);
					
					// mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(PropertyLocation);
					
			
			
		}catch (Exception e) {
			strDefaultLanguage = Constants.ENG;
			strLanguages ="ENG,HIN";
			StackTrace.PrintException(e);
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_HOSTRESULT).setValue(Constants.ERROR);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "default Language in catch:"+strDefaultLanguage);
			info.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Language list in catch :"+strLanguages);
		}finally{
			
		
			
			
			//mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_ANI).setValue(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_DEFAULT_LANGUAGE).setValue(strDefaultLanguage);
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_REGIONAL_LANG).setValue(strLanguages);
			mySession.getVariableField(IProjectVariables.APP__VARIABLES, IProjectVariables.APP__VARIABLES_FIELD_HOSTRESULT).setValue(hostresult);
			
			
			
					
			
		}

		
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
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
	 * Last generated by Orchestration Designer at: 2016-DEC-07  03:15:31 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "App_Variables:hostresult", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(3396)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Welcome_Ann", "Default").setDebugId(3252));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("LikDown", "LinkDown").setDebugId(3397));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
