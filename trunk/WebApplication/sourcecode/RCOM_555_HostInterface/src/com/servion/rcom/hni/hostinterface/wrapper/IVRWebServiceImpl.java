package com.servion.rcom.hni.hostinterface.wrapper;

import com.servion.rcom.hni.hostinterface.TransAccountBalance;
import com.servion.rcom.hni.hostinterface.TransActivateVAS;
import com.servion.rcom.hni.hostinterface.TransActivePackDetails;
import com.servion.rcom.hni.hostinterface.TransActivePlanDetails;
import com.servion.rcom.hni.hostinterface.TransBarringInfo;
import com.servion.rcom.hni.hostinterface.TransBillDeliveryStatus;
import com.servion.rcom.hni.hostinterface.TransBillInfo;
import com.servion.rcom.hni.hostinterface.TransCreditLimitInfo;
import com.servion.rcom.hni.hostinterface.TransDNCderegistration;
import com.servion.rcom.hni.hostinterface.TransDNCregistration;
import com.servion.rcom.hni.hostinterface.TransDataBalance;
import com.servion.rcom.hni.hostinterface.TransDataConsumption;
import com.servion.rcom.hni.hostinterface.TransDataOffers;
import com.servion.rcom.hni.hostinterface.TransDuplicateBillRequest;
import com.servion.rcom.hni.hostinterface.TransFreeUnitInfo;
import com.servion.rcom.hni.hostinterface.TransGPRSSettingsDownload;
import com.servion.rcom.hni.hostinterface.TransIldActivation;
import com.servion.rcom.hni.hostinterface.TransItemisedBillActivation;
import com.servion.rcom.hni.hostinterface.TransLastRechargeDetails;
import com.servion.rcom.hni.hostinterface.TransLastThreeTransactions;
import com.servion.rcom.hni.hostinterface.TransNonActivePackDetails;
import com.servion.rcom.hni.hostinterface.TransPaymentLink;
import com.servion.rcom.hni.hostinterface.TransPaymentUsingCoreBalance;
import com.servion.rcom.hni.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.hni.hostinterface.TransStorePTP;
import com.servion.rcom.hni.hostinterface.TransURLHitPaymentUsingCreditcard;
import com.servion.rcom.hni.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.hni.hostinterface.TransURLHitTopUpAmountValidation;
import com.servion.rcom.hni.hostinterface.TransURLHitUpdateVAS;
import com.servion.rcom.hni.hostinterface.TransUnbilledInfo;
import com.servion.rcom.hni.hostinterface.TransVoiceOffers;
import com.servion.rcom.hni.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.hni.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.hni.hostinterface.view.ReqActivePackDetails;
import com.servion.rcom.hni.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.hni.hostinterface.view.ReqBarringInfo;
import com.servion.rcom.hni.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.hni.hostinterface.view.ReqBillInfo;
import com.servion.rcom.hni.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.hni.hostinterface.view.ReqDNCderegistration;
import com.servion.rcom.hni.hostinterface.view.ReqDNCregistration;
import com.servion.rcom.hni.hostinterface.view.ReqDataBalance;
import com.servion.rcom.hni.hostinterface.view.ReqDataConsumption;
import com.servion.rcom.hni.hostinterface.view.ReqDataOffers;
import com.servion.rcom.hni.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.hni.hostinterface.view.ReqFreeUnitInfo;
import com.servion.rcom.hni.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.hni.hostinterface.view.ReqIldActivation;
import com.servion.rcom.hni.hostinterface.view.ReqItemisedBillActivation;
import com.servion.rcom.hni.hostinterface.view.ReqLastRechargeDetails;
import com.servion.rcom.hni.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.hni.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hni.hostinterface.view.ReqPaymentLink;
import com.servion.rcom.hni.hostinterface.view.ReqPaymentUsingCoreBalance;
import com.servion.rcom.hni.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hni.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hni.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hni.hostinterface.view.ReqStorePTP;
import com.servion.rcom.hni.hostinterface.view.ReqTopUpAmountValidation;
import com.servion.rcom.hni.hostinterface.view.ReqURLHitUpdateVAS;
import com.servion.rcom.hni.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.hni.hostinterface.view.ReqVoiceOffers;
import com.servion.rcom.hni.hostinterface.view.ResAccountBalance;
import com.servion.rcom.hni.hostinterface.view.ResActivateVAS;
import com.servion.rcom.hni.hostinterface.view.ResActivePackDetails;
import com.servion.rcom.hni.hostinterface.view.ResActivePlanDetails;
import com.servion.rcom.hni.hostinterface.view.ResBarringInfo;
import com.servion.rcom.hni.hostinterface.view.ResBillDeliveryStatus;
import com.servion.rcom.hni.hostinterface.view.ResBillInfo;
import com.servion.rcom.hni.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.hni.hostinterface.view.ResDNCderegistration;
import com.servion.rcom.hni.hostinterface.view.ResDNCregistration;
import com.servion.rcom.hni.hostinterface.view.ResDataBalance;
import com.servion.rcom.hni.hostinterface.view.ResDataConsumption;
import com.servion.rcom.hni.hostinterface.view.ResDataOffers;
import com.servion.rcom.hni.hostinterface.view.ResDuplicateBill;
import com.servion.rcom.hni.hostinterface.view.ResFreeUnitInfo;
import com.servion.rcom.hni.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.hni.hostinterface.view.ResIldActivation;
import com.servion.rcom.hni.hostinterface.view.ResItemizedBillActivation;
import com.servion.rcom.hni.hostinterface.view.ResLastRechargeDetails;
import com.servion.rcom.hni.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.hni.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.hni.hostinterface.view.ResPaymentLink;
import com.servion.rcom.hni.hostinterface.view.ResPaymentUsingCoreBalance;
import com.servion.rcom.hni.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.hni.hostinterface.view.ResPushSMS;
import com.servion.rcom.hni.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hni.hostinterface.view.ResStorePTP;
import com.servion.rcom.hni.hostinterface.view.ResTopUpAmountValidation;
import com.servion.rcom.hni.hostinterface.view.ResURLHitUpdateVAS;
import com.servion.rcom.hni.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.hni.hostinterface.view.ResVoiceOffers;
import com.servion.util.IVRDataBean;

public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS req) {
		TransURLHitPushSMS transPushSMS = new TransURLHitPushSMS();
		return transPushSMS.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResAccountBalance executeAccountBalance(IVRDataBean ivrDataBean, ReqAccountBalance req) {
		TransAccountBalance transAccountBalance = new TransAccountBalance();
		return transAccountBalance.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResPaymentUsingCreditcard executePaymentUsingCreditcard(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard req) {
		TransURLHitPaymentUsingCreditcard transURLHitPaymentUsingCreditcard = new TransURLHitPaymentUsingCreditcard();
		return transURLHitPaymentUsingCreditcard.getHostInterface(ivrDataBean, req);
	}


	@Override
	public ResDataBalance executeDataBalance(IVRDataBean ivrDataBean, ReqDataBalance req) {
		TransDataBalance transDataBalance = new TransDataBalance();
		return transDataBalance.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResLastRechargeDetails executeLastRechargeDetails(IVRDataBean ivrDataBean, ReqLastRechargeDetails req) {
		TransLastRechargeDetails transLastRechargeDetails = new TransLastRechargeDetails();
		return transLastRechargeDetails.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResGPRSSettingsDownload executeGPRSSettingsDownload(IVRDataBean ivrDataBean, ReqGPRSSettingsDownload req) {
		TransGPRSSettingsDownload transGPRSSettingsDownload = new TransGPRSSettingsDownload();
		return transGPRSSettingsDownload.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResPaymentUsingCoreBalance executePaymentUsingCoreBalance(IVRDataBean ivrDataBean, ReqPaymentUsingCoreBalance req) {
		TransPaymentUsingCoreBalance transPaymentUsingCoreBalance = new TransPaymentUsingCoreBalance();
		return transPaymentUsingCoreBalance.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResTopUpAmountValidation executeTopUpAmountValidation(IVRDataBean ivrDataBean, ReqTopUpAmountValidation req) {
		TransURLHitTopUpAmountValidation transFetchAvailableTopUpList = new TransURLHitTopUpAmountValidation();
		return transFetchAvailableTopUpList.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResURLHitUpdateVAS executeURLHitUpdateVAS(IVRDataBean ivrDataBean, ReqURLHitUpdateVAS req) {
		TransURLHitUpdateVAS transUpdateVASURLHit = new TransURLHitUpdateVAS();
		return transUpdateVASURLHit.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResActivePackDetails executeActivePackDetails(IVRDataBean ivrDataBean, ReqActivePackDetails req) {
		TransActivePackDetails transActivePackDetails = new TransActivePackDetails();
		return transActivePackDetails.getHostInterface(ivrDataBean, req);
	}


	@Override
	public ResLastThreeTransactions executeLastThreeTransactions(IVRDataBean ivrDataBean, ReqLastThreeTransactions req) {
		TransLastThreeTransactions transLastThreeTransactions = new TransLastThreeTransactions();
		return transLastThreeTransactions.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResActivePlanDetails executeActivePlanDetails(IVRDataBean ivrDataBean, ReqActivePlanDetails req) {
		TransActivePlanDetails transActivePlanDetails = new TransActivePlanDetails();
		return transActivePlanDetails.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResServiceRequestDetails executeServiceRequestDetails(IVRDataBean ivrDataBean,ReqServiceRequestDetails req) {
		TransServiceRequestDetails transServiceRequestDetails = new TransServiceRequestDetails();
		return transServiceRequestDetails.getHostInterface(ivrDataBean, req);
	}
	
	@Override
	public ResNonActivePackDetails executeNonActivePackDetails(IVRDataBean ivrDataBean, ReqNonActivePackDetails req) {
		TransNonActivePackDetails transNonActivePackDetails = new TransNonActivePackDetails();
		return transNonActivePackDetails.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResActivateVAS executeActivateVAS(IVRDataBean ivrDataBean, ReqActivateVAS req) {
		TransActivateVAS transActivateVAS = new TransActivateVAS();
		return transActivateVAS.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResVoiceOffers executeVoiceOffers(IVRDataBean ivrDataBean, ReqVoiceOffers req) {
		TransVoiceOffers transVoiceOffers = new TransVoiceOffers();
		return transVoiceOffers.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResDataOffers executeDataOffers(IVRDataBean ivrDataBean,ReqDataOffers req) {
		TransDataOffers transDataOffers = new TransDataOffers();
		return transDataOffers.getHostInterface(ivrDataBean, req);
		
	}



	@Override
	public ResUnbilledInfo executeUnbilledInfo(IVRDataBean ivrDataBean, ReqUnbilledInfo reqUnbilledInfo) {
		TransUnbilledInfo transUnbilledInfo = new TransUnbilledInfo();
		return transUnbilledInfo.getHostInterface(ivrDataBean, reqUnbilledInfo);
	}

	@Override
	public ResBillInfo executeBillInfo(IVRDataBean ivrDataBean, ReqBillInfo reqBillInfo) {
		TransBillInfo transBillInfo = new TransBillInfo();
		return transBillInfo.getHostInterface(ivrDataBean, reqBillInfo);
	}

	@Override
	public ResCreditLimitInfo executeCreditLimitInfo(IVRDataBean ivrDataBean ,ReqCreditLimitInfo reqCreditLimitInfo) {
		TransCreditLimitInfo transCreditLimitInfo = new TransCreditLimitInfo();
		return transCreditLimitInfo.getHostInterface(ivrDataBean, reqCreditLimitInfo);
		
	}


	@Override
	public ResBarringInfo executeBarringInfo(IVRDataBean ivrDataBean, ReqBarringInfo reqBarringInfo) {
		TransBarringInfo transBarringInfo = new TransBarringInfo();
		return transBarringInfo.getHostInterface(ivrDataBean, reqBarringInfo);
		
	}

	@Override
	public ResDataConsumption executeDataConsumption(IVRDataBean ivrDataBean, ReqDataConsumption reqDataConsumption) {
		TransDataConsumption transDataConsumption = new TransDataConsumption();
		return transDataConsumption.getHostInterface(ivrDataBean, reqDataConsumption);
		
	}


	@Override
	public ResFreeUnitInfo executeFreeUnitInfo(IVRDataBean ivrDataBean, ReqFreeUnitInfo reqFreeUnitInfo) {
		TransFreeUnitInfo transFreeUnitInfo = new TransFreeUnitInfo();
		return transFreeUnitInfo.getHostInterface(ivrDataBean, reqFreeUnitInfo);
		
	}

	@Override
	public ResItemizedBillActivation executeItemisedBillActivation(IVRDataBean ivrDataBean, ReqItemisedBillActivation reqItemisedBillActivation) {
		TransItemisedBillActivation transItemisedBillActivation = new TransItemisedBillActivation();
		return transItemisedBillActivation.getHostInterface(ivrDataBean, reqItemisedBillActivation);
	}

	@Override
	public ResDNCregistration executeDNCregistration(IVRDataBean ivrDataBean, ReqDNCregistration reqDNCregistration) {
		TransDNCregistration transDNCregistration = new TransDNCregistration();
		return transDNCregistration.getHostInterface(ivrDataBean, reqDNCregistration);
	}

	@Override
	public ResDNCderegistration executeDNCderegistration(IVRDataBean ivrDataBean, ReqDNCderegistration reqDNCderegistration) {
		TransDNCderegistration transDNCderegistration = new TransDNCderegistration();
		return transDNCderegistration.getHostInterface(ivrDataBean, reqDNCderegistration);
		
	}

	@Override
	public ResBillDeliveryStatus executeBillDeliveryStatus(IVRDataBean ivrDataBean, ReqBillDeliveryStatus reqBillDeliveryStatus) {
		TransBillDeliveryStatus transBillDeliveryStatus = new TransBillDeliveryStatus();
		return transBillDeliveryStatus.getHostInterface(ivrDataBean, reqBillDeliveryStatus);
	}

	@Override
	public ResDuplicateBill executeDuplicateBillRequest(IVRDataBean ivrDataBean, ReqDuplicateBill reqDuplicateBill) {
		TransDuplicateBillRequest transDuplicateBillRequest = new TransDuplicateBillRequest();
		return transDuplicateBillRequest.getHostInterface(ivrDataBean, reqDuplicateBill);
	}

	@Override
	public ResPaymentLink executePaymentLink(IVRDataBean ivrDataBean, ReqPaymentLink reqPaymentLink) {
		TransPaymentLink transPaymentLink = new TransPaymentLink();
		return transPaymentLink.getHostInterface(ivrDataBean, reqPaymentLink);
	}

	@Override
	public ResIldActivation executeIldActivation(IVRDataBean ivrDataBean, ReqIldActivation reqIldActivation) {
		TransIldActivation transIldActivation = new TransIldActivation();
		return transIldActivation.getHostInterface(ivrDataBean, reqIldActivation);
	}
	

	@Override
	public ResStorePTP executeStorePTP(IVRDataBean ivrDataBean, ReqStorePTP req) {
		TransStorePTP transStorePTP = new TransStorePTP();
		return transStorePTP.getHostInterface(ivrDataBean, req);
	}
	
}
