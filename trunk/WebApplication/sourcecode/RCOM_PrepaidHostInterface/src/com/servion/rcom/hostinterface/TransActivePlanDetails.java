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
import com.servion.rcom.hostinterface.view.PlanDetails;
import com.servion.rcom.hostinterface.view.ReqActivePlanDetails;
import com.servion.rcom.hostinterface.view.ResActivePlanDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TransActivePlanDetails implements ITransaction{

	ReqActivePlanDetails reqActivePlanDetails = null;
	ResActivePlanDetails resActivePlanDetails = new ResActivePlanDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResActivePlanDetails getHostInterface(IVRDataBean ivrDataBean , ReqActivePlanDetails request) {
		
		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_ACTIVE_PLAN_DETAILS);
			
			reqActivePlanDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.info(uniqueId + "|" + "TransActivePlanDetails getHostInterface method start");
			wsdlProcessor();
			logger.info(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.info(uniqueId + "|" + "TransActivePlanDetails getHostInterface method end");
			return resActivePlanDetails;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resActivePlanDetails;
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_ACTIVE_PLAN);
			
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
			
			MDN = reqActivePlanDetails.getMDN();
			
			logger.info(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.info(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_ACTIVE_PLAN_DETAILS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.info(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.info(uniqueId + "|" + "Before calling Active Pack Details Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_ACTIVE_PLAN_DETAILS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.info(uniqueId + "|" + "After calling Active Pack Details Service");
			
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
					
					String messageText = response.getMsgText();
					logger.info(uniqueId + "|" + "Active Pack Message Text : " +messageText);
					
					MsgTokens msgTokens = response.getMsgTokens();
					List<Token> tokens = msgTokens.getToken();
					
					
					//Searching plan token through rate plan parameter
					List<Token> planTokens = new ArrayList<Token>();
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PLN_RATE_PLAN))
							{
								planTokens.add(token);
								
							}
						}
					}
					
					//Getting plan token from Token List (1 to n)
					/*for(int i = 1; i<tokens.size() ;i++)
					{
						planTokens.add(tokens.get(i));
					}*/
					
					ArrayList<PlanDetails> planDetailsList = new ArrayList<PlanDetails>();
					PlanDetails planDetails = null;
					
					logger.info(uniqueId + "|" + "Total Plans : " +planTokens.size());
					
					if(planTokens.size() != 0)
					{
						for(Token planToken : planTokens)
						{
							List<Param> params = planToken.getMsgParam().getParam();
							planDetails = new PlanDetails();
							
							for(Param param : params)
							{
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PLN_RATE_PLAN))
									planDetails.setRatePlan(param.getValue());
								if(param.getId().equalsIgnoreCase(HostConstants.PARAM_PLN_MONTHLY_RENTAL_CHARGE))
									planDetails.setMontlyRentalCharge(param.getValue());
								
								
									
							}
							planDetailsList.add(planDetails);
							
						}
					}
					
					resActivePlanDetails.setPlanDetailsList(planDetailsList);
					
					ArrayList<PlanDetails> outputplnDetList = resActivePlanDetails.getPlanDetailsList();
					
					for(PlanDetails plnDetails1 : outputplnDetList)
					{
						logger.info(uniqueId + "|" + "Plan Details : " +plnDetails1.toString());
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
			
			resActivePlanDetails.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resActivePlanDetails.getPlanDetailsList());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
