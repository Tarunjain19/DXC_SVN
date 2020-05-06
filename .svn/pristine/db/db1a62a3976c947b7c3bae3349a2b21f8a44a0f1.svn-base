package com.rcom.rdtv.util;

import java.util.HashMap;
import java.util.Map;

public class AppDataMap {
	
	 
	private static Map<String, Object>  mapObjApplicationData = new HashMap<String, Object>(); 

	public Map objApplicationData = new HashMap<String, Object>();
	public static AppDataMap getInstance(String applicationName){
		
		AppDataMap objApplicationData = null;
		 
		 if(mapObjApplicationData.get(applicationName) != null){
			 objApplicationData = (AppDataMap)mapObjApplicationData.get(applicationName);
			 return objApplicationData;
		 }else{
			 objApplicationData = new AppDataMap();
			 mapObjApplicationData.put(applicationName,objApplicationData);
			 return objApplicationData;
		 }
	}
	
	private AppDataMap(){
	}
	
	public Object getAppData(String strAppDataName){
		Object objData=null;
		if(null!=objApplicationData){
			objData=objApplicationData.get(strAppDataName);	
		}
		return objData;
	}
	

	<X> void setAppData(String strElementKey, X beanElementData){
		if(null!=objApplicationData){
			objApplicationData.put(strElementKey, beanElementData);	
		}
	}
	
}





