
package com.rcom.hostinterface.util;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;



public class HttpRequest {

	private String URL = null;
	private String responseString = null;
    private Logger logger = null;
	private String connectionTimeout = null;
	
	
	public HttpRequest(String URL,Logger logger,String connTimeout)
	{
		this.URL = URL;
	    this.logger = logger;
		this.connectionTimeout = connTimeout;
		}
	
	public StringBuffer call() throws SocketTimeoutException, IOException, Exception
	{
		
		logger.debug("URL : " + this.URL);
		System.out.println("URL::"+URL);
		StringBuffer str = new StringBuffer(postMethod());
		return str;
	}
	
	
	@SuppressWarnings("finally")
	public String postMethod()
	{
		
		try{
			
			 PostMethod post = new PostMethod(URL);
			 post.setRequestHeader("Content-type", "text/xml; charset=ISO-8859-1");
			 logger.debug("URL in HttpRequest:PostMethod() " +URL);
			 System.out.println("URL in HttpRequest:PostMethod() " +URL);
			 HttpClient httpclient = new HttpClient();
			 if(connectionTimeout != null && connectionTimeout !="") 
				 {
				 httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(Integer.parseInt(connectionTimeout));
				 httpclient.getHttpConnectionManager().getParams().setSoTimeout(Integer.parseInt(connectionTimeout));
				 }
			 else
			 {
				 httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
				 httpclient.getHttpConnectionManager().getParams().setSoTimeout(5000);
			 }
			 
			 int result = httpclient.executeMethod(post);
				
			 // Display status code
	        System.out.println("Response status code: " + result);
	        if(result!=200){
	        	System.out.println("Exception in calling wenservice ResponseCode:"+result);
	        	logger.debug("Exception in calling wenservice ResponseCode:"+result);
	        	
	        }
	        else
	        {
	        	InputStream in = post.getResponseBodyAsStream();
	        	responseString = post.getResponseBodyAsString();
	        	logger.debug("Response String : " +responseString);
	        	System.out.println("Response String : " +responseString);
	        }
		
		}catch(Exception e){e.printStackTrace();
		System.out.println("Hello :"+e);}
		finally{
			
			URL = null;
			System.out.println("end");
		//	logger = null;
			return responseString;
			
		}
	}
	
}
