package flow.subflow.Prepaid_BuyThePack;

/**
 * Class that represents a call to a reusable application.
 * Last generated by Orchestration Designer at: 2015-MAR-11  06:03:11 PM
 */
public class Tries_ExceededMonth extends com.avaya.sce.runtime.Invoke {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-11  06:03:11 PM
	 */
	public Tries_ExceededMonth() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		setNeedsDefaultDisconnectHandler(false);
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns a collection of Parameters that has information about the
	 * parameters to pass to the reusable module.  If it has
	 * no inputs, then an empty list is returned
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public java.util.Collection getInputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Parameter param = null;
		list = new java.util.ArrayList(114);

		param = new com.avaya.sce.runtime.Parameter("input_propertiesLocation", "DMProperties:configFilePath", com.avaya.sce.runtime.Parameter.VARIABLE);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_globalPropertyFileName", "DMProperties:globalGeneral", com.avaya.sce.runtime.Parameter.VARIABLE);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_propertyFileName", "Prepaid_propertyFileName:Month_Exceed", com.avaya.sce.runtime.Parameter.VARIABLE);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_language", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_isDTMF", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_customAudioLocation", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_standardAudioLocation", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_grammarLocation", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_isAnnouncement", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_specificSlots", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_initialPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_maxNoMatchCount", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_maxNoInputCount", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noMatchPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_builtInGrammarFlag", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_builtInGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noInputPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noInputMaxTryPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noMatchMaxTryPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_helpPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_successPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dtmfGlobalGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dtmfGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_voiceGlobalGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_voiceGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationMaxCount", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationInitialPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationMaxTryPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationNoInputPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationNoMatchPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationReprompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationSpecificPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationDeniedMaxCount", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationDeniedApologyRandom", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationDeniedApology", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationDeniedMaxTryPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationDtmfGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationVoiceGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_rePromptNoInput", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_rePromptNoMatch", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_Number", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_NumberValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_Digits", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_DigitsValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_Date", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_DateValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_Time", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_TimeValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_Currency", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ss_CurrencyValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Number", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_NumberValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Digits", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_DigitsValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Date", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_DateValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Time", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_TimeValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Currency", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_CurrencyValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Name", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_NameValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Telephone", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_TelephoneValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_Address", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_tts_AddressValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_nbest", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_disallowList", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_menuOptions", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionFlag", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionCount", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionPreviousMenuFlag", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionDTMFGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionVoiceGrammar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_moreOptionDynamicValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dynamicConstraintListValues", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dynamicConstraintListFlag", "false", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dynamicConstraintListCounterFlag", "false", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dynamicConstraintListCounter", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_dynamicConstraintListPrompts", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_oneTimeFlag", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_privateData", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_reEntry", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_menuID", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_AnnounceID", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_DialogName", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_ConfirmationMode", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_NINMCounter", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_LoggerName", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_LoggingEnabled", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_RepeatCounter", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_StaticConstraintList", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_SuccessPromptOnlyForConfirmation", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_DTMFGrammaruseSlots", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noMatchRandom", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_noInputRandom", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_CompleteTimeout", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_incompleteTimeout", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_interdigitTimeout", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_terminatingTimeout", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_initialTimeout", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_highConfidenceLevel", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_lowConfidenceLevel", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_bargeIn", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_manageRepeat", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_reportEnabled", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_terminatingChar", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_mediaTypeDTMF", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_mediaTypeVoice", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_BargeInType", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_confirmationValueFlag", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_globalPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_repeatPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		param = new com.avaya.sce.runtime.Parameter("input_repeatMaxTryPrompt", "DEFAULT", com.avaya.sce.runtime.Parameter.CONSTANT);
		list.add(param);

		return(list);
	}
	/**
	 * Returns a collection of strings that are the names of the output parameters
	 * of the reusable application being invoked.  If it has no outputs, then an
	 * empty list is returned
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public java.util.Collection getOutputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList(17);

		list.add("ReturnCode");
		list.add("Value");
		list.add("Utterance");
		list.add("Recorded_Utterance");
		list.add("OtherSlot");
		list.add("NomatchRemaining");
		list.add("NoinputRemaining");
		list.add("nBestValues");
		list.add("InputType");
		list.add("ConfirmationRemaining");
		list.add("Confidence");
		list.add("MenuID");
		list.add("MenuStartTime");
		list.add("MenuEndTime");
		list.add("SpecificSlot");
		list.add("AnnounceID");
		list.add("DialogName");

		return(list);
	}
	/**
	 * Returns the name of the next form in the application
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public String getNext() {
		return("Prepaid_BuyThePack-agent");
	}
	/**
	 * Returns the entry point URL to the application being invoked.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public String getWebAppEntryPoint(com.avaya.sce.runtimecommon.SCESession mySession) {
		String entryPoint = mySession.getParameter("module.DM.entrypoint");
		if (entryPoint != null)
			return checkEntryPoint(entryPoint, mySession);
		return(checkEntryPoint("DM/Start", mySession));
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the event handlers for the node, override:
	 *    void updateEvents(Collection events, SCESession mySession)
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 * @return a collection of Events
	 */
	public java.util.Collection getEvents(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list;
		com.avaya.sce.runtime.Event event;
		list = new java.util.ArrayList();
		java.util.List eventPromptNames = null;
		String ___tempPromptName = null;
		return(list);
	}
	/**
	 * Returns the submit method.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public String getSubmitMethod() {
		return("get");
	}
	/**
	 * Returns the flag to indicate whether to use namelist.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public boolean passParamsAsNameList() {
		return(false);
	}
	/**
	 * Returns the flag to indicate whether output data contains multipart.
	 * Last generated by Orchestration Designer at: 2015-OCT-27  02:07:58 PM
	 */
	public boolean outputMultipart() {
		return(false);
	}
}
