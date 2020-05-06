package com.rcom.metro;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utilities {

	
	private static final String DATE_FORMAT = "dd-MM-yyyy";
	private static final String DAY_FORMAT = "EEEE";
	
	public static boolean isBusinessHour(String[] holidays, String[] workingDaysOfWeek, String startTime, String endTime)
	{
		
		Calendar todaysCal = Calendar.getInstance();
		
		//Holidays Check
		boolean isHoliday = false;
		if(holidays != null && holidays.length != 0)
		{
			SimpleDateFormat formatDate = new SimpleDateFormat(DATE_FORMAT);
			String todaysDate = formatDate.format(todaysCal.getTime());
			
			for(String holiday : holidays)
			{
				if(todaysDate.equalsIgnoreCase(holiday))
				{
					isHoliday = true;
				}
			}
		}
		
		//Working Days of Week Check
		boolean isWorkingDay = true;
		if(workingDaysOfWeek != null && workingDaysOfWeek.length != 0)
		{
			isWorkingDay=false;
			SimpleDateFormat formatDay = new SimpleDateFormat(DAY_FORMAT);
			String todaysDay = formatDay.format(todaysCal.getTime());
			
			for(String workingDay : workingDaysOfWeek)
			{
				if(todaysDay.equalsIgnoreCase(workingDay))
				{
					isWorkingDay = true;
					break;
				}
			}
		}
		
		
		//Start Time and End Time Check
		boolean isWorkingTime = true;
		if(startTime != null && !startTime.equalsIgnoreCase("") && endTime != null && !endTime.equalsIgnoreCase(""))
		{
			isWorkingTime=false;
			int todaysHour = todaysCal.get(Calendar.HOUR_OF_DAY);
			int todaysMinute = todaysCal.get(Calendar.MINUTE);
			
			int startTimeTotalMinutes = Integer.parseInt(startTime.split(":")[0])*60 + Integer.parseInt(startTime.split(":")[1]);
			int endTimeTotalMinutes = Integer.parseInt(endTime.split(":")[0])*60 + Integer.parseInt(endTime.split(":")[1]);
			int currentTimeTotalMinutes = todaysHour*60 + todaysMinute;

			if(currentTimeTotalMinutes >= startTimeTotalMinutes && currentTimeTotalMinutes <= endTimeTotalMinutes)
			{
				isWorkingTime = true;
			}
		}
		
		if(!isHoliday && isWorkingDay && isWorkingTime)
			return true;
		else return false;
		
	}
	
	
}
