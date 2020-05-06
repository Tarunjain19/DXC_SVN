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
 * Last generated by Orchestration Designer at: 2015-JUN-14  05:09:54 PM
 */
public class EvaluatePrepaidMenu extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-14  05:09:54 PM
	 */
	public EvaluatePrepaidMenu() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:04 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "PrepaidMainMenu:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(10079)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "PrepaidMainMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:ReportLoss", true).setDebugId(10081)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0010", true).setDebugId(14926));
				actions.add(new com.avaya.sce.runtime.Next("CheckServiceType", "(Report Loss)").setDebugId(10082));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "PrepaidMainMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:PrepaidAccInfo", true).setDebugId(10087)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PrepaidAccInfo", "(Prepaid Acc Info)").setDebugId(10088));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "PrepaidMainMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:InternetAndVas", true).setDebugId(10089)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InternetVAS", "(Internet & VAS)").setDebugId(10090));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "PrepaidMainMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "AGENT", false).setDebugId(16571)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0009", true).setDebugId(16574));
				actions.add(new com.avaya.sce.runtime.Next("checkNIExceeds", "Agent").setDebugId(16572));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "PrepaidMainMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "IOT", false).setDebugId(16611)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0105", true).setDebugId(16612));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:IOTChargable", "false", true).setDebugId(16621));
				actions.add(new com.avaya.sce.runtime.Next("checkNIExceeds", "IOT Calls").setDebugId(16613));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("set_HotFlash_Product", "(Products & Offers)").setDebugId(10092));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "PrepaidMainMenu:ReturnCode", false).setDebugId(15333));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0009", true).setDebugId(14925));
			actions.add(new com.avaya.sce.runtime.Next("checkNIExceeds", "(Exceeded)").setDebugId(10077));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}