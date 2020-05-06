package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;

import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.HostConstants.ComplaintStatus;
import com.servion.rcom.hostinterface.util.HostConstants.REPORT_PS_CS;
import com.servion.rcom.hostinterface.util.HostTransactionID;
import com.servion.rcom.hostinterface.util.HttpRequest;
import com.servion.rcom.hostinterface.util.QueryString;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqRegisterNoSupplyComplaint;
import com.servion.rcom.hostinterface.view.ResRegisterNoSupplyComplaint;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;

public class TransRegisterNoSupplyComplaint implements ITransaction{

	ReqRegisterNoSupplyComplaint reqRegisterNoSupplyComplaint = null;
	ResRegisterNoSupplyComplaint resRegisterNoSupplyComplaint = new ResRegisterNoSupplyComplaint();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public ResRegisterNoSupplyComplaint getHostInterface(IVRDataBean ivrDataBean, ReqRegisterNoSupplyComplaint request){
		
		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_REGISTER_NO_SUPPLY_COMLAINT);
			host.setHOSTMETHOD(HostTransactionID.TRANS_REGISTER_NO_SUPPLY_COMLAINT);
			
			reqRegisterNoSupplyComplaint = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransRegisterNoSupplyComplaint getHostInterface method start");
			processor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransRegisterNoSupplyComplaint getHostInterface method end");
			return resRegisterNoSupplyComplaint;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resRegisterNoSupplyComplaint;
		}
	}
	
	@Override
	public void processor() {
		
		String strURL = null;
		String IVRSerialNo = null;
		String accountNo = null;
		String MDN = null;
		boolean isIndividual = false;
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
			accountNo = reqRegisterNoSupplyComplaint.getAccountNo();
			MDN = HostConstants.STR_0+reqRegisterNoSupplyComplaint.getMDN(); /** For CR the Changes Done **/
			isIndividual = reqRegisterNoSupplyComplaint.isIndividual();
			complaintByAccNo = reqRegisterNoSupplyComplaint.isComplaintByAccNo();
			
			requestMethod = hostProperties.getIVRProp(HostConstants.URL_REQUEST_METHOD);
			if(requestMethod == null || requestMethod.equalsIgnoreCase(HostConstants.EMPTY)) requestMethod = HostConstants.URL_REQUEST_METHOD_POST;
			userAgent = hostProperties.getIVRProp(HostConstants.USER_AGENT);
			IVRSerialNo = hostProperties.getIVRProp(HostConstants.IVR_SERIAL_NUMBER);
			strURL = hostProperties.getIVRProp(HostConstants.ENDPOINT_URL_REGISTER_NO_SUPPLY_COMPLAINT);
			connectionTimeout = hostProperties.getIVRProp(HostConstants.CONNECTION_TIMEOUT);
			readTimeout = hostProperties.getIVRProp(HostConstants.READ_TIMEOUT);
			
			
			logBuilder.append(uniqueId + "|" + "Endpoint URL : " +strURL);
			logBuilder.append("|" + "Request Method : " +requestMethod);
			logBuilder.append("|" + "IVR Serial No : " +IVRSerialNo);
			
			logBuilder.append("|" + "Inputs from IVR : ");
			logBuilder.append("|" + "Account Number : " +accountNo);
			logBuilder.append("|" + "MDN : " +MDN);
			logBuilder.append("|" + "Is Individual Area : " +isIndividual);
			logBuilder.append("|" + "Complaint By Account No : " +complaintByAccNo);
			
			logger.debug(logBuilder);
			
			complaintTypeReport = complaintByAccNo?HostConstants.REPORT_PS_COMPLAINT_TYPE_ACC_NO:HostConstants.REPORT_PS_COMPLAINT_TYPE_REG_NO;
			
			qs = new QueryString(HostConstants.FIELD1, IVRSerialNo);
			qs.add(HostConstants.FIELD2, accountNo);
			qs.add(HostConstants.FIELD3, HostConstants.DEFAULT_FIELD_VALUE);
			qs.add(HostConstants.FIELD4, HostConstants.DEFAULT_FIELD_VALUE);
			/** For CR Changes Value Changed Here **/
			//qs.add(HostConstants.FIELD5, HostConstants.STR_1);
			qs.add(HostConstants.FIELD5, HostConstants.STR_0);
			qs.add(HostConstants.FIELD6, MDN);
			qs.add(HostConstants.FIELD7, HostConstants.STR_1);
			
			if(isIndividual)
			{
				qs.add(HostConstants.FIELD8, HostConstants.STR_1);
			}
			else
			{
				qs.add(HostConstants.FIELD8, HostConstants.STR_2);
			}
			

			HttpRequest httpRequest = new HttpRequest(strURL, qs.toString(), requestMethod, userAgent, logger, connectionTimeout, readTimeout);
			host.setHOSTINPARAMS(complaintTypeReport
					+ HostConstants.PIPE_SEPERATOR
					+ accountNo
					+ HostConstants.PIPE_SEPERATOR
					+ MDN
					+ HostConstants.PIPE_SEPERATOR
					+ URLDecoder.decode(qs.toString(), HostConstants.DECODE_FORMAT));
			
			
			System.out.println(host.getHOSTINPARAMS());
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
					
					resRegisterNoSupplyComplaint.setValidAccount(true);
					
					String[] resFields = strResMessage.split(HostConstants.COMMA_SEPERATOR);
					
					TAT = resFields[2];
					complaintNumber = resFields[4];
					complaintStatus = resFields[5];
					
					logBuilder.setLength(0);
					logBuilder.append("TAT : " +TAT);
					logBuilder.append(" | Complaint Status : " +complaintStatus);
					logBuilder.append(" | Complaint Number : " +complaintNumber);
					logger.debug(logBuilder);
					
					//If Complaint status code is 51 and TAT is not 0 or 52 and TAT is not 0, then it is considered as planned outage
					if(complaintStatus.equalsIgnoreCase(HostConstants.CS_51) && !TAT.equalsIgnoreCase(HostConstants.STR_0)
							|| complaintStatus.equalsIgnoreCase(HostConstants.CS_52) && !TAT.equalsIgnoreCase(HostConstants.STR_0))
					{
						resRegisterNoSupplyComplaint.setKnownOutage(true);
						resRegisterNoSupplyComplaint.setTAT(TAT);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.KNOWN_OUTAGE.name();
					}
					/** Changes Done For the Receiving Station Down **/
						/*//If Complaint status code is 52, then it is considered as Major Breakdown
						else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_52)&& !TAT.equalsIgnoreCase(HostConstants.STR_0))
						{
							resRegisterNoSupplyComplaint.setStationDown(true);
							resRegisterNoSupplyComplaint.setTAT(TAT);
							
							//For reporting
							complaintStatusReport = REPORT_PS_CS.RECEIVING_STATION_DOWN.name();
						}*/
					//If Complaint status is 92, then it is considered as complaint closed
					else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_92)||complaintStatus.equalsIgnoreCase(HostConstants.CS_90))
					{
						resRegisterNoSupplyComplaint.setComplaintStatus(ComplaintStatus.CLOSED);
						resRegisterNoSupplyComplaint.setComplaintNumber(complaintNumber);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.EXISTING_COMPLAINT_CLOSED_OR_OPEN_OUTSIDE_TAT.name();
					}
					//If Complaint status is 91 and TAT is 0, then it is considered as complaint is open outside TAT
					else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_91) && TAT.equalsIgnoreCase(HostConstants.STR_0))
					{
						resRegisterNoSupplyComplaint.setComplaintStatus(ComplaintStatus.OPEN_OUTSIDE_TAT);
						resRegisterNoSupplyComplaint.setComplaintNumber(complaintNumber);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.EXISTING_COMPLAINT_CLOSED_OR_OPEN_OUTSIDE_TAT.name();
					}
					//If Complaint status is 91 and TAT is not 0, then it is considered as complaint is open within TAT
					else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_91) && !TAT.equalsIgnoreCase(HostConstants.STR_0))
					{
						resRegisterNoSupplyComplaint.setComplaintStatus(ComplaintStatus.OPEN_WITHIN_TAT);
						resRegisterNoSupplyComplaint.setComplaintNumber(complaintNumber);
						resRegisterNoSupplyComplaint.setTAT(TAT);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.EXISTING_COMPLAINT_OPEN_WITHIN_TAT.name();
					}
					//If Complaint status is 99 and TAT is 0, then fresh complaint is registered and new complaint number will be returned
					else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_93) || complaintStatus.equalsIgnoreCase(HostConstants.CS_53))
					{
						resRegisterNoSupplyComplaint.Set_Response_93_53(true);
						
						complaintStatusReport = REPORT_PS_CS.SAFETY_NON_PAYMENTS.name();
					}
					
					else if(complaintStatus.equalsIgnoreCase(HostConstants.CS_99) && TAT.equalsIgnoreCase(HostConstants.STR_0))
					{
						resRegisterNoSupplyComplaint.setComplaintStatus(ComplaintStatus.FRESH_COMPLAINT);
						resRegisterNoSupplyComplaint.setComplaintNumber(complaintNumber);
						
						//For reporting
						if(isIndividual)
							complaintStatusReport = REPORT_PS_CS.FRESH_COMPLAINT_INDIVIDUAL_AREA_POWER_INTERUPTION.name();
						else
							complaintStatusReport = REPORT_PS_CS.FRESH_COMPLAINT_LARGE_AREA_POWER_INTERUPTION.name();
					}
					else
					{
						responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					}
					
				}
				else
				{
					if(strResMessage.contains(HostConstants.EXCEPTION_MESSAGE_REL_INVALID_CA))
					{
						responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						
						//For reporting
						complaintStatusReport = REPORT_PS_CS.INVALID_ACCOUNT_NO.name();
						
						resRegisterNoSupplyComplaint.setValidAccount(false);
					}
					/** Receiving Station Down Scenario -- if the responseMessage contains "LINKDOWN" String **/
					else if(strResMessage.contains(HostConstants.LINKDOWN) || strResMessage.contains(HostConstants.LINK_DOWN))
					{
						responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
						complaintStatusReport = REPORT_PS_CS.RECEIVING_STATION_DOWN.name();
						
						resRegisterNoSupplyComplaint.setStationDown(true);
						
					}
					else
					{
						responseCode = HostConstants.RESPONSE_CODE_FAILURE;
						
						//For Reporting
						host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
						host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					}
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

			resRegisterNoSupplyComplaint.setResponseCode(responseCode);
			
			logBuilder.setLength(0);
			logBuilder.append(uniqueId + "|" + "Complaint Status : " +resRegisterNoSupplyComplaint.getComplaintStatus());
			logBuilder.append("|" + "TAT : " +resRegisterNoSupplyComplaint.getTAT());
			logBuilder.append("|" + "Complaint Number : " +resRegisterNoSupplyComplaint.getComplaintNumber());
			logBuilder.append("|" + "Is Valid Account : " +resRegisterNoSupplyComplaint.isValidAccount());
			logBuilder.append("|" + "Is Known Outage : " +resRegisterNoSupplyComplaint.isKnownOutage());
			logBuilder.append("|" + "Is Station Down : " +resRegisterNoSupplyComplaint.isStationDown());
			logger.debug(logBuilder);
			
			//For Reporting
			if(resRegisterNoSupplyComplaint.getResponseCode().equalsIgnoreCase(HostConstants.RESPONSE_CODE_SUCCESS))
				host.setHOSTOUTPARAMS(complaintStatusReport);
			else 
				host.setHOSTOUTPARAMS(strResMessage);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			logBuilder = null;
		}
		
	}
	

}
