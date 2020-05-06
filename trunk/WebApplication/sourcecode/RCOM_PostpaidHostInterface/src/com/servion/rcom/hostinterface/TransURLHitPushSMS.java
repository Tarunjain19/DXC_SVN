package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqPushSMS;
import com.servion.rcom.hostinterface.view.ResPushSMS;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


public class TransURLHitPushSMS implements ITransaction{

	ReqPushSMS reqPushSMS = null;
	ResPushSMS resPushSMS = new ResPushSMS();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public ResPushSMS getHostInterface(IVRDataBean ivrDataBean, ReqPushSMS request) {
		
		logger = ivrDataBean.getLogger();
		
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_PUSH_SMS);
		
		reqPushSMS = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransURLHitPushSMS getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransURLHitPushSMS getHostInterface method end");
		return resPushSMS;
	}

	@Override
	public void wsdlProcessor() {
		

		
		URL absoluteURL = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpURLconnection = null;
		InputStream inputStream = null;
		
			try {
				
				AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
				
				
				String url = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_URL);
				String attrMDN = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_ATTR_MDN);
				String attrMessage = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_ATTR_MESSAGE);
				
				
				String MDN = reqPushSMS.getMDN();
				String messageText = reqPushSMS.getMessageText();
				String encMessageText = URLEncoder.encode(messageText, "UTF-8");
				
				
				logger.debug(uniqueId + "|" + "URL To be hit : " +url);
				logger.debug(uniqueId + "|" + "MDN : " +MDN);
				logger.debug(uniqueId + "|" + "Message Text : " +messageText);
				logger.debug(uniqueId + "|" + "UTF-8 Encoded Message Text : " +encMessageText);
				
				String strAbsoluteURL = url + attrMDN + "=" + MDN + "&" + attrMessage + "=" +encMessageText;  
				
				logger.debug(uniqueId + "|" + "Absolute URL : " +strAbsoluteURL);
				
				
				 
				 absoluteURL = new URL(strAbsoluteURL);
				 urlConnection = absoluteURL.openConnection();
				 
				 if(urlConnection instanceof HttpURLConnection)
				 {
					 httpURLconnection = (HttpURLConnection) urlConnection;
					 int connectionResponseCode = httpURLconnection.getResponseCode();
					 logger.debug(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
					 logger.debug(uniqueId + "|" + "Before sending request");
					 
					 	//For Reporting
						host.setHOSTMETHOD(url + HostConstants.PIPE);
						host.setHOSTINPARAMS(MDN + HostConstants.PIPE + messageText);
						host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
					 
						inputStream = httpURLconnection.getInputStream();
					 
					 	//For Reporting
						host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
						
					 logger.debug(uniqueId + "|" + "After sending request");
					 
					 responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					 
					 	//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
				 }
				 else
				 {
					 logger.debug(uniqueId + "|" + "Other than HTTP URL, Hence request not sent");
					 
					 	//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					 
					 responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				 }
				 
			} catch (MalformedURLException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
				logger.error(uniqueId + "|" + "MalformedURLException : " +e);
				logger.error(uniqueId + "|" + "MalformedURLException : " +e.getMessage());
				
			} catch(UnsupportedEncodingException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
				logger.error(uniqueId + "|" + "UnsupportedEncodingException" +e);
				logger.error(uniqueId + "|" + "UnsupportedEncodingException Message : " +e.getMessage());
				
			}
			catch (IOException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
				logger.error(uniqueId + "|" + "IOException : " +e);
				logger.error(uniqueId + "|" + "IOException Message : " +e.getMessage());
				
			} catch (Exception e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
				logger.error(uniqueId + "|" + "Exception Occured : " +e);
				logger.error(uniqueId + "|" + "Exception Error Message : " +e.getMessage());
			}
			finally{
				resPushSMS.setResponseCode(responseCode);
				
				//For Reporting
				host.setHOSTOUTPARAMS("NA");
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
				
				absoluteURL = null;
				urlConnection = null;
				httpURLconnection = null;
				if(inputStream!= null)
				{
					try {
						inputStream.close();
					} catch (IOException e) {
					
						logger.error(uniqueId + "|" + "Finally IOException : " +e);
						logger.error(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
					}
				}
				inputStream = null;
				
			}
			
	
		
	}

}
