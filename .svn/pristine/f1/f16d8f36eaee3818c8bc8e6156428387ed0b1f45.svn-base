package com.rcom.rdtv.util;

import org.apache.log4j.Logger;

import com.servion.util.AppProperties;

public class LoadAppData {
	public static void LanguageCode(Logger logger){
		/**Declaration**/
		String strLangCode = AppConstants.EMPTY_STRING,strCode = AppConstants.EMPTY_STRING,Key = AppConstants.EMPTY_STRING;
		String appName = AppConstants.EMPTY_STRING,strLang = AppConstants.EMPTY_STRING;
		String[] arrLangCodeHypen = null; 
		String[] arrLangCode = null; 
		/**Assign**/
		try {
			appName = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.APP_NAME);
			strLangCode = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.Language_Code);
			
			logger.debug("Application Names :"+appName);
			logger.debug("Complete Language Codes :"+strLangCode);
			
			if(!AppConstants.N.equalsIgnoreCase(strLangCode)){
				arrLangCodeHypen =strLangCode.split(AppConstants.SEPERATOR_COMMA);
				
				for(int i =0; i<arrLangCodeHypen.length;i++){
					logger.debug("Language Codes :"+ "i :"+arrLangCodeHypen[i]);
					arrLangCode = arrLangCodeHypen[i].split(AppConstants.SEPERATOR_HYPEN);
					strCode=arrLangCode[0];
					strLang=arrLangCode[1];
					Key = AppConstants.LANG_+strCode;
					logger.debug("IVR DB Code :"+ ":"+strCode);
					logger.debug("IVR DB Lang :"+ ":"+strLang);
					logger.debug("IVR DB Key :"+ ":"+Key);
					
					AppDataMap.getInstance(AppConstants.RDTV_9001).setAppData(Key,strLang);
					AppDataMap.getInstance(AppConstants.RDTV_9001).setAppData(strLang,strCode);
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Loading Language Code :"+strCode);
			StackTrace.PrintException(e);
		}
		
	}
	
	public static void LanguageCodeExternal(Logger logger){
		/**Declaration**/
		String strLangCode = AppConstants.EMPTY_STRING,strCode = AppConstants.EMPTY_STRING,Key = AppConstants.EMPTY_STRING;
		String appName = AppConstants.EMPTY_STRING,strLang = AppConstants.EMPTY_STRING;
		String[] arrLangCodeHypen = null; 
		String[] arrLangCode = null; 
		/**Assign**/
		try {
			appName = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.APP_NAME);
			strLangCode = AppProperties.GetInstance(AppConstants.IVR_CONFIG_PROPERTIES).getIVRProp(AppConstants.Language_Code_External);
			
			logger.debug("Application Names :"+appName);
			logger.debug("Complete Language Codes :"+strLangCode);
			
			if(!AppConstants.N.equalsIgnoreCase(strLangCode)){
				arrLangCodeHypen =strLangCode.split(AppConstants.SEPERATOR_COMMA);
				
				for(int i =0; i<arrLangCodeHypen.length;i++){
					logger.debug("Language Codes :"+ "i :"+arrLangCodeHypen[i]);
					arrLangCode = arrLangCodeHypen[i].split(AppConstants.SEPERATOR_HYPEN);
					strCode=arrLangCode[0];
					strLang=arrLangCode[1];
					Key = AppConstants.LANG_+strCode;
					logger.debug("External DB Code :"+ ":"+strCode);
					logger.debug("External DB Lang :"+ ":"+strLang);
					logger.debug("External BB Key :"+ ":"+Key);
					
					AppDataMap.getInstance(AppConstants.RDTV_9001_EXTERNAL).setAppData(Key,strLang);
					AppDataMap.getInstance(AppConstants.RDTV_9001_EXTERNAL).setAppData(strLang,strCode);
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Loading Language Code :"+strCode);
			StackTrace.PrintException(e);
		}
		
	}
}
