package com.servion.triplefive.utils;

import org.apache.log4j.Logger;

import com.servion.util.AppProperties;

public class LoadAppData {
	public static void LanguageCode(Logger logger){
		/**Declaration**/
		String strLangCode = Constants.EMPTY_STRING,strCode = Constants.EMPTY_STRING,Key = Constants.EMPTY_STRING;
		String appName = Constants.EMPTY_STRING,strLang = Constants.EMPTY_STRING;
		String[] arrLangCodeHypen = null; 
		String[] arrLangCode = null; 
		/**Assign**/
		try {
			appName = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.APPLICATION_NAMES);
			strLangCode = AppProperties.GetInstance(Constants.IVR_CONFIG).getIVRProp(Constants.Language_Code);
			
			logger.debug("Application Names :"+appName);
			logger.debug("Complete Language Codes :"+strLangCode);
			
			if(!Constants.N.equalsIgnoreCase(strLangCode)){
				arrLangCodeHypen =strLangCode.split(Constants.COMMA);
				
				for(int i =0; i<arrLangCodeHypen.length;i++){
					logger.debug("Language Codes :"+ "i :"+arrLangCodeHypen[i]);
					arrLangCode = arrLangCodeHypen[i].split(Constants.HYPEN);
					strCode=arrLangCode[0];
					strLang=arrLangCode[1];
					Key = Constants.Language_Code+strCode;
					logger.debug("Code :"+ ":"+strCode);
					logger.debug("Lang :"+ ":"+strLang);
					logger.debug("Key :"+ ":"+Key);
					
					AppDataMap.getInstance(Constants.TRIPLEFIVE).setAppData(Key,strLang);
					AppDataMap.getInstance(Constants.TRIPLEFIVE).setAppData(strLang,strCode);
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Loading Language Code :"+strCode);
			PrintStackTrace.PrintException(e);
		}
		
	}
}
