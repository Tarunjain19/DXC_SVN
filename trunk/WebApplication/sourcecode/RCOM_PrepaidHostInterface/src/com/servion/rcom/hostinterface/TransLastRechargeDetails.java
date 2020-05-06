package com.servion.rcom.hostinterface;

import java.net.URL;
import java.util.ArrayList;
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
import com.servion.rcom.hostinterface.view.RechargeDetails;
import com.servion.rcom.hostinterface.view.ReqLastRechargeDetails;
import com.servion.rcom.hostinterface.view.ResLastRechargeDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;



//TODO : Pending WSDL, service names, request and response parameters
public class TransLastRechargeDetails  implements ITransaction{

	ReqLastRechargeDetails reqLastRechargeDetails = null;
	ResLastRechargeDetails resLastRechargeDetails = new ResLastRechargeDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null,talktime = null,lrdamount =null;
	
	public ResLastRechargeDetails getHostInterface(IVRDataBean ivrDataBean, ReqLastRechargeDetails request) {

		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_LAST_RECHARGE_DETAILS);
			
			reqLastRechargeDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.info(uniqueId + "|" + "TransLastRechargeDetails getHostInterface method start");
			wsdlProcessor();
			logger.info(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.info(uniqueId + "|" + "TransLastRechargeDetails getHostInterface method end");
			return resLastRechargeDetails;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resLastRechargeDetails;
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_LRD);
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.info(uniqueId + "|" + "Service URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			csssoapReciever = new CSSSOAPReciever(url);
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			MDN = reqLastRechargeDetails.getMDN();
			
			logger.info(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.info(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_LAST_RECHARGE_DETAILS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.info(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.info(uniqueId + "|" + "Before calling lastRechargeDetails Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_LAST_RECHARGE_DETAILS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.info(uniqueId + "|" + "After calling lastRechargeDetails Service");
			
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
					
					List<Token> lastThreeRechargeTokens = new ArrayList<Token>();
					
					//Searching Last three recharge token using TRANS ID Parameter
					/*for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_LRD_TRANS_ID))
							{
								lastThreeRechargeTokens.add(token);
								
							}
						}
					}*/
					
					//Searching last three recharge token through Token ID
					/*for(Token token : tokens)
					{
						String tokenID = token.getTokenId();
						
						if(tokenID.equalsIgnoreCase(HostConstants.STR_1) || tokenID.equalsIgnoreCase(HostConstants.STR_2) || tokenID.equalsIgnoreCase(HostConstants.STR_3))
						{
							lastThreeRechargeTokens.add(token);
						}
					}*/
					
					//Getting last three recharge details token from Token List (1 to n)
					for(int i = 1; i<tokens.size() ;i++)
					{
						lastThreeRechargeTokens.add(tokens.get(i));
					}
					
					
					ArrayList<RechargeDetails> rechargeDetailsList = new ArrayList<RechargeDetails>();
					RechargeDetails rechargeDetails = null;
					
					logger.info(uniqueId + "|" + "Total Recharges : " +lastThreeRechargeTokens.size());
					
					//Removing last transaction details , if there are more than 3
					if(lastThreeRechargeTokens.size()>3)
					{
						
						for(int i = lastThreeRechargeTokens.size(); i>=3; i--)
							lastThreeRechargeTokens.remove(i);
					}
					
					
					if(lastThreeRechargeTokens.size() != 0)
					{
						for(Token rechargeToken : lastThreeRechargeTokens)
						{
							List<Param> params = rechargeToken.getMsgParam().getParam();
							rechargeDetails = new RechargeDetails();
							
							for(Param param : params)
							{
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_LRD_AMT))
								     { 
									lrdamount = param.getValue();
									lrdamount = Utilities.adjustDecimal(logger, lrdamount);
									rechargeDetails.setAmount(lrdamount);
										}
									
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_LRD_DATE))
									rechargeDetails.setDate(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_LRD_REC_TYPE))
									rechargeDetails.setType(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_LRD_TALK_TIME))
								{   talktime = param.getValue();
								    talktime = Utilities.adjustDecimal(logger, talktime);
									rechargeDetails.setTalktime(talktime);
								}
									
							}
							rechargeDetailsList.add(rechargeDetails);
							
						}
					}
					
					resLastRechargeDetails.setRechargeDetailsList(rechargeDetailsList);
					
					ArrayList<RechargeDetails> outputRecDetList = resLastRechargeDetails.getRechargeDetailsList();
					
					for(RechargeDetails rechrgeDetails1 : outputRecDetList)
					{
						logger.info(uniqueId + "|" + "Recharge Details : " +rechrgeDetails1.toString());
					}
					
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
			
			resLastRechargeDetails.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resLastRechargeDetails.getResponseCode());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}
	
	
}

