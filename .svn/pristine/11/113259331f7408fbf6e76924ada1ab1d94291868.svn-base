package com.rcom.postpaid.daoservice;

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
	
	/**
	 * 
	 * @param dataBean
	 * @param dobInfo
	 * @return DOBInfo
	 */
	DOBInfo getDOBInfoFromDB(IVRDataBean dataBean, DOBInfo dobInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param barringInfo
	 * @return BarringInfo
	 */
	BarringInfo getBarringInfofromDB(IVRDataBean dataBean, BarringInfo barringInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param promiseToPayInfo
	 * @return PromiseToPayInfo
	 */
	PromiseToPayInfo getPromiseToPayInfoFromDB(IVRDataBean dataBean, PromiseToPayInfo promiseToPayInfo);
	
	/**
	 * 
	 * @param dataBean
	 * @param postpaidCRMCountInfo
	 * @return PostpaidCRMCountInfo
	 */
	PostpaidCRMCountInfo getPostpaidCRMCountInfoFromDB(IVRDataBean dataBean, PostpaidCRMCountInfo postpaidCRMCountInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param dndInfo
	 * @return DNDInfo
	 */
	DNDInfo getDNDInfoFromDB(IVRDataBean ivrDataBean, DNDInfo dndInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param validateMobileNumber
	 * @return
	 */
	ValidateMobileNumber validateMDNFromDB(IVRDataBean ivrDataBean, ValidateMobileNumber validateMobileNumber);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param registerCallBack
	 * @return
	 */
	RegisterCallBack registerCallBackToDB(IVRDataBean ivrDataBean, RegisterCallBack registerCallBack);
	
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
	 * @param MDNhotflash
	 * @return MDNHotFlashInfo
	 */
	 
	MDNHotFlashInfo checkMDNHotFlagFromDB(IVRDataBean objIVRDataBean,MDNHotFlashInfo MDNhotflash);
	
	
				/**
				 * 
				 * @param objIVRDataBean
				 * @param LowARPU
				 * @return LowARPUInfo
				 */
		LowARPUInfo checkLowARPUInfoFromDB(IVRDataBean objIVRDataBean,LowARPUInfo LowARPU);
}
