package com.servion.rcom.hostinterface;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqTeleVerify;
import com.servion.rcom.hostinterface.view.ResTeleVerify;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class TeleVerifyRequest implements ITransaction{

	ReqTeleVerify reqTeleVerify = null;
	ResTeleVerify resTeleVerify = new ResTeleVerify();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResTeleVerify getHostInterface(IVRDataBean ivrDataBean , ReqTeleVerify request) {
		
		try{
		logger = ivrDataBean.getLogger();
		
		
			
			/*Logger logger = Logger.getLogger(this.getClass());
		
		Properties log4jProps = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/config/hostconfig/log4j.properties");
		
		log4jProps.load(in);
		
	    PropertyConfigurator.configure(log4jProps);*/
		
		//Logger logger = Logger.getLogger(TeleVerifyRequest.class);
		
		
		
		uniqueId = Utilities.generateUniqueID();
		
		System.out.println("Hello Startrepositry: "+logger.getLoggerRepository());
		System.out.println("Hello Start get name: "+logger.getName());
		System.out.println("Hello Start Resource: "+logger.getResourceBundle());
		System.out.println("Hello Start new: "+logger.getRootLogger());
		
		
		reportObject = ivrDataBean.getGetReportObject();
		
		System.out.println("Hello Start new1");
		host = reportObject.createReportHostObject();
		System.out.println("Hello Start new2");
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		
		System.out.println("Hello Start new3");
		host.setHOSTID(HostTransactionID.TRANS_TVP_STATUS_REQUEST);
		System.out.println("Hello Start new4");
		
		reqTeleVerify = request;
		System.out.println("Hello Start new5");
		uniqueId = ivrDataBean.getSessionID();
		System.out.println("Hello Start new6: "+uniqueId);
		logger.debug(uniqueId + "|" + "TeleVerifyRequest getHostInterface method start");
		System.out.println("Before wsdlprocess");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TeleVerifyRequest getHostInterface method end");
		return resTeleVerify;
		}catch(Exception e)
		{
			System.out.println("In catchxxx : "+e);
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resTeleVerify;
		}
	}

	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		
		try {
			System.out.println("IN wsdlProcessor is 27");
			logger.debug(uniqueId + "|" + " Before Service URL is ok : ");
			
			Properties appProperties = new Properties();
			//FileInputStream in = new FileInputStream("C:\\RCOM\\OtherFlows\\RCOM_CF_Televerification_IVR\\Config\\webservice.properties");
			  FileInputStream in = new FileInputStream("C:\\RCOM\\OtherFlows\\RCOM_CF_TVP\\Config\\webservice.properties");
			
	        try {
	        	appProperties.load(in);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

			
			/*AppProperties.setInstance("webservice", "C:\\RCOM\\OtherFlows\\RCOM_CF_Televerification_IVR\\Config\\");
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			*/
			
			
			
			
		
		
			
			//For Testing
			String serviceURL = null;
			
			serviceURL=appProperties.getProperty(HostConstants.CSS_ENDPOINT_TELEVERIFY_REQUEST);
			
			
			//serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_TELEVERIFY_REQUEST);
			
			System.out.println("serviceURL is: "+serviceURL);
			
			
			
			
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getProperty(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			
			
			csssoapReciever = new CSSSOAPReciever(url);
			
			
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = appProperties.getProperty(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getProperty(HostConstants.HOST_REQUEST_TIMEOUT);
			
			System.out.println("connectionTimeout is: "+connectionTimeout);
			
			logger.debug(uniqueId + "|" + "connectionTimeout : " +connectionTimeout);
			logger.debug(uniqueId + "|" + "requestTimeout : " +requestTimeout);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			
			
			MDN = reqTeleVerify.getMDN();
			
			
			System.out.println("MDN is yes: "+MDN);
			
			String requestid=reqTeleVerify.getRequestId();
			
			System.out.println("requestid is: "+requestid);
			String langid=reqTeleVerify.getLangId();
			
			langid="0";
			
			System.out.println("langid is: "+langid);
			
			String reqsource=reqTeleVerify.getSOURCE();
			
			System.out.println("langid is: "+langid);
			
			String reqtype=reqTeleVerify.getREQUESTTYPE();
			
			System.out.println("reqtype is: "+reqtype);
			
			String ivr_time=reqTeleVerify.getREQUESTDATE();
			
			System.out.println("ivr_time is: "+ivr_time);
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			logger.debug(uniqueId + "|" + "requestid : " +requestid);
			logger.debug(uniqueId + "|" + "langid Value : " +langid);
			logger.debug(uniqueId + "|" + "reqsource Value : " +reqsource);
			logger.debug(uniqueId + "|" + "reqtype Value : " +reqtype);
			logger.debug(uniqueId + "|" + "ivr_time Value : " +ivr_time);
			
			
			
			Request request = new Request();
			request.setRequestId(requestid);
			request.setLangID(langid);
			request.setRequestSource(reqsource);
			request.setRequestType(reqtype);
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getProperty(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			
			logger.debug(uniqueId + "|" + "Before calling TeleVerify request Service");
			
			
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + reqtype);
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			System.out.println("request is: "+request);
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			
			System.out.println("response.toString() is: "+response);
			
			logger.debug(uniqueId + "|" + "After calling request Service response "+response);
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.debug(uniqueId + "|" + "Host Response Error Code : " +errorCode);
				System.out.println("errorCode is: "+errorCode);

				if((errorCode != null) && (!HostConstants.EMPTY.equalsIgnoreCase(errorCode)) && 
						(appProperties.getProperty(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(errorCode)){
					
					String messageText = response.getMsgText();
					String Error_code = response.getErrorCode();
					
					resTeleVerify.setERROR_CODE(Error_code);
					resTeleVerify.setERROR_MSG(errorMessage);
					
					
					
					
					logger.debug(uniqueId + "|" + "messageText: "+messageText);
					
					
					
					List<Token> tokens = response.getMsgTokens().getToken();
					String CUSTOMER_TYPE = "";
					String CUSTOMER_CATEGORY="";
					String SERVICE_TYPE="";
					String TECHNOLOGY_TYPE="";
					String PRODUCT_TYPE="";
					String POA_TYPE="";
					String POA_ID_DETAILS="";
					String POA_ISSUE_DATE="";
					String TVP_STATUS="";
					String DOB="";
					String DATA_CONSENT="";
					String UPDATE_DATE="";
					String OUT_STATUS="";
					String OUT_STATUS_CODE="";
					String OUT_MSG="";
					String E_KYC="";
					
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							
							
							
							String temp_getid=param.getId();
							
							logger.debug(uniqueId + "|" +" temp is:"+temp_getid);
							
							temp_getid=temp_getid.trim();
							
							if(param.getId().equalsIgnoreCase(HostConstants.CUSTOMER_TYPE))
							{
								CUSTOMER_TYPE = param.getValue();
								logger.debug(uniqueId + "|" + "CUSTOMER_TYPE : " +CUSTOMER_TYPE);
								resTeleVerify.setCUSTOMER_TYPE(CUSTOMER_TYPE);
								System.out.println("CUSTOMER_TYPE is: "+CUSTOMER_TYPE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.CUSTOMER_CATEGORY))
							{
								CUSTOMER_CATEGORY = param.getValue();
								logger.debug(uniqueId + "|" + "CUSTOMER_CATEGORY : " +CUSTOMER_CATEGORY);
								resTeleVerify.setCUSTOMER_CATEGORY(CUSTOMER_CATEGORY);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.SERVICE_TYPE))
							{
								SERVICE_TYPE = param.getValue();
								logger.debug(uniqueId + "|" + "SERVICE_TYPE : " +SERVICE_TYPE);
								resTeleVerify.setSERVICE_TYPE(SERVICE_TYPE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.TECHNOLOGY_TYPE))
							{
								TECHNOLOGY_TYPE = param.getValue();
								logger.debug(uniqueId + "|" + "TECHNOLOGY_TYPE : " +TECHNOLOGY_TYPE);
								resTeleVerify.setTECHNOLOGY_TYPE(TECHNOLOGY_TYPE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.PRODUCT_TYPE))
							{
								PRODUCT_TYPE = param.getValue();
								logger.debug(uniqueId + "|" + "PRODUCT_TYPE : " +PRODUCT_TYPE);
								resTeleVerify.setPRODUCT_TYPE(PRODUCT_TYPE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.POA_TYPE))
							{
								POA_TYPE = param.getValue();
								logger.debug(uniqueId + "|" + "POA_TYPE : " +POA_TYPE);
								resTeleVerify.setPOA_TYPE(POA_TYPE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.POA_ID_DETAILS))
							{
								POA_ID_DETAILS = param.getValue();
								logger.debug(uniqueId + "|" + "POA_ID_DETAILS is : " +POA_ID_DETAILS);
								resTeleVerify.setPOA_ID_DETAILS(POA_ID_DETAILS);
							}
							else if(temp_getid.equalsIgnoreCase(HostConstants.POA_ISSUE_DATE))
							{
								logger.debug(uniqueId + "|" + " In POA_ISSUE_DATE is: " );
								POA_ISSUE_DATE = param.getValue();
								
								logger.debug(uniqueId + "|" + "POA_ISSUE_DATE : " +POA_ISSUE_DATE);
								resTeleVerify.setPOA_ISSUE_DATE(POA_ISSUE_DATE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.TVP_STATUS))
							{
								TVP_STATUS = param.getValue();
								logger.debug(uniqueId + "|" + "TVP_STATUS : " +TVP_STATUS);
								resTeleVerify.setTVP_STATUS(TVP_STATUS);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.DOB))
							{
								DOB = param.getValue();
								logger.debug(uniqueId + "|" + "DOB : " +DOB);
								resTeleVerify.setDOB(DOB);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.DATA_CONSENT))
							{
								DATA_CONSENT = param.getValue();
								logger.debug(uniqueId + "|" + "DATA_CONSENT : " +DATA_CONSENT);
								resTeleVerify.setDATA_CONSENT(DATA_CONSENT);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.UPDATE_DATE))
							{
								UPDATE_DATE = param.getValue();
								logger.debug(uniqueId + "|" + "UPDATE_DATE : " +UPDATE_DATE);
								resTeleVerify.setUPDATE_DATE(UPDATE_DATE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.OUT_STATUS))
							{
								OUT_STATUS = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_STATUS : " +OUT_STATUS);
								resTeleVerify.setOUT_STATUS(OUT_STATUS);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.OUT_STATUS_CODE))
							{
								OUT_STATUS_CODE = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_STATUS_CODE Id : " +OUT_STATUS_CODE);
								resTeleVerify.setOUT_STATUS_CODE(OUT_STATUS_CODE);
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.OUT_MSG))
							{
								OUT_MSG = param.getValue();
								logger.debug(uniqueId + "|" + "OUT_MSG Id : " +OUT_MSG);
								resTeleVerify.setOUT_MSG(OUT_MSG);
								
							}
							else if(param.getId().equalsIgnoreCase(HostConstants.E_KYC))
							{
								E_KYC = param.getValue();
								logger.debug(uniqueId + "|" + "E_KYC: " +E_KYC);
								System.out.println("E_KYC: " +E_KYC);
								resTeleVerify.setE_KYC(E_KYC);
							}
							
						}
					}
					
					
					
					
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					resTeleVerify.setResponseCode(responseCode);
					logger.debug(uniqueId + "|" + "responseCode : " +responseCode);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					
				}else{
					
					
					resTeleVerify.setERROR_MSG(errorMessage);
					resTeleVerify.setERROR_CODE(errorCode);
					logger.debug(uniqueId + "|" + "responseCode : " +responseCode);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					logger.debug(uniqueId + "|" + "Host Response Error Message : " +errorMessage);
				}
						
			}
			else
			{
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				resTeleVerify.setERROR_MSG("ERROR");
				resTeleVerify.setERROR_CODE("ERROR");
				
			}
			
		} catch (MalformedURLException e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			resTeleVerify.setERROR_MSG("ERROR");
			resTeleVerify.setERROR_CODE("ERROR");
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			
			logger.error(uniqueId + "|" + "MalformedURLException : " +e);
			logger.error(uniqueId + "|" + "MalformedURLException Message: " +e.getMessage());
			
		} catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			resTeleVerify.setERROR_MSG("ERROR");
			resTeleVerify.setERROR_CODE("ERROR");
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			
			logger.error(uniqueId + "|" + "Exception Occured : " +e);
			logger.error(uniqueId + "|" + "Exception Error Message : " +e.getMessage());
			
		} finally {
			
			resTeleVerify.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
