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
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 * @return the Submit object that contains the standard variables and the first form
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = new com.avaya.sce.runtime.Submit("UUIDataParse");
		return ( submit );
	}
	/**
	 * This method initializes the SCE session with the variables that
	 * are defined in the application.<BR>
	 * 
	 * This method is generated automatically and should not be manually
	 * edited because changes may be overwritten by future code 
	 * generation.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variableFields = new String[] {
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_2, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_ANNOUNCE_ID,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_CONFIDENCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_DIALOG_NAME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_INPUT_TYPE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_MENU_END_TIME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_MENU_ID,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_MENU_START_TIME,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_N_BEST_VALUES,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_NOINPUT_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_NOMATCH_REMAINING,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_OTHER_SLOT,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_RETURN_CODE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_SPECIFIC_SLOT,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_UTTERANCE,
			IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.THANKYOU___1_9_2_5__PA___0_0_0_3, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CALLER_TYPE_FLAG, "", null, session, false, false );
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

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.APP__NAME, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.APP__VARIABLES_FIELD_ALT_MDN,
			IProjectVariables.APP__VARIABLES_FIELD_ANI,
			IProjectVariables.APP__VARIABLES_FIELD_ERROR__CODE,
			IProjectVariables.APP__VARIABLES_FIELD_UUIDNIS,
			IProjectVariables.APP__VARIABLES_FIELD_WEB_RESPONCE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.APP__VARIABLES, variableFields, null, session, false, false );
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
			IProjectVariables.FLAG_FIELD_ACCOUNT_INFORMATION,
			IProjectVariables.FLAG_FIELD_IS_CALL_DATE_VALID,
			IProjectVariables.FLAG_FIELD_IS_CALLER_DUNNED,
			IProjectVariables.FLAG_FIELD_IS_CALL_LOOPED,
			IProjectVariables.FLAG_FIELD_IS_DATA_PLAN_AVAILABLE,
			IProjectVariables.FLAG_FIELD_IS_DNCDEREGISTRATION_DONE,
			IProjectVariables.FLAG_FIELD_IS_DNCREGISTRATION_DONE,
			IProjectVariables.FLAG_FIELD_IS_DOBTODAY,
			IProjectVariables.FLAG_FIELD_IS_FROM_EVENT_BASED,
			IProjectVariables.FLAG_FIELD_IS_FROM_ILDACTIVATION,
			IProjectVariables.FLAG_FIELD_IS_FROM_INTELLIGENT_LAYER,
			IProjectVariables.FLAG_FIELD_IS_FROM_INTERACTION_HISTORY,
			IProjectVariables.FLAG_FIELD_IS_HOST_FAILURE,
			IProjectVariables.FLAG_FIELD_IS_HOT_FLASH_ACTIVE,
			IProjectVariables.FLAG_FIELD_IS_INSERT_IN_DB,
			IProjectVariables.FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED,
			IProjectVariables.FLAG_FIELD_IS_LINK_DOWN,
			IProjectVariables.FLAG_FIELD_IS_MAX_DATA_CONSUMED,
			IProjectVariables.FLAG_FIELD_IS_PAYMENT_ENABLED,
			IProjectVariables.FLAG_FIELD_IS_PTPSRPRESENT,
			IProjectVariables.FLAG_FIELD_IS_SLADATE_VALID,
			IProjectVariables.FLAG_FIELD_IS_TOTAL_EXPOSURE_VALID,
			IProjectVariables.FLAG_FIELD_IS_VASSUCCESSFUL,
			IProjectVariables.FLAG_FIELD_PTP_FLAG,
			IProjectVariables.FLAG_FIELD_TRANSFER_CALL_BACK__POS,
			IProjectVariables.FLAG_FIELD_TRANSFER_CALL_BACK__PRE,
			IProjectVariables.FLAG_FIELD_UDATA_FAIL };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.FLAG, variableFields, new String[] {"", "", "", "", "", "", "", "no", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANTS_COPY_FIELD_DELIVERED,
			IProjectVariables.CONSTANTS_COPY_FIELD_EIGHT,
			IProjectVariables.CONSTANTS_COPY_FIELD_FAILURE,
			IProjectVariables.CONSTANTS_COPY_FIELD_FEATURE_LEVEL,
			IProjectVariables.CONSTANTS_COPY_FIELD_FIVE,
			IProjectVariables.CONSTANTS_COPY_FIELD_FOUR,
			IProjectVariables.CONSTANTS_COPY_FIELD_HASH,
			IProjectVariables.CONSTANTS_COPY_FIELD_MENU_LEVEL,
			IProjectVariables.CONSTANTS_COPY_FIELD_MENU_REPEAT,
			IProjectVariables.CONSTANTS_COPY_FIELD_NA,
			IProjectVariables.CONSTANTS_COPY_FIELD_NINE,
			IProjectVariables.CONSTANTS_COPY_FIELD_NO,
			IProjectVariables.CONSTANTS_COPY_FIELD_ONE,
			IProjectVariables.CONSTANTS_COPY_FIELD_PA___0_0_0_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_PA___0_1_0_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_POSTPAID,
			IProjectVariables.CONSTANTS_COPY_FIELD_PREPAID,
			IProjectVariables.CONSTANTS_COPY_FIELD_SEVEN,
			IProjectVariables.CONSTANTS_COPY_FIELD_SIX,
			IProjectVariables.CONSTANTS_COPY_FIELD_STAR,
			IProjectVariables.CONSTANTS_COPY_FIELD_SUCCESS,
			IProjectVariables.CONSTANTS_COPY_FIELD_THREE,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_1,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_4,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_5,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_7,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_0_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_1_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_2_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_2_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_2_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_2_7,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_2_8,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_3_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_3_4,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_3_5,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_3_8,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_3_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_0,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_1,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_4,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_7,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_4_8,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_5_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_5_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_5_4,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_5_5,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_5_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_7_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_7_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_7_8,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_7_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_8_0,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_8_1,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_8_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_8_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_9_1,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_9_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_0_9_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_0_1,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_0_2,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_0_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_0_4,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_1_6,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_1_7,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_1_8,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_1_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_2_3,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_2_5,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_2_7,
			IProjectVariables.CONSTANTS_COPY_FIELD_TR___0_1_3_0,
			IProjectVariables.CONSTANTS_COPY_FIELD_TWO,
			IProjectVariables.CONSTANTS_COPY_FIELD_UNTITLED_9,
			IProjectVariables.CONSTANTS_COPY_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANTS_COPY, variableFields, new String[] {"Delivered", "8", "failure", "FeatureLevel", "5", "4", "#", "MenuLevel", "MenuRepeat", "NA", "9", "no", "1", "PA_0006", "PA_0102", "postpaid", "prepaid", "7", "6", "*", "success", "3", "TR_0001", "TR_0002", "TR_0003", "TR_0004", "TR_0005", "TR_0006", "TR_0007", "TR_0009", "TR_0016", "TR_0022", "TR_0023", "TR_0026", "TR_0027", "TR_0028", "TR_0032", "TR_0034", "TR_0035", "TR_0038", "TR_0039", "TR_0040", "TR_0041", "TR_0042", "TR_0043", "TR_0044", "TR_0046", "TR_0047", "TR_0048", "TR_0052", "TR_0053", "TR_0054", "TR_0055", "TR_0056", "TR_0072", "TR_0073", "TR_0078", "TR_0079", "TR_0080", "TR_0081", "TR_0086", "TR_0089", "TR_0091", "TR_0092", "TR_0093", "TR_0101", "TR_0102", "TR_0103", "TR_0104", "TR_0116", "TR_0117", "TR_0118", "TR_0119", "TR_0123", "TR_0125", "TR_0127", "TR_0130", "2", "", "yes"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_ANNOUNCE_ID,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_CONFIDENCE,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_DIALOG_NAME,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_INPUT_TYPE,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_MENU_END_TIME,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_MENU_ID,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_MENU_START_TIME,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_N_BEST_VALUES,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_OTHER_SLOT,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_RETURN_CODE,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_UTTERANCE,
			IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DATA_CARD_DEACT___1_9_2_5__PA___0_0_6, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DMPROPERTY_FIELD_ASS__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_BEN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_DATA_CARD_ACT___1_9_2_5__PA___0_0_5,
			IProjectVariables.DMPROPERTY_FIELD_DATA_CARD_DEACT___1_9_2_5__PA___0_0_6,
			IProjectVariables.DMPROPERTY_FIELD_ENG__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_GLOBAL,
			IProjectVariables.DMPROPERTY_FIELD_GUJ__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_HIN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_INITIAL_PROMPT,
			IProjectVariables.DMPROPERTY_FIELD_KAN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_LANGUAGE___1_9_2_5__MN___0_0_0_1,
			IProjectVariables.DMPROPERTY_FIELD_LANGUAGE___1_9_2_5__MN___0_0_0_3,
			IProjectVariables.DMPROPERTY_FIELD_LINK_DOWN___1_9_2_5__PA___0_0_4,
			IProjectVariables.DMPROPERTY_FIELD_MAIN_MENU___1_9_2_5__MN___0_0_0_2,
			IProjectVariables.DMPROPERTY_FIELD_MAL__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_MAR__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_MENU_OPTION,
			IProjectVariables.DMPROPERTY_FIELD_MENU_OPTION_COUNT,
			IProjectVariables.DMPROPERTY_FIELD_ORI__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_POST_PAID_ACT___1_9_2_5__PA___0_0_7,
			IProjectVariables.DMPROPERTY_FIELD_PUN__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_TAM__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_TEL__CONFIG_FILE_PATH,
			IProjectVariables.DMPROPERTY_FIELD_THANKYOU___1_9_2_5__PA___0_0_0_3,
			IProjectVariables.DMPROPERTY_FIELD_WELCOME___1_9_2_5__PA___0_0_0_1 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DMPROPERTY, variableFields, new String[] {"", "", "", "DataCardAct_1925_PA_005.properties", "DataCardDeact_1925_PA_006.properties", "", "global.properties", "", "", "", "", "Language_1925_MN_0001.properties", "Language_1925_MN_0003.properties", "LinkDown_1925_PA_004.properties", "MainMenu_1925_MN_0002.properties", "", "", "", "", "", "PostPaidAct_1925_PA_007.properties", "", "", "", "Thankyou_1925_PA_0003.properties", "Welcome_1925_PA_0001.properties"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LANGUAGE___1_9_2_5__MN___0_0_0_1, variableFields, null, session, false, false );
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
			IProjectVariables.SHAREDUUI_FIELD_ID,
			IProjectVariables.SHAREDUUI_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SHAREDUUI, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_ANNOUNCE_ID,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_CONFIDENCE,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_DIALOG_NAME,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_INPUT_TYPE,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_MENU_END_TIME,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_MENU_ID,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_MENU_START_TIME,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_N_BEST_VALUES,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_NOINPUT_REMAINING,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_NOMATCH_REMAINING,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_OTHER_SLOT,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_RETURN_CODE,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_SPECIFIC_SLOT,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_UTTERANCE,
			IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.MAIN_MENU___1_9_2_5__MN___0_0_0_2, variableFields, null, session, false, false );
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
			IProjectVariables.REDIRECTINFO_FIELD_PRESENTATIONINFO,
			IProjectVariables.REDIRECTINFO_FIELD_REASON,
			IProjectVariables.REDIRECTINFO_FIELD_SCREENINGINFO,
			IProjectVariables.REDIRECTINFO_FIELD_URI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REDIRECTINFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_ANNOUNCE_ID,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_CONFIDENCE,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_DIALOG_NAME,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_INPUT_TYPE,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_MENU_END_TIME,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_MENU_ID,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_MENU_START_TIME,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_N_BEST_VALUES,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_NOINPUT_REMAINING,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_NOMATCH_REMAINING,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_OTHER_SLOT,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_RETURN_CODE,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_SPECIFIC_SLOT,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_UTTERANCE,
			IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DATA_CARD_ACT___1_9_2_5__PA___0_0_5, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.POCINCVALUE, "0", null, session, false, false );
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
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_ANNOUNCE_ID,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_CONFIDENCE,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_DIALOG_NAME,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_INPUT_TYPE,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_MENU_END_TIME,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_MENU_ID,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_MENU_START_TIME,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_N_BEST_VALUES,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_OTHER_SLOT,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_RETURN_CODE,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_UTTERANCE,
			IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LINK_DOWN___1_9_2_5__PA___0_0_0_4, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_ANNOUNCE_ID,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_CONFIDENCE,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_DIALOG_NAME,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_INPUT_TYPE,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_MENU_END_TIME,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_MENU_ID,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_MENU_START_TIME,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_N_BEST_VALUES,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_NOINPUT_REMAINING,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_NOMATCH_REMAINING,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_OTHER_SLOT,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_RETURN_CODE,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_SPECIFIC_SLOT,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_UTTERANCE,
			IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.POST_PAID_ACT___1_9_2_5__PA___0_0_7, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_ERRORCODE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_MESSAGE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_OBJECT,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_STACKTRACE,
			IProjectVariables.DD_LAST_EXCEPTION_FIELD_TYPE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DD_LAST_EXCEPTION, variableFields, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.POCINCDOB, "0", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.UUIDATA, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_ANNOUNCE_ID,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_CONFIDENCE,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_DIALOG_NAME,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_INPUT_TYPE,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_MENU_END_TIME,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_MENU_ID,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_MENU_START_TIME,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_N_BEST_VALUES,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_NOINPUT_REMAINING,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_NOMATCH_REMAINING,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_OTHER_SLOT,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_RETURN_CODE,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_SPECIFIC_SLOT,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_UTTERANCE,
			IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.WELCOME___1_9_2_5__PA___0_0_0_1, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CALL_DATA_FIELD_APPLICATION_NAME,
			IProjectVariables.CALL_DATA_FIELD_CIRCLE,
			IProjectVariables.CALL_DATA_FIELD_DATA_CARD_RETRY,
			IProjectVariables.CALL_DATA_FIELD_DEFAULT_LANGUAGE,
			IProjectVariables.CALL_DATA_FIELD_IS_DATA_CARD,
			IProjectVariables.CALL_DATA_FIELD_IS_LINK_DOWN,
			IProjectVariables.CALL_DATA_FIELD_REGINAL_LANGUAGE,
			IProjectVariables.CALL_DATA_FIELD_SERVICE__TYPE,
			IProjectVariables.CALL_DATA_FIELD_TRANSFER_REASON_CODE,
			IProjectVariables.CALL_DATA_FIELD_TRANSFER_VDN,
			IProjectVariables.CALL_DATA_FIELD_UUI_DATA };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CALL_DATA, variableFields, new String[] {"RCOM_CF_1925_IVR", "", "0", "", "", "N", "", "", "", "", ""}, null, session, false, false );
		session.putVariable(variable);
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 */
	public String getEntryName() {
		return("RCOM_CF_1925_IVR");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
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
	 * Last generated by Orchestration Designer at: 2016-MAY-11  07:12:39 PM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}