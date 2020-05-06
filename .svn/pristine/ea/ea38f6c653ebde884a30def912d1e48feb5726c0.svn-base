package com.rcom.postpaid.dbservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.rcom.postpaid.daoservice.IVRDBDaoService;
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
import com.rcom.postpaid.model.LowARPUInfo;
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
import com.servion.util.IVRDataBean;

@Component
public class IVRDataServiceImpl implements IVRDataService {

	private IVRDBDaoService ivrdbDao;

	
	public IVRDBDaoService getIvrdbDao() {
		return ivrdbDao;
	}



	public void setIvrdbDao(IVRDBDaoService ivrdbDao) {
		this.ivrdbDao = ivrdbDao;
	}



	@Override
	public String getTestData(String strTestdata) {

		return getIvrdbDao().getDBData(strTestdata);
	}



	@Override
	public IVRRoutingInfo getIVRRoutingInfo(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo) {

		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : IVRRoutingInfo from IVR:"+ivrRoutingInfo.toString());
		return getIvrdbDao().getIVRRoutingInfoDB(objIVRDataBean, ivrRoutingInfo);
	}

	
	@Override
	public UpdateLanguage updatePreferredLanguage(IVRDataBean objIVRDataBean,
			UpdateLanguage updateLanguage) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : UpdateLanguage from IVR:"+updateLanguage.toString());
		return getIvrdbDao().updatePreferredLanguage(objIVRDataBean, updateLanguage);
	}


	@Override
	public Hashtable<String, Hashtable<String, List<IVRVasInfo>>> getVASDetails(Logger logger,
			IVRVasInfo vasDetails) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : CompleteVASInfo from IVR:"+vasDetails.toString());
		return getIvrdbDao().getVASDetailsFromDB(logger, vasDetails);
	}


	@Override
	public MDNOfferInfo getMDNSpecificOffers(IVRDataBean objIVRDataBean,
			MDNOfferInfo mdnOfferInfo) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : MDNOfferInfo from IVR:"+mdnOfferInfo.toString());
		return getIvrdbDao().getMDNSpecificOffersFromDB(objIVRDataBean, mdnOfferInfo);
	}



	@Override
	public StoreAddress getStoreAddress(IVRDataBean objIVRDataBean, StoreAddress storeAddress) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : StoreAddress from IVR:"+storeAddress.toString());
		return getIvrdbDao().getStoreAddressFromDB(objIVRDataBean, storeAddress);
	}



	@Override
	public OnlinePaymentCheck checkOnlinePaymentFlag(IVRDataBean objIVRDataBean,
			OnlinePaymentCheck onlinePaymentCheck) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : OnlinePaymentCheck from IVR:"+onlinePaymentCheck.toString());
		return getIvrdbDao().checkOnlinePaymentFlagFromDB(objIVRDataBean, onlinePaymentCheck);
	}



	@Override
	public TransferVDNInfo getTransferVDN(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : TransferVDNInfo from IVR:"+transferVDNInfo.toString());
		return getIvrdbDao().getTransferVDNFromDB(objIVRDataBean, transferVDNInfo);
	}



	@Override
	public SRCInfo checkSRCFlag(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : SRCInfo from IVR:"+srcCheck.toString());
		return getIvrdbDao().checkSRCFlagFromDB(objIVRDataBean, srcCheck);
	}



	@Override
	public SRCInfo updateSRC(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : SRCInfo from IVR:"+srcCheck.toString());
		return getIvrdbDao().updateSRCToDB(objIVRDataBean, srcCheck);
	}



	@Override
	public Hashtable<String, Hashtable<String, IntelligentLayerInfo>> getIntelligentLayerActiveStatus(Logger logger,
			IntelligentLayerInfo intelligentLayerInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : IntelligentLayerInfo from IVR:"+intelligentLayerInfo.toString());
		return getIvrdbDao().getIntelligentLayerActiveStatusFromDB(logger, intelligentLayerInfo);
	}



	@Override
	public Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> getRechargePlan(Logger logger,
			RechargePlanInfo rechargePlanInfo) {		
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : RechargePlanInfo from IVR:"+rechargePlanInfo.toString());
		return getIvrdbDao().getRechargePlanFromDB(logger, rechargePlanInfo);
	}



	@Override
	public Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> getSpecialTarifInfo(Logger logger,
			SpecialTariffInfo specialTariffInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : SpecialTariffInfo from IVR:"+specialTariffInfo.toString());
		return getIvrdbDao().getSpecialTarifInfoFromDB(logger, specialTariffInfo);
	}


	@Override
	public IVRCspInfo getIVRCSPInfo(IVRDataBean objIVRDataBean, IVRCspInfo ivrCspInfo) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : IVRCspInfo from IVR:"+ivrCspInfo.toString());
		return getIvrdbDao().getIVRCSPInfoFromDB(objIVRDataBean, ivrCspInfo);
	}
	
	@Override
	public Hashtable<String, Hashtable<String, HotFlashInfo>> getHotFlashInfo(Logger logger,HotFlashInfo hotFlashInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : HotFlashInfo from IVR:"+hotFlashInfo.toString());
		return getIvrdbDao().getHotFlashInfoDB(logger, hotFlashInfo);
	}


	@Override
	public Hashtable<String, Hashtable<String, ServiceUpdateInfo>> getServiceUpdationInfo(Logger logger,
			ServiceUpdateInfo serviceUpdateInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : ServiceUpdateInfo from IVR:"+serviceUpdateInfo.toString());
		return getIvrdbDao().getServiceUpdationInfoFromDB(logger, serviceUpdateInfo);
	}


	@Override
	public ServiceUpdateInfo updateServiceUpdationInfo(Logger logger,
			ServiceUpdateInfo serviceUpdateInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : ServiceUpdateInfo from IVR:"+serviceUpdateInfo.toString());
		return getIvrdbDao().updateServiceUpdationInfoToDB(logger, serviceUpdateInfo);
	}


	@Override
	public Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> getCircleOffers(Logger logger,
			CircleOffersInfo circleOffers) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : CircleOffersInfo from IVR:"+circleOffers.toString());
		return getIvrdbDao().getCircleOffersFromDB(logger, circleOffers);
	}



	@Override
	public TariffChangeDetail getTariffChangeDetail(IVRDataBean ivrDataBean,
			TariffChangeDetail tariffChangeDetail) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : TariffChangeDetail from IVR:"+tariffChangeDetail.toString());
		return getIvrdbDao().getTariffChangeDetailFromDB(ivrDataBean, tariffChangeDetail);
	}


	@Override
	public Hashtable<String, Hashtable<String, PushSMSInfo>> getPushSMSInfo(
			Logger logger, PushSMSInfo pushSMSInfo) {
		if(logger.isDebugEnabled())logger.debug("Load on Start UP : ServiceUpdateInfo from IVR:"+pushSMSInfo.toString());
		return getIvrdbDao().getPushSMSInfoFromDB(logger, pushSMSInfo);
	}



	@Override
	public CRMPackInfo getCRMPackInfo(IVRDataBean ivrDataBean,
			CRMPackInfo crmPackInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : CRMCountInfo from IVR:"+crmPackInfo.toString());
		return getIvrdbDao().getCRMPackInfoFromDB(ivrDataBean, crmPackInfo);
	}



	@Override
	public DOBInfo getDOBInfo(IVRDataBean ivrDataBean, DOBInfo dobInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : DOBInfo from IVR:" +dobInfo.toString());
		return getIvrdbDao().getDOBInfoFromDB(ivrDataBean, dobInfo);
	}



	@Override
	public BarringInfo getBarringInfo(IVRDataBean ivrDataBean,BarringInfo barringInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" :BarringInfo from IVR:" +barringInfo.toString());
		return getIvrdbDao().getBarringInfofromDB(ivrDataBean, barringInfo);
	}



	@Override
	public PromiseToPayInfo getPromiseToPayInfo(IVRDataBean ivrDataBean, PromiseToPayInfo promiseToPayInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" :PromiseToPayInfo from IVR:" +promiseToPayInfo.toString());
		return getIvrdbDao().getPromiseToPayInfoFromDB(ivrDataBean, promiseToPayInfo);
	}



	@Override
	public PostpaidCRMCountInfo getPostpaidCRMCountInfo(IVRDataBean ivrDataBean, PostpaidCRMCountInfo postpaidCRMCountInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" :PostpaidCRMCountInfo from IVR:" +postpaidCRMCountInfo.toString());
		return getIvrdbDao().getPostpaidCRMCountInfoFromDB(ivrDataBean, postpaidCRMCountInfo);
		
	}

	@Override
	public DNDInfo getDNDInfo(IVRDataBean ivrDataBean, DNDInfo dndInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : DNDInfo from IVR:"+dndInfo.toString());
		return getIvrdbDao().getDNDInfoFromDB(ivrDataBean, dndInfo);
	}



	@Override
	public ValidateMobileNumber validateMDN(IVRDataBean ivrDataBean,
			ValidateMobileNumber validateMobileNumber) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : ValidateMobileNumber from IVR:"+validateMobileNumber.toString());
		return  getIvrdbDao().validateMDNFromDB(ivrDataBean, validateMobileNumber);
	}



	@Override
	public RegisterCallBack registerCallBack(IVRDataBean ivrDataBean,
			RegisterCallBack registerCallBack) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : IVRDataBean from IVR:"+registerCallBack.toString());
		return getIvrdbDao().registerCallBackToDB(ivrDataBean, registerCallBack);
	}



	@Override
	public ValidateCWG validateCWGFlag(IVRDataBean ivrDataBean,
			ValidateCWG validateCWG) {
		return getIvrdbDao().validateCWGFlag(ivrDataBean, validateCWG);
	}

	@Override
	public MDNHotFlashInfo checkMDNHotFlashFlag(IVRDataBean objIVRDataBean, MDNHotFlashInfo MDNhotflash) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : MDNhotflash from IVR:"+MDNhotflash.toString());
		return getIvrdbDao().checkMDNHotFlagFromDB(objIVRDataBean, MDNhotflash);
	}



	public LowARPUInfo checkLowARPUInfoFlag(IVRDataBean objIVRDataBean, LowARPUInfo LowARPU) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : LowARPUInfo from IVR:"+LowARPU.toString());
		return getIvrdbDao().checkLowARPUInfoFromDB(objIVRDataBean, LowARPU);
	}
	
}
