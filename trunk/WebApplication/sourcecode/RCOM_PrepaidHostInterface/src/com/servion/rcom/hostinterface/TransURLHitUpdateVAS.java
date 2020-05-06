package com.servion.rcom.hostinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

import com.servion.rcom.hostinterface.util.HostConstants;
import com.servion.rcom.hostinterface.util.Utilities;
import com.servion.rcom.hostinterface.view.ReqURLHitUpdateVAS;
import com.servion.rcom.hostinterface.view.ResURLHitUpdateVAS;
import com.servion.util.IVRDataBean;

public class TransURLHitUpdateVAS implements ITransaction{

	ReqURLHitUpdateVAS reqURLHitUpdateVAS = null;
	ResURLHitUpdateVAS resURLHitUpdateVAS = new ResURLHitUpdateVAS();
	private String uniqueId = null;
	private String responseCode = HostConstants.RESPONSE_CODE_FAILURE;
	Logger logger = null;
	
	public ResURLHitUpdateVAS getHostInterface(IVRDataBean ivrDataBean, ReqURLHitUpdateVAS request) {
		
		logger = ivrDataBean.getLogger();
		reqURLHitUpdateVAS = request;
		uniqueId = ivrDataBean.getSessionID();
		logger.info(uniqueId + "|" + "TransURLHitUpdateVAS getHostInterface method start");
		wsdlProcessor();
		logger.info(uniqueId + "|" + "Response Code to Call Flow : " + responseCode);
		logger.info(uniqueId + "|" + "TransURLHitUpdateVAS getHostInterface method end");
		return resURLHitUpdateVAS;
	}
	
	@Override
	public void wsdlProcessor() {
		
		URL absoluteURL = null;
		URLConnection urlConnection = null;
		HttpURLConnection httpURLconnection = null;
		InputStream inputStream = null;
		
			try {
				
				/*PropertiesBundle bundle = PropertiesBundle.getBundle(PropertiesFileNameConstants.GLOBALHOSTCONFIG);*/
				
				//No Need to maintain these values, as call flow itself will provide entire URL. Host Interface will only replace '%MDN%' in URL with actual MDN.
				
				/*String attrMDN = bundle.getString(HostConstants.URL_HIT_UPDATE_VAS_ATTR_MDN);
				String attrPackId = bundle.getString(HostConstants.URL_HIT_UPDATE_VAS_ATTR_PACKID);
				String attrAction = bundle.getString(HostConstants.URL_HIT_UPDATE_VAS_ATTR_ACTION);
				String actionValue = bundle.getString(HostConstants.URL_HIT_UPDATE_VAS_ACTION_VALUE);*/
				
				String url = reqURLHitUpdateVAS.getUrl();
				String MDN = reqURLHitUpdateVAS.getMDN();
				/*String encPackId = URLEncoder.encode(packId, "UTF-8");*/
				
				
				
				logger.info(uniqueId + "|" + "URL To be hit : " +url);
				logger.info(uniqueId + "|" + "MDN : " +MDN);
				/*logger.info(uniqueId + "|" + "UTF-8 Encoded Pack Id : " +encPackId);*/
				
				String absluteURL = url.replaceFirst("%MDN%", MDN);  
				
				logger.info(uniqueId + "|" + "Absolute URL : " +absluteURL);
				
				
				 
				 absoluteURL = new URL(absluteURL);
				 urlConnection = absoluteURL.openConnection();
				 
				 if(urlConnection instanceof HttpURLConnection)
				 {
					 httpURLconnection = (HttpURLConnection) urlConnection;
					 int connectionResponseCode = httpURLconnection.getResponseCode();
					 logger.info(uniqueId + "|" + "Connection Response Code : " +connectionResponseCode);
					 logger.info(uniqueId + "|" + "Before sending request");
					 inputStream = httpURLconnection.getInputStream();
					 logger.info(uniqueId + "|" + "After sending request");
					 
					 responseCode = HostConstants.RESPONSE_CODE_SUCCESS;
				 }
				 else
				 {
					 logger.info(uniqueId + "|" + "Other than HTTP URL, Hence request not sent");
					 responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				 }
				 
			} catch (MalformedURLException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				logger.info(uniqueId + "|" + "MalformedURLException : " +e);
				logger.info(uniqueId + "|" + "MalformedURLException : " +e.getMessage());
				Utilities.printStackTrace(logger, uniqueId, e);
			} catch(UnsupportedEncodingException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				logger.info(uniqueId + "|" + "UnsupportedEncodingException" +e);
				logger.info(uniqueId + "|" + "UnsupportedEncodingException Message : " +e.getMessage());
				Utilities.printStackTrace(logger, uniqueId, e);
			}catch (IOException e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				logger.info(uniqueId + "|" + "IOException : " +e);
				logger.info(uniqueId + "|" + "IOException Message : " +e.getMessage());
				Utilities.printStackTrace(logger, uniqueId, e);
			} catch (Exception e) {
				
				responseCode = HostConstants.RESPONSE_CODE_FAILURE;
				logger.info(uniqueId + "|" + "Exception Occured : " +e);
				logger.info(uniqueId + "|" + "Exception Error Message : " +e.getMessage());
				Utilities.printStackTrace(logger, uniqueId, e);
			}
			finally{
				resURLHitUpdateVAS.setResponseCode(responseCode);
				absoluteURL = null;
				
					try {
						
						if(urlConnection != null) ((HttpURLConnection) urlConnection).disconnect();
						if(httpURLconnection != null) httpURLconnection.disconnect();
						
						urlConnection = null;
						httpURLconnection = null;
						
						if(inputStream!= null) inputStream.close();
						inputStream = null;
					} catch (IOException e) {
					
						logger.info(uniqueId + "|" + "Finally IOException : " +e);
						logger.info(uniqueId + "|" + "Finally IOException Message : " +e.getMessage());
					}
					
					inputStream = null;
					urlConnection = null;
					httpURLconnection = null;
				
			}
			
	}

}
