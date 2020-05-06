package com.servion.rcom.hostinterface.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class QueryString {
	
	private String query = HostConstants.EMPTY;
	private static String ENCODE_FORMAT = "UTF-8";
	private static String EQUAL_TO = "=";

	public QueryString(String name, String value) throws UnsupportedEncodingException
	{
		encode(name, value);
	}
	
	public void add(String name, String value) throws UnsupportedEncodingException
	{
		query += "&";
		encode(name, value);
	}
	
	private void encode(String name, String value) throws UnsupportedEncodingException
	{
		query += URLEncoder.encode(name, ENCODE_FORMAT);
		query += EQUAL_TO;
		query += URLEncoder.encode(value, ENCODE_FORMAT);
	}
	
	public String getQuery()
	{
		return query;
	}
	
	@Override
	public String toString() {
		return getQuery();
	}

}
