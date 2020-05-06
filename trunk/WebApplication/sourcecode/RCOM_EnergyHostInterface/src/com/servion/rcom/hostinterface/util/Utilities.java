package com.servion.rcom.hostinterface.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class Utilities {

	
	public static void printStackTrace(Logger logger, String sessionId, Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error(sessionId+"Error occured in : ", e);
		}finally {
			sw.flush();
			pw.close();
			sw = null;
			pw = null;
		}
	}
	
	public static String getTimeStamp(Logger logger, String format)
	{
		String timeStamp = null;
		try{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			
			Calendar cal = Calendar.getInstance();
			Date todaysDate = cal.getTime();
			timeStamp = dateFormat.format(todaysDate);
			
		}catch(Exception e) {
			logger.error("Error occured in : ", e);
		}
		return timeStamp;
	}
	
	public static String generateUniqueID() throws Exception{
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat fromFormat = new SimpleDateFormat("HHmmssSSS");
        String vdatestr = fromFormat.format(c1.getTime());
        return vdatestr;
    }
	
	public static String adjustDecimal (Logger logger,String strDecimal2)
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
                  logger.error("Error occured in : ", e);
           }
           return strDecimal2;
    }
}
