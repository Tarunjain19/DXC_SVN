package flow.subflow.Intelligent;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.StackTrace;

import flow.IProjectVariables;

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
 * Last generated by Orchestration Designer at: 2016-SEP-29  03:36:07 PM
 */
public class Check_ILInteractionHistory extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-SEP-29  03:36:07 PM
	 */
	public Check_ILInteractionHistory() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-29  03:09:24 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(2);
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_INFO, "CRM History Next Node :", "Flag:CRMHistoryFlag").setDebugId(629));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Flag:CRMHistoryFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Main_Account_Bal", true).setDebugId(631)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-Account_Information", "Main_Account_Bal").setDebugId(632));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag:CRMHistoryFlag", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:Data_Balance", true).setDebugId(633)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-Account_Information", "Data_Balance").setDebugId(634));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Intelligent-DB_TariffDetails", "MDN Look UP").setDebugId(636));
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
		
		String strCategory1Count =  AppConstant.EMPTY_STRING,strCategory2Count =  AppConstant.EMPTY_STRING;
		String strCategory3Count =  AppConstant.EMPTY_STRING,strCategory4Count =  AppConstant.EMPTY_STRING;
		String nextNode			 =  AppConstant.EMPTY_STRING;
		ITraceInfo trace		 =  mySession.getTraceOutput();
		String strTraversalCount = AppConstant.zero,strILInteractionHistory = AppConstant.EMPTY_STRING;
		try{
			strCategory1Count    = mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_1).getStringValue();
			strCategory2Count    = mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_2).getStringValue();
			strCategory3Count    = mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_3).getStringValue();
			strCategory4Count    = mySession.getVariableField(IProjectVariables.ILINTERACTION_HISTORY_COUNT,IProjectVariables.ILINTERACTION_HISTORY_COUNT_FIELD_CATEGORY_4).getStringValue();
			strTraversalCount	 = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_ILTRAVERSL_COUNT).getStringValue();
			strILInteractionHistory = mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_COPY_FIELD_CRMHISTORY_FLAG).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"strCategory1Count "+strCategory1Count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"strCategory2Count "+strCategory2Count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"strCategory3Count "+strCategory3Count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"strCategory4Count "+strCategory4Count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Before If");
		if(strCategory1Count!=null && strCategory2Count!=null && strCategory3Count!=null && strCategory4Count!=null){
			int intCategory1Count = Integer.parseInt(strCategory1Count);
			int intCategory2Count = Integer.parseInt(strCategory2Count);
			int intCategory3Count = Integer.parseInt(strCategory3Count);
			int intCategory4Count = Integer.parseInt(strCategory4Count);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Inside If");
			
			if(intCategory1Count>2&&!strILInteractionHistory.equalsIgnoreCase(AppConstant.Main_Account_Bal)){
				nextNode = AppConstant.Main_Account_Bal;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category1Count > 2");
			}else if(intCategory2Count>2&&!strILInteractionHistory.equalsIgnoreCase(AppConstant.Main_Account_Bal)){
				nextNode = AppConstant.Main_Account_Bal;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category2Count > 2");
			} else if(intCategory3Count>2&&!strILInteractionHistory.equalsIgnoreCase(AppConstant.Data_Balance)){
				nextNode = AppConstant.Data_Balance;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category3Count > 2");
			} else if(intCategory4Count>2&&!strILInteractionHistory.equalsIgnoreCase(AppConstant.Data_Balance)){
				nextNode = AppConstant.Data_Balance;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category4Count > 2");
			} else {
				nextNode = AppConstant.MDN_LookUp;
				trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Category complete Else");
			}
		}else {
			nextNode = AppConstant.MDN_LookUp;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Count Should never be null");
		}
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"Next Node ID :"+nextNode);
		mySession.getVariableField(IProjectVariables.FLAG,IProjectVariables.FLAG_FIELD_CRMHISTORY_FLAG).setValue(nextNode);
		
		}catch(Exception e){
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Error in CRM Count Info :" +e);
			StackTrace.PrintException(e);
		}
	}
	
	
}
