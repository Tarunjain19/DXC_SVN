package com.rcom.util;

import java.net.InetAddress;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;


import com.rcom.otherflows.model.HotFlashInfo;
import com.rcom.otherflows.model.PushSMSInfo;
import com.rcom.otherflows.model.ServiceUpdateInfo;
import com.rcom.otherflows.resource.IVRDBServiceInstance;
import com.servion.util.AppProperties;
import com.rcom.util.AppConstant;


public class DBLoadOnStartUp {
	Logger logger =Logger.getLogger(AppConstant.LOGGER_NAME);
	private static DBLoadOnStartUp objDBLoadOnStartUp = null;
	private DBLoadOnStartUp (){

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
		
		ipAddress = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.ipAddress);
		
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
		objServiceUpdateInfo=IVRDBServiceInstance.getIVRDBInstance().getServiceUpdationInfo(logger,inputObjServiceUpdateInfo);
		
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
		ipAddress = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.ipAddress);
		
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
		ObjServiceUpdateInfo=IVRDBServiceInstance.getIVRDBInstance().updateServiceUpdationInfo(logger,ObjServiceUpdateInfo);
		
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
			System.out.println("RCOM_Dealer## <---Loading PushSMSText Details--->");
			/** Declaration**/
			PushSMSInfo inputObjPushSMSInfo = null;
			Hashtable<String, Hashtable<String, PushSMSInfo>> objPushSMSInfo = null;
			String PushSMSInfoKey = null;
			Set<String> keys = null;
			
			/**Assign**/
			try{
			logger.debug("Application Names :"+appName);
			System.out.println("RCOM_Dealer## Application Names :"+appName);
			inputObjPushSMSInfo = new PushSMSInfo();
			inputObjPushSMSInfo.setAppName(appName);
			
			/**DB Call**/
			objPushSMSInfo=IVRDBServiceInstance.getIVRDBInstance().getPushSMSInfo(logger,inputObjPushSMSInfo);
			
			if(objPushSMSInfo!=null){
				logger.debug("Push SMS Text Info Details :"+objPushSMSInfo.values());
				System.out.println("RCOM_Dealer## Push SMS Text Info Details :"+objPushSMSInfo.values());
				keys = objPushSMSInfo.keySet();
				
				for(String key: keys){
					logger.debug("Application Name :"+key);
					System.out.println("RCOM_Dealer## Application Name :"+key);
					logger.debug("Push SMS Text Map value :"+objPushSMSInfo.get(key));
					System.out.println("RCOM_Dealer## Push SMS Text Map value :"+objPushSMSInfo.get(key));
					PushSMSInfoKey = AppConstant.PUSH_SMS+key;
					logger.debug("Push SMS Text Info Key :"+PushSMSInfoKey);
					System.out.println("RCOM_Dealer## Push SMS Text Info Key :"+PushSMSInfoKey);
					AppDataMap.getInstance(key).setAppData(PushSMSInfoKey, objPushSMSInfo.get(key));
					
				}
			}
		}catch(Exception e){
			logger.error("Exception in Push SMS :"+e);
			System.out.println("RCOM_Dealer## Exception in Push SMS :"+e);
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
