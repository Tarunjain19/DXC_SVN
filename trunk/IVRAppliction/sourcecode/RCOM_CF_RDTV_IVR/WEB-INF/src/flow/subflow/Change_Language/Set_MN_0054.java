package flow.subflow.Change_Language;

import java.util.ArrayList;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;
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
 * Last generated by Orchestration Designer at: 2015-JUN-16  08:40:29 PM
 */
public class Set_MN_0054 extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-16  08:40:29 PM
	 */
	public Set_MN_0054() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:02 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("Change_Language-Language_Menu", "Default");
		next.setDebugId(7);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:02 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:02 PM
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
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Change Language Menu Inital Prompt Start");
		LanguageSelectionMenu(mySession);
	}
	
public void LanguageSelectionMenu (SCESession mySession){
		
		/** Declaration **/
		String initialPrompt = AppConstants.EMPTY_STRING,grammarValue = AppConstants.EMPTY_STRING,circleLangCode = AppConstants.EMPTY_STRING,menuOption=AppConstants.EMPTY_STRING;
		String dynamicWaves =  AppConstants.EMPTY_STRING,appName = AppConstants.EMPTY_STRING,key = AppConstants.EMPTY_STRING,circleLanguage = AppConstants.EMPTY_STRING,langKey = AppConstants.EMPTY_STRING;
		String[] arrayLangCode = null;
		ArrayList<String> arrLanguage=null;
		ITraceInfo trace =null;
		
		try
		{
		/**Assign**/
		trace = mySession.getTraceOutput();
		appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
		key = appName+AppConstants.SEPERATOR_HYPEN+AppConstants.RD01_MN_0054;
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"application Name :"+appName);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt Key :"+key);
		
		dynamicWaves = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(key);
		trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language initial Prompt :"+dynamicWaves);
		arrLanguage = new ArrayList<>();
		/** Form Dynamic Initial Prompt**/
		circleLangCode = mySession.getVariableField(IProjectVariables.APP_VARIABLES,IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE_LIST).getStringValue();
		
		if(circleLangCode!=null){
			arrayLangCode = circleLangCode.split(AppConstants.SEPERATOR_COMMA);
			
			for(int i = 0;i<arrayLangCode.length;i++){
				/*key = AppConstant.Language_Code+arrayLangCode[i];
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Language_Code Key:"+key);*/
				if(!arrayLangCode[i].equalsIgnoreCase(mySession.getCurrentLanguage()))
				{
					circleLanguage=arrayLangCode[i];
					menuOption = menuOption+circleLanguage+AppConstants.SEPERATOR_COMMA;
					arrLanguage.add(circleLanguage+AppConstants.wave);
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Circle Language : "+i+" :"+circleLanguage);
				}
				/*langKey = AppConstants.LANG_+i;
				dynamicWaves = dynamicWaves.replaceAll(langKey,circleLanguage);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Dynamic Wave :" +dynamicWaves);*/
				
			}
			
			/** Form Initial Prompt**/
			String count = String.valueOf(arrLanguage.size());
			initialPrompt = DynamicMenu.playPrompt(arrLanguage, dynamicWaves, count, AppConstants.RD01_MN_0054, trace);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Initial Prompt ::"+initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Menu Option : "+menuOption);
			
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT).setValue(count);
			mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_MENU_OPTION).setValue(menuOption);
			
		}
		}
		catch (Exception e) {
			mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_IS_HOST_FAILURE).setValue(AppConstants.Yes);
			StackTrace.PrintException(e);
		}
		
		finally
		{arrayLangCode = null;arrLanguage = null;trace = null;dynamicWaves =  null;appName = null;key =  null;circleLanguage =  null;langKey =  null;}
}
}
