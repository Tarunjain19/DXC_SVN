package com.rcom.red.daoservice;

import org.springframework.transaction.annotation.Transactional;

import com.rcom.red.dao.impl.IVRDBDaoRepository;
import com.rcom.red.model.IVRRoutingInfo;
import com.rcom.red.model.TransferVDNInfo;
import com.rcom.red.model.ValidateRedMDN;
import com.rcom.red.resource.Constants;
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
	public ValidateRedMDN checkRedMDNHardCodingFromDB(IVRDataBean ivrDataBean,
			ValidateRedMDN validateRedMDN) {
		return getDaoRepository().queryRedMDNHardCodingInfo(ivrDataBean, validateRedMDN);
	}

	@Override
	public TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,
			TransferVDNInfo transferVDNInfo) {
		return getDaoRepository().queryTransferVDNTable(objIVRDataBean, transferVDNInfo);
	}

}
