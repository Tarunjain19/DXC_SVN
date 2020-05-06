package com.servion.rcom.Data.hostinterface.wrapper;


import com.servion.rcom.Data.hostinterface.view.ReqPushSMS;
import com.servion.rcom.Data.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ReqDataActDeact;

import com.servion.rcom.Data.hostinterface.view.ResPushSMS;
import com.servion.rcom.Data.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ResDataActDeact;



import com.servion.util.IVRDataBean;



public interface IVRWebService {

	
	
	

	/**
	 * 
	 * @param reqPushSMS
	 * @return ResPushSMS
	 */
	public ResPushSMS executePushSMS(IVRDataBean ivrDataBean, ReqPushSMS reqPushSMS);
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqServiceRequestDetails
	 * @return ResServiceRequestDetails
	 */
	public ResServiceRequestDetails executeServiceRequestDetails(IVRDataBean ivrDataBean, ReqServiceRequestDetails reqServiceRequestDetails);

	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqDuplicateBill
	 * @return ResDuplicateBill
	 */
	//public ResTeleVerify executeDuplicateBillRequest(IVRDataBean ivrDataBean, ReqTeleVerify reqDuplicateBill);
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqteleverify
	 * @return ResTeleVerify
	 */
	public ResDataActDeact executeDataRequest(IVRDataBean ivrDataBean, ReqDataActDeact reqData);
	
	
	

	
	

	
	
	
}
