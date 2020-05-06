package com.servion.rcom.ppp.hostinterface;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;

import com.relianceada.ivr.Ivr;
import com.relianceada.ivr.IvrPortType;
import com.relianceada.ivr.OfferInfo;
import com.relianceada.ivr.Offers;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.servion.rcom.ppp.hostinterface.util.HostConstants;
import com.servion.rcom.ppp.hostinterface.util.HostTransactionID;
import com.servion.rcom.ppp.hostinterface.util.Utilities;
import com.servion.rcom.ppp.hostinterface.view.OfferDetails;
import com.servion.rcom.ppp.hostinterface.view.ReqDataOffers;
import com.servion.rcom.ppp.hostinterface.view.ResDataOffers;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class TransDataOffers implements ITransaction{

	ReqDataOffers reqDataOffers = null;
	ResDataOffers resDataOffers = new ResDataOffers();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	
	public ResDataOffers getHostInterface(IVRDataBean ivrDataBean , ReqDataOffers request) {
		

		try{
			
			uniqueId = Utilities.generateUniqueID();
			logger = ivrDataBean.getLogger();
			
			reportObject = ivrDataBean.getGetReportObject();
			host = reportObject.createReportHostObject();
			
			//For Reporting
			host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
			host.setHOSTID(HostTransactionID.TRANS_DATA_OFFERS);
			
			reqDataOffers = request;
			uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
			logger.debug(uniqueId + "|" + "TransDataOffers getHostInterface method start");
			wsdlProcessor();
			logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
			logger.debug(uniqueId + "|" + "TransDataOffers getHostInterface method end");
			return resDataOffers;
		
		}catch(Exception e)
		{
			
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
			return resDataOffers;
		}
	}
	
	@Override
	public void wsdlProcessor() {
		
		String MDN = null;
		
		Ivr ivr = null;
		IvrPortType ivrPortType = null;
		Offers offers = null;
		
		try {
			
			AppProperties appProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			
			//For Testing
			String serviceURL = null;
			String qnameNamespace = null;
			String qnameLocalpart = null;
			serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL_DATA_OFFERS);
			qnameNamespace = appProperties.getIVRProp(HostConstants.OFU_QNAME_NAMESPACE);
			qnameLocalpart = appProperties.getIVRProp(HostConstants.OFU_QNAME_LOCALPART);
			
			if(serviceURL == null || HostConstants.EMPTY.equalsIgnoreCase(serviceURL) || HostConstants.DISABLED.equalsIgnoreCase(serviceURL))
			{
				serviceURL = appProperties.getIVRProp(HostConstants.CSS_ENDPOINT_URL);
			}
			
			logger.debug(uniqueId + "|" + "Service URL : " +serviceURL);
			logger.debug(uniqueId + "|" + "QName Namespace : " +qnameNamespace);
			logger.debug(uniqueId + "|" + "QName Localpart : " +qnameNamespace);
			URL url = new URL(serviceURL);
			
			
			if(qnameNamespace != null && qnameLocalpart != null)
			{
				QName serviceName = new QName(qnameNamespace, qnameLocalpart);
				ivr = new Ivr(url, serviceName);
			}
			else
			{
				ivr = new Ivr();
			}
			ivrPortType = ivr.getIvr();
			
			String connectionTimeout = appProperties.getIVRProp(HostConstants.HOST_CONNECTION_TIMEOUT);
			String requestTimeout = appProperties.getIVRProp(HostConstants.HOST_REQUEST_TIMEOUT);
			
		    BindingProvider bindingProvider = (BindingProvider)ivrPortType;
			bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, Integer.parseInt(connectionTimeout));
			bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, Integer.parseInt(requestTimeout));
			
			MDN = reqDataOffers.getMDN();
			
			logger.debug(uniqueId + "|" + "Unique Id : " +uniqueId);
			logger.debug(uniqueId + "|" + "MDN : " +MDN);
			
			logger.debug(uniqueId + "|" + "Timestamp : " +Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)));
			logger.debug(uniqueId + "|" + "Before calling voice offers Service");
			
			//For Reporting
			host.setHOSTMETHOD(HostConstants.CSS_HOST_METHOD + HostConstants.PIPE + appProperties.getIVRProp(HostConstants.CSS_REQUEST_TYPE_OFU));
			host.setHOSTINPARAMS(HostConstants.CSS_REQUEST_TYPE_OFU + HostConstants.PIPE + HostConstants.CSS_REQUEST_SOURCE + HostConstants.PIPE + MDN+HostConstants.PIPE + Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT)) + HostConstants.PIPE + uniqueId);
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			offers = ivrPortType.getOffers(
					HostConstants.CSS_REQUEST_TYPE_OFU, 
					HostConstants.CSS_REQUEST_SOURCE, 
					MDN, 
					"",
					uniqueId);
			
			//Utilities.getTimeStamp(logger, appProperties.getIVRProp(HostConstants.CSS_REQUEST_TIMESTAMP_FORMAT))
			
			//For Reporting
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			logger.debug(uniqueId + "|" + "After calling voice offers Service");
			
			if(offers != null)
			{
					responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_SUCCESS);
					
					List<OfferInfo> listOffers = offers.getOffer();
					
					ArrayList<OfferDetails> listOfferDetails = new ArrayList<OfferDetails>();
					OfferDetails offerDetails = null;
					
					if(listOffers != null)
					{
						logger.debug(uniqueId + "|" + "No of Offers returned : " +listOffers.size());
						
						for(OfferInfo offerInfo : listOffers)
						{
							offerDetails = new OfferDetails();
							
							offerDetails.setCampaignName(offerInfo.getCampaignName());
							offerDetails.setCampaignText(offerInfo.getCampaignText());
							offerDetails.setMrp(offerInfo.getMRP());
							offerDetails.setValidity(offerInfo.getValidity());
							
							logger.debug(uniqueId + "|" + "Offer Details : " +offerDetails.toString());
							
							listOfferDetails.add(offerDetails);
						}
							
					}
					
					resDataOffers.setOfferDetailsList(listOfferDetails);
					
				}else{
					
					responseCode = HostConstants.RESPONSE_CODE_FAILURE;
					
					//For Reporting
					host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
					host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
					
				}
						
			
		}catch(Exception e) {
			
			responseCode = HostConstants.RESPONSE_CODE_FAILURE;
			
			//For Reporting
			host.setHOSTRESPONSE(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTSTATUS(HostConstants.REPORT_HOST_STATUS_FAILURE);
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			Utilities.printStackTrace(logger, uniqueId, e);
			
		} finally {
			
			resDataOffers.setResponseCode(responseCode);
			host.setHOSTOUTPARAMS(responseCode+HostConstants.PIPE+resDataOffers.toString());
			//For Reporting
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			
			ivr = null;
			ivrPortType = null;
			offers = null;
		}
	}

}
