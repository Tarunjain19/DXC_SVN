package com.rcom.dnd.daoservice;

import org.springframework.transaction.annotation.Transactional;

import com.rcom.dnd.dao.impl.IVRDBDaoRepository;
import com.rcom.dnd.model.DNDInfo;
import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.model.TransferVDNInfo;
import com.rcom.dnd.resource.Constants;
import com.rcom.dnd.model.SRCInfo;
import com.servion.util.IVRDataBean;

@Transactional(Constants.TxManager)
public class IVRDBDaoServiceImpl implements IVRDBDaoSevice{

	private IVRDBDaoRepository daoRepository;
	
	public IVRDBDaoRepository getDaoRepository() {
		return daoRepository;
	}

	public void setDaoRepository(IVRDBDaoRepository daoRepository) {
		this.daoRepository = daoRepository;
	}
	
	@Override
	public IVRRoutingInfo getIVRRoutingInfoFromDB(IVRDataBean objIVRDataBean,
			IVRRoutingInfo ivrRoutingInfo) {
		return getDaoRepository().queryRoutingTable(objIVRDataBean, ivrRoutingInfo);
	}

	@Override
	public TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		return getDaoRepository().queryTransferVDNTable(objIVRDataBean, transferVDNInfo);
	}

	@Override
	public DNDInfo getDNDInfoFromDB(IVRDataBean ivrDataBean, DNDInfo dndInfo) {
		return getDaoRepository().queryDNDInfo(ivrDataBean, dndInfo);
	}

	// Added SRC barring
	
	@Override
	public SRCInfo updateSRCToDB(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		return getDaoRepository().updateSRCount(objIVRDataBean,srcCheck);
	}

	@Override
	public SRCInfo checkSRCFlagFromDB(IVRDataBean objIVRDataBean, SRCInfo srcCheck) {
		return getDaoRepository().querySRCInfoTable(objIVRDataBean,srcCheck);
	}



}
