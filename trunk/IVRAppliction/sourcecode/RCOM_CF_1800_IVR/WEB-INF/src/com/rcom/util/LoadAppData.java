package com.rcom.util;

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
			appName = AppProperties.GetInstance(AppConstants.IVR_CONFIG).getIVRProp(AppConstants.APPLICATION_NAMES);
			strLangCode = AppProperties.GetInstance(AppConstants.IVR_CONFIG).getIVRProp(AppConstants.Language_Code);
			
			logger.debug("Application Names :"+appName);
			logger.debug("Complete Language Codes :"+strLangCode);
			
			if(!AppConstants.N.equalsIgnoreCase(strLangCode)){
				arrLangCodeHypen =strLangCode.split(AppConstants.SEPERATOR_COMMA);
				
				for(int i =0; i<arrLangCodeHypen.length;i++){
					logger.debug("Language Codes :"+ "i :"+arrLangCodeHypen[i]);
					arrLangCode = arrLangCodeHypen[i].split(AppConstants.SEPERATOR_HYPEN);
					strCode=arrLangCode[0];
					strLang=arrLangCode[1];
					Key = AppConstants.Language_Code+strCode;
					logger.debug("Code :"+ ":"+strCode);
					logger.debug("Lang :"+ ":"+strLang);
					logger.debug("Key :"+ ":"+Key);
					
					AppDataMap.getInstance(AppConstants.PREPAID).setAppData(Key,strLang);
					AppDataMap.getInstance(AppConstants.PREPAID).setAppData(strLang,strCode);
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Loading Language Code :"+strCode);
			StackTrace.PrintException(e);
		}
		
	}
}
