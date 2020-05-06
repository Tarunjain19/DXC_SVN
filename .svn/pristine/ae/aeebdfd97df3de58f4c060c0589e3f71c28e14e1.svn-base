package com.rcom.prepaid.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.rcom.prepaid.model.CircleOffersInfo;
import com.rcom.prepaid.model.HotFlashInfo;
import com.rcom.prepaid.model.IVRVasInfo;
import com.rcom.prepaid.model.IntelligentLayerInfo;
import com.rcom.prepaid.model.MDNOfferInfo;
import com.rcom.prepaid.model.PushSMSInfo;
import com.rcom.prepaid.model.RechargePlanInfo;
import com.rcom.prepaid.model.ServiceUpdateInfo;
import com.rcom.prepaid.model.SpecialTariffInfo;
import com.rcom.prepaid.resource.Constants;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA.HOSTDETAILS.HOST;

public class Utils {
	
	/**
	 * 
	 * @param logger
	 * @param strProcedure
	 * @param startTime
	 * @param endtime
	 */
	public static void getConnectionTime(Logger logger,String sessionId, String strProcedure, long startTime, long endtime){
		if(logger.isDebugEnabled()){logger.debug(sessionId+" : Time for executing "+strProcedure+" is "+(endtime-startTime)+" ms");}
		//System.out.println((endtime-startTime));
	}
	
	/**
	 * 
	 * @param logger
	 * @param e
	 */
	public static void printStackTrace(Logger logger, String sessionId, Exception e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			//e.printStackTrace();
			logger.error(sessionId+"Error occured in : ", e);
		}finally {
			sw.flush();
			pw.close();
			sw = null;
			pw = null;
		}
	}
	
	/**
	 * 
	 * @param flashInfoList
	 * @param applicationName
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, HotFlashInfo>> getHotFlashHashTable(List<HotFlashInfo> flashInfoList){
		
		Hashtable<String, Hashtable<String, HotFlashInfo>> nodeIdHotFlashTable = new Hashtable<String, Hashtable<String, HotFlashInfo>>();
		
		Hashtable<String, HotFlashInfo> circleIdHashtable = null;
		
		Set<String> circleOffersInfoSet = new HashSet<String>();
		
		for (int i = 0; i < flashInfoList.size(); i++) {
			
			circleOffersInfoSet.add(flashInfoList.get(i).getAppName());
			
		}
		
		for (Iterator iterator = circleOffersInfoSet.iterator(); iterator
				.hasNext();) {
			String applicationName = (String) iterator.next();
			circleIdHashtable = new Hashtable<String, HotFlashInfo>();
			
				for (Iterator iterator1 = flashInfoList.iterator(); iterator1
						.hasNext();) {
					
					HotFlashInfo hotFlashInfo = (HotFlashInfo) iterator1.next();
					if((hotFlashInfo.getAppName()).equals(applicationName))
					{
						
						circleIdHashtable.put(hotFlashInfo.getNodeId()+Constants.UNDERSCORE+hotFlashInfo.getCircle()+Constants.UNDERSCORE+hotFlashInfo.getLanguage(), hotFlashInfo);
					}
					
					nodeIdHotFlashTable.put(applicationName, circleIdHashtable);
					
				}
		}
		
		return nodeIdHotFlashTable;
		
	}
	
	/**
	 * 
	 * @param circleOfferList
	 * @param applicationName
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> getCircleOfferHashTable(List<CircleOffersInfo> circleOfferList){
		
		Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> applicationNameTariffTable = new Hashtable<String, Hashtable<String, List<CircleOffersInfo>>>();
		Hashtable<String, List<CircleOffersInfo>> circleIdHashtable = null; 
		List<CircleOffersInfo> newCircleOfferInfoList = null;
		
		for (int i = 0; i < circleOfferList.size(); i++) {
			String appName = circleOfferList.get(i).getAppName();
			circleIdHashtable = applicationNameTariffTable.get(appName);
			
			if(circleIdHashtable == null){
				circleIdHashtable = new Hashtable<String, List<CircleOffersInfo>>();
				applicationNameTariffTable.put(appName, circleIdHashtable);
			}
			
			newCircleOfferInfoList =  circleIdHashtable.get(circleOfferList.get(i).getCircleId()+Constants.UNDERSCORE+circleOfferList.get(i).getLanguage()+Constants.UNDERSCORE+circleOfferList.get(i).getMenuOption());
			
			if(newCircleOfferInfoList == null){
				newCircleOfferInfoList = new LinkedList<CircleOffersInfo>();
				newCircleOfferInfoList.add(circleOfferList.get(i));
				circleIdHashtable.put(circleOfferList.get(i).getCircleId()+Constants.UNDERSCORE+circleOfferList.get(i).getLanguage()+Constants.UNDERSCORE+circleOfferList.get(i).getMenuOption(), newCircleOfferInfoList);
			}else{
				newCircleOfferInfoList.add(circleOfferList.get(i));
			}
			
		}
		
		return applicationNameTariffTable;
		
	}
	
	/**
	 * 
	 * @param mdnOfferInfoList
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, List<MDNOfferInfo>>> getMDNOfferHashTable(List<MDNOfferInfo> mdnOfferInfoList){
		
		Hashtable<String, Hashtable<String, List<MDNOfferInfo>>> mdnHashTable = new Hashtable<String, Hashtable<String, List<MDNOfferInfo>>>();
		Hashtable<String, List<MDNOfferInfo>> circleIdHashtable = null; 
		List<MDNOfferInfo> newMDNOfferInfoList = null;
		
		for (int i = 0; i < mdnOfferInfoList.size(); i++) {
			String applicationName = mdnOfferInfoList.get(i).getAppName();
			circleIdHashtable = mdnHashTable.get(applicationName);
			
			if(circleIdHashtable == null){
				circleIdHashtable = new Hashtable<String, List<MDNOfferInfo>>();
				mdnHashTable.put(applicationName, circleIdHashtable);
			}
			
			newMDNOfferInfoList =  circleIdHashtable.get(mdnOfferInfoList.get(i).getLanguage()+Constants.UNDERSCORE+mdnOfferInfoList.get(i).getOfferCode());
			
			if(newMDNOfferInfoList == null){
				newMDNOfferInfoList = new LinkedList<MDNOfferInfo>();
				newMDNOfferInfoList.add(mdnOfferInfoList.get(i));
				circleIdHashtable.put(mdnOfferInfoList.get(i).getLanguage()+Constants.UNDERSCORE+mdnOfferInfoList.get(i).getOfferCode(), newMDNOfferInfoList);
			}else{
				newMDNOfferInfoList.add(mdnOfferInfoList.get(i));
			}
			
		}
		
		return mdnHashTable;
		
	}
	
	/**
	 * 
	 * @param rechargePlanList
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> getRechargePlanHashTable(List<RechargePlanInfo> rechargePlanList){
				
		Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> applicationspecialTariffTable = new Hashtable<String, Hashtable<String, List<RechargePlanInfo>>>();
		Hashtable<String, List<RechargePlanInfo>> circleIdHashtable = null; 
		List<RechargePlanInfo> newRechargePlanInfoList = null;
		
		for (int i = 0; i < rechargePlanList.size(); i++) {
			String appName = rechargePlanList.get(i).getAppName();
			circleIdHashtable = applicationspecialTariffTable.get(appName);
			
			if(circleIdHashtable == null){
				circleIdHashtable = new Hashtable<String, List<RechargePlanInfo>>();
				applicationspecialTariffTable.put(appName, circleIdHashtable);
			}
			
			newRechargePlanInfoList =  circleIdHashtable.get(rechargePlanList.get(i).getCircleId()+Constants.UNDERSCORE+rechargePlanList.get(i).getLanguage()+Constants.UNDERSCORE+rechargePlanList.get(i).getMenuOption());
			
			if(newRechargePlanInfoList == null){
				newRechargePlanInfoList = new LinkedList<RechargePlanInfo>();
				newRechargePlanInfoList.add(rechargePlanList.get(i));
				circleIdHashtable.put(rechargePlanList.get(i).getCircleId()+Constants.UNDERSCORE+rechargePlanList.get(i).getLanguage()+Constants.UNDERSCORE+rechargePlanList.get(i).getMenuOption(), newRechargePlanInfoList);
			}else{
				newRechargePlanInfoList.add(rechargePlanList.get(i));
			}
			
		}
		
		
		
		return applicationspecialTariffTable;
		
	}
	
	/**
	 * 
	 * @param speInfoList
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> getSpecialTariffHashTable(List<SpecialTariffInfo> speInfoList){
		
		Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> applicationspecialTariffTable = new Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>>();
		Hashtable<String, List<SpecialTariffInfo>> circleIdHashtable = null; 
		List<SpecialTariffInfo> newSpecialTariffInfoList = null;
		
		for (int i = 0; i < speInfoList.size(); i++) {
			String appName = speInfoList.get(i).getAppName();
			circleIdHashtable = applicationspecialTariffTable.get(appName);
			
			if(circleIdHashtable == null){
				circleIdHashtable = new Hashtable<String, List<SpecialTariffInfo>>();
				applicationspecialTariffTable.put(appName, circleIdHashtable);
			}
			
			newSpecialTariffInfoList =  circleIdHashtable.get(speInfoList.get(i).getCircleId()+Constants.UNDERSCORE+speInfoList.get(i).getLanguage()+Constants.UNDERSCORE+speInfoList.get(i).getPackMenuOption());
			
			if(newSpecialTariffInfoList == null){
				newSpecialTariffInfoList = new LinkedList<SpecialTariffInfo>();
				newSpecialTariffInfoList.add(speInfoList.get(i));
				circleIdHashtable.put(speInfoList.get(i).getCircleId()+Constants.UNDERSCORE+speInfoList.get(i).getLanguage()+Constants.UNDERSCORE+speInfoList.get(i).getPackMenuOption(), newSpecialTariffInfoList);
			}else{
				newSpecialTariffInfoList.add(speInfoList.get(i));
			}
			
		}		
		
		return applicationspecialTariffTable;
		
	}
	
	/**
	 * 
	 * @param intelligentLayerActiveList
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, IntelligentLayerInfo>> getIntelligentLayerHashTable(List<IntelligentLayerInfo> intelligentLayerActiveList){
		
		Hashtable<String, Hashtable<String, IntelligentLayerInfo>> applicationIntelligentLayerTable = new Hashtable<String, Hashtable<String, IntelligentLayerInfo>>();
		Hashtable<String, IntelligentLayerInfo> circleIdHashtable = null;
		
		Set<String> intelligentLayerInfoSet = new HashSet<String>();
		
		for (int i = 0; i < intelligentLayerActiveList.size(); i++) {
			
			intelligentLayerInfoSet.add(intelligentLayerActiveList.get(i).getAppName());
			
		}
		
		for (Iterator iterator = intelligentLayerInfoSet.iterator(); iterator
				.hasNext();) {
			String applicationName = (String) iterator.next();
			circleIdHashtable = new Hashtable<String, IntelligentLayerInfo>();
			
				for (Iterator iterator1 = intelligentLayerActiveList.iterator(); iterator1
						.hasNext();) {
					
					IntelligentLayerInfo intelligentLayerInfo = (IntelligentLayerInfo) iterator1.next();
					if((intelligentLayerInfo.getAppName()).equals(applicationName))
					{
						
						circleIdHashtable.put(intelligentLayerInfo.getCircleId(), intelligentLayerInfo);
					}
					
					applicationIntelligentLayerTable.put(applicationName, circleIdHashtable);
					
				}
		}
		
		return applicationIntelligentLayerTable;
		
	}
	
	public static Hashtable<String, Hashtable<String, ServiceUpdateInfo>> getServiceUpdateInfoHashTable(List<ServiceUpdateInfo> serviceUpdateInfoList){
		
		Hashtable<String, Hashtable<String, ServiceUpdateInfo>> serviceUpdateTable = new Hashtable<String, Hashtable<String, ServiceUpdateInfo>>();
		
		Hashtable<String, ServiceUpdateInfo> circleIdHashtable = null;
		
		Set<String> serviceUpdateInfoSet = new HashSet<String>();
		
		for (int i = 0; i < serviceUpdateInfoList.size(); i++) {
			
			serviceUpdateInfoSet.add(serviceUpdateInfoList.get(i).getAppName());
			
		}
		
		for (Iterator iterator = serviceUpdateInfoSet.iterator(); iterator
				.hasNext();) {
			String applicationName = (String) iterator.next();
			circleIdHashtable = new Hashtable<String, ServiceUpdateInfo>();
			
				for (Iterator iterator1 = serviceUpdateInfoList.iterator(); iterator1
						.hasNext();) {
					
					ServiceUpdateInfo serviceUpdateInfo = (ServiceUpdateInfo) iterator1.next();
					if((serviceUpdateInfo.getAppName()).equals(applicationName))
					{
						
						circleIdHashtable.put(serviceUpdateInfo.getServiceName(), serviceUpdateInfo);
					}
					
					serviceUpdateTable.put(applicationName, circleIdHashtable);
					
				}
		}
		
		return serviceUpdateTable;
		
	}
	
	public static void main(String[] args) {
		/*IntelligentLayerInfo intelligentLayerInfo1 = new IntelligentLayerInfo();
		intelligentLayerInfo1.setCircleId("123");
		intelligentLayerInfo1.setAppName("App1");
		IntelligentLayerInfo intelligentLayerInfo2 = new IntelligentLayerInfo();
		intelligentLayerInfo2.setCircleId("1231");
		intelligentLayerInfo2.setAppName("App2");
		
		List<IntelligentLayerInfo> list = new LinkedList<IntelligentLayerInfo>();
		list.add(intelligentLayerInfo1);
		list.add(intelligentLayerInfo2);
		
		String[] arrString = "App1,App2".split(",");
		
		Hashtable<String, IntelligentLayerInfo> hashtable = Utils.getIntelligentLayerHashTable(list, arrString);
		System.out.println(hashtable.toString());
		
		HotFlashInfo hotFlashInfo1 = new HotFlashInfo();
		hotFlashInfo1.setAppName("AppName");
		hotFlashInfo1.setNodeId("100");
		
		HotFlashInfo hotFlashInfo2 = new HotFlashInfo();
		hotFlashInfo2.setAppName("AppName");
		hotFlashInfo2.setNodeId("101");
		
		List<HotFlashInfo> hotFlashInfoList = new LinkedList<HotFlashInfo>();
		hotFlashInfoList.add(hotFlashInfo1);
		hotFlashInfoList.add(hotFlashInfo2);
		
		Hashtable<String, Hashtable<String, HotFlashInfo>> hashtable = Utils.getHotFlashHashTable(hotFlashInfoList);
		System.out.println(hashtable);
		
		String[] arrString = null;
		arrString = ("App1,App2").split(",");
		arrString.*/
		
		/*SpecialTariffInfo specialTariffInfo1 = new SpecialTariffInfo();
		specialTariffInfo1.setAppName("App1");
		specialTariffInfo1.setCircleId("123");
		specialTariffInfo1.setLanguage("03");
		specialTariffInfo1.setOfferId("off1");
		SpecialTariffInfo specialTariffInfo2 = new SpecialTariffInfo();
		specialTariffInfo2.setAppName("App1");
		specialTariffInfo2.setCircleId("123");
		specialTariffInfo2.setLanguage("03");
		specialTariffInfo2.setOfferId("off2");
		SpecialTariffInfo specialTariffInfo3 = new SpecialTariffInfo();
		specialTariffInfo3.setAppName("App1");
		specialTariffInfo3.setCircleId("123");
		specialTariffInfo3.setLanguage("04");
		specialTariffInfo3.setOfferId("off3");
		SpecialTariffInfo specialTariffInfo4 = new SpecialTariffInfo();
		specialTariffInfo4.setAppName("App2");
		specialTariffInfo4.setCircleId("123");
		specialTariffInfo4.setLanguage("03");
		specialTariffInfo4.setOfferId("off4");
		
		List<SpecialTariffInfo> list = new LinkedList<SpecialTariffInfo>();
		list.add(specialTariffInfo1);
		list.add(specialTariffInfo2);
		list.add(specialTariffInfo4);
		list.add(specialTariffInfo3);*/
		
		
		
		/*Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> hashtable = Utils.getSpecialTariffHashTable(list);
		
		//Utils.dummy(list);
		System.out.println(hashtable);*/
		
		

	}
	
	/**
	 * 
	 * @param intelligentLayerActiveList
	 * @return
	 */
	public static Hashtable<String, Hashtable<String, List<IVRVasInfo>>> getapplicationIVRVasInfoHashTable(List<IVRVasInfo> ivrVasInfoList){
		
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> applicationIVRVasInfoTable = new Hashtable<String, Hashtable<String, List<IVRVasInfo>>>();
		Hashtable<String, List<IVRVasInfo>> circleIdHashtable = null; 
		List<IVRVasInfo> newSpecialTariffInfoList = null;
		
		for (int i = 0; i < ivrVasInfoList.size(); i++) {
			String appName = ivrVasInfoList.get(i).getAppName();
			circleIdHashtable = applicationIVRVasInfoTable.get(appName);
			
			if(circleIdHashtable == null){
				circleIdHashtable = new Hashtable<String, List<IVRVasInfo>>();
				applicationIVRVasInfoTable.put(appName, circleIdHashtable);
			}
			
			newSpecialTariffInfoList =  circleIdHashtable.get(ivrVasInfoList.get(i).getCircleId()+Constants.UNDERSCORE+ivrVasInfoList.get(i).getLanguageCode());
			
			if(newSpecialTariffInfoList == null){
				newSpecialTariffInfoList = new LinkedList<IVRVasInfo>();
				newSpecialTariffInfoList.add(ivrVasInfoList.get(i));
				circleIdHashtable.put(ivrVasInfoList.get(i).getCircleId()+Constants.UNDERSCORE+ivrVasInfoList.get(i).getLanguageCode(), newSpecialTariffInfoList);
			}else{
				newSpecialTariffInfoList.add(ivrVasInfoList.get(i));
			}
			
		}
		
		return applicationIVRVasInfoTable;
		
	}
	
	public static Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfoHashTable(List<PushSMSInfo> pushSMSInfoList){
		
		
		Hashtable<String, Hashtable<String, PushSMSInfo>> pushSMSInfoHashTable = new Hashtable<String, Hashtable<String, PushSMSInfo>>();
		Hashtable<String, PushSMSInfo> circleIdHashtable = null;
		
		Set<String> pushSMSInfoSet = new HashSet<String>();
		
		for (int i = 0; i < pushSMSInfoList.size(); i++) {
			
			pushSMSInfoSet.add(pushSMSInfoList.get(i).getAppName());
			
		}
		
		for (Iterator iterator = pushSMSInfoSet.iterator(); iterator
				.hasNext();) {
			String applicationName = (String) iterator.next();
			circleIdHashtable = new Hashtable<String, PushSMSInfo>();
			
				for (Iterator iterator1 = pushSMSInfoList.iterator(); iterator1
						.hasNext();) {
					
					PushSMSInfo pushSMSInfo = (PushSMSInfo) iterator1.next();
					if((pushSMSInfo.getAppName()).equals(applicationName))
					{
						
						circleIdHashtable.put(pushSMSInfo.getCircleId()+Constants.UNDERSCORE+pushSMSInfo.getSmsKeyword(), pushSMSInfo);
					}
					
					pushSMSInfoHashTable.put(applicationName, circleIdHashtable);
					
				}
		}
		
		return pushSMSInfoHashTable;
	}
	
	public static void dummy (List<SpecialTariffInfo> list){
		
		Hashtable< String , Hashtable<String, List<SpecialTariffInfo>>> objFinal = new Hashtable< String , Hashtable<String, List<SpecialTariffInfo>>>();
		String cricleKey = null;
		
		for (int i=0;i<list.size();i++){
			SpecialTariffInfo objSpecialTariffInfo = list.get(i);
			String appName = objSpecialTariffInfo.getAppName();
			
			Hashtable<String, List<SpecialTariffInfo>> objcricleMap =objFinal.get(appName);
			
			if(objcricleMap==null){
				objcricleMap = new Hashtable<String, List<SpecialTariffInfo>>();
				objFinal.put(appName, objcricleMap);
			}
			
			cricleKey = objSpecialTariffInfo.getCircleId()+objSpecialTariffInfo.getLanguage();
			List<SpecialTariffInfo> innerList = objcricleMap.get(cricleKey);
			
			if(innerList == null){
				 innerList = new LinkedList<SpecialTariffInfo>();
				 innerList.add(objSpecialTariffInfo);
				 objcricleMap.put(cricleKey,innerList);
			}else{
				 innerList.add(objSpecialTariffInfo);
			}
			
			
		}
		System.out.println(objFinal);
	}

	public static void generateReport(GetReportObject reportObject, String hostId, String hostMethod, String startTime, String input, String output, String response, String status, String endtime){
		
		if(reportObject!= null){
			HOST host = reportObject.createReportHostObject();
			
			host.setHOSTTYPE("DB");
			host.setHOSTID(hostId);
			host.setHOSTMETHOD(hostMethod);
			host.setHOSTSTDATETIME(startTime);
			host.setHOSTINPARAMS(input);
			host.setHOSTOUTPARAMS(output);
			host.setHOSTRESPONSE(response);
			host.setHOSTSTATUS(status);
			host.setHOSTENDDATETIME(endtime);
			
			reportObject.insertHostDetail(reportObject.getIvrreportdata(), host);
		}
		
	}
	
}
