package com.rcom.dnd.daoservice;

import com.rcom.dnd.model.DNDInfo;
import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.model.TransferVDNInfo;
import com.rcom.dnd.model.SRCInfo;
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
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return TransferVDNInfo
	 */
	TransferVDNInfo getTransferVDNFromDB(IVRDataBean objIVRDataBean,TransferVDNInfo transferVDNInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param dndInfo
	 * @return
	 */
	DNDInfo getDNDInfoFromDB(IVRDataBean ivrDataBean, DNDInfo dndInfo);
	
	// Added SRC Barring
	
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
	
	
	
}
