package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 2015-APR-02  03:13:39 PM
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
	 * Last generated by Orchestration Designer at: 2016-JAN-28  05:42:46 PM
	 */
	public static final String WELCOME_ANN__PP = "WelcomeAnn_PP";
	public static final String HOT_FLASH__PP = "HotFlash_PP";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String HOT_FLASH_INFO = "HotFlashInfo";
	public static final String PROMO__MN = "Promo_MN";
	public static final String LINK_DOWN__PP = "LinkDown_PP";
	public static final String DM__PROPERTY_FILE_NAME = "DM_propertyFileName";
	public static final String CALL_TRANSFER = "CallTransfer";
	public static final String ENQUIRY__MN = "Enquiry_MN";
	public static final String SESSION = "session";
	public static final String AGENT_TRANSFER__PP = "AgentTransfer_PP";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String TIME = "time";
	public static final String SHAREDUUI = "shareduui";
	public static final String DM__PROPERTIES__LOCATION = "DM_Properties_Location";
	public static final String BUSINESS_HOUR_ANN__PP = "BusinessHourAnn_PP";
	public static final String MAIN_MENU__MN = "MainMenu_MN";
	public static final String TICKET_RELATED_ENQUIRY__MN = "TicketRelatedEnquiry_MN";
	public static final String APP_VARIABLES = "appVariables";
	public static final String CONSTANTS = "Constants";
	public static final String LANGUAGES = "LANGUAGES";
	public static final String SELECT_LANG__MN = "SelectLang_MN";
	public static final String DATE = "date";
	public static final String DM__INPUT = "DM_input";
	public static final String TOKEN__MN = "Token_MN";
	public static final String SMART_CARD__MN = "SmartCard_MN";
	public static final String TRAIN_SCHEDULE__MN = "TrainSchedule_MN";
	public static final String TRANSFER_POINTS = "TransferPoints";
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
	public static final String HOT_FLASH_INFO_FIELD_ANNO_ID = "annoID";
	public static final String HOT_FLASH_INFO_FIELD_CALLING_NODE_ID = "CallingNodeId";
	public static final String HOT_FLASH_INFO_FIELD_HOT_FLASH_INITIAL_PROMPT = "HotFlashInitialPrompt";
	public static final String HOT_FLASH_INFO_FIELD_IS_HOT_FLASH_ENABLED = "isHotFlashEnabled";
	public static final String PROMO__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String PROMO__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String PROMO__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String PROMO__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String PROMO__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String PROMO__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String PROMO__MN_FIELD_MENU_ID = "MenuID";
	public static final String PROMO__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String PROMO__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String PROMO__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String PROMO__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String PROMO__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String PROMO__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String PROMO__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String PROMO__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String PROMO__MN_FIELD_UTTERANCE = "Utterance";
	public static final String PROMO__MN_FIELD_VALUE = "Value";
	public static final String LINK_DOWN__PP_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String LINK_DOWN__PP_FIELD_CONFIDENCE = "Confidence";
	public static final String LINK_DOWN__PP_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String LINK_DOWN__PP_FIELD_DIALOG_NAME = "DialogName";
	public static final String LINK_DOWN__PP_FIELD_INPUT_TYPE = "InputType";
	public static final String LINK_DOWN__PP_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String LINK_DOWN__PP_FIELD_MENU_ID = "MenuID";
	public static final String LINK_DOWN__PP_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String LINK_DOWN__PP_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String LINK_DOWN__PP_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String LINK_DOWN__PP_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String LINK_DOWN__PP_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String LINK_DOWN__PP_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String LINK_DOWN__PP_FIELD_RETURN_CODE = "ReturnCode";
	public static final String LINK_DOWN__PP_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String LINK_DOWN__PP_FIELD_UTTERANCE = "Utterance";
	public static final String LINK_DOWN__PP_FIELD_VALUE = "Value";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_AGENT_TRANSFER__PP = "AgentTransfer_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_BUSINESS_HOUR_ANN__PP = "BusinessHourAnn_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_ENQUIRY__MN = "Enquiry_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_HOT_FLASH__PP = "HotFlash_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_LINK_DOWN__PP = "LinkDown_PP";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_MAIN_MENU__MN = "MainMenu_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_PROMO__MN = "Promo_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_SELECT_LANG__MN = "SelectLang_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_SMART_CARD__MN = "SmartCard_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_TICKET_RELATED_ENQUIRY__MN = "TicketRelatedEnquiry_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_TOKEN__MN = "Token_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_TRAIN_SCHEDULE__MN = "TrainSchedule_MN";
	public static final String DM__PROPERTY_FILE_NAME_FIELD_WELCOME_ANN__PP = "WelcomeAnn_PP";
	public static final String ENQUIRY__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String ENQUIRY__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String ENQUIRY__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String ENQUIRY__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String ENQUIRY__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String ENQUIRY__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String ENQUIRY__MN_FIELD_MENU_ID = "MenuID";
	public static final String ENQUIRY__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String ENQUIRY__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String ENQUIRY__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String ENQUIRY__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String ENQUIRY__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String ENQUIRY__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String ENQUIRY__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String ENQUIRY__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String ENQUIRY__MN_FIELD_UTTERANCE = "Utterance";
	public static final String ENQUIRY__MN_FIELD_VALUE = "Value";
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
	public static final String TIME_FIELD_AUDIO = "audio";
	public static final String TIME_FIELD_HOUR = "hour";
	public static final String TIME_FIELD_MILLISECOND = "millisecond";
	public static final String TIME_FIELD_MINUTE = "minute";
	public static final String TIME_FIELD_SECOND = "second";
	public static final String TIME_FIELD_TIMEZONE = "timezone";
	public static final String SHAREDUUI_FIELD_ID = "id";
	public static final String SHAREDUUI_FIELD_VALUE = "value";
	public static final String DM__PROPERTIES__LOCATION_FIELD_ENGLISH = "ENGLISH";
	public static final String DM__PROPERTIES__LOCATION_FIELD_HINDI = "HINDI";
	public static final String DM__PROPERTIES__LOCATION_FIELD_MARATHI = "MARATHI";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_CONFIDENCE = "Confidence";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_DIALOG_NAME = "DialogName";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_INPUT_TYPE = "InputType";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_MENU_ID = "MenuID";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_RETURN_CODE = "ReturnCode";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_UTTERANCE = "Utterance";
	public static final String BUSINESS_HOUR_ANN__PP_FIELD_VALUE = "Value";
	public static final String MAIN_MENU__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String MAIN_MENU__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String MAIN_MENU__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String MAIN_MENU__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String MAIN_MENU__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String MAIN_MENU__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String MAIN_MENU__MN_FIELD_MENU_ID = "MenuID";
	public static final String MAIN_MENU__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String MAIN_MENU__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String MAIN_MENU__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String MAIN_MENU__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String MAIN_MENU__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String MAIN_MENU__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String MAIN_MENU__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String MAIN_MENU__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String MAIN_MENU__MN_FIELD_UTTERANCE = "Utterance";
	public static final String MAIN_MENU__MN_FIELD_VALUE = "Value";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_MENU_ID = "MenuID";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_UTTERANCE = "Utterance";
	public static final String TICKET_RELATED_ENQUIRY__MN_FIELD_VALUE = "Value";
	public static final String APP_VARIABLES_FIELD_APP_NAME = "appName";
	public static final String APP_VARIABLES_FIELD_CIRCLE = "circle";
	public static final String APP_VARIABLES_FIELD_DB_RESPONSE = "dbResponse";
	public static final String APP_VARIABLES_FIELD_IS_EXCEPTION = "isException";
	public static final String APP_VARIABLES_FIELD_LANGUAGE = "language";
	public static final String APP_VARIABLES_FIELD_TRANSFER_POINT = "transferPoint";
	public static final String APP_VARIABLES_FIELD_TRANSFER_VDN = "transferVDN";
	public static final String APP_VARIABLES_FIELD_UUI_DATA = "uuiData";
	public static final String CONSTANTS_FIELD_ENQUIRY__MN__RET_VAL__REP = "Enquiry_MN_RetVal_Rep";
	public static final String CONSTANTS_FIELD_ENQUIRY__MN__RET_VAL__TICKET_FARES = "Enquiry_MN_RetVal_TicketFares";
	public static final String CONSTANTS_FIELD_ENQUIRY__MN__RET_VAL__TICKET_RELATED_ENQUIRY = "Enquiry_MN_RetVal_TicketRelatedEnquiry";
	public static final String CONSTANTS_FIELD_ENQUIRY__MN__RET_VAL__TRAIN_SCHEDULE = "Enquiry_MN_RetVal_TrainSchedule";
	public static final String CONSTANTS_FIELD_IS_CALLED_WITHIN_BUSINESS_HOUR = "IsCalledWithinBusinessHour";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__COMPLAINT = "MainMenu_MN_RetVal_Complaint";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__EMERGENCY = "MainMenu_MN_RetVal_Emergency";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__ENQUIRY = "MainMenu_MN_RetVal_Enquiry";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__FEEDBACK = "MainMenu_MN_RetVal_Feedback";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__LOST = "MainMenu_MN_RetVal_Lost";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__REP = "MainMenu_MN_RetVal_Rep";
	public static final String CONSTANTS_FIELD_MAIN_MENU__MN__RET_VAL__RETAIL = "MainMenu_MN_RetVal_Retail";
	public static final String CONSTANTS_FIELD_SELECT_LANG__MN__RET_VAL__ENGLISH = "SelectLang_MN_RetVal_English";
	public static final String CONSTANTS_FIELD_SELECT_LANG__MN__RET_VAL__HINDI = "SelectLang_MN_RetVal_Hindi";
	public static final String CONSTANTS_FIELD_SELECT_LANG__MN__RET_VAL__MARATHI = "SelectLang_MN_RetVal_Marathi";
	public static final String CONSTANTS_FIELD_SUCCESS = "SUCCESS";
	public static final String CONSTANTS_FIELD_TRE__MN__RET_VAL__OTHER_ENQUIRIES = "TRE_MN_RetVal_OtherEnquiries";
	public static final String CONSTANTS_FIELD_TRE__MN__RET_VAL__PROMOTIONS = "TRE_MN_RetVal_Promotions";
	public static final String CONSTANTS_FIELD_TRE__MN__RET_VAL__SMART_CARD_INFO = "TRE_MN_RetVal_SmartCardInfo";
	public static final String CONSTANTS_FIELD_TRE__MN__RET_VAL__SMART_CARD_PERSONALIZATION = "TRE_MN_RetVal_SmartCardPersonalization";
	public static final String CONSTANTS_FIELD_TRE__MN__RET_VAL__TRAVEL_TOKEN = "TRE_MN_RetVal_TravelToken";
	public static final String CONSTANTS_FIELD_TRUE = "TRUE";
	public static final String CONSTANTS_FIELD_YES = "Yes";
	public static final String LANGUAGES_FIELD_ENGLISH = "ENGLISH";
	public static final String LANGUAGES_FIELD_HINDI = "HINDI";
	public static final String LANGUAGES_FIELD_MARATHI = "MARATHI";
	public static final String SELECT_LANG__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String SELECT_LANG__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String SELECT_LANG__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String SELECT_LANG__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String SELECT_LANG__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String SELECT_LANG__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String SELECT_LANG__MN_FIELD_MENU_ID = "MenuID";
	public static final String SELECT_LANG__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String SELECT_LANG__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String SELECT_LANG__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String SELECT_LANG__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String SELECT_LANG__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String SELECT_LANG__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String SELECT_LANG__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String SELECT_LANG__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String SELECT_LANG__MN_FIELD_UTTERANCE = "Utterance";
	public static final String SELECT_LANG__MN_FIELD_VALUE = "Value";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String DM__INPUT_FIELD_DM__GLOBAL_PROPERTY_FILE_NAME = "DM_globalPropertyFileName";
	public static final String DM__INPUT_FIELD_DM__INITIAL_PROMPT = "DM_initialPrompt";
	public static final String DM__INPUT_FIELD_DM__PROPERTIES_LOCATION = "DM_propertiesLocation";
	public static final String DM__INPUT_FIELD_DM__RE_PROMPT_NO_INPUT = "DM_rePromptNoInput";
	public static final String DM__INPUT_FIELD_DM__RE_PROMPT_NO_MATCH = "DM_rePromptNoMatch";
	public static final String TOKEN__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String TOKEN__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String TOKEN__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String TOKEN__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String TOKEN__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String TOKEN__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String TOKEN__MN_FIELD_MENU_ID = "MenuID";
	public static final String TOKEN__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String TOKEN__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String TOKEN__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String TOKEN__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String TOKEN__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String TOKEN__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String TOKEN__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String TOKEN__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String TOKEN__MN_FIELD_UTTERANCE = "Utterance";
	public static final String TOKEN__MN_FIELD_VALUE = "Value";
	public static final String SMART_CARD__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String SMART_CARD__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String SMART_CARD__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String SMART_CARD__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String SMART_CARD__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String SMART_CARD__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String SMART_CARD__MN_FIELD_MENU_ID = "MenuID";
	public static final String SMART_CARD__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String SMART_CARD__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String SMART_CARD__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String SMART_CARD__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String SMART_CARD__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String SMART_CARD__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String SMART_CARD__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String SMART_CARD__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String SMART_CARD__MN_FIELD_UTTERANCE = "Utterance";
	public static final String SMART_CARD__MN_FIELD_VALUE = "Value";
	public static final String TRAIN_SCHEDULE__MN_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String TRAIN_SCHEDULE__MN_FIELD_CONFIDENCE = "Confidence";
	public static final String TRAIN_SCHEDULE__MN_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String TRAIN_SCHEDULE__MN_FIELD_DIALOG_NAME = "DialogName";
	public static final String TRAIN_SCHEDULE__MN_FIELD_INPUT_TYPE = "InputType";
	public static final String TRAIN_SCHEDULE__MN_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String TRAIN_SCHEDULE__MN_FIELD_MENU_ID = "MenuID";
	public static final String TRAIN_SCHEDULE__MN_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String TRAIN_SCHEDULE__MN_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String TRAIN_SCHEDULE__MN_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String TRAIN_SCHEDULE__MN_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String TRAIN_SCHEDULE__MN_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String TRAIN_SCHEDULE__MN_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String TRAIN_SCHEDULE__MN_FIELD_RETURN_CODE = "ReturnCode";
	public static final String TRAIN_SCHEDULE__MN_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String TRAIN_SCHEDULE__MN_FIELD_UTTERANCE = "Utterance";
	public static final String TRAIN_SCHEDULE__MN_FIELD_VALUE = "Value";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_1 = "MIVR_TR_0001";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_2 = "MIVR_TR_0002";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_3 = "MIVR_TR_0003";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_4 = "MIVR_TR_0004";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_5 = "MIVR_TR_0005";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_6 = "MIVR_TR_0006";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_7 = "MIVR_TR_0007";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_8 = "MIVR_TR_0008";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_0_9 = "MIVR_TR_0009";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_0 = "MIVR_TR_0010";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_1 = "MIVR_TR_0011";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_2 = "MIVR_TR_0012";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_3 = "MIVR_TR_0013";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_4 = "MIVR_TR_0014";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_5 = "MIVR_TR_0015";
	public static final String TRANSFER_POINTS_FIELD_MIVR__TR___0_0_1_7 = "MIVR_TR_0017";
	//}}END:PROJECT:VARIABLEFIELDS
}