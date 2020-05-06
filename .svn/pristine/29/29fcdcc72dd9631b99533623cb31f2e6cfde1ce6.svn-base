package com.servion.rcom.hostinterface;

import java.net.MalformedURLException;
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
import com.servion.rcom.hostinterface.view.PackDetails;
import com.servion.rcom.hostinterface.view.ReqNonActivePackDetails;
import com.servion.rcom.hostinterface.view.ResNonActivePackDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TransNonActivePackDetails implements ITransaction{

	ReqNonActivePackDetails reqNonActivePackDetails = null;
	ResNonActivePackDetails resNonActivePackDetails = new ResNonActivePackDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResNonActivePackDetails getHostInterface(IVRDataBean ivrDataBean, ReqNonActivePackDetails request) {
		
		logger = ivrDataBean.getLogger();
		
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_APPLICABLE_VAS_LIST);
		
		reqNonActivePackDetails = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransNonActivePackDetails getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransNonActivePackDetails getHostInterface method end");
		return resNonActivePackDetails;
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_NON_ACT_PACK);
			
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
			
			MDN = reqNonActivePackDetails.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_NON_ACTIVE_PACKS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling non active packs Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_NON_ACTIVE_PACKS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling non active packs Service");
			
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
					
					
					//Searching Balance token through Parameter names
					List<Token> nonActivePacksTokens = new ArrayList<Token>();
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PACK_NAME))
							{
								nonActivePacksTokens.add(token);
								
							}
						}
					}
					
					
					//Searching Balance token through Token ID
					/*for(Token token : tokens)
					{
						String tokenID = token.getTokenId();
						
						if(tokenID.equalsIgnoreCase(HostConstants.STR_1) || tokenID.equalsIgnoreCase(HostConstants.STR_2) || tokenID.equalsIgnoreCase(HostConstants.STR_3)
								 || tokenID.equalsIgnoreCase(HostConstants.STR_4) || tokenID.equalsIgnoreCase(HostConstants.STR_5))
						{
							nonActivePacksTokens.add(token);
						}
					}*/
					
					
					//Getting Balance token from Token List (1 to n)
					/*for(int i = 1; i<tokens.size() ;i++)
					{
						nonActivePacksTokens.add(tokens.get(i));
					}*/
					
					ArrayList<PackDetails> packDetailsList = new ArrayList<PackDetails>();
					PackDetails packDetails = null;
					
					logger.debug(uniqueId + "|" + "Total Packs : " +nonActivePacksTokens.size());
					
					//Removing tail unwanted packs, if there are more than 5
					if(nonActivePacksTokens.size()>5)
					{
						
						for(int i = nonActivePacksTokens.size(); i>=5; i--)
							nonActivePacksTokens.remove(i);
					}
					
					if(nonActivePacksTokens.size() != 0)
					{
						for(Token nonActivePackToken : nonActivePacksTokens)
						{
							List<Param> params = nonActivePackToken.getMsgParam().getParam();
							packDetails = new PackDetails();
							
							for(Param param : params)
							{
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PACK_NAME))
									packDetails.setName(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PACK_CODE))
									packDetails.setCode(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PACK_VALIDITY))
									packDetails.setValidity(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PACK_AMOUNT))
									packDetails.setAmount(param.getValue());
									
							}
							packDetailsList.add(packDetails);
							
						}
					}
					
					resNonActivePackDetails.setPackDetailsList(packDetailsList);
					
					ArrayList<PackDetails> outputPackDetList = resNonActivePackDetails.getPackDetailsList();
					
					for(PackDetails packDetails1 : outputPackDetList)
					{
						logger.debug(uniqueId + "|" + "Pack Details : " +packDetails1.toString());
					}
					
					
					
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
			
			resNonActivePackDetails.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resNonActivePackDetails.getPackDetailsList());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

	
	
}
