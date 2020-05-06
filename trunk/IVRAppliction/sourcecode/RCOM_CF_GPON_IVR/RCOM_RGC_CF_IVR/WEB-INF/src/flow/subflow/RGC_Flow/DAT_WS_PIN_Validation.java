package flow.subflow.RGC_Flow;

import javax.xml.rpc.holders.StringHolder;

import org.tempuri.RGC_ServicesSoapProxy;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hpe.util.AppConstant;
import com.hpe.util.XMLParser;

import flow.IProjectVariables;

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
 * Last generated by Orchestration Designer at: 2016-JUN-07  11:49:57 AM
 */
public class DAT_WS_PIN_Validation extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JUN-07  11:49:57 AM
	 */
	public DAT_WS_PIN_Validation() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	public void requestBegin(SCESession mySession)
	{
		String pin = AppConstant.EMPTY_STRING,PhNum = AppConstant.EMPTY_STRING;
		String EndpointURL =AppConstant.EMPTY_STRING,AUTH_KEY =AppConstant.EMPTY_STRING,EDUID =AppConstant.EMPTY_STRING;
		String testResp = AppConstant.EMPTY_STRING, Result_status = AppConstant.EMPTY_STRING,attribute = "Message";
		
		PhNum = mySession.getVariableField(IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU,IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU_FIELD_VALUE).getStringValue();
		pin = mySession.getVariableField(IProjectVariables.DM__GET__PIN,IProjectVariables.DM__GET__PIN_FIELD_VALUE).getStringValue();
		
		EndpointURL = mySession.getVariableField(IProjectVariables.WS__VALIDATE__PIN,IProjectVariables.WS__VALIDATE__PIN_FIELD_ENDPOINT_URL).getStringValue();
		AUTH_KEY = 	mySession.getVariableField(IProjectVariables.AUTH__KEY).getStringValue();	
		EDUID =  mySession.getVariableField(IProjectVariables.EDUID).getStringValue();	

		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"Web service operation - Validate PIN", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"REGISTERED_NUMBER - "+PhNum, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"EndpointURL - "+EndpointURL, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"INT_INTERACTION_TYPE - 1", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"INT_SERVICE_TYPE - 0", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"INT_VALIDATE_TYPE - 0", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"AUTH_KEY - "+ AUTH_KEY, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"EDUID - "+ EDUID, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"MESSAGE - ", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"PIN_NUMBER - ", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"PRODUCT_CODE - RGCIVR", mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"RESPONSE_XML - ", mySession);
		
		try
		{
			
		RGC_ServicesSoapProxy servInst= new RGC_ServicesSoapProxy();
		servInst.setEndpoint(mySession.getVariableField(IProjectVariables.WS__VALIDATE__PIN,IProjectVariables.WS__VALIDATE__PIN_FIELD_ENDPOINT_URL).getStringValue());
		testResp = servInst.validateCustomer(mySession.getVariableField(IProjectVariables.AUTH__KEY).getStringValue(), mySession.getVariableField(IProjectVariables.EDUID).getStringValue(), 1,mySession.getVariableField(IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU,IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU_FIELD_VALUE).getStringValue(),mySession.getVariableField(IProjectVariables.DM__GET__PIN,IProjectVariables.DM__GET__PIN_FIELD_VALUE).getStringValue(), 0, 0, "RGCIVR", new StringHolder(""), new StringHolder(""));

		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"Webservice operation SUCCESS - ", mySession);
		
		XMLParser obj = new XMLParser();
		Result_status = obj.parseXML(testResp,attribute);
		
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"RespXml is - "+testResp, mySession);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO," Result_status  is - "+Result_status, mySession);
		
		mySession.getVariableField(IProjectVariables.WS__VALIDATE__PIN,IProjectVariables.WS__VALIDATE__PIN_FIELD_OUT__STR_MESSAGE).setValue(Result_status);
		mySession.getVariableField(IProjectVariables.WS__VALIDATE__PIN,IProjectVariables.WS__VALIDATE__PIN_FIELD_OUT__STR_RESPONSE_XML).setValue(testResp);
		
		}
		catch(Exception e)
		{
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_INFO,"PIN Validation - Webservice operation failed  - "+testResp, mySession);
			mySession.getVariableField(IProjectVariables.FLAG__APPLICATION__ERROR).setValue(AppConstant.TRUE);
		}
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUN-23  05:13:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag_Application_Error", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:TRUE", true).setDebugId(1596)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.ReportAlarmInfo(com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "RCOM_RGC_CF_IVR - Webservice Error while validating registered mobile number with PIN", "session:sessionid", true).setDebugId(1597));
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-TechDiffMsg", "Tech_Diff_Msg").setDebugId(1598));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "WS_Validate_PIN:Out_strMessage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(1599)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-DAT_Store_PIN", "success").setDebugId(1600));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-DM_Invalid_PIN_Msg", "failure").setDebugId(1602));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
