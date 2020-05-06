package flow.subflow.ServiceManagement;

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
 * Last generated by Orchestration Designer at: 2015-MAY-25  09:24:24 PM
 */
public class Evaluate_MN_0015 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-25  09:24:24 PM
	 */
	public Evaluate_MN_0015() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:45 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:45 PM
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
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:45 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "GPRS_MN_0015:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:success", true).setDebugId(6217)).evaluate(mySession)) {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "GPRS_MN_0015:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Download", true).setDebugId(6218)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-AccessHost_DownloadGPRS", "Download").setDebugId(6219));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "GPRS_MN_0015:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Assitance", true).setDebugId(6220)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0011", true).setDebugId(6237));
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-Transfer", "Assitance").setDebugId(6221));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "GPRS_MN_0015:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Repeat", true).setDebugId(6222)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-GPRS_MN_0015", "Repeat").setDebugId(6223));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "GPRS_MN_0015:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:Previous", true).setDebugId(6224)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-ServMgmt_MN_0013", "Previous").setDebugId(6225));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "GPRS_MN_0015:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Grammars:MainMenu", true).setDebugId(6226)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-MainMenu", "MainMenu").setDebugId(6227));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-Transfer", "Transfer").setDebugId(6229));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "Flag:isFromIntelligentLayer", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "Constants:yes", true).setDebugId(6231)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-MainMenu", "NINM_MainMenu").setDebugId(6232));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("CallData:transferReasonCode", "TR_0088", true).setDebugId(6234));
				actions.add(new com.avaya.sce.runtime.Next("ServiceManagement-Transfer", "NINM_Transfer").setDebugId(6235));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}

		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
