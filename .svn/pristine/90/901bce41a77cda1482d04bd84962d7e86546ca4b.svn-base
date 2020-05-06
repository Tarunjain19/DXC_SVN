package com.rcom.util;

import java.text.DecimalFormat;

public class Adjust2Decimal {

	public Adjust2Decimal() {
	
	}

	public String adjustDecimal (String strDecimal2)
	{
		
		try
		{
			
		if(strDecimal2.contains("."))
				{
				double d=Double.parseDouble(strDecimal2);
			
				System.out.println("Original Decimal value is "+d);
			
				DecimalFormat df = new DecimalFormat("0.00");
				strDecimal2 = df.format(d);
				}
		}
		catch(Exception e)
		{
			StackTrace.PrintException(e);
		}
		return strDecimal2;
							
	}
	
}
