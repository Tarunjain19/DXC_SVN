package com.rcom.postpaid.test;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.rcom.postpaid.model.IVRCspInfo;
import com.rcom.postpaid.model.IVRVasInfo;
import com.rcom.postpaid.model.LowARPUInfo;
import com.rcom.postpaid.model.ValidateCWG;
import com.rcom.postpaid.resource.IVRDBServiceInstance;
import com.servion.util.IVRDataBean;

public class Test {
	
	private static Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		
		final IVRDataBean objIVRDataBean = new IVRDataBean();
		objIVRDataBean.setLogger(logger);
		objIVRDataBean.setSessionID("Thread");
		/*IVRRoutingInfo ivrRoutingInfo = new IVRRoutingInfo();
		ivrRoutingInfo.setDnis("52535");
		ivrRoutingInfo = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean, ivrRoutingInfo);
		System.out.println(ivrRoutingInfo.toString());
		
		
		
		IVRRoutingInfo ivrRoutingInfo1 = new IVRRoutingInfo();
		ivrRoutingInfo1.setDnis("52532");
		ivrRoutingInfo1 = IVRDBServiceInstance.getInstance().getIVRRoutingInfo(objIVRDataBean, ivrRoutingInfo1);
		System.out.println(ivrRoutingInfo1.toString());*/
		
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
		info.setAppName("RCOM_CF_222_GSM_POSTPAID");
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
		System.out.println(hashtable);
		
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
		mdnOfferInfo.setAppName("RCOM_CF_222_CDMA_Postpaid");
		mdnOfferInfo.setCircleId("TN");
		mdnOfferInfo.setLanguage("ENG");
		mdnOfferInfo.setOfferType("DATA");
		mdnOfferInfo.setOfferCode("345345");
		mdnOfferInfo = IVRDBServiceInstance.getInstance().getMDNSpecificOffers(objIVRDataBean, mdnOfferInfo);
		System.out.println(mdnOfferInfo);
		
		IVRCspInfo ivrCspInfo = new IVRCspInfo();
		ivrCspInfo.setMdn("4556");
		ivrCspInfo = IVRDBServiceInstance.getInstance().getIVRCSPInfo(objIVRDataBean, ivrCspInfo);
		System.out.println(ivrCspInfo.toString());*/
		
		/*DOBInfo dobInfo = new DOBInfo();
		dobInfo.setMdn("4553");
		dobInfo = IVRDBServiceInstance.getInstance().getDOBInfo(objIVRDataBean, dobInfo);
		System.out.println(dobInfo.toString());*/
		
		/*BarringInfo barringInfo = new BarringInfo();
		barringInfo.setMdn("");
		barringInfo = IVRDBServiceInstance.getInstance().getBarringInfo(objIVRDataBean, barringInfo);
		System.out.println(barringInfo.toString());*/
		
		/*ValidateMobileNumber validateMobileNumber = new ValidateMobileNumber();
		validateMobileNumber.setMdn("9600301098");
		validateMobileNumber = IVRDBServiceInstance.getInstance().validateMDN(objIVRDataBean, validateMobileNumber);
		System.out.println(validateMobileNumber);
		
		if(((validateMobileNumber.getServiceType()).contains("POSTPAID"))||((validateMobileNumber.getServiceType()).contains("postpaid")))
			System.out.println("postpaid number");*/
		/*PromiseToPayInfo promiseToPayInfo = new PromiseToPayInfo();
		promiseToPayInfo.setMdn("4553");
		promiseToPayInfo = IVRDBServiceInstance.getInstance().getPromiseToPayInfo(objIVRDataBean, promiseToPayInfo);
		System.out.println(promiseToPayInfo.toString());
		
		PostpaidCRMCountInfo postpaidCRMCountInfo = new PostpaidCRMCountInfo();
		postpaidCRMCountInfo.setMdn("4553");
		postpaidCRMCountInfo = IVRDBServiceInstance.getInstance().getPostpaidCRMCountInfo(objIVRDataBean, postpaidCRMCountInfo);
		System.out.println(postpaidCRMCountInfo.toString());
		
		DNDInfo dndInfo = new DNDInfo();
		dndInfo.setMdn("4553");
		dndInfo = IVRDBServiceInstance.getInstance().getDNDInfo(objIVRDataBean, dndInfo);
		System.out.println(dndInfo.toString());*/
		
		/*PushSMSInfo pushSMSInfo = new PushSMSInfo();
		pushSMSInfo.setAppName("RCOM_CF_222_HNI_3G_CDMA_POSTPAID");
		Hashtable<String, Hashtable<String, PushSMSInfo>> hashtablePushSMS = IVRDBServiceInstance.getInstance().getPushSMSInfo(logger, pushSMSInfo);
		System.out.println(hashtablePushSMS);*/
	
		/*PostpaidCRMCountInfo postpaidCRMCountInfo = new PostpaidCRMCountInfo();
		postpaidCRMCountInfo.setMdn("8144166673");
		postpaidCRMCountInfo = IVRDBServiceInstance.getInstance().getPostpaidCRMCountInfo(objIVRDataBean, postpaidCRMCountInfo);
		System.out.println(postpaidCRMCountInfo.toString());*/
		
		/*IVRVasInfo info = new IVRVasInfo();
		info.setAppName("RCOM_CF_222_HNI_3G_CDMA_POSTPAID");
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
		System.out.println(hashtable);*/
		
		/*RegisterCallBack registerCallBack = new RegisterCallBack();
		
		registerCallBack.setApplicationName("POSTPAID");
		registerCallBack.setCategory("POSTPAID");
		registerCallBack.setCircle("MU");
		registerCallBack.setLangugage("ENG");
		registerCallBack.setMdn("8144166673");
		
		registerCallBack = IVRDBServiceInstance.getInstance().registerCallBack(objIVRDataBean, registerCallBack);
		System.out.println(registerCallBack);*/
		//[AppName:RCOM_CF_222_HNI_3G_CDMA_POSTPAID, CircleId:MU, Language:ENG, OfferType:DATA, OfferCode:null, Status:null, OfferCategoryPhrase:null, OfferDetailPhrase:null, Campaignname:C_JD_DUMMY_JUNE, MenuOptions:null]
		/*MDNOfferInfo mdnOfferInfo = new MDNOfferInfo();
		mdnOfferInfo.setAppName("RCOM_CF_222_HNI_3G_CDMA_POSTPAID");
		mdnOfferInfo.setCircleId("MU");
		mdnOfferInfo.setLanguage("ENG");
		mdnOfferInfo.setCampaignname("C_JD_DUMMY_JUNE");
		mdnOfferInfo.setOfferType("DATA");
		mdnOfferInfo = IVRDBServiceInstance.getInstance().getMDNSpecificOffers(objIVRDataBean, mdnOfferInfo);
		System.out.println(mdnOfferInfo);*/
		
		/*IVRCspInfo ivrCspInfo = new IVRCspInfo();
		ivrCspInfo.setMdn("8144166673");
		ivrCspInfo = IVRDBServiceInstance.getInstance().getIVRCSPInfo(objIVRDataBean, ivrCspInfo);
		System.out.println(ivrCspInfo.toString());*/
		
		/*PromiseToPayInfo promiseToPayInfo = new PromiseToPayInfo();
		promiseToPayInfo.setMdn("9322662338");
		promiseToPayInfo = IVRDBServiceInstance.getInstance().getPromiseToPayInfo(objIVRDataBean, promiseToPayInfo);
		System.out.println(promiseToPayInfo.toString());*/
		
		/*IVRVasInfo info = new IVRVasInfo();
		info.setAppName("RCOM_CF_BB_Corporate_Desk_IVR");
		Hashtable<String, Hashtable<String, List<IVRVasInfo>>> hashtable = IVRDBServiceInstance.getInstance().getVASDetails(logger, info);
		System.out.println(hashtable);*/
		
		ValidateCWG validateCWG = new ValidateCWG();
		validateCWG.setMdn("9600301098");
		validateCWG = IVRDBServiceInstance.getInstance().validateCWGFlag(objIVRDataBean, validateCWG);
		System.out.println(validateCWG);
		
		LowARPUInfo lowARPUInfo = new LowARPUInfo();
		lowARPUInfo.setMdn("2230340133");
		lowARPUInfo = IVRDBServiceInstance.getInstance().checkLowARPUInfoFlag(objIVRDataBean, lowARPUInfo);
		System.out.println(lowARPUInfo);
		
	}

}
