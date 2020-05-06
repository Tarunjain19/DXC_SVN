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
import com.servion.rcom.hostinterface.util.AESCryptoService;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.CreditCardDetails;
import com.servion.rcom.hostinterface.view.ERecharge;
import com.servion.rcom.hostinterface.view.ReqPaymentUsingCreditcard;
import com.servion.rcom.hostinterface.view.ResPaymentUsingCreditcard;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;


//TODO : Pending WSDL, service names, request and response parameters
public class TransURLHitPaymentUsingCreditcard implements ITransaction{
	
	
	ReqPaymentUsingCreditcard reqPaymentValidation = null;
	ResPaymentUsingCreditcard resPaymentValidation = new ResPaymentUsingCreditcard();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String strResErrorCode = null;
	
	public ResPaymentUsingCreditcard getHostInterface(IVRDataBean ivrDataBean, ReqPaymentUsingCreditcard request) {

		try{
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_BUY_PACK_BY_CREDIT_CARD);
			
			reqPaymentValidation = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.info(uniqueId + "|" + "TransURLHitPaymentValidation getHostInterface method start");
			wsdlProcessor();
			logger.info(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.info(uniqueId + "|" + "TransURLHitPaymentValidation getHostInterface method end");
			return resPaymentValidation;
		}catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resPaymentValidation;
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
		StringBuilder sbUrlParameters = new StringBuilder(100);
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			String Url = appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_URL);
			String attrMessage = appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_ATTR_MESSAGE);
			String sourceId = appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_SOURCE_ID);
			String xmlHeader = appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_XML_HEADER);
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			String cardType = appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_CARD_TYPE);
			
			String MDN = reqPaymentValidation.getMDN();
			String MDNToBeRecharged = reqPaymentValidation.getMDNToBeRecharged();
			if(MDNToBeRecharged == null)
			{
				MDNToBeRecharged = MDN;
			}
			String rcType = reqPaymentValidation.getRcType();
			String OTP = reqPaymentValidation.getOTP();
			String amount = reqPaymentValidation.getAmount();
			CreditCardDetails cardDetails = reqPaymentValidation.getCreditCardDetails();
			String creditCardType = cardDetails.getCardType();
			String creditCardNo = cardDetails.getCardNumber();
			String cardCvvNo = cardDetails.getCardCVV();
			String cardExpDate = cardDetails.getCardExpiryDate();
			
			logBuilder.append(uniqueId + "|" + "MDN : " +MDN);
			logBuilder.append("|" + "MDNToBeRecharged : " +MDNToBeRecharged);
			logBuilder.append("|" + "RCType : " +rcType);
			logBuilder.append("|" + "amount : " +amount);
			logger.info(logBuilder.toString());
			
			/*String encCreditCardNo = Utilities.getDESEncryptedText(logger, creditCardNo, DESKey);
			String encCardCvvNo = Utilities.getDESEncryptedText(logger, cardCvvNo, DESKey);
			String encCardExpDate = Utilities.getDESEncryptedText(logger, cardExpDate, DESKey);
			String encAmount = Utilities.getDESEncryptedText(logger, amount, DESKey);
			String encOTP = Utilities.getDESEncryptedText(logger, OTP, DESKey);
			String encMDN = Utilities.getDESEncryptedText(logger, MDN, DESKey);
			String encMDNToBeRecharged = Utilities.getDESEncryptedText(logger, MDNToBeRecharged, DESKey);
			
			logBuilder.setLength(0);
			
			logBuilder.append("\n" + uniqueId + "|" + "encCreditCardNo : " +encCreditCardNo);
			logBuilder.append("\n" + uniqueId + "|" + "encCardCvvNo : " +encCardCvvNo);
			logBuilder.append("\n" + uniqueId + "|" + "encCardExpDate : " +encCardExpDate);
			logBuilder.append("\n" + uniqueId + "|" + "encAmount : " +encAmount);
			logBuilder.append("\n" + uniqueId + "|" + "encOTP : " +encOTP);
			logBuilder.append("\n" + uniqueId + "|" + "encMDN : " +encMDN);
			logBuilder.append("\n" + uniqueId + "|" + "encMDNToBeRecharged : " +encMDNToBeRecharged);
			logger.info(logBuilder.toString());*/
			
			eRecharge = new ERecharge();
			
			eRecharge.setSESSIONID(uniqueId);
			eRecharge.setSOURCE_ID(sourceId);
			eRecharge.setREQUESTER_MDN(MDN);
			eRecharge.setBENEFICIARY_MDN(MDNToBeRecharged);
			eRecharge.setRC_TYPE(rcType);
			eRecharge.setCCTYPE(creditCardType);
			eRecharge.setCCNO(creditCardNo);
			eRecharge.setCVVNO(cardCvvNo);
			eRecharge.setEXPDATE(cardExpDate);
			eRecharge.setOTP(OTP);
			eRecharge.setAMOUNT(amount);
			eRecharge.setCARD(cardType);
			
			String xml = Utilities.getXMLFromObject(logger, ERecharge.class, eRecharge, xmlHeader);
			
			//logger.info(uniqueId + "|" + "xml : " +xml);
			
			xml = AESCryptoService.encrypt(xml);
			
			logger.info(uniqueId + "|" + "Encrypted xml : " +xml);
			
			//sbUrlParameters.append(Url);
			sbUrlParameters.append(attrMessage);
			sbUrlParameters.append("=");
			sbUrlParameters.append(xml);
			
			String strAbsoluteURL = sbUrlParameters.toString();
			
			logger.info(uniqueId + "|" + "URL Parameters : " +Url+strAbsoluteURL);
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
				host.setHOSTINPARAMS("XXXXXX");
				host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				// Send post request
				httpURLConnection.setDoOutput(true);
				writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
				writer.append(strAbsoluteURL);
				writer.flush();
				writer.close();
				
				int connectionResponseCode = httpURLConnection.getResponseCode();
				
				logger.info(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
				
				reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				
				//For Reporting
				host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
				
				String line;
				StringBuffer xmlResponse = new StringBuffer();
				
				while ((line = reader.readLine()) != null) {
					xmlResponse.append(line);
				}
				
				logger.info(uniqueId + "|" + "Response : " +xmlResponse);
				
				String strXMLResponse = xmlResponse.toString();
				
				eRechargeRes = (ERecharge) Utilities.getObjectFromXML(logger, ERecharge.class, strXMLResponse);
				
				String strResSessionId = eRechargeRes.getSESSIONID();
				String strResAmount = eRechargeRes.getAMOUNT();
				String strResPaymentId = eRechargeRes.getPAYMENTID();
				strResErrorCode = eRechargeRes.getERRCODE();
				String strResMessage = eRechargeRes.getMESSAGE();
				String strResMinVal = eRechargeRes.getMINVAL();
				String strResMaxVal = eRechargeRes.getMAXVAL();
				
				logBuilder.setLength(0);
				logBuilder.append("\n" + uniqueId + "|" + "strResSessionId : " +strResSessionId);
				logBuilder.append("\n" + uniqueId + "|" + "strResAmount : " +strResAmount);
				logBuilder.append("\n" + uniqueId + "|" + "strResPaymentId : " +strResPaymentId);
				logBuilder.append("\n" + uniqueId + "|" + "strResErrorCode : " +strResErrorCode);
				logBuilder.append("\n" + uniqueId + "|" + "strResMessage : " +strResMessage);
				logBuilder.append("\n" + uniqueId + "|" + "strResMinVal : " +strResMinVal);
				logBuilder.append("\n" + uniqueId + "|" + "strResMaxVal : " +strResMaxVal);
				logger.info(logBuilder.toString());
				
				if(strResErrorCode != null && (!HostConstants.EMPTY.equalsIgnoreCase(strResErrorCode)) 
						&& appProperties.getIVRProp(HostConstants.URL_HIT_PAYMENT_VALIDATION_ERROR_CODE_SUCCESS).equalsIgnoreCase(strResErrorCode)){
					
					
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					resPaymentValidation.setPaymentId(strResPaymentId);
					
				}
				else
				{
					logger.info(uniqueId + "|" + "Host Response Failure : " +strResErrorCode);
					logger.info(uniqueId + "|" + "Host Response Failure Message: " +strResMessage);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
					responseCode = strResErrorCode;
				}
				
				
			} 
			else
			{
				logger.info(uniqueId + "|" + "Other than HTTP URL, Hence request not sent");
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				
			}
		}catch (SocketTimeoutException e) {
			
			responseCode = HostConstants.PAYMENT_ERROR_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
			
		}
		catch (IOException e) {
			
			responseCode = HostConstants.PAYMENT_ERROR_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
			
		} catch(Exception e) {
			
			responseCode = HostConstants.PAYMENT_ERROR_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			Utilities.printStackTrace(logger, uniqueId, e);
		}  
		finally{
			
			resPaymentValidation.setResponseCode(responseCode);
			
			//For Reporting
			host.setHOSTOUTPARAMS(strResErrorCode);
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
				logger.info(uniqueId + "|" + "Finally IOException : " +e);
				logger.info(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
			}
			
			urlConnection = null;
			httpURLConnection = null;
			writer = null;
			reader = null;
			logBuilder = null;
			
		}
		
	}

}


