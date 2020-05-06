package com.servion.rcom.CDMA.hostinterface.wrapper;




import com.servion.rcom.CDMA.hostinterface.CdmaRequest;

import com.servion.rcom.CDMA.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.CDMA.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ReqCdmaLtaAct;

import com.servion.rcom.CDMA.hostinterface.view.ReqPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.CDMA.hostinterface.view.ResCdmaLta;

import com.servion.rcom.CDMA.hostinterface.view.ResPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ResServiceRequestDetails;






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
	
	

	
	
	// It is used to Get CDMA status from Tibco
	
		public ResCdmaLta executeCDMALTARequest(IVRDataBean ivrDataBean, ReqCdmaLtaAct reqcdma) {
			CdmaRequest cdmaRequest = new CdmaRequest();
			return cdmaRequest.getHostInterface(ivrDataBean, reqcdma);
		}
	
	
	
	


	
	
	
}
