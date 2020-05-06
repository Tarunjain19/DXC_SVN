package com.rcom.rdtv.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.avaya.sce.runtimecommon.ITraceInfo;


public class SayItSmartTime {
	
	public String playTime(ITraceInfo trace, String strData)
	{		
		
		String playcurrency = AppConstants.EMPTY_STRING;
		String hours = AppConstants.Hours;
		String minutes = AppConstants.Minutes;
		String fillerWave = AppConstants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Given :"+strData);
			
			if(strData!=null && !AppConstants.EMPTY_STRING.equals(strData)){
				
				String[] arrayData = strData.split("\\:");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Hour :"+arrayData[0]);
				int hour = Integer.parseInt(arrayData[0]);
				if(hour!=0){
					playcurrency = AppConstants.SS+arrayData[0]+AppConstants.number;
					
					if(hour==1){
						playcurrency = playcurrency+AppConstants._Star+hours;
					}else{
						playcurrency = playcurrency+AppConstants._Star+hours;
					}
				}
				if(arrayData.length>1){
					int minute = Integer.parseInt(arrayData[1]);
					if(minute!=0 && hour!=0){
						playcurrency =  playcurrency+AppConstants._Star+fillerWave+AppConstants._Star+AppConstants.SS+minute+AppConstants.number+AppConstants._Star+minutes;
					}else if(minute!=0){
						playcurrency =AppConstants.SS+minute+AppConstants.number+AppConstants._Star+minutes;
					}else if(hour == 0 && minute == 0){
						playcurrency =AppConstants.SS+hour+AppConstants.number+AppConstants._Star+hours;
					}
				}
			}else{
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time is given Empty");
			}
			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Returned :"+playcurrency);
		}catch(Exception e){
			StackTrace.PrintException(e);
		}
		return playcurrency;
	}
	
	
	public static void main(String[] args) {
		/*SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMMdd");
		Date dstartDate;
		try {
			dstartDate = sdFormat.parse("31072007");
			String e = sdFormat2.format(dstartDate);
		} catch (ParseException e1) {
			//  Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		/*SayItSmartTime obj = new SayItSmartTime();
		try {
			System.out.println(obj.changeddMMyyyyDateFormat("31072010"));
		} catch (ParseException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println(accountDetailsDateFormat());
	}
	
	public static String changeddMMyyyyDateFormat(String date) throws ParseException
	{
		SimpleDateFormat sdFormat = new SimpleDateFormat("dd-MMM-yy");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMMdd");
		Date startDate;
		startDate = sdFormat.parse(date);
		return sdFormat2.format(startDate);
	}
	
	public static int checkLockingPeriod(String packDate) throws ParseException
	{
		DateFormat df=new SimpleDateFormat("dd-MMM-yy");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Date date2 = new Date();
		date = df.parse(packDate);
		return (date.compareTo(date2));
	}
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public static XMLGregorianCalendar accountDetailsDateFormat() 
	{
		/*Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-mm-dd");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("hh:mm:ss");
		return sdFormat.format(cal.getTime())+AppConstants.T+sdFormat2.format(cal.getTime())+AppConstants.Z;*/
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
			
			
		} catch (DatatypeConfigurationException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}
		return xmlDate2;
		
	}
}
