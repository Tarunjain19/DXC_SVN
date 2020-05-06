package flow;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.servion.util.AppConstant;
import com.servion.util.AppProperties;
import com.servion.util.DynamicMenu;

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
 * Last generated by Orchestration Designer at: 2015-MAR-12  03:58:47 PM
 */
public class GetLanguageConfirmProperties extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-12  03:58:47 PM
	 */
	public GetLanguageConfirmProperties() {
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
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("LanguageConfirm");
		next.setDebugId(907);
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

		/** Declaration **/
		String initialPrompt = AppConstant.EMPTY_STRING,key = AppConstant.EMPTY_STRING,selectedLanguageCode= AppConstant.EMPTY_STRING;
		String dynamicWaves =  AppConstant.EMPTY_STRING,appName = AppConstant.EMPTY_STRING,selectedLanguage = AppConstant.EMPTY_STRING;
		ArrayList<String> arrLanguage = null;
		ITraceInfo trace =null;
		
		/**Assign**/
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP_NAME).getStringValue();
		key = appName+AppConstant.SEPERATOR_HYPEN+AppConstant.MN_0002;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Confirmation Language initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(AppConstant.DYN_MENU).getIVRProp(key);
		arrLanguage = new ArrayList<>();
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Confirmation Language initial Prompt :"+dynamicWaves);
		
		/** Form Dynamic Initial Prompt**/
		selectedLanguage = mySession.getVariableField(IProjectVariables.LANGUAGE_MENU,IProjectVariables.LANGUAGE_MENU_FIELD_VALUE).getStringValue();
		
		/*key = AppConstant.Language_Code+selectedLanguageCode;
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language_Code Key:"+key);
		selectedLanguage=(String) AppDataMap.getInstance(appName).getAppData(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Selected Language :"+selectedLanguage);*/
		
		if(selectedLanguage!=null && !AppConstant.EMPTY_STRING.equalsIgnoreCase(selectedLanguage)){
			arrLanguage.add(selectedLanguage+AppConstant.wave);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Dynamic wave File :"+arrLanguage.get(0));
		}
			
			
		/** Form Initial Prompt**/
		DynamicMenu objDynamicMenu = new DynamicMenu();
		initialPrompt=objDynamicMenu.playPrompt(arrLanguage, dynamicWaves, AppConstant.NA, trace);
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
		mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
		
		}
		
	
}
