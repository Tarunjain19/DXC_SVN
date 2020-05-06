package com.hp.utilities;

import com.hp.utilities.TVP_Properties;

import com.hp.utilities.IVRConstants;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import com.avaya.sce.runtime.tracking.TraceInfo;
import com.avaya.sce.runtimecommon.ITraceInfo;
import com.avaya.sce.runtimecommon.IVariable;
import com.avaya.sce.runtimecommon.IVariableField;
import com.avaya.sce.runtimecommon.SCESession;

import flow.IProjectVariables;
import org.apache.log4j.Logger;

public class TVP_Utilities {

	public static boolean logEnabled = true;
	
	
	
	public static String getChannelLoggerImplementation(SCESession mySession, String channelNo)
	{

		Properties prop = new Properties();
		FileInputStream fileInputStream = null;
		String projectPath = mySession.getAbsoluteProjectFilePath();
		String logImplForChannel = null;

		try
		{
			fileInputStream = new FileInputStream(projectPath + "/data/ddlog4j.properties");
			prop.load(fileInputStream);
			logImplForChannel = prop.getProperty("log4j.logger.Channel."+channelNo);
			if (logImplForChannel == null || logImplForChannel.isEmpty())
			{
				//System.out.println("00000-");
				channelNo = "0"; 
			}
		}
		catch(Exception e)
		{
			//logCustomError("Caught exception :: "+ e, "Utilities file", mySession);

		}

		return channelNo;
	}
	
	public String getDateTime() {
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
        
       	return df.format(curDate);		
	}

public String getCurrentTime(String timeformat)
{
	SimpleDateFormat df = new SimpleDateFormat(timeformat);

    java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
    
   	return df.format(curDate);	
}
	public boolean check4WorkingHour(String startTime,String endTime){

		int startTimeValue = Integer.parseInt(startTime.replace(":", "").trim());
		int endTimeValue  = Integer.parseInt(endTime.replace(":", "").trim());

		Date currentDateTime = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmm");

		int currentTime = Integer.parseInt(sdf.format(currentDateTime));

		boolean isWorkingHour = (currentTime >= startTimeValue) && (currentTime <= endTimeValue);

		return isWorkingHour;
	}
	
	public String getLastTenDigits(String ani){
		
		String strAni =  IVRConstants.EMPTY_QUOTES;
		
		//getting only the last 10 numbers from the caller id if > 10
		if(ani.length() > IVRConstants.TEN){
			
			//eg:       cli = 0 0 9 1 9 9 0 1 6 9 8  1  0  4
			//				  | | | | | | | | | | |  |  |  |  
			//   Java Index = 0 1 2 3 4 5 6 7 8 9 10 11 12 13
			//length of cli = 14, 14 - 10 = 4, 4 is the starting index of phone number.
			strAni = ani.substring(ani.length() - IVRConstants.TEN);
			
		} else if(ani.length() == IVRConstants.TEN)  {
			
			strAni = ani;
		}
		
		return strAni;
	}
	

	
	public boolean isHoliday(SCESession mySession, String holiDays){
		
		String []holiDaysArray = new String[IVRConstants.TEN];
		
		boolean isWorkingHour = IVRConstants.FALSE;
		
		Calendar cal = Calendar.getInstance();
		
		int intDay = IVRConstants.ZERO;
		int intMonth = IVRConstants.ZERO;
		int currentDay = IVRConstants.ZERO;
		int currentMonth = IVRConstants.ZERO;							
		int dayofWeek = IVRConstants.ZERO;
		
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#holidays:"+ holiDays, mySession);
				
		dayofWeek = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#dayofWeek:"+ dayofWeek, mySession);
		
		//if(dayofWeek > 1 && dayofWeek <7) { // Checking for Sunday & Saturday
			
		//checking for holiday eg; 1:26|8:15|10:2
		if(holiDays.length() > 0) {
			
			holiDaysArray = holiDays.split(IVRConstants.COMMA);						
			
			String []strMonth_Day =  new String[IVRConstants.THREE];
			currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;// since range starts from 0
			currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			
			for(int count =0; count < holiDaysArray.length; count++) {
				
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#holiDaysArray[count]:"+ holiDaysArray[count], mySession);
				if(holiDaysArray[count].isEmpty()) {
					
					isWorkingHour = true; //This is the last entry and setting to true
					break;
				}else {
					strMonth_Day =  holiDaysArray[count].split(IVRConstants.COLON);
					
					intMonth = Integer.parseInt(strMonth_Day[0].trim());
					intDay = Integer.parseInt(strMonth_Day[1].trim());
													
					if((currentMonth == intMonth)&&(currentDay == intDay)) {
						
						TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#Holiday found. Setting isWorkingHours to false", mySession);
						isWorkingHour = false; //One of the holiday matches hence setting false
						break;
					} else {
						
						TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#Setting isWorkingHours to true", mySession);
						isWorkingHour = true;
					}
				}							
			}
			
			//Setting the for holiday true or false in OD variable
			//mySession.getVariableField(IProjectVariables.VAR_ACTIVE_CALL, IProjectVariables.VAR_ACTIVE_CALL_FIELD_IS_PUBLIC_HOLIDAY).setValue(isWorkingHour);
		} else {
		
		TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#Holiday list is empty.", mySession);
		}

		return isWorkingHour;
	}
	
	public boolean isWorkingHours(SCESession mySession, String workingHours){
		
		String []workingHoursArray = new String[IVRConstants.THREE];
		String []startTime = new String[IVRConstants.THREE];
		String []endTime = new String[IVRConstants.THREE];				
		
		boolean isWorkingHour = IVRConstants.FALSE;
		
		Calendar cal = Calendar.getInstance();
		
		int startHour = IVRConstants.ZERO;
		int startMinute = IVRConstants.ZERO;
		int endHour = IVRConstants.ZERO;
		int endMinute = IVRConstants.ZERO;
		int currentHour = IVRConstants.ZERO;
		int currentMinute = IVRConstants.ZERO;	
		
		// working hourse eg: 8:00 - 18:00
		if(workingHours.length() > 0) {
			
			workingHoursArray = workingHours.split("-");// This will give the two times start and end times
			startTime = workingHoursArray[0].split(":");// This will give the start hour and start minute
			endTime = workingHoursArray[1].split(":");// This will give the end hour and end minute
			
			startHour = Integer.parseInt(startTime[0].trim());
			startMinute = Integer.parseInt(startTime[1].trim());
			
			endHour = Integer.parseInt(endTime[0].trim());
			endMinute = Integer.parseInt(endTime[1].trim());
								
			currentHour = cal.get(Calendar.HOUR);
			currentMinute = cal.get(Calendar.MINUTE);
									
			if(cal.get(Calendar.AM_PM)!= 0){
				currentHour += 12;
			}									
			
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#cal.get(Calendar.AM_PM):"+ cal.get(Calendar.AM_PM), mySession );
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#startHour:"+ startHour, mySession);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#startMinute:"+startMinute, mySession);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#endHour:"+endHour, mySession);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#endMinute:"+endMinute, mySession);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#currentHour"+currentHour, mySession);
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#currentMinute"+currentMinute, mySession);

			
			if((currentHour > startHour) && (currentHour < endHour)) {
				
				isWorkingHour = true;
			} else if(currentHour == startHour){
				if(currentMinute >= startMinute){
					isWorkingHour = true;
				}
			}else if(currentHour == endHour) {
				if(currentMinute <= endMinute){
					isWorkingHour = true;
				}
			}else {
				
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "#Time:Setting isWorkingHours to false", mySession);
				isWorkingHour = false;
			}											
		}
		
		return isWorkingHour;
	}
	
	public int getNumberOfDays(String date, SCESession mySession) {
		
		int year = IVRConstants.ZERO;
		int month = IVRConstants.ZERO;
		int day = IVRConstants.ZERO;
		int cur_year = Calendar.getInstance().get(Calendar.YEAR);
		int cur_month = Calendar.getInstance().get(Calendar.MONTH);
		int cur_day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int difference = IVRConstants.ZERO;
		
		try{
			
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "Date="+ date , mySession);
			
			if(date.length() == 28){
				// Sample EID original 2007/99920/07400 10/02/2013 12:09:34
				// 1218122220006520101031152044
				
				
				year = Integer.parseInt(date.substring(14, 18));
				month = Integer.parseInt(date.substring(18, 20));
				day = Integer.parseInt(date.substring(20, 22));
				
				Calendar calEID = new GregorianCalendar();
		        Calendar calToday = new GregorianCalendar();    
		        calEID.set(year, month, day); // Setting enrollment date
		        calToday.set(cur_year, cur_month, cur_day);
		        
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "EID Year=" + year + " Month="+ month + " Day=" + day , mySession);
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "Today Year=" + cur_year + " Month="+ cur_month+ " Day=" + cur_day , mySession);
				
				
				//Calculating the number of days
				Date d1 = calEID.getTime();
				Date d2 = calToday.getTime();
				
				difference = (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
				
				TraceInfo.trace(ITraceInfo.TRACE_LEVEL_DEBUG, "Difference="+ difference , mySession);
				
				return difference;
				//Calendar.
			}
			
			
		}catch(Exception e){
			
			TraceInfo.trace(ITraceInfo.TRACE_LEVEL_ERROR, "Error in calculating the No of days in getNumberOfDays =" + e.getMessage(), mySession);
			
			return -1; // Indicating error occured.
		}
                
		return 0;
	}
	
	public String getTimeDiff (SCESession mySession,String timeFormat)
	{
		System.out.println();
		String curTime=this.getCurrentTime(timeFormat);
		String updateTime=mySession.getVariableField(IProjectVariables.TIBCO__VALIDATION__RES,IProjectVariables.TIBCO__VALIDATION__RES_FIELD_UPDATE_DATE).getStringValue();
	
		Date d1 = null;
		Date d2 = null;
		SimpleDateFormat format = new SimpleDateFormat(timeFormat);
		try {
			d1 = format.parse(updateTime);
			d2 = format.parse(curTime);

			//in milliseconds
			long diff = d2.getTime() - d1.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			long diffDays = diff / (24 * 60 * 60 * 1000);

			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
			System.out.print(diffSeconds + " seconds.");
			return (diffDays+"_"+diffHours+"_"+diffMinutes+"_"+diffSeconds);

		} catch (Exception e) {
			e.printStackTrace();
		
		return null;
		}

	
	
	}
	public  String Right(String s, int length)
    {
		int interval=0;
    if (s.length() > length)
    {
    	interval=s.length()-length;
    	System.out.println("length:" +s.length());
        return s.substring(interval,s.length() );
    }
    else
    {
        return s;
    }
    }
    
    public String getCurrentDate(String format)
    {
    		SimpleDateFormat df = new SimpleDateFormat(format);
    		Date d=new Date();
    		
         //  java.util.Date curDate = new java.util.Date(System.currentTimeMillis());
            
           	return df.format(d);		
    	}
    public static String generateUniqueID() throws Exception{
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat fromFormat = new SimpleDateFormat("HHmmssSSS");
        String vdatestr = fromFormat.format(c1.getTime());
        return vdatestr;
    } 
    public static String getToday(String format)
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		
		Calendar cal = Calendar.getInstance();
		Date todaysDate = cal.getTime();
		String timeStamp = dateFormat.format(todaysDate);
		
		return timeStamp;
	}

}	
		
	
	
