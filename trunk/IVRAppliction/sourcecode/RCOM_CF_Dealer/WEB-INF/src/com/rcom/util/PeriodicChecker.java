package com.rcom.util;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.otherflows.model.ServiceUpdateInfo;
import com.servion.util.AppProperties;

public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(AppConstant.LOGGER_NAME);
	String appNames = AppConstant.EMPTY_STRING;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
	Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
	ServiceUpdateInfo objServiceUpdateInfo =null;
	Set<String> keys = null;
	String sleepTime = AppConstant.EMPTY_STRING;
	 @Override
	    public void run()
	    {
		 	while(true){
		 	appNames = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.APPLICATION_NAMES);
		 	
			DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
			
			/*** Thread Sleep  ***/
	           try {
	           sleepTime = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.DB_HIT_INTERVAL);
		           try {
					if(!AppConstant.N.equalsIgnoreCase(sleepTime)){
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
	    	   
	    	   appNames = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.APPLICATION_NAMES);
	    	   
	    	   /*** Service Updation***/ 
	    	   try{
	    		   objAppServiceUpdateInfo=objDBLoadOnStartUp.CheckAdminStatus(appNames);
	    	   }catch(Exception e){
	    		   logger.error("Exception in Service Updation :"+e);
	    		   StackTrace.GlobalPrintException(e);
	    	   }
	    	   
	    	   if(objAppServiceUpdateInfo!=null){
	    	   
	    		  keys = objAppServiceUpdateInfo.keySet();
	    		  for(String localAppName: keys){
		   			logger.debug("Application Name :"+localAppName);
		   			logger.debug("Service Update Info Map value :"+objAppServiceUpdateInfo.get(localAppName));
		   			
		   			objProductServiceUpdateInfo = objAppServiceUpdateInfo.get(localAppName);
		   			
		   			  		    			
		   			
		   			
		   		   
		   		/***Check SMS Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstant.SMS);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstant.SMS.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstant.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("SMS DETAIL UPDATED");
			   				objDBLoadOnStartUp.loadPushSMSText(localAppName);
			   				logger.debug("UPDATED SMS DETAIL Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstant.SMS);
			   			}else{
			   				logger.debug("SMS DETAIL NOT UPDATED");
			   				
			   			}
		   			}else{
		   				logger.debug("SMS DETAIL OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			logger.error("Exception in stv Updation :"+e);
		   			 StackTrace.GlobalPrintException(e);
		   		   }
		   		   
	    		  }
		   		   
	    	   }
	    	   else{
			    	 logger.debug("Service Updation Map is null");
			   }
	    	   System.out.println(Calendar.getInstance().getTime());
	    
				
			} catch (Exception e) {
				StackTrace.GlobalPrintException(e);
			}
	     }
	   }
}

