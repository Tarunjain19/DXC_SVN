package com.servion.rcom.hostinterface;

import org.apache.log4j.Logger;

import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.view.ReqBarringInfo;
import com.servion.rcom.hostinterface.view.ResBarringInfo;
import com.servion.util.IVRDataBean;

public class TransBarringInfo implements ITransaction{

	ReqBarringInfo reqBarringInfo = null;
	ResBarringInfo resBarringInfo = new ResBarringInfo();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	
	public ResBarringInfo getHostInterface(IVRDataBean ivrDataBean, ReqBarringInfo request) {
		
		logger = ivrDataBean.getLogger();
		reqBarringInfo = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransBarringInfo getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransBarringInfo getHostInterface method end");
		return resBarringInfo;
	}
	
	@Override
	public void wsdlProcessor() {
		// TODO Auto-generated method stub
		
	}

}
