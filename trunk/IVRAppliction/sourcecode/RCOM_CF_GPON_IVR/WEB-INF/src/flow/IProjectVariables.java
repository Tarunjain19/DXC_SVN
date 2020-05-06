package flow;

/**
 * This interface is used to define the name of variables that are 
 * declared in the call flow.  All variables are defined as 
 * <code>public static final String</code>, which allows user-defined
 * code to reference variable names by the Java variable name.
 * Last generated by Orchestration Designer at: 2016-JAN-19  04:25:08 PM
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
	 * Last generated by Orchestration Designer at: 2017-JUL-27  12:38:47 PM
	 */
	public static final String DATE = "date";
	public static final String BLIND_TRANSFER = "blindTransfer";
	public static final String HOT_FLASH_IDS = "HotFlashIds";
	public static final String VAR__GPON = "VAR_GPON";
	public static final String TRANSFER_UUIDATA = "TransferUUIData";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String CALL_DATA = "CallData";
	public static final String VAR__LANG = "VAR_LANG";
	public static final String SESSION = "session";
	public static final String HOT_FLASH_INFO = "HotFlashInfo";
	public static final String APP_NAME = "appName";
	public static final String CONSTANTS = "Constants";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String VAR__CONFIG = "Var_Config";
	public static final String VAR__PHRASES = "Var_phrases";
	public static final String MNU__LANG_SELECTION = "Mnu_LangSelection";
	public static final String TIME = "time";
	public static final String SHAREDUUI = "shareduui";
	//}}END:PROJECT:VARIABLES
	//{{START:PROJECT:VARIABLEFIELDS
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String HOT_FLASH_IDS_FIELD_HF__PA___0_0_1 = "HF_PA_001";
	public static final String VAR__GPON_FIELD_IS_CALL_END_START = "isCallEndStart";
	public static final String VAR__GPON_FIELD_IS_TRANSFFERED = "isTransffered";
	public static final String VAR__GPON_FIELD_JAVA__ERROR = "JAVA_ERROR";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String CALL_DATA_FIELD_CALLER_PATH = "callerPath";
	public static final String CALL_DATA_FIELD_CIRCLE = "Circle";
	public static final String CALL_DATA_FIELD_CURRENT_LANG = "CurrentLang";
	public static final String CALL_DATA_FIELD_DEFAULT_LANG = "DefaultLang";
	public static final String CALL_DATA_FIELD_DTMF_PATH = "dtmfPath";
	public static final String CALL_DATA_FIELD_MENU_PATH = "menuPath";
	public static final String CALL_DATA_FIELD_TRANSFER_REASON_CODE = "transferReasonCode";
	public static final String CALL_DATA_FIELD_TRANSFER_VDN = "transferVDN";
	public static final String CALL_DATA_FIELD_UUIDATA = "UUIData";
	public static final String VAR__LANG_FIELD_ANN__LANG__OPTION___1 = "ann_lang_option_1";
	public static final String VAR__LANG_FIELD_ANN__LANG__OPTION___2 = "ann_lang_option_2";
	public static final String VAR__LANG_FIELD_ANN__LANG__OPTION___3 = "ann_lang_option_3";
	public static final String VAR__LANG_FIELD_ANN__LANG__OPTION___4 = "ann_lang_option_4";
	public static final String VAR__LANG_FIELD_LANG___1 = "lang_1";
	public static final String VAR__LANG_FIELD_LANG___2 = "lang_2";
	public static final String VAR__LANG_FIELD_LANG___3 = "lang_3";
	public static final String VAR__LANG_FIELD_NUMBER__WAVFILE__NAME = "number_wavfile_name";
	public static final String VAR__LANG_FIELD_PRESS___1 = "press_1";
	public static final String VAR__LANG_FIELD_PRESS___2 = "press_2";
	public static final String VAR__LANG_FIELD_PRESS___3 = "press_3";
	public static final String VAR__LANG_FIELD_PRESS___4 = "press_4";
	public static final String VAR__LANG_FIELD_PRESS__WAVFILE__NAME = "press_wavfile_name";
	public static final String VAR__LANG_FIELD_TOTAL__LANG = "total_lang";
	public static final String VAR__LANG_FIELD_WAVFILE__NAME = "wavfile_name";
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
	public static final String HOT_FLASH_INFO_FIELD_ANN_ID = "annID";
	public static final String HOT_FLASH_INFO_FIELD_CALLING_NODE_ID = "callingNodeId";
	public static final String HOT_FLASH_INFO_FIELD_FLAG = "Flag";
	public static final String HOT_FLASH_INFO_FIELD_PHRASE_ID = "phraseId";
	public static final String CONSTANTS_FIELD_TRUE = "TRUE";
	public static final String DD_LAST_EXCEPTION_FIELD_ERRORCODE = "errorcode";
	public static final String DD_LAST_EXCEPTION_FIELD_MESSAGE = "message";
	public static final String DD_LAST_EXCEPTION_FIELD_OBJECT = "object";
	public static final String DD_LAST_EXCEPTION_FIELD_STACKTRACE = "stacktrace";
	public static final String DD_LAST_EXCEPTION_FIELD_TYPE = "type";
	public static final String VAR__CONFIG_FIELD_CONFIG_FILE_PATH = "configFilePath";
	public static final String VAR__CONFIG_FIELD_MAX__INVALIDTRY = "max_invalidtry";
	public static final String VAR__CONFIG_FIELD_MAX__NOINPUT = "max_noinput";
	public static final String VAR__CONFIG_FIELD_MAX__NOMATCH = "max_nomatch";
	public static final String VAR__CONFIG_FIELD_MAX__TIMEOUT = "max_timeout";
	public static final String VAR__PHRASES_FIELD_STATIC__URL = "Static_URL";
	public static final String MNU__LANG_SELECTION_FIELD_CONFIDENCE = "confidence";
	public static final String MNU__LANG_SELECTION_FIELD_INPUTMODE = "inputmode";
	public static final String MNU__LANG_SELECTION_FIELD_INTERPRETATION = "interpretation";
	public static final String MNU__LANG_SELECTION_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String MNU__LANG_SELECTION_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String MNU__LANG_SELECTION_FIELD_UTTERANCE = "utterance";
	public static final String MNU__LANG_SELECTION_FIELD_VALUE = "value";
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
