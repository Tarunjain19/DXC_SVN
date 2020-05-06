package com.rcom.util;

import org.apache.log4j.Logger;

import com.servion.util.AppProperties;

public class LoadAppData {
	public static void LanguageCode(Logger logger){
		/**Declaration**/
		String strLangCode = AppConstant.EMPTY_STRING,strCode = AppConstant.EMPTY_STRING,Key = AppConstant.EMPTY_STRING;
		String appName = AppConstant.EMPTY_STRING,strLang = AppConstant.EMPTY_STRING;
		String[] arrLangCodeHypen = null; 
		String[] arrLangCode = null; 
		/**Assign**/
		try {
			appName = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.APPLICATION_NAMES);
			strLangCode = AppProperties.GetInstance(AppConstant.IVR_CONFIG).getIVRProp(AppConstant.Language_Code);
			
			logger.debug("Application Names :"+appName);
			logger.debug("Complete Language Codes :"+strLangCode);
			
			if(!AppConstant.N.equalsIgnoreCase(strLangCode)){
				arrLangCodeHypen =strLangCode.split(AppConstant.SEPERATOR_COMMA);
				
				for(int i =0; i<arrLangCodeHypen.length;i++){
					logger.debug("Language Codes :"+ "i :"+arrLangCodeHypen[i]);
					arrLangCode = arrLangCodeHypen[i].split(AppConstant.SEPERATOR_HYPEN);
					strCode=arrLangCode[0];
					strLang=arrLangCode[1];
					Key = AppConstant.Language_Code+strCode;
					logger.debug("Code :"+ ":"+strCode);
					logger.debug("Lang :"+ ":"+strLang);
					logger.debug("Key :"+ ":"+Key);
					
					AppDataMap.getInstance(AppConstant.PREPAID).setAppData(Key,strLang);
					AppDataMap.getInstance(AppConstant.PREPAID).setAppData(strLang,strCode);
				}
			}
		} catch (Exception e) {
			logger.error("Exception in Loading Language Code :"+strCode);
			StackTrace.PrintException(e);
		}
		
	}
}
