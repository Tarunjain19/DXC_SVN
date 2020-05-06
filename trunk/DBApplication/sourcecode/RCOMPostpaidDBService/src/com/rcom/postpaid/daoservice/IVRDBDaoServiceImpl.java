package com.rcom.postpaid.daoservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcom.postpaid.dao.impl.IVRDBDaoRepository;
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
	public Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfoFromDB(
			Logger logger, PushSMSInfo pushSMSInfo) {
		return getDaoRepository().queryPushSMSInfo(logger, pushSMSInfo);
	}

	@Override
	public CRMPackInfo getCRMPackInfoFromDB(IVRDataBean dataBean,
			CRMPackInfo crmPackInfo) {
		return getDaoRepository().queryCRMPackInfo(dataBean, crmPackInfo);
	}

	@Override
	public DOBInfo getDOBInfoFromDB(IVRDataBean dataBean, DOBInfo dobInfo) {
		
		return getDaoRepository().queryDOBInfo(dataBean, dobInfo);
	}

	@Override
	public BarringInfo getBarringInfofromDB(IVRDataBean dataBean, BarringInfo barringInfo) {
		return getDaoRepository().queryBarringInfo(dataBean, barringInfo);
	}

	@Override
	public PromiseToPayInfo getPromiseToPayInfoFromDB(IVRDataBean dataBean, PromiseToPayInfo promiseToPayInfo) {
		return getDaoRepository().queryPromiseToPayInfo(dataBean, promiseToPayInfo);
	}

	@Override
	public PostpaidCRMCountInfo getPostpaidCRMCountInfoFromDB(IVRDataBean dataBean, PostpaidCRMCountInfo postpaidCRMCountInfo) {
		return getDaoRepository().quetyPostpaidCRMCountInfo(dataBean, postpaidCRMCountInfo);
	}

	@Override
	public DNDInfo getDNDInfoFromDB(IVRDataBean ivrDataBean, DNDInfo dndInfo) {
		return getDaoRepository().queryDNDInfo(ivrDataBean, dndInfo);
	}

	@Override
	public ValidateMobileNumber validateMDNFromDB(IVRDataBean ivrDataBean,
			ValidateMobileNumber validateMobileNumber) {
		return getDaoRepository().queryCSPToValidateMDN(ivrDataBean, validateMobileNumber);
	}

	@Override
	public RegisterCallBack registerCallBackToDB(IVRDataBean ivrDataBean,
			RegisterCallBack registerCallBack) {
		return getDaoRepository().insertCallBackReuqest(ivrDataBean, registerCallBack);
	}

	@Override
	public ValidateCWG validateCWGFlag(IVRDataBean ivrDataBean,
			ValidateCWG validateCWG) {
		return getDaoRepository().queryCWGTable(ivrDataBean, validateCWG);
	}

	@Override
	public MDNHotFlashInfo checkMDNHotFlagFromDB(IVRDataBean objIVRDataBean, MDNHotFlashInfo MDNhotflash) {
		return getDaoRepository().queryMDNHotFlashTable(objIVRDataBean,MDNhotflash);
	}
	
	@Override
	public LowARPUInfo checkLowARPUInfoFromDB(IVRDataBean objIVRDataBean, LowARPUInfo LowARPU) {
		return getDaoRepository().queryLowARPU(objIVRDataBean, LowARPU);
		
	}
}
