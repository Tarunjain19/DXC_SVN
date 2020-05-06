package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 2015-MAR-18  11:27:56 AM
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-18  11:27:56 AM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.APP__NAME, "", null, session, false, false );
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
			IProjectVariables.APP_VARIABLES_FIELD_CIRCLE,
			IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION,
			IProjectVariables.APP_VARIABLES_FIELD_REASON_CODE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_CODE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN,
			IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.APP_VARIABLES, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_ANNOUNCE_ID,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_CONFIDENCE,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_DIALOG_NAME,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_INPUT_TYPE,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_MENU_END_TIME,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_MENU_ID,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_MENU_START_TIME,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_N_BEST_VALUES,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_OTHER_SLOT,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_RETURN_CODE,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_UTTERANCE,
			IProjectVariables.BCHD__MN___0_0_0_1__MM_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BCHD__MN___0_0_0_1__MM, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.COMP__DATE, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.START__HOT_FLASH_FIELD_ANNOUNCE_ID,
			IProjectVariables.START__HOT_FLASH_FIELD_CONFIDENCE,
			IProjectVariables.START__HOT_FLASH_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.START__HOT_FLASH_FIELD_DIALOG_NAME,
			IProjectVariables.START__HOT_FLASH_FIELD_INPUT_TYPE,
			IProjectVariables.START__HOT_FLASH_FIELD_MENU_END_TIME,
			IProjectVariables.START__HOT_FLASH_FIELD_MENU_ID,
			IProjectVariables.START__HOT_FLASH_FIELD_MENU_START_TIME,
			IProjectVariables.START__HOT_FLASH_FIELD_N_BEST_VALUES,
			IProjectVariables.START__HOT_FLASH_FIELD_NOINPUT_REMAINING,
			IProjectVariables.START__HOT_FLASH_FIELD_NOMATCH_REMAINING,
			IProjectVariables.START__HOT_FLASH_FIELD_OTHER_SLOT,
			IProjectVariables.START__HOT_FLASH_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.START__HOT_FLASH_FIELD_RETURN_CODE,
			IProjectVariables.START__HOT_FLASH_FIELD_SPECIFIC_SLOT,
			IProjectVariables.START__HOT_FLASH_FIELD_UTTERANCE,
			IProjectVariables.START__HOT_FLASH_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.START__HOT_FLASH, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.HOT_FLASH_INFO_FIELD_ANNO_ID,
			IProjectVariables.HOT_FLASH_INFO_FIELD_CALLING_NODE_ID,
			IProjectVariables.HOT_FLASH_INFO_FIELD_FLAG };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.HOT_FLASH_INFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.GRAMMARS_FIELD_CAMPUS_WI_FI,
			IProjectVariables.GRAMMARS_FIELD_FAULT_BOOKING,
			IProjectVariables.GRAMMARS_FIELD_OPEN_FAULT_STATUS };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.GRAMMARS, variableFields, new String[] {"CampusWiFi", "FaultBooking", "OpenFaultStatus"}, null, session, false, false );
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
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT,
			IProjectVariables.DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM_INPUT_PARAMETER, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANT_FIELD_ABUSIVE,
			IProjectVariables.CONSTANT_FIELD_ACCBAL,
			IProjectVariables.CONSTANT_FIELD_AGENT,
			IProjectVariables.CONSTANT_FIELD_CORPORATE__HD,
			IProjectVariables.CONSTANT_FIELD_DEFAULT__DM,
			IProjectVariables.CONSTANT_FIELD_FOUR,
			IProjectVariables.CONSTANT_FIELD_INTELLIGENT,
			IProjectVariables.CONSTANT_FIELD_KEY__TRUE,
			IProjectVariables.CONSTANT_FIELD_MAIN_MENU,
			IProjectVariables.CONSTANT_FIELD_MYVAS,
			IProjectVariables.CONSTANT_FIELD_NO,
			IProjectVariables.CONSTANT_FIELD_ONE,
			IProjectVariables.CONSTANT_FIELD_PREVIOUS,
			IProjectVariables.CONSTANT_FIELD_REPEAT,
			IProjectVariables.CONSTANT_FIELD_SERVICE,
			IProjectVariables.CONSTANT_FIELD_START,
			IProjectVariables.CONSTANT_FIELD_SUCCESS,
			IProjectVariables.CONSTANT_FIELD_THREE,
			IProjectVariables.CONSTANT_FIELD_TWO,
			IProjectVariables.CONSTANT_FIELD_VASUNSUB,
			IProjectVariables.CONSTANT_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANT, variableFields, new String[] {"ABUSIVE", "ACCBAL", "agent", "Corporate_HD", "DEFAULT", "4", "Intelligent", "true", "MainMenu", "MYVAS", "no", "1", "previous", "repeat", "service", "", "success", "3", "2", "VAS-UNSUB", "yes"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_BCHD__MM,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_DUMMY,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_GLOBAL,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_THANK__YOU__ANNCE,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_TRANSFER__AGENT__ANNCE,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_WELCOME__MSG__ANNCE,
			IProjectVariables.PROPERTY_FILE_NAME_FIELD_WELCOME__MSG__ENT };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.PROPERTY_FILE_NAME, variableFields, new String[] {"BCHD_MM.properties", "Dummy.properties", "Global.properties", "Thank_you_Annce.properties", "Transfer_Agent_Annce.properties", "Welcome_Msg_Annce.properties", "Welcome_Msg_Ent.properties"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_ANNOUNCE_ID,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_CONFIDENCE,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_DIALOG_NAME,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_INPUT_TYPE,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_MENU_END_TIME,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_MENU_ID,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_MENU_START_TIME,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_N_BEST_VALUES,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_OTHER_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_RETURN_CODE,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BCHD__PA___0_0_0_1__WELCOME__ANNCE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.FLAG_FIELD_END_CALL };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.FLAG, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_ANNOUNCE_ID,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_CONFIDENCE,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_DIALOG_NAME,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_INPUT_TYPE,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_MENU_END_TIME,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_MENU_ID,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_MENU_START_TIME,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_N_BEST_VALUES,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_OTHER_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_RETURN_CODE,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BCHD__PA___0_0_0_3__TRANSFER_AGENT__ANNCE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_ANNOUNCE_ID,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_CONFIDENCE,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_DIALOG_NAME,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_INPUT_TYPE,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_MENU_END_TIME,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_MENU_ID,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_MENU_START_TIME,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_N_BEST_VALUES,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_OTHER_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_RETURN_CODE,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BCHD__PA___0_0_0_6__WELCOME___3_8_3__ANNCE, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CALL_DATA, variableFields, null, session, false, false );
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
			IProjectVariables.TRANSFER_CODES_FIELD_BCHD__TR___0_0_0_1,
			IProjectVariables.TRANSFER_CODES_FIELD_BCHD__TR___0_0_0_2,
			IProjectVariables.TRANSFER_CODES_FIELD_BCHD__TR___0_0_0_3 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_CODES, variableFields, new String[] {"BCHD_TR_0001", "BCHD_TR_0002", "BCHD_TR_0003"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DUMMY__DM_FIELD_ANNOUNCE_ID,
			IProjectVariables.DUMMY__DM_FIELD_CONFIDENCE,
			IProjectVariables.DUMMY__DM_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DUMMY__DM_FIELD_DIALOG_NAME,
			IProjectVariables.DUMMY__DM_FIELD_INPUT_TYPE,
			IProjectVariables.DUMMY__DM_FIELD_MENU_END_TIME,
			IProjectVariables.DUMMY__DM_FIELD_MENU_ID,
			IProjectVariables.DUMMY__DM_FIELD_MENU_START_TIME,
			IProjectVariables.DUMMY__DM_FIELD_N_BEST_VALUES,
			IProjectVariables.DUMMY__DM_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DUMMY__DM_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DUMMY__DM_FIELD_OTHER_SLOT,
			IProjectVariables.DUMMY__DM_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DUMMY__DM_FIELD_RETURN_CODE,
			IProjectVariables.DUMMY__DM_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DUMMY__DM_FIELD_UTTERANCE,
			IProjectVariables.DUMMY__DM_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DUMMY__DM, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_ANNOUNCE_ID,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_CONFIDENCE,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_DIALOG_NAME,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_INPUT_TYPE,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_MENU_END_TIME,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_MENU_ID,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_MENU_START_TIME,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_N_BEST_VALUES,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_OTHER_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_RETURN_CODE,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_UTTERANCE,
			IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BCHD__PA___0_0_0_5__THANKYOU__ANNCE, variableFields, null, session, false, false );
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
			IProjectVariables.HOT_FLASH_IDS_FIELD_BCHD__PA___0_0_0_2 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.HOT_FLASH_IDS, variableFields, new String[] {"BCHD_PA_0002"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.SHAREDUUI_FIELD_ID,
			IProjectVariables.SHAREDUUI_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SHAREDUUI, variableFields, null, session, false, false );
		session.putVariable(variable);
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public String getEntryName() {
		return("RCOM_Corporate_Desk");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
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
	 * Last generated by Orchestration Designer at: 2017-SEP-06  02:38:39 PM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}
