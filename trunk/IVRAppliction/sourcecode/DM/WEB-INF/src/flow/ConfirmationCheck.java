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
 * Last generated by Orchestration Designer at: 2013-OCT-15  06:09:10 PM
 */
public class ConfirmationCheck extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2013-OCT-15  06:09:10 PM
	 */
	public ConfirmationCheck() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:35 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("CheckSuccessPrompt", "Yes");
		next.setDebugId(1042);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:35 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:35 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "confirmationreturnvalues:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "no", false).setDebugId(1015)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "IDM_Variables:countConfirmation", com.avaya.sce.runtime.Expression.INT_LESS_THAN, "inputVariables:noAnswerMaxCount", true).setDebugId(1016)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Increment("IDM_Variables:countConfirmation").setDebugId(1017));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "inputVariables:noAnswerApologies", com.avaya.sce.runtime.Expression.STRING_NOT_EQUAL_IGNORE, "NONE", false).setDebugId(1018)).evaluate(mySession)) {
					actions = new java.util.ArrayList(5);
					actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "inputVariables:noAnswerApologies", "*", false).setDebugId(1019));
					actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("COLLECTIONINITIALPROMPT").setDebugId(1020));
					actions.add(new com.avaya.sce.runtime.varoperations.NextInCollection("COLLECTIONINITIALPROMPT").setDebugId(1021));
					actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "TRACE", "COLLECTIONINITIALPROMPT").setDebugId(1023));
					actions.add(new com.avaya.sce.runtime.Next("PlayNoAnswerApologies", "No").setDebugId(1024));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("IDM_Variables:retryconfirmation", "true", true).setDebugId(1026));
					actions.add(new com.avaya.sce.runtime.Next("ResetVar", "NoAudio").setDebugId(1027));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			}

			actions = new java.util.ArrayList(6);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("FLAGS:MAXTRY", "CONSTANTS:TRUE", false).setDebugId(1383));
			actions.add(new com.avaya.sce.runtime.varoperations.Parse("COLLECTIONINITIALPROMPT", "inputVariables:noAnswerLimitPrompt", "*", false).setDebugId(1028));
			actions.add(new com.avaya.sce.runtime.varoperations.ResetCollection("COLLECTIONINITIALPROMPT").setDebugId(1029));
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "TRACE", "COLLECTIONINITIALPROMPT").setDebugId(1030));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Output_Parameters:returncode", "NEGATIVECONF", true).setDebugId(1031));
			actions.add(new com.avaya.sce.runtime.Next("PlayNINM", "MaxRetryConfirmation").setDebugId(1032));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "confirmationreturnvalues:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "yes", false).setDebugId(1033)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "Prompt and collect Result :", "PromptAndCollect").setDebugId(1636));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "PromptAndCollect:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:MORE", true).setDebugId(1622)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PromptandCollectCheck", "More Option").setDebugId(1626));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "PromptAndCollect:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:PREVIOUS", true).setDebugId(1627)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PromptandCollectCheck", "Previous").setDebugId(1631));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "PromptAndCollect:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:REPEAT", true).setDebugId(1711)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PromptandCollectCheck", "Repeat").setDebugId(1712));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "PromptAndCollect:RESULT", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:HELP", true).setDebugId(1714)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PromptandCollectCheck", "Help").setDebugId(1721));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}


			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "inputVariables:confirmationValueFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:FALSE", true).setDebugId(2049)).evaluate(mySession)) {
				actions = new java.util.ArrayList(4);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:value", "confirmationreturnvalues:value", false).setDebugId(1034));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:interpretation", "confirmationreturnvalues:interpretation", false).setDebugId(1039));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:utterance", "confirmationreturnvalues:utterance", false).setDebugId(1040));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:RESULT", "confirmationreturnvalues:RESULT", false).setDebugId(1036));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:OTHER_SLOT", "confirmationreturnvalues:OTHER_SLOT", false).setDebugId(1035));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:confidence", "confirmationreturnvalues:confidence", false).setDebugId(1037));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("PromptAndCollect:inputmode", "confirmationreturnvalues:inputmode", false).setDebugId(1038));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}