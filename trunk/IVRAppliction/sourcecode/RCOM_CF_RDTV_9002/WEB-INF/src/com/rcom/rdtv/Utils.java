package com.rcom.rdtv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;



public class Utils {
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public static XMLGregorianCalendar parseDate(){
		XMLGregorianCalendar xmlDate2 = null;
		try {

		Date dob=null;
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		dob=df.parse( dateFormat.format(date) );
		GregorianCalendar cal = new GregorianCalendar();

		cal.setTime(dob);

		xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(),dob.getMinutes(),dob.getSeconds(),DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();

		} catch (Exception e) {


			StackTrace.PrintException(e);

		}

		return xmlDate2;

	}
public String getLastTenDigits(String ani){
		
		String strAni =  "";
		
		//getting only the last 10 numbers from the caller id if > 10
		if(ani.length() > 10){
			
			//eg:       cli = 0 0 9 1 9 9 0 1 6 9 8  1  0  4
			//				  | | | | | | | | | | |  |  |  |  
			//   Java Index = 0 1 2 3 4 5 6 7 8 9 10 11 12 13
			//length of cli = 14, 14 - 10 = 4, 4 is the starting index of phone number.
			strAni = ani.substring(ani.length() - 10);
			
		} else if(ani.length() == 10)  {
			
			strAni = ani;
		}
		
		return strAni;
	}
	
}
