package com.rcom.red.daoservice;

import com.rcom.red.model.IVRRoutingInfo;
import com.rcom.red.model.TransferVDNInfo;
import com.rcom.red.model.ValidateRedMDN;
import com.servion.util.IVRDataBean;

public interface IVRDBDaoSevice {

	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrRoutingInfo
	 * @return IVRRoutingInfo
	 */
	IVRRoutingInfo getIVRRoutingInfoFromDB(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param validateMDN
	 * @return
	 */
	ValidateRedMDN checkRedMDNHardCodingFromDB(IVRDataBean ivrDataBean, ValidateRedMDN validateRedMDN);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return TransferVDNInfo
	 */
	TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,TransferVDNInfo transferVDNInfo);
	
}
