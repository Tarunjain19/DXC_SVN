package flow;

import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.SCESession;
import com.rcom.broadband.Constants;
import com.rcom.broadband.StackTrace;
import com.servion.util.AppProperties;

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
 * Last generated by Orchestration Designer at: 2015-MAY-28  07:15:50 PM
 */
public class SetToggleMenu extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAY-28  07:15:50 PM
	 */
	public SetToggleMenu() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
	
		try
		{
			
			AppProperties ivrProperties = AppProperties.GetInstance(Constants.IVR_CONFIG);
			ITraceInfo trace = mySession.getTraceOutput();
			
			String dmPropertiesLocation = null;
			String language = null;
			
			String keyToGetLanguageOptions = null;
			String initialPrompt = null;
			String dtmfGrammar = null;
			
			String circle = mySession.getVariableField(IProjectVariables.APP_VARIABLES, IProjectVariables.APP_VARIABLES_FIELD_CIRCLE).getStringValue();
			String selectedLang = mySession.getCurrentLanguage();
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Already selected language : " +selectedLang);
			
			if(selectedLang.equalsIgnoreCase(ivrProperties.getIVRProp(Constants.LANGUAGE_ENGLISH)))
			{
				
				keyToGetLanguageOptions = circle + Constants.UNDERSCORE + selectedLang + Constants.UNDERSCORE + Constants.CHANGE_LANG_INITIAL_PROMPTS;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Key to get Language Options : " +keyToGetLanguageOptions);
				initialPrompt = ivrProperties.getIVRProp(keyToGetLanguageOptions);
				dtmfGrammar = ivrProperties.getIVRProp(Constants.REGIONAL_HINDI_GRXML);
				
			}
			else if(selectedLang.equalsIgnoreCase(ivrProperties.getIVRProp(Constants.LANGUAGE_HINDI)))
			{
				keyToGetLanguageOptions = circle + Constants.UNDERSCORE + selectedLang + Constants.UNDERSCORE + Constants.CHANGE_LANG_INITIAL_PROMPTS;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Key to get Language Options : " +keyToGetLanguageOptions);
				initialPrompt = ivrProperties.getIVRProp(keyToGetLanguageOptions);
				dtmfGrammar = ivrProperties.getIVRProp(Constants.REGIONAL_ENGLISH_GRXML);
			}
			else
			{
				keyToGetLanguageOptions = Constants.CHANGE_LANG_INITIAL_PROMPTS;
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "Key to get Language Options : " +keyToGetLanguageOptions);
				initialPrompt = ivrProperties.getIVRProp(keyToGetLanguageOptions);
				dtmfGrammar = ivrProperties.getIVRProp(Constants.HINDI_ENGLISH_GRXML);
				
			}
			
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__RE_PROMPT_NO_INPUT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__RE_PROMPT_NO_MATCH).setValue(initialPrompt);
			//mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__NO_INPUT_PROMPT).setValue(initialPrompt);
			//mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__NO_MATCH_PROMPT).setValue(initialPrompt);
			mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__DTMF_GRAMMAR).setValue(dtmfGrammar);
			//mySession.getVariableField(IProjectVariables.DM__INPUT, IProjectVariables.DM__INPUT_FIELD_DM__CUSTOM_AUDIO_LOCATION).setValue(ivrProperties.getIVRProp(Constants.COMMON_PROMPTS_LOCATION));
			
			
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM__INPUT_FIELD_DM__INITIAL_PROMPT : " +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM__INPUT_FIELD_DM__RE_PROMPT_NO_INPUT : " +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM__INPUT_FIELD_DM__RE_PROMPT_NO_MATCH : " +initialPrompt);
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM__INPUT_FIELD_DM__DTMF_GRAMMAR : " +dtmfGrammar);
			//trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG, "DM__INPUT_FIELD_DM__CUSTOM_AUDIO_LOCATION : " +ivrProperties.getIVRProp(Constants.COMMON_PROMPTS_LOCATION));
		}catch(Exception e) {
			StackTrace.PrintException(e);
		}
		
	}
	
	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("ToggleLang_MN", "Default");
		next.setDebugId(8545);
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
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
	 * Last generated by Orchestration Designer at: 2016-SEP-28  04:13:56 PM
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
}
