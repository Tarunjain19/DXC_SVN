package com.rcom.prepaid.test;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.rcom.prepaid.model.CRMCountInfo;
import com.rcom.prepaid.model.IVRRoutingInfo;
import com.rcom.prepaid.model.IVRVasInfo;
import com.rcom.prepaid.resource.IVRDBServiceInstance;
import com.servion.util.IVRDataBean;

public class Test {
	
	private static Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		final IVRDataBean objIVRDataBean = new IVRDataBean();
		objIVRDataBean.setLogger(logger);
		objIVRDataBean.setSessionID("Thread");
		IVRRoutingInfo ivrRoutingInfo = new IVRRoutingInfo();
		ivrRoutingInfo.setDnis("52535");
		ivrRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean, ivrRoutingInfo);
		System.out.println(ivrRoutingInfo.toString());
		/*Runnable task = new Runnable() {
	        @Override
	        public void run() {
	            for (int i = 0; i < 100; i++){
	            	IVRCspInfo ivrCspInfo = new IVRCspInfo();
					ivrCspInfo.setMdn("4556");
					ivrCspInfo = IVRDBServiceInstance.getInstance().getIVRCSPInfo(objIVRDataBean, ivrCspInfo);
					System.out.println(ivrCspInfo.toString());
					
					IVRVasInfo info = new IVRVasInfo();
					info.setAppName("RCOM_CF_BB_Corporate_Desk_IVR");
					Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
					System.out.println(hashtable);
					
					CircleOffersInfo circleOffersInfo = new CircleOffersInfo();
					circleOffersInfo.setAppName("RCOM_CF_555_Postpaid_IVR");
					circleOffersInfo.setOfferType("DATA");
					Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> hashtable3 = IVRDBServiceInstance.getInstance().getCircleOffers(logger, circleOffersInfo);
					System.out.println(hashtable3);
					
					MDNOfferInfo mdnOfferInfo = new MDNOfferInfo();
					mdnOfferInfo.setAppName("RCOM_CF_555_Postpaid_IVR");
					mdnOfferInfo.setOfferCode("66");
					mdnOfferInfo = IVRDBServiceInstance.getInstance().getMDNSpecificOffers(objIVRDataBean, mdnOfferInfo);
					System.out.println(mdnOfferInfo);
					
					UpdateLanguage updateLanguage = new UpdateLanguage();
					updateLanguage.setLanguageCode("01");
					updateLanguage.setMdn("9600301098");
					updateLanguage = IVRDBServiceInstance.getInstance().updatePreferredLanguage(objIVRDataBean, updateLanguage);
					System.out.println(updateLanguage);
					
					TariffChangeDetail tariffChangeDetail = new TariffChangeDetail();
					tariffChangeDetail.setMdn("4434");
					tariffChangeDetail.setCircleId("TN");
					tariffChangeDetail.setLanguageid("ENG");
					tariffChangeDetail = IVRDBServiceInstance.getInstance().getTariffChangeDetail(objIVRDataBean, tariffChangeDetail);
					System.out.println(tariffChangeDetail);
					
					CRMCountInfo crmCountInfo = new CRMCountInfo();
					crmCountInfo.setMdn("9600301098");
					crmCountInfo = IVRDBServiceInstance.getInstance().getCRMCountInfo(objIVRDataBean, crmCountInfo);
					System.out.println(crmCountInfo);
					
					RechargePlanInfo rechargePlanInfo = new RechargePlanInfo();
					rechargePlanInfo.setAppName("RCOM_CF_BB_Corporate_Desk_IVR");
					Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> hashtable2 = IVRDBServiceInstance.getInstance().getRechargePlan(logger, rechargePlanInfo);
					System.out.println(hashtable2);
					
					PushSMSInfo pushSMSInfo = new PushSMSInfo();
					pushSMSInfo.setAppName("RCOM_CF_BB_Corporate_Desk_IVR");
					Hashtable<String, Hashtable<String, PushSMSInfo>> hashtablePushSMS = IVRDBServiceInstance.getInstance().getPushSMSInfo(logger, pushSMSInfo);
					System.out.println(hashtablePushSMS);
					
					TransferVDNInfo trVdnInfo = new TransferVDNInfo();
					trVdnInfo.setAppName("RCOM_CF_BB_Enterprise_Desk_IVR");
					trVdnInfo.setCircle("");
					trVdnInfo.setCustomerSegment("");
					trVdnInfo.setLanguage("");
					trVdnInfo.setCallType("");
					trVdnInfo.setTransferReasonCode("TR_0001");
					trVdnInfo = IVRDBServiceInstance.getInstance().getTransferVDN(objIVRDataBean, trVdnInfo);
					System.out.println(trVdnInfo.toString());
					
					SpecialTariffInfo specialTariffInfo = new SpecialTariffInfo();
					specialTariffInfo.setAppName("RCOM_CF_BB_Corporate_Desk_IVR");
					Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> hashtable1 = IVRDBServiceInstance.getInstance().getSpecialTarifInfo(logger, specialTariffInfo);
					System.out.println(hashtable1);
					
					IVRRoutingInfo ivrRoutingInfo = new IVRRoutingInfo();
					ivrRoutingInfo.setDnis("1");
					ivrRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean, ivrRoutingInfo);
					System.out.println(ivrRoutingInfo.toString());
					
					ServiceUpdateInfo serviceUpdateInfo = new ServiceUpdateInfo();
					serviceUpdateInfo.setAppName("RCOM_CF_333_CDMA_Prepaid_IVR");
					Hashtable<String, Hashtable<String, ServiceUpdateInfo>> hashtable6 = IVRDBServiceInstance.getInstance().getServiceUpdationInfo(logger, serviceUpdateInfo);
					System.out.println(hashtable6);
					
					ServiceUpdateInfo serviceUpdateInfo1 = new ServiceUpdateInfo();
					serviceUpdateInfo1.setAppName("RCOM_CF_333_CDMA_Prepaid_IVR");
					serviceUpdateInfo1.setServiceName("HOTFLASH");
					serviceUpdateInfo1.setStatus("Y");
					serviceUpdateInfo1 = IVRDBServiceInstance.getInstance().updateServiceUpdationInfo(logger, serviceUpdateInfo1);
					System.out.println(serviceUpdateInfo1.getFlag());
					
					HotFlashInfo hotFlashInfo = new HotFlashInfo();
					hotFlashInfo.setAppName("RCOM_CF_555_Postpaid_IVR");
					Hashtable<String, Hashtable<String, HotFlashInfo>> hashtable5 = IVRDBServiceInstance.getInstance().getHotFlashInfo(logger, hotFlashInfo);
					System.out.println(hashtable5);
					
					StoreAddress storeAddress = new StoreAddress();
					storeAddress.setPinCode("626003");
					storeAddress = IVRDBServiceInstance.getInstance().getStoreAddress(
							objIVRDataBean, storeAddress);
					System.out.println(storeAddress.toString());
					
					OnlinePaymentCheck onlinePaymentCheck = new OnlinePaymentCheck();
					onlinePaymentCheck.setAppName("RCOM_CF_555_Postpaid_IVR");
					onlinePaymentCheck.setCircleId("TN");
					onlinePaymentCheck = IVRDBServiceInstance.getInstance().checkOnlinePaymentFlag(objIVRDataBean, onlinePaymentCheck);
					System.out.println(onlinePaymentCheck.toString());
					
					SRCInfo srcInfo = new SRCInfo();
					srcInfo.setMdn("9677981544");
					srcInfo = IVRDBServiceInstance.getInstance().updateSRC(objIVRDataBean,
								srcInfo);
					System.out.println((srcInfo.getFlag()).trim());
					
					IntelligentLayerInfo intelligentLayerInfo1 = new IntelligentLayerInfo();
					intelligentLayerInfo1.setAppName("RCOM_CF_BB_Enterprise_Desk_IVR");
					Hashtable<String, Hashtable<String, IntelligentLayerInfo>> hashtable11 = IVRDBServiceInstance.getInstance().getIntelligentLayerActiveStatus(logger, intelligentLayerInfo1);
					System.out.println(hashtable11);
	            }
	                
	        }
	    };

	    long start = System.nanoTime();
	    int runs = 100;
	    for (int i = 0; i < runs; i++)
	    {
	    	logger.debug("Starting Thread:"+i);
	    	new Thread(task).start();
	    	
	    }
	    

	    long time = System.nanoTime() - start;
	     System.out.printf("Time for task to complete: %.2f seconds", (double) time / 1000000000.0);*/
	 
	
		/*ApplicationContext ac=null;
		try{
			 ac= new ClassPathXmlApplicationContext("application-context.xml");
			 
			 IVRDBService ivrdbService = ac.getBean(IVRDBServiceImpl.class);
			 ivrdbService.getTestData("123456");
			 
		}catch(Exception e){
			e.printStackTrace();
		}
		*/
		
		/*HotFlashInfo hotFlashInfo = new HotFlashInfo();
		hotFlashInfo.setAppName("RCOM_CF_198_CDMA_PREPAID,RCOM_CF_198_GSM_PREPAID,RCOM_CF_333_CDMA_PREPAID,RCOM_CF_333_GSM_PREPAID,RTL_CF_198_GSM_PREPAID,RTL_CF_333_GSM_PREPAID");
		Hashtable<String, Hashtable<String, HotFlashInfo>> hashtable5 = IVRDBServiceInstance.getInstance().getHotFlashInfo(logger, hotFlashInfo);
		System.out.println(hashtable5);
		*/
		/*ServiceUpdateInfo serviceUpdateInfo = new ServiceUpdateInfo();
		serviceUpdateInfo.setAppName("RCOM_CF_198_CDMA_PREPAID,RCOM_CF_198_GSM_PREPAID,RCOM_CF_333_CDMA_PREPAID,RCOM_CF_333_GSM_PREPAID,RTL_CF_198_GSM_PREPAID,RTL_CF_333_GSM_PREPAID");
		Hashtable<String, Hashtable<String, ServiceUpdateInfo>> hashtable6 = IVRDBServiceInstance.getInstance().getServiceUpdationInfo(logger, serviceUpdateInfo);
		System.out.println(hashtable6);*/
		
		/*UpdateLanguage updateLanguage = new UpdateLanguage();
		updateLanguage.setLanguageCode("5");
		updateLanguage.setMdn("4552");
		updateLanguage = IVRDBServiceInstance.getInstance().updatePreferredLanguage(objIVRDataBean, updateLanguage);
		System.out.println(updateLanguage);*/
		
		/*IntelligentLayerInfo intelligentLayerInfo1 = new IntelligentLayerInfo();
		intelligentLayerInfo1.setAppName("RCOM_CF_198_CDMA_PREPAID,RCOM_CF_198_GSM_PREPAID,RCOM_CF_333_CDMA_PREPAID,RCOM_CF_333_GSM_PREPAID,RTL_CF_198_GSM_PREPAID,RTL_CF_333_GSM_PREPAID");
		Hashtable<String, Hashtable<String, IntelligentLayerInfo>> hashtable11 = IVRDBServiceInstance.getInstance().getIntelligentLayerActiveStatus(logger, intelligentLayerInfo1);
		System.out.println(hashtable11);*/
		
		/*CRMCountInfo crmCountInfo = new CRMCountInfo();
		crmCountInfo.setMdn("4567");
		crmCountInfo = IVRDBServiceInstance.getInstance().getCRMCountInfo(objIVRDataBean, crmCountInfo);
		System.out.println(crmCountInfo);*/
		
		/*IVRRoutingInfo ivrRoutingInfo = new IVRRoutingInfo();
		ivrRoutingInfo.setDnis("52585");
		ivrRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean, ivrRoutingInfo);
		System.out.println(ivrRoutingInfo.toString());*/
		
		IVRVasInfo info = new IVRVasInfo();
		info.setAppName("RCOM_CF_333_GSM_PREPAID");
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
		System.out.println("VAS Info" +hashtable);
		
		
		/*TariffChangeDetail tariffChangeDetail = new TariffChangeDetail();
		tariffChangeDetail.setMdn("4555");
		tariffChangeDetail.setCircleId("TN");
		tariffChangeDetail.setLanguageid("ENG");
		tariffChangeDetail = IVRDBServiceInstance.getInstance().getTariffChangeDetail(objIVRDataBean, tariffChangeDetail);
		System.out.println(tariffChangeDetail);*/
		
		/*CRMPackInfo crmPackInfo = new CRMPackInfo();
		crmPackInfo.setMdn("4434");
		crmPackInfo = IVRDBServiceInstance.getInstance().getCRMPackInfo(objIVRDataBean, crmPackInfo);
		System.out.println(crmPackInfo);*/
		
		/*CircleOffersInfo circleOffersInfo = new CircleOffersInfo();
		circleOffersInfo.setAppName("RCOM_CF_198_CDMA_PREPAID");
		circleOffersInfo.setOfferType("DATA");
		Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> hashtable3 = IVRDBServiceInstance.getInstance().getCircleOffers(logger, circleOffersInfo);
		System.out.println(hashtable3);*/
		
		/*RechargePlanInfo rechargePlanInfo = new RechargePlanInfo();
		rechargePlanInfo.setAppName("RCOM_CF_198_CDMA_PREPAID");
		Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> hashtable2 = IVRDBServiceInstance.getInstance().getRechargePlan(logger, rechargePlanInfo);
		System.out.println(hashtable2);*/
		
		/*OnlinePaymentCheck onlinePaymentCheck = new OnlinePaymentCheck();
		onlinePaymentCheck.setAppName("RCOM_CF_198_CDMA_PREPAID");
		onlinePaymentCheck.setCircleId("TN");
		onlinePaymentCheck = IVRDBServiceInstance.getInstance().checkOnlinePaymentFlag(objIVRDataBean, onlinePaymentCheck);
		System.out.println(onlinePaymentCheck.toString());*/
		
		/*MDNOfferInfo mdnOfferInfo = new MDNOfferInfo();
		mdnOfferInfo.setAppName("123");
		mdnOfferInfo.setCircleId("TN");
		mdnOfferInfo.setLanguage("ENG");
		mdnOfferInfo.setOfferType("DATA");
		mdnOfferInfo.setOfferCode("Off136");
		mdnOfferInfo = IVRDBServiceInstance.getInstance().getMDNSpecificOffers(objIVRDataBean, mdnOfferInfo);
		System.out.println(mdnOfferInfo);*/
		
		/*IVRVasInfo info = new IVRVasInfo();
		info.setAppName("RCOM_CF_198_CDMA_Prepaid");
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
		System.out.println(hashtable);*/
		
		CRMCountInfo crmCountInfo = new CRMCountInfo();
		crmCountInfo.setMdn("9543027347");
		crmCountInfo = IVRDBServiceInstance.getInstance().getCRMCountInfo(objIVRDataBean, crmCountInfo);
		System.out.println(crmCountInfo);
		
		/*IVRCspInfo ivrCspInfo = new IVRCspInfo(); 
		ivrCspInfo.setMdn("9025714681");
		ivrCspInfo = IVRDBServiceInstance.getInstance().getIVRCSPInfo(objIVRDataBean, ivrCspInfo);
		System.out.println(ivrCspInfo.toString());*/
		
		/*SRCInfo srcInfo = new SRCInfo();
		srcInfo.setMdn("9322662338");
		srcInfo = IVRDBServiceInstance.getInstance().updateSRC(objIVRDataBean,
					srcInfo);
		System.out.println((srcInfo.getFlag()).trim());*/
		
		/*SRCInfo srcInfo = new SRCInfo();
		srcInfo.setMdn("9322662338");
		srcInfo.setCircleId("MU");
		srcInfo.setAppname("RCOM_CF_198_CDMA_PREPAID");
		srcInfo = IVRDBServiceInstance.getInstance().checkSRCFlag(objIVRDataBean, srcInfo);
				//updateSRC(objIVRDataBean,	srcInfo);
		System.out.println((srcInfo.getFlag()).trim());*/
		
		/*OnlinePaymentCheck onlinePaymentCheck = new OnlinePaymentCheck();
		onlinePaymentCheck.setAppName("RCOM_CF_198_Prepaid");
		onlinePaymentCheck.setCircleId("MU");
		onlinePaymentCheck = IVRDBServiceInstance.getInstance().checkOnlinePaymentFlag(objIVRDataBean, onlinePaymentCheck);
		System.out.println(onlinePaymentCheck.toString());*/
		
	}

}
