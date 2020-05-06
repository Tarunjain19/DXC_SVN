package com.servion.rcom.Data.hostinterface;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.Data.hostinterface.util.HostConstants;
import com.servion.rcom.Data.hostinterface.util.HostTransactionID;
import com.servion.rcom.Data.hostinterface.util.Utilities;
import com.servion.rcom.Data.hostinterface.view.ReqDataActDeact;
import com.servion.rcom.Data.hostinterface.view.ResDataActDeact;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

public class DataRequest implements ITransaction{

	ReqDataActDeact reqActDeact = null;
	ResDataActDeact resActDeact = new ResDataActDeact();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResDataActDeact getHostInterface(IVRDataBean ivrDataBean , ReqDataActDeact request) {
		
		try{
		logger = ivrDataBean.getLogger();
		
		
		
		
		uniqueId = Utilities.generateUniqueID();
		
	
		
		reportObject = ivrDataBean.getGetReportObject();
		
		System.out.println("Hello  In Data Start 1");
		host = reportObject.createReportHostObject();
		System.out.println("Hello Start new2");
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		
		
		host.setHOSTID(HostTransactionID.TRANS_TVP_STATUS_REQUEST);
		
		
		reqActDeact = request;
		System.out.println("Hello before session data");
		uniqueId = ivrDataBean.getSessionID();
		System.out.println("Hello Start new6: "+uniqueId);
		logger.debug(uniqueId + "|" + "Data getHostInterface method start");
		System.out.println("Before wsdlprocess");
		wsdlProcessor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TeleVerifyRequest getHostInterface method end");
		return resActDeact;
		}catch(Exception e)
		{
			System.out.println("In catchxxx : "+e);
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resActDeact;
		}
	}

	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
	try {
			System.out.println("IN Data wsdlProcessor");
			logger.debug(uniqueId + "|" + " Before Service URL is : ");
			
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			
		
		
			
			//For Testing
			String serviceURL = null;
			
			serviceURL=appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_DATA_REQUEST);
			
			
			//serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_TELEVERIFY_REQUEST);
			
			System.out.println("Data URL from config: "+serviceURL);
			
			
			
			
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Data URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			System.out.println(" URL is: "+url.toString());
			logger.debug(uniqueId + "|" + " URL is : " +url.toString());
			
			
			
			csssoapReciever = new CSSSOAPReciever(url);
			
			
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			
			
			MDN = reqActDeact.getMDN();
			
			
			
			
			
			String langid=reqActDeact.getLangId();
			
			langid="0";
			
			System.out.println("langid is: "+langid);
			
			String reqsource=reqActDeact.getSOURCE();
			
			System.out.println("langid is: "+langid);
			
			String reqtype=reqActDeact.getREQUESTTYPE();
			
			System.out.println("reqtype is: "+reqtype);
			
			
			
			String reqoptype=reqActDeact.getREQopType();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			logger.debug(uniqueId + "|" + "langid Value : " +langid);
			logger.debug(uniqueId + "|" + "reqsource Value : " +reqsource);
			logger.debug(uniqueId + "|" + "reqtype Value : " +reqtype);
			logger.debug(uniqueId + "|" + "reqoptype Value : " +reqoptype);
			
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(langid);
			request.setRequestSource(reqsource);
			request.setRequestType(reqtype);
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			Param DataInfo = new Param();
			DataInfo.setId(HostConstants.OPTYPE);
			DataInfo.setValue(reqoptype);
			DataInfo.setType(HostConstants.PARAM_TYPE_STRING);
			
			request.getParam().add(DataInfo);
			
			
			
			
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
			
			System.out.println("response.toString() is: "+response.toString());
			
			logger.debug(uniqueId + "|" + "After calling request Service response "+response.toString());
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.debug(uniqueId + "|" + "Host Response Error Code : " +errorCode);
				System.out.println("errorCode is: "+errorCode);
				responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
				resActDeact.setResponseCode(responseCode);
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);

				if(errorCode.equalsIgnoreCase("1")){
					
					
					resActDeact.setERROR_CODE(errorCode);
					
					logger.debug(uniqueId + "|" + "errorCode : " +errorCode);
					
					//For Reporting
					
					
					
				}else{
					
					resActDeact.setERROR_CODE(errorCode);
					logger.debug(uniqueId + "|" + "errorCode : " +errorCode);
					
					
					
					logger.debug(uniqueId + "|" + "Host Response Error Message : " +errorMessage);
				}
						
			}
			else
			{
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				resActDeact.setResponseCode(responseCode);
				
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
			
			resActDeact.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
