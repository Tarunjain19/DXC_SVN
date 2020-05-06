package com.rcom.hostinterface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.rcom.hostinterface.util.HostConstants;
import com.rcom.hostinterface.view.ReqActivePacks;
import com.rcom.hostinterface.view.ResActivePacks;
import com.rcom.hostinterface.view.ReqStopVAS;
import com.rcom.hostinterface.view.ResStopVAS;
import com.servion.prepaid.report.GetReportObject;
import com.rcom.hostinterface.wrapper.IVRWebService;
import com.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


public class Main {

	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(Main.class);
		ReqActivePacks reqActivePacks = new ReqActivePacks();
		reqActivePacks.setMdn("7811964631");
		AppProperties.setInstance(HostConstants.GLOBALHOSTCONFIG,"C:/RCOM/OtherFlows/RCOM_CF_VAS/");
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		System.out.println("MDN ::"+reqActivePacks.getMdn());
		ResActivePacks resActivePacks = ivrWebService.getActivePacks(ivrDataBean, reqActivePacks);
		System.out.println("ResActivePacks :"+resActivePacks.toString());
		/*
		ReqStopVAS reqStopVAS = new ReqStopVAS();
		reqStopVAS.setMdn("7811964631");
		reqStopVAS.setSubID("1004");
		ResStopVAS resStopVAS = new ResStopVAS();
		resStopVAS = ivrWebService.stopVAS(ivrDataBean, reqStopVAS);
		System.out.println("ResStopVAS ::"+resStopVAS.toString()); */
	}
	
}
