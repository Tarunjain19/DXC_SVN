package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.rcom.hostinterface.util.HttpRequest;
import com.servion.rcom.hostinterface.util.QueryString;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.util.HostConstants.ComplaintStatus;
import com.servion.rcom.hostinterface.view.ReqAccountDetails;
import com.servion.rcom.hostinterface.view.ReqDuplicateBillRequest;
import com.servion.rcom.hostinterface.view.ReqLastPaymentDetails;
import com.servion.rcom.hostinterface.view.ReqLatestBillGenDetails;
import com.servion.rcom.hostinterface.view.ReqRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ReqRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.view.ReqValidateAccountNumber;
import com.servion.rcom.hostinterface.view.ResAccountDetails;
import com.servion.rcom.hostinterface.view.ResDuplicateBillRequest;
import com.servion.rcom.hostinterface.view.ResLastPaymentDetails;
import com.servion.rcom.hostinterface.view.ResLatestBillGenDetails;
import com.servion.rcom.hostinterface.view.ResRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ResRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.view.ResValidateAccountNumber;
import com.servion.rcom.hostinterface.wrapper.IVRWebService;
import com.servion.rcom.hostinterface.wrapper.IVRWebServiceImpl;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class Main {

	public static void main(String[] args)
	{
		/*Logger logger = Logger.getLogger(Main.class);
		try {
			QueryString qs = new QueryString("feld1", "NULL");
			qs.add("feld2", "100179814");
			qs.add("feld3", "NULL");
			qs.add("feld4", "NULL");
			qs.add("feld5", "NULL");
			qs.add("feld6", "30094161");
			qs.add("feld7", "5");
			qs.add("feld8", "1");
			
			String strURL = "http://172.16.12.178:8080/URL_HIT_DEMO/LoginServlet?";
			HttpRequest httpRequest = new HttpRequest(strURL, qs.toString(), "GET", null, logger);
			StringBuffer responseMessage = httpRequest.call();
			
			System.out.println("Response message : " +responseMessage);
			
		} catch (UnsupportedEncodingException e) {
			Utilities.printStackTrace(logger, "Temp ID", e);
		} catch (MalformedURLException e) {
			Utilities.printStackTrace(logger, "Temp ID", e);
		} catch (IOException e) {
			Utilities.printStackTrace(logger, "Temp ID", e);
		}*/
		
		/*String res = "REL_INVALID_CA";
		String[] resFields = res.split(",");
		System.out.println(resFields.length);*/
		
		Logger logger = Logger.getLogger(Main.class);
		AppProperties.setInstance("Energy_Hostservice", "D:/New Volume (E)/C/ProjectList/RCOM/AAOD_7_0/AAOD7.0/apache-tomcat-7.0.61_RCOM/webapps/RCOM/REL/");
		
		IVRWebService ivrWebService = new IVRWebServiceImpl();
		
		
		IVRDataBean ivrDataBean = new IVRDataBean();
		GetReportObject  getReportObject = new GetReportObject();
		getReportObject.setIvrreportdata(getReportObject.createIVRReportObject());
		ivrDataBean.setSessionID("1234");
		ivrDataBean.setLogger(logger);
		ivrDataBean.setGetReportObject(getReportObject);
		
		/*ReqValidateAccountNumber reqValidateAccountNumber = new ReqValidateAccountNumber();
		reqValidateAccountNumber.setAccountNo("182737383");
		
		ResValidateAccountNumber resValidateAccountNumber = ivrWebService.validateAccountNumber(ivrDataBean, reqValidateAccountNumber);
		System.out.println("Response Code : " +resValidateAccountNumber.getResponseCode());
		System.out.println("Is Valid Account : " +resValidateAccountNumber.isValidAccount());
		System.out.println("Consumer Name : " +resValidateAccountNumber.getConsumerName());*/
		
		/*ReqAccountDetails reqAccountDetails = new ReqAccountDetails();
		reqAccountDetails.setMDN("9942530028");
		
		ResAccountDetails resAccountDetails = ivrWebService.getAccountDetails(ivrDataBean, reqAccountDetails);
		
		System.out.println("Response Code : " +resAccountDetails.getResponseCode());
		System.out.println("Is Valid MDN : " +resAccountDetails.isValidMDN());
		System.out.println("Is Single Account : " +resAccountDetails.isSingleAccountFound());
		System.out.println("Is Multiple Account : " +resAccountDetails.isMulAccFound());
		System.out.println("Is No Account Found : " +resAccountDetails.isNoAccFound());
		System.out.println("Account No : " +resAccountDetails.getAccountNumber());
		System.out.println("Consumer Name : " +resAccountDetails.getConsumerName());*/
		
		/*ReqDuplicateBillRequest reqDuplicateBillRequest = new ReqDuplicateBillRequest();
		reqDuplicateBillRequest.setAccountNo("1100285611");
		reqDuplicateBillRequest.setMDN("9942530028");
		
		ResDuplicateBillRequest resDuplicateBillRequest = ivrWebService.registerDuplicateBillRequest(ivrDataBean, reqDuplicateBillRequest);
		
		System.out.println("Response Code : " +resDuplicateBillRequest.getResponseCode());
		System.out.println("Service Request No : " +resDuplicateBillRequest.getServiceRequestNumber());*/
		
		/*ReqLastPaymentDetails reqLastPaymentDetails = new ReqLastPaymentDetails();
		reqLastPaymentDetails.setAccountNo("1100285611");
		reqLastPaymentDetails.setMDN("9942530028");
		
		ResLastPaymentDetails resLastPaymentDetails = ivrWebService.getLastPaymentDetails(ivrDataBean, reqLastPaymentDetails);
		
		System.out.println("Response Code : " +resLastPaymentDetails.getResponseCode());
		System.out.println("Last Payment Received Date : " +resLastPaymentDetails.getLastPaymentReceivedDate());
		System.out.println("Total Amount Received : " +resLastPaymentDetails.getTotalAmtReceived());
		System.out.println("Mode of payment : " +resLastPaymentDetails.getModeOfPayment());*/
		
		/*ReqLatestBillGenDetails reqLatestBillGenDetails = new ReqLatestBillGenDetails();
		reqLatestBillGenDetails.setAccountNo("1100285611");
		reqLatestBillGenDetails.setMDN("9942530028");
		
		ResLatestBillGenDetails resLatestBillGenDetails = ivrWebService.getLatestBillGenerationDetails(ivrDataBean, reqLatestBillGenDetails);
		
		System.out.println("Response Code : " +resLatestBillGenDetails.getResponseCode());
		System.out.println("Latest Bill Amount : " +resLatestBillGenDetails.getLatestBillAmount());
		System.out.println("Latest Bill Generation Date : " +resLatestBillGenDetails.getLatestBillGenerationDate());
		System.out.println("Due date : " +resLatestBillGenDetails.getDueDate());*/
		
		/*ReqRegisterFireAndShockComplaint reqRegisterFireAndShockComplaint = new ReqRegisterFireAndShockComplaint();
		reqRegisterFireAndShockComplaint.setAccountNo("1100285611");
		reqRegisterFireAndShockComplaint.setMDN("9942530028");
		
		ResRegisterFireAndShockComplaint resRegisterFireAndShockComplaint = ivrWebService.registerFireAndShockComplaint(ivrDataBean, reqRegisterFireAndShockComplaint);
		
		System.out.println("Response Code : " + resRegisterFireAndShockComplaint.getResponseCode());
		System.out.println("Is Complaint Registered :" +resRegisterFireAndShockComplaint.isComplaintRegistered());
		System.out.println("Complaint Number : " +resRegisterFireAndShockComplaint.getComplaintNumber());*/
		
		/*ReqRegisterNoSupplyComplaint reqRegisterNoSupplyComplaint = new ReqRegisterNoSupplyComplaint();
		reqRegisterNoSupplyComplaint.setAccountNo("1100285611");
		reqRegisterNoSupplyComplaint.setMDN("9942530028");
		reqRegisterNoSupplyComplaint.setIndividual(true);
		
		ResRegisterNoSupplyComplaint resRegisterNoSupplyComplaint = ivrWebService.registerNoSupplyComplaint(ivrDataBean, reqRegisterNoSupplyComplaint);
		
		System.out.println("Response Code : " +resRegisterNoSupplyComplaint.getResponseCode());
		System.out.println("Is Valid Account : " +resRegisterNoSupplyComplaint.isValidAccount());
		System.out.println("Is Known Outage : " +resRegisterNoSupplyComplaint.isKnownOutage());
		System.out.println("Is Station down : " +resRegisterNoSupplyComplaint.isStationDown());
		System.out.println("Complaint Status : " + resRegisterNoSupplyComplaint.getComplaintStatus());
		System.out.println("Complaint Number : " +resRegisterNoSupplyComplaint.getComplaintNumber());
		System.out.println("TAT : " +resRegisterNoSupplyComplaint.getTAT());
		
		
		System.out.println(resRegisterNoSupplyComplaint.getComplaintStatus().compareTo(ComplaintStatus.FRESH_COMPLAINT));*/
		
		ReqRegisterNoSupplyComplaint reqRegisterNoSupplyComplaint = new ReqRegisterNoSupplyComplaint();
		reqRegisterNoSupplyComplaint.setAccountNo("1100285611");
		reqRegisterNoSupplyComplaint.setMDN("9942530028");
		reqRegisterNoSupplyComplaint.setIndividual(false);
		
		ResRegisterNoSupplyComplaint resRegisterNoSupplyComplaint = ivrWebService.registerNoSupplyComplaint(ivrDataBean, reqRegisterNoSupplyComplaint);
		
		System.out.println("Response Code : " +resRegisterNoSupplyComplaint.getResponseCode());
		System.out.println("Is Valid Account : " +resRegisterNoSupplyComplaint.isValidAccount());
		System.out.println("Is Known Outage : " +resRegisterNoSupplyComplaint.isKnownOutage());
		System.out.println("Is Station down : " +resRegisterNoSupplyComplaint.isStationDown());
		System.out.println("Complaint Status : " + resRegisterNoSupplyComplaint.getComplaintStatus());
		System.out.println("Complaint Number : " +resRegisterNoSupplyComplaint.getComplaintNumber());
		System.out.println("TAT : " +resRegisterNoSupplyComplaint.getTAT());
		
		
	/*	try {
			URL url = new URL("http://www.kesav.com/Energy/Servlet1?");
			URLConnection urlConnection = url.openConnection();
			urlConnection.setConnectTimeout(3000);
			System.out.println("---");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
/*
		try {
			System.out.println(Utilities.generateUniqueID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
}
