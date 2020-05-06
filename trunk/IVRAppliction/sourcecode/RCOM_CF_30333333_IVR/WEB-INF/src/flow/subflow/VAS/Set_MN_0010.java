package flow.subflow.VAS;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.DynamicMenu;
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
 * Last generated by Orchestration Designer at: 2015-APR-08  10:31:48 PM
 */
public class Set_MN_0010 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-08  10:31:48 PM
	 */
	public Set_MN_0010() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:07 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("VAS-MN_0010", "Default");
		next.setDebugId(387);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:07 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-05  10:39:07 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "dmInputParameter:initialPrompt", com.avaya.sce.runtime.Expression.IS_EMPTY).setDebugId(385)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("VAS-VAS_Linkdown", "linkdown").setDebugId(386));
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
		ITraceInfo trace = mySession.getTraceOutput();
		String key = AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING;

		ArrayList<String> offerPhrase = null;
		String initialPrompt = null;
		String offerID =AppConstant.EMPTY_STRING;
		String offerCount = AppConstant.EMPTY_STRING;
		//initial prompt processing...
		try
		{
			appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Application Name :: "+appName);
			
			key = appName +AppConstant.SEPERATOR_HYPEN+ AppConstant.MN_0013;
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "Key :: "+key);
			initialPrompt = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "VAS initial Prompt Before Dynamic Insertion:: "+initialPrompt);
			
			offerPhrase = (ArrayList<String>) mySession.getProperty(AppConstant.OFFER_PHRASE);
			offerID = (String) mySession.getProperty(AppConstant.OFFERCODES);
			offerCount = AppConstant.EMPTY_STRING+mySession.getProperty(AppConstant.OFFER_COUNT);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "offerPhrase ::"+offerPhrase);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "offerID ::"+offerID);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "offerCount ::"+offerCount);
			
			DynamicMenu objDynamicMenu = new DynamicMenu();
			initialPrompt=DynamicMenu.playPrompt(offerPhrase, initialPrompt, ""+offerPhrase.size(), AppConstant.MN_0013, trace);
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "VAS initial Prompt :: "+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_INFO, "VAS Selection Grammar :: "+offerID);
			
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(offerID);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER, IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(offerCount);
			
			
		}
		catch(Exception e)
		{
			StackTrace.PrintException(e);
			trace.writeln(ITraceInfo.TRACE_LEVEL_ERROR, "Exception in VAS initial prompt :: "+e);
		}
		finally
		{
				initialPrompt = null;
		}
		
	}
}
