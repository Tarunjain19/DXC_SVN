package flow.subflow.Prepaid;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.hsd.utils.AppConstant;
import com.servion.hsd.utils.Constants;
import com.servion.hsd.utils.DynamicMenu;
import com.servion.hsd.utils.PrintStackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-JUL-21  02:24:14 PM
 */
public class check_GetPayment extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUL-21  02:24:14 PM
	 */
	public check_GetPayment() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:02 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:02 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:02 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "GetPaymentAmount ReturnCode :: ", "GetPaymentAmount:ReturnCode").setDebugId(10434));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "GetPaymentAmount:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(10435)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "GetPaymentAmount Value :: ", "GetPaymentAmount:Value").setDebugId(10436));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-ConfirmPayment", "success").setDebugId(10440));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:HSDI_TR_0063", false).setDebugId(10439));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid-Transfer", "triesexceed").setDebugId(10438));
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
		ITraceInfo trace = null;
		String returnCode = AppConstant.EMPTY_STRING;
		String value  = AppConstant.EMPTY_STRING;
		AppProperties appProperties = null;
		DynamicMenu dynamicMenu = null;
		ArrayList<String> dynamicValueList = null;
		String strApplicationName = AppConstant.EMPTY_STRING,initialPrompt = AppConstant.EMPTY_STRING;
		
		try
		{
			trace = mySession.getTraceOutput();
			dynamicValueList = new ArrayList<String>();
			dynamicMenu = new DynamicMenu();
			returnCode = mySession.getVariableField(IProjectVariables.GET_PAYMENT_AMOUNT, IProjectVariables.GET_PAYMENT_AMOUNT_FIELD_RETURN_CODE).getStringValue();
			if(returnCode.equalsIgnoreCase(AppConstant.Success))
			{
				value = mySession.getVariableField(IProjectVariables.GET_PAYMENT_AMOUNT, IProjectVariables.GET_PAYMENT_AMOUNT_FIELD_VALUE).getStringValue();
				appProperties = AppProperties.GetInstance(AppConstant.DYN_MENU);
				strApplicationName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
				initialPrompt = appProperties.getIVRProp(strApplicationName+Constants.HYPEN+Constants.HSDI_MN_0033);
				
				dynamicValueList.add(value+AppConstant.currency);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, Constants.HSDI_MN_0033+" Initial Prompt From Property File :: "+initialPrompt);
				initialPrompt = dynamicMenu.playPrompt(dynamicValueList, initialPrompt, Constants.NA, trace);
				
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			}
		}
		catch (Exception e) {
			PrintStackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception:"+e.getMessage());
		}
		
	}
}