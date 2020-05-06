package com.rcom.hostinterface.wrapper;


import com.rcom.hostinterface.TransActivePacks;
import com.rcom.hostinterface.TransSTOPVAS;
import com.rcom.hostinterface.view.ReqActivePacks;
import com.rcom.hostinterface.view.ReqStopVAS;
import com.rcom.hostinterface.view.ResActivePacks;
import com.rcom.hostinterface.view.ResStopVAS;
import com.servion.util.IVRDataBean;


public class IVRWebServiceImpl implements IVRWebService{

	@Override
	public ResActivePacks getActivePacks(IVRDataBean ivrDataBean,
			ReqActivePacks reqActivePacks) {
		TransActivePacks transActivePacks = new TransActivePacks();
		return transActivePacks.getHostInterface(ivrDataBean, reqActivePacks);
	}

	@Override
	public ResStopVAS stopVAS(IVRDataBean ivrDataBean, ReqStopVAS reqStopVAS) {
		TransSTOPVAS transSTOPVAS = new TransSTOPVAS();
		return transSTOPVAS.getHostInterface(ivrDataBean, reqStopVAS);
	}

	

	
}
