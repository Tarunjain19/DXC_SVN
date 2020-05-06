package com.rcom.hostinterface;



import org.apache.log4j.Logger;

import com.rcom.hostinterface.view.ReqActivePacks;
import com.rcom.hostinterface.view.ResActivePacks;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.rcom.hostinterface.util.DOMParsing;
import com.rcom.hostinterface.util.HttpRequest;
import com.rcom.hostinterface.util.HostConstants;
import com.rcom.hostinterface.util.HostTransactionID;
import com.rcom.hostinterface.util.Utilities;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class TransActivePacks {

	ReqActivePacks reqActivePacks = new ReqActivePacks();
	ResActivePacks resActivePacks = new ResActivePacks();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	@SuppressWarnings("finally")
	public ResActivePacks getHostInterface(IVRDataBean ivrDataBean,
			ReqActivePacks request) {
		
		try
		{
		uniqueId = Utilities.generateUniqueID();
		logger = ivrDataBean.getLogger();
		reqActivePacks = request; 	
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_ACTIVE_PACKS);
		host.setHOSTMETHOD(HostTransactionID.TRANS_ACTIVE_PACKS);
	
		uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransActivePacks getHostInterface method start");
		processor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransActivePacks getHostInterface method end");

			
		}
		catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
				
		}
		finally{
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			return resActivePacks;
		}
		
	}

	public void processor() {
		
		String strURL = null;
		String MDN = null;
		String requestMethod = null;
		String connectionTimeout = null;
		AppProperties hostProperties = null;
		StringBuilder logBuilder = new StringBuilder(100);
		String hostResponse = HostConstants.REPORT_HOST_STATUS_FAILURE,hostStatus = HostConstants.LINK_DOWN,hostOutput = HostConstants.REPORT_HOST_STATUS_FAILURE;
		
		try {
		
			AppProperties.setInstance(HostConstants.GLOBALHOSTCONFIG, "C:/RCOM/OtherFlows/RCOM_CF_VAS/");
			hostProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			logger.debug(uniqueId + "|" + "hostProperties"+hostProperties);
			MDN = reqActivePacks.getMdn();
			logger.debug(uniqueId + "|" + "MDN"+MDN);
			resActivePacks.setResponseCode(HostConstants.RESPONSE_CODE_FAILURE);
			
			requestMethod = hostProperties.getIVRProp(HostConstants.URL_REQUEST_METHOD);
			if(requestMethod == null || requestMethod.equalsIgnoreCase(HostConstants.EMPTY)) requestMethod = HostConstants.URL_REQUEST_METHOD_POST;
			strURL = hostProperties.getIVRProp(HostConstants.ENDPOINT_URL_GET_VAS);
			connectionTimeout = hostProperties.getIVRProp(HostConstants.CONNECTION_TIMEOUT);
			
			logger.debug(uniqueId + "|" + "strURL"+strURL);
			logBuilder.append(uniqueId + "|" + "Endpoint URL : " +strURL);
			logBuilder.append("|" + "Request Method : " +requestMethod);
						
			logBuilder.append("|" + "Inputs from IVR : ");
			logBuilder.append("|" + "MDN : " +MDN);
			
			logger.debug(logBuilder);
			
			//xml = (new FormXML()).getXML(MDN,logger);
			//cUSTOMIZING URL
			strURL = strURL.replace("MDN",MDN);
			logger.debug("Complete Url ::"+strURL);
			System.out.println("Complete Url ::"+strURL);
			
			HttpRequest httpRequest = new HttpRequest(strURL, logger, connectionTimeout);
			host.setHOSTINPARAMS(MDN);
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			StringBuffer responseMessage = httpRequest.call();
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			logger.debug("Response Message : " +responseMessage);
			if(responseMessage!= null && !responseMessage.equals(HostConstants.EMPTY) && responseMessage.length() != 0)
			{
				DOMParsing dom = new DOMParsing();
				resActivePacks = dom.domParsing(resActivePacks, responseMessage.toString());
				if(resActivePacks.getResponseCode().equalsIgnoreCase(HostConstants.RESPONSE_CODE_FAILURE)){
					//host.setHOSTRESPONSE();
					//host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					//host.setHOSTOUTPARAMS(responseMessage.toString());
					hostResponse = HostConstants.REPORT_HOST_STATUS_FAILURE;
					hostStatus = HostConstants.REPORT_HOST_STATUS_FAILURE;
					hostOutput = resActivePacks.getResponseCode();
				}
				else{
					//host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					//host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					//host.setHOSTOUTPARAMS(resActivePacks.getResponseCode()+"|"+resActivePacks.getPackCodes()+"|"+resActivePacks.getPackNames()+"|"+resActivePacks.getResponseMessage());
					hostResponse = HostConstants.REPORT_HOST_STATUS_SUCCESS;
					hostStatus = HostConstants.REPORT_HOST_STATUS_SUCCESS;
					hostOutput = resActivePacks.getResponseCode()+"|"+resActivePacks.getPackCodes()+"|"+resActivePacks.getPackNames()+"|"+resActivePacks.getResponseMessage();
				}
					
			}
					
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			host.setHOSTRESPONSE(hostResponse);
			host.setHOSTSTATUS(hostStatus);
			host.setHOSTOUTPARAMS(hostOutput);
		}
	}
}
