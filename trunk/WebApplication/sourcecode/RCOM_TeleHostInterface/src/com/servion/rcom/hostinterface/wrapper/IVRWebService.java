package com.servion.rcom.hostinterface.wrapper;


import com.servion.rcom.hostinterface.view.ReqTeleVerify;
import com.servion.rcom.hostinterface.view.ReqServiceRequestDetails;

import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ReqTvpUpdate;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.rcom.hostinterface.view.ResTeleVerify;
import com.servion.rcom.hostinterface.view.ResServiceRequestDetails;

import com.servion.rcom.hostinterface.view.ResTvpUpdate;
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
	public ResTeleVerify executeTeleVerifyRequest(IVRDataBean ivrDataBean, ReqTeleVerify reqteleverify);
	
	
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param reqTvpUpdate
	 * @return ResTvpUpdate
	 */
	
	
	public ResTvpUpdate executeTVPUpdateRequest(IVRDataBean ivrDataBean, ReqTvpUpdate reqTvpUpdate);
	
	

	
	
	
}
