package com.rcom.rdtv.util;



import java.util.Calendar;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.otherflows.model.ServiceUpdateInfo;
import com.servion.util.AppProperties;

public class PeriodicChecker extends Thread{
	Logger logger = Logger.getLogger(AppConstants.LOGGER_NAME);
	String appNames = AppConstants.EMPTY_STRING;
	String offerCodeHitEndTime = AppConstants.EMPTY_STRING;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objAppServiceUpdateInfo= null;
	Hashtable<String,ServiceUpdateInfo> objProductServiceUpdateInfo=null;
	ServiceUpdateInfo objServiceUpdateInfo =null;
	Set<String> keys = null;
	String sleepTime = AppConstants.EMPTY_STRING;
	boolean offerCodeFlag = false;
	static int dayOfMonth = AppConstants.Zero,dayOfMonth2 = AppConstants.Zero;
	 @Override
	    public void run()
	    {
		 	while(true){
		 	offerCodeFlag = false;
		 	appNames = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.APP_NAME);
		 	offerCodeHitEndTime  = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.OFFERCODE_HIT_ENDTIME);
			DBLoadOnStartUp objDBLoadOnStartUp = DBLoadOnStartUp.getInstance();
			Calendar cal = Calendar.getInstance();
			dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
			/*** Thread Sleep  ***/
	           try {
	           sleepTime = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.DB_HIT_INTERVAL);
		           try {
					if(!AppConstants.N.equalsIgnoreCase(sleepTime)){
						   int intSleepTime = Integer.parseInt(sleepTime);
						   Thread.sleep(intSleepTime);
					   }else{
						   Thread.sleep(5000);
					   }
				} catch (Exception e) {
					Thread.sleep(5000);
					StackTrace.PrintException(e);
				}
	    	   System.out.println(Thread.currentThread().getName());
	    	   
	    	   appNames = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.APP_NAME);
	    	   
	    	   /*** Service Updation***/
	    	   try{
	    		   objAppServiceUpdateInfo=objDBLoadOnStartUp.CheckAdminStatus(appNames);
	    	   }catch(Exception e){
	    		   logger.error("Exception in Service Updation :"+e);
	    		   StackTrace.PrintException(e);
	    	   }
	    	   
	    	   if(objAppServiceUpdateInfo!=null){
	    	   
	    		  keys = objAppServiceUpdateInfo.keySet();
	    		  for(String localAppName: keys){
		   			logger.debug("Application Name :"+localAppName);
		   			logger.debug("Service Update Info Map value :"+objAppServiceUpdateInfo.get(localAppName));
		   			
		   			objProductServiceUpdateInfo = objAppServiceUpdateInfo.get(localAppName);
		   			
		   			/**Check Hot Flash Status**/
		   		   try{
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
		   			}catch(Exception e){
		   			   logger.error("Exception in Hot Flash Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/**Check Base Pack Status**/
		   		   try{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.BasePack);
			   			if(objServiceUpdateInfo!=null){
				   			if(AppConstants.BasePack.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("BASE PACK UPDATED");
				   				objDBLoadOnStartUp.loadBasePacksInfo(localAppName);
				   				logger.debug("UPDATED BASE PACK Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.BasePack);
				   			}else{
				   				logger.debug("BASE PACK NOT UPDATED");
				   			}
			   			}else{
			   				logger.debug("BASE PACK OBJECT IS NULL");
			   			}
		   			}catch(Exception e){
		   			   logger.error("Exception in Base Pack Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/**Check Block Buster Status**/
		   		   try{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.BlockBuster);
			   			if(objServiceUpdateInfo!=null){
				   			if(AppConstants.BlockBuster.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("BlockBuster UPDATED");
				   				objDBLoadOnStartUp.loadBBMoviesMessage(localAppName);
				   				logger.debug("UPDATED BlockBuster Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.BlockBuster);
				   				offerCodeFlag = true;
				   				}else{
				   				logger.debug("BlockBuster NOT UPDATED");
				   			}
			   			}else{
			   				logger.debug("BlockBuster OBJECT IS NULL");
			   			}
		   			}catch(Exception e){
		   			   logger.error("Exception in BlockBuster Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/**Check Block Buster OfferCode Check Status**/
		   		   try{
		   			 //this is the method you should use, not the Date(), because it is desperated.
					int hour = cal.get(Calendar.HOUR_OF_DAY);
					/*if(AppConstants.Zero<= hour && hour <= Integer.parseInt(offerCodeHitEndTime) && offerCodeFlag !=true)*/
					if(dayOfMonth2 != dayOfMonth && offerCodeFlag !=true)
					{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.BlockBuster);
			   			if(objServiceUpdateInfo!=null){
				   			
				   				logger.debug("BlockBuster OfferCode UPDATED");
				   				objDBLoadOnStartUp.loadBBMoviesMessage(localAppName);
				   				logger.debug("UPDATED BlockBuster OfferCode Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.BlockBuster);
				   				dayOfMonth2 = dayOfMonth;
				   				
			   			}else{
			   				logger.debug("BlockBuster OBJECT IS NULL");
			   			}
		   		   }
		   			}catch(Exception e){
		   			   logger.error("Exception in BlockBuster OfferCode Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/**Check TopupPack Status**/
		   		   try{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.TopupPack);
			   			if(objServiceUpdateInfo!=null){
				   			if(AppConstants.TopupPack.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("TopupPack UPDATED");
				   				objDBLoadOnStartUp.loadTopUpMainCategoryMessage(localAppName);
				   				logger.debug("UPDATED TopupPack Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.TopupPack);
				   			}else{
				   				logger.debug("TopupPack NOT UPDATED");
				   			}
			   			}else{
			   				logger.debug("TopupPack OBJECT IS NULL");
			   			}
		   			}catch(Exception e){
		   			   logger.error("Exception in TopupPack Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/**Check PackInfo Status**/
		   		   try{
			   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.PackInfo);
			   			if(objServiceUpdateInfo!=null){
				   			if(AppConstants.PackInfo.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
				   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
				   				logger.debug("PackInfo UPDATED");
				   				//objDBLoadOnStartUp.loadPackInfoMovieMessage(localAppName);
				   				objDBLoadOnStartUp.loadPackInfoVASMessage(localAppName);
				   				logger.debug("UPDATED PackInfo Flag");
				   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.PackInfo);
				   			}else{
				   				logger.debug("PackInfo NOT UPDATED");
				   			}
			   			}else{
			   				logger.debug("PackInfo OBJECT IS NULL");
			   			}
		   			}catch(Exception e){
		   			   logger.error("Exception in PackInfo Updation :"+e);
		    		   StackTrace.PrintException(e);
		   			}
		   		   
		   		/*   *//** Check CancelPack Status**//*
		   		try{
		   			objServiceUpdateInfo = objProductServiceUpdateInfo.get(AppConstants.CancelPack);
		   			if(objServiceUpdateInfo!=null){
			   			if(AppConstants.CancelPack.equalsIgnoreCase(objServiceUpdateInfo.getServiceName())&&
			   					AppConstants.Y.equalsIgnoreCase(objServiceUpdateInfo.getStatus())){
			   				logger.debug("CancelPack UPDATED");
			   				objDBLoadOnStartUp.loadCancelPacksInfo(localAppName);
			   				logger.debug("UPDATED CancelPack Flag");
			   				objDBLoadOnStartUp.UpdateAdminStatus(localAppName, AppConstants.CancelPack);
			   			}else{
			   				logger.debug("CancelPack NOT UPDATED");
			   			}
		   			}else{
		   				logger.debug("CancelPack OBJECT IS NULL");
		   			}
	   			}catch(Exception e){
	   			   logger.error("Exception in CancelPack Updation :"+e);
	    		   StackTrace.PrintException(e);
	   			}*/
		   		
		   		
	    		  }
	    	   }
	           
		 	}catch(Exception e){
	   			   logger.error("Exception in Periodic Checker Updation :"+e);
	    		   StackTrace.PrintException(e);
	    }
	           
	           
}
	    }
}
	           

