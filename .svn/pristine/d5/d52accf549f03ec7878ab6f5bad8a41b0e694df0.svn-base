package com.servion.rcom.broadband.hostinterface;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.rcom.broadband.hostinterface.util.HostConstants;
import com.servion.rcom.broadband.hostinterface.view.CreditCardDetails;
import com.servion.rcom.broadband.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ReqPushSMS;
import com.servion.rcom.broadband.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.rcom.broadband.hostinterface.view.ResPushSMS;
import com.servion.rcom.broadband.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.broadband.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Main {

	public static void main(String[] args)
	{
		Logger logger = Logger.getLogger(Main.class);
		AppProperties.setInstance(HostConstants.GLOBALHOSTCONFIG, "D:/v2.1/ARCOM_Workspace/RCOM_BroadbandHostInterface/config/hostconfig/");
		
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		ReqPushSMS reqPushSMS = new ReqPushSMS();
		reqPushSMS.setMDN("9942530028");
		reqPushSMS.setMessageText("Message");
		
		ResPushSMS resPushSMS = ivrWebService.executePushSMS(ivrDataBean, reqPushSMS);
		System.out.println("Push SMS Response Code : " +resPushSMS.getResponseCode());
		
		System.out.println("***************************");
		
		ReqPaymentUsingCreditcard reqPaymentUsingCreditcard = new ReqPaymentUsingCreditcard();
		reqPaymentUsingCreditcard.setAmount("100");
		reqPaymentUsingCreditcard.setMDN("9942530028");
		reqPaymentUsingCreditcard.setMDNToBeRecharged("9942153546");
		reqPaymentUsingCreditcard.setOTP("3123");
		
		CreditCardDetails cardDetails = new CreditCardDetails();
		cardDetails.setCardCVV("121");
		cardDetails.setCardExpiryDate("122017");
		cardDetails.setCardNumber("12345678912345678");
		cardDetails.setCardType("V");
		
		reqPaymentUsingCreditcard.setCreditCardDetails(cardDetails);
		
		ResPaymentUsingCreditcard resPaymentUsingCreditcard = ivrWebService.executePaymentUsingCreditcard(ivrDataBean, reqPaymentUsingCreditcard);
		
		System.out.println("Bill pay using credit card Response Code : " +resPaymentUsingCreditcard.getResponseCode());
		System.out.println("Payment ID : " +resPaymentUsingCreditcard.getPaymentId());
		
		System.out.println("***************************");
	}
	
}
