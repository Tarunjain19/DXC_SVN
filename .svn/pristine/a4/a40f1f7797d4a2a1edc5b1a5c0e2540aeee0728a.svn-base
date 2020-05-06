package com.rcom.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class SetPushSMS {
	
	public SetPushSMS() {
	}
	
	public Hashtable<String, String> generatePushSMSDataMap(String strSMSFrame, ArrayList<String> arrSMSData){
		
		String[] arrSMSFrame = strSMSFrame.split("\\|");
		
		String[] arrSMSConstants = null;
		Hashtable<String, String> smsDataInfoTable = new Hashtable<String, String>();
		
		smsDataInfoTable.put(AppConstant.SMSKeyword, arrSMSFrame[0]);
		
		if(arrSMSFrame.length>1){
			
			 arrSMSConstants = arrSMSFrame[1].split(",");
			 
			for (int i = 0; i < arrSMSConstants.length; i++) {
				System.out.println(i);
				System.out.println(arrSMSConstants[i]);
				smsDataInfoTable.put(arrSMSConstants[i], arrSMSData.get(i));
				
			}
			
		}
		
		return smsDataInfoTable;
		
		
	}
	
	public String getSMSText(String strSMSTemplate, Hashtable<String, String> smsDataInfoTable){
		
		if(smsDataInfoTable!=null){
			Set<String> strKey = smsDataInfoTable.keySet();
			for (String strKeyword : strKey) {
				
				strSMSTemplate = strSMSTemplate.replace(strKeyword, smsDataInfoTable.get(strKeyword));
				
			}
		}
		return strSMSTemplate;
	}
	
	public static void main(String[] args) {
		
		String strSMSFrame = "MYPLAN_Success|<PushSMS1>,<PushSMS2>,<PushSMS3>";
		ArrayList<String> arrList = new ArrayList<String>();
		String strSMSTemplate = "SMS one is <PushSMS1>, SMS two is <PushSMS2>, SMS three is <PushSMS3>";
		
		arrList.add("123");
		arrList.add("234");
		arrList.add("456");
		
		SetPushSMS setSMText = new SetPushSMS();
		System.out.println(setSMText.generatePushSMSDataMap(strSMSFrame, arrList));
		
		strSMSTemplate = setSMText.getSMSText(strSMSTemplate, setSMText.generatePushSMSDataMap(strSMSFrame, arrList));
		System.out.println(strSMSTemplate);
		
	}

}
