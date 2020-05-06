package com.servion.rcom.ppp.hostinterface.wrapper;

import com.servion.rcom.ppp.hostinterface.TransAccountBalance;
import com.servion.rcom.ppp.hostinterface.TransActivateVAS;
import com.servion.rcom.ppp.hostinterface.TransActivePackDetails;
import com.servion.rcom.ppp.hostinterface.TransActivePlanDetails;
import com.servion.rcom.ppp.hostinterface.TransBillDeliveryStatus;
import com.servion.rcom.ppp.hostinterface.TransBillInfo;
import com.servion.rcom.ppp.hostinterface.TransCreditLimitInfo;
import com.servion.rcom.ppp.hostinterface.TransDataBalance;
import com.servion.rcom.ppp.hostinterface.TransDataOffers;
import com.servion.rcom.ppp.hostinterface.TransDuplicateBillRequest;
import com.servion.rcom.ppp.hostinterface.TransFreeUnitInfo;
import com.servion.rcom.ppp.hostinterface.TransGPRSSettingsDownload;
import com.servion.rcom.ppp.hostinterface.TransLastRechargeDetails;
import com.servion.rcom.ppp.hostinterface.TransLastThreeTransactions;
import com.servion.rcom.ppp.hostinterface.TransNonActivePackDetails;
import com.servion.rcom.ppp.hostinterface.TransPaymentLink;
import com.servion.rcom.ppp.hostinterface.TransURLHitPaymentUsingCreditcard;
import com.servion.rcom.ppp.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.ppp.hostinterface.TransUnbilledInfo;
import com.servion.rcom.ppp.hostinterface.TransVoiceOffers;
import com.servion.rcom.ppp.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.ppp.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.ppp.hostinterface.view.ReqActivePackDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.ppp.hostinterface.view.ReqBillInfo;
import com.servion.rcom.ppp.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.ppp.hostinterface.view.ReqDataBalance;
import com.servion.rcom.ppp.hostinterface.view.ReqDataOffers;
import com.servion.rcom.ppp.hostinterface.view.ReqDuplicateBill;
import com.servion.rcom.ppp.hostinterface.view.ReqFreeUnitInfo;
import com.servion.rcom.ppp.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.ppp.hostinterface.view.ReqLastRechargeDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.ppp.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqPaymentLink;
import com.servion.rcom.ppp.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.ppp.hostinterface.view.ReqPushSMS;
import com.servion.rcom.ppp.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.ppp.hostinterface.view.ReqVoiceOffers;
import com.servion.rcom.ppp.hostinterface.view.ResAccountBalance;
import com.servion.rcom.ppp.hostinterface.view.ResActivateVAS;
import com.servion.rcom.ppp.hostinterface.view.ResActivePackDetails;
import com.servion.rcom.ppp.hostinterface.view.ResActivePlanDetails;
import com.servion.rcom.ppp.hostinterface.view.ResBillDeliveryStatus;
import com.servion.rcom.ppp.hostinterface.view.ResBillInfo;
import com.servion.rcom.ppp.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.ppp.hostinterface.view.ResDataBalance;
import com.servion.rcom.ppp.hostinterface.view.ResDataOffers;
import com.servion.rcom.ppp.hostinterface.view.ResDuplicateBill;
import com.servion.rcom.ppp.hostinterface.view.ResFreeUnitInfo;
import com.servion.rcom.ppp.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.ppp.hostinterface.view.ResLastRechargeDetails;
import com.servion.rcom.ppp.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.ppp.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.ppp.hostinterface.view.ResPaymentLink;
import com.servion.rcom.ppp.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.ppp.hostinterface.view.ResPushSMS;
import com.servion.rcom.ppp.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.ppp.hostinterface.view.ResVoiceOffers;
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
	public ResFreeUnitInfo executeFreeUnitInfo(IVRDataBean ivrDataBean, ReqFreeUnitInfo reqFreeUnitInfo) {
		TransFreeUnitInfo transFreeUnitInfo = new TransFreeUnitInfo();
		return transFreeUnitInfo.getHostInterface(ivrDataBean, reqFreeUnitInfo);
		
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

}
