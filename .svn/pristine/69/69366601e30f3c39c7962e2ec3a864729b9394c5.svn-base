package com.rcom.util;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.ppp.model.ServiceUpdateInfo;
import com.servion.util.AppProperties;



public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(AppConstants.LOGGER_NAME);
	String appNames = AppConstants.EMPTY_STRING;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
	Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
	ServiceUpdateInfo objServiceUpdateInfo =null;
	Set<String> keys = null;
	String sleepTime = AppConstants.EMPTY_STRING;
	 @Override
	    public void run()
	    {
		 	for(;;){
		 	appNames = AppProperties.GetInstance(AppConstants.IVR_CONFIG).getIVRProp(AppConstants.APP_NAME);
			DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
        	   try {
    	           sleepTime = AppProperties.GetInstance(AppConstants.IVR_CONFIG).getIVRProp(AppConstants.DB_HIT_INTERVAL);
    		           try {
    					if(!AppConstants.N.equalsIgnoreCase(sleepTime)){
    						   int intSleepTime = Integer.parseInt(sleepTime);
    						   Thread.sleep(intSleepTime);
    					   }else{
    						   Thread.sleep(5000);
    					   }
    				} catch (Exception e) {
    					Thread.sleep(5000);
    					StackTrace.GlobalPrintException(e);
    			}
   
	    	   System.out.println(Thread.currentThread().getName());
	    	   appNames = AppProperties.GetInstance(AppConstants.IVR_CONFIG).getIVRProp(AppConstants.APP_NAME);
	    	   objAppServiceUpdateInfo=objDBLoadOnStartUp.CheckAdminStatus(appNames);
	    	   
	    	   if(objAppServiceUpdateInfo!=null){
	    	   
	    		  keys = objAppServiceUpdateInfo.keySet();
	    		  for(String localAppName: keys){
		   			logger.debug("Application Name :"+localAppName);
		   			logger.debug("Service Update Info Map value :"+objAppServiceUpdateInfo.get(localAppName));
		   			
		   			objProductServiceUpdateInfo = objAppServiceUpdateInfo.get(localAppName);
		   			
		   			/**Check Hot Flash Status**/
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.HOTFLASH);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstants.HOTFLASH.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("HOT FLASH UPDATED");
			   				objDBLoadOnStartUp.loadHotFlashMessage(localAppName);
			   				logger.debug("UPDATED HOT FLASH Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.HOTFLASH);
			   			}else{
			   				logger.debug("HOT FLASH NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("HOT FLASH OBJECT IS NULL");
		   			}
	
	    		  }
	    	   }
	    	   else{
			    	 logger.debug("Service Updation Map is null");
			   }
	    	   System.out.println(Calendar.getInstance().getTime());
	    
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	}
}

