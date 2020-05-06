package flow.subflow.RGC_Flow;

import java.util.ArrayList;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.hpe.util.AppConstant;
import com.servion.util.AppProperties;
import com.hpe.util.DynamicMenu;
import com.hpe.util.StackTrace;

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
 * Last generated by Orchestration Designer at: 2016-JUN-07  11:15:53 AM
 */
public class DAT_Chk_PHNum extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2016-JUN-07  11:15:53 AM
	 */
	public DAT_Chk_PHNum() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

public void requestBegin(SCESession mySession) {
		
		try
		{
			ITraceInfo trace = mySession.getTraceOutput();
			
			AppProperties ivrProperties = AppProperties.GetInstance(AppConstant.DYN_MENU);
			String appName = null;
			String key = null;
			String initialPrompt = null;
			ArrayList<String> dynamicList = new ArrayList<String>();
			
			String getMobNoReturnCode = mySession.getVariableField(IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU, IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU_FIELD_RETURN_CODE).getStringValue();
			String getMobNoReturnValue = mySession.getVariableField(IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU, IProjectVariables.DM__GET_REGISTERED_PH_NUM__MENU_FIELD_VALUE).getStringValue();
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GET_Registered_PhNum_FIELD_RETURN_CODE : " +getMobNoReturnCode);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "GET_Registered_PhNum_FIELD_VALUE : " +getMobNoReturnValue);
			
			appName =  mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			
			if(getMobNoReturnCode.equalsIgnoreCase(AppConstant.Success))
			{
				key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.MN_0103;
				initialPrompt = ivrProperties.getIVRProp(key);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key : "+key);
				dynamicList.add(getMobNoReturnValue);
				
				/** Invoking the playPromt method **/
				initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstant.NA, AppConstant.MN_0103, trace);
				
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt :: "+initialPrompt);
			}
			
			
		}catch(Exception e)
		{
			mySession.getVariableField(IProjectVariables.FLAG__APPLICATION__ERROR).setValue(AppConstant.TRUE);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "ERROR in DAT_ChkPhNum :"+e, mySession);
			StackTrace.PrintException(e);
		}
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-JUN-25  02:40:38 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUN-25  02:40:38 PM
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
	 * Last generated by Orchestration Designer at: 2016-JUN-25  02:40:38 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "DM_GetRegisteredPhNum_Menu:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "constant:success", true).setDebugId(723)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-DM_ReConfirm_RegPhNumMenu", "ReConfirmMenu").setDebugId(724));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Flag_Application_Error", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "TRUE", false).setDebugId(725)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-TechDiffMsg", "Tech_Diff").setDebugId(726));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("RGC_Flow-DM_TriesExceeded_Msg", "(Exceeded)").setDebugId(728));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;
		}


		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
}
