package com.servion.rcom.ppp.hostinterface;

import java.net.URL;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CSSSOAPReciever;
import com.example.xmlns._1272370141776.cssinfoimpl.businessusecases.starterservices.CssInfoPort;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.ppp.hostinterface.util.HostConstants;
import com.servion.rcom.ppp.hostinterface.util.HostTransactionID;
import com.servion.rcom.ppp.hostinterface.util.Utilities;
import com.servion.rcom.ppp.hostinterface.view.ReqDataBalance;
import com.servion.rcom.ppp.hostinterface.view.ResDataBalance;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.MsgTokens;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Param;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Request;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Response;
import com.tibco.schemas.css_gw.sharedresources.schema._private.css_schema.Token;

//TODO : Pending WSDL, service names, request and response parameters
public class TransDataBalance implements ITransaction{

	ReqDataBalance reqDataBalance = null;
	ResDataBalance resDataBalance = new ResDataBalance();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String errorCode = null;
	
	public ResDataBalance getHostInterface(IVRDataBean ivrDataBean, ReqDataBalance request) {
		
		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_DATA_BALANCE);
			
			reqDataBalance = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransDataBalance getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransDataBalance getHostInterface method end");
			return resDataBalance;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resDataBalance;
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
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_DATA_BAL);
			
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
			
			MDN = reqDataBalance.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			
			Request request = new Request();
			request.setRequestId(uniqueId);
			request.setLangID(appProperties.getIVRProp(HostConstants.CSS_LANG_ID));
			request.setRequestSource(appProperties.getIVRProp(HostConstants.CSS_REQUEST_SOURCE));
			request.setRequestType(appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_DATA_BALANCE));
			request.setServiceID(MDN);
			request.setTimeStamp(Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			
			logger.debug(uniqueId + "|" + "Timestamp : " +request.getTimeStamp());
			logger.debug(uniqueId + "|" + "Before calling dataBalance Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_DATA_BALANCE));
			host.setHOSTINPARAMS(request.getRequestId() + HostConstants.PIPE + request.getLangID() + HostConstants.PIPE + request.getRequestSource()+HostConstants.PIPE + request.getRequestType() + HostConstants.PIPE + request.getServiceID()+HostConstants.PIPE+request.getTimeStamp());
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			response = cssInfoPort.cssInfo(request);
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling dataBalance Service");
			
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
					
					Token twoGDataBalToken = null;
					Token threeGDataBalToken = null;
					Token threeGFUDataBalToken = null;
					Token cdmaDataBalToken = null;
					for(Token token : tokens)
					{
						List<Param> params = token.getMsgParam().getParam();
						
						for(Param param : params)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_BALANCE_NAME))
							{
								if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_DAT_BAL_NAME_GPRS))
								{
									twoGDataBalToken = token;
								}
								if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_DAT_BAL_NAME_3G_GPRS))
								{
									threeGDataBalToken = token;
								}
								if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_DAT_BAL_NAME_3G_GPRS_FU))
								{
									threeGFUDataBalToken = token;
								}
								if(param.getValue().equalsIgnoreCase(HostConstants.PARAM_DAT_BAL_NAME_CDMA))
								{
									cdmaDataBalToken = token;
								}
							}
						}
						
					}
					
					
					String twoGNetBal = null;
					String twoGNetBalExpDate = null;
					
					if(twoGDataBalToken != null)
					{
						List<Param> listParam = twoGDataBalToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALUE))
							{
								twoGNetBal = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALIDITY))
							{
								twoGNetBalExpDate = param.getValue();
							}
						}
					}
					
					
					String threeGNetBal = null;
					String threeGNetBalExpDate = null;
					if(threeGDataBalToken != null)
					{
						List<Param> listParam = threeGDataBalToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALUE))
							{
								threeGNetBal = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALIDITY))
							{
								threeGNetBalExpDate = param.getValue();
							}
						}
					}
					
					String threeGFUNetBal = null;
					String threeGFUNetBalExpDate = null;
					if(threeGFUDataBalToken != null)
					{
						List<Param> listParam = threeGFUDataBalToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALUE))
							{
								threeGFUNetBal = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALIDITY))
							{
								threeGFUNetBalExpDate = param.getValue();
							}
						}
					}
					
					String cdmaDataNetBal = null;
					String cdmaDataBalExpDate = null;
					if(cdmaDataBalToken != null)
					{
						List<Param> listParam = cdmaDataBalToken.getMsgParam().getParam();
						
						for(Param param : listParam)
						{
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALUE))
							{
								cdmaDataNetBal = param.getValue();
							}
							if(param.getId().equalsIgnoreCase(HostConstants.PARAM_VALIDITY))
							{
								cdmaDataBalExpDate = param.getValue();
							}
						}
					}
					
					
					
					logBuilder.append("\n" + uniqueId + "|" + "2G Net Balance : " +twoGNetBal);
					logBuilder.append("\n" + uniqueId + "|" + "2G Net Balance Expiry Date : " +twoGNetBalExpDate);
					logBuilder.append("\n" + uniqueId + "|" + "3G Net Balance : " +threeGNetBal);
					logBuilder.append("\n" + uniqueId + "|" + "3G Net Balance Expiry Date : " +threeGNetBalExpDate);
					logBuilder.append("\n" + uniqueId + "|" + "CDMA Usage Net Balance : " +cdmaDataNetBal);
					logBuilder.append("\n" + uniqueId + "|" + "CDMA Usage Net Balance Expiry Date : " +cdmaDataBalExpDate);
					logBuilder.append("\n" + uniqueId + "|" + "3G Fair Usage Net Balance : " +threeGFUNetBal);
					logBuilder.append("\n" + uniqueId + "|" + "3G Fair Usage Net Balance Expiry Date : " +threeGFUNetBalExpDate);
					logger.debug(logBuilder.toString());
					
					resDataBalance.setTwoGNetBalance(twoGNetBal);
					resDataBalance.setTwoGNetBalanceExpiryDate(twoGNetBalExpDate);
					resDataBalance.setThreeGNetBalance(threeGNetBal);
					resDataBalance.setThreeGNetBalanceExpiryDate(threeGNetBalExpDate);
					resDataBalance.setcdmaDataBalance(cdmaDataNetBal);
					resDataBalance.setcdmaDataBalanceExpiryDate(cdmaDataBalExpDate);
					resDataBalance.setThreeGFairUsageBalance(threeGFUNetBal);
					resDataBalance.setThreeGFairUsageBalanceExpiryDate(threeGFUNetBalExpDate);
					
					
					msgTokens = null;
					tokens = null;
					
				}else{
					
					responseCode = errorCode;
					
					//For Reporting
					host.setHOSTRESPONSE(errorCode);
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
			
			resDataBalance.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(errorCode+HostConstants.PIPE+resDataBalance.toString());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			csssoapReciever = null;
			cssInfoPort = null;
			response = null;
			logBuilder = null;
		}
	}

}
