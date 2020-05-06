package com.servion.hsd.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
	
	public ArrayList<String> listofAppDataServiceNames(){
		ArrayList<String> arrListOfServiceName = new ArrayList<String>();
		if(null!=objApplicationData){
			Set<String> serviceNames = objApplicationData.keySet();
			for (String serviceName : serviceNames) {
				arrListOfServiceName.add(serviceName);
			}
		}
		return arrListOfServiceName;
	}
	
	public static ArrayList<String> listApplicationNameInList(){
		
		Set<String> applicationNames = mapObjApplicationData.keySet();
		ArrayList<String> arrListOfAppName = new ArrayList<String>();
		
		for (String applicationName : applicationNames) {
			arrListOfAppName.add(applicationName);
		}		
		
		return arrListOfAppName;
	}
	
}





