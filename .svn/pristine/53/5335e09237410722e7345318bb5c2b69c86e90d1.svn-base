package com.dnd.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class Utilities {
	
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
	
}

