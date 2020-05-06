package com.hpe.util;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.ppp.model.CircleOffersInfo;
import com.rcom.ppp.model.HotFlashInfo;
import com.rcom.ppp.model.IVRVasInfo;
import com.rcom.ppp.model.PushSMSInfo;
import com.rcom.ppp.model.ServiceUpdateInfo;
import com.rcom.ppp.resource.IVRDBServiceInstance;
import com.servion.util.AppProperties;


public class DBLoadOnStartUp {
	Logger logger =Logger.getLogger(AppConstant.LOGGER_NAME);
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
		objHotFlashInfo=IVRDBServiceInstance.getInstance().getHotFlashInfo(logger,inputObjHotFlashInfo);
		
		if(objHotFlashInfo!=null){
			logger.debug("Hot Flash DB Details :"+objHotFlashInfo.values());
			keys = objHotFlashInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Hot Flash Map value :"+objHotFlashInfo.get(key));
				
				hotFlashKey = AppConstant.HOTFLASH_KEY+key;
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

	public void loadVoiceOffer (String appName){
		
		logger.debug("<---Loading Voice Offer--->");
		
		/** Declaration**/
		CircleOffersInfo inputObjCircleOffersInfo = null;
		Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> objCircleOffersInfo = null;
		String VoiceOfferKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		inputObjCircleOffersInfo = new CircleOffersInfo();
		inputObjCircleOffersInfo.setAppName(appName);
		inputObjCircleOffersInfo.setOfferType(AppConstant.VOICE_OFFER);
		
		/**DB Call**/
		objCircleOffersInfo=IVRDBServiceInstance.getInstance().getCircleOffers(logger,inputObjCircleOffersInfo);
		
		if(objCircleOffersInfo!=null){
			logger.debug("Circle Voice Offers Details :"+objCircleOffersInfo.values());
			keys = objCircleOffersInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Circle Voice Offers Map value :"+objCircleOffersInfo.get(key));
				
				VoiceOfferKey = AppConstant.VOICEOFFER_KEY+key;
				logger.debug("Circle Voice Offers Key :"+VoiceOfferKey);
				
				AppDataMap.getInstance(key).setAppData(VoiceOfferKey, objCircleOffersInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in Voice Offer :"+e);
			StackTrace.PrintException(e);
		}finally{
			inputObjCircleOffersInfo = null;
			VoiceOfferKey = null;
			keys = null;
		}	
	}
	
	public void loadDataOffer (String appName){
		
		logger.debug("<---Loading Data Offer--->");
		
		/** Declaration**/
		CircleOffersInfo inputObjCircleOffersInfo = null;
		Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> objCircleOffersInfo = null;
		String DataOfferKey = null;
		Set<String> keys = null;
		
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		inputObjCircleOffersInfo = new CircleOffersInfo();
		inputObjCircleOffersInfo.setAppName(appName);
		inputObjCircleOffersInfo.setOfferType(AppConstant.DATA_OFFER);
		
		/**DB Call**/
		objCircleOffersInfo=IVRDBServiceInstance.getInstance().getCircleOffers(logger,inputObjCircleOffersInfo);
		
		if(objCircleOffersInfo!=null){
			logger.debug("Circle Data Offers Details :"+objCircleOffersInfo.values());
			keys = objCircleOffersInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Circle Data Offers Map value :"+objCircleOffersInfo.get(key));
				
				DataOfferKey = AppConstant.DATAOFFER_KEY+key;
				logger.debug("Circle Data Offers Key :"+DataOfferKey);
				
				AppDataMap.getInstance(key).setAppData(DataOfferKey, objCircleOffersInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in Data Offer :"+e);
			StackTrace.PrintException(e);
		}finally{
			inputObjCircleOffersInfo = null;
			DataOfferKey = null;
			keys = null;
		}	
	}
	
	
	public void loadVASDetails (String appName){
		
		logger.debug("<---Loading VAS Details--->");
		
		/** Declaration**/
		IVRVasInfo objIVRVasInfo = null;
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> objCompleteVASInfo = null;
		
		String VASInfoKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		objIVRVasInfo = new IVRVasInfo();
		objIVRVasInfo.setAppName(appName);
		
		/**DB Call**/
		objCompleteVASInfo=IVRDBServiceInstance.getInstance().getVASDetails(logger,objIVRVasInfo);
		
		if(objCompleteVASInfo!=null){
			logger.debug("VAS Info Details :"+objCompleteVASInfo.values());
			keys = objCompleteVASInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("VAS Info Map value :"+objCompleteVASInfo.get(key));
				
				VASInfoKey = AppConstant.VAS_KEY+key;
				logger.debug("VAS Info Key :"+VASInfoKey);
				
				AppDataMap.getInstance(key).setAppData(VASInfoKey, objCompleteVASInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in VAS :"+e);
			StackTrace.PrintException(e);
		}finally{
			objIVRVasInfo = null;
			VASInfoKey = null;
			keys = null;
		}	
	}

	public Hashtable CheckAdminStatus (String appName){
	
		logger.debug("<---Check Admin Application Status--->");
		
		/** Declaration**/
		ServiceUpdateInfo inputObjServiceUpdateInfo = null;
		Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objServiceUpdateInfo= null;
		String ServiceUpdationKey = null;
		Set<String> keys = null;
		String ipAddress = AppConstant.EMPTY_STRING;
		InetAddress ip = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		
		ipAddress = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.IPAddress);
		
		if(AppConstant.N.equals(ipAddress)){
			logger.debug("IP address not configured in Property File:");	
			ip= InetAddress.getLocalHost();
			ipAddress = String.valueOf(ip);
		}
		
		logger.debug("IP address :" +ipAddress);
		
		inputObjServiceUpdateInfo = new ServiceUpdateInfo();
		inputObjServiceUpdateInfo.setAppName(appName);
		inputObjServiceUpdateInfo.setIPaddress(ipAddress);
		
		/**DB Call**/
		objServiceUpdateInfo=IVRDBServiceInstance.getInstance().getServiceUpdationInfo(logger,inputObjServiceUpdateInfo);
		
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
		String ipAddress = AppConstant.EMPTY_STRING;
		InetAddress ip = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		
		ipAddress = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.IPAddress);
		
		if(AppConstant.N.equals(ipAddress)){
			logger.debug("IP address not configured in Property File:");	
			ip= InetAddress.getLocalHost();
			ipAddress = String.valueOf(ip);
			
		}
		
		logger.debug("IP address :" +ipAddress);
		
		ObjServiceUpdateInfo = new ServiceUpdateInfo();
		ObjServiceUpdateInfo.setAppName(appName);
		ObjServiceUpdateInfo.setIPaddress(ipAddress);
		ObjServiceUpdateInfo.setFlag(AppConstant.N);
		ObjServiceUpdateInfo.setStatus(AppConstant.N);
		ObjServiceUpdateInfo.setServiceName(serviceName);
		
		/**DB Call**/
		ObjServiceUpdateInfo=IVRDBServiceInstance.getInstance().updateServiceUpdationInfo(logger,ObjServiceUpdateInfo);
		
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
			objPushSMSInfo=IVRDBServiceInstance.getInstance().getPushSMSInfo(logger,inputObjPushSMSInfo);
			
			if(objPushSMSInfo!=null){
				logger.debug("Push SMS Text Info Details :"+objPushSMSInfo.values());
				keys = objPushSMSInfo.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("Push SMS Text Map value :"+objPushSMSInfo.get(key));
					
					PushSMSInfoKey = AppConstant.PUSH_SMS+key;
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
		
	
	public static DBLoadOnStartUp getInstance(){
	 if(objDBLoadOnStartUp!=null)
		return objDBLoadOnStartUp;
	 else{
		 objDBLoadOnStartUp = new DBLoadOnStartUp();
		 return objDBLoadOnStartUp;
	 }
	}
}