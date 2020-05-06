package com.servion.rcom.hostinterface.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class HttpRequest {

	private String URL = null;
	private String queryString = null;
	private String requestMethod = null;
	private StringBuffer responseString = null;
	private String userAgent = null;
	private Logger logger = null;
	private String connectionTimeout = null;
	private String readTimeout = null;
	
	private URL absoluteURL = null;
	private URLConnection urlConnection = null;
	private HttpURLConnection httpURLConnection = null;
	private BufferedReader in = null;
	private OutputStreamWriter writer = null;
	
	private static String REQUEST_TYPE_GET = "GET";
	
	public HttpRequest(String URL, String queryString, String requestMethod, String userAgent, Logger logger, String connTimeout, String readTimeout)
	{
		this.URL = URL;
		this.queryString = queryString;
		this.requestMethod = requestMethod;
		this.userAgent = userAgent;
		this.logger = logger;
		this.connectionTimeout = connTimeout;
		this.readTimeout = readTimeout;
	}
	
	public StringBuffer call() throws SocketTimeoutException, IOException, Exception
	{
		
		logger.debug("URL : " + this.URL);
		logger.debug("Query String : " +this.queryString);
		if(requestMethod.equalsIgnoreCase(REQUEST_TYPE_GET))
		{
			getMethod();
		}
		else
		{
			postMethod();
		}
		return responseString;
	}
	
	private void getMethod() throws SocketTimeoutException, IOException, Exception
	{
		try{
			
		URL = URL+queryString;
		absoluteURL = new URL(URL);
		urlConnection = absoluteURL.openConnection();
		 if(urlConnection instanceof HttpURLConnection)
		 {
			httpURLConnection = (HttpURLConnection)urlConnection;
			//add request header
			httpURLConnection.setRequestMethod(requestMethod);
			if(connectionTimeout != null && connectionTimeout != HostConstants.EMPTY) httpURLConnection.setConnectTimeout(Integer.parseInt(connectionTimeout));
			if(readTimeout != null && readTimeout != HostConstants.EMPTY) httpURLConnection.setReadTimeout(Integer.parseInt(readTimeout));
			if(userAgent!= null && !userAgent.equalsIgnoreCase(HostConstants.EMPTY)) httpURLConnection.setRequestProperty("User-Agent", userAgent);
			logger.debug("Sending GET Request");
			logger.debug("HTTP URL Connnection response code : " +httpURLConnection.getResponseCode());
			
			in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			
			String line = null;
			responseString = new StringBuffer();
			
			while((line = in.readLine()) != null)
			{
				responseString.append(line);
			}
			
			in.close();
			
			logger.debug("Response String : " +responseString);
		 }
		 else
		 {
			 logger.debug("Other than HTTP URL, Hence request not sent");
		 }
		 
		}
		finally
		{
			URL = null;
			queryString = null;
			requestMethod = null;
			userAgent = null;
			logger = null;
			absoluteURL = null;
			
			if(urlConnection!=null)((HttpURLConnection) urlConnection).disconnect();
			if(httpURLConnection!=null)httpURLConnection.disconnect();
			if(in!= null) in.close();
			urlConnection = null;
			httpURLConnection = null;
			in = null;
			
		}
	}
	
	private void postMethod() throws SocketTimeoutException, IOException, Exception
	{

		try{
		absoluteURL = new URL(URL);
		urlConnection = absoluteURL.openConnection();
		
		if(urlConnection instanceof HttpURLConnection)
		{
			httpURLConnection = (HttpURLConnection) urlConnection;
			//add request header
			httpURLConnection.setRequestMethod(HostConstants.URL_REQUEST_METHOD_POST);
			if(connectionTimeout != null && connectionTimeout != HostConstants.EMPTY) httpURLConnection.setConnectTimeout(Integer.parseInt(connectionTimeout));
			if(readTimeout != null && readTimeout != HostConstants.EMPTY) httpURLConnection.setReadTimeout(Integer.parseInt(readTimeout));
			if(userAgent!= null && !userAgent.equalsIgnoreCase(HostConstants.EMPTY)) httpURLConnection.setRequestProperty("User-Agent", userAgent);
			
			// Send post request
			httpURLConnection.setDoOutput(true);
			writer = new OutputStreamWriter(httpURLConnection.getOutputStream());
			writer.append(queryString);
			writer.flush();
			writer.close();
			
			int connectionResponseCode = httpURLConnection.getResponseCode();
			logger.debug("Connection Response Code : " +connectionResponseCode);
			
			in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			
			String line;
			responseString = new StringBuffer();
			
			while ((line = in.readLine()) != null) {
				responseString.append(line);
			}
			
			in.close();
			
			logger.debug("Response String : " +responseString);
		}
		else
		{
			logger.debug("Other than HTTP URL, Hence request not sent");
		}
		}
		finally{
			
			URL = null;
			queryString = null;
			requestMethod = null;
			userAgent = null;
			logger = null;
			absoluteURL = null;
			
			if(urlConnection!=null)((HttpURLConnection) urlConnection).disconnect();
			if(httpURLConnection!=null)httpURLConnection.disconnect();
			if(writer != null) writer.close();
			if(in != null) in.close();
			urlConnection  = null;
			httpURLConnection = null;
			writer = null;
			in = null;
		}
	}
}
