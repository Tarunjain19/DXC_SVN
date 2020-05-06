package com.servion.rcom.CDMA.hostinterface;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;

import com.servion.rcom.CDMA.hostinterface.view.ReqCdmaLtaAct;

import com.servion.rcom.CDMA.hostinterface.view.ReqPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ResCdmaLta;

import com.servion.rcom.CDMA.hostinterface.view.ResPushSMS;
import com.servion.rcom.CDMA.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.CDMA.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.CDMA.hostinterface.wrapper.IVRWebServiceImpl;


import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Main {
	
	/*private static String bytes2String(byte[] bytes)
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++)
		{
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}*/
	
	public static void main(String[] args)
	{
		System.out.println(" Hello In root in");
		System.out.println(" Hello In root in");
				
		Logger logger = Logger.getLogger(Main.class);
		
		System.out.println("In start");
		AppProperties.setInstance("webservice_CDMA", "C:\\RCOM\\OtherFlows\\RCOM_CF_SIM_IVR\\Config\\");
		
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		System.out.println("In  Data between");
		
		//ReqDataActDeact req= new ReqDataActDeact();
		
		ReqCdmaLtaAct req=new ReqCdmaLtaAct();
		
		
		req.setRequestId("1236985");
		req.setRequestSource("IVR");
		req.setId("123456789123456789");
		req.setRequestType("4GMIG");
		req.setService_ID("9320101528");
		req.setTimeStamp("18/03/2016 10:38:33");
		req.setType("8805678100");
		req.setValue("8991150004050000254");
		
		/*req.setREQUESTDATE("23/11/2015 11:10:30");
		req.requestId("12345678");
		req.service_ID("88805678100");
		req.setREQUESTTYPE("4GMIG");
		req.setrequestSource();
		req.timeStamp("18/03/2016 10:38:33");
		req.id();
		req.value();
		req.type();
		req.setSOURCE("IVR");
		req.setREQopType("N");*/
		//dd/MM/YYYY hh:mm:ss
		
		ResCdmaLta res = ivrWebService.executeCDMALTARequest(ivrDataBean, req);
		
		System.out.println("CDMA_Response : " +res.getResponseCode());
		//System.out.println("TVP_STATUS() Msg out : " +resTeleVerify.getOUT_MSG());
		
		System.out.println("END");
		
		System.out.println("SMS start");
		
	/*	ReqPushSMS req1=new ReqPushSMS();
		
		req1.setMDN("8805678100");
		req1.setMessageText("This is test msg");
	
		
		ResPushSMS  res1=ivrWebService.executePushSMS(ivrDataBean, req1);
		
		System.out.println("SMS_Response : " +res1.getResponseCode());
	*/
		
		
		
		
		/*ReqTvpUpdate req1=new ReqTvpUpdate();
		req1.setMDN("8144166673");
		req1.setDATACONSENT("Y");
		req1.setTVPSTATUSFLAG_VALUE("Y");
		ResTvpUpdate resTVPUpdate=ivrWebService.executeTVPUpdateRequest(ivrDataBean, req1);
		
		System.out.println("TVP_STATUS() : " +resTVPUpdate.getOUT_MSG());*/
		
	
		
	}

}

