package com.rcom.hostinterface;



import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.rcom.hostinterface.view.ReqStopVAS;
import com.rcom.hostinterface.view.ResStopVAS;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;
import com.rcom.hostinterface.util.HttpRequest;
import com.rcom.hostinterface.util.HostConstants;
import com.rcom.hostinterface.util.HostTransactionID;
import com.rcom.hostinterface.util.Utilities;
import com.servion.util.AppProperties;
import com.servion.util.IVRDataBean;
public class TransSTOPVAS {

	ReqStopVAS reqStopVAS = new ReqStopVAS();
	ResStopVAS resStopVAS = new ResStopVAS();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = Logger.getLogger(this.getClass());
	private HOST host = null;
	private GetReportObject reportObject = null;
	String hostResponse = HostConstants.REPORT_HOST_STATUS_FAILURE,hostStatus = HostConstants.LINK_DOWN,hostOutput = HostConstants.REPORT_HOST_STATUS_FAILURE;
	@SuppressWarnings("finally")
	public ResStopVAS getHostInterface(IVRDataBean ivrDataBean,
			ReqStopVAS request) {
		
		try
		{
		uniqueId = Utilities.generateUniqueID();
		logger = ivrDataBean.getLogger();
		reqStopVAS = request; 	
		reportObject = ivrDataBean.getGetReportObject();
		host = reportObject.createReportHostObject();
		
		//For Reporting
		host.setHOSTTYPE(HostConstants.HOST_REQUEST_TYPE);
		host.setHOSTID(HostTransactionID.TRANS_STOP_PACKS);
		host.setHOSTMETHOD(HostTransactionID.TRANS_STOP_PACKS);
	
		uniqueId = uniqueId+HostConstants.DOT+ivrDataBean.getSessionID();
		logger.debug(uniqueId + "|" + "TransActivePacks getHostInterface method start");
		processor();
		logger.debug(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.debug(uniqueId + "|" + "TransActivePacks getHostInterface method end");

			
		}
		catch(Exception e)
		{
			if(logger==null)
				logger = Logger.getLogger(this.getClass());
			Utilities.printStackTrace(logger, uniqueId, e);
				
		}
		finally{
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
			return resStopVAS;
		}
		
	}

	public void processor() {
		
		String strURL = null;
		String MDN = null;
		String requestMethod = null;
		String connectionTimeout = null;
		AppProperties hostProperties = null;
		StringBuilder logBuilder = new StringBuilder(100);
		String subID = null;
		
		try {
		
			hostProperties = AppProperties.GetInstance(HostConstants.GLOBALHOSTCONFIG);
			MDN = reqStopVAS.getMdn();
			subID = reqStopVAS.getSubID();
			requestMethod = HostConstants.URL_REQUEST_METHOD_POST;
			strURL = hostProperties.getIVRProp(HostConstants.ENDPOINT_URL_STOP_VAS);
			connectionTimeout = hostProperties.getIVRProp(HostConstants.CONNECTION_TIMEOUT);
			
			
			logBuilder.append(uniqueId + "|" + "Endpoint URL : " +strURL);
			logBuilder.append("|" + "Request Method : " +requestMethod);
			logBuilder.append("|" + "Connection Timeout : " +connectionTimeout);
						
			logBuilder.append("|" + "Inputs from IVR : ");
			logBuilder.append("|" + "MDN : " +MDN);
			
			logger.debug(logBuilder);
			//Customize URL
			strURL = strURL.replace("MDN",MDN);
			strURL = strURL.replace("SUBID",subID);
			
			logger.debug("Complete Url ::"+strURL);
			System.out.println("Complete Url ::"+strURL);
			
			HttpRequest httpRequest = new HttpRequest(strURL, logger, connectionTimeout);
			host.setHOSTINPARAMS(strURL);
			host.setHOSTSTDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			StringBuffer responseMessage = httpRequest.call();
			host.setHOSTENDDATETIME(Utilities.getTimeStamp(logger, HostConstants.DATE_TIME_FORMAT_HOST_REPORT));
			
			logger.debug("Response Message : " +responseMessage);
			System.out.println("Response Message :"+responseMessage);
			if(responseMessage!= null && !responseMessage.equals(HostConstants.EMPTY) && responseMessage.length() != 0)
			{
				parseResponse(responseMessage.toString());
				if(resStopVAS.getResponseCode().equalsIgnoreCase(HostConstants.RESPONSE_CODE_FAILURE)){
					hostResponse = HostConstants.REPORT_HOST_STATUS_FAILURE;
					hostStatus = HostConstants.REPORT_HOST_STATUS_FAILURE;
					hostOutput = resStopVAS.getResponseCode();
				}
				else{
					hostResponse = HostConstants.REPORT_HOST_STATUS_SUCCESS;
					hostStatus = HostConstants.REPORT_HOST_STATUS_SUCCESS;
					hostOutput = resStopVAS.getResponseCode();
				}
					
			}
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			host.setHOSTRESPONSE(hostResponse);
			host.setHOSTSTATUS(hostStatus);
			host.setHOSTOUTPARAMS(hostOutput);
		}
	}
	
	public void parseResponse(String responseMsg)
	{
		String code =HostConstants.RESPONSE_CODE_FAILURE;
		try{
			 DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 InputSource is = new InputSource();
			 is.setCharacterStream(new StringReader(responseMsg));
			 Document doc = db.parse(is);
			 NodeList node = doc.getElementsByTagName(HostConstants.CODE);
			 Element line = (Element) node.item(0);
			 code = getCharacterDataFromElement(line);
			 if(code !=null && code.equalsIgnoreCase(HostConstants.RESPONSE_CODE_SUCCESS))
				 resStopVAS.setResponseCode(code);
			 else
				 resStopVAS.setResponseCode(HostConstants.RESPONSE_CODE_FAILURE);
			 logger.debug("Response Code ::"+resStopVAS.getResponseCode());
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.debug("Error in TransSTOPVAS:: "+e.getMessage());
		}
	}
		 public static String getCharacterDataFromElement(Element e) {
			    Node child = e.getFirstChild();
			    if (child instanceof CharacterData) {
			       CharacterData cd = (CharacterData) child;
			       return cd.getData();
			    }
			    return "NA";
			  }
}
