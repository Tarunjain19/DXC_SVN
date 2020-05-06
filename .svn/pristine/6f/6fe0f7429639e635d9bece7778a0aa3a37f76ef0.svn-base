package com.servion.rcom.hostinterface;

import java.net.URL;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqAccountBalance;
import com.servion.rcom.hostinterface.view.ResAccountBalance;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;


//TODO : Pending WSDL, service names
public class TransAccountBalance implements ITransaction{

	
	ReqAccountBalance reqAccountBalance = null;
	ResAccountBalance resAccountBalance = new ResAccountBalance();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResAccountBalance getHostInterface(IVRDataBean ivrDataBean, ReqAccountBalance request) {
		
		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_ACCOUNT_BALANCE);
			
			reqAccountBalance = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.info(uniqueId + "|" + "TransAccountBalance getHostInterface method start");
			wsdlProcessor();
			logger.info(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.info(uniqueId + "|" + "TransAccountBalance getHostInterface method end");
			return resAccountBalance;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resAccountBalance;
		}
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_ACC_BAL);
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.info(uniqueId + "|" + "Service URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			csssoapReciever = new CSSSOAPReciever(url);
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			MDN = reqAccountBalance.getMDN();
			
			logger.info(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.info(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_ACCOUNT_BALANCE));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.info(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.info(uniqueId + "|" + "Before calling accountBalance Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_ACCOUNT_BALANCE));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.info(uniqueId + "|" + "After calling accountBalance Service");
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.info(uniqueId + "|" + "Host Response Error Code : " +errorCode);

				if((errorCode != null) && (!HostConstants.EMPTY.equalsIgnoreCase(errorCode)) && 
						(appProperties.getIVRProp(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(errorCode)){
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					MsgTokens msgTokens = response.getMsgTokens();
					List<Token> tokens = msgTokens.getToken();
					
					
					//Searching Balance token through Parameter names
					Token balToken = null;
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BALANCE_NAME))
							{
								if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_CORE_BALANCE))
								{
									balToken = token;
									System.out.println(param.getValue());
									break;
								}
								
							}
						}
					}
					
					//Searching Balance token throuth token id 
					/*Token balToken = null;
					for(Token token : tokens)
					{
						if(token.getTokenId().equalsIgnoreCase(HostConstants.STR_1));
						{
							balToken = token;
							break;
						}
					}*/
					
					String accBal = null;
					String accBalExpDate = null;
					
					if(balToken != null)
					{
						List<Param> listParam = balToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALUE))
							{
								accBal = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALIDITY))
							{
								accBalExpDate = param.getValue();
							}
						}
					}
					
					
					logger.info(uniqueId + "|" + "Account Balance : " +accBal);
					logger.info(uniqueId + "|" + "Account Balance Expiry Date : " +accBalExpDate);
					
					resAccountBalance.setAccBalance(accBal);
					resAccountBalance.setAccBalanceExpiryDate(accBalExpDate);
					
					
					msgTokens = null;
					tokens = null;
					balToken = null;
					
					
				}else{
					
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					logger.info(uniqueId + "|" + "Host Response Error Message : " +errorMessage);
				}
						
			}
			
		}catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			Utilities.printStackTrace(logger, uniqueId, e);
			
		} finally {
			
			resAccountBalance.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resAccountBalance.getAccBalance()+HostConstants.PIPE+resAccountBalance.getAccBalanceExpiryDate());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
