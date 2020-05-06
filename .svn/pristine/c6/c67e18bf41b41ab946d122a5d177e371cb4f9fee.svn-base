package com.servion.rcom.CDMA.hostinterface.wrapper;


import com.servion.rcom.CDMA.hostinterface.view.ReqCdmaLtaAct;

import com.servion.rcom.CDMA.hostinterface.view.ReqPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.CDMA.hostinterface.view.ResCdmaLta;

import com.servion.rcom.CDMA.hostinterface.view.ResPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ResServiceRequestDetails;




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
	public ResCdmaLta executeCDMALTARequest(IVRDataBean ivrDataBean, ReqCdmaLtaAct reqcdma);
	
	
	

	
	

	
	
	
}
