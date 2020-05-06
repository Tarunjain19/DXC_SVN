package com.servion.rcom.broadband.hostinterface.wrapper;

import com.servion.rcom.broadband.hostinterface.TransURLHitPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.broadband.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ReqPushSMS;
import com.servion.rcom.broadband.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ResPushSMS;
import com.servion.util.IVRDataBean;



public class IVRWebServiceImpl implements IVRWebService{

	
	@Override
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS) {
		TransURLHitPushSMS transURLHitPushSMS = new TransURLHitPushSMS();
		return transURLHitPushSMS.getHostInterface(ivrDataBean, reqPushSMS);
	}


	@Override
	public ResPaymentUsingCreditcard executePaymentUsingCreditcard(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard req) {
		TransURLHitPaymentUsingCreditcard transURLHitPaymentUsingCreditcard = new TransURLHitPaymentUsingCreditcard();
		return transURLHitPaymentUsingCreditcard.getHostInterface(ivrDataBean, req);
	}
	
}
