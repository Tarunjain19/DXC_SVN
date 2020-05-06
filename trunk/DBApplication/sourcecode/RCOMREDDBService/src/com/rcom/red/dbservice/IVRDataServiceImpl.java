package com.rcom.red.dbservice;

import org.springframework.stereotype.Component;

import com.rcom.red.daoservice.IVRDBDaoSevice;
import com.rcom.red.model.IVRRoutingInfo;
import com.rcom.red.model.TransferVDNInfo;
import com.rcom.red.model.ValidateRedMDN;
import com.servion.util.IVRDataBean;

@Component
public class IVRDataServiceImpl implements IVRDataService {

	private IVRDBDaoSevice ivrdbDao;
	
	public IVRDBDaoSevice getIvrdbDao() {
		return ivrdbDao;
	}

	public void setIvrdbDao(IVRDBDaoSevice ivrdbDao) {
		this.ivrdbDao = ivrdbDao;
	}
	
	

	@Override
	public IVRRoutingInfo getIVRRoutingInfo(IVRDataBean ivrDataBean,
			IVRRoutingInfo ivrRoutingInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : IVRRoutingInfo from IVR:"+ivrRoutingInfo.toString());
		return getIvrdbDao().getIVRRoutingInfoFromDB(ivrDataBean, ivrRoutingInfo);
	}

	@Override
	public ValidateRedMDN checkRedMDNHardCoding(IVRDataBean ivrDataBean,
			ValidateRedMDN validateRedMDN) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : ValidateRedMDN from IVR:"+validateRedMDN.toString());
		return getIvrdbDao().checkRedMDNHardCodingFromDB(ivrDataBean, validateRedMDN);
	}

	@Override
	public TransferVDNInfo getTransferVDN(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : TransferVDNInfo from IVR:"+transferVDNInfo.toString());
		return getIvrdbDao().getTransferVDNFromDB(objIVRDataBean, transferVDNInfo);
	}

	

}
