package com.rcom.dnd.test;

import org.apache.log4j.Logger;

import com.rcom.dnd.model.DNDInfo;
//import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.resource.IVRDBServiceInstance;
import com.servion.prepaid.report.GetReportObject;
import com.servion.prepaid.report.IVRREPORTDATA;
import com.servion.util.IVRDataBean;

public class Test {

	/**
	 * @param args
	 */
	private static Logger logger = Logger.getLogger(Test.class);
	public static void main(String[] args) {
		IVRDataBean ivrDataBean = new IVRDataBean();
		ivrDataBean.setLogger(logger);
		ivrDataBean.setSessionID("123456789");
		GetReportObject getReportObject = new GetReportObject();
		IVRREPORTDATA ivrreportdata = getReportObject.createIVRReportObject();
		getReportObject.setIvrreportdata(ivrreportdata);
		ivrDataBean.setGetReportObject(getReportObject);
		
		/*IVRRoutingInfo ivrRoutingInfo = new IVRRoutingInfo();
		ivrRoutingInfo.setDnis("52543");
		ivrRoutingInfo = IVRDBServiceInstance.getIVRDBInstance().getIVRRoutingInfo(ivrDataBean, ivrRoutingInfo);
		System.out.println(ivrRoutingInfo.toString());*/
		
		
		/*TransferVDNInfo trVdnInfo = new TransferVDNInfo();
		trVdnInfo.setAppName("RCOM_CF_WebworldHelpdesk");
		trVdnInfo.setCircle("TN");
		trVdnInfo.setCustomerSegment("2");
		trVdnInfo.setLanguage("ENG");
		trVdnInfo.setCallType("2");
		trVdnInfo.setTransferReasonCode("WHIVR_TR_0002");
		trVdnInfo = IVRDBServiceInstance.getIVRDBInstance().getTransferVDN(ivrDataBean, trVdnInfo);
		System.out.println(trVdnInfo.toString());*/
		
		/*HotFlashInfo hotFlashInfo = new HotFlashInfo();
		hotFlashInfo.setAppName("RCOM_CF_BB_Enterprise_Desk_IVR");
		Hashtable<String, HotFlashInfo> hashtable5 = IVRDBServiceInstance.getIVRDBInstance().getHotFlashInfo(ivrDataBean, hotFlashInfo);
		System.out.println(hashtable5);*/
		
		DNDInfo dndInfo = new DNDInfo();
		dndInfo.setMdn("7667555701");
		dndInfo = IVRDBServiceInstance.getIVRDBInstance().getDNDInfo(ivrDataBean, dndInfo);
		System.out.println(dndInfo);
		

	}

}
