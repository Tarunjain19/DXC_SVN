package com.rcom.dnd.dbservice;

import org.springframework.stereotype.Component;

import com.rcom.dnd.daoservice.IVRDBDaoSevice;
import com.rcom.dnd.model.DNDInfo;
import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.model.TransferVDNInfo;
import com.rcom.dnd.model.SRCInfo;
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
	public TransferVDNInfo getTransferVDN(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		if(objIVRDataBean.getLogger().isDebugEnabled())objIVRDataBean.getLogger().debug(objIVRDataBean.getSessionID()+" : TransferVDNInfo from IVR:"+transferVDNInfo.toString());
		return getIvrdbDao().getTransferVDNFromDB(objIVRDataBean, transferVDNInfo);
	}

	@Override
	public DNDInfo getDNDInfo(IVRDataBean ivrDataBean, DNDInfo dndInfo) {
		if(ivrDataBean.getLogger().isDebugEnabled())ivrDataBean.getLogger().debug(ivrDataBean.getSessionID()+" : DNDInfo from IVR:"+dndInfo.toString());
		return getIvrdbDao().getDNDInfoFromDB(ivrDataBean, dndInfo);
	}

	// Added SRC Barring
	
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

}
