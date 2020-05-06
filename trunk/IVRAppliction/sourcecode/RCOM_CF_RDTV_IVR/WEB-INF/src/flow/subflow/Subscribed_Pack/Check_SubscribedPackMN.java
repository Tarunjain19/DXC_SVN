package flow.subflow.Subscribed_Pack;

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
 * Last generated by Orchestration Designer at: 2015-MAY-29  12:49:23 PM
 */
public class Check_SubscribedPackMN extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-29  12:49:23 PM
	 */
	public Check_SubscribedPackMN() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-SEP-02  06:27:38 PM
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
	 * Last generated by Orchestration Designer at: 2015-SEP-02  06:27:38 PM
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
	 * Last generated by Orchestration Designer at: 2015-SEP-02  06:27:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "SubscribedPack_MN ReturnCode :: ", "SubscribedPack_MN:ReturnCode").setDebugId(297));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "SubscribedPack_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(298)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "SubscribedPack_MN Value :: ", "SubscribedPack_MN:Value").setDebugId(299));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:ChangePack", true).setDebugId(300)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0021", false).setDebugId(310));
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-transfer", "change-pack").setDebugId(301));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:BuyTopUp", true).setDebugId(302)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-TopUp_Pack", "buy-topup").setDebugId(303));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:BuyServices", true).setDebugId(306)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-latest_movies_services", "buy-services").setDebugId(307));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:CancelTopUp", true).setDebugId(308)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-Cancel_A_PAck2", "cancel-topup").setDebugId(309));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:previous", true).setDebugId(311)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-previous", "previous").setDebugId(312));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "SubscribedPack_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:MainMenu", true).setDebugId(313)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-mainmenu", "mainmenu").setDebugId(314));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(370));
				actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-transfer", "representative").setDebugId(316));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Subscribed_Pack-tries_exceed", "tries-exceed").setDebugId(318));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}