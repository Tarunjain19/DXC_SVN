package flow;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.StackTrace;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.prepaid.report.IVRREPORTDATA.CALLINFO;

import com.servion.util.AppProperties;
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
 * Last generated by Orchestration Designer at: 2015-JUL-22  07:29:42 PM
 */
public class Capture_ANI_DNIS_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-22  07:29:42 PM
	 */
	public Capture_ANI_DNIS_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:38:57 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		com.avaya.sce.runtime.BooleanOperation bo1 = new com.avaya.sce.runtime.BooleanOperation(com.avaya.sce.runtime.BooleanOperation.AND);
		com.avaya.sce.runtime.Expression be1 = new com.avaya.sce.runtime.Expression("expression1", "session:ani", com.avaya.sce.runtime.Expression.NOT_EMPTY);
		bo1.addExpression(be1);
		com.avaya.sce.runtime.Expression be2 = new com.avaya.sce.runtime.Expression("expression2", "session:dnis", com.avaya.sce.runtime.Expression.NOT_EMPTY);
		bo1.addExpression(be2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "ANI :", "session:ani").setDebugId(8684));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "DNIS :", "session:dnis").setDebugId(8685));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Application Name", "APP_NAME").setDebugId(8686));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition").setDebugId(8687)).evaluate(mySession, bo1)) {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:ANI", "session:ani", false).setDebugId(8691));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:DNIS", "session:dnis", false).setDebugId(8692));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "session:uui", com.avaya.sce.runtime.Expression.IS_EMPTY).setDebugId(10041)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Check_DNISRouting", "callwithoutUUI").setDebugId(10042));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ConnectionTypeRetunedAtUuiIsPrepaid", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NA", false).setDebugId(10052)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.SetCurrentLanguage("LanguageInUui", false).setDebugId(10070));
				actions.add(new com.avaya.sce.runtime.Next("CheckDataCard", "ConnectionTypeNA").setDebugId(10054));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "AppVariables:ANI", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "NA", false).setDebugId(10053)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.SetCurrentLanguage("LanguageInUui", false).setDebugId(10071));
				actions.add(new com.avaya.sce.runtime.Next("CheckDataCard", "DataCardNumberNA").setDebugId(10055));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "NoDataInDataCardNumber", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "True", false).setDebugId(10062)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CheckDataCard", "DataCardNumberEmpty").setDebugId(10072));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.varoperations.SetCurrentLanguage("LanguageInUui", false).setDebugId(10050));
				actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Language in UUI::", "LanguageInUui").setDebugId(10051));
				actions.add(new com.avaya.sce.runtime.Next("Check_GetDataCard", "CheckDataCard").setDebugId(10044));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("ANINotAvailableAnnc", "notAvailable").setDebugId(8695));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {

		/**Declaration **/
		String sessionID = AppConstant.EMPTY_STRING,PropertyKey= AppConstant.EMPTY_STRING;
		String appName = AppConstant.EMPTY_STRING,PropertyLocation= AppConstant.EMPTY_STRING,defaultLanguage = AppConstant.EMPTY_STRING;
		Logger logger = null;
		ITraceInfo trace = null;
		IVRREPORTDATA ivrreportdata = null;
		InetAddress ip = null;
		CALLINFO callInfo  = null;
		SimpleDateFormat dateFormat = null;
		String callerType = AppConstant.EMPTY_STRING;
		String aniOverride = AppConstant.EMPTY_STRING;
		String strANI = "";
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		try{
			String languagewithuui=mySession.getVariableField(IProjectVariables.LANGUAGE_IN_UUI).getStringValue();
			
			if(!(languagewithuui.isEmpty()||languagewithuui==null)){
				defaultLanguage=mySession.getVariableField(IProjectVariables.LANGUAGE_IN_UUI).getStringValue();
				mySession.getVariableField(IProjectVariables.LANGUAGE_IN_UUI).setValue(defaultLanguage);
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Setting Language as recived with UUI :"+defaultLanguage);
				
				
			}
			else{
				
				defaultLanguage = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DefaultLanguage);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "default  Language else :"+defaultLanguage);
			}
			sessionID = mySession.getSessionId();
			logger = Logger.getLogger(AppConstant.LOGGER_NAME_CALLLEVEL);
			//defaultLanguage = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DefaultLanguage);
			appName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.APP_NAME);
			PropertyKey = AppConstant.PROPERTY+appName+AppConstant.SEPERATOR_UNDERSCORE+defaultLanguage;
			dateFormat =  new SimpleDateFormat(AppConstant.DATE_FORMAT_REPORT);
			strANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			mySession.getVariableField(IProjectVariables.POSTPAID__CALL_DATA, IProjectVariables.POSTPAID__CALL_DATA_FIELD_MDN).setValue(strANI);
			
			/**Create IVR Bean Object**/
			IVRDataBean objIVRDataBean = new IVRDataBean(); 
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Session ID :"+sessionID);
			objIVRDataBean.setLogger(logger);
			objIVRDataBean.setSessionID(sessionID);
			
			/** ANI Overriding **/
			aniOverride = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.OVERRIDE_ANI);
			if(!aniOverride.equalsIgnoreCase(AppConstant.N) && aniOverride !=null && !aniOverride.equalsIgnoreCase(AppConstant.EMPTY_STRING))
			{
				mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).setValue(aniOverride);
				mySession.getVariableField(IProjectVariables.POSTPAID__CALL_DATA, IProjectVariables.POSTPAID__CALL_DATA_FIELD_MDN).setValue(aniOverride);
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "** ANI Overriden **");
			}
			
			/**Default Property File Location**/
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "default Language :"+defaultLanguage);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "application Name :"+appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Property Key :"+PropertyKey);
			
			PropertyLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(PropertyKey);
			mySession.getVariableField(IProjectVariables.APP__NAME).setValue(appName);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Property Location :"+PropertyLocation);
			
			if(PropertyLocation!=null && PropertyLocation!="N")
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(PropertyLocation);
			else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
				PropertyLocation = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DEFAULT_PROPERTY_LOCATION);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"default properties Location :"+PropertyLocation);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(PropertyLocation);
			}
			
			/**Postpaid Intelligent Layer && Postpaid Information Configuration**/
			mySession.getVariableField(IProjectVariables.POSTPAID__CALL_DATA, IProjectVariables.POSTPAID__CALL_DATA_FIELD_APPLICATION_NAME).setValue(appName);
			mySession.getVariableField(IProjectVariables.POSTPAID__CALL_DATA, IProjectVariables.POSTPAID__CALL_DATA_FIELD_ALLOWED_MAIN_MENU_COUNT).setValue(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.Postpaid_AllowedMainMenuCount));
			
			/**Reporting**/
			GetReportObject objGetReportObject = new GetReportObject();
			objGetReportObject.createIVRReportObject();
			objIVRDataBean.setGetReportObject(objGetReportObject);
			mySession.setProperty(AppConstant.IVRDATABEAN,objIVRDataBean);
			
			ivrreportdata = objGetReportObject.createIVRReportObject();
			mySession.setProperty(AppConstant.BEANREPORTDATA, objGetReportObject);
			objGetReportObject.setIvrreportdata(ivrreportdata);
			objIVRDataBean.setGetReportObject(objGetReportObject);
			
			/**Assigning call info data for report*/
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"/*** Call Info Reporting is started ***/");
			ip= InetAddress.getLocalHost();
			callInfo  = ivrreportdata.getCALLINFO();
			callInfo.setUNIQUECALLID(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			callInfo.setSESSIONID(mySession.getSessionId());
			callInfo.setVXMLIP(String.valueOf(ip));
			callInfo.setSTARTDATETIME(dateFormat.format(new Date()));
			callInfo.setAPPNAME(appName);
			callInfo.setCALLERTYPE(callerType);
			callInfo.setCATEGORY(AppConstant.NA);
			callInfo.setCIRCLEID(AppConstant.NA);
			callInfo.setCLI(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue());
			callInfo.setDNIS(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue());
			callInfo.setDNISTYPE(AppConstant.NA);
			callInfo.setHUB(AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.HUB));
			callInfo.setAGENTID(AppConstant.NA);
			callInfo.setAGENTEXTN(AppConstant.NA);
			callInfo.setTRANSCODE(AppConstant.NA);
			callInfo.setTRANSCODE(AppConstant.NA);
			callInfo.setLANGUAGEFROM(AppConstant.NA);
			callInfo.setLANGUAGETO(AppConstant.NA);
			callInfo.setTAGGING(AppConstant.NA);
			callInfo.setTRANSFERVDN(AppConstant.NA);
			callInfo.setUUIDATA(AppConstant.NA);
			callInfo.setABANDONEDFLAG(AppConstant.NA);
			callInfo.setTRANSTOIVR(AppConstant.NA);
			callInfo.setSKILLNAME(AppConstant.NA);
			callInfo.setLANGCODE(AppConstant.ENG);
			callInfo.setENDDATETIME(AppConstant.NA);
			callInfo.setDTMFPATH(AppConstant.NA);
			callInfo.setMENUPATH(AppConstant.NA);
			callInfo.setCALLERPATH(AppConstant.NA);
			callInfo.setLASTMENUACCESSED(AppConstant.NA);
			callInfo.setLASTNODEACCESSED(AppConstant.NA);
			callInfo.setDISPOSITION(AppConstant.ID);
			callInfo.setCALLENDREASON(AppConstant.IVR_DISCONNECT);
			callInfo.setHOWCALLENDED(AppConstant.DISCONNECT);
			callInfo.setERRREASON(AppConstant.NA);
			ivrreportdata.setCALLINFO(callInfo);
			
			objIVRDataBean.setGetReportObject(objGetReportObject);
			/**Setting Bean in Session **/
			mySession.setProperty(AppConstant.IVRDATABEAN,objIVRDataBean);
		}catch(Exception e){
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR,"ERROR in Call Start :"+e);
			StackTrace.PrintException(e);
		}
		
	}
}