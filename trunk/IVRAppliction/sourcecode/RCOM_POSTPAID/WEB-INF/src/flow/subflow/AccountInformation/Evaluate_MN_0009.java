package flow.subflow.AccountInformation;

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
 * Last generated by Orchestration Designer at: 2015-MAY-13  03:09:12 PM
 */
public class Evaluate_MN_0009 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-13  03:09:12 PM
	 */
	public Evaluate_MN_0009() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-28  11:20:51 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "CheckBill_MN_0009:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(2220)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "CheckBill_MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:BillDelivery", true).setDebugId(2221)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-AccessHost_DeliveryStatus", "BillDelivery").setDebugId(2222));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "CheckBill_MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:OnlinePayment", true).setDebugId(2223)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-PaymentInfo_MN_0011", "OnlinePayment").setDebugId(2224));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "CheckBill_MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Repeat", true).setDebugId(2229)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("CallData:menuRepeatTries").setDebugId(5833));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "CallData:menuRepeatTries", com.avaya.sce.runtime.Expression.INT_GREATER_THEN_EQUAL, "3", false).setDebugId(5834)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0034", true).setDebugId(5835));
					actions.add(new com.avaya.sce.runtime.Next("AccountInformation-RepeatTriesExceeded_PA_0090c", "TriesExceed").setDebugId(5836));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("AccountInformation-CheckBillDateDiff", "Repeat").setDebugId(2230));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "CheckBill_MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Previous", true).setDebugId(2231)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-BillPaymentInfo_MN_0008", "Previous").setDebugId(2232));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "CheckBill_MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:MainMenu", true).setDebugId(2233)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-MainMenu", "MainMenu").setDebugId(2234));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-Transfer", "Transfer").setDebugId(2236));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "CheckBill_MN_0009:ReturnCode", false).setDebugId(5861));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "Flag:isFromIntelligentLayer", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(2238)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-MainMenu", "NINM_MainMenu").setDebugId(2239));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0082", true).setDebugId(4975));
				actions.add(new com.avaya.sce.runtime.Next("AccountInformation-Transfer", "NINM_Transfer").setDebugId(2241));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}