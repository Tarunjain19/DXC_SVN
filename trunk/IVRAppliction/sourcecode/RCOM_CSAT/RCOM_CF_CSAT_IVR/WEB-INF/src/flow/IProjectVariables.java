package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 2015-APR-01  12:45:26 PM
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
	 * Last generated by Orchestration Designer at: 2016-APR-11  05:10:40 PM
	 */
	public static final String APP__NAME = "APP_NAME";
	public static final String APP__VARIABLES = "APP_VARIABLES";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String CSAT__MN___0_0_0_1 = "CSAT_MN_0001";
	public static final String CALLER_TYPE_FLAG = "callerTypeFlag";
	public static final String CALL_DATA = "CallData";
	public static final String SESSION = "session";
	public static final String POCINCVALUE = "pocincvalue";
	public static final String POCINCDOB = "pocincdob";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String TIME = "time";
	public static final String SHAREDUUI = "shareduui";
	public static final String UUIDATA = "UUIData";
	public static final String THANKYOU__CSAT__PA___0_0_0_3 = "Thankyou_CSAT_PA_0003";
	public static final String THANKYOU__CSAT__PA___0_0_0_2 = "Thankyou_CSAT_PA_0002";
	public static final String CONSTANTS = "Constants";
	public static final String WELCOME__CSAT__PA___0_0_0_1 = "Welcome_CSAT_PA_0001";
	public static final String CONSTANTS_COPY = "ConstantsCopy";
	public static final String DATE = "date";
	public static final String CONSTANT = "constant";
	public static final String FLAG = "Flag";
	public static final String DMPROPERTY = "DMProperty";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4 = "LinkDown_CSAT_PA_0004";
	//}}END:PROJECT:VARIABLES
	//{{START:PROJECT:VARIABLEFIELDS
	public static final String APP__VARIABLES_FIELD_ALT_MDN = "AltMdn";
	public static final String APP__VARIABLES_FIELD_ANI = "ANI";
	public static final String APP__VARIABLES_FIELD_ERROR__CODE = "ERROR_CODE";
	public static final String APP__VARIABLES_FIELD_UUIDNIS = "UUIDNIS";
	public static final String APP__VARIABLES_FIELD_WEB_RESPONCE = "WebResponce";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String CSAT__MN___0_0_0_1_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String CSAT__MN___0_0_0_1_FIELD_CONFIDENCE = "Confidence";
	public static final String CSAT__MN___0_0_0_1_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String CSAT__MN___0_0_0_1_FIELD_DIALOG_NAME = "DialogName";
	public static final String CSAT__MN___0_0_0_1_FIELD_INPUT_TYPE = "InputType";
	public static final String CSAT__MN___0_0_0_1_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String CSAT__MN___0_0_0_1_FIELD_MENU_ID = "MenuID";
	public static final String CSAT__MN___0_0_0_1_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String CSAT__MN___0_0_0_1_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String CSAT__MN___0_0_0_1_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String CSAT__MN___0_0_0_1_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String CSAT__MN___0_0_0_1_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String CSAT__MN___0_0_0_1_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String CSAT__MN___0_0_0_1_FIELD_RETURN_CODE = "ReturnCode";
	public static final String CSAT__MN___0_0_0_1_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String CSAT__MN___0_0_0_1_FIELD_UTTERANCE = "Utterance";
	public static final String CSAT__MN___0_0_0_1_FIELD_VALUE = "Value";
	public static final String CALL_DATA_FIELD_APPLICATION_NAME = "applicationName";
	public static final String CALL_DATA_FIELD_CALLER_TYPE = "callerType";
	public static final String CALL_DATA_FIELD_CIRCLE = "circle";
	public static final String CALL_DATA_FIELD_DEFAULT_LANGUAGE = "defaultLanguage";
	public static final String CALL_DATA_FIELD_IS_DATA_CARD = "isDataCard";
	public static final String CALL_DATA_FIELD_IS_LINK_DOWN = "isLinkDown";
	public static final String CALL_DATA_FIELD_REGINAL_LANGUAGE = "reginalLanguage";
	public static final String CALL_DATA_FIELD_SERVICE__TYPE = "SERVICE_TYPE";
	public static final String CALL_DATA_FIELD_TRANSFER_REASON_CODE = "transferReasonCode";
	public static final String CALL_DATA_FIELD_TRANSFER_VDN = "transferVDN";
	public static final String CALL_DATA_FIELD_UUI_DATA = "uuiData";
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
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_CONFIDENCE = "Confidence";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_DIALOG_NAME = "DialogName";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_INPUT_TYPE = "InputType";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_MENU_ID = "MenuID";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_RETURN_CODE = "ReturnCode";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_UTTERANCE = "Utterance";
	public static final String THANKYOU__CSAT__PA___0_0_0_3_FIELD_VALUE = "Value";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_CONFIDENCE = "Confidence";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_DIALOG_NAME = "DialogName";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_INPUT_TYPE = "InputType";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_MENU_ID = "MenuID";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_RETURN_CODE = "ReturnCode";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_UTTERANCE = "Utterance";
	public static final String THANKYOU__CSAT__PA___0_0_0_2_FIELD_VALUE = "Value";
	public static final String CONSTANTS_FIELD_ENG = "ENG";
	public static final String CONSTANTS_FIELD_HIN = "HIN";
	public static final String CONSTANTS_FIELD_ONE = "one";
	public static final String CONSTANTS_FIELD_SUCCESS = "success";
	public static final String CONSTANTS_FIELD_TWO = "two";
	public static final String CONSTANTS_FIELD_YES = "yes";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_CONFIDENCE = "Confidence";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_DIALOG_NAME = "DialogName";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_INPUT_TYPE = "InputType";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_MENU_ID = "MenuID";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_RETURN_CODE = "ReturnCode";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_UTTERANCE = "Utterance";
	public static final String WELCOME__CSAT__PA___0_0_0_1_FIELD_VALUE = "Value";
	public static final String CONSTANTS_COPY_FIELD_DELIVERED = "Delivered";
	public static final String CONSTANTS_COPY_FIELD_EIGHT = "eight";
	public static final String CONSTANTS_COPY_FIELD_FAILURE = "failure";
	public static final String CONSTANTS_COPY_FIELD_FEATURE_LEVEL = "FeatureLevel";
	public static final String CONSTANTS_COPY_FIELD_FIVE = "five";
	public static final String CONSTANTS_COPY_FIELD_FOUR = "four";
	public static final String CONSTANTS_COPY_FIELD_HASH = "hash";
	public static final String CONSTANTS_COPY_FIELD_MENU_LEVEL = "MenuLevel";
	public static final String CONSTANTS_COPY_FIELD_MENU_REPEAT = "MenuRepeat";
	public static final String CONSTANTS_COPY_FIELD_NA = "NA";
	public static final String CONSTANTS_COPY_FIELD_NINE = "nine";
	public static final String CONSTANTS_COPY_FIELD_NO = "no";
	public static final String CONSTANTS_COPY_FIELD_ONE = "one";
	public static final String CONSTANTS_COPY_FIELD_PA___0_0_0_6 = "PA_0006";
	public static final String CONSTANTS_COPY_FIELD_PA___0_1_0_2 = "PA_0102";
	public static final String CONSTANTS_COPY_FIELD_POSTPAID = "postpaid";
	public static final String CONSTANTS_COPY_FIELD_PREPAID = "prepaid";
	public static final String CONSTANTS_COPY_FIELD_SEVEN = "seven";
	public static final String CONSTANTS_COPY_FIELD_SIX = "six";
	public static final String CONSTANTS_COPY_FIELD_STAR = "star";
	public static final String CONSTANTS_COPY_FIELD_SUCCESS = "success";
	public static final String CONSTANTS_COPY_FIELD_THREE = "three";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_1 = "TR_0001";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_2 = "TR_0002";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_3 = "TR_0003";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_4 = "TR_0004";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_5 = "TR_0005";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_6 = "TR_0006";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_7 = "TR_0007";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_0_9 = "TR_0009";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_1_6 = "TR_0016";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_2_2 = "TR_0022";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_2_3 = "TR_0023";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_2_6 = "TR_0026";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_2_7 = "TR_0027";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_2_8 = "TR_0028";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_3_2 = "TR_0032";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_3_4 = "TR_0034";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_3_5 = "TR_0035";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_3_8 = "TR_0038";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_3_9 = "TR_0039";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_0 = "TR_0040";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_1 = "TR_0041";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_2 = "TR_0042";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_3 = "TR_0043";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_4 = "TR_0044";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_6 = "TR_0046";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_7 = "TR_0047";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_4_8 = "TR_0048";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_5_2 = "TR_0052";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_5_3 = "TR_0053";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_5_4 = "TR_0054";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_5_5 = "TR_0055";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_5_6 = "TR_0056";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_7_2 = "TR_0072";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_7_3 = "TR_0073";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_7_8 = "TR_0078";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_7_9 = "TR_0079";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_8_0 = "TR_0080";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_8_1 = "TR_0081";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_8_6 = "TR_0086";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_8_9 = "TR_0089";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_9_1 = "TR_0091";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_9_2 = "TR_0092";
	public static final String CONSTANTS_COPY_FIELD_TR___0_0_9_3 = "TR_0093";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_0_1 = "TR_0101";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_0_2 = "TR_0102";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_0_3 = "TR_0103";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_0_4 = "TR_0104";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_1_6 = "TR_0116";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_1_7 = "TR_0117";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_1_8 = "TR_0118";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_1_9 = "TR_0119";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_2_3 = "TR_0123";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_2_5 = "TR_0125";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_2_7 = "TR_0127";
	public static final String CONSTANTS_COPY_FIELD_TR___0_1_3_0 = "TR_0130";
	public static final String CONSTANTS_COPY_FIELD_TWO = "two";
	public static final String CONSTANTS_COPY_FIELD_UNTITLED_9 = "untitled9";
	public static final String CONSTANTS_COPY_FIELD_YES = "yes";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String CONSTANT_FIELD_CHANNEL_SUPPORT = "ChannelSupport";
	public static final String CONSTANT_FIELD_ENG_CONFIG_PATH = "EngConfigPath";
	public static final String CONSTANT_FIELD_HIN_CONFIG_PATH = "HinConfigPath";
	public static final String CONSTANT_FIELD_INVALID = "invalid";
	public static final String CONSTANT_FIELD_KEY__TRUE = "Key_true";
	public static final String CONSTANT_FIELD_NO = "No";
	public static final String CONSTANT_FIELD_SUCCESS = "success";
	public static final String CONSTANT_FIELD_THREE = "three";
	public static final String CONSTANT_FIELD_VALID = "valid";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_1 = "WHIVR_TR_0001";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_2 = "WHIVR_TR_0002";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_3 = "WHIVR_TR_0003";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_4 = "WHIVR_TR_0004";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_5 = "WHIVR_TR_0005";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_6 = "WHIVR_TR_0006";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_7 = "WHIVR_TR_0007";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_8 = "WHIVR_TR_0008";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_0_9 = "WHIVR_TR_0009";
	public static final String CONSTANT_FIELD_WHIVR__TR___0_0_1_0 = "WHIVR_TR_0010";
	public static final String CONSTANT_FIELD_YES = "yes";
	public static final String FLAG_FIELD_ACCOUNT_INFORMATION = "accountInformation";
	public static final String FLAG_FIELD_ARRAY_COUNT = "ArrayCount";
	public static final String FLAG_FIELD_ARRAY_VALUE = "ArrayValue";
	public static final String FLAG_FIELD_END_ARRAY = "EndArray";
	public static final String FLAG_FIELD_INITAL_ARRAY = "InitalArray";
	public static final String FLAG_FIELD_IS_CALL_LOOPED = "isCallLooped";
	public static final String FLAG_FIELD_IS_DNCDEREGISTRATION_DONE = "isDNCDeregistrationDone";
	public static final String FLAG_FIELD_IS_DNCREGISTRATION_DONE = "isDNCRegistrationDone";
	public static final String FLAG_FIELD_IS_DOBTODAY = "isDOBToday";
	public static final String FLAG_FIELD_IS_FROM_EVENT_BASED = "isFromEventBased";
	public static final String FLAG_FIELD_IS_FROM_ILDACTIVATION = "isFromILDActivation";
	public static final String FLAG_FIELD_IS_FROM_INTERACTION_HISTORY = "isFromInteractionHistory";
	public static final String FLAG_FIELD_IS_HOST_FAILURE = "isHostFailure";
	public static final String FLAG_FIELD_IS_HOT_FLASH_ACTIVE = "isHotFlashActive";
	public static final String FLAG_FIELD_IS_INTELLIGENT_LAYER_ENABLED = "isIntelligentLayerEnabled";
	public static final String FLAG_FIELD_IS_LINK_DOWN = "isLinkDown";
	public static final String FLAG_FIELD_IS_MAX_DATA_CONSUMED = "isMaxDataConsumed";
	public static final String FLAG_FIELD_IS_MORE_QUESTION = "isMoreQuestion";
	public static final String FLAG_FIELD_IS_PAYMENT_ENABLED = "isPaymentEnabled";
	public static final String FLAG_FIELD_IS_PTPSRPRESENT = "isPTPSRPResent";
	public static final String FLAG_FIELD_IS_SLADATE_VALID = "isSLADateValid";
	public static final String FLAG_FIELD_IS_TOTAL_EXPOSURE_VALID = "isTotalExposureValid";
	public static final String FLAG_FIELD_IS_VASSUCCESSFUL = "isVASSuccessful";
	public static final String FLAG_FIELD_PTP_FLAG = "ptpFlag";
	public static final String FLAG_FIELD_TRANSFER_CALL_BACK__POS = "TransferCallBack_Pos";
	public static final String FLAG_FIELD_TRANSFER_CALL_BACK__PRE = "TransferCallBack_Pre";
	public static final String FLAG_FIELD_UDATA_FAIL = "UdataFail";
	public static final String DMPROPERTY_FIELD_ASS__CONFIG_FILE_PATH = "ASS_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_BEN__CONFIG_FILE_PATH = "BEN_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_CONFIG_FILE_PATH = "ConfigFilePath";
	public static final String DMPROPERTY_FIELD_CSAT__MN___0_0_0_1 = "CSAT_MN_0001";
	public static final String DMPROPERTY_FIELD_CSAT__MN___0_0_0_2 = "CSAT_MN_0002";
	public static final String DMPROPERTY_FIELD_CSAT__MN___0_0_0_3 = "CSAT_MN_0003";
	public static final String DMPROPERTY_FIELD_DIALOG_NAME = "DialogName";
	public static final String DMPROPERTY_FIELD_ENG__CONFIG_FILE_PATH = "ENG_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_GLOBAL = "global";
	public static final String DMPROPERTY_FIELD_GUJ__CONFIG_FILE_PATH = "GUJ_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_HIN__CONFIG_FILE_PATH = "HIN_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_INITIAL_PROMPT = "initialPrompt";
	public static final String DMPROPERTY_FIELD_KAN__CONFIG_FILE_PATH = "KAN_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_LINK_DOWN__CSAT__PA___0_0_4 = "LinkDown_CSAT_PA_004";
	public static final String DMPROPERTY_FIELD_MAL__CONFIG_FILE_PATH = "MAL_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_MAR__CONFIG_FILE_PATH = "MAR_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_MENU_OPTION = "menuOption";
	public static final String DMPROPERTY_FIELD_MENU_OPTION_COUNT = "menuOptionCount";
	public static final String DMPROPERTY_FIELD_ORI__CONFIG_FILE_PATH = "ORI_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_PUN__CONFIG_FILE_PATH = "PUN_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_TAM__CONFIG_FILE_PATH = "TAM_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_TEL__CONFIG_FILE_PATH = "TEL_ConfigFilePath";
	public static final String DMPROPERTY_FIELD_THANKYOU__CSAT__PA___0_0_0_3 = "Thankyou_CSAT_PA_0003";
	public static final String DMPROPERTY_FIELD_WELCOME__CSAT__PA___0_0_0_1 = "Welcome_CSAT_PA_0001";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_ANNOUNCE_ID = "AnnounceID";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_CONFIDENCE = "Confidence";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_CONFIRMATION_REMAINING = "ConfirmationRemaining";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_DIALOG_NAME = "DialogName";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_INPUT_TYPE = "InputType";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_MENU_ID = "MenuID";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_NOINPUT_REMAINING = "NoinputRemaining";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_NOMATCH_REMAINING = "NomatchRemaining";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_OTHER_SLOT = "OtherSlot";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_RECORDED__UTTERANCE = "Recorded_Utterance";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_RETURN_CODE = "ReturnCode";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_SPECIFIC_SLOT = "SpecificSlot";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_UTTERANCE = "Utterance";
	public static final String LINK_DOWN__CSAT__PA___0_0_0_4_FIELD_VALUE = "Value";
	//}}END:PROJECT:VARIABLEFIELDS
}