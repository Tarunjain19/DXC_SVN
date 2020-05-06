package com.rcom.dnd.dbservice;

import com.rcom.dnd.model.DNDInfo;
import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.model.TransferVDNInfo;
import com.rcom.dnd.model.SRCInfo;
import com.servion.util.IVRDataBean;

public interface IVRDataService {

	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrRoutingInfo
	 * @return IVRRoutingInfo
	 */
	IVRRoutingInfo getIVRRoutingInfo(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return TransferVDNInfo
	 */
	TransferVDNInfo getTransferVDN(IVRDataBean objIVRDataBean,TransferVDNInfo transferVDNInfo);
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param dndInfo
	 * @return
	 */
	DNDInfo getDNDInfo(IVRDataBean ivrDataBean, DNDInfo dndInfo);
	
	// Added SRC Barring  on 22 Mar16
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo checkSRCFlag(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcCheck
	 * @return SRCInfo
	 */
	SRCInfo updateSRC(IVRDataBean objIVRDataBean,SRCInfo srcCheck);
	
	
}
