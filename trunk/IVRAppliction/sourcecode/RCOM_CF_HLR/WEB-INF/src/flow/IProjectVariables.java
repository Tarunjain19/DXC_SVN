package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 2015-MAR-16  01:12:14 PM
 */
public interface IProjectVariables {





	//{{START:PROJECT:VARIABLES
	/**
	 * This is a reserved block of variable name definitions.
	 * The variable names defined here can be used as the key
	 * to get the <code>com.avaya.sce.runtime.Variable</code>
	 * from the <code>SCESession</code> at runtime.<br>
	 * 
	 * For example, given a variable name <code>phoneNum</code>,
	 * user-defined code should access the variable in this format:<PRE>
	 *   Variable phNum = mySession.getVariable(IProjectVariables.PHONE_NUM);
	 *   if ( phNum != null ) {
	 *        // do something with the variable
	 *   }</PRE>
	 * 
	 * This block of code is generated automatically by Orchestration Designer and should not
	 * be manually edited as changes may be overwritten by future code generation.
	 * Last generated by Orchestration Designer at: 2016-APR-19  05:37:51 PM
	 */
	public static final String DM_INPUT_PARAMETER = "dmInputParameter";
	public static final String TIME = "time";
	public static final String APP__NAME = "APP_NAME";
	public static final String DATE = "date";
	public static final String HLR__MN___0_0_0_2 = "HLR_MN_0002";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1 = "GetMobileNumber_MN_0001";
	public static final String CONSTANT = "constant";
	public static final String SHAREDUUI = "shareduui";
	public static final String TRANSFER__MENU = "Transfer_Menu";
	public static final String APP_VARIABLES = "appVariables";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String TRANSFER_CODES = "TransferCodes";
	public static final String DM_GRAMMAR_VALUES = "dmGrammarValues";
	public static final String SESSION = "session";
	public static final String HLR__PA___0_0_1_1 = "HLR_PA_0011";
	public static final String HLR__PA___0_0_0_7 = "HLR_PA_0007";
	public static final String HLR__PA___0_0_0_5 = "HLR_PA_0005";
	public static final String HLR__PA___0_0_0_6 = "HLR_PA_0006";
	public static final String HLR__PA___0_0_0_3 = "HLR_PA_0003";
	public static final String HLR__PA___0_0_0_4 = "HLR_PA_0004";
	public static final String HLR__PA___0_0_0_2 = "HLR_PA_0002";
	public static final String HLR__PA___0_0_0_1 = "HLR_PA_0001";
	public static final String VALIDATE_MOBILE_NUMBER = "validateMobileNumber";
	public static final String PROPERTY_FILE_NAME = "propertyFileName";
	public static final String TRANSFER = "Transfer";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	//}}END:PROJECT:VARIABLES
	//{{START:PROJECT:VARIABLEFIELDS
	public static final String DM_INPUT_PARAMETER_FIELD_GLOBAL_PROPERTY_FILE_NAME = "globalPropertyFileName";
	public static final String DM_INPUT_PARAMETER_FIELD_INITIAL_PROMPT = "initialPrompt";
	public static final String DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_LOCATION = "propertyFileLocation";
	public static final String DM_INPUT_PARAMETER_FIELD_PROPERTY_FILE_NAME = "propertyFileName";
	public static final String TIME_FIELD_AUDIO = "audio";
	public static final String TIME_FIELD_HOUR = "hour";
	public static final String TIME_FIELD_MILLISECOND = "millisecond";
	public static final String TIME_FIELD_MINUTE = "minute";
	public static final String TIME_FIELD_SECOND = "second";
	public static final String TIME_FIELD_TIMEZONE = "timezone";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String HLR__MN___0_0_0_2_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__MN___0_0_0_2_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__MN___0_0_0_2_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__MN___0_0_0_2_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__MN___0_0_0_2_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__MN___0_0_0_2_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__MN___0_0_0_2_FIELD_MENU_ID = "MenuID";
	public static final String HLR__MN___0_0_0_2_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__MN___0_0_0_2_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__MN___0_0_0_2_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__MN___0_0_0_2_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__MN___0_0_0_2_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__MN___0_0_0_2_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__MN___0_0_0_2_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__MN___0_0_0_2_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__MN___0_0_0_2_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__MN___0_0_0_2_FIELD_VALUE = "Value";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_CONFIDENCE = "Confidence";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_DIALOG_NAME = "DialogName";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_INPUT_TYPE = "InputType";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_MENU_ID = "MenuID";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_RETURN_CODE = "ReturnCode";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_UTTERANCE = "Utterance";
	public static final String GET_MOBILE_NUMBER__MN___0_0_0_1_FIELD_VALUE = "Value";
	public static final String CONSTANT_FIELD_HLR__DESK = "HLR_Desk";
	public static final String CONSTANT_FIELD_IS_CALLED_WITHIN_BUSINESS_HOURS = "IsCalledWithinBusinessHours";
	public static final String CONSTANT_FIELD_NETWORK__DESK = "Network_Desk";
	public static final String CONSTANT_FIELD_SUCCESS = "success";
	public static final String CONSTANT_FIELD_THREE = "three";
	public static final String CONSTANT_FIELD_YES = "yes";
	public static final String SHAREDUUI_FIELD_ID = "id";
	public static final String SHAREDUUI_FIELD_VALUE = "value";
	public static final String TRANSFER__MENU_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String TRANSFER__MENU_FIELD_CONFIDENCE = "Confidence";
	public static final String TRANSFER__MENU_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String TRANSFER__MENU_FIELD_DIALOG_NAME = "DialogName";
	public static final String TRANSFER__MENU_FIELD_INPUT_TYPE = "InputType";
	public static final String TRANSFER__MENU_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String TRANSFER__MENU_FIELD_MENU_ID = "MenuID";
	public static final String TRANSFER__MENU_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String TRANSFER__MENU_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String TRANSFER__MENU_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String TRANSFER__MENU_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String TRANSFER__MENU_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String TRANSFER__MENU_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String TRANSFER__MENU_FIELD_RETURN_CODE = "ReturnCode";
	public static final String TRANSFER__MENU_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String TRANSFER__MENU_FIELD_UTTERANCE = "Utterance";
	public static final String TRANSFER__MENU_FIELD_VALUE = "Value";
	public static final String APP_VARIABLES_FIELD_AAI__DATA = "AAI_DATA";
	public static final String APP_VARIABLES_FIELD_BUSINESS_HOUR_FLAG = "businessHourFlag";
	public static final String APP_VARIABLES_FIELD_CIRCLE = "circle";
	public static final String APP_VARIABLES_FIELD_IS_EXCEPTION = "isException";
	public static final String APP_VARIABLES_FIELD_NETWORK_ERROR = "networkError";
	public static final String APP_VARIABLES_FIELD_REASON_CODE = "reasonCode";
	public static final String APP_VARIABLES_FIELD_TRANSFER_CODE = "TransferCode";
	public static final String APP_VARIABLES_FIELD_TRANSFER_VDN = "TransferVDN";
	public static final String APP_VARIABLES_FIELD_TRIES_COUNT = "triesCount";
	public static final String APP_VARIABLES_FIELD_UUI_DATA = "uuiData";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_1 = "HLR_TR_0001";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_2 = "HLR_TR_0002";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_3 = "HLR_TR_0003";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_4 = "HLR_TR_0004";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_5 = "HLR_TR_0005";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_6 = "HLR_TR_0006";
	public static final String TRANSFER_CODES_FIELD_HLR__TR___0_0_0_7 = "HLR_TR_0007";
	public static final String DM_GRAMMAR_VALUES_FIELD_CONFIRM = "Confirm";
	public static final String DM_GRAMMAR_VALUES_FIELD_RE_ENTER = "ReEnter";
	public static final String SESSION_FIELD_AAI = "aai";
	public static final String SESSION_FIELD_ANI = "ani";
	public static final String SESSION_FIELD_CALLTAG = "calltag";
	public static final String SESSION_FIELD_CHANNEL = "channel";
	public static final String SESSION_FIELD_CHANNELTYPE = "channeltype";
	public static final String SESSION_FIELD_CONVERSEFIRST = "conversefirst";
	public static final String SESSION_FIELD_CONVERSESECOND = "conversesecond";
	public static final String SESSION_FIELD_CURRENTLANGUAGE = "currentlanguage";
	public static final String SESSION_FIELD_DNIS = "dnis";
	public static final String SESSION_FIELD_EXIT_CUSTOMER_ID = "exitCustomerId";
	public static final String SESSION_FIELD_EXIT_INFO_1 = "exitInfo1";
	public static final String SESSION_FIELD_EXIT_INFO_2 = "exitInfo2";
	public static final String SESSION_FIELD_EXIT_PREFERRED_PATH = "exitPreferredPath";
	public static final String SESSION_FIELD_EXIT_REASON = "exitReason";
	public static final String SESSION_FIELD_EXIT_TOPIC = "exitTopic";
	public static final String SESSION_FIELD_LASTERROR = "lasterror";
	public static final String SESSION_FIELD_MEDIATYPE = "mediatype";
	public static final String SESSION_FIELD_PROTOCOLNAME = "protocolname";
	public static final String SESSION_FIELD_PROTOCOLVERSION = "protocolversion";
	public static final String SESSION_FIELD_SESSIONID = "sessionid";
	public static final String SESSION_FIELD_SESSIONLABEL = "sessionlabel";
	public static final String SESSION_FIELD_SHAREDMODE = "sharedmode";
	public static final String SESSION_FIELD_UCID = "ucid";
	public static final String SESSION_FIELD_UUI = "uui";
	public static final String SESSION_FIELD_VIDEOBITRATE = "videobitrate";
	public static final String SESSION_FIELD_VIDEOCODEC = "videocodec";
	public static final String SESSION_FIELD_VIDEOENABLED = "videoenabled";
	public static final String SESSION_FIELD_VIDEOFARFMTP = "videofarfmtp";
	public static final String SESSION_FIELD_VIDEOFORMAT = "videoformat";
	public static final String SESSION_FIELD_VIDEOFPS = "videofps";
	public static final String SESSION_FIELD_VIDEOHEIGHT = "videoheight";
	public static final String SESSION_FIELD_VIDEONEARFMTP = "videonearfmtp";
	public static final String SESSION_FIELD_VIDEOWIDTH = "videowidth";
	public static final String SESSION_FIELD_VPCALLEDEXTENSION = "vpcalledextension";
	public static final String SESSION_FIELD_VPCONVERSEONDATA = "vpconverseondata";
	public static final String SESSION_FIELD_VPCOVERAGEREASON = "vpcoveragereason";
	public static final String SESSION_FIELD_VPCOVERAGETYPE = "vpcoveragetype";
	public static final String SESSION_FIELD_VPRDNIS = "vprdnis";
	public static final String SESSION_FIELD_VPREPORTURL = "vpreporturl";
	public static final String HLR__PA___0_0_1_1_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_1_1_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_1_1_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_1_1_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_1_1_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_1_1_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_1_1_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_1_1_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_1_1_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_1_1_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_1_1_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_1_1_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_1_1_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_1_1_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_1_1_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_1_1_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_1_1_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_7_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_7_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_7_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_7_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_7_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_7_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_7_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_7_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_7_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_7_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_7_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_7_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_7_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_7_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_7_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_7_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_7_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_5_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_5_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_5_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_5_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_5_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_5_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_5_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_5_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_5_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_5_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_5_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_5_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_5_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_5_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_5_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_5_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_5_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_6_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_6_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_6_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_6_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_6_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_6_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_6_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_6_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_6_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_6_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_6_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_6_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_6_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_6_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_6_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_6_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_6_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_3_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_3_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_3_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_3_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_3_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_3_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_3_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_3_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_3_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_3_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_3_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_3_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_3_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_3_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_3_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_3_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_3_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_4_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_4_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_4_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_4_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_4_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_4_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_4_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_4_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_4_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_4_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_4_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_4_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_4_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_4_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_4_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_4_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_4_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_2_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_2_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_2_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_2_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_2_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_2_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_2_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_2_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_2_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_2_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_2_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_2_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_2_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_2_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_2_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_2_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_2_FIELD_VALUE = "Value";
	public static final String HLR__PA___0_0_0_1_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HLR__PA___0_0_0_1_FIELD_CONFIDENCE = "Confidence";
	public static final String HLR__PA___0_0_0_1_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HLR__PA___0_0_0_1_FIELD_DIALOG_NAME = "DialogName";
	public static final String HLR__PA___0_0_0_1_FIELD_INPUT_TYPE = "InputType";
	public static final String HLR__PA___0_0_0_1_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HLR__PA___0_0_0_1_FIELD_MENU_ID = "MenuID";
	public static final String HLR__PA___0_0_0_1_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HLR__PA___0_0_0_1_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HLR__PA___0_0_0_1_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HLR__PA___0_0_0_1_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HLR__PA___0_0_0_1_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HLR__PA___0_0_0_1_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HLR__PA___0_0_0_1_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HLR__PA___0_0_0_1_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HLR__PA___0_0_0_1_FIELD_UTTERANCE = "Utterance";
	public static final String HLR__PA___0_0_0_1_FIELD_VALUE = "Value";
	public static final String VALIDATE_MOBILE_NUMBER_FIELD_FLAG = "Flag";
	public static final String PROPERTY_FILE_NAME_FIELD_ATTEMPTS__EXCEEDED__PA = "Attempts_Exceeded_PA";
	public static final String PROPERTY_FILE_NAME_FIELD_GET__CONFIRMATION = "Get_Confirmation";
	public static final String PROPERTY_FILE_NAME_FIELD_GET__MOBILE__NUMBER = "Get_Mobile_Number";
	public static final String PROPERTY_FILE_NAME_FIELD_GLOBAL = "global";
	public static final String PROPERTY_FILE_NAME_FIELD_LINK_DOWN = "LinkDown";
	public static final String PROPERTY_FILE_NAME_FIELD_NON__AUTHORIZED__PA = "Non_Authorized_PA";
	public static final String PROPERTY_FILE_NAME_FIELD_NON__BUSINESS__HOUR = "Non_Business_Hour";
	public static final String PROPERTY_FILE_NAME_FIELD_THANK__YOU = "Thank_You";
	public static final String PROPERTY_FILE_NAME_FIELD_TRANSFER__MENU = "Transfer_Menu";
	public static final String PROPERTY_FILE_NAME_FIELD_TRANSFER_MESSAGE = "TransferMessage";
	public static final String PROPERTY_FILE_NAME_FIELD_WELCOME__PA = "Welcome_PA";
	public static final String DD_LAST_EXCEPTION_FIELD_ERRORCODE = "errorcode";
	public static final String DD_LAST_EXCEPTION_FIELD_MESSAGE = "message";
	public static final String DD_LAST_EXCEPTION_FIELD_OBJECT = "object";
	public static final String DD_LAST_EXCEPTION_FIELD_STACKTRACE = "stacktrace";
	public static final String DD_LAST_EXCEPTION_FIELD_TYPE = "type";
	//}}END:PROJECT:VARIABLEFIELDS
}
