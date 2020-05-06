package com.servion.rcom.hostinterface.wrapper;


import com.servion.rcom.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.hostinterface.view.ReqActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.hostinterface.view.ReqBillInfo;
import com.servion.rcom.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.hostinterface.view.ReqDataBalance;
import com.servion.rcom.hostinterface.view.ReqDataOffers;
import com.servion.rcom.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.hostinterface.view.ReqFreeUnitInfo;
import com.servion.rcom.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ReqLastRechargeDetails;
import com.servion.rcom.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqPaymentLink;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ReqTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ReqURLHitUpdateVAS;
import com.servion.rcom.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.hostinterface.view.ReqVoiceOffers;
import com.servion.rcom.hostinterface.view.ResAccountBalance;
import com.servion.rcom.hostinterface.view.ResActivateVAS;
import com.servion.rcom.hostinterface.view.ResActivePackDetails;
import com.servion.rcom.hostinterface.view.ResActivePlanDetails;
import com.servion.rcom.hostinterface.view.ResBillDeliveryStatus;
import com.servion.rcom.hostinterface.view.ResBillInfo;
import com.servion.rcom.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.hostinterface.view.ResDataBalance;
import com.servion.rcom.hostinterface.view.ResDataOffers;
import com.servion.rcom.hostinterface.view.ResDuplicateBill;
import com.servion.rcom.hostinterface.view.ResFreeUnitInfo;
import com.servion.rcom.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ResLastRechargeDetails;
import com.servion.rcom.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ResPaymentLink;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ResURLHitUpdateVAS;
import com.servion.rcom.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.hostinterface.view.ResVoiceOffers;
import com.servion.util.IVRDataBean;

public interface IVRWebService {



	/**
	 * 
	 * @param reqPushSMS
	 * @return ResPushSMS
	 */
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqCreditLimitInfo
	 * @return ResCreditLimitInfo
	 */
	public ResCreditLimitInfo executeCreditLimitInfo(IVRDataBean ivrDataBean, ReqCreditLimitInfo reqCreditLimitInfo);
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqFreeUnitInfo
	 * @return ResFreeUnitInfo
	 */
	public ResFreeUnitInfo executeFreeUnitInfo(IVRDataBean ivrDataBean, ReqFreeUnitInfo reqFreeUnitInfo);
	
	
	
	/**
	 * 
	 * @param reqAccountBalance
	 * @return ResAccountBalance
	 */
	public ResAccountBalance executeAccountBalance(IVRDataBean ivrDataBean, ReqAccountBalance reqAccountBalance);
	
	/**
	 * 
	 * @param reqPaymentValidation
	 * @return ResPaymentValidation
	 */
	public ResPaymentUsingCreditcard executePaymentUsingCreditcard(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard reqPaymentValidation);
	
	
	/**
	 * 
	 * @param reqDataBalance
	 * @return ResDataBalance
	 */
	public ResDataBalance executeDataBalance(IVRDataBean ivrDataBean, ReqDataBalance reqDataBalance);
	
	/**
	 * 
	 * @param reqLastRechargeDetails
	 * @return ResLastRechargeDetails
	 */
	public ResLastRechargeDetails executeLastRechargeDetails(IVRDataBean ivrDataBean, ReqLastRechargeDetails reqLastRechargeDetails);
	
	/**
	 * 
	 * @param reqGPRSSettingsDownload
	 * @return ResGPRSSettingsDownload
	 */
	public ResGPRSSettingsDownload executeGPRSSettingsDownload(IVRDataBean ivrDataBean, ReqGPRSSettingsDownload reqGPRSSettingsDownload);
	
	/**
	 * 
	 * @param reqPackActivation
	 * @return ResPackActivation
	 */
	public ResPaymentUsingCoreBalance executePaymentUsingCoreBalance(IVRDataBean ivrDataBean, ReqPaymentUsingCoreBalance reqPaymentUsingCoreBalance);
	
	/**
	 * 
	 * @param reqAvailableTopUpList
	 * @return ResAvailableTopUpList
	 */
	public ResTopUpAmountValidation executeTopUpAmountValidation(IVRDataBean ivrDataBean, ReqTopUpAmountValidation reqTopUpAmountValidation);
	
	/**
	 * 
	 * @param reqURLHitUpdateVAS
	 * @return ResURLHitUpdateVAS
	 */
	public ResURLHitUpdateVAS executeURLHitUpdateVAS(IVRDataBean ivrDataBean, ReqURLHitUpdateVAS reqURLHitUpdateVAS);
	
	/**
	 * 
	 * @param reqActivePackDetails
	 * @return resActivePackDetails
	 */
	public ResActivePackDetails executeActivePackDetails(IVRDataBean ivrDataBean, ReqActivePackDetails reqActivePackDetails);
	
	
	/**
	 * 
	 * @param reqLastThreeTransactions
	 * @return resLastThreeTransactions
	 */
	public ResLastThreeTransactions executeLastThreeTransactions(IVRDataBean ivrDataBean, ReqLastThreeTransactions reqLastThreeTransactions);
	
	/**
	 * 
	 * @param reqActivePlanDetails
	 * @return resActivePlanDetails
	 */
	public ResActivePlanDetails executeActivePlanDetails(IVRDataBean ivrDataBean, ReqActivePlanDetails reqActivePlanDetails);
	
	/**
	 * 
	 * @param reqServiceRequestDetails
	 * @param resServiceRequestDetails
	 */
	public ResServiceRequestDetails executeServiceRequestDetails(IVRDataBean ivrDataBean, ReqServiceRequestDetails reqServiceRequestDetails);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqUnbilledInfo
	 * @return ResUnbilledInfo
	 */
	public ResUnbilledInfo executeUnbilledInfo(IVRDataBean ivrDataBean, ReqUnbilledInfo reqUnbilledInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqNonActivePackDetails
	 * @return resNonActivePackDetails
	 */
	public ResNonActivePackDetails executeNonActivePackDetails(IVRDataBean ivrDataBean, ReqNonActivePackDetails reqNonActivePackDetails);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqActivateVAS
	 * @return resActivateVAS
	 */
	public ResActivateVAS executeActivateVAS(IVRDataBean ivrDataBean, ReqActivateVAS reqActivateVAS);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqVoiceOffers
	 * @return resVoiceOffers
	 */
	public ResVoiceOffers executeVoiceOffers(IVRDataBean ivrDataBean, ReqVoiceOffers reqVoiceOffers);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqDataOffers
	 * @return resDataOffers
	 */
	public ResDataOffers executeDataOffers(IVRDataBean ivrDataBean, ReqDataOffers reqDataOffers);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqBillInfo
	 * @return ResBillInfo
	 */
	public ResBillInfo executeBillInfo(IVRDataBean ivrDataBean, ReqBillInfo reqBillInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqBillDeliveryStatus
	 * @return ResBillDeliveryStatus
	 */
	public ResBillDeliveryStatus executeBillDeliveryStatus(IVRDataBean ivrDataBean, ReqBillDeliveryStatus reqBillDeliveryStatus);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqDuplicateBill
	 * @return ResDuplicateBill
	 */
	public ResDuplicateBill executeDuplicateBillRequest(IVRDataBean ivrDataBean, ReqDuplicateBill reqDuplicateBill);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqPaymentLink
	 * @return ResPaymentLink
	 */
	public ResPaymentLink executePaymentLink(IVRDataBean ivrDataBean, ReqPaymentLink reqPaymentLink);
	
}
