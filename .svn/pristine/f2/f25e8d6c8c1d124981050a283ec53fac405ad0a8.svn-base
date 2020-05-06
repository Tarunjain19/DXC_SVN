package com.servion.rcom.Data.hostinterface.wrapper;




import com.servion.rcom.Data.hostinterface.DataRequest;
import com.servion.rcom.Data.hostinterface.TransServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.TransURLHitPushSMS;
import com.servion.rcom.Data.hostinterface.view.ReqPushSMS;
import com.servion.rcom.Data.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ReqDataActDeact;

import com.servion.rcom.Data.hostinterface.view.ResPushSMS;
import com.servion.rcom.Data.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ResDataActDeact;





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
	
	public ResDataActDeact executeDataRequest(IVRDataBean ivrDataBean, ReqDataActDeact reqData) {
		DataRequest dataRequest = new DataRequest();
		return dataRequest.getHostInterface(ivrDataBean, reqData);
	}
	
	
	
	


	
	
	
}
