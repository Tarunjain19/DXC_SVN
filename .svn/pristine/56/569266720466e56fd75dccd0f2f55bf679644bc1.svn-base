package com.rcom.prepaid.daoservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.rcom.prepaid.model.CRMCountInfo;
import com.rcom.prepaid.model.CRMPackInfo;
import com.rcom.prepaid.model.CircleOffersInfo;
import com.rcom.prepaid.model.FourGHardCodeInfo;
import com.rcom.prepaid.model.GPRSSRCInfo;
import com.rcom.prepaid.model.HotFlashInfo;
import com.rcom.prepaid.model.IVRCspInfo;
import com.rcom.prepaid.model.IVRRoutingInfo;
import com.rcom.prepaid.model.IVRVasInfo;
import com.rcom.prepaid.model.IntelligentLayerInfo;
import com.rcom.prepaid.model.MDNHotFlashInfo;
import com.rcom.prepaid.model.MDNOfferInfo;
import com.rcom.prepaid.model.OnlinePaymentCheck;
import com.rcom.prepaid.model.PushSMSInfo;
import com.rcom.prepaid.model.RechargePlanInfo;
import com.rcom.prepaid.model.SRCInfo;
import com.rcom.prepaid.model.ServiceUpdateInfo;
import com.rcom.prepaid.model.SpecialTariffInfo;
import com.rcom.prepaid.model.StoreAddress;
import com.rcom.prepaid.model.TariffChangeDetail;
import com.rcom.prepaid.model.TransferVDNInfo;
import com.rcom.prepaid.model.UpdateLanguage;
import com.rcom.prepaid.model.LowARPUInfo;

import com.servion.util.IVRDataBean;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */
public interface IVRDBDaoService {
	
	//Test method
	String getDBData(String strTestData);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrRoutingInfo
	 * @return IVRRoutingInfo
	 */
	IVRRoutingInfo getIVRRoutingInfoDB(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param onlinePaymentCheck
	 * @return OnlinePaymentCheck
	 */
	OnlinePaymentCheck checkOnlinePaymentFlagFromDB(IVRDataBean objIVRDataBean,OnlinePaymentCheck onlinePaymentCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param fetchVasURL
	 * @return VasRequestURLInfo
	 */
	//VasRequestURLInfo getVASRequestURLFromDB(IVRDataBean objIVRDataBean,VasRequestURLInfo fetchVasURL);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return TransferVDNInfo
	 */
	TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,TransferVDNInfo transferVDNInfo);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param storeAddress
	 * @return StoreAddress
	 */
	StoreAddress getStoreAddressFromDB(IVRDataBean objIVRDataBean,StoreAddress storeAddress);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param updateLanguage
	 * @return UpdateLanguage
	 */
	UpdateLanguage updatePreferredLanguage(IVRDataBean objIVRDataBean,UpdateLanguage updateLanguage);
		
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo updateSRCToDB(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo checkSRCFlagFromDB(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrCspInfo
	 * @return IVRCspInfo
	 */
	IVRCspInfo getIVRCSPInfoFromDB(IVRDataBean objIVRDataBean, IVRCspInfo ivrCspInfo);
	
	/**
	 * 
	 * @param logger
	 * @param intelligentLayerInfo
	 * @return Hashtable<String, Hashtable<String, IntelligentLayerInfo>>
	 */
	Hashtable<String, Hashtable<String, IntelligentLayerInfo>> getIntelligentLayerActiveStatusFromDB(Logger logger,IntelligentLayerInfo intelligentLayerInfo);
	
	/**
	 * 
	 * @param logger
	 * @param specialTariffInfo
	 * @return Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> getSpecialTarifInfoFromDB(Logger logger,SpecialTariffInfo specialTariffInfo);
	
	/**
	 * 
	 * @param logger
	 * @param rechargePlanInfo
	 * @return Hashtable<String, Hashtable<String, List<RechargePlanInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> getRechargePlanFromDB(Logger logger,RechargePlanInfo rechargePlanInfo);
	
	/**
	 * 
	 * @param logger
	 * @param circleDataOffers
	 * @return Hashtable<String, Hashtable<String, List<CircleOffersInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> getCircleOffersFromDB(Logger logger,CircleOffersInfo circleDataOffers);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param specificDataOffer
	 * @return MDNOfferInfo
	 */
	MDNOfferInfo getMDNSpecificOffersFromDB(IVRDataBean objIVRDataBean,MDNOfferInfo specificDataOffer);
	
	/**
	 * 
	 * @param logger
	 * @param serviceUpdateInfo
	 * @return Hashtable<String, Hashtable<String, ServiceUpdateInfo>>
	 */
	Hashtable<String, Hashtable<String, ServiceUpdateInfo>> getServiceUpdationInfoFromDB(Logger logger,ServiceUpdateInfo serviceUpdateInfo);
	
	/**
	 * 
	 * @param logger
	 * @param serviceUpdateInfo
	 * @return ServiceUpdateInfo
	 */
	ServiceUpdateInfo updateServiceUpdationInfoToDB(Logger logger,ServiceUpdateInfo serviceUpdateInfo);
	
	/**
	 * 
	 * @param logger
	 * @param hotFlashInfo
	 * @return Hashtable<String, Hashtable<String, HotFlashInfo>>
	 */
	Hashtable<String, Hashtable<String, HotFlashInfo>> getHotFlashInfoDB(Logger logger, HotFlashInfo hotFlashInfo);

	/**
	 * 
	 * @param objIVRDataBean
	 * @param vasDetails
	 * @return Hashtable<String, Hashtable<String, List<IVRVasInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<IVRVasInfo>>> getVASDetailsFromDB(Logger logger,IVRVasInfo vasDetails);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param tariffChangeDetail
	 * @return
	 */
	TariffChangeDetail getTariffChangeDetailFromDB(IVRDataBean ivrDataBean, TariffChangeDetail tariffChangeDetail);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param crmCountInfo
	 * @return
	 */
	CRMCountInfo getCRMCountInfoFromDB(IVRDataBean ivrDataBean, CRMCountInfo crmCountInfo);
	
	/**
	 * 
	 * @param logger
	 * @param pushSMSInfo
	 * @return
	 */
	Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfoFromDB(Logger logger, PushSMSInfo pushSMSInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param crmPackInfo
	 * @return
	 */
	CRMPackInfo getCRMPackInfoFromDB(IVRDataBean dataBean, CRMPackInfo crmPackInfo);
	
	

	// Add by Tarun For GPRS Barring
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param GPRSsrcCheck
	 * @return GPRSSRCInfo
	 */
	GPRSSRCInfo checkGPRSSRCFlagFromDB(IVRDataBean objIVRDataBean,GPRSSRCInfo GPRSsrcCheck);
	
	
	// Add  MDN HOT FLASH Logic  By Tarun on 8 Dec
	
		/**
		 * 
		 * @param objIVRDataBean
		 * @param MDNhotflash
		 * @return MDNHotFlashInfo
		 */
	MDNHotFlashInfo checkMDNHotFlagFromDB(IVRDataBean objIVRDataBean,MDNHotFlashInfo MDNhotflash);
	
	
	// Add  LowARPU Logic  By Rahul on 17 Mar16
	
			/**
			 * 
			 * @param objIVRDataBean
			 * @param LowARPU
			 * @return LowARPUInfo
			 */
	LowARPUInfo checkLowARPUInfoFromDB(IVRDataBean objIVRDataBean,LowARPUInfo LowARPU);
	
	
	
	//-------------4G HARD CODE for RCOM_CF_4GSIM_IVR on 09/01/2016-------
	
				/**
				 * 
				 * @param objIVRDataBean
				 * @param HardCode
				 * @return FourGHardCodeInfo
				 */
	FourGHardCodeInfo checkHardCodeFromDB(IVRDataBean objIVRDataBean,FourGHardCodeInfo HardCode);
	
	
}
