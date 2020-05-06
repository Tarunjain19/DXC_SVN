package flow.subflow.Change_Language;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.rdtv.util.AppConstants;
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
 * Last generated by Orchestration Designer at: 2015-JUN-16  08:43:42 PM
 */
public class Check_Change_LangMenu extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-JUN-16  08:43:42 PM
	 */
	public Check_Change_LangMenu() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:03 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:03 PM
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
	 * Last generated by Orchestration Designer at: 2017-MAR-03  03:46:03 PM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(3);
		actions.add(new com.avaya.sce.runtime.varoperations.Assign("Global_Counter:Max_NoMatch", "Language_Menu:NomatchRemaining", false).setDebugId(632));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "RD01_MN_0054 ReturnCode :: ", "Language_Menu:ReturnCode").setDebugId(149));
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "Language_Menu:ReturnCode", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "CONSTANTS:SUCCESS", true).setDebugId(150)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "RD01_MN_0054 Value :: ", "Language_Menu:Value").setDebugId(151));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

			if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "Language_Menu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:agent", true).setDebugId(615)).evaluate(mySession)) {
				actions = new java.util.ArrayList(2);
				actions.add(new com.avaya.sce.runtime.varoperations.Assign("AppVariables:TransferPoint", "TransferPoints:RD01_TR_0045", false).setDebugId(628));
				actions.add(new com.avaya.sce.runtime.Next("Change_Language-agent", "agent").setDebugId(616));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "Language_Menu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:MainMenu", true).setDebugId(617)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Change_Language-main_menu", "mainmenu").setDebugId(618));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "Language_Menu:Value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "dmGrammarValues:previous", true).setDebugId(619)).evaluate(mySession)) {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Change_Language-previous", "previous").setDebugId(620));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;

			} else {
				actions = new java.util.ArrayList(1);
				actions.add(new com.avaya.sce.runtime.Next("Change_Language-Access_RCOM_DB_Set_Preffered_Lang", "next").setDebugId(152));
				if(evaluateActions(actions, mySession)) {
					return true;
				}
				actions = null;
			}


		} else {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("Change_Language-trie_exceed", "exceeded").setDebugId(154));
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
		
		/**Declaration **/
		String returnCode = AppConstants.EMPTY_STRING;
		String selectedLang = AppConstants.EMPTY_STRING,key = AppConstants.EMPTY_STRING;
		String appName = AppConstants.EMPTY_STRING,propetyKey = AppConstants.EMPTY_STRING;
		String propertiesLocation = AppConstants.EMPTY_STRING;
		ITraceInfo trace = null;
		
		/**Assign **/
		selectedLang = mySession.getVariableField(IProjectVariables.LANGUAGE__MENU,IProjectVariables.LANGUAGE__MENU_FIELD_VALUE).getStringValue();
		returnCode = mySession.getVariableField(IProjectVariables.LANGUAGE__MENU,IProjectVariables.LANGUAGE__MENU_FIELD_RETURN_CODE).getStringValue();
		appName = mySession.getVariableField(IProjectVariables.APP__NAME).getStringValue();
		trace = mySession.getTraceOutput();
		mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_PREVIOUS_LANGUAGE).setValue(mySession.getCurrentLanguage());
		
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"LANGUAGE_MENU Return Code :"+returnCode);
		trace.writeln(ITraceInfo.TRACE_LEVEL_INFO,"LANGUAGE_MENU Return Value :"+selectedLang);
		
		/***Getting Property File for selected Language***/
		if(AppConstants.Success.equalsIgnoreCase(returnCode)){
			
			if(!selectedLang.equalsIgnoreCase(AppConstants.Agent)&&!selectedLang.equalsIgnoreCase(AppConstants.MainMenu)&&!selectedLang.equalsIgnoreCase(AppConstants.Previous))
			{
			if(selectedLang!=null && !AppConstants.EMPTY_STRING.equals(selectedLang)){
				mySession.setCurrentLanguage(selectedLang);
				propetyKey = AppConstants.PROPERTY+appName+AppConstants.SEPERATOR_UNDERSCORE+selectedLang;
				
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"property Key :"+propetyKey);
				propertiesLocation = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(propetyKey);
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location :"+propertiesLocation);
				
				if(propertiesLocation!=null && !AppConstants.N.equalsIgnoreCase(propertiesLocation))
					mySession.getVariableField(IProjectVariables.DM_INPUT_PARAMETER,IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION).setValue(propertiesLocation);
				else{
					trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"properties Location is Null");
					
				}
			}}
			
		}
	}
}
