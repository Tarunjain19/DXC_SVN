package com.servion.rcom.hostinterface.util;

public interface HostConstants {
	
	public static final String GLOBALHOSTCONFIG = "RCOM_CF_HSD_HOSTCONFIG";
	public static final String HOST_REQUEST_TYPE = "WS";
	public static final String CSS_HOST_METHOD = "cssInfo";
	
	
	/*
	 * CSS Endpoint URL
	 */
	public static final String CSS_ENDPOINT_URL = "CSS_ENDPOINT_URL";
	public static final String CSS_ENDPOINT_URL_ACC_BAL = "CSS_ENDPOINT_URL_ACC_BAL";
	public static final String CSS_ENDPOINT_URL_ACT_VAS = "CSS_ENDPOINT_URL_ACT_VAS";
	public static final String CSS_ENDPOINT_URL_ACTIVE_PACK = "CSS_ENDPOINT_URL_ACTIVE_PACK";
	public static final String CSS_ENDPOINT_URL_ACTIVE_PLAN = "CSS_ENDPOINT_URL_ACTIVE_PLAN";
	public static final String CSS_ENDPOINT_URL_DATA_BAL = "CSS_ENDPOINT_URL_DATA_BAL";
	public static final String CSS_ENDPOINT_URL_GPRS = "CSS_ENDPOINT_URL_GPRS";
	public static final String CSS_ENDPOINT_URL_LRD = "CSS_ENDPOINT_URL_LRD";
	public static final String CSS_ENDPOINT_URL_NON_ACT_PACK = "CSS_ENDPOINT_URL_NON_ACT_PACK";
	public static final String CSS_ENDPOINT_URL_PMT_CORE_BAL = "CSS_ENDPOINT_URL_PMT_CORE_BAL";
	public static final String CSS_ENDPOINT_URL_SR_DET = "CSS_ENDPOINT_URL_SR_DET";
	public static final String CSS_ENDPOINT_URL_VOICE_OFFERS = "CSS_ENDPOINT_URL_VOICE_OFFERS";
	public static final String CSS_ENDPOINT_URL_DATA_OFFERS = "CSS_ENDPOINT_URL_DATA_OFFERS";
	public static final String CSS_ENDPOINT_URL_UNBILLED_INFO="CSS_ENDPOINT_URL_UNBILLED_INFO";
	public static final String CSS_ENDPOINT_URL_FRU="CSS_ENDPOINT_URL_FRU";
	public static final String CSS_ENDPOINT_URL_CL="CSS_ENDPOINT_URL_CL";
	public static final String CSS_ENDPOINT_URL_BILL_INFO="CSS_ENDPOINT_URL_BILL_INFO";
	public static final String CSS_ENDPOINT_URL_BILL_DELIVERY_STATUS = "CSS_ENDPOINT_URL_BILL_DELIVERY_STATUS";
	
	
	public static final String CSS_LANG_ID = "CSS_LANG_ID";
	public static final String CSS_REQUEST_SOURCE = "CSS_REQUEST_SOURCE";
	public static final String CSS_REQUEST_TIMESTAMP_FORMAT = "CSS_REQUEST_TIMESTAMP_FORMAT";
	
	/*
	 * CSS WSDL Request Types
	 */
	public static final String CSS_REQUEST_TYPE_ACCOUNT_BALANCE = "CSS_REQUEST_TYPE_ACCOUNT_BALANCE";
	public static final String CSS_REQUEST_TYPE_LAST_RECHARGE_DETAILS = "CSS_REQUEST_TYPE_LAST_RECHARGE_DETAILS";
	public static final String CSS_REQUEST_TYPE_DATA_BALANCE = "CSS_REQUEST_TYPE_DATA_BALANCE";
	public static final String CSS_REQUEST_TYPE_ACTIVE_PACK_DETAILS = "CSS_REQUEST_TYPE_ACTIVE_PACK_DETAILS";
	public static final String CSS_REQUEST_TYPE_ACTIVE_VAS_DETAILS = "CSS_REQUEST_TYPE_ACTIVE_VAS_DETAILS";
	public static final String CSS_REQUEST_TYPE_ACTIVE_PLAN_DETAILS = "CSS_REQUEST_TYPE_ACTIVE_PLAN_DETAILS";
	public static final String CSS_REQUEST_TYPE_NON_ACTIVE_PACKS = "CSS_REQUEST_TYPE_NON_ACTIVE_PACKS";
	public static final String CSS_REQUEST_TYPE_ACTIVATE_VAS = "CSS_REQUEST_TYPE_ACTIVATE_VAS";
	public static final String CSS_REQUEST_TYPE_LAST3_TRANSACTIONS = "CSS_REQUEST_TYPE_LAST3_TRANSACTIONS";
	public static final String CSS_REQUEST_TYPE_SR_DETAILS = "CSS_REQUEST_TYPE_SR_DETAILS";
	public static final String CSS_REQUEST_TYPE_GPRS_SETTINGS = "CSS_REQUEST_TYPE_GPRS_SETTINGS";
	public static final String CSS_REQUEST_TYPE_BUY_PACK_USING_CORE_BAL = "CSS_REQUEST_TYPE_BUY_PACK_USING_CORE_BAL";
	public static final String CSS_REQUEST_TYPE_OFU = "CSS_REQUEST_TYPE_OFU";
	public static final String CSS_REQUEST_TYPE_UNBILLED_INFO = "CSS_REQUEST_TYPE_UNBILLED_INFO";
	public static final String CSS_REQUEST_TYPE_CREDIT_LIMIT_INFO = "CSS_REQUEST_TYPE_CREDIT_LIMIT_INFO";
	public static final String CSS_REQUEST_TYPE_FREE_UNIT_INFORMATION = "CSS_REQUEST_TYPE_FREE_UNIT_INFORMATION";
	public static final String CSS_REQUEST_TYPE_BILL_INFO = "CSS_REQUEST_TYPE_BILL_INFO";
	public static final String CSS_REQUEST_TYPE_BILL_DELIVERY_STATUS = "CSS_REQUEST_TYPE_BILL_DELIVERY_STATUS";
	public static final String CSS_ENDPOINT_URL_DUPLICATE_BILL_REQUEST = "CSS_ENDPOINT_URL_DUPLICATE_BILL_REQUEST";
	public static final String CSS_REQUEST_TYPE_DUPLICATE_BILL_REQUEST = "CSS_REQUEST_TYPE_DUPLICATE_BILL_REQUEST";
	public static final String CSS_ENDPOINT_URL_PAYMENT_LINK = "CSS_ENDPOINT_URL_PAYMENT_LINK";
	public static final String CSS_REQUEST_TYPE_PAYMENT_LINK = "CSS_REQUEST_TYPE_PAYMENT_LINK";
	
	public static final String OFU_QNAME_NAMESPACE = "OFU_QNAME_NAMESPACE";
	public static final String OFU_QNAME_LOCALPART = "OFU_QNAME_LOCALPART";
	
	public static final String RESPONSE_CODE_SUCCESS = "0";
	public static final String RESPONSE_CODE_FAILURE = "1";
	public static final String RESPONSE_CODE_MINUS_ONE = "-1";
	public static final String RESPONSE_CODE_ONE = "1";
	
	//TODO : Pending Success and Failure Error codes
	public static final String HOST_RESPONSE_ERROR_CODE_SUCCESS = "HOST_RESPONSE_ERROR_CODE_SUCCESS";
	//public static final String HOST_RESPONSE_ERROR_CODE_FAILURE = "HOST_RESPONSE_ERROR_CODE_FAILURE";
	
	public static final String EMPTY = "";
	public static final String PIPE = "|";
	public static final String DISABLED = "N";
	public static final String UNDERSCORE = "_";
	public static final String DOT = ".";
	public static final String DATE_TIME_FORMAT_HOST_REPORT = "dd/MM/YYYY HH:mm:ss";
	public static final String REPORT_HOST_STATUS_SUCCESS = "SUCCESS";
	public static final String REPORT_HOST_STATUS_FAILURE = "FAILURE";
	public static final String REPORT_HOST_STATUS_DOWN = "DOWN";
	
	public static final String HOST_CONNECTION_TIMEOUT = "HOST_CONNECTION_TIMEOUT";
	public static final String HOST_REQUEST_TIMEOUT = "HOST_REQUEST_TIMEOUT";
	
	public static final String URL_HIT_UPDATE_VAS_ATTR_MDN = "URL_HIT_UPDATE_VAS_ATTR_MDN";
	public static final String URL_HIT_UPDATE_VAS_ATTR_PACKID = "URL_HIT_UPDATE_VAS_ATTR_PACKID";
	public static final String URL_HIT_UPDATE_VAS_ATTR_ACTION = "URL_HIT_UPDATE_VAS_ATTR_ACTION";
	public static final String URL_HIT_UPDATE_VAS_ACTION_VALUE = "URL_HIT_UPDATE_VAS_ACTION_VALUE";
	
	public static final String URL_HIT_PUSH_SMS_URL = "URL_HIT_PUSH_SMS_URL";
	public static final String URL_HIT_PUSH_SMS_ATTR_MDN = "URL_HIT_PUSH_SMS_ATTR_MDN";
	public static final String URL_HIT_PUSH_SMS_ATTR_MESSAGE = "URL_HIT_PUSH_SMS_ATTR_MESSAGE";
	
	public static final String URL_HIT_PAYMENT_VALIDATION_URL="URL_HIT_PAYMENT_VALIDATION_URL";
	public static final String URL_HIT_PAYMENT_VALIDATION_ATTR_MESSAGE="URL_HIT_PAYMENT_VALIDATION_ATTR_MESSAGE";
	public static final String URL_HIT_PAYMENT_VALIDATION_SOURCE_ID="URL_HIT_PAYMENT_VALIDATION_SOURCE_ID";
	public static final String URL_HIT_PAYMENT_VALIDATION_XML_HEADER="URL_HIT_PAYMENT_VALIDATION_XML_HEADER";
	public static final String URL_HIT_PAYMENT_VALIDATION_DES_KEY = "URL_HIT_PAYMENT_VALIDATION_DES_KEY";
	public static final String URL_HIT_PAYMENT_VALIDATION_ERROR_CODE_SUCCESS = "URL_HIT_PAYMENT_VALIDATION_ERROR_CODE_SUCCESS";
	public static final String URL_HIT_PAYMENT_VALIDATION_CARD_TYPE = "URL_HIT_PAYMENT_VALIDATION_CARD_TYPE";
	
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_URL = "URL_HIT_TOPUP_AMOUNT_VALIDATION_URL";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_ATTR_MESSAGE = "URL_HIT_TOPUP_AMOUNT_VALIDATION_ATTR_MESSAGE";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_XML_HEADER = "URL_HIT_TOPUP_AMOUNT_VALIDATION_XML_HEADER";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_RC_TYPE = "URL_HIT_TOPUP_AMOUNT_VALIDATION_RC_TYPE";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_EXACT_VAL = "URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_EXACT_VAL";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_NEAR_VAL = "URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_NEAR_VAL";
	public static final String URL_HIT_TOPUP_AMOUNT_VALIDATION_ERROR_CODE_SUCCESS = "URL_HIT_TOPUP_AMOUNT_VALIDATION_ERROR_CODE_SUCCESS";

	public static final String STR_1 = "1";
	public static final String STR_2 = "2";
	public static final String STR_3 = "3";
	public static final String STR_4 = "4";
	public static final String STR_5 = "5";
	
	public static final String PARAM_VALUE = "VALUE";
	public static final String PARAM_VALIDITY = "VALIDITY";
	public static final String PARAM_AMT = "AMT";
	public static final String PARAM_DATE = "DATE";
	
	public static final String PARAM_BALANCE_NAME = "BALANCE_NAME";
	public static final String PARAM_DAT_BAL_NAME_GPRS = "GPRS";
	public static final String PARAM_DAT_BAL_NAME_3G_GPRS = "3G_GPRS";
	public static final String PARAM_DAT_BAL_NAME_3G_GPRS_FU = "3G_GPRS_FU";
	public static final String PARAM_DAT_BAL_NAME_GPRS_FU = "GPRS_FU";
	public static final String PARAM_CORE_BALANCE = "CORE BALANCE";
	public static final String PARAM_TYPE_INTEGER = "INTEGER";
	public static final String PARAM_TYPE_STRING = "STRING";
	
	
	
	public static final String PARAM_DATA_BAL_NAME_CORE_BAL = "CORE BALANCE";
	public static final String PARAM_DATA_BAL_NAME_RCONNECT_BAL = "RCONNECT";
	public static final String PARAM_DATA_BAL_NAME_PROMOTIONAL_BAL = "PROMOTIONAL BALANCE 1";
	public static final String PARAM_DATA_BAL_NAME_ONNET_LOCAL_BAL = "ONNET_LOCAL";
	
	public static final String PARAM_TXN_AMOUNT = "AMOUNT";
	public static final String PARAM_TXN_PAYMENT_RCVD_DATE = "PAYMENT_RCVD_DATE";
	public static final String PARAM_TXN_PAYMENT_TYPE = "PAYMENT_TYPE";
	
	public static final String PARAM_PACK_NAME = "PACK_NAME";
	public static final String PARAM_PACK_CODE = "PACK_CODE";
	public static final String PARAM_PACK_VALIDITY = "PACK_VALIDITY";
	public static final String PARAM_PACK_AMOUNT = "PACK_AMOUNT";
	
	public static final String PARAM_PAY_LINK_URL = "URL";
	
	public static final String PARAM_FRU_CATEGORY = "FRU_CATEGORY";
	public static final String PARAM_FRU_ALLOCATED_UNITS = "FRU_ALLOCATED_UNITS";
	public static final String PARAM_FRU_CONSUMED_UNITS = "FRU_CONSUMED_UNITS";
	public static final String PARAM_FRU_REMAINING_UNITS = "FRU_REMAINING_UNITS";
	public static final String PARAM_FRU_PERIOD_END_DATE = "FRU_PERIOD_END_DATE";
	public static final String PARAM_FRU_UOM = "FRU_UOM";
	
	public static final String PARAM_SR_SR_ID = "SR_ID";
	public static final String PARAM_SR_SRCREATION_DATE = "SRCREATION_DATE";
	public static final String PARAM_SR_SR_TYPE = "SR_TYPE";
	public static final String PARAM_SR_STATUS = "STATUS";
	public static final String PARAM_SR_CRMSLA_DATE = "CRMSLA_DATE";
	public static final String PARAM_SR_STATUS_OPEN = "OPEN";
	public static final String PARAM_SR_STATUS_SOLVING = "SOLVING";
	
	public static final String PARAM_PLN_RATE_PLAN = "RATE_PLAN";
	public static final String PARAM_PLN_MONTHLY_RENTAL_CHARGE = "MONTHLY_RENTAL_CHARGE";
	
	public static final String PARAM_LRD_TRANS_ID = "TRANS_ID";
	public static final String PARAM_LRD_AMT = "RECHARGE_AMOUNT";
	public static final String PARAM_LRD_DATE = "RECHARGE_DATE";
	public static final String PARAM_LRD_REC_TYPE = "REC_TYPE";
	public static final String PARAM_LRD_TALK_TIME = "VALIDITY_DAYS";
	public static final String PARAM_UNBILLED_AMT = "UNBILLED_AMT";
	public static final String PARAM_UNBILLED_SYSDATE = "DATE";
	
	public static final String PARAM_CL_CREDIT_LIM = "CREDIT_LIMIT";
	public static final String PARAM_CL_SYSDATE = "SYSDATE";
	
	public static final String PARAM_BILL_ACCOUNT_BALANCE = "ACCOUNT_BALANCE";
	public static final String PARAM_BILL_ISSUE_DATE = "ISSUE_DATE";
	public static final String PARAM_BILL_INVOICE_AMOUNT = "INVOICE_AMOUNT";
	public static final String PARAM_BILL_PAYMENT_DUE_DATE = "PAYMENT_DUE_DATE";
	
	public static final String PARAM_BDS_MODE = "MODE";
	public static final String PARAM_BDS_BILL_GEN_DATE = "BILLGENERATION_DATE";
	public static final String PARAM_BDS_BILL_DEL_DATE = "BILLDELIVERY_DATE";
	public static final String PARAM_BDS_BILL_DEL_STATUS = "BILLDELIVERY_STATUS";
	
	public static final String PARAM_DUP_BILL_ACTION_TYPE = "REQUEST_SUBTYPE";
	public static final String PARAM_DUP_BILL_ACTION_TYPE_EMAIL = "EMAIL";
	public static final String PARAM_DUP_BILL_ACTION_TYPE_DUPBILL = "DUPBILL";
	public static final String PARAM_DUP_BILL_CASE_ID = "CASE_ID";
}
