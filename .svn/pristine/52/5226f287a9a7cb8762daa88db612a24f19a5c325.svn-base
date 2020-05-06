package com.rcom.rdtv.util;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;
import com.servion.util.AppProperties;



public class UpdateBlockBuster {
	Logger logger = Logger.getLogger(AppConstants.LOGGER_NAME);
	String appNames = AppConstants.EMPTY_STRING;
	DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
	static int dayOfMonth = AppConstants.Zero,dayOfMonth2 = AppConstants.Zero;
	public void updateOfferCode() {
		
		try
		{
		Timer timer = new Timer();
		
		TimerTask tt = new TimerTask(){
			public void run(){
				System.out.println(Calendar.getInstance().getTime());
				Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), because it is desperated.
				int hour = cal.get(Calendar.HOUR_OF_DAY);//get the hour number of the day, from 0 to 23
				if(hour >= 1){
					logger.debug("BBMovies Offer Code Updation Time  :: "+Calendar.getInstance().getTime());
					objDBLoadOnStartUp.loadBBMoviesMessage(AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.APP_NAME));
				}
			}
		};
		timer.schedule(tt, 1000*5, 1000*60*60*24);//	delay the task 5 second, and then run task every 24 Hours
	}catch (Exception e) {
		 logger.error("Exception in Periodic Checker Updation :"+e);
		   StackTrace.PrintException(e);
	}
		finally
		{
			objDBLoadOnStartUp = null;
		}
	}
	
	public static void main(String[] args) {
		
		//this is the method you should use, not the Date(), because it is desperated.
		try
		{
		Timer timer = new Timer();
		
		TimerTask tt = new TimerTask(){
			public void run(){
				 Calendar cal = Calendar.getInstance();
		dayOfMonth = cal.get(Calendar.SECOND);
		System.out.println("DOM :: "+dayOfMonth);
		System.out.println("DOM2 :: "+dayOfMonth2);
		if(dayOfMonth2 != dayOfMonth)
		{
			dayOfMonth2 = dayOfMonth;
			System.out.println("Success");
			
		}
		else
			System.out.println("Fails");
			}
			};
			timer.schedule(tt, 1000*5, 1000*5);//	delay the task 5 second, and then run task every 24 Hours
		}catch (Exception e) {
			
			   StackTrace.PrintException(e);
		}
	}
}
