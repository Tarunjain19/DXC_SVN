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
 * Last generated by Orchestration Designer at: 2015-JUN-12  07:46:23 PM
 */
public class ConfirmCDMAInput extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-12  07:46:23 PM
	 */
	public ConfirmCDMAInput() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
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
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
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
	 * Last generated by Orchestration Designer at: 2016-OCT-12  02:20:52 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ConfirmNumber Return Code :: ", "ConfirmCDMANumber:ReturnCode").setDebugId(5901));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ConfirmCDMANumber:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:Success", true).setDebugId(5902)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ConfirmNumber Value ::", "ConfirmCDMANumber:Value").setDebugId(5903));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ConfirmCDMANumber:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Confirm", true).setDebugId(5904)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MOBILE", false).setDebugId(5929)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CollectLast4Digit", "MOBILE").setDebugId(5930));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "DIGIT", false).setDebugId(5932)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("CollectsimNumber", "DIGIT").setDebugId(5934));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "SIM", false).setDebugId(5933)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Thanks_CDMA_PP", "SIM").setDebugId(5935));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Thanks_CDMA_PP", "NOTget").setDebugId(5937));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:mobileNoCount").setDebugId(5907));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "appVariables:mobileNoCount", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "Constants:three", true).setDebugId(5908)).evaluate(mySession)) {

					if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "MOBILE", false).setDebugId(5938)).evaluate(mySession)) {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.Next("CollectCDMAMobileNumber", "MOBILE").setDebugId(5939));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "DIGIT", false).setDebugId(5940)).evaluate(mySession)) {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.Next("CollectLast4Digit", "DIGIT").setDebugId(5941));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "Flag:Check_CDMA_Stage", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "SIM", false).setDebugId(5942)).evaluate(mySession)) {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.Next("CollectsimNumber", "SIM").setDebugId(5943));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					} else {
						actions = new java.util.ArrayList(1);
						actions.add(new com.avaya.sce.runtime.Next("Thanks_CDMA_PP", "NOTget").setDebugId(5945));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;
					}


				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Thanks_CDMA_PP", "ExceedsCount").setDebugId(5911));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:TR_0006", false).setDebugId(5913));
			actions.add(new com.avaya.sce.runtime.Next("Thanks_CDMA_PP", "StdErr").setDebugId(5914));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}