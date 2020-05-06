package com.servion.rcom.hostinterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ERecharge;
import com.servion.rcom.hostinterface.view.ReqTopUpAmountValidation;
import com.servion.rcom.hostinterface.view.ResTopUpAmountValidation;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

//TODO : Pending WSDL, service names, request and response parameters
public class TransURLHitTopUpAmountValidation implements ITransaction{

	
	ReqTopUpAmountValidation reqTopUpAmountValidation = null;
	ResTopUpAmountValidation resTopUpAmountValidation = new ResTopUpAmountValidation();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String strResErrorCode = null;
	
	public ResTopUpAmountValidation getHostInterface(IVRDataBean ivrDataBean, ReqTopUpAmountValidation request){

		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_TOP_UP_AMOUNT_VALIDATION);
			
			reqTopUpAmountValidation = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransURLHitTopUpAmountValidation getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransURLHitTopUpAmountValidation getHostInterface method end");
			return resTopUpAmountValidation;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resTopUpAmountValidation;
		}
	}
	
	@Override
	public void wsdlProcessor() {
		
		URL absoluteURL = null;
		ERecharge eRecharge = null;
		ERecharge eRechargeRes = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpURLConnection  = null;
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		StringBuilder sbUrlParameters = new StringBuilder();
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			String Url = appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_URL);
			String attrMessage = appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_ATTR_MESSAGE);
			String xmlHeader = appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_XML_HEADER);
			String rcType = appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_RC_TYPE);
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
			String MDN = reqTopUpAmountValidation.getMDN();
			String MDNToBeRecharged = reqTopUpAmountValidation.getMDNToBeRecharged();
			if(MDNToBeRecharged == null)
			{
				MDNToBeRecharged = MDN;
			}
			String amount = reqTopUpAmountValidation.getAmount();
			
			
			logBuilder.append(uniqueId + "|" + "MDN : " +MDN);
			logBuilder.append("|" + "MDNToBeRecharged : " +MDNToBeRecharged);
			logBuilder.append("|" + "topUpType : " +rcType);
			logBuilder.append("|" + "amount : " +amount);
			logger.debug(logBuilder.toString());
			
			
			
			
			eRecharge = new ERecharge();
			
			eRecharge.setREQUESTER_MDN(MDN);
			eRecharge.setBENEFICIARY_MDN(MDNToBeRecharged);
			eRecharge.setRC_TYPE(rcType);
			eRecharge.setAMOUNT(amount);
			
			String xml = Utilities.getXMLFromObject(logger, ERecharge.class, eRecharge, xmlHeader);
			
			logger.debug(uniqueId + "|" + "xml : " +xml);
			
			//sbUrlParameters.append(Url);
			sbUrlParameters.append(attrMessage);
			sbUrlParameters.append("=");
			sbUrlParameters.append(xml);
			
			String strAbsoluteURL = sbUrlParameters.toString();
			System.out.println(strAbsoluteURL);
			logger.debug(uniqueId + "|" + "URL Parameters : " +Url+strAbsoluteURL);
			absoluteURL = new URL(Url);
			urlConnection = absoluteURL.openConnection();
			
			if(urlConnection instanceof HttpURLConnection)
			{
				httpURLConnection = (HttpURLConnection) urlConnection;
				//add request header
				httpURLConnection.setRequestMethod("POST");
				
				if(connectionTimeout != null && connectionTimeout != HostConstants.EMPTY) httpURLConnection.setConnectTimeout(Integer.parseInt(connectionTimeout));
				if(requestTimeout != null && requestTimeout != HostConstants.EMPTY) httpURLConnection.setReadTimeout(Integer.parseInt(requestTimeout));
				
				//For Reporting
				host.setHOSTMETHOD(Url + HostConstants.PIPE);
				host.setHOSTINPARAMS(eRecharge.toString());
				host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				// Send post request
				httpURLConnection.setDoOutput(true);
				writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
				writer.append(strAbsoluteURL);
				writer.flush();
				writer.close();
				
				int connectionResponseCode = httpURLConnection.getResponseCode();
				
				logger.debug(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
				
				reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				
				//For Reporting
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				String line;
				StringBuffer xmlResponse = new StringBuffer();
				
				while ((line = reader.readLine()) != null) {
					xmlResponse.append(line);
				}
				
				logger.debug(uniqueId + "|" + "Response : " +xmlResponse);
				
				String strXMLResponse = xmlResponse.toString();
				
				eRechargeRes = (ERecharge) Utilities.getObjectFromXML(logger, ERecharge.class, strXMLResponse);
				
				String strResRequesterMDN = eRechargeRes.getREQUESTER_MDN();
				String strResBeneficiaryMDN = eRechargeRes.getBENEFICIARY_MDN();
				String strResRCType = eRechargeRes.getRC_TYPE();
				String strResAmount = eRechargeRes.getAMOUNT();
				String strResTalktime = eRechargeRes.getTALKTIME();
				String strResMinVal = eRechargeRes.getMINVAL();
				String strResMinTalktimeValue = eRechargeRes.getMINTTVAL();
				String strResMaxVal = eRechargeRes.getMAXVAL();
				String strResMaxTalktimeValue = eRechargeRes.getMAXTTVAL();
				strResErrorCode = eRechargeRes.getERRCODE();
				String strResMessage = eRechargeRes.getMESSAGE();
				
				logBuilder.setLength(0);
				logBuilder.append("\n" + uniqueId + "|" + "strResRequesterMDN : " +strResRequesterMDN);
				logBuilder.append("\n" + uniqueId + "|" + "strResBeneficiaryMDN : " +strResBeneficiaryMDN);
				logBuilder.append("\n" + uniqueId + "|" + "strResRCType : " +strResRCType);
				logBuilder.append("\n" + uniqueId + "|" + "strResAmount : " +strResAmount);
				logBuilder.append("\n" + uniqueId + "|" + "strResTalktime : " +strResTalktime);
				logBuilder.append("\n" + uniqueId + "|" + "strResMinVal : " +strResMinVal);
				logBuilder.append("\n" + uniqueId + "|" + "strResMinTalktimeValue : " +strResMinTalktimeValue);
				logBuilder.append("\n" + uniqueId + "|" + "strResMaxVal : " +strResMaxVal);
				logBuilder.append("\n" + uniqueId + "|" + "strResMaxTalktimeValue : " +strResMaxTalktimeValue);
				logBuilder.append("\n" + uniqueId + "|" + "strResErrorCode : " +strResErrorCode);
				logBuilder.append("\n" + uniqueId + "|" + "strResMessage : " +strResMessage);
				logger.debug(logBuilder.toString());
				
				if(strResErrorCode != null && (!HostConstants.EMPTY.equalsIgnoreCase(strResErrorCode)) 
						&& appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_ERROR_CODE_SUCCESS).indexOf(strResErrorCode)>=0){
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					if(strResErrorCode.equalsIgnoreCase(appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_EXACT_VAL)))
					{
						responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
						resTopUpAmountValidation.setCurrentTopupAmountTalktime(strResTalktime);
					}
					else if(strResErrorCode.equalsIgnoreCase(appProperties.getIVRProp(HostConstants.URL_HIT_TOPUP_AMOUNT_VALIDATION_ERR_CODE_NEAR_VAL)))
					{
						responseCode = HostConstants.RESPONSE_CODE_MINUS_ONE;
						resTopUpAmountValidation.setCurrentTopupAmountTalktime(strResTalktime);
						resTopUpAmountValidation.setMinVal(strResMinVal);
						resTopUpAmountValidation.setMinValTalktime(strResMinTalktimeValue);
						resTopUpAmountValidation.setMaxVal(strResMaxVal);
						resTopUpAmountValidation.setMaxValTalktime(strResMaxTalktimeValue);
					}
					
					
				}
				else
				{
					logger.debug(uniqueId + "|" + "Host Response Failure : " +strResErrorCode);
					logger.debug(uniqueId + "|" + "Host Response Failure Message: " +strResMessage);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					responseCode = strResErrorCode;
				}
				
				
			} 
			else
			{
				logger.debug(uniqueId + "|" + "Other than HTTP URL, Hence request not sent");
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			}
		}catch (SocketTimeoutException e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
		}
		catch (IOException e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
			
		} catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
		}  
		finally{
			
			resTopUpAmountValidation.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(strResErrorCode+HostConstants.PIPE+eRecharge.toString());
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			absoluteURL = null;
			eRecharge = null;
			eRechargeRes = null;
			sbUrlParameters = null;
			
			try{
				
				if(urlConnection != null) ((HttpURLConnection) urlConnection).disconnect();
				if(httpURLConnection != null) httpURLConnection.disconnect();
				
				urlConnection = null;
				httpURLConnection = null;

				
				if(writer != null){
					writer.close();
					writer = null;
				}
				if(reader != null){
					reader.close();
					reader = null;
				}
				
			}catch (IOException e) {
				logger.debug(uniqueId + "|" + "Finally IOException : " +e);
				logger.debug(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
			}
			
			urlConnection = null;
			httpURLConnection = null;
			writer = null;
			reader = null;
			logBuilder = null;
			
		}
		
	}

}
