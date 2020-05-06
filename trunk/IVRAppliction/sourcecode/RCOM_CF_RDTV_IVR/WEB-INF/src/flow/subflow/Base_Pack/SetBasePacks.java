package flow.subflow.Base_Pack;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.otherflows.model.BasePacks;
import com.rcom.rdtv.util.AppConstants;
import com.rcom.rdtv.util.AppDataMap;
import com.rcom.rdtv.util.DynamicMenu;
import com.rcom.rdtv.util.StackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-JUN-30  11:02:33 PM
 */
public class SetBasePacks extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-30  11:02:33 PM
	 */
	public SetBasePacks() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:05 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:05 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:05 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "AppVariables:IsHostFailure", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:YES", true).setDebugId(648)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0050", false).setDebugId(649));
			actions.add(new com.avaya.sce.runtime.Next("Base_Pack-link_down", "linkdown").setDebugId(650));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Base_Pack-BasePack_MN", "next").setDebugId(652));
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
		ITraceInfo trace = null;
		String key=null,appName = null,circleID = null,langId = null,initialPrompt = null,dynamicWaves = null,menuOption = AppConstants.EMPTY_STRING;
		Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, BasePacks>>>> basePacksList = null;
		Hashtable<String, Hashtable<String, Hashtable<String, BasePacks>>> circlePackInfo = null;
		Hashtable<String, Hashtable<String, BasePacks>> langPackInfo = null;
		Hashtable<String, BasePacks> basePackInfo = null;
		BasePacks basePacks = null;
		ArrayList<String> arrPacks=null;Set<String> basePackKey = null;
		Set<String> baseSubKey = null;
		try
		{
			trace = mySession.getTraceOutput();
			appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
			circleID = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE_ID).getStringValue();
			langId = mySession.getCurrentLanguage();
			
			/** Formating the Request **/
			key = AppConstants.BASEPACKS_KEY+appName;
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " BasePacks KEY:: "+key);
			basePacksList = (Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, BasePacks>>>>) AppDataMap.getInstance(appName).getAppData(key);
			
			if(basePacksList != null)
			{
				circlePackInfo = basePacksList.get(circleID);
				langPackInfo = circlePackInfo.get(langId);
				basePackKey = langPackInfo.keySet();
				
				arrPacks = new ArrayList<>();
				for (String baseKeys : basePackKey) {
					basePackInfo = langPackInfo.get(baseKeys);
					baseSubKey = basePackInfo.keySet();
					for (String baseSubs : baseSubKey) 
						basePacks = basePackInfo.get(baseSubs);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " BasePacks From DB :: "+baseKeys+" :: "+basePacks.toString());
					arrPacks.add(basePacks.getMainPackDetailPhrase());
					menuOption = menuOption+basePacks.getPackOptionID()+AppConstants.SEPERATOR_COMMA;
					}
				
				/** Form Initial Prompt**/
				String count = String.valueOf(arrPacks.size());
				dynamicWaves = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_MN_0042);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, " DynamicWaves from Property for "+AppConstants.RD01_MN_0042+" :: "+dynamicWaves);
				initialPrompt = DynamicMenu.playPrompt(arrPacks, dynamicWaves, count, AppConstants.RD01_MN_0042, trace);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option : "+menuOption);
				
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
				mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(menuOption);
			}
			else
				mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);	
			
		}catch(Exception e)
		{mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
		StackTrace.PrintException(e);
		}
		finally
		{trace=null;arrPacks=null;baseSubKey=null;basePacks=null;basePackKey=null;langPackInfo=null;basePacks=null;circlePackInfo=null;basePacksList=null;key=null;appName = null;circleID = null;langId = null;initialPrompt = null;dynamicWaves = null;menuOption = null;}
		}
}