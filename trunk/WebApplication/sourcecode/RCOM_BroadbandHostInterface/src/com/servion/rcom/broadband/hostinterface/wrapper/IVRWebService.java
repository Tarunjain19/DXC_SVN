package com.servion.rcom.broadband.hostinterface.wrapper;

import com.servion.rcom.broadband.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ReqPushSMS;
import com.servion.rcom.broadband.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ResPushSMS;
import com.servion.util.IVRDataBean;



public interface IVRWebService {

	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqPushSMS
	 * @return ResPushSMS
	 */
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS);
	
	
	/**
	 * 
	 * @param reqPaymentValidation
	 * @param ivrDataBean
	 * @return ResPaymentValidation
	 */
	public ResPaymentUsingCreditcard executePaymentUsingCreditcard(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard reqPaymentValidation);
	
}
