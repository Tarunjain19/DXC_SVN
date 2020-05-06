package com.servion.triplefive.utils;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.hni.model.CircleOffersInfo;
import com.rcom.hni.model.HotFlashInfo;
import com.rcom.hni.model.IVRVasInfo;
import com.rcom.hni.model.IntelligentLayerInfo;
import com.rcom.hni.model.PushSMSInfo;
import com.rcom.hni.model.RechargePlanInfo;
import com.rcom.hni.model.ServiceUpdateInfo;
import com.rcom.hni.model.SpecialTariffInfo;
import com.rcom.hni.resource.IVRDBServiceInstance;
import com.servion.util.AppProperties;


public class DBLoadOnStartUp {
	Logger logger = Logger.getLogger(Constants.LOGGER_NAME_LOADLEVEL);
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
				
				hotFlashKey = Constants.HOTFLASH_KEY+key;
				logger.debug("Hot Flash Key :"+hotFlashKey);
				
				AppDataMap.getInstance(key).setAppData(hotFlashKey, objHotFlashInfo.get(key));
				
			}
		  }
		}catch(Exception e){
			logger.error("Exception in HotFlash :"+e);
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
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
		inputObjCircleOffersInfo.setOfferType(Constants.VOICE_OFFER);
		
		/**DB Call**/
		objCircleOffersInfo=IVRDBServiceInstance.getInstance().getCircleOffers(logger,inputObjCircleOffersInfo);
		
		if(objCircleOffersInfo!=null){
			logger.debug("Circle Voice Offers Details :"+objCircleOffersInfo.values());
			keys = objCircleOffersInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Circle Voice Offers Map value :"+objCircleOffersInfo.get(key));
				
				VoiceOfferKey = Constants.VOICEOFFER_KEY+key;
				logger.debug("Circle Voice Offers Key :"+VoiceOfferKey);
				
				AppDataMap.getInstance(key).setAppData(VoiceOfferKey, objCircleOffersInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in Voice Offer :"+e);
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
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
		inputObjCircleOffersInfo.setOfferType(Constants.DATA_OFFER);
		
		/**DB Call**/
		objCircleOffersInfo=IVRDBServiceInstance.getInstance().getCircleOffers(logger,inputObjCircleOffersInfo);
		
		if(objCircleOffersInfo!=null){
			logger.debug("Circle Data Offers Details :"+objCircleOffersInfo.values());
			keys = objCircleOffersInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Circle Data Offers Map value :"+objCircleOffersInfo.get(key));
				
				DataOfferKey = Constants.DATAOFFER_KEY+key;
				logger.debug("Circle Data Offers Key :"+DataOfferKey);
				
				AppDataMap.getInstance(key).setAppData(DataOfferKey, objCircleOffersInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in Data Offer :"+e);
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
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
				
				VASInfoKey = Constants.VAS_KEY+key;
				logger.debug("VAS Info Key :"+VASInfoKey);
				
				AppDataMap.getInstance(key).setAppData(VASInfoKey, objCompleteVASInfo.get(key));
				
			}
		}
		}catch(Exception e){
			logger.error("Exception in VAS :"+e);
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
		}finally{
			objIVRVasInfo = null;
			VASInfoKey = null;
			keys = null;
		}	
	}

	public void loadRechargeDetails (String appName){
		
		logger.debug("<---Loading Recharge Details--->");
		
		/** Declaration**/
		RechargePlanInfo inputObjRechargePlanInfo = null;
		Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> objRechargePlanInfo = null;
		String RechargePlanInfoKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		inputObjRechargePlanInfo = new RechargePlanInfo();
		inputObjRechargePlanInfo.setAppName(appName);
		
		/**DB Call**/
		objRechargePlanInfo=IVRDBServiceInstance.getInstance().getRechargePlan(logger,inputObjRechargePlanInfo);
		
		if(objRechargePlanInfo!=null){
			logger.debug("Recharge Plan Info Details :"+objRechargePlanInfo.values());
			keys = objRechargePlanInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Recharge Plan Info Map value :"+objRechargePlanInfo.get(key));
				
				RechargePlanInfoKey = Constants.RECHARGEDETAIL_KEY+key;
				logger.debug("Recharge Plan Info Key :"+RechargePlanInfoKey);
				
				AppDataMap.getInstance(key).setAppData(RechargePlanInfoKey, objRechargePlanInfo.get(key));
				
			}
		}}catch(Exception e){
			logger.error("Exception in Recharge :"+e);
			GlobalPrintStackTrace.PrintException(e);
		}finally{
			inputObjRechargePlanInfo = null;
			RechargePlanInfoKey = null;
			keys = null;
		}	
		
	}
	
	public void loadSTVDetails (String appName){
		
		logger.debug("<---Loading STV Details--->");
		
		/** Declaration**/
		SpecialTariffInfo inputObjSpecialTariffInfo = null;
		Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> objSpecialTariffInfo = null;
		String STVInfoKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		inputObjSpecialTariffInfo = new SpecialTariffInfo();
		inputObjSpecialTariffInfo.setAppName(appName);
		
		/**DB Call**/
		objSpecialTariffInfo=IVRDBServiceInstance.getInstance().getSpecialTarifInfo(logger,inputObjSpecialTariffInfo);
		
		if(objSpecialTariffInfo!=null){
			logger.debug("STV Plan Info Details :"+objSpecialTariffInfo.values());
			keys = objSpecialTariffInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("STV Plan Info Map value :"+objSpecialTariffInfo.get(key));
				
				STVInfoKey = Constants.STV_KEY+key;
				logger.debug("STV Plan Info Key :"+STVInfoKey);
				
				AppDataMap.getInstance(key).setAppData(STVInfoKey, objSpecialTariffInfo.get(key));
				
			}
		}
	}catch(Exception e){
		logger.error("Exception in STV :"+e);
		GlobalPrintStackTrace.PrintException(e);
	}finally{
		inputObjSpecialTariffInfo = null;
		STVInfoKey = null;
		keys = null;
	}	
}
	
	public void loadIntelligentLayer (String appName){

		
		logger.debug("<---Loading Intelligent Layer Details--->");
		
		/** Declaration**/
		IntelligentLayerInfo objIntelligentLayer = null;
		Hashtable<String, Hashtable<String, IntelligentLayerInfo>> objIntelligentLayerInfo = null;
		String IntelligentLayerKey = null;
		Set<String> keys = null;
		
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		objIntelligentLayer = new IntelligentLayerInfo();
		objIntelligentLayer.setAppName(appName);
		
		/**DB Call**/
		objIntelligentLayerInfo=IVRDBServiceInstance.getInstance().getIntelligentLayerActiveStatus(logger,objIntelligentLayer);
		
		if(objIntelligentLayerInfo!=null){
			logger.debug("Intelligent Layer Info :"+objIntelligentLayerInfo.values());
			keys = objIntelligentLayerInfo.keySet();
			
			for(String key: keys){
				logger.debug("Application Name :"+key);
				logger.debug("Intelligent Layer Info Map value :"+objIntelligentLayerInfo.get(key));
				
				IntelligentLayerKey = Constants.INTELLIGENT_KEY+key;
				logger.debug("Intelligent Layer Info Key :"+IntelligentLayerKey);
				
				AppDataMap.getInstance(key).setAppData(IntelligentLayerKey, objIntelligentLayerInfo.get(key));
				
			}
		}
	}catch(Exception e){
		logger.error("Exception in Intelligent Layer :"+e);
		GlobalPrintStackTrace.PrintStartUpException(logger, e);
	}finally{
		objIntelligentLayer = null;
		IntelligentLayerKey = null;
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
		String ipAddress = Constants.EMPTY_STRING;
		
		ipAddress = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.IPAddress);
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		logger.debug("IP Address:"+ipAddress);
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
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
		}finally{
			inputObjServiceUpdateInfo = null;
			ServiceUpdationKey = null;
			keys = null;
		}	
		return objServiceUpdateInfo;
	}
	
	public static DBLoadOnStartUp getInstance(){
	 if(objDBLoadOnStartUp!=null)
		return objDBLoadOnStartUp;
	 else{
		 objDBLoadOnStartUp = new DBLoadOnStartUp();
		 return objDBLoadOnStartUp;
	 }
	}
	
	public void UpdateAdminStatus (String appName,String serviceName){
		
		logger.debug("<---Check Admin Application Status--->");
		
		/** Declaration**/
		ServiceUpdateInfo ObjServiceUpdateInfo = null;
		String ServiceUpdationKey = null;
		Set<String> keys = null;
		String ipAddress = Constants.EMPTY_STRING;
		InetAddress ip = null;
		/**Assign**/
		try{
		logger.debug("Application Names :"+appName);
		ipAddress = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.IPAddress);
		
		if(Constants.N.equals(ipAddress)){
			logger.debug("IP address not configured in Property File:");	
			ip= InetAddress.getLocalHost();
			ipAddress = String.valueOf(ip);
			
		}
		
		logger.debug("IP address :" +ipAddress);
		ObjServiceUpdateInfo = new ServiceUpdateInfo();
		ObjServiceUpdateInfo.setAppName(appName);
		ObjServiceUpdateInfo.setIPaddress(ipAddress);
		ObjServiceUpdateInfo.setFlag(Constants.N);
		ObjServiceUpdateInfo.setStatus(Constants.N);
		ObjServiceUpdateInfo.setServiceName(serviceName);
		
		/**DB Call**/
		ObjServiceUpdateInfo=IVRDBServiceInstance.getInstance().updateServiceUpdationInfo(logger,ObjServiceUpdateInfo);
		
		if(ObjServiceUpdateInfo!=null){
			logger.debug("Service Update Status :"+ObjServiceUpdateInfo.getStatus());
		}
		
		}catch(Exception e){
			logger.error("Exception in HotFlash :"+e);
			GlobalPrintStackTrace.PrintStartUpException(logger, e);
		}finally{
			ObjServiceUpdateInfo = null;
			ServiceUpdationKey = null;
			keys = null;
		}	
	}
		
	public void loadPushSMSDetails (String appName){
			
			logger.debug("<---Loading VAS Details--->");
			
			/** Declaration**/
			IVRVasInfo objIVRVasInfo = null;
			Hashtable<String, Hashtable<String, List<IVRVasInfo>>> objCompleteVASInfo = null;
			PushSMSInfo pushSMSInfo = null;
			
			String PushSMSKey = null;
			Set<String> keys = null;
			
			Hashtable<String, Hashtable<String, PushSMSInfo>> pushSMSInfoHashTable = null;
			
			
			/**Assign**/
			try{
			logger.debug("Application Names :"+appName);
			pushSMSInfo = new PushSMSInfo();
			pushSMSInfo.setAppName(appName);
			
			/**DB Call**/
			pushSMSInfoHashTable = IVRDBServiceInstance.getInstance().getPushSMSInfo(logger, pushSMSInfo);
			
			if(pushSMSInfoHashTable!=null){
				logger.debug("Push SMS Info Details :"+pushSMSInfoHashTable.values());
				keys = pushSMSInfoHashTable.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					logger.debug("Push SMS Map value :"+pushSMSInfoHashTable.get(key));
					
					PushSMSKey = Constants.PUSH_SMS+key;
					logger.debug("Push SMS Info Key :"+PushSMSKey);
					
					AppDataMap.getInstance(key).setAppData(PushSMSKey, pushSMSInfoHashTable.get(key));
					
				}
			}
			}catch(Exception e){
				logger.error("Exception in Push SMS :"+e);
				GlobalPrintStackTrace.PrintStartUpException(logger, e);
			}finally{
				objIVRVasInfo = null;
				PushSMSKey = null;
				keys = null;
			}	
		}
}
