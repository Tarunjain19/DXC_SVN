package com.servion.rcom.hostinterface.wrapper;

import com.servion.rcom.hostinterface.TransDNCderegistration;
import com.servion.rcom.hostinterface.TransDNCregistration;
import com.servion.rcom.hostinterface.view.ReqDNCderegistration;
import com.servion.rcom.hostinterface.view.ReqDNCregistration;
import com.servion.rcom.hostinterface.view.ResDNCderegistration;
import com.servion.rcom.hostinterface.view.ResDNCregistration;
import com.servion.util.IVRDataBean;



public class IVRWebServiceImpl implements IVRWebService{


	@Override
	public ResDNCregistration executeDNCregistration(IVRDataBean ivrDataBean, ReqDNCregistration reqDNCregistration) {
		TransDNCregistration transDNCregistration = new TransDNCregistration();
		return transDNCregistration.getHostInterface(ivrDataBean, reqDNCregistration);
	}

	@Override
	public ResDNCderegistration executeDNCderegistration(IVRDataBean ivrDataBean, ReqDNCderegistration reqDNCderegistration) {
		TransDNCderegistration transDNCderegistration = new TransDNCderegistration();
		return transDNCderegistration.getHostInterface(ivrDataBean, reqDNCderegistration);
		
	}

	
}
