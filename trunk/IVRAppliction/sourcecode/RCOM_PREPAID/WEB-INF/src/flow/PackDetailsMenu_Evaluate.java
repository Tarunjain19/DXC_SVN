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
 * Last generated by Orchestration Designer at: 2015-MAR-12  11:44:24 PM
 */
public class PackDetailsMenu_Evaluate extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  11:44:24 PM
	 */
	public PackDetailsMenu_Evaluate() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:22 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:22 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:22 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "PackDetails Menu Return Code", "PackDetailsMenu:ReturnCode").setDebugId(4957));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "PackDetails Menu Return Value", "PackDetailsMenu:Value").setDebugId(4958));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "Pack Detail Menu ID :", "PackDetailsMenu:MenuID").setDebugId(7485));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "PackDetailsMenu:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(4959)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "PackDetailsMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:agent", true).setDebugId(4960)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "PackDetailsMenu:MenuID", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MN_0022", false).setDebugId(7480)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0099", true).setDebugId(7478));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "PackDetailsMenu:MenuID", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MN_0039", false).setDebugId(7481)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0100", true).setDebugId(7483));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0101", true).setDebugId(7484));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("checkNIexceeds", "agent").setDebugId(4961));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "PackDetailsMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:MainMenu", true).setDebugId(4962)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("checkMainMenuCount", "MainMenu").setDebugId(4963));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "PackDetailsMenu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MenuOption:previous", true).setDebugId(4964)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Get_STVMenu", "previous").setDebugId(4965));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Get_PackConfirmMenu", "RechargeConfirm").setDebugId(4967));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "PackDetailsMenu:ReturnCode", false).setDebugId(9081));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "PackDetailsMenu:MenuID", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MN_0022", false).setDebugId(7486)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0037", true).setDebugId(7487));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "PackDetailsMenu:MenuID", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MN_0039", false).setDebugId(7488)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0038", true).setDebugId(7489));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0036", true).setDebugId(7491));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("checkNIexceeds", "ExceededTries").setDebugId(4969));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
