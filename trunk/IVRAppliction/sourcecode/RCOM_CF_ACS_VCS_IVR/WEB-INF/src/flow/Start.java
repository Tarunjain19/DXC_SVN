package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 2015-MAR-16  07:38:10 PM
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-16  07:38:10 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 * @return the Submit object that contains the standard variables and the first form
	 */
	public com.avaya.sce.runtime.Submit getSubmit(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Submit submit = new com.avaya.sce.runtime.Submit("Capture_ANI_DNIS_BC");
		return ( submit );
	}
	/**
	 * This method initializes the SCE session with the variables that
	 * are defined in the application.<BR>
	 * 
	 * This method is generated automatically and should not be manually
	 * edited because changes may be overwritten by future code 
	 * generation.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.APP__NAME, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.TRANSFER_CALL, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.WELCOME_ANN__PP_FIELD_ANNOUNCE_ID,
			IProjectVariables.WELCOME_ANN__PP_FIELD_CONFIDENCE,
			IProjectVariables.WELCOME_ANN__PP_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.WELCOME_ANN__PP_FIELD_DIALOG_NAME,
			IProjectVariables.WELCOME_ANN__PP_FIELD_INPUT_TYPE,
			IProjectVariables.WELCOME_ANN__PP_FIELD_MENU_END_TIME,
			IProjectVariables.WELCOME_ANN__PP_FIELD_MENU_ID,
			IProjectVariables.WELCOME_ANN__PP_FIELD_MENU_START_TIME,
			IProjectVariables.WELCOME_ANN__PP_FIELD_N_BEST_VALUES,
			IProjectVariables.WELCOME_ANN__PP_FIELD_NOINPUT_REMAINING,
			IProjectVariables.WELCOME_ANN__PP_FIELD_NOMATCH_REMAINING,
			IProjectVariables.WELCOME_ANN__PP_FIELD_OTHER_SLOT,
			IProjectVariables.WELCOME_ANN__PP_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.WELCOME_ANN__PP_FIELD_RETURN_CODE,
			IProjectVariables.WELCOME_ANN__PP_FIELD_SPECIFIC_SLOT,
			IProjectVariables.WELCOME_ANN__PP_FIELD_UTTERANCE,
			IProjectVariables.WELCOME_ANN__PP_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.WELCOME_ANN__PP, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.HOT_FLASH__PP_FIELD_ANNOUNCE_ID,
			IProjectVariables.HOT_FLASH__PP_FIELD_CONFIDENCE,
			IProjectVariables.HOT_FLASH__PP_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.HOT_FLASH__PP_FIELD_DIALOG_NAME,
			IProjectVariables.HOT_FLASH__PP_FIELD_INPUT_TYPE,
			IProjectVariables.HOT_FLASH__PP_FIELD_MENU_END_TIME,
			IProjectVariables.HOT_FLASH__PP_FIELD_MENU_ID,
			IProjectVariables.HOT_FLASH__PP_FIELD_MENU_START_TIME,
			IProjectVariables.HOT_FLASH__PP_FIELD_N_BEST_VALUES,
			IProjectVariables.HOT_FLASH__PP_FIELD_NOINPUT_REMAINING,
			IProjectVariables.HOT_FLASH__PP_FIELD_NOMATCH_REMAINING,
			IProjectVariables.HOT_FLASH__PP_FIELD_OTHER_SLOT,
			IProjectVariables.HOT_FLASH__PP_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.HOT_FLASH__PP_FIELD_RETURN_CODE,
			IProjectVariables.HOT_FLASH__PP_FIELD_SPECIFIC_SLOT,
			IProjectVariables.HOT_FLASH__PP_FIELD_UTTERANCE,
			IProjectVariables.HOT_FLASH__PP_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.HOT_FLASH__PP, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REDIRECTINFO_FIELD_PRESENTATIONINFO,
			IProjectVariables.REDIRECTINFO_FIELD_REASON,
			IProjectVariables.REDIRECTINFO_FIELD_SCREENINGINFO,
			IProjectVariables.REDIRECTINFO_FIELD_URI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REDIRECTINFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION,
			IProjectVariables.APP_VARIABLES_FIELD_TRANFER_CODE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN,
			IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.APP_VARIABLES, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.HOT_FLASH_INFO_FIELD_ANNO_ID,
			IProjectVariables.HOT_FLASH_INFO_FIELD_CALLING_NODE_ID,
			IProjectVariables.HOT_FLASH_INFO_FIELD_HOT_FLASH_INITIAL_PROMPT,
			IProjectVariables.HOT_FLASH_INFO_FIELD_IS_HOT_FLASH_ENABLED };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.HOT_FLASH_INFO, variableFields, new String[] {"", "", "", "false"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANTS_FIELD_AV__MENU__RET__VAL__AUDIO,
			IProjectVariables.CONSTANTS_FIELD_SUCCESS,
			IProjectVariables.CONSTANTS_FIELD_TRUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANTS, variableFields, new String[] {"Audio", "SUCCESS", "true"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.NODE_NAMES_FIELD_AUDIO_OR_VIDEO__MN,
			IProjectVariables.NODE_NAMES_FIELD_WELCOME_ANN__PP };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.NODE_NAMES, variableFields, new String[] {"AudioOrVideo_MN", "WelcomeAnn_PP"}, null, session, false, false );
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
			IProjectVariables.TRANSFER_DETAILS_FIELD_SKILL__NAME,
			IProjectVariables.TRANSFER_DETAILS_FIELD_TRANSFER__VDN___1,
			IProjectVariables.TRANSFER_DETAILS_FIELD_TRANSFER__VDN___2 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_DETAILS, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_AGENT_TRANSFER__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_AUDIO_OR_VIDEO__MN,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_HOT_FLASH__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_WELCOME_ANN__PP };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM__PROPERTY_FILE_NAME, variableFields, new String[] {"AgentTransfer_PP.properties", "AudioOrVideo_MN.properties", "HotFlash_PP.properties", "WelcomeAnn_PP.properties"}, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CIRCLE, "", null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DM__INPUT_FIELD_DM__ANNOUNCE_ID,
			IProjectVariables.DM__INPUT_FIELD_DM__GLOBAL_PROPERTY_FILE_NAME,
			IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT,
			IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM__INPUT, variableFields, new String[] {"", "global.properties", "", ""}, null, session, false, false );
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
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_ANNOUNCE_ID,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_CONFIDENCE,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_DIALOG_NAME,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_INPUT_TYPE,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_MENU_END_TIME,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_MENU_ID,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_MENU_START_TIME,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_N_BEST_VALUES,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_NOINPUT_REMAINING,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_NOMATCH_REMAINING,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_OTHER_SLOT,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_RETURN_CODE,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_SPECIFIC_SLOT,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_UTTERANCE,
			IProjectVariables.AUDIO_OR_VIDEO__MN_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.AUDIO_OR_VIDEO__MN, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_ANNOUNCE_ID,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_CONFIDENCE,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_DIALOG_NAME,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_INPUT_TYPE,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_MENU_END_TIME,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_MENU_ID,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_MENU_START_TIME,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_N_BEST_VALUES,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_NOINPUT_REMAINING,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_NOMATCH_REMAINING,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_OTHER_SLOT,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_RETURN_CODE,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_SPECIFIC_SLOT,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_UTTERANCE,
			IProjectVariables.AGENT_TRANSFER__PP_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.AGENT_TRANSFER__PP, variableFields, null, session, false, false );
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
			IProjectVariables.TRANSFER_POINTS_FIELD_AVS__TR___0_0_0_1,
			IProjectVariables.TRANSFER_POINTS_FIELD_AVS__TR___0_0_0_2 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_POINTS, variableFields, new String[] {"AVS_TR_0001", "AVS_TR_0002"}, null, session, false, false );
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
	}
	/**
	 * This method returns the name of the application.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public String getEntryName() {
		return("RCOM_CF_ACS_VCS_IVR");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}
