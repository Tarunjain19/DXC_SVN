package com.servion.rcom.hostinterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;

import com.servion.rcom.hostinterface.view.ReqTvpUpdate;
import com.servion.rcom.hostinterface.view.ResTvpUpdate;

import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TeleStatusUpdate implements ITransaction{

	ReqTvpUpdate reqTvpUpdate = null;
	ResTvpUpdate resTvpUpdate = new ResTvpUpdate();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResTvpUpdate getHostInterface(IVRDataBean ivrDataBean , ReqTvpUpdate request) {
		
		
		System.out.println("Test update 27");
		
		logger = ivrDataBean.getLogger();
		
		System.out.println("Test update1");
		
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_TVP_UPDATE_STATUS_REQUEST);
		
		
		System.out.println("Test update3");
		
		reqTvpUpdate = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TeleVerifyRequest getHostInterface method start");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TeleVerifyRequest getHostInterface method end");
		return resTvpUpdate;
	}

	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		try {
			
			
			System.out.println("in wsdlProcessor");
			
			Properties appProperties = new Properties();
			  FileInputStream in = new FileInputStream("C:\\RCOM\\OtherFlows\\RCOM_CF_TVP\\Config\\webservice.properties");
			
	        try {
	        	appProperties.load(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

			
			
			
		
			
			//For Testing
			//String serviceURL = "http://97.253.38.18:8989/BusinessUseCases/StarterServices/TVP_IVR_Receiver";
	        
			String serviceURL = appProperties.getProperty(HostConstants.CSS_ENDPOINT_TELEVERIFY_REQUEST);
			
			System.out.println("in serviceURL"+serviceURL);
			
			
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getProperty(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			
			System.out.println("in serviceURL url"+serviceURL);
			URL url = new URL(serviceURL);
			
			
			
			csssoapReciever = new CSSSOAPReciever(url);
			
			
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			
			System.out.println("after cssInfoPort url");
			
			
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = appProperties.getProperty(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getProperty(HostConstants.HOST_REQUEST_TIMEOUT);
			
			logger.debug(uniqueId + "|" + "connectionTimeout : " +connectionTimeout);
			logger.debug(uniqueId + "|" + "requestTimeout : " +requestTimeout);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			String requestid=reqTvpUpdate.getRequestId();
			String langid=reqTvpUpdate.getLangId();
			String reqsource=reqTvpUpdate.getSOURCE();
			String reqtype=reqTvpUpdate.getREQUESTTYPE();
			String ivr_time=reqTvpUpdate.getREQUESTDATE();
			MDN = reqTvpUpdate.getMDN();
			String Data_consent=reqTvpUpdate.getDATACONSENT();
			String TVPSTATUSVALUE=reqTvpUpdate.getTVPSTATUSFLAG_VALUE();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "requestid : " +requestid);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			logger.debug(uniqueId + "|" + "langid Value : " +langid);
			logger.debug(uniqueId + "|" + "reqsource Value : " +reqsource);
			logger.debug(uniqueId + "|" + "reqtype Value : " +reqtype);
			logger.debug(uniqueId + "|" + "ivr_time Value : " +ivr_time);
			logger.debug(uniqueId + "|" + "Data_consent Value : " +Data_consent);
			logger.debug(uniqueId + "|" + "TVPSTATUSVALUE Value : " +TVPSTATUSVALUE);
			
			
			Request request = new Request();
			request.setRequestId(requestid);
			request.setLangID(langid);
			request.setRequestSource(reqsource);
			request.setRequestType(reqtype);
			request.setServiceID(MDN);
			request.setTimeStamp(ivr_time);
			
			Param tvpstatusupdate = new Param();
			tvpstatusupdate.setId(HostConstants.TVP_STATUS_FLAG);
			tvpstatusupdate.setValue(TVPSTATUSVALUE);
			tvpstatusupdate.setType(HostConstants.PARAM_TYPE_STRING);
			
			tvpstatusupdate.setId(HostConstants.DATA_CONSENT);
			tvpstatusupdate.setValue(Data_consent);
			tvpstatusupdate.setType(HostConstants.PARAM_TYPE_STRING);
			
			request.getParam().add(tvpstatusupdate);
			
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling TeleVerify request Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE +reqtype);
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling CSS_REQUEST_TYPE_TVP_STATUS_UPDATE");
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.debug(uniqueId + "|" + "Host Response Error Code : " +errorCode);

				if((errorCode != null) && (!HostConstants.EMPTY.equalsIgnoreCase(errorCode)) && 
						(appProperties.getProperty(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(errorCode)){
					
					
				 
					List<Token> tokens = response.getMsgTokens().getToken();
					
					String OUT_STATUS=null;
					String OUT_STATUS_CODE=null;
					String OUT_MSG=null;
					
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							
							if(param.getId().equalsIgnoreCase(HostConstants.OUT_STATUS))
							{
								OUT_STATUS = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_STATUS : " +OUT_STATUS);
								resTvpUpdate.setOUT_STATUS(OUT_STATUS);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.OUT_STATUS_CODE))
							{
								OUT_STATUS_CODE = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_STATUS_CODE Id : " +OUT_STATUS_CODE);
								resTvpUpdate.setOUT_STATUS_CODE(OUT_STATUS_CODE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.OUT_MSG))
							{
								OUT_MSG = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_MSG Id : " +OUT_MSG);
								resTvpUpdate.setOUT_MSG(OUT_MSG);
								
							}
							
						}
					}
					
					
					
					
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					resTvpUpdate.setResponseCode(responseCode);
					logger.debug(uniqueId + "|" + "responseCode : " +responseCode);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					
				}else{
					
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					resTvpUpdate.setResponseCode(responseCode);
					logger.debug(uniqueId + "|" + "responseCode : " +responseCode);
					
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
			
			resTvpUpdate.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
