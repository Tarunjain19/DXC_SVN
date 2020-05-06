package flow.subflow.Prepaid_Start;

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
 * Last generated by Orchestration Designer at: 2015-MAR-12  11:44:24 PM
 */
public class ConfirmTopUpAmt_Evaluate extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  11:44:24 PM
	 */
	public ConfirmTopUpAmt_Evaluate() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:51 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "RVC Menu Return Code", "ConfirmTopUpAmount:ReturnCode").setDebugId(10490));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "RVC Menu Return Value", "ConfirmTopUpAmount:Value").setDebugId(10491));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ConfirmTopUpAmount:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_constant:success", true).setDebugId(10492)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ConfirmTopUpAmount:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Prepaid_MenuOption:confirm", true).setDebugId(10493)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_Flag:RCVFlag", "Prepaid_constant:Key_true", false).setDebugId(10494));
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-Push_SMS_topup", "confirm").setDebugId(10495));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("Prepaid_appVariables:TopupCounter").setDebugId(10497));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Prepaid_appVariables:TopupCounter", com.avaya.sce.runtime.Expression.INT_EQUAL, "3", false).setDebugId(10498)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:transferCode", "TR_0006", true).setDebugId(10499));
					actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-TopUpTriesExceed", "exceed").setDebugId(10500));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				}

				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-TopUpInfo", "cancel").setDebugId(10501));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Prepaid_appVariables:transferCode", "TR_0031", true).setDebugId(10503));
			actions.add(new com.avaya.sce.runtime.Next("Prepaid_Start-Get_TransferVDN", "ExceededTries").setDebugId(10504));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
