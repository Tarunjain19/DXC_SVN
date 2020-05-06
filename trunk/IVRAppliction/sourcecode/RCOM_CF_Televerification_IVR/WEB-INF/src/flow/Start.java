package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 2015-APR-01  12:45:26 PM
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-APR-01  12:45:26 PM
	 */
	public Start() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * This method is generated automatically.  Any changes may be overwritten.
	 * Returns the submit object that will redirect application flow to the first
	 * form in the application.  This also adds various standard variables to the
	 * list of data to be submitted to the runtime variable table.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 * @return the Submit object that contains the standard variables and the first form
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = new com.avaya.sce.runtime.Submit("InitializeVariables");
		return ( submit );
	}
	/**
	 * This method initializes the SCE session with the variables that
	 * are defined in the application.<BR>
	 * 
	 * This method is generated automatically and should not be manually
	 * edited because changes may be overwritten by future code 
	 * generation.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variableFields = new String[] {
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_ANNOUNCE_ID,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_CONFIDENCE,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_DIALOG_NAME,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_INPUT_TYPE,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_MENU_END_TIME,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_MENU_ID,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_MENU_START_TIME,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_N_BEST_VALUES,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_OTHER_SLOT,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_RETURN_CODE,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_UTTERANCE,
			IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LINK_DOWN__TELV__PA___0_0_1_5, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_ANNOUNCE_ID,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_CONFIDENCE,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_DIALOG_NAME,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_INPUT_TYPE,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_MENU_END_TIME,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_MENU_ID,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_MENU_START_TIME,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_N_BEST_VALUES,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_OTHER_SLOT,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_RETURN_CODE,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_UTTERANCE,
			IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LANGUAGE__TELV__MN___0_0_0_6, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_ANNOUNCE_ID,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_CONFIDENCE,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_DIALOG_NAME,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_INPUT_TYPE,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_MENU_END_TIME,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_MENU_ID,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_MENU_START_TIME,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_N_BEST_VALUES,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_NOINPUT_REMAINING,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_NOMATCH_REMAINING,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_OTHER_SLOT,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_RETURN_CODE,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_SPECIFIC_SLOT,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_UTTERANCE,
			IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.INVALID_NUMBER__TELV__PA___0_0_0_6, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.TRANSFER, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REDIRECTINFO_FIELD_PRESENTATIONINFO,
			IProjectVariables.REDIRECTINFO_FIELD_REASON,
			IProjectVariables.REDIRECTINFO_FIELD_SCREENINGINFO,
			IProjectVariables.REDIRECTINFO_FIELD_URI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REDIRECTINFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_ANNOUNCE_ID,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_CONFIDENCE,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_DIALOG_NAME,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_INPUT_TYPE,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_MENU_END_TIME,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_MENU_ID,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_MENU_START_TIME,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_N_BEST_VALUES,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_NOINPUT_REMAINING,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_NOMATCH_REMAINING,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_OTHER_SLOT,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_RETURN_CODE,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_SPECIFIC_SLOT,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_UTTERANCE,
			IProjectVariables.THANKYOU__TELV__PA___0_0_0_7_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.THANKYOU__TELV__PA___0_0_0_7, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.WELCOME__TELV__PA___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.WELCOME__TELV__PA___0_0_0_1, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRIES_EXCEEDED__TELV__PA___0_0_0_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.MAIN_MENU__TELV__MN___0_0_0_1, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CALLER_TYPE_FLAG, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME,
			IProjectVariables.CALL_DATA_FIELD_CIRCLE,
			IProjectVariables.CALL_DATA_FIELD_DATA_CARD_RETRY,
			IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE,
			IProjectVariables.CALL_DATA_FIELD_IS_DATA_CARD,
			IProjectVariables.CALL_DATA_FIELD_IS_LINK_DOWN,
			IProjectVariables.CALL_DATA_FIELD_IS_VALID_NUMBER,
			IProjectVariables.CALL_DATA_FIELD_MOBILE_NUMBER_RETRY,
			IProjectVariables.CALL_DATA_FIELD_REGINAL_LANGUAGE,
			IProjectVariables.CALL_DATA_FIELD_TRANSFER_REASON_CODE,
			IProjectVariables.CALL_DATA_FIELD_TRANSFER_VDN,
			IProjectVariables.CALL_DATA_FIELD_UUI_DATA,
			IProjectVariables.CALL_DATA_FIELD_VERIFY_MDN };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CALL_DATA, variableFields, new String[] {"RCOM_CF_Televerification", "", "0", "", "N", "N", "Y", "0", "", "", "", "", ""}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.SESSION_FIELD_AAI,
			IProjectVariables.SESSION_FIELD_ANI,
			IProjectVariables.SESSION_FIELD_CALLTAG,
			IProjectVariables.SESSION_FIELD_CHANNEL,
			IProjectVariables.SESSION_FIELD_CHANNELTYPE,
			IProjectVariables.SESSION_FIELD_CONVERSEFIRST,
			IProjectVariables.SESSION_FIELD_CONVERSESECOND,
			IProjectVariables.SESSION_FIELD_CURRENTLANGUAGE,
			IProjectVariables.SESSION_FIELD_DNIS,
			IProjectVariables.SESSION_FIELD_EXIT_CUSTOMER_ID,
			IProjectVariables.SESSION_FIELD_EXIT_INFO_1,
			IProjectVariables.SESSION_FIELD_EXIT_INFO_2,
			IProjectVariables.SESSION_FIELD_EXIT_PREFERRED_PATH,
			IProjectVariables.SESSION_FIELD_EXIT_REASON,
			IProjectVariables.SESSION_FIELD_EXIT_TOPIC,
			IProjectVariables.SESSION_FIELD_LASTERROR,
			IProjectVariables.SESSION_FIELD_MEDIATYPE,
			IProjectVariables.SESSION_FIELD_PROTOCOLNAME,
			IProjectVariables.SESSION_FIELD_PROTOCOLVERSION,
			IProjectVariables.SESSION_FIELD_SESSIONID,
			IProjectVariables.SESSION_FIELD_SESSIONLABEL,
			IProjectVariables.SESSION_FIELD_SHAREDMODE,
			IProjectVariables.SESSION_FIELD_UCID,
			IProjectVariables.SESSION_FIELD_UUI,
			IProjectVariables.SESSION_FIELD_VIDEOBITRATE,
			IProjectVariables.SESSION_FIELD_VIDEOCODEC,
			IProjectVariables.SESSION_FIELD_VIDEOENABLED,
			IProjectVariables.SESSION_FIELD_VIDEOFARFMTP,
			IProjectVariables.SESSION_FIELD_VIDEOFORMAT,
			IProjectVariables.SESSION_FIELD_VIDEOFPS,
			IProjectVariables.SESSION_FIELD_VIDEOHEIGHT,
			IProjectVariables.SESSION_FIELD_VIDEONEARFMTP,
			IProjectVariables.SESSION_FIELD_VIDEOWIDTH,
			IProjectVariables.SESSION_FIELD_VPCALLEDEXTENSION,
			IProjectVariables.SESSION_FIELD_VPCONVERSEONDATA,
			IProjectVariables.SESSION_FIELD_VPCOVERAGEREASON,
			IProjectVariables.SESSION_FIELD_VPCOVERAGETYPE,
			IProjectVariables.SESSION_FIELD_VPRDNIS,
			IProjectVariables.SESSION_FIELD_VPREPORTURL };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SESSION, variableFields, null, session, false, true );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_ANNOUNCE_ID,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_CONFIDENCE,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_DIALOG_NAME,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_INPUT_TYPE,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_MENU_END_TIME,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_MENU_ID,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_MENU_START_TIME,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_N_BEST_VALUES,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_NOINPUT_REMAINING,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_NOMATCH_REMAINING,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_OTHER_SLOT,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_RETURN_CODE,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_SPECIFIC_SLOT,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_UTTERANCE,
			IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_ERRORCODE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_MESSAGE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_OBJECT,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_STACKTRACE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_TYPE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DD_LAST_EXCEPTION, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.TIME_FIELD_AUDIO,
			IProjectVariables.TIME_FIELD_HOUR,
			IProjectVariables.TIME_FIELD_MILLISECOND,
			IProjectVariables.TIME_FIELD_MINUTE,
			IProjectVariables.TIME_FIELD_SECOND,
			IProjectVariables.TIME_FIELD_TIMEZONE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TIME, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.SHAREDUUI_FIELD_ID,
			IProjectVariables.SHAREDUUI_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SHAREDUUI, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_ANNOUNCE_ID,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_CONFIDENCE,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_DIALOG_NAME,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_INPUT_TYPE,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_MENU_END_TIME,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_MENU_ID,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_MENU_START_TIME,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_N_BEST_VALUES,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_NOINPUT_REMAINING,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_NOMATCH_REMAINING,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_OTHER_SLOT,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_RETURN_CODE,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_SPECIFIC_SLOT,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_UTTERANCE,
			IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.UUIDATA, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANTS_FIELD_ENG,
			IProjectVariables.CONSTANTS_FIELD_HIN,
			IProjectVariables.CONSTANTS_FIELD_ONE,
			IProjectVariables.CONSTANTS_FIELD_SUCCESS,
			IProjectVariables.CONSTANTS_FIELD_TWO,
			IProjectVariables.CONSTANTS_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANTS, variableFields, new String[] {"ENG", "HIN", "1", "success", "2", ""}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DATE_FIELD_AUDIO,
			IProjectVariables.DATE_FIELD_DAYOFMONTH,
			IProjectVariables.DATE_FIELD_DAYOFWEEK,
			IProjectVariables.DATE_FIELD_DAYOFWEEKNUM,
			IProjectVariables.DATE_FIELD_DAYOFYEAR,
			IProjectVariables.DATE_FIELD_MONTH,
			IProjectVariables.DATE_FIELD_MONTHINYEAR,
			IProjectVariables.DATE_FIELD_YEAR };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DATE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANT_FIELD_CHANNEL_SUPPORT,
			IProjectVariables.CONSTANT_FIELD_ENG_CONFIG_PATH,
			IProjectVariables.CONSTANT_FIELD_HIN_CONFIG_PATH,
			IProjectVariables.CONSTANT_FIELD_INVALID,
			IProjectVariables.CONSTANT_FIELD_KEY__TRUE,
			IProjectVariables.CONSTANT_FIELD_NO,
			IProjectVariables.CONSTANT_FIELD_SUCCESS,
			IProjectVariables.CONSTANT_FIELD_THREE,
			IProjectVariables.CONSTANT_FIELD_VALID,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_1,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_2,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_3,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_4,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_5,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_6,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_7,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_8,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_0_9,
			IProjectVariables.CONSTANT_FIELD_WHIVR__TR___0_0_1_0,
			IProjectVariables.CONSTANT_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANT, variableFields, new String[] {"", "D:\\RCOM\\RCOM_CF_WebworldHelpdesk_IVR\\Config\\ENG_DM_Property\\", "D:\\RCOM\\RCOM_CF_WebworldHelpdesk_IVR\\Config\\HIN_DM_Property\\", "", "true", "no", "success", "3", "", "WHIVR_TR_0001", "WHIVR_TR_0002", "WHIVR_TR_0003", "WHIVR_TR_0004", "WHIVR_TR_0005", "WHIVR_TR_0006", "WHIVR_TR_0007", "WHIVR_TR_0008", "WHIVR_TR_0009", "WHIVR_TR_0010", "yes"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DMPROPERTY_FIELD_ASS__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_BEN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_COLLECT_DATA_CARD__TELV__MN___0_0_0_2,
			IProjectVariables.DMPROPERTY_FIELD_COLLECT_MOBILE_NUMBER__TELV__MN___0_0_0_4,
			IProjectVariables.DMPROPERTY_FIELD_CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_CONFIRM_DATA_CARD__TELV__MN___0_0_0_3,
			IProjectVariables.DMPROPERTY_FIELD_CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5,
			IProjectVariables.DMPROPERTY_FIELD_ENG__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_GLOBAL,
			IProjectVariables.DMPROPERTY_FIELD_GUJ__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_HIN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT,
			IProjectVariables.DMPROPERTY_FIELD_INVALID_NUMBER__TELV__PA___0_0_0_6,
			IProjectVariables.DMPROPERTY_FIELD_KAN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_LANGUAGE__TELV__MN___0_0_0_6,
			IProjectVariables.DMPROPERTY_FIELD_LINK_DOWN__TELV__PA___0_0_1_5,
			IProjectVariables.DMPROPERTY_FIELD_MAIN_MENU__TELV__MN___0_0_0_1,
			IProjectVariables.DMPROPERTY_FIELD_MAL__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_MAR__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_MENU_OPTION,
			IProjectVariables.DMPROPERTY_FIELD_MENU_OPTION_COUNT,
			IProjectVariables.DMPROPERTY_FIELD_ORI__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_PUN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_TAM__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_TEL__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_THANKYOU__TELV__PA___0_0_0_7,
			IProjectVariables.DMPROPERTY_FIELD_TRANSFER__TELV__PA___0_0_0_8__TELV__PA___0_0_1_0,
			IProjectVariables.DMPROPERTY_FIELD_TRIES_EXCEEDED__TELV__PA___0_0_0_2,
			IProjectVariables.DMPROPERTY_FIELD_WELCOME__TELV__PA___0_0_0_1 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DMPROPERTY, variableFields, new String[] {"", "", "CollectDataCard_TELV_MN_0002.properties", "CollectMobileNumber_TELV_MN_0004.properties", "", "ConfirmDataCard_TELV_MN_0003.properties", "ConfirmMobileNumber_TELV_MN_0005.properties", "", "global.properties", "", "", "", "InvalidNumber_TELV_PA_0006.properties", "", "Language_TELV_MN_0006.properties", "LinkDown_TELV_PA_0015.properties", "MainMenu_TELV_MN_0001.properties", "", "", "", "", "", "", "", "", "Thankyou_TELV_PA_0007.properties", "Transfer_TELV_PA_0008_TELV_PA_0010.properties", "TriesExceeded_TELV_PA_0002.properties", "Welcome_TELV_PA_0001.properties"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.COLLECT_DATA_CARD__TELV__MN___0_0_0_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_ANNOUNCE_ID,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_CONFIDENCE,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_DIALOG_NAME,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_INPUT_TYPE,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_MENU_END_TIME,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_MENU_ID,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_MENU_START_TIME,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_N_BEST_VALUES,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_NOINPUT_REMAINING,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_NOMATCH_REMAINING,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_OTHER_SLOT,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_RETURN_CODE,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_SPECIFIC_SLOT,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_UTTERANCE,
			IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONFIRM_DATA_CARD__TELV__MN___0_0_0_3, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_ANNOUNCE_ID,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_CONFIDENCE,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_DIALOG_NAME,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_INPUT_TYPE,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_MENU_END_TIME,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_MENU_ID,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_MENU_START_TIME,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_N_BEST_VALUES,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_NOINPUT_REMAINING,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_NOMATCH_REMAINING,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_OTHER_SLOT,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_RETURN_CODE,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_SPECIFIC_SLOT,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_UTTERANCE,
			IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONFIRM_MOBILE_NUMBER__TELV__MN___0_0_0_5, variableFields, null, session, false, false );
		session.putVariable(variable);
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public String getEntryName() {
		return("RCOM_CF_Televerification_IVR");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public String getRootDoc() {
		return("AppRoot");
	}
	/**
	 * Builds the list of input parameters that are defined for this application 
	 * entry.  This list is built automatically by adding Input Parameter
	 * nodes to AppRoot in the call flow editor.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 *
	 * @return a Collection of <code>java.lang.String</code> objects that
	 * are the names of parameters the application is expecting.
	 * If the AppRoot node does not have any input parameters, then 
	 * this returns an empty list
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public java.util.Collection getInputParams(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
	/**
	 * Builds the list of capture expression that are defined for this application 
	 * entry.  This list is built automatically by adding Capture Expression
	 * items to AppRoot in the call flow editor.<BR>
	 *
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 *
	 * @return a Collection of <code>CaptureExpression</code> objects that
	 * specify the ECMA script expression and the Orchestration Designer 
	 * session variable that will store the captured result.
	 * If the AppRoot node does not have any capture expression items, then 
	 * this returns an empty list
	 * Last generated by Orchestration Designer at: 2015-DEC-28  01:09:53 PM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}