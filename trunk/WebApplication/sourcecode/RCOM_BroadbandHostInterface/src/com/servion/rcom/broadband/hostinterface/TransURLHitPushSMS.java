package com.servion.rcom.broadband.hostinterface;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.broadband.hostinterface.util.HostConstants;
import com.servion.rcom.broadband.hostinterface.util.HostTransactionID;
import com.servion.rcom.broadband.hostinterface.util.Utilities;
import com.servion.rcom.broadband.hostinterface.view.ReqPushSMS;
import com.servion.rcom.broadband.hostinterface.view.ResPushSMS;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


public class TransURLHitPushSMS implements ITransaction{

	ReqPushSMS reqPushSMS = null;
	ResPushSMS resPushSMS = new ResPushSMS();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public ResPushSMS getHostInterface(IVRDataBean ivrDataBean, ReqPushSMS request) {

		try{
		
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_PUSH_SMS);
			
			reqPushSMS = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransURLHitPushSMS getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransURLHitPushSMS getHostInterface method end");
			return resPushSMS;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resPushSMS;
		}
	}

	@Override
	public void wsdlProcessor() {
		

		
		URL absoluteURL = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpURLconnection = null;
		InputStream inputStream = null;
		
		StringBuilder logBuilder = new StringBuilder(100);
		
			try {
				
				AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
				
				
				String url = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_URL);
				String attrMDN = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_ATTR_MDN);
				String attrMessage = appProperties.getIVRProp(HostConstants.URL_HIT_PUSH_SMS_ATTR_MESSAGE);
				String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
				String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
				
				String MDN = reqPushSMS.getMDN();
				String messageText = reqPushSMS.getMessageText();
				String encMessageText = URLEncoder.encode(messageText, "UTF-8");
				
				
				logBuilder.append(uniqueId + "|" + "URL To be hit : " +url);
				logBuilder.append("|" + "MDN : " +MDN);
				logBuilder.append("|" + "Message Text : " +messageText);
				logBuilder.append("|" + "UTF-8 Encoded Message Text : " +encMessageText);
				logger.debug(logBuilder.toString());
				
				String strAbsoluteURL = url + attrMDN + "=" + MDN + "&" + attrMessage + "=" +encMessageText;  
				
				logger.debug(uniqueId + "|" + "Absolute URL : " +strAbsoluteURL);
				
				
				 
				 absoluteURL = new URL(strAbsoluteURL);
				 urlConnection = absoluteURL.openConnection();
				 
				 if(urlConnection instanceof HttpURLConnection)
				 {
					 httpURLconnection = (HttpURLConnection) urlConnection;
					 if(connectionTimeout != null && connectionTimeout != HostConstants.EMPTY) httpURLconnection.setConnectTimeout(Integer.parseInt(connectionTimeout));
					 if(requestTimeout != null && requestTimeout != HostConstants.EMPTY) httpURLconnection.setReadTimeout(Integer.parseInt(requestTimeout));
					 int connectionResponseCode = httpURLconnection.getResponseCode();
					 logger.debug(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
					 logger.debug(uniqueId + "|" + "Before sending request");
					 
					 	//For Reporting
						host.setHOSTMETHOD(url + HostConstants.PIPE);
						host.setHOSTINPARAMS(MDN + HostConstants.PIPE + messageText);
						host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
					 
						inputStream = httpURLconnection.getInputStream();
					 
					 	//For Reporting
						host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
						
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
				 
			}catch (SocketTimeoutException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				Utilities.printStackTrace(logger, uniqueId, e);
			}
			catch (IOException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				Utilities.printStackTrace(logger, uniqueId, e);
			} catch (Exception e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				Utilities.printStackTrace(logger, uniqueId, e);
			}
			finally{
				resPushSMS.setResponseCode(responseCode);
				
				//For Reporting
				host.setHOSTOUTPARAMS(null);
				reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
				
				absoluteURL = null;
				
				
					try {
						
						if(urlConnection != null) ((HttpURLConnection) urlConnection).disconnect();
						if(httpURLconnection != null) httpURLconnection.disconnect();
						
						urlConnection = null;
						httpURLconnection = null;
						
						if(inputStream!= null) inputStream.close();
						inputStream = null;
					} catch (IOException e) {
					
						logger.debug(uniqueId + "|" + "Finally IOException : " +e);
						logger.debug(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
					}
					
					inputStream = null;
					urlConnection = null;
					httpURLconnection = null;
					logBuilder= null;
			}
			
	
		
	}

}
