package com.rcom.prepaid.daoservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcom.prepaid.dao.impl.IVRDBDaoRepository;
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

@Service
@Transactional
public class IVRDBDaoServiceImpl implements IVRDBDaoService{

	//@Autowired
	private IVRDBDaoRepository daoRepository;
	
	public IVRDBDaoRepository getDaoRepository() {
		return daoRepository;
	}

	public void setDaoRepository(IVRDBDaoRepository daoRepository) {
		this.daoRepository = daoRepository;
	}
	
	@Override
	public String getDBData(String strTestData) {
		return getDaoRepository().doTest(strTestData);
	}

	@Override
	public IVRRoutingInfo getIVRRoutingInfoDB(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo) {
		
		return getDaoRepository().queryRoutingTable(objIVRDataBean, ivrRoutingInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, HotFlashInfo>> getHotFlashInfoDB(Logger logger, HotFlashInfo hotFlashInfo) {
		
		return getDaoRepository().queryHotFlashTable(logger,hotFlashInfo);
	}

	@Override
	public OnlinePaymentCheck checkOnlinePaymentFlagFromDB(IVRDataBean objIVRDataBean,
			OnlinePaymentCheck onlinePaymentCheck) {
		return getDaoRepository().queryOnlinePaymentTable(objIVRDataBean, onlinePaymentCheck);
	}

/*	@Override
	public VasRequestURLInfo getVASRequestURLFromDB(IVRDataBean objIVRDataBean,
			VasRequestURLInfo fetchVasURL) {
		return getDaoRepository().queryStopStartServicesTable(objIVRDataBean,fetchVasURL);
	}
*/
	@Override
	public TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		return getDaoRepository().queryTransferVDNTable(objIVRDataBean,transferVDNInfo);
	}

	@Override
	public StoreAddress getStoreAddressFromDB(IVRDataBean objIVRDataBean,
			StoreAddress storeAddress) {
		return getDaoRepository().queryStoreDetailTable(objIVRDataBean,storeAddress);
	}

	@Override
	public UpdateLanguage updatePreferredLanguage(IVRDataBean objIVRDataBean,
			UpdateLanguage updateLanguage) {
		return getDaoRepository().queryUpdateLanguageTable(objIVRDataBean,updateLanguage);
	}

	@Override
	public SRCInfo updateSRCToDB(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		return getDaoRepository().updateSRCount(objIVRDataBean,srcCheck);
	}

	@Override
	public SRCInfo checkSRCFlagFromDB(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		return getDaoRepository().querySRCInfoTable(objIVRDataBean,srcCheck);
	}


	@Override
	public IVRCspInfo getIVRCSPInfoFromDB(IVRDataBean objIVRDataBean, IVRCspInfo ivrCspInfo) {
		return getDaoRepository().queryCSPTable(objIVRDataBean, ivrCspInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, IntelligentLayerInfo>> getIntelligentLayerActiveStatusFromDB(
			Logger logger, IntelligentLayerInfo intelligentLayerInfo) {
		return getDaoRepository().queryIntelligentLayerInfo(logger, intelligentLayerInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> getSpecialTarifInfoFromDB(
			Logger logger, SpecialTariffInfo specialTariffInfo) {
		return getDaoRepository().querySpecialTariffInfo(logger, specialTariffInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> getRechargePlanFromDB(
			Logger logger, RechargePlanInfo rechargePlanInfo) {
		return getDaoRepository().queryRechargePlanInfo(logger, rechargePlanInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> getCircleOffersFromDB(
			Logger logger, CircleOffersInfo circleOffersInfo) {
		return getDaoRepository().queryApplicationOfferInfo(logger, circleOffersInfo);
	}

	@Override
	public MDNOfferInfo getMDNSpecificOffersFromDB(
			IVRDataBean objIVRDataBean, MDNOfferInfo mdnOfferInfo) {
		return getDaoRepository().queryMDNOfferInfo(objIVRDataBean, mdnOfferInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, ServiceUpdateInfo>> getServiceUpdationInfoFromDB(
			Logger logger, ServiceUpdateInfo serviceUpdateInfo) {
		return getDaoRepository().queryserviceUpdateInfo(logger, serviceUpdateInfo);
	}

	@Override
	public ServiceUpdateInfo updateServiceUpdationInfoToDB(Logger logger,
			ServiceUpdateInfo serviceUpdateInfo) {
		return getDaoRepository().updateServiceUpdateInfo(logger, serviceUpdateInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, List<IVRVasInfo>>> getVASDetailsFromDB(
			Logger logger, IVRVasInfo vasDetails) {
		return getDaoRepository().queryIVRVASInfo(logger, vasDetails);
	}

	@Override
	public TariffChangeDetail getTariffChangeDetailFromDB(
			IVRDataBean ivrDataBean, TariffChangeDetail tariffChangeDetail) {
		return getDaoRepository().queryTariffChangeInfo(ivrDataBean, tariffChangeDetail);
	}

	@Override
	public CRMCountInfo getCRMCountInfoFromDB(IVRDataBean ivrDataBean,
			CRMCountInfo crmCountInfo) {
		return getDaoRepository().queryCRMCountInfo(ivrDataBean, crmCountInfo);
	}

	@Override
	public Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfoFromDB(
			Logger logger, PushSMSInfo pushSMSInfo) {
		return getDaoRepository().queryPushSMSInfo(logger, pushSMSInfo);
	}

	@Override
	public CRMPackInfo getCRMPackInfoFromDB(IVRDataBean dataBean,
			CRMPackInfo crmPackInfo) {
		return getDaoRepository().queryCRMPackInfo(dataBean, crmPackInfo);
	}
	// Add By Tarun Gprs barring
	
	@Override
	public GPRSSRCInfo checkGPRSSRCFlagFromDB(IVRDataBean objIVRDataBean, GPRSSRCInfo GPRSsrcCheck) {
		return getDaoRepository().queryGPRSSRCInfoTable(objIVRDataBean,GPRSsrcCheck);
	}

	// Add  MDN HOT FLASH Logic  By Tarun on 8 Dec
	
	@Override
	public MDNHotFlashInfo checkMDNHotFlagFromDB(IVRDataBean objIVRDataBean, MDNHotFlashInfo MDNhotflash) {
		return getDaoRepository().queryMDNHotFlashTable(objIVRDataBean,MDNhotflash);
	}
	
	//Add  LowARPU Logic  By Rahul on 17 Mar16
	
	@Override
	public LowARPUInfo checkLowARPUInfoFromDB(IVRDataBean objIVRDataBean, LowARPUInfo LowARPU) {
		return getDaoRepository().queryLowARPU(objIVRDataBean, LowARPU);
		
	}
	
	//-------------4G HARD CODE for RCOM_CF_4GSIM_IVR on 09/01/2016-------
	
	@Override
	public FourGHardCodeInfo checkHardCodeFromDB(IVRDataBean objIVRDataBean, FourGHardCodeInfo HardCode) {
		return getDaoRepository().query4GHardCode(objIVRDataBean, HardCode);
	}


}
