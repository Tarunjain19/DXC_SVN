package com.servion.rdtv.hostinterface;

import java.net.URL;
import java.text.DecimalFormat;
//import java.util.Date;


import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;


import com.relianceada.si.crmgw.schemas.postpaid.AccountDetailsResponse;
import com.relianceada.si.crmgw.schemas.postpaid.GenericRequest;
import com.relianceada.si.crmgw.webservice.postpaid001.CRMGWPort;
import com.relianceada.si.crmgw.webservice.postpaid001.CRMGWPostpaid;
import com.servion.util.IVRDataBean;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.prepaid.report.GetReportObject;
import com.servion.util.AppProperties;
import com.servion.rdtv.hostinterface.util.HostConstants;
import com.servion.rdtv.hostservice.ReqAccountDetails;
import com.servion.rdtv.hostservice.ResAccountDetails;
import com.servion.rdtv.hostservice.Utilities;
import com.sun.xml.internal.ws.client.BindingProviderProperties;


public class TransAccountDetails implements ITransaction {
	ReqAccountDetails reqAccountDetails = null;
	ResAccountDetails resAccountDetails = new ResAccountDetails();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	private String responseStatusValue = null;
	
	public ResAccountDetails getHostInterface(IVRDataBean ivrDataBean, ReqAccountDetails request) {
		
		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTMETHOD(HostConstants.TRANS_ACCOUNT_ID);
			host.setHOSTID(HostConstants.TRANS_ACCOUNT_ID);
			
			reqAccountDetails = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransAccountDetails getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransAccountBalance getHostInterface method end");
			return resAccountDetails;
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resAccountDetails;
		}
	}

	@Override
	public void wsdlProcessor() {
		String accId = null;
		
		CRMGWPostpaid crmgwPostpaid = null;
		CRMGWPort crmgwPort = null;
		GenericRequest request = null;
		URL url = null;
		DecimalFormat f = new DecimalFormat("##.##");
		Double accBalDouble = null,unbillDouble=null;
		AccountDetailsResponse accountDetailsResponse = null;
		String serviceURL = null,connectionTimeout = null,requestTimeout = null,source = null,statusMessage = null,accBal= null,/*balanceDate = null,creditLimit = null*/unbilledAmount = null;
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);

			/** Forming Request URL **/
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_ACC_DETAILS);
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			url = new URL(serviceURL);
			
			crmgwPostpaid = new CRMGWPostpaid(url);
			crmgwPort = crmgwPostpaid.getCRMGWPort(); 
			
			connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			source = appProperties.getIVRProp(HostConstants.SOURCE);
			
		    BindingProvider bindingProvider = (BindingProvider)crmgwPort;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			accId = reqAccountDetails.getAccountId();
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "Source : " + source);
			logger.debug(uniqueId + "|" + "Account ID : " +accId);
			logger.debug(uniqueId + "|" + "StartTime : " + reqAccountDetails.getStartDate());
			
			/** Forming Request **/
			request = new GenericRequest();
			request.setSource(source);
			request.setStartDate( reqAccountDetails.getStartDate());
			request.setTransId(accId);
			
			//For Reporting
			host.setHOSTINPARAMS(request.getSource() + HostConstants.PIPE + request.getTransId() + HostConstants.PIPE + request.getStartDate());
			//host.setHOSTSTDATETIME(String.valueOf(new Date().getTime()));
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			accountDetailsResponse = crmgwPort.getAccountDetails(request);
			
			request = null;
			logger.debug(uniqueId + "|" + "After calling accountBalance Service");
			
			if(accountDetailsResponse != null)
			{
				responseStatusValue = accountDetailsResponse.getResponseStatus().getStatus();
				
				logger.debug(uniqueId + "|" + "Host Response Status Value : " +responseStatusValue);

				if((responseStatusValue != null) && (!HostConstants.EMPTY.equalsIgnoreCase(responseStatusValue)) && 
						(appProperties.getIVRProp(HostConstants.HOST_RESPONSE_ERROR_CODE_SUCCESS)).equalsIgnoreCase(responseStatusValue))
				{
					
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					accBal = accountDetailsResponse.getAccountDetails().getAccountBalance().toString();
					/*balanceDate = accountDetailsResponse.getAccountDetails().getBalanceDate().toString();
					creditLimit = accountDetailsResponse.getAccountDetails().getCreditLimit().toString();*/
					unbilledAmount = accountDetailsResponse.getAccountDetails().getUnbilledAmount().toString();
					
					/** Changes Done As per Request **/
					logger.info(uniqueId + "|" + "Host Return Account Balance :: "+accBal);
					logger.info(uniqueId + "|" + "Host Return Unbilled Amount :: "+unbilledAmount);
					
					 accBalDouble =  Double.parseDouble(accBal);
					 unbillDouble =  Double.parseDouble(unbilledAmount);
					 accBalDouble = accBalDouble + unbillDouble;
					if(accBalDouble<HostConstants.ZERO)
					{
						accBalDouble = accBalDouble*HostConstants.MINUS_ONE;
					}
					accBalDouble = Double.valueOf(f.format(accBalDouble));
					logger.info(uniqueId + "|" + "Host Return Current Balance :: "+accBalDouble);
					accBal = String.valueOf(accBalDouble);
					
					accBal = Utilities.adjustDecimal(logger, accBal);
					//Changes ends Here
					
					/** Storing in Response POJO **/
					resAccountDetails.setAccBalance(accBal);
					/*resAccountDetails.setBalanceDate(balanceDate);
					resAccountDetails.setCreditLimit(creditLimit);*/
					resAccountDetails.setUnbilledAount(unbilledAmount);
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
				}
				else
				{
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					logger.debug(uniqueId + "|" + "Host Response Message :: " +statusMessage);
				}
						
			}
			else
			{
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				
				//For Reporting
				host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
				host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
				logger.debug(uniqueId + "|" + "Host Response :: " +accountDetailsResponse);
			}
		}catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			Utilities.printStackTrace(logger, uniqueId, e);
			
		} finally {
			resAccountDetails.setResponseCode(responseCode);
			//For Reporting
			//host.setHOSTENDDATETIME(String.valueOf(new Date().getTime()));
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			host.setHOSTOUTPARAMS(responseStatusValue);
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			serviceURL=null;url=null;request = null;accountDetailsResponse = null;crmgwPort = null;accBalDouble=null;unbillDouble = null;f=null;crmgwPostpaid = null;connectionTimeout=null;requestTimeout = null;source = null;statusMessage = null;accBal= null;/*balanceDate = null;creditLimit = null;unbilledAount = null;*/
		}
	}

		
	}


