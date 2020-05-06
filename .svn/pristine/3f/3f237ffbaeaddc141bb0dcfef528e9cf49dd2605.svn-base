package com.servion.rdtv.hostinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.relianceada.si.crmgw.schemas.postpaid.RetailerDetails;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rdtv.hostinterface.util.HostConstants;
import com.servion.rdtv.hostservice.Utilities;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


public class FetchRetailerDetails implements ITransaction{
	
	private String uniqueId = null;
	RetailerDetails retailerDetails = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public RetailerDetails getHostInterface(IVRDataBean ivrDataBean, RetailerDetails request) {

		try{
		
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostConstants.TRANSACTIONID_GETCHANNELPARTNER_DETAILS);
			
			retailerDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransURLHitPushSMS getChannelPartner Details method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransURLHitPushSMS getChannelPartner Details method end");
			return retailerDetails;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return retailerDetails;
		}
	}
	
	@Override
	public void wsdlProcessor() {
		
		URL absoluteURL = null;
		DTH dth = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpURLConnection  = null;
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		StringBuilder sbUrlParameters = new StringBuilder(100);
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
			
			String Url = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.URL_HIT_GETCHANNEL_PARTNER_DETAILS_URL);
			String attrMessage = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.URL_HIT_GETCHANNEL_PARTNER_ATTRIBUE_MESSAGE_URL);
			String xmlHeader = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.URL_HIT_GETCHANNEL_PARTNER_DETAILS_XMLHEADER);
			String connectionTimeout =AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			String requestMethod = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG).getIVRProp(HostConstants.HOST_REQUEST_METHOD);
			
			String msgType = retailerDetails.getMsgType();
			String source = retailerDetails.getSource();
			String pin = retailerDetails.getPinCode();
			String cliNo = retailerDetails.getCliNo();
			String count = retailerDetails.getCount();
			
			logBuilder.append(uniqueId + "|" + "GetChannelMsg : " +msgType);
			logBuilder.append("|" + "source : " +source);
			logBuilder.append("|" + "pin : " +pin);
			logBuilder.append("|" + "cliNo : " +cliNo);
			logBuilder.append("|" + "count : " +count);
			logger.debug(logBuilder.toString());
						
			dth = new DTH();
			
			dth.setTIBCO_MSG_TYPE(msgType);
			dth.setSOURCE(source);
			dth.setPIN_CODE(pin);
			dth.setCLI_NO(cliNo);
			dth.setCOUNT(count);
			String xml = Utilities.getXMLFromObject(logger, DTH.class, dth, xmlHeader);
			
			logger.debug(uniqueId + "|" + "xml : " +xml);
			
			
			
			sbUrlParameters.append(Url);
			sbUrlParameters.append(attrMessage);
			sbUrlParameters.append("=");
			sbUrlParameters.append(xmlHeader);
			sbUrlParameters.append(xml);
			
			String strAbsoluteURL = sbUrlParameters.toString();
			
			logger.debug(uniqueId + "|" + "URL Parameters : " +Url+strAbsoluteURL);
			absoluteURL = new URL(Url);
			urlConnection = absoluteURL.openConnection();
			
			if(urlConnection instanceof HttpURLConnection)
			{
				httpURLConnection = (HttpURLConnection) urlConnection;
				//add request header
				httpURLConnection.setRequestMethod(requestMethod);
				
				if(connectionTimeout != null && connectionTimeout != HostConstants.EMPTY) httpURLConnection.setConnectTimeout(Integer.parseInt(connectionTimeout));
				if(requestTimeout != null && requestTimeout != HostConstants.EMPTY) httpURLConnection.setReadTimeout(Integer.parseInt(requestTimeout));
				
				//For Reporting
				host.setHOSTMETHOD(Url + HostConstants.PIPE);
				host.setHOSTINPARAMS(sbUrlParameters.toString());
				host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				// Send post request
				httpURLConnection.setDoOutput(true);
				writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
				writer.append(strAbsoluteURL);
				writer.flush();
				writer.close();
				
				int connectionResponseCode = httpURLConnection.getResponseCode();
				
				logger.debug(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				 logger.debug(uniqueId + "|" + "After sending request");
				 
				 responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
				 
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
			
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
			
		} catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
		}  
		finally{
			
			retailerDetails.setReponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(responseCode);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			absoluteURL = null;
			dth = null;
			sbUrlParameters = null;
			
			try{
				
				if(urlConnection != null) ((HttpURLConnection) urlConnection).disconnect();
				if(httpURLConnection != null) httpURLConnection.disconnect();
				
				urlConnection = null;
				httpURLConnection = null;
				
				if(writer != null){
					writer.close();
					writer = null;
				}
				if(reader != null){
					reader.close();
					reader = null;
				}
				
			}catch (IOException e) {
				logger.debug(uniqueId + "|" + "Finally IOException : " +e);
				logger.debug(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
			}
			
			urlConnection = null;
			httpURLConnection = null;
			writer = null;
			reader = null;
			logBuilder = null;
			
		}
		
	}

}
