package flow;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.secretariat.Constants;
import com.rcom.secretariat.StackTrace;
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
 * Last generated by Orchestration Designer at: 2015-MAR-18  08:34:42 PM
 */
public class Capture_ANI_DNIS_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-18  08:34:42 PM
	 */
	public Capture_ANI_DNIS_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		
		AppProperties ivrProperties = null;
		
		try{
		
			GetReportObject getReportObject = null;
			IVRREPORTDATA ivrreportdata = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			InetAddress ip = null;
			CALLINFO callInfo  = null;
			
			Logger logger = Logger.getLogger(this.getClass());
			ITraceInfo trace = mySession.getTraceOutput();
			
			String sessionId = mySession.getSessionId();
			String ANI = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
			String DNIS = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_DNIS).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "SESSION ID : " +sessionId);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "ANI : " +ANI);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DNIS : " +DNIS);
			
			ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA).setValue(ANI+"|" + DNIS + "|");
			
			
			//Setting IVRDataBean in session for DB Transactions - Start
			IVRDataBean ivrDataBean = new IVRDataBean();
			ivrDataBean.setSessionID(sessionId);
			ivrDataBean.setLogger(logger);
			
			//Setting IVRDataBean in session for DB Transactions - End
			
			/*
			 * Setting Report data
			 */
			
			getReportObject = new GetReportObject();
			ivrreportdata = getReportObject.createIVRReportObject();
			mySession.setProperty(Constants.BEANREPORTDATA, getReportObject);
			getReportObject.setIvrreportdata(ivrreportdata);
			ivrDataBean.setGetReportObject(getReportObject);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_APP_NAME).setValue(ivrProperties.getIVRProp(Constants.APP_NAME));
			
			
			/**Assigning call info data for report*/
			ip= InetAddress.getLocalHost();
			callInfo  = ivrreportdata.getCALLINFO();
			callInfo.setUNIQUECALLID(mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_UCID).getStringValue());
			callInfo.setSESSIONID(sessionId);
			callInfo.setVXMLIP(String.valueOf(ip));
			callInfo.setSTARTDATETIME(dateFormat.format(new Date()));
			callInfo.setAPPNAME(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_APP_NAME).getStringValue());
			callInfo.setCALLERTYPE("NA");
			callInfo.setCATEGORY("NA");
			callInfo.setCIRCLEID("NA");
			callInfo.setCLI(ANI);
			callInfo.setDNIS(DNIS);
			callInfo.setDNISTYPE("NA");
			callInfo.setHUB(ivrProperties.getIVRProp(Constants.HUB));
			callInfo.setAGENTID("NA");
			callInfo.setAGENTEXTN("NA");
			callInfo.setTRANSCODE("NA");
			callInfo.setTRANSFERVDN("NA");
			callInfo.setUUIDATA("NA");
			callInfo.setABANDONEDFLAG("NA");
			callInfo.setTRANSTOIVR("NA");
			callInfo.setSKILLNAME("NA");
			callInfo.setLANGCODE(ivrProperties.getIVRProp(Constants.LANGUAGE_ENGLISH));
			callInfo.setENDDATETIME("NA");
			callInfo.setDTMFPATH("NA");
			callInfo.setMENUPATH("NA");
			callInfo.setCALLERPATH("NA");
			callInfo.setLASTMENUACCESSED("NA");
			callInfo.setLASTNODEACCESSED("NA");
			callInfo.setDISPOSITION("ID");
			callInfo.setCALLENDREASON("IVR_DISCONNECT");
			callInfo.setHOWCALLENDED("DISCONNECT");
			callInfo.setERRREASON("NA");
			callInfo.setRESERVE1("NA");
			callInfo.setRESERVE2("NA");
			callInfo.setRESERVE3("NA");
			callInfo.setRESERVE4("NA");
			callInfo.setRESERVE5("NA");
			callInfo.setLANGUAGEFROM("NA");
			callInfo.setLANGUAGETO("NA");
			callInfo.setTAGGING("NA");
		
			
			ivrreportdata.setCALLINFO(callInfo);
			
			ivrDataBean.setGetReportObject(getReportObject);
			
			mySession.setProperty(Constants.IVR_DATA_BEAN, ivrDataBean);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Application Name:: "+mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_APP_NAME).getStringValue());
			
			//Setting English DM properties location in project variable
			String DM_Properties_Location_English = ivrProperties.getIVRProp(Constants.DM_PROPERTIES_LOCATION_ENGLISH);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM_Properties_Location_English : " +DM_Properties_Location_English);
			
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION).setValue(DM_Properties_Location_English);
			
			//Setting English as default language
			String language = ivrProperties.getIVRProp(Constants.LANGUAGE_ENGLISH);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE).setValue(language);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Default Language code for CV : " +language);
		
		} catch(Exception e)
		{
			StackTrace.PrintException(e);
		}
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("DB_GetCircle_BC", "Success");
		next.setDebugId(6);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}