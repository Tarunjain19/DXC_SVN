package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 2015-MAR-16  07:38:10 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUN-19  10:56:30 AM
	 */
	public static final String APP__NAME = "APP_NAME";
	public static final String TRANSFER_CALL = "TransferCall";
	public static final String WELCOME_ANN__PP = "WelcomeAnn_PP";
	public static final String HOT_FLASH__PP = "HotFlash_PP";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String APP_VARIABLES = "appVariables";
	public static final String HOT_FLASH_INFO = "HotFlashInfo";
	public static final String CONSTANTS = "Constants";
	public static final String NODE_NAMES = "NodeNames";
	public static final String DATE = "date";
	public static final String CONSTANT = "constant";
	public static final String TRANSFER_DETAILS = "TransferDetails";
	public static final String DM__PROPERTY_FILE_NAME = "DM_propertyFileName";
	public static final String CIRCLE = "CIRCLE";
	public static final String DM__INPUT = "DM_input";
	public static final String SESSION = "session";
	public static final String AUDIO_OR_VIDEO__MN = "AudioOrVideo_MN";
	public static final String AGENT_TRANSFER__PP = "AgentTransfer_PP";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String TRANSFER_POINTS = "TransferPoints";
	public static final String TIME = "time";
	public static final String SHAREDUUI = "shareduui";
	//}}END:PROJECT:VARIABLES
	//{{START:PROJECT:VARIABLEFIELDS
	public static final String WELCOME_ANN__PP_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String WELCOME_ANN__PP_FIELD_CONFIDENCE = "Confidence";
	public static final String WELCOME_ANN__PP_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String WELCOME_ANN__PP_FIELD_DIALOG_NAME = "DialogName";
	public static final String WELCOME_ANN__PP_FIELD_INPUT_TYPE = "InputType";
	public static final String WELCOME_ANN__PP_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String WELCOME_ANN__PP_FIELD_MENU_ID = "MenuID";
	public static final String WELCOME_ANN__PP_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String WELCOME_ANN__PP_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String WELCOME_ANN__PP_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String WELCOME_ANN__PP_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String WELCOME_ANN__PP_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String WELCOME_ANN__PP_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String WELCOME_ANN__PP_FIELD_RETURN_CODE = "ReturnCode";
	public static final String WELCOME_ANN__PP_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String WELCOME_ANN__PP_FIELD_UTTERANCE = "Utterance";
	public static final String WELCOME_ANN__PP_FIELD_VALUE = "Value";
	public static final String HOT_FLASH__PP_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String HOT_FLASH__PP_FIELD_CONFIDENCE = "Confidence";
	public static final String HOT_FLASH__PP_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String HOT_FLASH__PP_FIELD_DIALOG_NAME = "DialogName";
	public static final String HOT_FLASH__PP_FIELD_INPUT_TYPE = "InputType";
	public static final String HOT_FLASH__PP_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String HOT_FLASH__PP_FIELD_MENU_ID = "MenuID";
	public static final String HOT_FLASH__PP_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String HOT_FLASH__PP_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String HOT_FLASH__PP_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String HOT_FLASH__PP_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String HOT_FLASH__PP_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String HOT_FLASH__PP_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String HOT_FLASH__PP_FIELD_RETURN_CODE = "ReturnCode";
	public static final String HOT_FLASH__PP_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String HOT_FLASH__PP_FIELD_UTTERANCE = "Utterance";
	public static final String HOT_FLASH__PP_FIELD_VALUE = "Value";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String APP_VARIABLES_FIELD_IS_EXCEPTION = "isException";
	public static final String APP_VARIABLES_FIELD_TRANFER_CODE = "TranferCode";
	public static final String APP_VARIABLES_FIELD_TRANSFER_VDN = "TransferVDN";
	public static final String APP_VARIABLES_FIELD_UUI_DATA = "uuiData";
	public static final String HOT_FLASH_INFO_FIELD_ANNO_ID = "annoID";
	public static final String HOT_FLASH_INFO_FIELD_CALLING_NODE_ID = "CallingNodeId";
	public static final String HOT_FLASH_INFO_FIELD_HOT_FLASH_INITIAL_PROMPT = "HotFlashInitialPrompt";
	public static final String HOT_FLASH_INFO_FIELD_IS_HOT_FLASH_ENABLED = "isHotFlashEnabled";
	public static final String CONSTANTS_FIELD_AV__MENU__RET__VAL__AUDIO = "AV_MENU_RET_VAL_AUDIO";
	public static final String CONSTANTS_FIELD_SUCCESS = "SUCCESS";
	public static final String CONSTANTS_FIELD_TRUE = "TRUE";
	public static final String NODE_NAMES_FIELD_AUDIO_OR_VIDEO__MN = "AudioOrVideo_MN";
	public static final String NODE_NAMES_FIELD_WELCOME_ANN__PP = "WelcomeAnn_PP";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String CONSTANT_FIELD_ABUSIVE = "ABUSIVE";
	public static final String CONSTANT_FIELD_ACCBAL = "ACCBAL";
	public static final String CONSTANT_FIELD_AGENT = "agent";
	public static final String CONSTANT_FIELD_CORPORATE__HD = "Corporate_HD";
	public static final String CONSTANT_FIELD_DEFAULT__DM = "default_DM";
	public static final String CONSTANT_FIELD_FOUR = "four";
	public static final String CONSTANT_FIELD_INTELLIGENT = "Intelligent";
	public static final String CONSTANT_FIELD_KEY__TRUE = "Key_true";
	public static final String CONSTANT_FIELD_MAIN_MENU = "MainMenu";
	public static final String CONSTANT_FIELD_MYVAS = "MYVAS";
	public static final String CONSTANT_FIELD_NO = "no";
	public static final String CONSTANT_FIELD_ONE = "one";
	public static final String CONSTANT_FIELD_PREVIOUS = "previous";
	public static final String CONSTANT_FIELD_REPEAT = "repeat";
	public static final String CONSTANT_FIELD_SERVICE = "service";
	public static final String CONSTANT_FIELD_START = "Start";
	public static final String CONSTANT_FIELD_SUCCESS = "success";
	public static final String CONSTANT_FIELD_THREE = "three";
	public static final String CONSTANT_FIELD_TWO = "two";
	public static final String CONSTANT_FIELD_VASUNSUB = "VASUNSUB";
	public static final String CONSTANT_FIELD_YES = "yes";
	public static final String TRANSFER_DETAILS_FIELD_SKILL__NAME = "SKILL_NAME";
	public static final String TRANSFER_DETAILS_FIELD_TRANSFER__VDN___1 = "TRANSFER_VDN_1";
	public static final String TRANSFER_DETAILS_FIELD_TRANSFER__VDN___2 = "TRANSFER_VDN_2";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_AGENT_TRANSFER__PP = "AgentTransfer_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_AUDIO_OR_VIDEO__MN = "AudioOrVideo_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_HOT_FLASH__PP = "HotFlash_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_WELCOME_ANN__PP = "WelcomeAnn_PP";
	public static final String DM__INPUT_FIELD_DM__ANNOUNCE_ID = "DM_AnnounceID";
	public static final String DM__INPUT_FIELD_DM__GLOBAL_PROPERTY_FILE_NAME = "DM_globalPropertyFileName";
	public static final String DM__INPUT_FIELD_DM__INITIAL_PROMPT = "DM_initialPrompt";
	public static final String DM__INPUT_FIELD_DM__PROPERTIES_LOCATION = "DM_propertiesLocation";
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
	public static final String AUDIO_OR_VIDEO__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_MENU_ID = "MenuID";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_UTTERANCE = "Utterance";
	public static final String AUDIO_OR_VIDEO__MN_FIELD_VALUE = "Value";
	public static final String AGENT_TRANSFER__PP_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String AGENT_TRANSFER__PP_FIELD_CONFIDENCE = "Confidence";
	public static final String AGENT_TRANSFER__PP_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String AGENT_TRANSFER__PP_FIELD_DIALOG_NAME = "DialogName";
	public static final String AGENT_TRANSFER__PP_FIELD_INPUT_TYPE = "InputType";
	public static final String AGENT_TRANSFER__PP_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String AGENT_TRANSFER__PP_FIELD_MENU_ID = "MenuID";
	public static final String AGENT_TRANSFER__PP_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String AGENT_TRANSFER__PP_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String AGENT_TRANSFER__PP_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String AGENT_TRANSFER__PP_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String AGENT_TRANSFER__PP_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String AGENT_TRANSFER__PP_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String AGENT_TRANSFER__PP_FIELD_RETURN_CODE = "ReturnCode";
	public static final String AGENT_TRANSFER__PP_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String AGENT_TRANSFER__PP_FIELD_UTTERANCE = "Utterance";
	public static final String AGENT_TRANSFER__PP_FIELD_VALUE = "Value";
	public static final String DD_LAST_EXCEPTION_FIELD_ERRORCODE = "errorcode";
	public static final String DD_LAST_EXCEPTION_FIELD_MESSAGE = "message";
	public static final String DD_LAST_EXCEPTION_FIELD_OBJECT = "object";
	public static final String DD_LAST_EXCEPTION_FIELD_STACKTRACE = "stacktrace";
	public static final String DD_LAST_EXCEPTION_FIELD_TYPE = "type";
	public static final String TRANSFER_POINTS_FIELD_AVS__TR___0_0_0_1 = "AVS_TR_0001";
	public static final String TRANSFER_POINTS_FIELD_AVS__TR___0_0_0_2 = "AVS_TR_0002";
	public static final String TIME_FIELD_AUDIO = "audio";
	public static final String TIME_FIELD_HOUR = "hour";
	public static final String TIME_FIELD_MILLISECOND = "millisecond";
	public static final String TIME_FIELD_MINUTE = "minute";
	public static final String TIME_FIELD_SECOND = "second";
	public static final String TIME_FIELD_TIMEZONE = "timezone";
	public static final String SHAREDUUI_FIELD_ID = "id";
	public static final String SHAREDUUI_FIELD_VALUE = "value";
	//}}END:PROJECT:VARIABLEFIELDS
}