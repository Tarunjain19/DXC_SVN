package com.rcom.broadband;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Utilities {

	private static long last = 0;
	private static final long LIMIT = 10000000000L;
	public static String convertDateFormat(String date, String currentFormat, String returnFormat)
	{
		String returnDate = null;;
		
		try{
		
		SimpleDateFormat currformat = new SimpleDateFormat(currentFormat);
		SimpleDateFormat retFormat = new SimpleDateFormat(returnFormat);
		Date date1 = currformat.parse(date);
		returnDate = retFormat.format(date1);
		
		
		}catch(Exception e)
		{
			StackTrace.PrintException(e);
		}
		return returnDate;
	}
	
	public static String getComplaintRegistrationCaseID()
	{
		
		  // 10 digits.
		  long id = System.currentTimeMillis() % LIMIT;
		  if ( id <= last ) {
		    id = (last + 1) % LIMIT;
		  }
		  last = id;
		  
		  return String.valueOf(last);
		
	}
	
	public static void main(String[] args)
	{
		//System.out.println(convertDateFormat("27-03-2014", "DD-MM-yyyy", "yyyyMMdd"));
		
		
		//System.out.println(isValidExpiryDate("1111"));
		
		String[] str = "abc".split("\\|");
		
		System.out.println(str.length);
		
		//System.out.println(mmyyList);
		//System.out.println(mmyyList.size());
		
		System.out.println(Utilities.getComplaintRegistrationCaseID());
	}
	
	public static String getPossibleExpiryDateValues()
	{
		int month  = 0;
		int year = 0;
		SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		System.out.println(month = Calendar.getInstance().get(Calendar.MONTH)+1+1);
		System.out.println(year = Integer.parseInt(yearFormat.format(Calendar.getInstance().getTime())));
		
		ArrayList<String> currentYearMonthList = new ArrayList<String>();
		ArrayList<String> monthList = new ArrayList<String>();
		ArrayList<String> yearList = new ArrayList<String>();
		ArrayList<String> mmyyList = new ArrayList<String>();
		
		for(int i = month ; i<=12 ; i++ )
		{
			currentYearMonthList.add(String.valueOf(i));
		}
		
		for(int i = 1 ; i<=12 ; i++ )
		{
			monthList.add(String.valueOf(i));
		}
		
		System.out.println(monthList);
		
		for(int j = year+1 ; j<=99 ; j++)
		{
			yearList.add(String.valueOf(j));
		}
		
		System.out.println(yearList);
		
		for(String mm : currentYearMonthList)
		{
			if(mm.length()==1) mm = '0'+mm;
			mmyyList.add(mm+year);
		}
		
		for(String mm : monthList)
		{
			if(mm.length()==1) mm = '0'+mm;
			for(String yy : yearList)
			{
				mmyyList.add(mm+yy);
			}
		}
		
		String out = "";
		
		for(String str : mmyyList)
		{
			out = out +str + ",";
		}
		
		if(out.endsWith(","))
		{
			out = out.substring(0, out.length()-1);
		}
		
		return out;
	}
	
	public static boolean isValidExpiryDate(String date)
	{
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		int year = Integer.parseInt(yearFormat.format(Calendar.getInstance().getTime()));
		
		boolean regex = date.matches("(?:0[1-9]|1[0=2])[0-9]{2}");
		boolean yy = Integer.parseInt(date.substring(2))>=year ? true:false;
		boolean mm = Integer.parseInt(date.substring(0, 2))>(Calendar.getInstance().get(Calendar.MONTH)+1) ? true : false;
		
		return(regex && yy && mm);
	}
	
}
