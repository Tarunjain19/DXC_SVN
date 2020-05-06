package com.servion.rcom.Data.hostinterface;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;

import com.servion.rcom.Data.hostinterface.view.ReqPushSMS;
import com.servion.rcom.Data.hostinterface.view.ReqDataActDeact;

import com.servion.rcom.Data.hostinterface.view.ResPushSMS;
import com.servion.rcom.Data.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ResDataActDeact;

import com.servion.rcom.Data.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.Data.hostinterface.wrapper.IVRWebServiceImpl;
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
		System.out.println("In root");
				
		Logger logger = Logger.getLogger(Main.class);
		
		System.out.println("In start");
		AppProperties.setInstance("webservice", "C:\\RCOM\\OtherFlows\\RCOM_CF_1925_IVR\\Config\\");
		
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		System.out.println("In  Data between");
		
		ReqDataActDeact req= new ReqDataActDeact();
		
		req.setMDN("9324527112");
		req.setLangId("0");
		req.setREQUESTDATE("23/11/2015 11:10:30");
		req.setRequestId("12345678");
		req.setREQUESTTYPE("DATA");
		req.setSOURCE("IVR");
		req.setREQopType("N");
		//dd/MM/YYYY hh:mm:ss
		ResDataActDeact res = ivrWebService.executeDataRequest(ivrDataBean, req);
		
		System.out.println("Data_Response : " +res.getResponseCode());
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

