package flow;

/**
 * This is a special reserved class that is repsonsible for loading application 
 * variables as well as the forward to the actual first form of the application.<br>
 * This class should not be manually edited as changes may be overridden by the 
 * code generator.<br>
 * Last generated by Orchestration Designer at: 2015-MAR-18  08:32:05 PM
 */
public class Start extends com.avaya.sce.runtime.Entry {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: 2015-MAR-18  08:32:05 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public void initializeVariables(com.avaya.sce.runtimecommon.SCESession session) {
		com.avaya.sce.runtimecommon.IVariable variable = null;
		String[] variableFields = null;

		variableFields = new String[] {
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_ANNOUNCE_ID,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_CONFIDENCE,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_DIALOG_NAME,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_INPUT_TYPE,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_MENU_END_TIME,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_MENU_ID,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_MENU_START_TIME,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_N_BEST_VALUES,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_NOINPUT_REMAINING,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_NOMATCH_REMAINING,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_OTHER_SLOT,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_RETURN_CODE,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_SPECIFIC_SLOT,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_UTTERANCE,
			IProjectVariables.SELECT_LANGUAGE__MN_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.SELECT_LANGUAGE__MN, variableFields, null, session, false, false );
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
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_ANNOUNCE_ID,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_CONFIDENCE,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_DIALOG_NAME,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_INPUT_TYPE,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_MENU_END_TIME,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_MENU_ID,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_MENU_START_TIME,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_N_BEST_VALUES,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_NOINPUT_REMAINING,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_NOMATCH_REMAINING,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_OTHER_SLOT,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_RETURN_CODE,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_SPECIFIC_SLOT,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_UTTERANCE,
			IProjectVariables.BUSINESS_HOUR_ANN__PP_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.BUSINESS_HOUR_ANN__PP, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_ANNOUNCE_ID,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_CONFIDENCE,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_DIALOG_NAME,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_INPUT_TYPE,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_MENU_END_TIME,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_MENU_ID,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_MENU_START_TIME,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_N_BEST_VALUES,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_NOINPUT_REMAINING,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_NOMATCH_REMAINING,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_OTHER_SLOT,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_RETURN_CODE,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_SPECIFIC_SLOT,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_UTTERANCE,
			IProjectVariables.WIRELESS_OR_BROADBAND__MN_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.WIRELESS_OR_BROADBAND__MN, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.REDIRECTINFO_FIELD_PRESENTATIONINFO,
			IProjectVariables.REDIRECTINFO_FIELD_REASON,
			IProjectVariables.REDIRECTINFO_FIELD_SCREENINGINFO,
			IProjectVariables.REDIRECTINFO_FIELD_URI };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.REDIRECTINFO, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.CONSTANTS_FIELD_BROADBAND_NON_BUSINESS_HOUR__PP,
			IProjectVariables.CONSTANTS_FIELD_IS_CALLED_WITHIN_BUSINESS_HOUR,
			IProjectVariables.CONSTANTS_FIELD_MOBILE_NON_BUSINESS_HOUR__PP,
			IProjectVariables.CONSTANTS_FIELD_SUCCESS,
			IProjectVariables.CONSTANTS_FIELD_WIRED__WIRELESS__MN__RET__VALUE__BROADBAND,
			IProjectVariables.CONSTANTS_FIELD_WIRED__WIRELESS__MN__RET__VALUE__MOBILE,
			IProjectVariables.CONSTANTS_FIELD_YES };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.CONSTANTS, variableFields, new String[] {"BroadbandNonBusinessHour_PP.properties", "false", "MobileNonBusinessHour_PP.properties", "SUCCESS", "Broadband", "Mobile", "Yes"}, null, session, false, false );
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
			IProjectVariables.LINK_DOWN__PP_FIELD_ANNOUNCE_ID,
			IProjectVariables.LINK_DOWN__PP_FIELD_CONFIDENCE,
			IProjectVariables.LINK_DOWN__PP_FIELD_CONFIRMATION_REMAINING,
			IProjectVariables.LINK_DOWN__PP_FIELD_DIALOG_NAME,
			IProjectVariables.LINK_DOWN__PP_FIELD_INPUT_TYPE,
			IProjectVariables.LINK_DOWN__PP_FIELD_MENU_END_TIME,
			IProjectVariables.LINK_DOWN__PP_FIELD_MENU_ID,
			IProjectVariables.LINK_DOWN__PP_FIELD_MENU_START_TIME,
			IProjectVariables.LINK_DOWN__PP_FIELD_N_BEST_VALUES,
			IProjectVariables.LINK_DOWN__PP_FIELD_NOINPUT_REMAINING,
			IProjectVariables.LINK_DOWN__PP_FIELD_NOMATCH_REMAINING,
			IProjectVariables.LINK_DOWN__PP_FIELD_OTHER_SLOT,
			IProjectVariables.LINK_DOWN__PP_FIELD_RECORDED__UTTERANCE,
			IProjectVariables.LINK_DOWN__PP_FIELD_RETURN_CODE,
			IProjectVariables.LINK_DOWN__PP_FIELD_SPECIFIC_SLOT,
			IProjectVariables.LINK_DOWN__PP_FIELD_UTTERANCE,
			IProjectVariables.LINK_DOWN__PP_FIELD_VALUE };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.LINK_DOWN__PP, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.APP_VARIABLES_FIELD_ACCOUNT_NUMBER,
			IProjectVariables.APP_VARIABLES_FIELD_APP_NAME,
			IProjectVariables.APP_VARIABLES_FIELD_CIRCLE,
			IProjectVariables.APP_VARIABLES_FIELD_IS_EXCEPTION,
			IProjectVariables.APP_VARIABLES_FIELD_LANGUAGE,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_POINT,
			IProjectVariables.APP_VARIABLES_FIELD_TRANSFER_VDN,
			IProjectVariables.APP_VARIABLES_FIELD_UUI_DATA };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.APP_VARIABLES, variableFields, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_AGENT_TRANSFER__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_LINK_DOWN__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_NON_BUSINESS_HOUR__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_SELECT_LANGUAGE__MN,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_WELCOME_ANN__PP,
			IProjectVariables.DM__PROPERTY_FILE_NAME_FIELD_WIRELESS_OR_BROADBAND__MN };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM__PROPERTY_FILE_NAME, variableFields, new String[] {"AgentTransfer_PP.properties", "LinkDown_PP.properties", "BroadbandNonBusinessHour_PP.properties", "SelectLanguage_MN.properties", "WelcomeAnn_PP.properties", "WirelessOrBroadband_MN.properties"}, null, session, false, false );
		session.putVariable(variable);

		variableFields = new String[] {
			IProjectVariables.DM__INPUT_FIELD_DM__DTMF_GRAMMAR,
			IProjectVariables.DM__INPUT_FIELD_DM__GLOBAL_PROPERTY_FILE_NAME,
			IProjectVariables.DM__INPUT_FIELD_DM__INITIAL_PROMPT,
			IProjectVariables.DM__INPUT_FIELD_DM__MENU_ID,
			IProjectVariables.DM__INPUT_FIELD_DM__NO_INPUT_PROMPT,
			IProjectVariables.DM__INPUT_FIELD_DM__NO_MATCH_PROMPT,
			IProjectVariables.DM__INPUT_FIELD_DM__PROPERTIES_LOCATION };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.DM__INPUT, variableFields, new String[] {"null", "global.properties", "null", "null", "", "null", ""}, null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.CALL_TRANSFER, "", null, session, false, false );
		session.putVariable(variable);

		variable = com.avaya.sce.runtime.SimpleVariable.createSimpleVariable(IProjectVariables.DB__GET__CIRCLE__RET__CODE, "FAILURE", null, session, false, false );
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
			IProjectVariables.TRANSFER_POINTS_FIELD_SIVR__TR___0_0_0_1,
			IProjectVariables.TRANSFER_POINTS_FIELD_SIVR__TR___0_0_0_2,
			IProjectVariables.TRANSFER_POINTS_FIELD_SIVR__TR___0_0_0_3 };
		variable = com.avaya.sce.runtime.ComplexVariable.createComplexVariable(IProjectVariables.TRANSFER_POINTS, variableFields, new String[] {"SIVR_TR_0001", "SIVR_TR_0002", "SIVR_TR_0003"}, null, session, false, false );
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public String getEntryName() {
		return("RCOM_CF_Secretariat_IVR");
	}
	/**
	 * This method returns a list of life cycle classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public java.util.Collection getPluggableLifeCycle() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns a list of VXML contributor classes for Pluggable Connectors.
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public java.util.Collection getPluggableVXMLContrib() {
		java.util.ArrayList result = new java.util.ArrayList();
		return(result);
	}
	/**
	 * This method returns the root document for the application.
	 * This method is generated automatically and should not be modified
	 * because changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-03  11:47:32 AM
	 */
	public java.util.Collection getCaptureExpressions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		list = new java.util.ArrayList();

		return list;
	}
}