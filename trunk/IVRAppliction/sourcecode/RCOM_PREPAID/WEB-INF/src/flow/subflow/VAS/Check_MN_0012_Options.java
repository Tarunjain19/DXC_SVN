package flow.subflow.VAS;

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
 * Last generated by Orchestration Designer at: 2015-APR-08  10:30:29 PM
 */
public class Check_MN_0012_Options extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-08  10:30:29 PM
	 */
	public Check_MN_0012_Options() {
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

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MN_0012 ReturnCode : : ", "MN_0012:ReturnCode").setDebugId(4972));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "MN_0012:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(4104)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "MN_0012 Value : : ", "MN_0012:Value").setDebugId(4973));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:InternetSettings", true).setDebugId(4105)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("VAS-executeGPRSSettingsDownload", "Get_GPRS_Settings").setDebugId(4106));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "DataBalance", false).setDebugId(5662)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:databalance", "true", true).setDebugId(5674));
				actions.add(new com.avaya.sce.runtime.Next("VAS-DataBalance", "DataBalance").setDebugId(5665));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "DeductionQueries", false).setDebugId(5663)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0088", true).setDebugId(5668));
				actions.add(new com.avaya.sce.runtime.Next("VAS-AgentTransfer", "DeductionQueries").setDebugId(5666));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "InternetPlans", false).setDebugId(5664)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0088", true).setDebugId(5669));
				actions.add(new com.avaya.sce.runtime.Next("VAS-AgentTransfer", "InternetPlans").setDebugId(5667));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:TransferAgent", true).setDebugId(4889)).evaluate(mySession)) {
				actions = new java.util.ArrayList(3);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:GizmoFlag", "constant:Key_true", false).setDebugId(5646));
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0005", true).setDebugId(5626));
				actions.add(new com.avaya.sce.runtime.Next("VAS-AgentTransfer", "TransferAgent").setDebugId(4890));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:previous", true).setDebugId(4881)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("VAS-MN_0008_Inet_VAS_MM", "PreviousMenu").setDebugId(4882));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:MainMenu", true).setDebugId(4886)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("VAS-MainMenu", "MainMenu").setDebugId(4887));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "MN_0012:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:agent", true).setDebugId(5024)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0088", true).setDebugId(5611));
				actions.add(new com.avaya.sce.runtime.Next("VAS-AgentTransfer", "Agent").setDebugId(5025));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			}

		} else {
			actions = new java.util.ArrayList(3);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("appVariables:transferCode", "TR_0025", true).setDebugId(5612));
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("Flag:NIFlag", "MN_0012:ReturnCode", false).setDebugId(5710));
			actions.add(new com.avaya.sce.runtime.Next("VAS-AgentTransfer", "Agent").setDebugId(4109));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
