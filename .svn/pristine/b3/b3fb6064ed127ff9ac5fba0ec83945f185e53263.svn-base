package com.servion.util;

import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.ppp.model.ServiceUpdateInfo;

public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(AppConstant.LOGGER_NAME);
	String appNames = AppConstant.EMPTY_STRING;
	String prepaidAppName = AppConstant.EMPTY_STRING;
	String postpaidAppName = AppConstant.EMPTY_STRING;
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
		 	prepaidAppName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.PREPAID_APPLICATION_NAME);
		 	postpaidAppName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.POSTPAID_APPLICATION_NAME);
		 	
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
	    		   objAppServiceUpdateInfo=objDBLoadOnStartUp.CheckAdminStatus(appNames+AppConstant.SEPERATOR_COMMA+prepaidAppName+AppConstant.SEPERATOR_COMMA+postpaidAppName);
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
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstant.HOTFLASH);
			   			if(objServiceUpdateInfo!=null){
				   			if(AppConstant.HOTFLASH.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					AppConstant.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("HOT FLASH UPDATED");
				   				objDBLoadOnStartUp.loadHotFlashMessage(localAppName);
				   				logger.debug("UPDATED HOT FLASH Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstant.HOTFLASH);
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
		   			
		   			/**Check Data Offer Status**/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstant.DATAOFFER);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstant.DATAOFFER.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstant.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("DATA OFFER UPDATED");
			   				objDBLoadOnStartUp.loadDataOffer(localAppName);
			   				logger.debug("UPDATED DATA OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstant.DATAOFFER);
			   			}else{
			   				logger.debug("DATA OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("DATA OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			   logger.error("Exception in Data offer Updation :"+e);
		   			   StackTrace.GlobalPrintException(e);
		   		   }
		   		   
		   			/***Check Voice Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstant.VOICEOFFER);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstant.VOICEOFFER.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstant.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("VOICE OFFER UPDATED");
			   				objDBLoadOnStartUp.loadVoiceOffer(localAppName);
			   				logger.debug("UPDATED VOICE OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstant.VOICEOFFER);
			   			}else{
			   				logger.debug("VOICE OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("VOICE OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			   logger.error("Exception in Voice offer Updation :"+e);
		   			   StackTrace.GlobalPrintException(e);
		   		   }
		   		   
		   			/***Check VAS Offer ***/
		   		   try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstant.VAS);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstant.VAS.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstant.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("VAS OFFER UPDATED");
			   				objDBLoadOnStartUp.loadVASDetails(localAppName);
			   				logger.debug("UPDATED VAS OFFER Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstant.VAS);
			   			}else{
			   				logger.debug("VAS OFFER NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("VAS OFFER OBJECT IS NULL");
		   			}
		   		   }catch(Exception e){
		   			  logger.error("Exception in Voice offer Updation :"+e);
		   			   StackTrace.GlobalPrintException(e);
		   		   }
		   		   
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
