package flow;

/**
 * This interface is used to define the name of variables that are declared in
 * the call flow. All variables are defined as
 * <code>public static final String</code>, which allows user-defined code to
 * reference variable names by the Java variable name. Last generated by
 * Orchestration Designer at: 2013-OCT-03 11:45:23 AM
 */
public interface IProjectVariables {

	//{{START:PROJECT:VARIABLEFIELDS
	public static final String TIME_FIELD_AUDIO = "audio";
	public static final String TIME_FIELD_HOUR = "hour";
	public static final String TIME_FIELD_MILLISECOND = "millisecond";
	public static final String TIME_FIELD_MINUTE = "minute";
	public static final String TIME_FIELD_SECOND = "second";
	public static final String TIME_FIELD_TIMEZONE = "timezone";
	public static final String INPUT_VARIABLES_FIELD_ALWAYS_MORE_OPTION_FLAG = "alwaysMoreOptionFlag";
	public static final String INPUT_VARIABLES_FIELD_ANNOUNCE_ID = "announceID";
	public static final String INPUT_VARIABLES_FIELD_AUDIO_LOCATION = "audioLocation";
	public static final String INPUT_VARIABLES_FIELD_BARGE_IN = "bargeIn";
	public static final String INPUT_VARIABLES_FIELD_BARGE_IN_TYPE = "bargeInType";
	public static final String INPUT_VARIABLES_FIELD_BUILT_IN_GRAMMAR = "builtInGrammar";
	public static final String INPUT_VARIABLES_FIELD_BUILT_IN_GRAMMAR_FLAG = "builtInGrammarFlag";
	public static final String INPUT_VARIABLES_FIELD_CHECK_CONSECUTIVE_FLAG = "checkConsecutiveFlag";
	public static final String INPUT_VARIABLES_FIELD_COMPLETE_TIMEOUT = "completeTimeout";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_DEFAULT_PROMPT = "confirmationDefaultPrompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_DTMF_GRAMMAR = "confirmationDtmfGrammar";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_LIMIT_PROMPT = "confirmationLimitPrompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_MAX_COUNT = "confirmationMaxCount";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_MODE = "confirmationMode";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_NO_INPUT_PROMPT = "confirmationNoInputPrompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_NO_MATCH_PROMPT = "confirmationNoMatchPrompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_REPROMPT = "confirmationReprompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_SPECIFIC_PROMPT = "confirmationSpecificPrompt";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_VALUE_FLAG = "confirmationValueFlag";
	public static final String INPUT_VARIABLES_FIELD_CONFIRMATION_VOICE_GRAMMAR = "confirmationVoiceGrammar";
	public static final String INPUT_VARIABLES_FIELD_CONSTRAINT_LIST = "constraintList";
	public static final String INPUT_VARIABLES_FIELD_CONSTRAINT_LIST_PROMPTS = "ConstraintListPrompts";
	public static final String INPUT_VARIABLES_FIELD_CURRENCY_FORMAT = "currencyFormat";
	public static final String INPUT_VARIABLES_FIELD_CURRENCY_FORMAT_VALUES = "currencyFormatValues";
	public static final String INPUT_VARIABLES_FIELD_DATE_FORMAT = "dateFormat";
	public static final String INPUT_VARIABLES_FIELD_DATE_FORMAT_VALUES = "dateFormatValues";
	public static final String INPUT_VARIABLES_FIELD_DIALOG_NAME = "dialogName";
	public static final String INPUT_VARIABLES_FIELD_DIGITS_FORMAT = "digitsFormat";
	public static final String INPUT_VARIABLES_FIELD_DIGITS_FORMAT_VALUES = "digitsFormatValues";
	public static final String INPUT_VARIABLES_FIELD_DISALLOW_LIST = "disallowList";
	public static final String INPUT_VARIABLES_FIELD_DTMF_GLOBAL_GRAMMAR = "dtmfGlobalGrammar";
	public static final String INPUT_VARIABLES_FIELD_DTMF_GRAMMAR = "dtmfGrammar";
	public static final String INPUT_VARIABLES_FIELD_DTMF_GRAMMARS_USE_SLOTS = "dtmfGrammarsUseSlots";
	public static final String INPUT_VARIABLES_FIELD_GLOBAL_PROMPT = "globalPrompt";
	public static final String INPUT_VARIABLES_FIELD_GLOBAL_PROPERTIES = "globalProperties";
	public static final String INPUT_VARIABLES_FIELD_GRAMMAR_LOCATION = "grammarLocation";
	public static final String INPUT_VARIABLES_FIELD_HELP_PROMPT = "helpPrompt";
	public static final String INPUT_VARIABLES_FIELD_HIGH_CONFIDENCE_LEVEL = "highConfidenceLevel";
	public static final String INPUT_VARIABLES_FIELD_INCOMPLETE_TIMEOUT = "incompleteTimeout";
	public static final String INPUT_VARIABLES_FIELD_INITIAL_PROMPT = "initialPrompt";
	public static final String INPUT_VARIABLES_FIELD_INTERDIGIT_TIMEOUT = "interdigitTimeout";
	public static final String INPUT_VARIABLES_FIELD_IS_ANNOUNCEMENT = "isAnnouncement";
	public static final String INPUT_VARIABLES_FIELD_IS_DTMF = "isDTMF";
	public static final String INPUT_VARIABLES_FIELD_IS_TRANSACTION_AUDIO = "isTransactionAudio";
	public static final String INPUT_VARIABLES_FIELD_LANGUAGE = "language";
	public static final String INPUT_VARIABLES_FIELD_LOGGER_NAME = "loggerName";
	public static final String INPUT_VARIABLES_FIELD_LOGGING_ENABLED = "loggingEnabled";
	public static final String INPUT_VARIABLES_FIELD_LOW_CONFIDENCE_LEVEL = "lowConfidenceLevel";
	public static final String INPUT_VARIABLES_FIELD_MANAGE_REPEAT = "manageRepeat";
	public static final String INPUT_VARIABLES_FIELD_MAX_NO_INPUT_COUNT = "maxNoInputCount";
	public static final String INPUT_VARIABLES_FIELD_MAX_NO_MATCH_COUNT = "maxNoMatchCount";
	public static final String INPUT_VARIABLES_FIELD_MEDIA_TYPE_DTMF = "mediaTypeDTMF";
	public static final String INPUT_VARIABLES_FIELD_MEDIA_TYPE_VOICE = "mediaTypeVoice";
	public static final String INPUT_VARIABLES_FIELD_MENU_ID = "menuID";
	public static final String INPUT_VARIABLES_FIELD_MENU_OPTIONS = "menuOptions";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_COUNT = "moreOptionCount";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_DTMFGRAMMAR = "moreOptionDTMFGrammar";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_DYNAMIC_VALUES = "moreOptionDynamicValues";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_FLAG = "moreOptionFlag";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_PREVIOUS_MENU_FLAG = "moreOptionPreviousMenuFlag";
	public static final String INPUT_VARIABLES_FIELD_MORE_OPTION_VOICE_GRAMMAR = "moreOptionVoiceGrammar";
	public static final String INPUT_VARIABLES_FIELD_N_BEST = "nBest";
	public static final String INPUT_VARIABLES_FIELD_NINMCOMMON_COUNTER_FLAG = "NINMCommonCounterFlag";
	public static final String INPUT_VARIABLES_FIELD_NINMCOUNTER = "NINMCounter";
	public static final String INPUT_VARIABLES_FIELD_NO_ANSWER_APOLOGIES = "noAnswerApologies";
	public static final String INPUT_VARIABLES_FIELD_NO_ANSWER_APOLOGIES_RANDOM = "noAnswerApologiesRandom";
	public static final String INPUT_VARIABLES_FIELD_NO_ANSWER_LIMIT_PROMPT = "noAnswerLimitPrompt";
	public static final String INPUT_VARIABLES_FIELD_NO_ANSWER_MAX_COUNT = "noAnswerMaxCount";
	public static final String INPUT_VARIABLES_FIELD_NO_INPUT_LIMIT_PROMPT = "noInputLimitPrompt";
	public static final String INPUT_VARIABLES_FIELD_NO_INPUT_PROMPT = "noInputPrompt";
	public static final String INPUT_VARIABLES_FIELD_NO_INPUT_RANDOM = "noInputRandom";
	public static final String INPUT_VARIABLES_FIELD_NO_MATCH_LIMIT_PROMPT = "noMatchLimitPrompt";
	public static final String INPUT_VARIABLES_FIELD_NO_MATCH_PROMPT = "noMatchPrompt";
	public static final String INPUT_VARIABLES_FIELD_NO_MATCH_RANDOM = "noMatchRandom";
	public static final String INPUT_VARIABLES_FIELD_NUMBER_FORMAT = "numberFormat";
	public static final String INPUT_VARIABLES_FIELD_NUMBER_FORMAT_VALUES = "numberFormatValues";
	public static final String INPUT_VARIABLES_FIELD_ONE_TIME_FLAG = "oneTimeFlag";
	public static final String INPUT_VARIABLES_FIELD_PRIVATE_DATA = "privateData";
	public static final String INPUT_VARIABLES_FIELD_PROPERTIES_FILE = "propertiesFile";
	public static final String INPUT_VARIABLES_FIELD_PROPERTIES_LOCATION = "propertiesLocation";
	public static final String INPUT_VARIABLES_FIELD_RECORD_UTTERANCE = "recordUtterance";
	public static final String INPUT_VARIABLES_FIELD_RE_ENTRY = "reEntry";
	public static final String INPUT_VARIABLES_FIELD_REPEAT_COUNT = "repeatCount";
	public static final String INPUT_VARIABLES_FIELD_REPEAT_MAX_TRY_PROMPT = "repeatMaxTryPrompt";
	public static final String INPUT_VARIABLES_FIELD_REPEAT_PROMPT = "repeatPrompt";
	public static final String INPUT_VARIABLES_FIELD_REPORT__CLASS_NAME = "report_ClassName";
	public static final String INPUT_VARIABLES_FIELD_REPORT__METHOD_NAME = "report_MethodName";
	public static final String INPUT_VARIABLES_FIELD_REPORT_ENABLED = "reportEnabled";
	public static final String INPUT_VARIABLES_FIELD_REPORT_XMLENABLE = "reportXMLEnable";
	public static final String INPUT_VARIABLES_FIELD_RE_PROMPT_NO_INPUT = "rePromptNoInput";
	public static final String INPUT_VARIABLES_FIELD_RE_PROMPT_NO_MATCH = "rePromptNoMatch";
	public static final String INPUT_VARIABLES_FIELD_SPECIFIC_SLOTS = "specificSlots";
	public static final String INPUT_VARIABLES_FIELD_STANDARD_AUDIO_LOCATION = "standardAudioLocation";
	public static final String INPUT_VARIABLES_FIELD_SUCCESS_PROMPT = "successPrompt";
	public static final String INPUT_VARIABLES_FIELD_SUCCESS_PROMPT_ONLY_FOR_CONFIRMATION = "successPromptOnlyForConfirmation";
	public static final String INPUT_VARIABLES_FIELD_TERMINATING_CHAR = "terminatingChar";
	public static final String INPUT_VARIABLES_FIELD_TERMINATING_TIMEOUT = "terminatingTimeout";
	public static final String INPUT_VARIABLES_FIELD_TIME_FORMAT = "timeFormat";
	public static final String INPUT_VARIABLES_FIELD_TIME_FORMAT_VALUES = "timeFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TIMEOUT = "timeout";
	public static final String INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT = "ttsAddressFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_ADDRESS_FORMAT_VALUES = "ttsAddressFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_CURRENCY_FORMAT = "ttsCurrencyFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_CURRENCY_FORMAT_VALUES = "ttsCurrencyFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT = "ttsDateFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_DATE_FORMAT_VALUES = "ttsDateFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT = "ttsDigitsFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_DIGITS_FORMAT_VALUES = "ttsDigitsFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT = "ttsNameFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_NAME_FORMAT_VALUES = "ttsNameFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT = "ttsNumberFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_NUMBER_FORMAT_VALUES = "ttsNumberFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT = "ttsTelephoneFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_TELEPHONE_FORMAT_VALUES = "ttsTelephoneFormatValues";
	public static final String INPUT_VARIABLES_FIELD_TTS_TIME_FORMAT = "ttsTimeFormat";
	public static final String INPUT_VARIABLES_FIELD_TTS_TIME_FORMAT_VALUES = "ttsTimeFormatValues";
	public static final String INPUT_VARIABLES_FIELD_VOICE_GLOBAL_GRAMMAR = "voiceGlobalGrammar";
	public static final String INPUT_VARIABLES_FIELD_VOICE_GRAMMAR = "voiceGrammar";
	public static final String DATE_FIELD_AUDIO = "audio";
	public static final String DATE_FIELD_DAYOFMONTH = "dayofmonth";
	public static final String DATE_FIELD_DAYOFWEEK = "dayofweek";
	public static final String DATE_FIELD_DAYOFWEEKNUM = "dayofweeknum";
	public static final String DATE_FIELD_DAYOFYEAR = "dayofyear";
	public static final String DATE_FIELD_MONTH = "month";
	public static final String DATE_FIELD_MONTHINYEAR = "monthinyear";
	public static final String DATE_FIELD_YEAR = "year";
	public static final String FLAGS_FIELD_CONFIRMATION_MODE = "ConfirmationMode";
	public static final String FLAGS_FIELD_DIALOG_NAME__ERROR = "DialogName_Error";
	public static final String FLAGS_FIELD_IS_CONSECUTIVE_NUMBER = "isConsecutiveNumber";
	public static final String FLAGS_FIELD_MAXTRY = "MAXTRY";
	public static final String FLAGS_FIELD_MORE_OPTION_LAST_SET_FLAG = "moreOptionLastSetFlag";
	public static final String FLAGS_FIELD_MORE_OPTION_PREVIOUS_SET_FLAG = "moreOptionPreviousSetFlag";
	public static final String FLAGS_FIELD_NI = "NI";
	public static final String FLAGS_FIELD_NM = "NM";
	public static final String FLAGS_FIELD_TRIESEXCEEDED = "TRIESEXCEEDED";
	public static final String FLAGS_FIELD_UNIQUE_CONS_COUNTER_FLAG = "UniqueConsCounterFlag";
	public static final String IDM__VARIABLES_FIELD_CONSTRAINTCOUNT = "constraintcount";
	public static final String IDM__VARIABLES_FIELD_COUNT = "count";
	public static final String IDM__VARIABLES_FIELD_COUNT_CONFIRMATION = "countConfirmation";
	public static final String IDM__VARIABLES_FIELD_COUNTRETRYCONFIRMATION = "countretryconfirmation";
	public static final String IDM__VARIABLES_FIELD_DYNAMIC_COLLECTION_LENGTH = "dynamicCollectionLength";
	public static final String IDM__VARIABLES_FIELD_DYNAMIC_VALUE_LENGTH = "dynamicValueLength";
	public static final String IDM__VARIABLES_FIELD_DYNM_DTMFGRAM = "DynmDTMFGram";
	public static final String IDM__VARIABLES_FIELD_DYNM_VOICE_GRAM = "DynmVoiceGram";
	public static final String IDM__VARIABLES_FIELD_FIRSTCONFIRMATIONATTEMPT = "firstconfirmationattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTDYNAMICCONSTRIANTATTEMPT = "firstdynamicconstriantattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTINITIALATTEMPT = "firstinitialattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTNOINPUTATTEMPT = "firstnoinputattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTNOINPUTREPROMPTATTEMPT = "firstnoinputrepromptattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTNOMATCHATTEMPT = "firstnomatchattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTNOMATCHREPROMPTATTEMPT = "firstnomatchrepromptattempt";
	public static final String IDM__VARIABLES_FIELD_FIRSTRETRY = "firstretry";
	public static final String IDM__VARIABLES_FIELD_GLOBAL_COUNT = "globalCount";
	public static final String IDM__VARIABLES_FIELD_MORE_OPTION_COUNT = "moreOptionCount";
	public static final String IDM__VARIABLES_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String IDM__VARIABLES_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String IDM__VARIABLES_FIELD_REPEAT_COUNT = "repeatCount";
	public static final String IDM__VARIABLES_FIELD_REPROMPTACTIVE = "repromptactive";
	public static final String IDM__VARIABLES_FIELD_RETRYCONFIRMATION = "retryconfirmation";
	public static final String SHAREDUUI_FIELD_ID = "id";
	public static final String SHAREDUUI_FIELD_VALUE = "value";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_CONFIDENCE = "confidence";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_INPUTMODE = "inputmode";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_INTERPRETATION = "interpretation";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_OTHER__SLOT = "OTHER_SLOT";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_RESULT = "RESULT";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_UTTERANCE = "utterance";
	public static final String CONFIRMATIONRETURNVALUES_FIELD_VALUE = "value";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_COLUMN_0 = "Column0";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_CONFIDENCE = "confidence";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_INPUTMODE = "inputmode";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_INTERPRETATION = "interpretation";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_UTTERANCE = "utterance";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT_FIELD_VALUE = "value";
	public static final String PROMPT_AND_COLLECT_FIELD_CONFIDENCE = "confidence";
	public static final String PROMPT_AND_COLLECT_FIELD_CONFIRMATION__MODE = "CONFIRMATION_MODE";
	public static final String PROMPT_AND_COLLECT_FIELD_INPUTMODE = "inputmode";
	public static final String PROMPT_AND_COLLECT_FIELD_INTERPRETATION = "interpretation";
	public static final String PROMPT_AND_COLLECT_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String PROMPT_AND_COLLECT_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String PROMPT_AND_COLLECT_FIELD_OTHER__SLOT = "OTHER_SLOT";
	public static final String PROMPT_AND_COLLECT_FIELD_RECORDING = "recording";
	public static final String PROMPT_AND_COLLECT_FIELD_RECORDINGDURATION = "recordingduration";
	public static final String PROMPT_AND_COLLECT_FIELD_RECORDINGSIZE = "recordingsize";
	public static final String PROMPT_AND_COLLECT_FIELD_RESULT = "RESULT";
	public static final String PROMPT_AND_COLLECT_FIELD_UTTERANCE = "utterance";
	public static final String PROMPT_AND_COLLECT_FIELD_VALUE = "value";
	public static final String REDIRECTINFO_FIELD_PRESENTATIONINFO = "presentationinfo";
	public static final String REDIRECTINFO_FIELD_REASON = "reason";
	public static final String REDIRECTINFO_FIELD_SCREENINGINFO = "screeninginfo";
	public static final String REDIRECTINFO_FIELD_URI = "uri";
	public static final String SESSION_FIELD_AAI = "aai";
	public static final String SESSION_FIELD_ANI = "ani";
	public static final String SESSION_FIELD_CALLTAG = "calltag";
	public static final String SESSION_FIELD_CHANNEL = "channel";
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
	public static final String SESSION_FIELD_MESSAGE_TYPE = "messageType";
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
	public static final String CONSTANTS_FIELD_BUILTIN__BOOLEAN = "BUILTIN_BOOLEAN";
	public static final String CONSTANTS_FIELD_BUILTIN__NUMBER = "BUILTIN_NUMBER";
	public static final String CONSTANTS_FIELD_DTMF = "DTMF";
	public static final String CONSTANTS_FIELD_FAILURE = "FAILURE";
	public static final String CONSTANTS_FIELD_FALSE = "FALSE";
	public static final String CONSTANTS_FIELD_GLOBAL = "GLOBAL";
	public static final String CONSTANTS_FIELD_HELP = "HELP";
	public static final String CONSTANTS_FIELD_MORE = "MORE";
	public static final String CONSTANTS_FIELD_NO__CONFIRMATION__AUDIO = "NO_CONFIRMATION_AUDIO";
	public static final String CONSTANTS_FIELD_NOINPUT = "NOINPUT";
	public static final String CONSTANTS_FIELD_NOMATCH = "NOMATCH";
	public static final String CONSTANTS_FIELD_NONE = "NONE";
	public static final String CONSTANTS_FIELD_ONE = "ONE";
	public static final String CONSTANTS_FIELD_PREVIOUS = "PREVIOUS";
	public static final String CONSTANTS_FIELD_REPEAT = "REPEAT";
	public static final String CONSTANTS_FIELD_STAR = "STAR";
	public static final String CONSTANTS_FIELD_SUCCESS = "SUCCESS";
	public static final String CONSTANTS_FIELD_TRIESEXCEEDED = "TRIESEXCEEDED";
	public static final String CONSTANTS_FIELD_TRUE = "TRUE";
	public static final String CONSTANTS_FIELD_UNDEFINED = "UNDEFINED";
	public static final String CONSTANTS_FIELD_VOICE = "VOICE";
	public static final String CONSTANTS_FIELD_ZERO = "ZERO";
	public static final String DD_LAST_EXCEPTION_FIELD_ERRORCODE = "errorcode";
	public static final String DD_LAST_EXCEPTION_FIELD_MESSAGE = "message";
	public static final String DD_LAST_EXCEPTION_FIELD_OBJECT = "object";
	public static final String DD_LAST_EXCEPTION_FIELD_STACKTRACE = "stacktrace";
	public static final String DD_LAST_EXCEPTION_FIELD_TYPE = "type";
	public static final String OUTPUT__PARAMETERS_FIELD_ANNOUNCE_ID = "announceID";
	public static final String OUTPUT__PARAMETERS_FIELD_CONFIDENCE = "confidence";
	public static final String OUTPUT__PARAMETERS_FIELD_CONFIRMATIONS_REMAINING = "confirmationsRemaining";
	public static final String OUTPUT__PARAMETERS_FIELD_DISALLOW_LIST = "disallowList";
	public static final String OUTPUT__PARAMETERS_FIELD_INPUT_TYPE = "inputType";
	public static final String OUTPUT__PARAMETERS_FIELD_MENU_END_TIME = "MenuEndTime";
	public static final String OUTPUT__PARAMETERS_FIELD_MENU_ID = "menuID";
	public static final String OUTPUT__PARAMETERS_FIELD_MENU_START_TIME = "MenuStartTime";
	public static final String OUTPUT__PARAMETERS_FIELD_N_BEST_VALUES = "nBestValues";
	public static final String OUTPUT__PARAMETERS_FIELD_NO_INPUT_REMAINING = "noInputRemaining";
	public static final String OUTPUT__PARAMETERS_FIELD_NO_MATCHS_REMAINING = "noMatchsRemaining";
	public static final String OUTPUT__PARAMETERS_FIELD_OTHER_SLOT = "otherSlot";
	public static final String OUTPUT__PARAMETERS_FIELD_RECORDED_UTTERANCE = "recordedUtterance";
	public static final String OUTPUT__PARAMETERS_FIELD_RETURNCODE = "returncode";
	public static final String OUTPUT__PARAMETERS_FIELD_SPECIFIC_SLOTS = "specificSlots";
	public static final String OUTPUT__PARAMETERS_FIELD_UTTERANCE = "utterance";
	public static final String OUTPUT__PARAMETERS_FIELD_VALUE = "value";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_CONFIDENCE = "confidence";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_CONFIRMATION__MODE = "CONFIRMATION_MODE";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_INPUTMODE = "inputmode";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_INTERPRETATION = "interpretation";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_NOINPUTCOUNT = "noinputcount";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_NOMATCHCOUNT = "nomatchcount";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_OTHER__SLOT = "OTHER_SLOT";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_RESULT = "RESULT";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_UTTERANCE = "utterance";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT_FIELD_VALUE = "value";
	//}}END:PROJECT:VARIABLEFIELDS

	
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
	 * Last generated by Orchestration Designer at: 2017-SEP-04  04:23:50 PM
	 */
	public static final String INPUT__TTS__TELEPHONE = "input_tts_Telephone";
	public static final String INPUT__NO_MATCH_RANDOM = "input_noMatchRandom";
	public static final String INPUT__DYNAMIC_CONSTRAINT_LIST_FLAG = "input_dynamicConstraintListFlag";
	public static final String INPUT__BUILT_IN_GRAMMAR = "input_builtInGrammar";
	public static final String COLLECTIONDTMFGRAMMAR = "COLLECTIONDTMFGRAMMAR";
	public static final String TIME = "time";
	public static final String INPUT__IS_ANNOUNCEMENT = "input_isAnnouncement";
	public static final String COLLECTIONCONSTRAINTNOMATCHPROMPT = "COLLECTIONCONSTRAINTNOMATCHPROMPT";
	public static final String INPUT__CONFIRMATION_DENIED_APOLOGY_RANDOM = "input_confirmationDeniedApologyRandom";
	public static final String INPUT__ONE_TIME_FLAG = "input_oneTimeFlag";
	public static final String INPUT__DYNAMIC_CONSTRAINT_LIST_VALUES = "input_dynamicConstraintListValues";
	public static final String INPUT__TERMINATING_CHAR = "input_terminatingChar";
	public static final String COLLECTIONPREVIOUSINIITIALPRMTTEMP = "COLLECTIONPREVIOUSINIITIALPRMTTEMP";
	public static final String INPUT__PROPERTY_FILE_NAME = "input_propertyFileName";
	public static final String INPUT__PRIVATE_DATA = "input_privateData";
	public static final String INPUT__TTS__CURRENCY = "input_tts_Currency";
	public static final String INPUT__CONFIRMATION_INITIAL_PROMPT = "input_confirmationInitialPrompt";
	public static final String INPUT_VARIABLES = "inputVariables";
	public static final String INPUT__INITIAL_TIMEOUT = "input_initialTimeout";
	public static final String INPUT__MORE_OPTION_COUNT = "input_moreOptionCount";
	public static final String INPUT__TTS__NUMBER = "input_tts_Number";
	public static final String ASTERICK = "ASTERICK";
	public static final String INPUT__DTMF_GLOBAL_GRAMMAR = "input_dtmfGlobalGrammar";
	public static final String INPUT__MEDIA_TYPE_DTMF = "input_mediaTypeDTMF";
	public static final String DATE = "date";
	public static final String INPUT__TTS__ADDRESS = "input_tts_Address";
	public static final String COLLECTIONGLOBALREPROMPTTEMP = "COLLECTIONGLOBALREPROMPTTEMP";
	public static final String INPUT__SS__NUMBER = "input_ss_Number";
	public static final String INPUT__SS__TIME_VALUES = "input_ss_TimeValues";
	public static final String CONCATENATED_CONFIRMATION_DTMFGRAMMAR = "ConcatenatedConfirmationDTMFGrammar";
	public static final String COLLECTIONNOMATCHREPROMPT = "COLLECTIONNOMATCHREPROMPT";
	public static final String CONCATENATED_DTMFGRAMMAR = "ConcatenatedDTMFGrammar";
	public static final String INPUT__NINMCOUNTER = "input_NINMCounter";
	public static final String INPUT__IS_DTMF = "input_isDTMF";
	public static final String N_BEST_VALUES_COLLECTION = "nBestValuesCollection";
	public static final String INPUT__DYNAMIC_CONSTRAINT_LIST_COUNTER = "input_dynamicConstraintListCounter";
	public static final String INPUT__TTS__NUMBER_VALUES = "input_tts_NumberValues";
	public static final String INPUT__CONFIRMATION_MAX_TRY_PROMPT = "input_confirmationMaxTryPrompt";
	public static final String INPUT__TTS__TIME = "input_tts_Time";
	public static final String FLAGS = "FLAGS";
	public static final String COLLECTIONNOINPUTPROMPT = "COLLECTIONNOINPUTPROMPT";
	public static final String INPUT__STATIC_CONSTRAINT_LIST = "input_StaticConstraintList";
	public static final String INPUT__CUSTOM_AUDIO_LOCATION = "input_customAudioLocation";
	public static final String INPUT__SS__CURRENCY_VALUES = "input_ss_CurrencyValues";
	public static final String INPUT__SS__CURRENCY = "input_ss_Currency";
	public static final String INPUT__TTS__NAME = "input_tts_Name";
	public static final String INPUT__TTS__TIME_VALUES = "input_tts_TimeValues";
	public static final String INPUT__GLOBAL_PROMPT = "input_globalPrompt";
	public static final String IDM__VARIABLES = "IDM_Variables";
	public static final String INPUT__CONFIRMATION_DENIED_MAX_TRY_PROMPT = "input_confirmationDeniedMaxTryPrompt";
	public static final String INPUT__HIGH_CONFIDENCE_LEVEL = "input_highConfidenceLevel";
	public static final String INPUT__REPEAT_PROMPT = "input_repeatPrompt";
	public static final String INPUT__SPECIFIC_SLOTS = "input_specificSlots";
	public static final String INPUT__REPORT_ENABLED = "input_reportEnabled";
	public static final String INPUT = "input";
	public static final String INPUT__CONFIRMATION_REPROMPT = "input_confirmationReprompt";
	public static final String DISALLOW_COLLECTION = "disallowCollection";
	public static final String INPUT__CONFIRMATION_DTMF_GRAMMAR = "input_confirmationDtmfGrammar";
	public static final String INPUT__NO_INPUT_MAX_TRY_PROMPT = "input_NoInputMaxTryPrompt";
	public static final String INPUT__BARGE_IN_TYPE = "input_BargeInType";
	public static final String COLLECTIONREPEATPROMPT = "COLLECTIONREPEATPROMPT";
	public static final String INPUT__TTS__TELEPHONE_VALUES = "input_tts_TelephoneValues";
	public static final String GRAMMAR_URL = "grammarURL";
	public static final String INPUT__DYNAMIC_CONSTRAINT_LIST_COUNTER_FLAG = "input_dynamicConstraintListCounterFlag";
	public static final String INPUT__CONFIRMATION_NO_MATCH_PROMPT = "input_confirmationNoMatchPrompt";
	public static final String COLLECTIONVOICEGRAMMAR = "COLLECTIONVOICEGRAMMAR";
	public static final String INPUT__TTS__DIGITS = "input_tts_Digits";
	public static final String COLLECTIONDYNAMICCONSTRAINTLIST = "COLLECTIONDYNAMICCONSTRAINTLIST";
	public static final String INPUT__REPEAT_COUNTER = "input_RepeatCounter";
	public static final String COLLECTIONDYNAMICGRAMMAR = "COLLECTIONDYNAMICGRAMMAR";
	public static final String INPUT__SUCCESS_PROMPT = "input_successPrompt";
	public static final String DEFUALT_LANGUAGE = "defualtLanguage";
	public static final String SHAREDUUI = "shareduui";
	public static final String UNTITLED_INPUT_1 = "untitledInput1";
	public static final String UNTITLED_INPUT_2 = "untitledInput2";
	public static final String INPUT__MORE_OPTION_DYNAMIC_VALUES = "input_moreOptionDynamicValues";
	public static final String COLLECTIONMOREINITIALPROMPT = "COLLECTIONMOREINITIALPROMPT";
	public static final String INPUT__HELP_PROMPT = "input_helpPrompt";
	public static final String INPUT__GLOBAL_PROPERTY_FILE_NAME = "input_globalPropertyFileName";
	public static final String COLLECTION_SIZE = "CollectionSize";
	public static final String INPUT__VOICE_GLOBAL_GRAMMAR = "input_voiceGlobalGrammar";
	public static final String INITIAL_REPROMPT_COLLECTION = "initialRepromptCollection";
	public static final String CONFIRMATIONRETURNVALUES = "confirmationreturnvalues";
	public static final String INPUT__DIALOG_NAME = "input_DialogName";
	public static final String INTERNAL_CONFIRMATION_PROMPTAND_COLLECT = "InternalConfirmationPromptandCollect";
	public static final String PROMPT_AND_COLLECT = "PromptAndCollect";
	public static final String REDIRECTINFO = "redirectinfo";
	public static final String INPUT__MENU_ID = "input_menuID";
	public static final String INPUT__MENU_OPTIONS = "input_menuOptions";
	public static final String INPUT__INITIAL_PROMPT = "input_initialPrompt";
	public static final String INPUT__NO_INPUT_RANDOM = "input_noInputRandom";
	public static final String CONCATENATED_CONFIRMATION_VOICE_GRAMMAR = "ConcatenatedConfirmationVoiceGrammar";
	public static final String INPUT__VOICE_GRAMMAR = "input_voiceGrammar";
	public static final String INPUT__TTS__DIGITS_VALUES = "input_tts_DigitsValues";
	public static final String INPUT__INCOMPLETE_TIMEOUT = "input_incompleteTimeout";
	public static final String INPUT__LOGGER_NAME = "input_LoggerName";
	public static final String INPUT__NBEST = "input_nbest";
	public static final String SESSION = "session";
	public static final String INPUT__SS__DATE_VALUES = "input_ss_DateValues";
	public static final String INPUT__SS__DATE = "input_ss_Date";
	public static final String INPUT__DTMF_GRAMMAR = "input_dtmfGrammar";
	public static final String INPUT__PROPERTIES_LOCATION = "input_propertiesLocation";
	public static final String INPUT__DYNAMIC_CONSTRAINT_LIST_PROMPTS = "input_dynamicConstraintListPrompts";
	public static final String INPUT__SS__TIME = "input_ss_Time";
	public static final String COLLECTIONNOINPUTREPROMPT = "COLLECTIONNOINPUTREPROMPT";
	public static final String STATIC_CONSTRAINT_RESULT = "StaticConstraintResult";
	public static final String INPUT__CONFIRMATION_DENIED_MAX_COUNT = "input_confirmationDeniedMaxCount";
	public static final String INITAL_PRMT_COLLECTION = "initalPrmtCollection";
	public static final String COLLECTIONINITIALREPROMPT = "COLLECTIONINITIALREPROMPT";
	public static final String COLLECTIONCONFIRMATION = "COLLECTIONCONFIRMATION";
	public static final String COLLECTIONCONFIRMATIONNOMATCH = "COLLECTIONCONFIRMATIONNOMATCH";
	public static final String INPUT__LOW_CONFIDENCE_LEVEL = "input_lowConfidenceLevel";
	public static final String INPUT__BARGE_IN = "input_bargeIn";
	public static final String INPUT__INTERDIGIT_TIMEOUT = "input_interdigitTimeout";
	public static final String INPUT__RE_PROMPT_NO_MATCH = "input_rePromptNoMatch";
	public static final String INPUT__GRAMMAR_LOCATION = "input_grammarLocation";
	public static final String INPUT__SS__DIGITS_VALUES = "input_ss_DigitsValues";
	public static final String COLLECTIONCONFIRMATIONNOINPUT = "COLLECTIONCONFIRMATIONNOINPUT";
	public static final String INPUT__LOGGING_ENABLED = "input_LoggingEnabled";
	public static final String INPUT__MAX_NO_MATCH_COUNT = "input_maxNoMatchCount";
	public static final String CONCATENATED_VOICE_GRAMMAR = "ConcatenatedVoiceGrammar";
	public static final String INPUT__TTS__CURRENCY_VALUES = "input_tts_CurrencyValues";
	public static final String INPUT__MORE_OPTION_PREVIOUS_MENU_FLAG = "input_moreOptionPreviousMenuFlag";
	public static final String INPUT__MEDIA_TYPE_VOICE = "input_mediaTypeVoice";
	public static final String COLLECTIONPREVIOUSINIITALPROMPT = "COLLECTIONPREVIOUSINIITALPROMPT";
	public static final String COLLECTIONINITIALPROMPTTEMP = "COLLECTIONINITIALPROMPTTEMP";
	public static final String INPUT__NO_MATCH_MAX_TRY_PROMPT = "input_noMatchMaxTryPrompt";
	public static final String INPUT__CONFIRMATION_VALUE_FLAG = "input_confirmationValueFlag";
	public static final String INPUT__BUILT_IN_GRAMMAR_FLAG = "input_builtInGrammarFlag";
	public static final String CONSTANTS = "CONSTANTS";
	public static final String INPUT__DTMFGRAMMARUSE_SLOTS = "input_DTMFGrammaruseSlots";
	public static final String INPUT__MORE_OPTION_DTMFGRAMMAR = "input_moreOptionDTMFGrammar";
	public static final String INPUT__MORE_OPTION_FLAG = "input_moreOptionFlag";
	public static final String INPUT__SUCCESS_PROMPT_ONLY_FOR_CONFIRMATION = "input_SuccessPromptOnlyForConfirmation";
	public static final String INPUT__TTS__NAME_VALUES = "input_tts_NameValues";
	public static final String INPUT__RE_ENTRY = "input_reEntry";
	public static final String GLOBAL_PRMT_COLLECTION = "globalPrmtCollection";
	public static final String INPUT__CONFIRMATION_SPECIFIC_PROMPT = "input_confirmationSpecificPrompt";
	public static final String COLLECTIONMOREINITIALPRMTTEMP = "COLLECTIONMOREINITIALPRMTTEMP";
	public static final String INPUT__SS__DIGITS = "input_ss_Digits";
	public static final String INPUT__CONFIRMATION_MAX_COUNT = "input_confirmationMaxCount";
	public static final String INPUT__MAX_NO_INPUT_COUNT = "input_maxNoInputCount";
	public static final String DD_LAST_EXCEPTION = "ddLastException";
	public static final String INPUT__TERMINATING_TIMEOUT = "input_terminatingTimeout";
	public static final String INPUT__CONFIRMATION_NO_INPUT_PROMPT = "input_confirmationNoInputPrompt";
	public static final String INPUT__DISALLOW_LIST = "input_disallowList";
	public static final String COLLECTIONNOMATCHPROMPT = "COLLECTIONNOMATCHPROMPT";
	public static final String OUTPUT__PARAMETERS = "Output_Parameters";
	public static final String INPUT__MORE_OPTION_VOICE_GRAMMAR = "input_moreOptionVoiceGrammar";
	public static final String INPUT__NO_INPUT_PROMPT = "input_noInputPrompt";
	public static final String INPUT__TTS__DATE_VALUES = "input_tts_DateValues";
	public static final String INPUT__STANDARD_AUDIO_LOCATION = "input_standardAudioLocation";
	public static final String INPUT__COMPLETE_TIMEOUT = "input_CompleteTimeout";
	public static final String INPUT__CONFIRAMTION_MAX_COUNT = "input_confiramtionMaxCount";
	public static final String INPUT__SS__NUMBER_VALUES = "input_ss_NumberValues";
	public static final String CONFIRMATION_PROMPT_AND_COLLECT = "ConfirmationPromptAndCollect";
	public static final String COLLECTIONSUCCESSPROMPT = "COLLECTIONSUCCESSPROMPT";
	public static final String INPUT__CONFIRMATION_VOICE_GRAMMAR = "input_confirmationVoiceGrammar";
	public static final String INPUT__LANGUAGE = "input_language";
	public static final String INPUT__TTS__DATE = "input_tts_Date";
	public static final String INPUT__TTS__ADDRESS_VALUES = "input_tts_AddressValues";
	public static final String OPERATION_RESULT = "OperationResult";
	public static final String INPUT__ANNOUNCE_ID = "input_AnnounceID";
	public static final String INPUT__CONFIRMATION_MODE = "input_ConfirmationMode";
	public static final String INPUT__MANAGE_REPEAT = "input_manageRepeat";
	public static final String MORE_OPTION = "MoreOption";
	public static final String INPUT__NO_MATCH_PROMPT = "input_noMatchPrompt";
	public static final String COLLECTIONGLOBALINITIALTEMP = "COLLECTIONGLOBALINITIALTEMP";
	public static final String COLLECTIONINITIALPROMPT = "COLLECTIONINITIALPROMPT";
	public static final String INPUT__REPEAT_MAX_TRY_PROMPT = "input_repeatMaxTryPrompt";
	public static final String INPUT__CONFIRMATION_DENIED_APOLOGY = "input_ConfirmationDeniedApology";
	public static final String INPUT__RE_PROMPT_NO_INPUT = "input_rePromptNoInput";
	//}}END:PROJECT:VARIABLES
}