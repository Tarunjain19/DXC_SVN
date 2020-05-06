package com.rcom.broadband;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.bb.model.HotFlashInfo;
import com.rcom.bb.model.PushSMSInfo;
import com.rcom.bb.model.ServiceUpdateInfo;
import com.rcom.bb.resource.IVRDBServiceInstance;
import com.servion.util.AppProperties;


public class DBLoadOnStartUp {
	Logger logger =Logger.getLogger(Constants.LOGGER_NAME_LOADLEVEL);
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

		public Hashtable CheckAdminStatus (String appName){
	
		logger.debug("<---Check Admin Application Status--->");
		
		/** Declaration**/
		ServiceUpdateInfo inputObjServiceUpdateInfo = null;
		Hashtable<String,Hashtable<String,ServiceUpdateInfo>> objServiceUpdateInfo= null;
		String ServiceUpdationKey = null;
		Set<String> keys = null;
		String ipAddress = Constants.EMPTY;
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
		String ipAddress = Constants.EMPTY;
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
					
					PushSMSInfoKey = Constants.PUSH_SMS+key;
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
