package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.TransActivateBooster;
import com.servion.rcom.hostinterface.TransActivateVAS;
import com.servion.rcom.hostinterface.TransActivePackDetails;
import com.servion.rcom.hostinterface.TransActivePlanDetails;
import com.servion.rcom.hostinterface.TransBarringInfo;
import com.servion.rcom.hostinterface.TransBillDeliveryStatus;
import com.servion.rcom.hostinterface.TransBillInfo;
import com.servion.rcom.hostinterface.TransCreditLimitInfo;
import com.servion.rcom.hostinterface.TransDNCderegistration;
import com.servion.rcom.hostinterface.TransDNCregistration;
import com.servion.rcom.hostinterface.TransDataConsumption;
import com.servion.rcom.hostinterface.TransDataOffers;
import com.servion.rcom.hostinterface.TransDuplicateBillRequest;
import com.servion.rcom.hostinterface.TransFreeUnitInfo;
import com.servion.rcom.hostinterface.TransGPRSSettingsDownload;
import com.servion.rcom.hostinterface.TransIldActivation;
import com.servion.rcom.hostinterface.TransItemisedBillActivation;
import com.servion.rcom.hostinterface.TransLastThreeTransactions;
import com.servion.rcom.hostinterface.TransNonActivePackDetails;
import com.servion.rcom.hostinterface.TransPaymentLink;
import com.servion.rcom.hostinterface.TransPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.hostinterface.TransStorePTP;
import com.servion.rcom.hostinterface.TransURLHitPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.hostinterface.TransUnbilledInfo;
import com.servion.rcom.hostinterface.TransVoiceOffers;
import com.servion.rcom.hostinterface.view.ReqActivateBooster;
import com.servion.rcom.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.hostinterface.view.ReqActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.hostinterface.view.ReqBarringInfo;
import com.servion.rcom.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.hostinterface.view.ReqBillInfo;
import com.servion.rcom.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.hostinterface.view.ReqDNCderegistration;
import com.servion.rcom.hostinterface.view.ReqDNCregistration;
import com.servion.rcom.hostinterface.view.ReqDataConsumption;
import com.servion.rcom.hostinterface.view.ReqDataOffers;
import com.servion.rcom.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.hostinterface.view.ReqFreeUnitInfo;
import com.servion.rcom.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ReqIldActivation;
import com.servion.rcom.hostinterface.view.ReqItemisedBillActivation;
import com.servion.rcom.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqPaymentLink;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ReqStorePTP;
import com.servion.rcom.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.hostinterface.view.ReqVoiceOffers;
import com.servion.rcom.hostinterface.view.ResActivateBooster;
import com.servion.rcom.hostinterface.view.ResActivateVAS;
import com.servion.rcom.hostinterface.view.ResActivePackDetails;
import com.servion.rcom.hostinterface.view.ResActivePlanDetails;
import com.servion.rcom.hostinterface.view.ResBarringInfo;
import com.servion.rcom.hostinterface.view.ResBillDeliveryStatus;
import com.servion.rcom.hostinterface.view.ResBillInfo;
import com.servion.rcom.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.hostinterface.view.ResDNCderegistration;
import com.servion.rcom.hostinterface.view.ResDNCregistration;
import com.servion.rcom.hostinterface.view.ResDataConsumption;
import com.servion.rcom.hostinterface.view.ResDataOffers;
import com.servion.rcom.hostinterface.view.ResDuplicateBill;
import com.servion.rcom.hostinterface.view.ResFreeUnitInfo;
import com.servion.rcom.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ResIldActivation;
import com.servion.rcom.hostinterface.view.ResItemizedBillActivation;
import com.servion.rcom.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ResPaymentLink;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResStorePTP;
import com.servion.rcom.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.hostinterface.view.ResVoiceOffers;
import com.servion.util.IVRDataBean;



public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResServiceRequestDetails executeServiceRequestDetails(IVRDataBean ivrDataBean, ReqServiceRequestDetails req) {

		TransServiceRequestDetails transServiceRequestDetails = new TransServiceRequestDetails();
		return transServiceRequestDetails.getHostInterface(ivrDataBean, req);
		
	}

	@Override
	public ResActivePlanDetails executeActivePlanDetails(IVRDataBean ivrDataBean, ReqActivePlanDetails reqActivePlanDetails) {
		TransActivePlanDetails transActivePlanDetails = new TransActivePlanDetails();
		return transActivePlanDetails.getHostInterface(ivrDataBean, reqActivePlanDetails);
	}

	@Override
	public ResActivePackDetails executeActivePackDetails(IVRDataBean ivrDataBean, ReqActivePackDetails reqActivePackDetails) {
		TransActivePackDetails transActivePackDetails = new TransActivePackDetails();
		return transActivePackDetails.getHostInterface(ivrDataBean, reqActivePackDetails);
	}

	@Override
	public ResNonActivePackDetails executeNonActivePackDetails(IVRDataBean ivrDataBean, ReqNonActivePackDetails reqNonActivePackDetails) {
		TransNonActivePackDetails transNonActivePackDetails = new TransNonActivePackDetails();
		return transNonActivePackDetails.getHostInterface(ivrDataBean, reqNonActivePackDetails);
	}

	@Override
	public ResActivateVAS executeActivateVAS(IVRDataBean ivrDataBean, ReqActivateVAS reqActivateVAS) {
		TransActivateVAS transActivateVAS = new TransActivateVAS();
		return transActivateVAS.getHostInterface(ivrDataBean, reqActivateVAS);
	}

	@Override
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS) {
		TransURLHitPushSMS transURLHitPushSMS = new TransURLHitPushSMS();
		return transURLHitPushSMS.getHostInterface(ivrDataBean, reqPushSMS);
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
	public ResLastThreeTransactions executeLastThreeTransactions(IVRDataBean ivrDataBean, ReqLastThreeTransactions reqLastThreeTransactions) {
		TransLastThreeTransactions transLastThreeTransactions = new TransLastThreeTransactions();
		return transLastThreeTransactions.getHostInterface(ivrDataBean, reqLastThreeTransactions);
		
	}

	@Override
	public ResPaymentUsingCreditcard executePaymentUsingCreditcard(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard reqPaymentValidation) {
		TransURLHitPaymentUsingCreditcard transURLHitPaymentUsingCreditcard = new TransURLHitPaymentUsingCreditcard();
		return transURLHitPaymentUsingCreditcard.getHostInterface(ivrDataBean, reqPaymentValidation);
		
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
	public ResGPRSSettingsDownload executeGPRSSettingsDownload(IVRDataBean ivrDataBean, ReqGPRSSettingsDownload reqGPRSSettingsDownload) {
		TransGPRSSettingsDownload transGPRSSettingsDownload = new TransGPRSSettingsDownload();
		return transGPRSSettingsDownload.getHostInterface(ivrDataBean, reqGPRSSettingsDownload);
		
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
	public ResPaymentUsingCoreBalance executePaymentUsingCoreBalance(IVRDataBean ivrDataBean, ReqPaymentUsingCoreBalance req) {
		TransPaymentUsingCoreBalance transPaymentUsingCoreBalance = new TransPaymentUsingCoreBalance();
		return transPaymentUsingCoreBalance.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResStorePTP executeStorePTP(IVRDataBean ivrDataBean, ReqStorePTP req) {
		TransStorePTP transStorePTP = new TransStorePTP();
		return transStorePTP.getHostInterface(ivrDataBean, req);
	}
	//--------------------------------Changes for Booster pack-------------------------------------
	@Override
	public ResActivateBooster executeActivateBooster(IVRDataBean ivrDataBean,ReqActivateBooster reqActivateBooster){
	TransActivateBooster transActivateBooster=new TransActivateBooster();
	return transActivateBooster.getHostInterface(ivrDataBean, reqActivateBooster);
	}
}
