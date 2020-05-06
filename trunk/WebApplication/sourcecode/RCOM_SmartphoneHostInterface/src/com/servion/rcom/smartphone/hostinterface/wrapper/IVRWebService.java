package com.servion.rcom.smartphone.hostinterface.wrapper;

import com.servion.rcom.smartphone.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.smartphone.hostinterface.view.ReqBillInfo;
import com.servion.rcom.smartphone.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.smartphone.hostinterface.view.ReqLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.view.ReqPushSMS;
import com.servion.rcom.smartphone.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResAccountBalance;
import com.servion.rcom.smartphone.hostinterface.view.ResBillInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.view.ResPushSMS;
import com.servion.rcom.smartphone.hostinterface.view.ResUnbilledInfo;
import com.servion.util.IVRDataBean;



public interface IVRWebService {

	/**
	 * @param ivrDataBean
	 * @param reqAccountBalance
	 * @return ResAccountBalance
	 * 
	 */
	public ResAccountBalance executeAccountBalance(IVRDataBean ivrDataBean, ReqAccountBalance reqAccountBalance);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqPushSMS
	 * @return ResPushSMS
	 */
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS);
	
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
	 * @param reqBillInfo
	 * @return ResBillInfo
	 */
	public ResBillInfo executeBillInfo(IVRDataBean ivrDataBean, ReqBillInfo reqBillInfo);
	
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
	 * @param reqLastPaymentDetails
	 * @return ResLastPaymentDetails
	 */
	public ResLastPaymentDetails executeLastPaymentInfo(IVRDataBean ivrDataBean, ReqLastPaymentDetails reqLastPaymentDetails);
}
