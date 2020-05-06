package com.servion.rcom.hostinterface;

import org.apache.log4j.Logger;

import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.view.ReqDataConsumption;
import com.servion.rcom.hostinterface.view.ResDataConsumption;
import com.servion.util.IVRDataBean;

public class TransDataConsumption implements ITransaction{

	ReqDataConsumption reqDataConsumption = null;
	ResDataConsumption resDataConsumption = new ResDataConsumption();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	
	public ResDataConsumption getHostInterface(IVRDataBean ivrDataBean, ReqDataConsumption request) {
		
		logger = ivrDataBean.getLogger();
		reqDataConsumption = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransDataConsumption getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransDataConsumption getHostInterface method end");
		return resDataConsumption;
	}
	
	@Override
	public void wsdlProcessor() {
		// TODO Auto-generated method stub
		
	}

}
