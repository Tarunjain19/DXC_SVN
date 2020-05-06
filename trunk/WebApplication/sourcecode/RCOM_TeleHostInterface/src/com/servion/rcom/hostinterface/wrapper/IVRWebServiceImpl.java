package com.servion.rcom.hostinterface.wrapper;



import com.servion.rcom.hostinterface.TeleStatusUpdate;
import com.servion.rcom.hostinterface.TeleVerifyRequest;
import com.servion.rcom.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ReqTeleVerify;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.hostinterface.view.ResPushSMS;

import com.servion.rcom.hostinterface.view.ReqTvpUpdate;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;

import com.servion.rcom.hostinterface.view.ResTvpUpdate;

import com.servion.rcom.hostinterface.view.ResTeleVerify;

import com.servion.util.IVRDataBean;



public class IVRWebServiceImpl implements IVRWebService{
	
	
	@Override
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS req) {
		TransURLHitPushSMS transPushSMS = new TransURLHitPushSMS();
		return transPushSMS.getHostInterface(ivrDataBean, req);
	}

	@Override
	public ResServiceRequestDetails executeServiceRequestDetails(IVRDataBean ivrDataBean, ReqServiceRequestDetails req) {

		TransServiceRequestDetails transServiceRequestDetails = new TransServiceRequestDetails();
		return transServiceRequestDetails.getHostInterface(ivrDataBean, req);
		
	}
	
	// It is used to Get TVP status from Tibco
	
	public ResTeleVerify executeTeleVerifyRequest(IVRDataBean ivrDataBean, ReqTeleVerify reqteleverify) {
		TeleVerifyRequest teleVerifyRequest = new TeleVerifyRequest();
		return teleVerifyRequest.getHostInterface(ivrDataBean, reqteleverify);
	}
	
	// It is used to call TVP update in Tibco
	
	public ResTvpUpdate executeTVPUpdateRequest(IVRDataBean ivrDataBean, ReqTvpUpdate reqTvpUpdate) {
		TeleStatusUpdate teleStatusUpdate = new TeleStatusUpdate();
		return teleStatusUpdate.getHostInterface(ivrDataBean, reqTvpUpdate);
	}
	
	


	
	
	
}
