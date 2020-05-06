package com.servion.rcom.hostinterface;

import java.net.URL;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.dnd.util.HostConstants;
import com.dnd.util.HostTransactionID;
import com.dnd.util.LoadProperty;
import com.dnd.util.StackTrace;
import com.dnd.util.Utilities;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.view.ReqDNCderegistration;
import com.servion.rcom.hostinterface.view.ResDNCderegistration;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;

public class TransDNCderegistration implements ITransaction{

	ReqDNCderegistration reqDNCderegistration = null;
	ResDNCderegistration resDNCderegistration = new ResDNCderegistration();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResDNCderegistration getHostInterface(IVRDataBean ivrDataBean , ReqDNCderegistration request) {

		try{
			uniqueId = Utilities.generateUniqueID();	
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_DNC_DE_REGISTRATION);
			
			reqDNCderegistration = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransDNCderegistration getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransDNCderegistration getHostInterface method end");
			return resDNCderegistration;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			StackTrace.PrintException(e);
			return resDNCderegistration;
		}
	}
	
	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		CSSSOAPReciever csssoapReciever = null;
		CssInfoPort cssInfoPort = null;
		Response response = null;
		
		try {
			
			//For Testing
			String serviceURL = null;
			serviceURL = LoadProperty.getivrconfigProp(HostConstants.CSS_ENDPOINT_URL_DNC_DACT);
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = LoadProperty.getivrconfigProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			URL url = new URL(serviceURL);
			
			csssoapReciever = new CSSSOAPReciever(url);
			cssInfoPort = csssoapReciever.getCSSSoapReciever();
			
			//TODO : Pending Timeout Settings
			
			String connectionTimeout = LoadProperty.getivrconfigProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = LoadProperty.getivrconfigProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)cssInfoPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			MDN = reqDNCderegistration.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(LoadProperty.getivrconfigProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(LoadProperty.getivrconfigProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(LoadProperty.getivrconfigProp(HostConstants.CSS_REQUEST_TYPE_DNC_DEACTIVATION));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, LoadProperty.getivrconfigProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			Param DNDInfo = new Param();
			DNDInfo.setId(HostConstants.PARAM_DND_ACTION_TYPE);
			DNDInfo.setValue(HostConstants.PARAM_DND_ACTION_TYPE_DEACTIVATION);
			DNDInfo.setType(HostConstants.PARAM_TYPE_STRING);
			
			request.getParam().add(DNDInfo);
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling DND De Activation Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + LoadProperty.getivrconfigProp(HostConstants.CSS_REQUEST_TYPE_DNC_DEACTIVATION));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling DND De Activation Service");
			
			if(response != null)
			{
				errorCode = response.getErrorCode();
				String errorMessage = response.getErrorMsg();
				
				logger.debug(uniqueId + "|" + "Host Response Error Code : " +errorCode);

				if((errorCode != null) && (!HostConstants.EMPTY.equalsIgnoreCase(errorCode)) && 
						(LoadProperty.getivrconfigProp(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(errorCode)){
					
					
					String messageText = response.getMsgText();
					logger.debug(uniqueId + "|" + "DND DeActivation Message Text : " +messageText);
					
					resDNCderegistration.setMessageText(messageText);
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					
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
			

			StackTrace.PrintException(e);
			
		} finally {
			
			resDNCderegistration.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resDNCderegistration.getMessageText());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
		}
	}

}
