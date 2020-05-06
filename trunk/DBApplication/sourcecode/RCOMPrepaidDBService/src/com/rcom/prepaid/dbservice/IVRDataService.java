package com.rcom.prepaid.dbservice;

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

public interface IVRDataService {
	
	//Test method
	String getTestData(String strTestdata);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrRoutingInfo
	 * @return IVRRoutingInfo
	 */
	IVRRoutingInfo getIVRRoutingInfo(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrCspInfo
	 * @return IVRCspInfo
	 */
	IVRCspInfo getIVRCSPInfo(IVRDataBean objIVRDataBean, IVRCspInfo ivrCspInfo);
	
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
	 * @param vasDetails
	 * @return Hashtable<String, Hashtable<String, List<IVRVasInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<IVRVasInfo>>> getVASDetails(Logger logger,IVRVasInfo vasDetails);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param specificDataOffer
	 * @return Hashtable<String, Hashtable<String, List<MDNOfferInfo>>>
	 */
	MDNOfferInfo getMDNSpecificOffers(IVRDataBean objIVRDataBean,MDNOfferInfo specificDataOffer);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param storeAddress
	 * @return StoreAddress
	 */
	StoreAddress getStoreAddress(IVRDataBean objIVRDataBean,StoreAddress storeAddress);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param onlinePaymentCheck
	 * @return OnlinePaymentCheck
	 */
	OnlinePaymentCheck checkOnlinePaymentFlag(IVRDataBean objIVRDataBean,OnlinePaymentCheck onlinePaymentCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return TransferVDNInfo
	 */
	TransferVDNInfo getTransferVDN(IVRDataBean objIVRDataBean,TransferVDNInfo transferVDNInfo);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo checkSRCFlag(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo updateSRC(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	/**
	 * 
	 * @param logger
	 * @param intelligentLayerInfo
	 * @return Hashtable<String, Hashtable<String, IntelligentLayerInfo>>
	 */
	Hashtable<String, Hashtable<String, IntelligentLayerInfo>> getIntelligentLayerActiveStatus(Logger logger,IntelligentLayerInfo intelligentLayerInfo);
	
	/**
	 * 
	 * @param logger
	 * @param rechargePlanInfo
	 * @return Hashtable<String, Hashtable<String, List<RechargePlanInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> getRechargePlan(Logger logger,RechargePlanInfo rechargePlanInfo);
	
	/**
	 * 
	 * @param logger
	 * @param specialTariffInfo
	 * @return Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> getSpecialTarifInfo(Logger logger,SpecialTariffInfo specialTariffInfo);
	
	/**
	 * 
	 * @param logger
	 * @param serviceUpdateInfo
	 * @return Hashtable<String, Hashtable<String, ServiceUpdateInfo>>
	 */
	Hashtable<String, Hashtable<String, ServiceUpdateInfo>> getServiceUpdationInfo(Logger logger,ServiceUpdateInfo serviceUpdateInfo);
	
	/**
	 * 
	 * @param logger
	 * @param serviceUpdateInfo
	 * @return ServiceUpdateInfo
	 */
	ServiceUpdateInfo updateServiceUpdationInfo(Logger logger,ServiceUpdateInfo serviceUpdateInfo);
	
	/**
	 * 
	 * @param logger
	 * @param hotFlashInfo
	 * @return Hashtable<String, Hashtable<String, HotFlashInfo>>
	 */
	Hashtable<String, Hashtable<String, HotFlashInfo>> getHotFlashInfo(Logger logger,HotFlashInfo hotFlashInfo);
	
	/**
	 * 
	 * @param logger
	 * @param circleDataOffers
	 * @return Hashtable<String, Hashtable<String, List<CircleOffersInfo>>>
	 */
	Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> getCircleOffers(Logger logger,CircleOffersInfo circleDataOffers);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param tariffChangeDetail
	 * @return
	 */
	TariffChangeDetail getTariffChangeDetail(IVRDataBean ivrDataBean, TariffChangeDetail tariffChangeDetail);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param crmCountInfo
	 * @return
	 */
	CRMCountInfo getCRMCountInfo(IVRDataBean ivrDataBean, CRMCountInfo crmCountInfo);
	
	/**
	 * 
	 * @param logger
	 * @param pushSMSInfo
	 * @return
	 */
	Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfo(Logger logger, PushSMSInfo pushSMSInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param crmPackInfo
	 * @return
	 */
	CRMPackInfo getCRMPackInfo(IVRDataBean dataBean, CRMPackInfo crmPackInfo);
	
	// Add  GPRS Barring  By Tarun
	
		/**
		 * 
		 * @param objIVRDataBean
		 * @param GPRSsrcCheck
		 * @return GPRSSRCInfo
		 */
		GPRSSRCInfo checkGPRSSRCFlag(IVRDataBean objIVRDataBean,GPRSSRCInfo GPRSsrcCheck);
		
		
		// Add  MDN HOT FLASH Logic  By Tarun on 8 Dec
		
			/**
			 * 
			 * @param objIVRDataBean
			 * @param MDNHotFlashInfo
			 * @return MDNHotFlashInfo
			 */
		MDNHotFlashInfo checkMDNHotFlashFlag(IVRDataBean objIVRDataBean,MDNHotFlashInfo MDNhotflash);
		
	
		// Add  MDN HOT FLASH Logic  By Rahul on 29Mar16
		
		/**
		 * 
		 * @param objIVRDataBean
		 * @param MDNHotFlashInfo
		 * @return MDNHotFlashInfo
		 */
		LowARPUInfo checkLowARPUInfoFlag(IVRDataBean objIVRDataBean,LowARPUInfo LowARPU);	
		
		
		//-------------4G HARD CODE for RCOM_CF_4GSIM_IVR on 09/01/2016-------
		
				/**
				 * 
				 * @param objIVRDataBean
				 * @param HardCode
				 * @return FourGHardCodeInfo
				 */
		FourGHardCodeInfo checkHardCodeFlag(IVRDataBean objIVRDataBean,FourGHardCodeInfo HardCode);

}
