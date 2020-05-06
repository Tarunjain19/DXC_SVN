package com.servion.postpaid.utils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class SetPushSMS {
	
	public SetPushSMS() {
	}
	
	public Hashtable<String, String> generatePushSMSDataMap(String strSMSFrame, ArrayList<String> arrSMSData){
		
		String[] arrSMSFrame = strSMSFrame.split("\\|");
		
		String[] arrSMSConstants = null;
		Hashtable<String, String> smsDataInfoTable = null;
		
		try {
			smsDataInfoTable = new Hashtable<String, String>();
			
			smsDataInfoTable.put(Constants.SMSKeyword, arrSMSFrame[0]);
			
			if((arrSMSFrame.length>1)&&(arrSMSData.size()>0)){
				
				 arrSMSConstants = arrSMSFrame[1].split(",");
				 
				for (int i = 0; i < arrSMSConstants.length; i++) {
					smsDataInfoTable.put(arrSMSConstants[i], arrSMSData.get(i));
				}
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
		}
		
		return smsDataInfoTable;
		
	}
	
	public String getSMSText(String strSMSTemplate, Hashtable<String, String> smsDataInfoTable){
		
		Set<String> strKey = null;
		try {
			strKey = smsDataInfoTable.keySet();
			
			for (String strKeyword : strKey) {
				
				strSMSTemplate = strSMSTemplate.replace(strKeyword, smsDataInfoTable.get(strKeyword));
				
			}
		} catch (Exception e) {
			PrintStackTrace.PrintException(e);
		}
		
		return strSMSTemplate;
	}
	
	public static void main(String[] args) {
		
		String strSMSFrame = "FREEUNIT_Success|<FRUCategory>,<FRUAllocatedUnits>,<FRUConsumedUnits>,<FRUBalanceUnits>,<FRUEndDate>";
		ArrayList<String> arrList = new ArrayList<String>();
		String strSMSTemplate = "Free unit details for <FRUCategory> - Allocated Unit-<FRUAllocatedUnits>, Unit Consumed-<FRUConsumedUnits>, Balance Unit <FRUBalanceUnits>, Validity-<FRUEndDate>";
		
		arrList.add("123");
		arrList.add("234");
		arrList.add("456");
		arrList.add("457");
		arrList.add("458");
		
		SetPushSMS setSMText = new SetPushSMS();
		//System.out.println(setSMText.generatePushSMSDataMap(strSMSFrame, arrList));
		
		strSMSTemplate = setSMText.getSMSText(strSMSTemplate, setSMText.generatePushSMSDataMap(strSMSFrame, arrList));
		System.out.println(strSMSTemplate);
		
	}

}
