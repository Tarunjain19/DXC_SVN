package com.servion.rcom.smartphone.hostinterface.wrapper;

import com.servion.rcom.smartphone.hostinterface.TransAccountBalance;
import com.servion.rcom.smartphone.hostinterface.TransBillInfo;
import com.servion.rcom.smartphone.hostinterface.TransCreditLimitInfo;
import com.servion.rcom.smartphone.hostinterface.TransLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.smartphone.hostinterface.TransUnbilledInfo;
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



public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResAccountBalance executeAccountBalance(IVRDataBean ivrDataBean, ReqAccountBalance req) {
		TransAccountBalance transAccountBalance = new TransAccountBalance();
		return transAccountBalance.getHostInterface(ivrDataBean, req);
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
	public ResLastPaymentDetails executeLastPaymentInfo(IVRDataBean ivrDataBean, ReqLastPaymentDetails reqLastPaymentDetails) {
		TransLastPaymentDetails transLastPaymentDetails = new TransLastPaymentDetails();
		return transLastPaymentDetails.getHostInterface(ivrDataBean, reqLastPaymentDetails);
	}

}
