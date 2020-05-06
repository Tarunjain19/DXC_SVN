package com.rcom.prepaid.dbservice;

import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.rcom.prepaid.daoservice.IVRDBDaoService;
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
	public CRMCountInfo getCRMCountInfo(IVRDataBean ivrDataBean,
			CRMCountInfo crmCountInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : CRMCountInfo from IVR:"+crmCountInfo.toString());
		return getIvrdbDao().getCRMCountInfoFromDB(ivrDataBean, crmCountInfo);
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

	
	// Add GPRS Barring By Tarun on 17 Nov 2015
	@Override
	public GPRSSRCInfo checkGPRSSRCFlag(IVRDataBean objIVRDataBean, GPRSSRCInfo GPRSsrcCheck) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : GPRSSRCInfo from IVR:"+GPRSsrcCheck.toString());
		return getIvrdbDao().checkGPRSSRCFlagFromDB(objIVRDataBean, GPRSsrcCheck);
	}
	
		
	// Add  MDN HOT FLASH Logic  By Tarun on 8 Dec
	@Override
	public MDNHotFlashInfo checkMDNHotFlashFlag(IVRDataBean objIVRDataBean, MDNHotFlashInfo MDNhotflash) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : MDNhotflash from IVR:"+MDNhotflash.toString());
		return getIvrdbDao().checkMDNHotFlagFromDB(objIVRDataBean, MDNhotflash);
	}
	
	
	// Add  Low ARPU Info Logic  By Rahul on 17Mar16
	@Override
	public LowARPUInfo checkLowARPUInfoFlag(IVRDataBean objIVRDataBean, LowARPUInfo LowARPU) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : LowARPUInfo from IVR:"+LowARPU.toString());
		return getIvrdbDao().checkLowARPUInfoFromDB(objIVRDataBean, LowARPU);
	}
		
	
	//-------------4G HARD CODE for RCOM_CF_4GSIM_IVR on 09/01/2016-------
		@Override
		public FourGHardCodeInfo checkHardCodeFlag(IVRDataBean objIVRDataBean,FourGHardCodeInfo HardCode){
			if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : FourGHardCodeInfo from IVR:"+HardCode.toString());
			return getIvrdbDao().checkHardCodeFromDB(objIVRDataBean, HardCode);
		}
	
}
