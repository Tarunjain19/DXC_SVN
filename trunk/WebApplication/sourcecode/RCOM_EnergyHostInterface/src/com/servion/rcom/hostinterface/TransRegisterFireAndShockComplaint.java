package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostConstants.REPORT_PS_CS;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.HttpRequest;
import com.servion.rcom.hostinterface.util.QueryString;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqRegisterFireAndShockComplaint;
import com.servion.rcom.hostinterface.view.ResRegisterFireAndShockComplaint;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class TransRegisterFireAndShockComplaint implements ITransaction{

	ReqRegisterFireAndShockComplaint reqRegisterFireAndShockComplaint = null;
	ResRegisterFireAndShockComplaint resRegisterFireAndShockComplaint = new ResRegisterFireAndShockComplaint();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public ResRegisterFireAndShockComplaint getHostInterface(IVRDataBean ivrDataBean, ReqRegisterFireAndShockComplaint request){
		
		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_REGISTER_FIRE_AND_SHOCK_COMPLAINT);
			host.setHOSTMETHOD(HostTransactionID.TRANS_REGISTER_FIRE_AND_SHOCK_COMPLAINT);
			
			reqRegisterFireAndShockComplaint = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransRegisterFireAndShockComplaint getHostInterface method start");
			processor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransRegisterFireAndShockComplaint getHostInterface method end");
			return resRegisterFireAndShockComplaint;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resRegisterFireAndShockComplaint;
		}
	}
	
	@Override
	public void processor() {
		
		String strURL = null;
		String IVRSerialNo = null;
		String accountNo = null;
		String MDN = null;
		String TAT = null;
		String complaintStatus = null;
		String complaintNumber = null;
		String requestMethod = null;
		String connectionTimeout = null;
		String readTimeout = null;
		String userAgent = null;
		boolean complaintByAccNo = false;
		String complaintTypeReport = null;
		String complaintStatusReport = HostConstants.EMPTY;
		QueryString qs = null;
		AppProperties hostProperties = null;
		String strResMessage = HostConstants.EMPTY;
		StringBuilder logBuilder = new StringBuilder(100);
		
		try {
		
			hostProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			accountNo = reqRegisterFireAndShockComplaint.getAccountNo();
			MDN = HostConstants.STR_0+reqRegisterFireAndShockComplaint.getMDN(); /** For CR the changes Done **/
			complaintByAccNo = reqRegisterFireAndShockComplaint.isComplaintByAccNo();
			
			requestMethod = hostProperties.getIVRProp(HostConstants.URL_REQUEST_METHOD);
			if(requestMethod == null || requestMethod.equalsIgnoreCase(HostConstants.EMPTY)) requestMethod = HostConstants.URL_REQUEST_METHOD_POST;
			userAgent = hostProperties.getIVRProp(HostConstants.USER_AGENT);
			IVRSerialNo = hostProperties.getIVRProp(HostConstants.IVR_SERIAL_NUMBER);
			strURL = hostProperties.getIVRProp(HostConstants.ENDPOINT_URL_REGISTER_FIRE_AND_SHOCK_COMPLAINT);
			connectionTimeout = hostProperties.getIVRProp(HostConstants.CONNECTION_TIMEOUT);
			readTimeout = hostProperties.getIVRProp(HostConstants.READ_TIMEOUT);
			
			logBuilder.append(uniqueId + "|" + "Endpoint URL : " +strURL);
			logBuilder.append("|" + "Request Method : " +requestMethod);
			logBuilder.append("|" + "IVR Serial No : " +IVRSerialNo);
			
			logBuilder.append("|" + "Inputs from IVR : ");
			logBuilder.append("|" + "Account Number : " +accountNo);
			logBuilder.append("|" + "MDN : " +MDN);
			logBuilder.append("|" + "Complaint By Account No : " +complaintByAccNo);
			
			logger.debug(logBuilder);
			
			complaintTypeReport = complaintByAccNo?HostConstants.REPORT_PS_COMPLAINT_TYPE_ACC_NO:HostConstants.REPORT_PS_COMPLAINT_TYPE_REG_NO;
			
			qs = new QueryString(HostConstants.FIELD1, IVRSerialNo);
			qs.add(HostConstants.FIELD2, accountNo);
			qs.add(HostConstants.FIELD3, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD4, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD5, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD6, MDN);
			qs.add(HostConstants.FIELD7, HostConstants.STR_1);
			qs.add(HostConstants.FIELD8, HostConstants.STR_3);
			
			

			HttpRequest httpRequest = new HttpRequest(strURL, qs.toString(), requestMethod, userAgent, logger, connectionTimeout, readTimeout);
			host.setHOSTINPARAMS(complaintTypeReport
				+ HostConstants.PIPE_SEPERATOR
				+ accountNo
				+ HostConstants.PIPE_SEPERATOR
				+ MDN
				+ HostConstants.PIPE_SEPERATOR
				+ URLDecoder.decode(qs.toString(), HostConstants.DECODE_FORMAT));
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			StringBuffer responseMessage = httpRequest.call();
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			logger.debug("Response Message : " +responseMessage);
			
			if(responseMessage!= null && !responseMessage.equals(HostConstants.EMPTY) && responseMessage.length() != 0)
			{
				strResMessage = responseMessage.toString();
				
				if(strResMessage.split(HostConstants.COMMA_SEPERATOR).length > 1)
				{
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					String[] resFields = strResMessage.split(HostConstants.COMMA_SEPERATOR);
					
					TAT = resFields[2];
					complaintStatus = resFields[5];
					
					logger.debug("TAT : " +TAT);
					logger.debug("Complaint Status : " +complaintStatus);
					
					if(TAT.equalsIgnoreCase(HostConstants.STR_0) && complaintStatus.equalsIgnoreCase(HostConstants.CS_99))
					{
						complaintNumber = resFields[4];
						resRegisterFireAndShockComplaint.setComplaintRegistered(true);
						resRegisterFireAndShockComplaint.setComplaintNumber(complaintNumber);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.FRESH_COMPLAINT_FIRE_AND_SHOCK.name();
					}
					else
					{
						resRegisterFireAndShockComplaint.setComplaintRegistered(false);
						complaintStatusReport = REPORT_PS_CS.FIRE_AND_SHOCK_COMPLAINT_UNSUCCESS.name();
					}
					
					
					logger.debug(uniqueId + "|" + "Is Complaint Registered : " +resRegisterFireAndShockComplaint.isComplaintRegistered());
					logger.debug(uniqueId + "|" + "Complaint Number : " +resRegisterFireAndShockComplaint.getComplaintNumber());
					logger.debug(uniqueId + "|" + "Complaint Status : " +complaintStatusReport);
					
				}
				else
				{
						responseCode = HostConstants.RESPONSE_CODE_FAILURE;
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				}
			}
			else
			{
				logger.debug("Response Message is null (or) Empty (or) size 0, Hence returning Hosttimeout response code. ");
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			}
			
		
		}catch(SocketTimeoutException e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		} catch (IOException e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_DOWN);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		} catch(Exception e) {
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			Utilities.printStackTrace(logger, uniqueId, e);
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
		}
		
		finally{

			resRegisterFireAndShockComplaint.setResponseCode(responseCode);
			
			//For Reporting
			if(resRegisterFireAndShockComplaint.getResponseCode().equalsIgnoreCase(HostConstants.RESPONSE_CODE_SUCCESS) /*&& resRegisterFireAndShockComplaint.isComplaintRegistered()*/)
				host.setHOSTOUTPARAMS(complaintStatusReport);
			else 
				host.setHOSTOUTPARAMS(strResMessage);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			logBuilder = null;
		}
		
	}

}
