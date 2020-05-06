package com.servion.rcom.hni.hostinterface;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hni.hostinterface.util.HostConstants;
import com.servion.rcom.hni.hostinterface.util.HostTransactionID;
import com.servion.rcom.hni.hostinterface.util.Utilities;
import com.servion.rcom.hni.hostinterface.view.ReqStorePTP;
import com.servion.rcom.hni.hostinterface.view.ResStorePTP;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;

public class TransStorePTP implements ITransaction{

	ReqStorePTP reqStorePTP = null;
	ResStorePTP resStorePTP = new ResStorePTP();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResStorePTP getHostInterface(IVRDataBean ivrDataBean , ReqStorePTP request) {
		
		logger = ivrDataBean.getLogger();
		
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_STORE_PTP);
		
		reqStorePTP = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransStorePTP getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransStorePTP getHostInterface method end");
		return resStorePTP;
	}
	
	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		String ptpAmount = null;
		boolean isPtpByCash = false;
		boolean isPtpByCheque = false;
		boolean isPtpByCreditCard = false;
		boolean isPtpByDebitCard = false;
		String ptpMode = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			//For Testing
			String serviceURL = null;
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_STORE_PTP);
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			csssoapReciever = new CSSSOAPReciever(url);
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			MDN = reqStorePTP.getMDN();
			ptpAmount = reqStorePTP.getPtpAmount();
			isPtpByCash = reqStorePTP.isPtpByCash();
			isPtpByCheque = reqStorePTP.isPtpByCheque();
			isPtpByCreditCard = reqStorePTP.isPtpByCreditCard();
			isPtpByDebitCard = reqStorePTP.isPtpByDebitCard();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			logger.debug(uniqueId + "|" + "PTP Amount" +ptpAmount);
			logger.debug(uniqueId + "|" + "Is PTP By Cash : " +isPtpByCash);
			logger.debug(uniqueId + "|" + "Is PTP By Cheque :  : " +isPtpByCheque);
			logger.debug(uniqueId + "|" + "Is PTP By Credit Card :  : " +isPtpByCreditCard);
			logger.debug(uniqueId + "|" + "Is PTP By Debit Card :  : " +isPtpByDebitCard);
			
			if(isPtpByCash)
				ptpMode = HostConstants.PARAM_PTP_MODE_CASH;
			else if(isPtpByCheque)
				ptpMode = HostConstants.PARAM_PTP_MODE_CHEQUE;
			else if(isPtpByCreditCard)
				ptpMode = HostConstants.PARAM_PTP_MODE_CREDIT_CARD;
			else
				ptpMode = HostConstants.PARAM_PTP_MODE_DEBIT_CARD;
			
			logger.debug(uniqueId + "|" + "PTP Mode : " +ptpMode);
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_STORE_PTP));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			Param userIdParam = new Param();
			userIdParam.setId(HostConstants.PARAM_PTP_USER_ID);
			userIdParam.setValue(appProperties.getIVRProp(HostConstants.PTP_USER_ID));
			userIdParam.setType(HostConstants.PARAM_TYPE_STRING);
			
			Param userIpParam =new Param();
			userIpParam.setId(HostConstants.PARAM_PTP_USER_IP);
			userIpParam.setValue(appProperties.getIVRProp(HostConstants.PTP_USER_IP));
			userIpParam.setType(HostConstants.PARAM_TYPE_NUMBER);
			
			Param ptpModeParam = new Param();
			ptpModeParam.setId(HostConstants.PARAM_PTP_MODE);
			ptpModeParam.setValue(ptpMode);
			ptpModeParam.setType(HostConstants.PARAM_TYPE_STRING);
			
			Param ptpAmountParam = new Param();
			ptpAmountParam.setId(HostConstants.PARAM_PTP_AMOUNT);
			ptpAmountParam.setValue(ptpAmount);
			ptpAmountParam.setType(HostConstants.PARAM_TYPE_DOUBLE);
			
			request.getParam().add(userIdParam);
			request.getParam().add(userIpParam);
			request.getParam().add(ptpModeParam);
			request.getParam().add(ptpAmountParam);
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling Store PTP Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_STORE_PTP));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+ userIdParam.getValue() + HostConstants.PIPE + userIpParam.getValue() + HostConstants.PIPE + ptpModeParam.getValue() + HostConstants.PIPE + ptpAmountParam.getValue() + HostConstants.PIPE + request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling Store PTP Service");
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.debug(uniqueId + "|" + "Host Response Error Code : " +errorCode);

				if((errorCode != null) && (!HostConstants.EMPTY.equalsIgnoreCase(errorCode)) && 
						(appProperties.getIVRProp(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(errorCode)){
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					
				}else{
					
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					logger.debug(uniqueId + "|" + "Host Response Error Message : " +errorMessage);
				}
						
			}
			
		} catch (MalformedURLException e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			
			logger.error(uniqueId + "|" + "MalformedURLException : " +e);
			logger.error(uniqueId + "|" + "MalformedURLException Message: " +e.getMessage());
			
		} catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			
			logger.error(uniqueId + "|" + "Exception Occured : " +e);
			logger.error(uniqueId + "|" + "Exception Error Message : " +e.getMessage());
			
		} finally {
			
			resStorePTP.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
