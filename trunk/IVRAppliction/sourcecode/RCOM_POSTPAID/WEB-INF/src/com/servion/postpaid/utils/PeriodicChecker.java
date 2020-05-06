package com.servion.postpaid.utils;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.postpaid.model.ServiceUpdateInfo;
import com.servion.util.AppProperties;

public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(Constants.LOGGER_NAME);
	String appNames = Constants.EMPTY_STRING;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
	Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
	ServiceUpdateInfo objServiceUpdateInfo =null;
	Set<String> keys = null;
	String sleepTime = Constants.EMPTY_STRING;
	 @Override
	    public void run()
	    {
		 	while(true){
		 	appNames = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APPLICATION_NAMES);
		 	
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
					PrintStackTrace.PrintStartUpException(logger, e);
				}
	    	   System.out.println(Thread.currentThread().getName());
	    	   
	    	   appNames = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APPLICATION_NAMES);
	    	   
	    	   /*** Service Updation***/ 
	    	   try{
	    		   objAppServiceUpdateInfo=objDBLoadOnStartUp.CheckAdminStatus(appNames);
	    	   }catch(Exception e){
	    		   logger.error("Exception in Service Updation :"+e);
	    		   PrintStackTrace.PrintStartUpException(logger, e);
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
				   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
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
		    		   PrintStackTrace.PrintStartUpException(logger, e);
		   			}
		   			
		   			/**Check Data Offer Status**/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.DATAOFFER);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.DATAOFFER.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("DATA OFFER UPDATED");
			   				objDBLoadOnStartUp.loadDataOffer(localAppName);
			   				logger.debug("UPDATED DATA OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.DATAOFFER);
			   			}else{
			   				logger.debug("DATA OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("DATA OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			   logger.error("Exception in Data offer Updation :"+e);
		   			   PrintStackTrace.PrintStartUpException(logger, e);
		   		   }
		   		   
		   			/***Check Voice Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.VOICEOFFER);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.VOICEOFFER.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("VOICE OFFER UPDATED");
			   				objDBLoadOnStartUp.loadVoiceOffer(localAppName);
			   				logger.debug("UPDATED VOICE OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.VOICEOFFER);
			   			}else{
			   				logger.debug("VOICE OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("VOICE OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			   logger.error("Exception in Voice offer Updation :"+e);
		   			   PrintStackTrace.PrintStartUpException(logger, e);
		   		   }
		   		   
		   			/***Check VAS Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.VAS);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.VAS.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("VAS OFFER UPDATED");
			   				objDBLoadOnStartUp.loadVASDetails(localAppName);
			   				logger.debug("UPDATED VAS OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.VAS);
			   			}else{
			   				logger.debug("VAS OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("VAS OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			  logger.error("Exception in Voice offer Updation :"+e);
		   			   PrintStackTrace.PrintStartUpException(logger, e);
		   		   }
		   		   
		   		   /***Check Intellegent Layer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.IntelligentLayer);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.IntelligentLayer.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("Intelligent Layer DETAIL UPDATED");
			   				objDBLoadOnStartUp.loadIntelligentLayer(localAppName);
			   				logger.debug("UPDATED Intelligent Layer DETAIL Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.IntelligentLayer);
			   			}else{
			   				logger.debug("Intelligent Layer NOT UPDATED");
			   				
			   			}
		   			}else{
		   				logger.debug("Intelligent Layer OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			logger.error("Exception in Intelligent Layer Updation :"+e);
		   			 PrintStackTrace.PrintStartUpException(logger, e);
		   		   }
		   		   
		   		 
		   		   /***Check SMS Detail***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(Constants.SMS);
		   			if(objServiceUpdateInfo!=null){
			   			if(Constants.SMS.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					Constants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("SMS DETAIL UPDATED");
			   				objDBLoadOnStartUp.loadPushSMSDetails(localAppName);
			   				logger.debug("UPDATED SMS DETAIL Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, Constants.SMS);
			   			}else{
			   				logger.debug("SMS DETAIL NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("SMS OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			logger.error("Exception in Intelligent Layer Updation :"+e);
		   			 PrintStackTrace.PrintStartUpException(logger, e);
		   		   }
		   		   
	    		  }
		   		   
	    	   }
	    	   else{
			    	 logger.debug("Service Updation Map is null");
			   }
	    	   System.out.println(Calendar.getInstance().getTime());
	    
				
			} catch (Exception e) {
				PrintStackTrace.PrintStartUpException(logger, e);
			}
	     }
	   }
}
