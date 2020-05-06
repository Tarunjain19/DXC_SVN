package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.TransAccountBalance;
import com.servion.rcom.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ResAccountBalance;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.util.IVRDataBean;

public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResAccountBalance executeAccountBalance(IVRDataBean ivrDataBean, ReqAccountBalance req) {
		TransAccountBalance transAccountBalance = new TransAccountBalance();
		return transAccountBalance.getHostInterface(ivrDataBean, req);
	}
	@Override
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS req) {
		TransURLHitPushSMS transurlHitPushSMS = new TransURLHitPushSMS();
		return transurlHitPushSMS.getHostInterface(ivrDataBean, req);
	}
}
