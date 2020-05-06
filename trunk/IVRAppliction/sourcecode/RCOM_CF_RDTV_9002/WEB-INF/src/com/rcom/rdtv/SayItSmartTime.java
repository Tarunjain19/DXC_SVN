package com.rcom.rdtv;


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
		
		String playcurrency =Constants.EMPTY_STRING;
		String hours =Constants.Hours;
		String minutes = Constants.Minutes;
		String fillerWave = Constants.Filler;
		
		try{

			trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Time Given :"+strData);
			
			if(strData!=null && !Constants.EMPTY_STRING.equals(strData)){
				
				String[] arrayData = strData.split("\\:");
				trace.writeln(ITraceInfo.TRACE_LEVEL_DEBUG,"Hour :"+arrayData[0]);
				int hour = Integer.parseInt(arrayData[0]);
				if(hour!=0){
					playcurrency = Constants.SS+arrayData[0]+Constants.number;
					
					if(hour==1){
						playcurrency = playcurrency+Constants._Star+hours;
					}else{
						playcurrency = playcurrency+Constants._Star+hours;
					}
				}
				if(arrayData.length>1){
					int minute = Integer.parseInt(arrayData[1]);
					if(minute!=0 && hour!=0){
						playcurrency =  playcurrency+Constants._Star+fillerWave+Constants._Star+Constants.SS+minute+Constants.number+Constants._Star+minutes;
					}else if(minute!=0){
						playcurrency =Constants.SS+minute+Constants.number+Constants._Star+minutes;
					}else if(hour == 0 && minute == 0){
						playcurrency =Constants.SS+hour+Constants.number+Constants._Star+hours;
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
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public static XMLGregorianCalendar accountDetailsDateFormat()
	{
		XMLGregorianCalendar xmlDate2 = null;
		
		try{
			Date dob = null;
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			dob = df.parse(dateFormat.format(date));
			GregorianCalendar cal = new GregorianCalendar();
			
			cal.setTime(dob);
			
			xmlDate2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), dob.getHours(), dob.getMinutes(), dob.getSeconds(), DatatypeConstants.FIELD_UNDEFINED, cal.getTimeZone().LONG).normalize();
			
			
		}catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}catch(ParseException e){
			e.printStackTrace();
		}
		return xmlDate2;
	}
	public static void main(String[] args) {
		
		System.out.println(accountDetailsDateFormat());
		
		/*SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat sdFormat2 = new SimpleDateFormat("yyyyMMdd");
		Date dstartDate;
		try {
			dstartDate = sdFormat.parse("31072007");
			String e = sdFormat2.format(dstartDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
