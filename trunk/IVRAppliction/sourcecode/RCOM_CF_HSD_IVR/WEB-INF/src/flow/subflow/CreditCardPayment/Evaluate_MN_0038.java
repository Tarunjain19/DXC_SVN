package flow.subflow.CreditCardPayment;

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
 * Last generated by Orchestration Designer at: 2015-MAY-14  04:31:13 PM
 */
public class Evaluate_MN_0038 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-14  04:31:13 PM
	 */
	public Evaluate_MN_0038() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:10 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:10 PM
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
	 * Last generated by Orchestration Designer at: 2016-AUG-11  02:39:10 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ConfirmAmount_MN_0038:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:success", true).setDebugId(1673)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Increment("Postpaid_CallData:amountTries").setDebugId(2473));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ConfirmAmount_MN_0038:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "ConfirmAmount", false).setDebugId(2470)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-AccessPACE_ValidateCardDetails", "AmountCollected").setDebugId(1674));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Postpaid_CallData:amountTries", com.avaya.sce.runtime.Expression.INT_GREATER_THEN_EQUAL, "3", false).setDebugId(2474)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-TriesExceeded_PA_0083", "TriesExceeded").setDebugId(2472));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-CollectAmount_MN_0037", "ReEnter").setDebugId(2476));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Flag:CalledFromIntelligent", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Postpaid_Constants:yes", true).setDebugId(1676)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-MainMenu", "NINM_MainMenu").setDebugId(1677));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("Postpaid_CallData:transferReasonCode", "TR_0111", true).setDebugId(2456));
				actions.add(new com.avaya.sce.runtime.Next("CreditCardPayment-Transfer", "NINM_Transfer").setDebugId(1679));
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