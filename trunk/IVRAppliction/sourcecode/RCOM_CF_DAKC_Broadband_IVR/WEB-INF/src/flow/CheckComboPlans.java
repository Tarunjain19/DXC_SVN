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
 * Last generated by Orchestration Designer at: 2015-MAY-24  07:18:41 PM
 */
public class CheckComboPlans extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-24  07:18:41 PM
	 */
	public CheckComboPlans() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:57 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ComboPlans_MN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:success", true).setDebugId(7728)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ComboPlans_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:GPMR_Repeat", true).setDebugId(7729)).evaluate(mySession)) {

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "appVariables:tries", com.avaya.sce.runtime.Expression.STRING_EQUAL, "constants:Three", true).setDebugId(7730)).evaluate(mySession)) {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0010", false).setDebugId(8745));
					actions.add(new com.avaya.sce.runtime.Next("RepeatTriesExceeded_PP", "(Repeat Tries Exceeded)").setDebugId(7731));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(2);
					actions.add(new com.avaya.sce.runtime.varoperations.Increment("appVariables:tries").setDebugId(7733));
					actions.add(new com.avaya.sce.runtime.Next("ComboPlans_MN", "(Repeat)").setDebugId(7734));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}


			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:tries", "constants:One", false).setDebugId(7948));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

				if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "ComboPlans_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:GPMR_MainMenu", true).setDebugId(7737)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Mainmenu_MN", "(Main Menu)").setDebugId(7738));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "ComboPlans_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:GPMR_PreviousMenu", true).setDebugId(7739)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("Offers_MN", "(Previous Menu)").setDebugId(7740));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "ComboPlans_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:ComboPlansMenu_RetVal_549", true).setDebugId(7741)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("SetComboPlanDetails", "(549)").setDebugId(7742));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "ComboPlans_MN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constants:ComboPlansMenu_RetVal_699", true).setDebugId(7743)).evaluate(mySession)) {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("SetComboPlanDetails", "(699)").setDebugId(7744));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;

				} else {
					actions = new java.util.ArrayList(1);
					actions.add(new com.avaya.sce.runtime.Next("SetComboPlanDetails", "(999)").setDebugId(7746));
					if(evaluateActions(actions, mySession)) {
						return true;
					}
					actions = null;
				}

			}


		} else {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TransferCodes:DAKC_TR_0036", false).setDebugId(7757));
			actions.add(new com.avaya.sce.runtime.Next("Check_SRC", "(Tries Exceeded)").setDebugId(7756));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
