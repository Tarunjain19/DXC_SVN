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
 * Last generated by Orchestration Designer at: 2015-MAR-12  11:27:44 PM
 */
public class checkMainMenuCount extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  11:27:44 PM
	 */
	public checkMainMenuCount() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:21 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:MainMenuCount").setDebugId(1546));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:CalledFromIntelligent", "constant:Key_False", false).setDebugId(5988));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "appVariables:MainMenuCount", com.avaya.sce.runtime.Expression.INT_LESS_THAN_EQUAL, "4", false).setDebugId(1547)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:HNIcaller", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Key_true", true).setDebugId(1711)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:globalPropertyFileName", "propertyFileName:HNI_global", false).setDebugId(1712));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:propertyFileName", "propertyFileName:MainMenuHNI", false).setDebugId(1713));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:globalPropertyFileName", "propertyFileName:Normal_Global", false).setDebugId(1715));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("dmInputParameter:propertyFileName", "propertyFileName:MainMenu", false).setDebugId(1716));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("MainMenu", "Allow").setDebugId(1543));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0001", true).setDebugId(7444));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "NOMATCH", true).setDebugId(10133));
			actions.add(new com.avaya.sce.runtime.Next("checkNIexceeds", "agent").setDebugId(1549));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
