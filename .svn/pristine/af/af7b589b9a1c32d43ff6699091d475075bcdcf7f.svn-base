package com.servion.rcom.hni.hostinterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hni.hostinterface.util.HostConstants;
import com.servion.rcom.hni.hostinterface.util.HostTransactionID;
import com.servion.rcom.hni.hostinterface.util.Utilities;
import com.servion.rcom.hni.hostinterface.view.ReqLastThreeTransactions;
import com.servion.rcom.hni.hostinterface.view.ResLastThreeTransactions;
import com.servion.rcom.hni.hostinterface.view.TransactionDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TransLastThreeTransactions implements ITransaction{

	ReqLastThreeTransactions reqLastThreeTransactions = null;
	ResLastThreeTransactions resLastThreeTransactions = new ResLastThreeTransactions();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResLastThreeTransactions getHostInterface(IVRDataBean ivrDataBean, ReqLastThreeTransactions request){

		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_LAST3_TRANSACTIONS);
			
			reqLastThreeTransactions = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransLastThreeTransactions getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransLastThreeTransactions getHostInterface method end");
			return resLastThreeTransactions;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resLastThreeTransactions;
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_LAST3);
			
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
			
			MDN = reqLastThreeTransactions.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_LAST3_TRANSACTIONS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling last three transaction Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_LAST3_TRANSACTIONS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling last three transaction Service");
			
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
					
					
					//Searching last three transaction token through amount parameter
					List<Token> lastThreeTransactionTokens = new ArrayList<Token>();
					/*for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_TXN_AMOUNT))
							{
								lastThreeTransactionTokens.add(token);
								
							}
						}
					}*/
					
					
					//Searching last three transaction token through Token ID
					/*for(Token token : tokens)
					{
						String tokenID = token.getTokenId();
						
						if(tokenID.equalsIgnoreCase(HostConstants.STR_1) || tokenID.equalsIgnoreCase(HostConstants.STR_2) || tokenID.equalsIgnoreCase(HostConstants.STR_3))
						{
							lastThreeTransactionTokens.add(token);
						}
					}*/
					
					
					//Getting last three transaction token from Token List (1 to n)
					for(int i = 1; i<tokens.size() ;i++)
					{
						lastThreeTransactionTokens.add(tokens.get(i));
					}
					
					ArrayList<TransactionDetails> transactionDetailsList = new ArrayList<TransactionDetails>();
					TransactionDetails transactionDetails = null;
					
					logger.debug(uniqueId + "|" + "Total Transactions : " +lastThreeTransactionTokens.size());
					
					//Removing last transaction details , if there are more than 3
					if(lastThreeTransactionTokens.size()>3)
					{
						
						for(int i = lastThreeTransactionTokens.size(); i>=3; i--)
							lastThreeTransactionTokens.remove(i);
					}
					
					if(lastThreeTransactionTokens.size() != 0)
					{
						for(Token transactionToken : lastThreeTransactionTokens)
						{
							List<Param> params = transactionToken.getMsgParam().getParam();
							transactionDetails = new TransactionDetails();
							
							for(Param param : params)
							{
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_TXN_AMOUNT))
									transactionDetails.setAmount(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_TXN_PAYMENT_RCVD_DATE))
									transactionDetails.setPmtReceivedDate(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_TXN_PAYMENT_TYPE))
									transactionDetails.setPmtType(param.getValue());
								
									
							}
							transactionDetailsList.add(transactionDetails);
							
						}
					}
					
					resLastThreeTransactions.setTransactionDetailsList(transactionDetailsList);
					
					ArrayList<TransactionDetails> outputtxmDetList = resLastThreeTransactions.getTransactionDetailsList();
					
					for(TransactionDetails transactionDetails1 : outputtxmDetList)
					{
						logger.debug(uniqueId + "|" + "Transaction Details : " +transactionDetails1.toString());
					}
					
					
					
				}else{
					
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					logger.debug(uniqueId + "|" + "Host Response Error Message : " +errorMessage);
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
			
			resLastThreeTransactions.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resLastThreeTransactions.getTransactionDetailsList());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
