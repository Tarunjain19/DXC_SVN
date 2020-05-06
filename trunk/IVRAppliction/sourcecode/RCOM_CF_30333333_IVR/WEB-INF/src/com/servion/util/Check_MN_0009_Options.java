package com.servion.util;

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
 * Last generated by Orchestration Designer at: 2015-APR-08  10:29:56 PM
 */
public class Check_MN_0009_Options extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-08  10:29:56 PM
	 */
	public Check_MN_0009_Options() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("InternetAndVAS-AgentTransfer", "agent_transfer");
		next.setDebugId(5512);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
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
	 * Last generated by Orchestration Designer at: 2015-JUL-09  09:39:31 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MN_0009", "MN_0009:ReturnCode").setDebugId(5033));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "MN_0009:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(3829)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MN_0009", "MN_0009:Value").setDebugId(5034));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:MyTunes", true).setDebugId(5634)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-MyTunes", "(My Tunes)").setDebugId(5635));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:ActivateVAS", true).setDebugId(5636)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-ActivateVAS", "ActivateVAS").setDebugId(3831));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:DeactivateVAS", true).setDebugId(4927)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-PA_0029", "Deactivate").setDebugId(3833));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:previous", true).setDebugId(4935)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-MN_0008_Inet_VAS_MM", "PreviousMenu").setDebugId(4936));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:agent", true).setDebugId(4942)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0086", true).setDebugId(5613));
				actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-AgentTransfer", "Agent").setDebugId(4943));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "MN_0009:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:MainMenu", true).setDebugId(4932)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "IVR_CSP_Details:isPostpaid", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(5859)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-PostpaidMainMenu", "(Postpaid Main Menu)").setDebugId(5860));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "IVR_CSP_Details:IsPrepaid", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(5861)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-PrepaidMainMenu", "(Prepaid Main Menu)").setDebugId(5862));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("InternetAndVAS-ProspectMainMenu", "(Prospect Main Menu)").setDebugId(5864));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			}

		}

		actions = new java.util.ArrayList(1);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferReason", "TR_0019", true).setDebugId(5614));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
