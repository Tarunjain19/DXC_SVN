package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 2015-MAR-16  06:39:12 PM
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-16  06:39:12 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 * @return the Submit object that contains the standard variables and the first form
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = new com.avaya.sce.runtime.Submit("CallStart");
		return ( submit );
	}
	/**
	 * This method initializes the SCE session with the variables that
	 * are defined in the application.<BR>
	 * 
	 * This method is generated automatically and should not be manually
	 * edited because changes may be overwritten by future code 
	 * generation.
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.APP__NAME, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__MN___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.DND__MN___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__MN___0_0_0_1, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__MN___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.DND__MN___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__MN___0_0_0_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_ANNOUNCE_ID,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_CONFIDENCE,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_DIALOG_NAME,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_INPUT_TYPE,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_MENU_END_TIME,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_MENU_ID,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_MENU_START_TIME,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_N_BEST_VALUES,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_OTHER_SLOT,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_RETURN_CODE,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_UTTERANCE,
			IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LIN_KDOWN__DND__PA___0_0_2_0, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.THANKYOU_FIELD_ANNOUNCE_ID,
			IProjectVariables.THANKYOU_FIELD_CONFIDENCE,
			IProjectVariables.THANKYOU_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.THANKYOU_FIELD_DIALOG_NAME,
			IProjectVariables.THANKYOU_FIELD_INPUT_TYPE,
			IProjectVariables.THANKYOU_FIELD_MENU_END_TIME,
			IProjectVariables.THANKYOU_FIELD_MENU_ID,
			IProjectVariables.THANKYOU_FIELD_MENU_START_TIME,
			IProjectVariables.THANKYOU_FIELD_N_BEST_VALUES,
			IProjectVariables.THANKYOU_FIELD_NOINPUT_REMAINING,
			IProjectVariables.THANKYOU_FIELD_NOMATCH_REMAINING,
			IProjectVariables.THANKYOU_FIELD_OTHER_SLOT,
			IProjectVariables.THANKYOU_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.THANKYOU_FIELD_RETURN_CODE,
			IProjectVariables.THANKYOU_FIELD_SPECIFIC_SLOT,
			IProjectVariables.THANKYOU_FIELD_UTTERANCE,
			IProjectVariables.THANKYOU_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.THANKYOU, variableFields, null, session, false, false );
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
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_COUNT,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_MORE_OPTION_DYNAMIC_VALUES,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_NAME };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM_INPUT_PARAMETER, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CIRCLE, "", null, session, false, false );
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
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_ANNOUNCE_ID,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_CONFIDENCE,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_DIALOG_NAME,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_INPUT_TYPE,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_MENU_END_TIME,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_MENU_ID,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_MENU_START_TIME,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_N_BEST_VALUES,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_NOINPUT_REMAINING,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_NOMATCH_REMAINING,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_OTHER_SLOT,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_RETURN_CODE,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_SPECIFIC_SLOT,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_UTTERANCE,
			IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_MESSAGE__DND__PA___0_0_1_6, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_1,
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_2,
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_3,
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_4,
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_5,
			IProjectVariables.TRANSFER_CODES_FIELD_DND__TR___0_0_0_6 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_CODES, variableFields, new String[] {"DND_TR_0001", "DND_TR_0002", "DND_TR_0003", "DND_TR_0004", "DND_TR_0005", "DND_TR_0006"}, null, session, false, false );
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
			IProjectVariables.DND__PA___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_0_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_0_1, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_0_5_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_5_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_0_5, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_0_3_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_3_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_0_3, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.APP_VARIABLES_FIELD_DB__RESPONSE,
			IProjectVariables.APP_VARIABLES_FIELD_IS_ALREADY_DE_REG_DNC,
			IProjectVariables.APP_VARIABLES_FIELD_IS_ALREADY_REG_DNC,
			IProjectVariables.APP_VARIABLES_FIELD_IS_COMPLETED_3DAYS_ACT,
			IProjectVariables.APP_VARIABLES_FIELD_IS_COMPLETED_3DAYS_DE_ACT,
			IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION,
			IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE,
			IProjectVariables.APP_VARIABLES_FIELD_NETWORK_ERROR,
			IProjectVariables.APP_VARIABLES_FIELD_REASON_CODE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_CODE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN,
			IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA,
			IProjectVariables.APP_VARIABLES_FIELD_WS__RESPONSE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.APP_VARIABLES, variableFields, new String[] {"", "false", "false", "false", "false", "", "", "", "", "", "", "", ""}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_0_8_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_0_8_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_0_8, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_1_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_1_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_1_0_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_0_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_1_0, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DND__PA___0_0_1_4_FIELD_ANNOUNCE_ID,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_CONFIDENCE,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_DIALOG_NAME,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_INPUT_TYPE,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_MENU_END_TIME,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_MENU_ID,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_MENU_START_TIME,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_N_BEST_VALUES,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_OTHER_SLOT,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_RETURN_CODE,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_UTTERANCE,
			IProjectVariables.DND__PA___0_0_1_4_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DND__PA___0_0_1_4, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DM_GRAMMAR_VALUES_FIELD_COMPLAINT,
			IProjectVariables.DM_GRAMMAR_VALUES_FIELD_DE_REGISTRATION,
			IProjectVariables.DM_GRAMMAR_VALUES_FIELD_REGISTRATION };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM_GRAMMAR_VALUES, variableFields, new String[] {"Complaint", "DeRegistration", "Registration"}, null, session, false, false );
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
			IProjectVariables.CONSTANT_FIELD_KEY__FALSE,
			IProjectVariables.CONSTANT_FIELD_KEY__TRUE,
			IProjectVariables.CONSTANT_FIELD_SUCCESS,
			IProjectVariables.CONSTANT_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANT, variableFields, new String[] {"false", "true", "success", "yes"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_ALREADY__DE_REGISTERED,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_ALREADY__REGISTERED,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_CANNOT__DE_REGISTRATION,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_CANNOT__PROCESS,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_DE_REGISTRATION__SUCCESS,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_GLOBAL,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_LANGUAGE_SELECTION,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_LINK_DOWN,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_MAIN_MENU,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_REGISTRATION__NUMBER,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_REGISTRATION__SUCCESS,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_TECHICAL__DIFFICULTY,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_THANK__YOU,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_TRANSFER_MESSAGE,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_WELCOME_MESSAGE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.PROPERTY_FILE_NAME, variableFields, new String[] {"Already_DeRegistered.properties", "Already_Registered.properties", "Cannot_DeRegistration.properties", "Cannot_Process.properties", "DeRegistration_Success.properties", "global.properties", "LanguageSelection.properties", "LinkDown.properties", "MainMenu.properties", "Registration_Number.properties", "Registration_Success.properties", "Techical_Difficulty.properties", "Thank_You.properties", "TransferMessage.properties", "WelcomeMessage.properties"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.FLAG_FIELD_SRC_FLAG };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.FLAG, variableFields, null, session, false, false );
		session.putVariable(variable);
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 */
	public String getEntryName() {
		return("RCOM_CF_DND_1909_IVR");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
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
	 * Last generated by Orchestration Designer at: 2017-AUG-23  01:04:17 PM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}
