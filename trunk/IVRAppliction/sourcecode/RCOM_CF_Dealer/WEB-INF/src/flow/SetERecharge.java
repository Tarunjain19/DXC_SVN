package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.util.AppConstant;
import com.rcom.util.DynamicMenu;
import com.rcom.util.StackTrace;
import com.servion.util.AppProperties;
import com.rcom.util.Utilities;

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
 * Last generated by Orchestration Designer at: 2015-SEP-24  03:57:09 PM
 */
public class SetERecharge extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-SEP-24  03:57:09 PM
	 */
	public SetERecharge() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:28 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("AccountBalance_PP", "Default");
		next.setDebugId(3824);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:28 AM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-24  10:30:28 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		ITraceInfo trace = mySession.getTraceOutput();
		String key = null,getAmt = null,appName = null,initialPrompt = null;
		ArrayList<String> dynamicList = new ArrayList<>();
		
		try
		{	/** Forming the Dynamic Prompt **/
			appName = mySession.getVariable(IProjectVariables.APPNAME).getSimpleVariable().getStringValue();
			getAmt = mySession.getVariableField(IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY,IProjectVariables.MAIN_ACCOUNT_BALANCE_AND_VALIDITY_FIELD_BAL).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Amount Before adjusting : "+getAmt);
			getAmt =Utilities.adjust2Decimal(getAmt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Amount After adjusting : "+getAmt);
			key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.RCD_PA_0010;
			initialPrompt = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
			dynamicList.add(getAmt + AppConstant.currency);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Dynamic Prompt Key "+AppConstant.RCD_PA_0010+" :: "+key);
			
			/** Invoking the playPromt method **/
			DynamicMenu dynamicMenu = new DynamicMenu();
			initialPrompt = DynamicMenu.playPrompt(dynamicList, initialPrompt, AppConstant.NA,trace);
			mySession.getVariableField(IProjectVariables.DM__INPUT_PATH, IProjectVariables.DM__INPUT_PATH_FIELD_DM__INITIAL_PROMPT).setValue(initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Confirmation Initial Prompt "+AppConstant.RCD_PA_0010+" :: "+initialPrompt);
		
			}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION).setValue(AppConstant.Yes);
		StackTrace.PrintException(e);}
		finally
		{initialPrompt = null;getAmt = null;appName=null;key=null;}
	}
}
