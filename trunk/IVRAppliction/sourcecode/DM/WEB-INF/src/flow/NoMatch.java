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
 * Last generated by Orchestration Designer at: 2013-OCT-07  11:03:56 AM
 */
public class NoMatch extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2013-OCT-07  11:03:56 AM
	 */
	public NoMatch() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:33 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("ReportEnd", "NoRetry");
		next.setDebugId(245);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:33 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:33 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "IDM_Variables:nomatchcount", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "inputVariables:maxNoMatchCount", true).setDebugId(200)).evaluate(mySession)) {
			actions = new java.util.ArrayList(4);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("FLAGS:NM", "CONSTANTS:TRUE", false).setDebugId(473));
			actions.add(new com.avaya.sce.runtime.varoperations.Increment("IDM_Variables:nomatchcount").setDebugId(201));
			actions.add(new com.avaya.sce.runtime.varoperations.Increment("IDM_Variables:globalCount").setDebugId(2069));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No match Value", "COLLECTIONNOMATCHPROMPT").setDebugId(1332));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "input_dynamicConstraintListCounterFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:TRUE", true).setDebugId(1351)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("IDM_Variables:constraintcount").setDebugId(1352));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "inputVariables:NINMCounter", com.avaya.sce.runtime.Expression.IS_TRUE).setDebugId(202)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("IDM_Variables:noinputcount").setDebugId(203));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "inputVariables:noInputPrompt", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "CONSTANTS:NONE", true).setDebugId(204)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "First NoInput Attempt : ", "IDM_Variables:firstnoinputattempt").setDebugId(205));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

					if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "IDM_Variables:firstnoinputattempt", com.avaya.sce.runtime.Expression.IS_FALSE).setDebugId(206)).evaluate(mySession)) {
						actions = new java.util.ArrayList(5);
						actions.add(new com.avaya.sce.runtime.varoperations.Assign("IDM_Variables:firstnoinputattempt", "CONSTANTS:TRUE", false).setDebugId(207));
						actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONNOINPUTPROMPT", "inputVariables:noInputPrompt", "|", false).setDebugId(208));
						actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("COLLECTIONNOINPUTPROMPT").setDebugId(209));
						actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("COLLECTIONNOINPUTPROMPT").setDebugId(210));
						actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No input  Prompt Collection : ", "COLLECTIONNOINPUTPROMPT").setDebugId(211));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					} else {

						if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "COLLECTIONNOINPUTPROMPT", com.avaya.sce.runtime.Expression.HAS_MORE).setDebugId(213)).evaluate(mySession)) {
							actions = new java.util.ArrayList(3);
							actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "First NoInput Attempt : ", "IDM_Variables:firstnoinputattempt").setDebugId(214));
							actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("COLLECTIONNOINPUTPROMPT").setDebugId(215));
							actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Input Prompt Collection  : ", "COLLECTIONNOINPUTPROMPT").setDebugId(216));
							if(evaluateActions(actions, mySession)) {
								return true;
							}
							actions = null;

						}
					}


				}

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "inputVariables:noMatchPrompt", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "CONSTANTS:NONE", true).setDebugId(217)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "IDM_Variables:firstnomatchattempt", com.avaya.sce.runtime.Expression.IS_FALSE).setDebugId(218)).evaluate(mySession)) {
					actions = new java.util.ArrayList(8);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("IDM_Variables:firstnomatchattempt", "CONSTANTS:TRUE", false).setDebugId(219));
					actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONNOMATCHPROMPT", "inputVariables:noMatchPrompt", "|", false).setDebugId(220));
					actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("COLLECTIONNOMATCHPROMPT").setDebugId(221));
					actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("COLLECTIONNOMATCHPROMPT").setDebugId(222));
					actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Prompt Collection : ", "COLLECTIONNOMATCHPROMPT").setDebugId(223));
					actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "COLLECTIONNOMATCHPROMPT", "*", false).setDebugId(579));
					actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Collection Initial Prompt : ", "COLLECTIONINITIALPROMPT").setDebugId(580));
					actions.add(new com.avaya.sce.runtime.Next("PlayNINM", "FirstNoMatch").setDebugId(224));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {

					if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "COLLECTIONNOMATCHPROMPT", com.avaya.sce.runtime.Expression.HAS_MORE).setDebugId(226)).evaluate(mySession)) {
						actions = new java.util.ArrayList(6);
						actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "First NoMatch Attempt : ", "IDM_Variables:firstnomatchattempt").setDebugId(227));
						actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("COLLECTIONNOMATCHPROMPT").setDebugId(228));
						actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Prompt Collection  : ", "COLLECTIONNOMATCHPROMPT").setDebugId(229));
						actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "COLLECTIONNOMATCHPROMPT", "*", false).setDebugId(230));
						actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Prompt Collection  : ", "COLLECTIONINITIALPROMPT").setDebugId(231));
						actions.add(new com.avaya.sce.runtime.Next("PlayNINM", "NoMatchHasMore").setDebugId(232));
						if(evaluateActions(actions, mySession)) {
							return true;
						}
						actions = null;

					}

					actions = new java.util.ArrayList(3);
					actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "COLLECTIONNOMATCHPROMPT", "*", false).setDebugId(233));
					actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Prompt Collection  : ", "COLLECTIONINITIALPROMPT").setDebugId(234));
					actions.add(new com.avaya.sce.runtime.Next("PlayNINM", "HasNoMore").setDebugId(235));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("COLLECTIONINITIALPROMPT", "CONSTANTS:NONE", false).setDebugId(246));
				actions.add(new com.avaya.sce.runtime.Next("RepromptCheck", "NoNoMatchPrompt").setDebugId(237));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		}

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Output_Parameters:returncode", "CONSTANTS:NOMATCH", false).setDebugId(238));
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Output_Parameters:menuID", "inputVariables:menuID", false).setDebugId(1910));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition10", "inputVariables:noMatchLimitPrompt", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "CONSTANTS:NONE", true).setDebugId(239)).evaluate(mySession)) {
			actions = new java.util.ArrayList(6);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("FLAGS:MAXTRY", "CONSTANTS:TRUE", false).setDebugId(474));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "No Match Limit Prompt : ", "inputVariables:noMatchLimitPrompt").setDebugId(240));
			actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "inputVariables:noMatchLimitPrompt", "*", false).setDebugId(241));
			actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("COLLECTIONINITIALPROMPT").setDebugId(242));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "NoMatch Limit Prompt Collection : ", "COLLECTIONINITIALPROMPT").setDebugId(243));
			actions.add(new com.avaya.sce.runtime.Next("PlayNINM", "TriesExceeded").setDebugId(244));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
