package com.rcom.rdtv.util;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.otherflows.model.BBMoviesInfo;
import com.rcom.otherflows.model.BasePacks;
import com.rcom.otherflows.model.GetTopUpMainCategory;
import com.rcom.otherflows.model.GetTopUpSubCatagory;
import com.rcom.otherflows.model.HotFlashInfo;
import com.rcom.otherflows.model.PackInfoVAS;
import com.rcom.otherflows.model.PushSMSInfo;
import com.rcom.otherflows.model.ServiceUpdateInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.servion.util.AppProperties;



public class DBLoadOnStartUp {
	Logger logger =Logger.getLogger(AppConstants.LOGGER_NAME);
	private static DBLoadOnStartUp objDBLoadOnStartUp = null;
	private DBLoadOnStartUp (){

	}
	public void loadHotFlashMessage (String appName){
		
		logger.debug("<---Loading Hot Flash Message--->");
		/** Declaration**/
		HotFlashInfo inputObjHotFlashInfo = null;
		Hashtable<String, Hashtable<String, HotFlashInfo>> objHotFlashInfo = null;
		String hotFlashKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		inputObjHotFlashInfo = new HotFlashInfo();
		inputObjHotFlashInfo.setAppName(appName);
		
		
		/**DB Call**/
		objHotFlashInfo=IVRDBServiceInstance.getIVRDBInstance().getHotFlashInfo(logger,inputObjHotFlashInfo);
		
		if(objHotFlashInfo!=null){
			logger.debug("Hot Flash DB Details :"+objHotFlashInfo.values());
			keys = objHotFlashInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Hot Flash Map value :"+objHotFlashInfo.get(key));
				
				hotFlashKey = AppConstants.HOTFLASH_KEY+key;
				logger.debug("Hot Flash Key :"+hotFlashKey);
				
				AppDataMap.getInstance(key).setAppData(hotFlashKey, objHotFlashInfo.get(key));
				logger.debug("Hot Flash Value :"+AppDataMap.getInstance(key).getAppData(hotFlashKey));
			}
		  }
		}catch(Exception e){
			logger.error("Exception in HotFlash :"+e);
			StackTrace.PrintException(e);
		}finally{
			inputObjHotFlashInfo = null;
			hotFlashKey = null;
			keys = null;
		}	
	}
		
		public void loadBasePacksInfo (String appName){
			
			logger.debug("<---Loading BasePacks Message--->");
			/** Declaration**/
			BasePacks basePacks = null;
			Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, BasePacks>>>>> basePacksList = null;
			String basePackKey = null;
			Set<String> keys = null;
			
			/**Assign**/
			try{
			logger.debug("Application Names :"+appName);
			basePacks = new BasePacks();
			basePacks.setApplicationName(appName);
			
			
			/**DB Call**/
			basePacksList=IVRDBServiceInstance.getIVRDBInstance().getBasePacks(logger, basePacks);
			
			if(basePacksList!=null){
				logger.debug("BasePacks DB Details :"+basePacksList.values());
				keys = basePacksList.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("BasePacks Map value :"+basePacksList.get(key));
					
					basePackKey = AppConstants.BASEPACKS_KEY+key;
					logger.debug("BasePacks Key :"+basePackKey);
					
					AppDataMap.getInstance(key).setAppData(basePackKey, basePacksList.get(key));
					logger.debug("BasePacks Value :"+AppDataMap.getInstance(key).getAppData(basePackKey));
				}
			  }
			}catch(Exception e){
				logger.error("Exception in BasePacks :"+e);
				StackTrace.PrintException(e);
			}finally{
				basePacksList = null;basePackKey = null;keys = null;basePacks=null;
			}
	}

/*public void loadCancelPacksInfo (String appName){
			
			logger.debug("<---Loading CancelPacks Message--->");
			*//** Declaration**//*
			CancelPackInfo cancelPackInfo = null;
			Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, CancelPackInfo>>>> cancelPackInfoList = null;
			String cancelPackKey = null;
			Set<String> keys = null;
			
			*//**Assign**//*
			try{
			logger.debug("Application Names :"+appName);
			cancelPackInfo = new CancelPackInfo();
			cancelPackInfo.setAppName(appName);
			
			
			*//**DB Call**//*
			cancelPackInfoList=IVRDBServiceInstance.getIVRDBInstance().queryCancelPackInfo(logger, cancelPackInfo);
			
			if(cancelPackInfoList!=null){
				logger.debug("CancelPacks DB Details :"+cancelPackInfoList.values());
				keys = cancelPackInfoList.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("CancelPacks Map value :"+cancelPackInfoList.get(key));
					
					cancelPackKey = AppConstants.CANCELPACKS_KEY+key;
					logger.debug("CancelPacks Key :"+cancelPackKey);
					
					AppDataMap.getInstance(key).setAppData(cancelPackKey, cancelPackInfoList.get(key));
					logger.debug("CancelPacks Value :"+AppDataMap.getInstance(key).getAppData(cancelPackKey));
				}
			  }
			}catch(Exception e){
				logger.error("Exception in BasePacks :"+e);
				StackTrace.PrintException(e);
			}finally{
				cancelPackInfoList = null;cancelPackKey = null;keys = null;cancelPackInfo=null;
			}
			
	}*/
		
		/*public void loadPackInfoMessage (String appName)
		{
			logger.debug("<---Loading PackInfo Message--->");
			*//** Declaration**//*
			PackInfoVAS packInfoVAS = null;
			Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>> bBMoviesInfoList = null;
			String bBMoviesKey = null;
			Set<String> keys = null;
		}*/

		public void loadBBMoviesMessage (String appName){
			
			logger.debug("<---Loading BBMovie Message--->");
			/** Declaration**/
			BBMoviesInfo bbMoviesInfo = null;
			Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, BBMoviesInfo>>>> bBMoviesInfoList = null;
			String bBMoviesKey = null;
			Set<String> keys = null;
			
			/**Assign**/
			try{
			logger.debug("Application Names :"+appName);
			bbMoviesInfo = new BBMoviesInfo();
			bbMoviesInfo.setAppName(appName);
			
			
			/**DB Call**/
			bBMoviesInfoList=IVRDBServiceInstance.getIVRDBInstance().getBBMoviesInfo(logger, bbMoviesInfo);
			
			if(bBMoviesInfoList!=null){
				logger.debug("BBMovies DB Details :"+bBMoviesInfoList.values());
				keys = bBMoviesInfoList.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("BBMovies Map value :"+bBMoviesInfoList.get(key));
					
					bBMoviesKey = AppConstants.BBMOVIES_KEY+key;
					logger.debug("BBMovies Key :"+bBMoviesKey);
					
					AppDataMap.getInstance(key).setAppData(bBMoviesKey, bBMoviesInfoList.get(key));
					logger.debug("BBMovies Value :"+AppDataMap.getInstance(key).getAppData(bBMoviesKey));
				}
			  }
			}catch(Exception e){
				logger.error("Exception in BBMovies :"+e);
				StackTrace.PrintException(e);
			}finally{
				bBMoviesInfoList = null;bBMoviesKey = null;keys = null;bbMoviesInfo=null;
			}
			
	}
		
public void loadPackInfoVASMessage (String appName){
			
			logger.debug("<---Loading PackInfoVAS Message--->");
			/** Declaration**/
			PackInfoVAS packInfoVAS = null;
			Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>>> packInfoVASList = null;
			String packInfoVASKey = null;
			Set<String> keys = null;
			
			/**Assign**/
			try{
			logger.debug("Application Names :"+appName);
			packInfoVAS = new PackInfoVAS();
			packInfoVAS.setApplicationName(appName);
			packInfoVAS.setPackType(AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.PACKINFO_VAS_KEY));
			
			/**DB Call**/
			packInfoVASList=IVRDBServiceInstance.getIVRDBInstance().queryPackInfoVAS(logger, packInfoVAS);
			
			if(packInfoVASList!=null){
				logger.debug("PackInfoVAS DB Details :"+packInfoVASList.values());
				keys = packInfoVASList.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("PackInfoVAS Map value :"+packInfoVASList.get(key));
					
					packInfoVASKey = AppConstants.PACKINFOVAS_KEY+key;
					logger.debug("PackInfoVAS Key :"+packInfoVASKey);
					
					AppDataMap.getInstance(key).setAppData(packInfoVASKey, packInfoVASList.get(key));
					logger.debug("PackInfoVAS Value :"+AppDataMap.getInstance(key).getAppData(packInfoVASKey));
				}
			  }
			}catch(Exception e){
				logger.error("Exception in PackInfoVAS :"+e);
				StackTrace.PrintException(e);
			}finally{
				packInfoVASList = null;packInfoVASKey = null;keys = null;packInfoVAS=null;
			}
			
	}
	

public void loadPackInfoMovieMessage (String appName){
	
	logger.debug("<---Loading PackInfoMovies Message--->");
	/** Declaration**/
	PackInfoVAS packInfoMovie = null;
	Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, PackInfoVAS>>>> packInfoMovieList = null;
	String packInfoMovieKey = null;
	Set<String> keys = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	packInfoMovie = new PackInfoVAS();
	packInfoMovie.setApplicationName(appName);
	packInfoMovie.setPackType(AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.PACKINFO_MOVIES_KEY));
	
	/**DB Call**/
	packInfoMovieList=IVRDBServiceInstance.getIVRDBInstance().queryPackInfoVAS(logger, packInfoMovie);
	
	if(packInfoMovieList!=null){
		logger.debug("PackInfoMovies DB Details :"+packInfoMovieList.values());
		keys = packInfoMovieList.keySet();
		
		for(String key: keys){
			logger.debug("Application Name :"+key);
			logger.debug("PackInfoMovies Map value :"+packInfoMovieList.get(key));
			
			packInfoMovieKey = AppConstants.PACKINFOMOVIES_KEY+key;
			logger.debug("PackInfoMovies Key :"+packInfoMovieKey);
			
			AppDataMap.getInstance(key).setAppData(packInfoMovieKey, packInfoMovieList.get(key));
			logger.debug("PackInfoMovies Value :"+AppDataMap.getInstance(key).getAppData(packInfoMovieKey));
		}
	  }
	}catch(Exception e){
		logger.error("Exception in PackInfoMovies :"+e);
		StackTrace.PrintException(e);
	}finally{
		packInfoMovieList = null;packInfoMovieKey = null;keys = null;packInfoMovie=null;
	}
	
}

public void loadPushSMSText (String appName){
	
	logger.debug("<---Loading PushSMSText Details--->");
	
	/** Declaration**/
	PushSMSInfo inputObjPushSMSInfo = null;
	Hashtable<String, Hashtable<String, PushSMSInfo>> objPushSMSInfo = null;
	String PushSMSInfoKey = null;
	Set<String> keys = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	inputObjPushSMSInfo = new PushSMSInfo();
	inputObjPushSMSInfo.setAppName(appName);
	
	/**DB Call**/
	objPushSMSInfo=IVRDBServiceInstance.getIVRDBInstance().getPushSMSInfo(logger,inputObjPushSMSInfo);
	
	if(objPushSMSInfo!=null){
		logger.debug("Push SMS Text Info Details :"+objPushSMSInfo.values());
		keys = objPushSMSInfo.keySet();
		
		for(String key: keys){
			logger.debug("Application Name :"+key);
			logger.debug("Push SMS Text Map value :"+objPushSMSInfo.get(key));
			
			PushSMSInfoKey = AppConstants.PUSH_SMS+key;
			logger.debug("Push SMS Text Info Key :"+PushSMSInfoKey);
			
			AppDataMap.getInstance(key).setAppData(PushSMSInfoKey, objPushSMSInfo.get(key));
			
		}
	}
}catch(Exception e){
	logger.error("Exception in Push SMS :"+e);
	StackTrace.PrintException(e);
}finally{
	inputObjPushSMSInfo = null;
	PushSMSInfoKey = null;
	keys = null;
}	
}

public void loadTopUpMainCategoryMessage (String appName){
	
	logger.debug("<---Loading TopUpMainCategory Message--->");
	/** Declaration**/
	GetTopUpMainCategory getTopUpMainCategory = null;
	Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, GetTopUpMainCategory>>>>> getTopUpMainList = null;
	String topUpMainKey = null;
	Set<String> keys = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	getTopUpMainCategory = new GetTopUpMainCategory();
	getTopUpMainCategory.setApplicationName(appName);
	
	
	/**DB Call**/
	getTopUpMainList=IVRDBServiceInstance.getIVRDBInstance().queryTopUpMainCategory(logger, getTopUpMainCategory);
	
	if(getTopUpMainList!=null){
		logger.debug("TopUpMainCategory DB Details :"+getTopUpMainList.values());
		keys = getTopUpMainList.keySet();
		
		for(String key: keys){
			logger.debug("Application Name :"+key);
			logger.debug("PackInfoMovies Map value :"+getTopUpMainList.get(key));
			
			topUpMainKey = AppConstants.TOPUP_MAINCATEGORY_KEY+key;
			logger.debug("TopUpMainCategory Key :"+topUpMainKey);
			
			AppDataMap.getInstance(key).setAppData(topUpMainKey, getTopUpMainList.get(key));
			logger.debug("TopUpMainCategory Value :"+AppDataMap.getInstance(key).getAppData(topUpMainKey));
		}
	  }
	}catch(Exception e){
		logger.error("Exception in TopUpMainCategory :"+e);
		StackTrace.PrintException(e);
	}finally{
		getTopUpMainList = null;topUpMainKey = null;keys = null;getTopUpMainCategory=null;
	}
	
}

public void loadTopUpSubCategoryMessage (String appName){
	
	logger.debug("<---Loading TopUpSubCategory Message--->");
	/** Declaration**/
	GetTopUpSubCatagory getTopUpSubCatagory = null;
	Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, Hashtable<String, GetTopUpSubCatagory>>>>> getTopUpSubList = null;
	String topUpMainKey = null;
	Set<String> keys = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	getTopUpSubCatagory = new GetTopUpSubCatagory();
	getTopUpSubCatagory.setApplicationName(appName);
	
	
	/**DB Call**/
	getTopUpSubList=IVRDBServiceInstance.getIVRDBInstance().queryTopUpSubCategory(logger, getTopUpSubCatagory);
	
	if(getTopUpSubList!=null){
		logger.debug("TopUpSubCategory DB Details :"+getTopUpSubList.values());
		keys = getTopUpSubList.keySet();
		
		for(String key: keys){
			logger.debug("Application Name :"+key);
			logger.debug("PackInfoMovies Map value :"+getTopUpSubList.get(key));
			
			topUpMainKey = AppConstants.TOPUP_SUBCATEGORY_KEY+key;
			logger.debug("TopUpSubCategory Key :"+topUpMainKey);
			
			AppDataMap.getInstance(key).setAppData(topUpMainKey, getTopUpSubList.get(key));
			logger.debug("TopUpSubCategory Value :"+AppDataMap.getInstance(key).getAppData(topUpMainKey));
		}
	  }
	}catch(Exception e){
		logger.error("Exception in TopUpSubCategory :"+e);
		StackTrace.PrintException(e);
	}finally{
		getTopUpSubCatagory = null;topUpMainKey = null;keys = null;getTopUpSubList=null;
	}
	
}

public Hashtable CheckAdminStatus (String appName){
	
	logger.debug("<---Check Admin Application Status--->");
	
	/** Declaration**/
	ServiceUpdateInfo inputObjServiceUpdateInfo = null;
	Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objServiceUpdateInfo= null;
	String ServiceUpdationKey = null;
	Set<String> keys = null;
	String ipAddress = AppConstants.EMPTY_STRING;
	InetAddress ip = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	
	ipAddress = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.IPAddress);
	
	if(AppConstants.N.equals(ipAddress)){
		logger.debug("IP address not configured in Property File:");	
		ip= InetAddress.getLocalHost();
		ipAddress = String.valueOf(ip);
	}
	
	logger.debug("IP address :" +ipAddress);
	inputObjServiceUpdateInfo = new ServiceUpdateInfo();
	inputObjServiceUpdateInfo.setAppName(appName);
	inputObjServiceUpdateInfo.setIPaddress(ipAddress);
	
	/**DB Call**/
	objServiceUpdateInfo=IVRDBServiceInstance.getIVRDBInstance().getServiceUpdateInfo(logger, inputObjServiceUpdateInfo);
	
	if(objServiceUpdateInfo!=null){
		logger.debug("Service Update Info Details :"+objServiceUpdateInfo.values());
		keys = objServiceUpdateInfo.keySet();
		for(String key: keys){
			logger.debug("Application Name :"+key);
			logger.debug("Service Update Info Map value :"+objServiceUpdateInfo.get(key));
		}
	  }
	}catch(Exception e){
		logger.error("Exception in HotFlash :"+e);
		StackTrace.PrintException(e);
	}finally{
		inputObjServiceUpdateInfo = null;
		ServiceUpdationKey = null;
		keys = null;
	}	
	return objServiceUpdateInfo;
}

public void UpdateAdminStatus (String appName,String serviceName){
	
	logger.debug("<---Check Admin Application Status--->");
	
	/** Declaration**/
	ServiceUpdateInfo ObjServiceUpdateInfo = null;
	String ServiceUpdationKey = null;
	Set<String> keys = null;
	String ipAddress = AppConstants.EMPTY_STRING;
	InetAddress ip = null;
	
	/**Assign**/
	try{
	logger.debug("Application Names :"+appName);
	
	ipAddress = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.IPAddress);
	
	if(AppConstants.N.equals(ipAddress)){
		logger.debug("IP address not configured in Property File:");	
		ip= InetAddress.getLocalHost();
		ipAddress = String.valueOf(ip);
		
	}
	
	logger.debug("IP address :" +ipAddress);
	ObjServiceUpdateInfo = new ServiceUpdateInfo();
	ObjServiceUpdateInfo.setAppName(appName);
	ObjServiceUpdateInfo.setIPaddress(ipAddress);
	ObjServiceUpdateInfo.setFlag(AppConstants.N);
	ObjServiceUpdateInfo.setStatus(AppConstants.N);
	ObjServiceUpdateInfo.setServiceName(serviceName);
	
	/**DB Call**/
	ObjServiceUpdateInfo=IVRDBServiceInstance.getIVRDBInstance().updateServiceUpdateInfo(logger,ObjServiceUpdateInfo);
	
	if(ObjServiceUpdateInfo!=null){
		logger.debug("Service Update Status :"+ObjServiceUpdateInfo.getStatus());
	}
	
	}catch(Exception e){
		logger.error("Exception in HotFlash :"+e);
		StackTrace.PrintException(e);
	}finally{
		ObjServiceUpdateInfo = null;
		ServiceUpdationKey = null;
		keys = null;
	}	
}
		public static DBLoadOnStartUp getInstance(){
			 if(objDBLoadOnStartUp!=null)
				return objDBLoadOnStartUp;
			 else{
				 objDBLoadOnStartUp = new DBLoadOnStartUp();
				 return objDBLoadOnStartUp;
			 }
			}
	
	
	
	
	
}
