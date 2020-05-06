package flow;

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
 * Last generated by Orchestration Designer at: 2015-MAY-29  01:07:41 PM
 */
public class CheckMultiMainMenu_BC extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  01:07:41 PM
	 */
	public CheckMultiMainMenu_BC() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("ThankYouAnnc", "TriesExceeded");
		next.setDebugId(1371);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-12  05:47:07 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "MultiMainMenu_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(1373)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "MultiMainMenu_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:SmartCardNumber", true).setDebugId(1375)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("SCNAccountsStatus", "SmartCardNumber").setDebugId(1376));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "MultiMainMenu_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:AccountBalance", true).setDebugId(1377)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CollectSCNo", "AccountBalance").setDebugId(1378));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "MultiMainMenu_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:AnotherSmartCardNumber", true).setDebugId(1379)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("CollectSCN", "AnotherSmartCardNumber").setDebugId(1380));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("GetStartedKit_MN", "GetStartedKit").setDebugId(1382));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferPoint", "TransferPoints:RD02_TR_0005", false).setDebugId(1383));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
