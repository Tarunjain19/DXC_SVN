package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.TransAccountBalance;
import com.servion.rcom.hostinterface.TransActivateVAS;
import com.servion.rcom.hostinterface.TransActivePackDetails;
import com.servion.rcom.hostinterface.TransActivePlanDetails;
import com.servion.rcom.hostinterface.TransDataBalance;
import com.servion.rcom.hostinterface.TransDataOffers;
import com.servion.rcom.hostinterface.TransGPRSSettingsDownload;
import com.servion.rcom.hostinterface.TransLastRechargeDetails;
import com.servion.rcom.hostinterface.TransLastThreeTransactions;
import com.servion.rcom.hostinterface.TransNonActivePackDetails;
import com.servion.rcom.hostinterface.TransPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.hostinterface.TransURLHitPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.hostinterface.TransURLHitTopUpAmountValidation;
import com.servion.rcom.hostinterface.TransURLHitUpdateVAS;
import com.servion.rcom.hostinterface.TransVoiceOffers;
import com.servion.rcom.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.hostinterface.view.ReqActivateVAS;
import com.servion.rcom.hostinterface.view.ReqActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.hostinterface.view.ReqDataBalance;
import com.servion.rcom.hostinterface.view.ReqDataOffers;
import com.servion.rcom.hostinterface.view.ReqGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ReqLastRechargeDetails;
import com.servion.rcom.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ReqTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ReqURLHitUpdateVAS;
import com.servion.rcom.hostinterface.view.ReqVoiceOffers;
import com.servion.rcom.hostinterface.view.ResAccountBalance;
import com.servion.rcom.hostinterface.view.ResActivateVAS;
import com.servion.rcom.hostinterface.view.ResActivePackDetails;
import com.servion.rcom.hostinterface.view.ResActivePlanDetails;
import com.servion.rcom.hostinterface.view.ResDataBalance;
import com.servion.rcom.hostinterface.view.ResDataOffers;
import com.servion.rcom.hostinterface.view.ResGPRSSettingsDownload;
import com.servion.rcom.hostinterface.view.ResLastRechargeDetails;
import com.servion.rcom.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.hostinterface.view.ResNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCoreBalance;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ResURLHitUpdateVAS;
import com.servion.rcom.hostinterface.view.ResVoiceOffers;
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

}
