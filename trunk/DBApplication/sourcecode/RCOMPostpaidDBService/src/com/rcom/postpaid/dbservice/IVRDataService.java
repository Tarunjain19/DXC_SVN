package com.rcom.postpaid.dbservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;

import com.rcom.postpaid.model.BarringInfo;
import com.rcom.postpaid.model.CRMPackInfo;
import com.rcom.postpaid.model.CircleOffersInfo;
import com.rcom.postpaid.model.DNDInfo;
import com.rcom.postpaid.model.DOBInfo;
import com.rcom.postpaid.model.HotFlashInfo;
import com.rcom.postpaid.model.IVRCspInfo;
import com.rcom.postpaid.model.IVRRoutingInfo;
import com.rcom.postpaid.model.IVRVasInfo;
import com.rcom.postpaid.model.IntelligentLayerInfo;
import com.rcom.postpaid.model.MDNOfferInfo;
import com.rcom.postpaid.model.OnlinePaymentCheck;
import com.rcom.postpaid.model.PostpaidCRMCountInfo;
import com.rcom.postpaid.model.PromiseToPayInfo;
import com.rcom.postpaid.model.PushSMSInfo;
import com.rcom.postpaid.model.RechargePlanInfo;
import com.rcom.postpaid.model.RegisterCallBack;
import com.rcom.postpaid.model.SRCInfo;
import com.rcom.postpaid.model.ServiceUpdateInfo;
import com.rcom.postpaid.model.SpecialTariffInfo;
import com.rcom.postpaid.model.StoreAddress;
import com.rcom.postpaid.model.TariffChangeDetail;
import com.rcom.postpaid.model.TransferVDNInfo;
import com.rcom.postpaid.model.UpdateLanguage;
import com.rcom.postpaid.model.ValidateCWG;
import com.rcom.postpaid.model.ValidateMobileNumber;
import com.rcom.postpaid.model.MDNHotFlashInfo;
import com.rcom.postpaid.model.LowARPUInfo;
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

	/**
	 * 
	 * @param dataBean
	 * @param dobInfo
	 * @return DOBInfo
	 */
	DOBInfo getDOBInfo(IVRDataBean dataBean, DOBInfo dobInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param barringInfo
	 * @return BarringInfo
	 */
	BarringInfo getBarringInfo(IVRDataBean dataBean, BarringInfo barringInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param promiseToPayInfo
	 * @return PromiseToPayInfo
	 */
	PromiseToPayInfo getPromiseToPayInfo(IVRDataBean dataBean, PromiseToPayInfo promiseToPayInfo);
	
	
	/**
	 * 
	 * @param dataBean
	 * @param postpaidCRMCountInfo
	 * @return PostpaidCRMCountInfo
	 */
	PostpaidCRMCountInfo getPostpaidCRMCountInfo(IVRDataBean dataBean, PostpaidCRMCountInfo postpaidCRMCountInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param dndInfo
	 * @return DNDInfo
	 */
	DNDInfo getDNDInfo(IVRDataBean ivrDataBean, DNDInfo dndInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param validateMobileNumber
	 * @return
	 */
	ValidateMobileNumber validateMDN(IVRDataBean ivrDataBean, ValidateMobileNumber validateMobileNumber);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param registerCallBack
	 * @return
	 */
	RegisterCallBack registerCallBack(IVRDataBean ivrDataBean, RegisterCallBack registerCallBack);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param validateCWG
	 * @return
	 */
	ValidateCWG validateCWGFlag(IVRDataBean ivrDataBean, ValidateCWG validateCWG);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param MDNHotFlashInfo
	 * @return MDNHotFlashInfo
	 */
	MDNHotFlashInfo checkMDNHotFlashFlag(IVRDataBean objIVRDataBean,MDNHotFlashInfo MDNhotflash);
	
			/**
			 * 
			 * @param objIVRDataBean
			 * @param MDNHotFlashInfo
			 * @return MDNHotFlashInfo
			 */
			LowARPUInfo checkLowARPUInfoFlag(IVRDataBean objIVRDataBean,LowARPUInfo LowARPU);
}
