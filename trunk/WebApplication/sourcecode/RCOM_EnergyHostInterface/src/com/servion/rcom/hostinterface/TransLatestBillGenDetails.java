package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.HttpRequest;
import com.servion.rcom.hostinterface.util.QueryString;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqLatestBillGenDetails;
import com.servion.rcom.hostinterface.view.ResLatestBillGenDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class TransLatestBillGenDetails implements ITransaction{

	ReqLatestBillGenDetails reqLatestBillGenDetails = null;
	ResLatestBillGenDetails resLatestBillGenDetails = new ResLatestBillGenDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	
	public ResLatestBillGenDetails getHostInterface(IVRDataBean ivrDataBean, ReqLatestBillGenDetails request){
		
		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_LATEST_BILL_GEN_DETAILS);
			host.setHOSTMETHOD(HostTransactionID.TRANS_LATEST_BILL_GEN_DETAILS);
			
			reqLatestBillGenDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransLatestBillGenDetails getHostInterface method start");
			processor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransLatestBillGenDetails getHostInterface method end");
			return resLatestBillGenDetails;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resLatestBillGenDetails;
		}
	}
	
	@Override
	public void processor() {
		
		String strURL = null;
		String IVRSerialNo = null;
		String accountNo = null;
		String MDN = null;
		String latestBillGenerationDate = null;
		String latestBillAmount = null;
		String dueDate = null;
		String requestMethod = null;
		String connectionTimeout = null;
		String readTimeout = null;
		String userAgent = null;
		QueryString qs = null;
		AppProperties hostProperties = null;
		String strResMessage = HostConstants.EMPTY;
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
		
			hostProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			accountNo = reqLatestBillGenDetails.getAccountNo();
			MDN = reqLatestBillGenDetails.getMDN();

			
			requestMethod = hostProperties.getIVRProp(HostConstants.URL_REQUEST_METHOD);
			if(requestMethod == null || requestMethod.equalsIgnoreCase(HostConstants.EMPTY)) requestMethod = HostConstants.URL_REQUEST_METHOD_POST;
			userAgent = hostProperties.getIVRProp(HostConstants.USER_AGENT);
			IVRSerialNo = hostProperties.getIVRProp(HostConstants.IVR_SERIAL_NUMBER);
			strURL = hostProperties.getIVRProp(HostConstants.ENDPOINT_URL_LATEST_BILL_GEN_DETAILS);
			connectionTimeout = hostProperties.getIVRProp(HostConstants.CONNECTION_TIMEOUT);
			readTimeout = hostProperties.getIVRProp(HostConstants.READ_TIMEOUT);
			
			logBuilder.append(uniqueId + "|" + "Endpoint URL : " +strURL);
			logBuilder.append("|" + "Request Method : " +requestMethod);
			logBuilder.append("|" + "IVR Serial No : " +IVRSerialNo);
			
			logBuilder.append("|" + "Inputs from IVR : ");
			logBuilder.append("|" + "Account Number : " +accountNo);
			logBuilder.append("|" + "MDN : " +MDN);
			
			logger.debug(logBuilder);
			
			qs = new QueryString(HostConstants.FIELD1, IVRSerialNo);
			qs.add(HostConstants.FIELD2, accountNo);
			qs.add(HostConstants.FIELD3, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD4, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD5, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD6, MDN);
			qs.add(HostConstants.FIELD7, HostConstants.STR_5);
			qs.add(HostConstants.FIELD8, HostConstants.STR_1);
			

			HttpRequest httpRequest = new HttpRequest(strURL, qs.toString(), requestMethod, userAgent, logger, connectionTimeout, readTimeout);
			host.setHOSTINPARAMS(URLDecoder.decode(qs.toString(), HostConstants.DECODE_FORMAT));
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			StringBuffer responseMessage = httpRequest.call();
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			logger.debug("Response Message : " +responseMessage);
			
			if(responseMessage!= null && !responseMessage.equals(HostConstants.EMPTY) && responseMessage.length() != 0)
			{
				strResMessage = responseMessage.toString();
				
				if(strResMessage.split(HostConstants.COMMA_SEPERATOR).length > 1)
				{
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					resLatestBillGenDetails.setValidAccount(true);
					
					String[] resFields = strResMessage.split(HostConstants.COMMA_SEPERATOR);
					
					latestBillGenerationDate = resFields[3];
					latestBillAmount = resFields[4];
					dueDate = resFields[5];
					
					logBuilder.setLength(0);
					logBuilder.append(uniqueId + "|" + "Latest Bill Generation date : " +latestBillGenerationDate);
					logBuilder.append("|" + "Latest Bill Amount : " +latestBillAmount);
					logBuilder.append("|" + "Due date : " +dueDate);
					
					latestBillAmount = Utilities.adjustDecimal(logger, latestBillAmount);
					
					logBuilder.append(uniqueId + "|" + "Latest Bill Amount adjustDecimal : " +latestBillAmount);
					
					logger.debug(logBuilder);
					
					resLatestBillGenDetails.setLatestBillGenerationDate(latestBillGenerationDate);
					resLatestBillGenDetails.setLatestBillAmount(latestBillAmount);
					resLatestBillGenDetails.setDueDate(dueDate);
				}
				else
				{
					if(strResMessage.contains(HostConstants.EXCEPTION_MESSAGE_REL_INVALID_CA))
					{
						responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
						resLatestBillGenDetails.setValidAccount(false);
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					}
					else
					{
						responseCode = HostConstants.RESPONSE_CODE_FAILURE;
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					}
				}
			}
			else
			{
				logger.debug("Response Message is null (or) Empty (or) size 0, Hence returning Hosttimeout response code. ");
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			}
			
		
		}catch(SocketTimeoutException e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		} catch (IOException e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		} catch(Exception e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		}
		
		finally{

			resLatestBillGenDetails.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(strResMessage);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			logBuilder = null;
		}
		
	}

}
