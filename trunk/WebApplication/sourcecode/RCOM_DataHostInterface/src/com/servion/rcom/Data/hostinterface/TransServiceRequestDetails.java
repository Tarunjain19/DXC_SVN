package com.servion.rcom.Data.hostinterface;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.Data.hostinterface.util.HostConstants;
import com.servion.rcom.Data.hostinterface.util.HostTransactionID;
import com.servion.rcom.Data.hostinterface.util.Utilities;
import com.servion.rcom.Data.hostinterface.view.ReqServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.ResServiceRequestDetails;
import com.servion.rcom.Data.hostinterface.view.SRDetails;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TransServiceRequestDetails implements ITransaction{

	
	ReqServiceRequestDetails reqServiceRequestDetails = null;
	ResServiceRequestDetails resServiceRequestDetails = new ResServiceRequestDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResServiceRequestDetails getHostInterface(IVRDataBean ivrDataBean, ReqServiceRequestDetails request) {

		try{
			
			uniqueId = ivrDataBean.getSessionID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_SERVICE_REQUEST_DETAILS);
			
			reqServiceRequestDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransServiceRequestDetails getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransServiceRequestDetails getHostInterface method end");
			return resServiceRequestDetails;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			//Utilities.printStackTrace(logger, uniqueId, e);
			return resServiceRequestDetails;
		}
	}
	
	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			//For Testing
			String serviceURL = null;
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_SR_DET);
			
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
			
			MDN = reqServiceRequestDetails.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_SR_DETAILS));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling service request Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_SR_DETAILS));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling service request Service");
			
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
					
					List<Token> openSRDetailsTokenList = new ArrayList<Token>() ; 
					
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_SR_ID))
								logger.debug(uniqueId + "|" + "SR ID : " +param.getValue());
							
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_STATUS))
							{
								logger.debug(uniqueId + "|" + "SR Status : " +param.getValue());
								
								openSRDetailsTokenList.add(token);
								/*if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_SR_STATUS_OPEN) || param.getValue().equalsIgnoreCase(HostConstants.PARAM_SR_STATUS_SOLVING))
								{
									openSRDetailsTokenList.add(token);
								}*/
							}
						}
					}
					
					
					
					boolean isSRAvailable = false;
					String serviceRequestID = null;
					String serviceRequestCreationDate = null;
					String serviceRequestType = null;
					String serviceRequestStatus = null;
					String serviceRequestSLADate = null;
					
					ArrayList<SRDetails> srDetailsList = new ArrayList<SRDetails>();
					SRDetails srDetails = null;
					
					logger.debug(uniqueId + "|" + "No of SR in open status : " +openSRDetailsTokenList.size());
					
					if(openSRDetailsTokenList.size() != 0)
					{
						isSRAvailable = true;
						
						for(Token openSRToken : openSRDetailsTokenList)
						{
							
								List<Param> listParam = openSRToken.getMsgParam().getParam();
								srDetails = new SRDetails();
								
								for(Param param : listParam)
								{
									if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_SR_ID))
									{
										srDetails.setServiceRequestID(param.getValue());
										logger.debug(uniqueId + "|" + "SR ID : " +srDetails.getServiceRequestID());
									}
									if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_SRCREATION_DATE))
									{
										srDetails.setServiceRequestCreationDate(param.getValue());
										logger.debug(uniqueId + "|" + "SR Creation Date : " +srDetails.getServiceRequestCreationDate());
									}
									if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_SR_TYPE))
									{
										srDetails.setServiceRequestType(param.getValue());
										logger.debug(uniqueId + "|" + "SR Type : " +param.getValue());
									}
									if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_STATUS))
									{
										srDetails.setServiceRequestStatus(param.getValue());
									}
									if(param.getId().equalsIgnoreCase(HostConstants.PARAM_SR_CRMSLA_DATE))
									{
										srDetails.setServiceRequestSLADate(param.getValue());
									}
								}
								
								srDetailsList.add(srDetails);
							
						}
						
						//Sorting list based on SR creation date, to get latest SR
						Collections.sort(srDetailsList, new Comparator<SRDetails>() {
							
							DateFormat f = new SimpleDateFormat("dd-MM-yyyy");
							
							@Override
							public int compare(SRDetails o1, SRDetails o2) {
								// TODO Auto-generated method stub
								
								try{
								Date date1 = null;
								Date date2 = null;
								
									date1 = f.parse(o1.getServiceRequestCreationDate());
									date2 = f.parse(o2.getServiceRequestCreationDate()); 
									return date1.compareTo(date2);
								} 
								
							catch (ParseException e) {
									logger.debug(uniqueId + "|" + "Parse Exception while parsing SR creation date for sorting." +e);
									throw new IllegalArgumentException(e);
								}
							}
							
							
						});
						Collections.reverse(srDetailsList);
						SRDetails latestSR = srDetailsList.get(0);
						
						serviceRequestID = latestSR.getServiceRequestID();
						serviceRequestCreationDate = latestSR.getServiceRequestCreationDate();
						serviceRequestType = latestSR.getServiceRequestType();
						serviceRequestStatus = latestSR.getServiceRequestStatus();
						serviceRequestSLADate = latestSR.getServiceRequestSLADate();
					}
					
					
					
					
					
					
					logBuilder.append("\n" + uniqueId + "|" + "Service Request Available : " +isSRAvailable);
					logBuilder.append("\n" + uniqueId + "|" + "Service Request ID : " +serviceRequestID);
					logBuilder.append("\n" + uniqueId + "|" + "Service Request Creation Date : " +serviceRequestCreationDate);
					logBuilder.append("\n" + uniqueId + "|" + "Service Request Type : " +serviceRequestType);
					logBuilder.append("\n" + uniqueId + "|" + "Service Request Status : " +serviceRequestStatus);
					logBuilder.append("\n" + uniqueId + "|" + "Service Request SLA Date : " +serviceRequestSLADate);
					logger.debug(logBuilder.toString());
					
					resServiceRequestDetails.setServiceRequestAvailable(isSRAvailable);
					resServiceRequestDetails.setServiceRequestID(serviceRequestID);
					resServiceRequestDetails.setServiceRequestCreationDate(serviceRequestCreationDate);
					resServiceRequestDetails.setServiceRequestType(serviceRequestType);
					resServiceRequestDetails.setServiceRequestStatus(serviceRequestStatus);
					resServiceRequestDetails.setServiceRequestSLADate(serviceRequestSLADate);
					
					msgTokens = null;
					tokens = null;
					
					
					
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
			//Utilities.printStackTrace(logger, uniqueId, e);
			
		} finally {
			
			resServiceRequestDetails.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resServiceRequestDetails.toString());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
			
			logBuilder = null;
		}
	}

}

