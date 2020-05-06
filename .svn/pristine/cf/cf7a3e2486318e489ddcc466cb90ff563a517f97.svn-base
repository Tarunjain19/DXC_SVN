package com.servion.hsd.utils;

public class TrimDecimal {

	public TrimDecimal() {
	}
	
	public String trimDecimal (String deciString)
	{
		try
		{
			if(deciString!=null && deciString.contains("."))
			{
				int p =deciString.indexOf(".");
				deciString=deciString.substring(0,p);
			}
		}
		catch (Exception e)
		{
			StackTrace.PrintException(e);
		}
		
		return deciString;
	}

}
