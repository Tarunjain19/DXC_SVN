package com.servion.rcom.ppp.hostinterface;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.ppp.hostinterface.util.HostConstants;
import com.servion.rcom.ppp.hostinterface.util.HostTransactionID;
import com.servion.rcom.ppp.hostinterface.util.Utilities;
import com.servion.rcom.ppp.hostinterface.view.ReqBillDeliveryStatus;
import com.servion.rcom.ppp.hostinterface.view.ResBillDeliveryStatus;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TransBillDeliveryStatus  implements ITransaction{

	ReqBillDeliveryStatus reqBillDeliveryStatus = null;
	ResBillDeliveryStatus resBillDeliveryStatus = new ResBillDeliveryStatus();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResBillDeliveryStatus getHostInterface(IVRDataBean ivrDataBean, ReqBillDeliveryStatus request) {
		
		logger = ivrDataBean.getLogger();
		
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_BILL_DELIVERY_STATUS);
		
		reqBillDeliveryStatus = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransBillDeliveryStatus getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransBillDeliveryStatus getHostInterface method end");
		return resBillDeliveryStatus;
	}
	
	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			//For Testing
			String serviceURL = null;
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_BILL_DELIVERY_STATUS);
			
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
			
			MDN = reqBillDeliveryStatus.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_BILL_DELIVERY_STATUS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling bill delivery status Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_BILL_DELIVERY_STATUS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling bill delivery status Service");
			
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
					
					MsgTokens msgTokens = response.getMsgTokens();
					List<Token> tokens = msgTokens.getToken();
					
					
					//Searching bill Info token through Parameter names
					Token billDeliveryStatusToken = null;
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BDS_BILL_GEN_DATE))
							{
								
								billDeliveryStatusToken = token;
									break;
								
							}
						}
					}
					
					//Searching bill info token through token id 
					/*Token billDeliveryStatusToken = null;
					for(Token token : tokens)
					{
						if(token.getTokenId().equalsIgnoreCase(HostConstants.STR_1));
						{
							billDeliveryStatusToken = token;
							break;
						}
					}*/
					
					
					String mode = null;
					String billGenDate = null;
					String billDeliveryDate = null;
					String billDeliveryStatus = null;
					
					if(billDeliveryStatusToken != null)
					{
						List<Param> listParam = billDeliveryStatusToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BDS_MODE))
							{
								mode = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BDS_BILL_GEN_DATE))
							{
								billGenDate = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BDS_BILL_DEL_DATE))
							{
								billDeliveryDate = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BDS_BILL_DEL_STATUS))
							{
								billDeliveryStatus = param.getValue();
							}
						}
					}
					
					
					logger.debug(uniqueId + "|" + "Bill Delivery Status - Mode : " +mode);
					logger.debug(uniqueId + "|" + "Bill Delivery Status - Bill Generation Date : " +billGenDate);
					logger.debug(uniqueId + "|" + "Bill Delivery Status - Bill Delivery Date : " +billDeliveryDate);
					logger.debug(uniqueId + "|" + "Bill Delivery Status - Bill Delivery Status : " +billDeliveryStatus);
					
					resBillDeliveryStatus.setMode(mode);
					resBillDeliveryStatus.setBillGenDate(billGenDate);
					resBillDeliveryStatus.setBillDeliveryDate(billDeliveryDate);
					resBillDeliveryStatus.setBillDeliveryStatus(billDeliveryStatus);
					
					
					msgTokens = null;
					tokens = null;
					billDeliveryStatusToken = null;
					
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
			
			resBillDeliveryStatus.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resBillDeliveryStatus.toString());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
