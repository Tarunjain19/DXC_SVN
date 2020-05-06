package com.rcom.broadband;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.bb.model.ServiceUpdateInfo;
import com.servion.util.AppProperties;

public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(Constants.LOGGER_NAME_LOADLEVEL);
	String appNames = Constants.EMPTY;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
	Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
	ServiceUpdateInfo objServiceUpdateInfo =null;
	Set<String> keys = null;
	String sleepTime = Constants.EMPTY;
	 @Override
	    public void run()
	    {
		 	while(true){
		 	appNames = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APP_NAME);
		 	
			DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
			
			/*** Thread Sleep  ***/
	           try {
	           sleepTime = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.DB_HIT_INTERVAL);
		           try {
					if(!Constants.N.equalsIgnoreCase(sleepTime)){
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
	    	   
	    	   appNames = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APP_NAME);
	    	   
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
		   			
		   			/**Check Hot Flash Status**/
		   		   try{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.HOTFLASH);
			   			if(objServiceUpdateInfo!=null){
				   			if(Constants.HOTFLASH.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					Constants.ENABLED.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("HOT FLASH UPDATED");
				   				objDBLoadOnStartUp.loadHotFlashMessage(localAppName);
				   				logger.debug("UPDATED HOT FLASH Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.HOTFLASH);
				   			}else{
				   				logger.debug("HOT FLASH NOT UPDATED");
				   			}
			   			}else{
			   				logger.debug("HOT FLASH OBJECT IS NULL");
			   			}
		   			}catch(Exception e){
		   			   logger.error("Exception in Hot Flash Updation :"+e);
		    		   StackTrace.GlobalPrintException(e);
		   			}
		   		   
		   		/***Check SMS Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.SMS);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.SMS.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.ENABLED.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("SMS DETAIL UPDATED");
			   				objDBLoadOnStartUp.loadPushSMSText(localAppName);
			   				logger.debug("UPDATED SMS DETAIL Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.SMS);
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
