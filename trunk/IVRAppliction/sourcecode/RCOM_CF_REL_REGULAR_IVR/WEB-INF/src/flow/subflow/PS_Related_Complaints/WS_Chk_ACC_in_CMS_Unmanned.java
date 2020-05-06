package flow.subflow.PS_Related_Complaints;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.energy.AppConstants;
import com.rcom.energy.StackTrace;
import com.servion.rcom.hostinterface.view.ReqAccountDetails;
import com.servion.rcom.hostinterface.view.ResAccountDetails;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.IVRDataBean;

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
 * Last generated by Orchestration Designer at: 2016-SEP-12  11:03:13 AM
 */
public class WS_Chk_ACC_in_CMS_Unmanned extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-SEP-12  11:03:13 AM
	 */
	public WS_Chk_ACC_in_CMS_Unmanned() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	public void requestBegin(SCESession mySession) {
		
		ITraceInfo trace = mySession.getTraceOutput();
		
		/*
		 * Calling Web service to get Account Number using CLI
		 */
		
		IVRWebService ivrWebService = null;
		String MDN = null;
		String uniqueId = null;
		String responseCode = null;
		boolean isSingleAccountFound = false;
		boolean isNoAccountFound = false;
		try
		{
		uniqueId = mySession.getSessionId();
		MDN = mySession.getVariableField(IProjectVariables.SESSION, IProjectVariables.SESSION_FIELD_ANI).getStringValue();
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Inputs to Host Interface : ");
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Unique ID : "+uniqueId);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "MDN : "+MDN);
		
		ReqAccountDetails req = new ReqAccountDetails();
		if(mySession.getVariableField(IProjectVariables.VALIDATE_MOBILE_NUMBER, IProjectVariables.VALIDATE_MOBILE_NUMBER_FIELD_IS_VALID_MDN).getBooleanValue())
			req.setMDN(mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_VALID_MDN).getStringValue());
		
		else
			req.setMDN(MDN);
		ivrWebService = new IVRWebServiceImpl();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Before calling getAccountDetails service");
		ResAccountDetails res = ivrWebService.getAccountDetails((IVRDataBean)mySession.getProperty(AppConstants.IVR_DATA_BEAN), req);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "After calling getAccountDetails service");
		responseCode = res.getResponseCode();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Host Interface response code : " +responseCode);
		if(responseCode.equalsIgnoreCase(AppConstants.WS_RESPONSE_SUCCESS))
		{
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_WEB_SERVICE_RESPONSE).setValue(AppConstants.SUCCESS);
			isSingleAccountFound = res.isSingleAccountFound();
			isNoAccountFound = res.isNoAccFound();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Is Single Account : " +isSingleAccountFound+" ,Customer Name : "+res.getConsumerName());
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_SINGLE_ACCOUNT).setValue(isSingleAccountFound);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_NO_ACCOUNT).setValue(isNoAccountFound);
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CUSTOMER_NAME).setValue(res.getConsumerName());
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_ACCOUNT_NO).setValue(res.getAccountNumber());
		}
		else
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_WEB_SERVICE_RESPONSE).setValue(AppConstants.FAILURE);
		}
		catch(Exception e)
		{
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_WEB_SERVICE_RESPONSE).setValue(AppConstants.FAILURE);
			StackTrace.PrintException(e);
		}
		
	}
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:20 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:20 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  03:43:20 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:WebServiceResponse", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(1695)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "AppVariables:IsSingleAccount", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(1696)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:IsSingleAccount", "CONSTANTS:FALSE", false).setDebugId(1697));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:RegisterdMobile_Flag", "CONSTANTS:TRUE", false).setDebugId(2820));
				actions.add(new com.avaya.sce.runtime.Next("PS_Related_Complaints-Set_AccNum1", "Single").setDebugId(1698));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "AppVariables:IsNoAccount", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(1699)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:IsNoAccount", "CONSTANTS:FALSE", false).setDebugId(1700));
				actions.add(new com.avaya.sce.runtime.Next("PS_Related_Complaints-Unmanned_InputMenu", "NoAcc").setDebugId(1701));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PS_Related_Complaints-Unmanned_InputMenu", "MultiAcc").setDebugId(1703));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("PS_Related_Complaints-Disconnect", "Failure").setDebugId(1706));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
