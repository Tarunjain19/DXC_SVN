package com.servion.rcom.smartphone.hostinterface;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.rcom.smartphone.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.smartphone.hostinterface.view.ReqBillInfo;
import com.servion.rcom.smartphone.hostinterface.view.ReqCreditLimitInfo;
import com.servion.rcom.smartphone.hostinterface.view.ReqLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.view.ReqPushSMS;
import com.servion.rcom.smartphone.hostinterface.view.ReqUnbilledInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResAccountBalance;
import com.servion.rcom.smartphone.hostinterface.view.ResBillInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResCreditLimitInfo;
import com.servion.rcom.smartphone.hostinterface.view.ResLastPaymentDetails;
import com.servion.rcom.smartphone.hostinterface.view.ResPushSMS;
import com.servion.rcom.smartphone.hostinterface.view.ResUnbilledInfo;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.smartphone.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Main {

	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(Main.class);
		AppProperties.setInstance("smartphone_webservice", "D:/v2.1/ARCOM_Workspace/RCOM_SmartphoneHostInterface/config/hostconfig/");
		
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		ReqAccountBalance reqAccountBalance = new ReqAccountBalance();
		reqAccountBalance.setMDN("9942530028");
		
		ResAccountBalance resAccountBalance = ivrWebService.executeAccountBalance(ivrDataBean, reqAccountBalance);
		System.out.println("Response Code : " +resAccountBalance.getResponseCode());
		System.out.println("Account Balance : " +resAccountBalance.getAccBalance());
		System.out.println("Account Balance Expiry Date : "+resAccountBalance.getAccBalanceExpiryDate());
		
		System.out.println("***************************");
		
		ReqUnbilledInfo reqUnbilledInfo = new ReqUnbilledInfo();
		reqUnbilledInfo.setMDN("9942530028");
		
		ResUnbilledInfo resUnbilledInfo = ivrWebService.executeUnbilledInfo(ivrDataBean, reqUnbilledInfo);
		System.out.println("Response Code : " +resUnbilledInfo.getResponseCode());
		System.out.println("Unbilled Amount : " +resUnbilledInfo.getUnBilledAmount());
		System.out.println("System Date : " + resUnbilledInfo.getSysDate());
		
		System.out.println("***************************");
		
		ReqBillInfo reqBillInfo = new ReqBillInfo();
		reqBillInfo.setMDN("9942530028");
		
		ResBillInfo resBillInfo = ivrWebService.executeBillInfo(ivrDataBean, reqBillInfo);
		
		System.out.println("Response Code : " +resBillInfo.getResponseCode());
		System.out.println("Account Balance : " +resBillInfo.getAccountBalance());
		System.out.println("Invoice Amount : " +resBillInfo.getInvoiceAmount());
		System.out.println("Bill Issue Date : " +resBillInfo.getBillIssueDate());
		System.out.println("Payment Due Date : " +resBillInfo.getPaymentDueDate());
		
		System.out.println("***************************");
		
		ReqCreditLimitInfo reqCreditLimitInfo = new ReqCreditLimitInfo();
		reqCreditLimitInfo.setMDN("9942530028");
		
		ResCreditLimitInfo resCreditLimitInfo = ivrWebService.executeCreditLimitInfo(ivrDataBean, reqCreditLimitInfo);
		System.out.println("Response Code : " +resCreditLimitInfo.getResponseCode());
		System.out.println("Credit Limit : " +resCreditLimitInfo.getCreditLimit());
		System.out.println("System Date : " +resCreditLimitInfo.getSysDate());
		
		System.out.println("***************************");
		
		ReqLastPaymentDetails reqLastPaymentDetails = new ReqLastPaymentDetails();
		reqLastPaymentDetails.setMDN("9942530028");
		
		ResLastPaymentDetails resLastPaymentDetails = ivrWebService.executeLastPaymentInfo(ivrDataBean, reqLastPaymentDetails);
		System.out.println("Response Code : " +resLastPaymentDetails.getResponseCode());
		System.out.println("Last Payment Amount : " +resLastPaymentDetails.getLastPaymentAmount());
		System.out.println("Last Payment Received Date : " +resLastPaymentDetails.getPaymentReceivedDate());
		System.out.println("Payment Type : " +resLastPaymentDetails.getPaymentType());
		
		System.out.println("***************************");
		
		ReqPushSMS reqPushSMS = new ReqPushSMS();
		reqPushSMS.setMDN("9942530028");
		reqPushSMS.setMessageText("Message");
		
		ResPushSMS resPushSMS = ivrWebService.executePushSMS(ivrDataBean, reqPushSMS);
		
		System.out.println("Response Code : " +resPushSMS.getResponseCode());
		
	}
	
}
