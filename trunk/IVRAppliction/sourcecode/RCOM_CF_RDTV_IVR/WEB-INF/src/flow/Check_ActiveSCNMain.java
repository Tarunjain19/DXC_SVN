package flow;

import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;

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
 * Last generated by Orchestration Designer at: 2015-MAY-28  11:46:59 AM
 */
public class Check_ActiveSCNMain extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-28  11:46:59 AM
	 */
	public Check_ActiveSCNMain() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:45:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(4);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "ActiveSCN_MainMN:NomatchRemaining", false).setDebugId(9658));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "ActiveSCN Menu value", "ActiveSCN_MainMN:Value").setDebugId(8542));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ActiveSCN_MainMenu ReturnCode :: ", "ActiveSCN_MainMN:ReturnCode").setDebugId(1110));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "ActiveSCN_MainMN:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(1109)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "ActiveSCN_MainMenu Value :: ", "ActiveSCN_MainMN:Value").setDebugId(1111));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "ActiveSCN_MainMN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:AccountInfo", true).setDebugId(1112)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Account_HotFlash", "account-info").setDebugId(1113));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "ActiveSCN_MainMN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:RegisterCompliant", true).setDebugId(1114)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Register_Complaint", "register-complaint").setDebugId(1115));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "ActiveSCN_MainMN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:PackInfo", true).setDebugId(1116)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("PackInfo_MN", "pack-info").setDebugId(1117));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "ActiveSCN_MainMN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:RetailerAndISP", true).setDebugId(1118)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:IsRetailerISPNode", "T", true).setDebugId(9352));
				actions.add(new com.avaya.sce.runtime.Next("Retail_And_ISP", "retailer-ISP").setDebugId(1119));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "ActiveSCN_MainMN:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:transfer", true).setDebugId(8533)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(8534));
				actions.add(new com.avaya.sce.runtime.Next("Transfer_Annc", "agent-Txfr").setDebugId(8535));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("ChangeLanguage", "change-language").setDebugId(1121));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Tries_ExceedAnncom", "tries-exceed").setDebugId(1123));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		
		if(mySession.getVariableField(IProjectVariables.ACTIVE_SCN__MAIN_MN, IProjectVariables.ACTIVE_SCN__MAIN_MN_FIELD_RETURN_CODE).getStringValue().equalsIgnoreCase(AppConstants.Success))
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME).setValue(mySession.getVariableField(IProjectVariables.PROPERTY_FILE_NAME, IProjectVariables.PROPERTY_FILE_NAME_FIELD_GLOBAL__NORMAL).getStringValue());
		
	}
}
