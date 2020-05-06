package com.servion.postpaid.utils;

import java.text.DecimalFormat;

public  class TrimDecimal {

	public TrimDecimal() {
	}
	
	public static String trimDecimal (String deciString)
	{
	
	try
	{
		
	if(deciString.contains("."))
			{
			double d=Double.parseDouble(deciString);
		
			System.out.println("Original Decimal value is "+d);
		
			DecimalFormat df = new DecimalFormat("0");
			deciString = df.format(d);
			}
	}
	catch(Exception e)
	{
		PrintStackTrace.PrintException(e);
	}
	return deciString;
						
	}
}
