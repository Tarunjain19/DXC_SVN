package com.servion.rcom.test;

import org.apache.log4j.Logger;




import com.servion.prepaid.report.GetReportObject;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Test {
	
	private static Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args)
	{
	
		AppProperties.setInstance("DEALER_HOST_CONFIG", "C:\\RCOM\\RCOM_Dealer\\Config\\");
		Logger logger = Logger.getLogger("RCOM.com.servion.util");
		
		IVRDataBean ivrDataBean = new IVRDataBean();
				
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject); 
		
		ReqPushSMS req = new ReqPushSMS();
		req.setMDN("7666888255");
		req.setMessageText("Hello");
		IVRWebService ivrWebService =new IVRWebServiceImpl();
		ivrWebService.executePushSMS(ivrDataBean, req);
		
		
	}

}
