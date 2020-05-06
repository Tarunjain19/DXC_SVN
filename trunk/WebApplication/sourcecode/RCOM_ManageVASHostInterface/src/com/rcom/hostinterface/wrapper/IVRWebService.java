package com.rcom.hostinterface.wrapper;


import com.rcom.hostinterface.view.ReqActivePacks;
import com.rcom.hostinterface.view.ReqStopVAS;
import com.rcom.hostinterface.view.ResActivePacks;
import com.rcom.hostinterface.view.ResStopVAS;
import com.servion.util.IVRDataBean;


public interface IVRWebService {



	/**
	 * 
	 * @param ivrDataBean
	 * @param reqLatestBillGenDetails
	 * @return ResLatestBillGenDetails
	 */
	public ResActivePacks getActivePacks (IVRDataBean ivrDataBean,ReqActivePacks reqActivePacks);
	public ResStopVAS stopVAS (IVRDataBean ivrDataBean,ReqStopVAS reqStopVAS);
}
