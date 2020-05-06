package com.rcom.postpaid.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

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
import com.rcom.postpaid.model.MDNOfferInfo;
import com.rcom.postpaid.model.MenuMaster;
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
import com.rcom.postpaid.resource.Constants;
import com.rcom.postpaid.util.Utils;
import com.rcom.postpaid.model.LowARPUInfo;
import com.servion.prepaid.report.GetReportObject;
import com.servion.util.IVRDataBean;

@Repository
public class IVRDBDaoRepository extends GenericEntityManager {

	private long startTime;
	private long endTime;
	Logger logger = null;
	String sessionId = "Load on Start UP";
	String response = Constants.SUCCESS;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	GetReportObject getReportObject = null;
	
	public String doTest(String strTestData)
	{

		System.out.println("In Repository : "+entityManager);
		try {
			startTime = new Date().getTime();
			//ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

			/*EntityManagerFactory entityManagerFactory = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
			EntityManager entityManager = entityManagerFactory.createEntityManager();*/

			System.out.println(entityManager);
			@SuppressWarnings("unchecked")
			List<MenuMaster> list = (List<MenuMaster>) entityManager.createNamedStoredProcedureQuery("GetMenuDetailSP").getResultList();
			System.out.println(list.toString());
			strTestData = list.get(1).getMenuId();
			endTime = new Date().getTime();
			Utils.getConnectionTime(null,sessionId, "GetMenuDetailSP", startTime, endTime);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return strTestData;

	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrRoutingInfo
	 * @return
	 */
	public IVRRoutingInfo queryRoutingTable(IVRDataBean objIVRDataBean, IVRRoutingInfo ivrRoutingInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();
		
		try {
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.SP_IVR_DNISRouting);
			spq.registerStoredProcedureParameter(Constants.o_ErrorCode, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.o_ErrorDescription, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.DNIS, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.TrunkGroup, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.CircleId, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.Languages, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.DefaultLanguage, String.class, ParameterMode.OUT);
			spq.setParameter(Constants.DNIS, ivrRoutingInfo.getDnis());
			spq.execute();

			/*Storing output to the bean*/
			ivrRoutingInfo.setTrunkGroup((String) spq.getOutputParameterValue(Constants.TrunkGroup));
			ivrRoutingInfo.setCircle((String) spq.getOutputParameterValue(Constants.CircleId));
			ivrRoutingInfo.setLanguage((String) spq.getOutputParameterValue(Constants.Languages));
			ivrRoutingInfo.setDefaultLanguage((String) spq.getOutputParameterValue(Constants.DefaultLanguage));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRRoutingInfo to IVR:"+ivrRoutingInfo.toString());
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_DNISRouting, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.SP_IVR_DNISRouting, Constants.SP_IVR_DNISRouting, dateFormat.format(startTime), ivrRoutingInfo.getDnis(), ivrRoutingInfo.getCircle()+Constants.PIPE+ivrRoutingInfo.getDefaultLanguage(), response, response, dateFormat.format(endTime));
		}

		return ivrRoutingInfo;

	}

	/**
	 * 
	 * @param logger
	 * @param hotFlashInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, HotFlashInfo>> queryHotFlashTable(Logger logger, HotFlashInfo hotFlashInfo){

		startTime = new Date().getTime();
		
		List<HotFlashInfo> hostFlashInfoList = null;

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetIVRHotFlash);
			spq.setParameter(Constants.ApplicationName, hotFlashInfo.getAppName());
			spq.execute();

			/*Storing result set to the list bean*/
			hostFlashInfoList = (List<HotFlashInfo>) spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : HotFlashInfo to IVR:"+hostFlashInfoList.toString());

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetIVRHotFlash, startTime, endTime);
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetIVRHotFlash, startTime, endTime);
		}

		return Utils.getHotFlashHashTable(hostFlashInfoList);

	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param onlinePaymentCheck
	 * @return
	 */
	public OnlinePaymentCheck queryOnlinePaymentTable(IVRDataBean objIVRDataBean, OnlinePaymentCheck onlinePaymentCheck){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_Online_Payment);
			spq.setParameter(Constants.ApplicationName, onlinePaymentCheck.getAppName());
			spq.setParameter(Constants.Circle, onlinePaymentCheck.getCircleId());
			spq.execute();
			
			/*Storing output to bean*/
			onlinePaymentCheck.setStatus((String) spq.getOutputParameterValue(Constants.OnlinePaymentFlag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : OnlinePaymentCheck to IVR:"+onlinePaymentCheck.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_Online_Payment, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_IVR_Online_Payment, Constants.SP_IVR_Online_Payment, dateFormat.format(startTime), onlinePaymentCheck.getAppName()+Constants.PIPE+onlinePaymentCheck.getCircleId(), onlinePaymentCheck.getStatus(), response, response, dateFormat.format(endTime));
		}

		return onlinePaymentCheck;

	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return
	 */
	public TransferVDNInfo queryTransferVDNTable(IVRDataBean objIVRDataBean, TransferVDNInfo transferVDNInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_IVR_VDNTransfer);
			spq.setParameter(Constants.ApplicationName, transferVDNInfo.getAppName());
			spq.setParameter(Constants.Language, transferVDNInfo.getLanguage());
			spq.setParameter(Constants.Circle, transferVDNInfo.getCircle());
			spq.setParameter(Constants.CustomerSegment, transferVDNInfo.getCustomerSegment());
			spq.setParameter(Constants.CallType, transferVDNInfo.getCallType());
			spq.setParameter(Constants.TransferReasonCode, transferVDNInfo.getTransferReasonCode());
			spq.execute();

			/*Storing output to bean*/
			transferVDNInfo.setTransferVDN1((String) spq.getOutputParameterValue(Constants.TransferVDN1));
			transferVDNInfo.setTransferVDN2((String) spq.getOutputParameterValue(Constants.TransferVDN2));
			transferVDNInfo.setSkillName((String) spq.getOutputParameterValue(Constants.SkillName));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : TransferVDNInfo to IVR:"+transferVDNInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_IVR_VDNTransfer, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_IVR_IVR_VDNTransfer, Constants.SP_IVR_IVR_VDNTransfer, dateFormat.format(startTime), transferVDNInfo.getAppName()+Constants.PIPE+transferVDNInfo.getCircle()+Constants.PIPE+transferVDNInfo.getLanguage()+transferVDNInfo.getCustomerSegment()+Constants.PIPE+transferVDNInfo.getTransferReasonCode(), transferVDNInfo.getTransferVDN1()+Constants.PIPE+transferVDNInfo.getTransferVDN2()+Constants.PIPE+transferVDNInfo.getSkillName(), response, response, dateFormat.format(endTime));
		}

		return transferVDNInfo;
	}

	/*public VasRequestURLInfo queryStopStartServicesTable(IVRDataBean objIVRDataBean, VasRequestURLInfo fetchVasURL){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();

		try {

			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_START_STOP_SERVICES);
			spq.setParameter(Constants.PackName, fetchVasURL.getPackId());
			spq.execute();

			fetchVasURL.setUrl((String) spq.getOutputParameterValue(Constants.HTTP_URL));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : VasRequestURLInfo to IVR:"+fetchVasURL.toString());
			
		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_START_STOP_SERVICES, startTime, endTime);
		return fetchVasURL;
	}*/

	public StoreAddress queryStoreDetailTable(IVRDataBean objIVRDataBean, StoreAddress storeAddress){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_StoreDetails);
			spq.setParameter(Constants.PINCode, storeAddress.getPinCode());
			spq.execute();

			storeAddress.setStoreAddress((String) spq.getOutputParameterValue(Constants.StoreAddress));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : StoreAddress to IVR:"+storeAddress.toString());
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_StoreDetails, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_IVR_StoreDetails, Constants.SP_IVR_StoreDetails, dateFormat.format(startTime), storeAddress.getPinCode(), storeAddress.getStoreAddress(), response, response, dateFormat.format(endTime));
		}

		return storeAddress;
	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param updateLanguage
	 * @return UpdateLanguage
	 */
	public UpdateLanguage queryUpdateLanguageTable(IVRDataBean objIVRDataBean, UpdateLanguage updateLanguage){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_PREF_LANG_Insert_Update);
			
			/*Assigning inputs for the procedure*/
			spq.setParameter(Constants.MDN, updateLanguage.getMdn());
			spq.setParameter(Constants.LanguageCode, updateLanguage.getLanguageCode());
			spq.execute();
			
			/*Storing the output to the bean*/
			updateLanguage.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : UpdateLanguage to IVR:"+updateLanguage.toString());

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_PREF_LANG_Insert_Update, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_IVR_PREF_LANG_Insert_Update, Constants.SP_IVR_PREF_LANG_Insert_Update, dateFormat.format(startTime), updateLanguage.getMdn()+Constants.PIPE+updateLanguage.getMdn(), updateLanguage.getFlag(), response, response, dateFormat.format(endTime));
		}
		return updateLanguage;
	}

	/*public List<IVRVasInfo> queryVasInfoTable(IVRDataBean objIVRDataBean, IVRVasInfo ivrVasInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		
		List<IVRVasInfo> ivrVasInfoList = null;

		try {

			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_VAS);
			spq.setParameter(Constants.MDN, ivrVasInfo.getMdn());
			spq.execute();

			ivrVasInfoList = spq.getResultList();
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRVasInfo to IVR:"+ivrVasInfoList.toString());

		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_VAS, startTime, endTime);
		return ivrVasInfoList;
	}
*/
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrVasInfo
	 * @return
	 *//*
	public IVRVasInfo updateVasInfo(IVRDataBean objIVRDataBean, IVRVasInfo ivrVasInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();

		try {

			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.SP_IVR_VAS_Insert);
			spq.registerStoredProcedureParameter(0, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(2, String.class, ParameterMode.OUT);

			spq.setParameter(0, ivrVasInfo.getMdn());
			spq.setParameter(1, ivrVasInfo.getPackId());
			spq.execute();
			//ivrVasInfo.setFlag((String)spq.getOutputParameterValue(2));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRVasInfo to IVR:"+ivrVasInfo.toString());

		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_VAS_Insert, startTime, endTime);
		return ivrVasInfo;
	}*/

	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcInfo
	 * @return
	 */
	public SRCInfo updateSRCount(IVRDataBean objIVRDataBean, SRCInfo srcInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_SRC_Count_Update);
			spq.setParameter(Constants.MDN, srcInfo.getMdn());
			spq.execute();
			
			/*Storing output to bean*/
			srcInfo.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : SRCInfo to IVR:"+srcInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));

		} catch (Exception e) {
			response =  Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_SRC_Count_Update, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.PROC_IVR_SRC_Count_Update, Constants.IVR_SRC_Count_Update, dateFormat.format(startTime), srcInfo.getMdn(), srcInfo.getFlag(), response, response, dateFormat.format(endTime));
		
		return srcInfo;
	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param srcInfo
	 * @return
	 */
	/* public SRCInfo querySRCInfoTable(IVRDataBean objIVRDataBean, SRCInfo srcInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			//Calling Stored procedure
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.SP_IVR_SRC_Check);
			spq.registerStoredProcedureParameter(Constants.MDN, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.Flag, String.class, ParameterMode.OUT);
			spq.setParameter(Constants.MDN, srcInfo.getMdn());
			spq.execute();
			
			//Storing output to bean//
			srcInfo.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : SRCInfo to IVR:"+srcInfo.toString());

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_SRC_Check, startTime, endTime);
		return srcInfo;
	} */

	public SRCInfo querySRCInfoTable(IVRDataBean objIVRDataBean, SRCInfo srcInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.SP_IVR_SRC_Check);
			spq.registerStoredProcedureParameter(Constants.MDN, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.Circle, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.AppName, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.Flag, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.o_ErrorCode, String.class, ParameterMode.OUT);
			spq.registerStoredProcedureParameter(Constants.o_ErrorDescription, String.class, ParameterMode.OUT);
			
			spq.setParameter(Constants.MDN, srcInfo.getMdn());
			spq.setParameter(Constants.Circle, srcInfo.getCircleId());
			spq.setParameter(Constants.AppName, srcInfo.getAppname());
			spq.execute();
			
			//Storing output to bean*/
			srcInfo.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : SRCInfo to IVR:"+srcInfo.toString());

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_SRC_Check, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.PROC_IVR_SRC_Check, Constants.SP_IVR_SRC_Check, dateFormat.format(startTime), srcInfo.getMdn(), srcInfo.getFlag(), response, response, dateFormat.format(endTime));
		return srcInfo;
	}
	
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param ivrCspInfo
	 * @return IVRCspInfo
	 */
	public IVRCspInfo queryCSPTable(IVRDataBean objIVRDataBean, IVRCspInfo ivrCspInfo){
		
		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_CSP);
			
			/*Assigning Input for stored procedure*/
			spq.setParameter(Constants.MDN, ivrCspInfo.getMdn());
			spq.execute();
			
			/*Stored the values returned to the bean*/
			ivrCspInfo.setService((String) spq.getOutputParameterValue(Constants.SERVICE));
			ivrCspInfo.setHnipre((String) spq.getOutputParameterValue(Constants.HNIPRE));
			ivrCspInfo.setBarringList((String) spq.getOutputParameterValue(Constants.BARRINGLIST));
			ivrCspInfo.setPreLang((String) spq.getOutputParameterValue(Constants.PREFLANG));
			ivrCspInfo.setStrRTN((String) spq.getOutputParameterValue(Constants.RTN));
			ivrCspInfo.setErrorCode((String) spq.getOutputParameterValue(Constants.o_ErrorCode));
			ivrCspInfo.setErrorDescription((String) spq.getOutputParameterValue(Constants.o_ErrorDescription));
			ivrCspInfo.setDob((String) spq.getOutputParameterValue(Constants.DOB));
		
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRCspInfo to IVR:"+ivrCspInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		} finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_CSP, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_IVR_CSP, Constants.SP_IVR_CSP, dateFormat.format(startTime), ivrCspInfo.getMdn(), ivrCspInfo.getService()+Constants.PIPE+ivrCspInfo.getHnipre()+Constants.PIPE+ivrCspInfo.getPreLang(), response, response, dateFormat.format(endTime));
		}

		return ivrCspInfo;
	}
	
	/**
	 * 
	 * @param logger
	 * @param intelligentLayerInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, IntelligentLayerInfo>> queryIntelligentLayerInfo(Logger logger, IntelligentLayerInfo intelligentLayerInfo){
		
		startTime = new Date().getTime();
		
		List<IntelligentLayerInfo> intelligentLayerActiveList = null;
		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetIntelligentLayer);
			spq.setParameter(Constants.ApplicationName, intelligentLayerInfo.getAppName());
			spq.execute();
			
			/*Storing result set to bean*/
			intelligentLayerActiveList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IntelligentLayerInfo to IVR:"+intelligentLayerInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetIntelligentLayer, startTime, endTime);
		return Utils.getIntelligentLayerHashTable(intelligentLayerActiveList);
		
	}
	
	/**
	 * 
	 * @param logger
	 * @param specialTariffInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, List<SpecialTariffInfo>>> querySpecialTariffInfo(Logger logger, SpecialTariffInfo specialTariffInfo){
		
		startTime = new Date().getTime();
		
		List<SpecialTariffInfo> specialInfoList = null;
		try {
			/*Calling Stored Procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetSpecialTraiffVoucher);
			spq.setParameter(Constants.ApplicationName, specialTariffInfo.getAppName());
			spq.execute();
			
			/*Storing resultset into list*/
			specialInfoList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : SpecialTariffInfo to IVR:"+specialTariffInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetSpecialTraiffVoucher, startTime, endTime);
		
		return Utils.getSpecialTariffHashTable(specialInfoList);
		
	}
	
	/**
	 * 
	 * @param logger
	 * @param rechargePlanInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, List<RechargePlanInfo>>> queryRechargePlanInfo(Logger logger, RechargePlanInfo rechargePlanInfo){
		
		startTime = new Date().getTime();
		
		List<RechargePlanInfo> rechargePlanInfoList = null;
		try {
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetPlanVoucherDenomination);
			
			/*Passing input variable*/
			spq.setParameter(Constants.ApplicationName, rechargePlanInfo.getAppName());
			spq.execute();
		
			/*Storing resultset to bean*/
			rechargePlanInfoList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : RechargePlanInfo to IVR:"+rechargePlanInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetPlanVoucherDenomination, startTime, endTime);
		
		return Utils.getRechargePlanHashTable(rechargePlanInfoList);
		
	}
	
	/**
	 * 
	 * @param logger
	 * @param circleOffersInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, List<CircleOffersInfo>>> queryApplicationOfferInfo(Logger logger, CircleOffersInfo circleOffersInfo){
		
		startTime = new Date().getTime();
		
		List<CircleOffersInfo> circleOffersInfoList = null;
		try {
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetOfferApplication);
			
			/*Passing input variable*/
			spq.setParameter(Constants.ApplicationName, circleOffersInfo.getAppName());
			spq.setParameter(Constants.OfferType, circleOffersInfo.getOfferType());
			spq.execute();
		
			/*Storing resultset to bean*/
			circleOffersInfoList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : CircleOffersInfo to IVR:"+circleOffersInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetOfferApplication, startTime, endTime);
		
		return Utils.getCircleOfferHashTable(circleOffersInfoList);
	}

	/**
	 * 
	 * @param objIVRDataBean
	 * @param mdnOfferInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public MDNOfferInfo queryMDNOfferInfo(IVRDataBean objIVRDataBean, MDNOfferInfo mdnOfferInfo){
		
		startTime =  new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		
		List<MDNOfferInfo> mdnOfferInfoList = null;
		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetOfferMDN);
			
			/*Passing input variables*/
			spq.setParameter(Constants.ApplicationName, mdnOfferInfo.getAppName());
			spq.setParameter(Constants.CircleCode, mdnOfferInfo.getCircleId());
			spq.setParameter(Constants.LanguageCode, mdnOfferInfo.getLanguage());
			spq.setParameter(Constants.OfferType, mdnOfferInfo.getOfferType());
			spq.setParameter(Constants.Campaignname, mdnOfferInfo.getCampaignname());
			spq.execute();
		
			/*Storing resultset to bean*/
			try {
				mdnOfferInfoList = spq.getResultList();
				mdnOfferInfo = mdnOfferInfoList.get(0);
				if(logger.isDebugEnabled())logger.debug(sessionId+" : MDNOfferInfo to IVR:"+mdnOfferInfo.toString());
			} catch (Exception e) {
				mdnOfferInfo.setOfferCategoryPhrase(null);
				mdnOfferInfo.setOfferDetailPhrase(null);
				mdnOfferInfo.setStatus("N");
				Utils.printStackTrace(logger, sessionId, e);
			}
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime =  new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetOfferMDN, startTime, endTime);
		}
		return mdnOfferInfo;
	}
	
	/**
	 * 
	 * @param logger
	 * @param serviceUpdateInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, ServiceUpdateInfo>> queryserviceUpdateInfo(Logger logger, ServiceUpdateInfo serviceUpdateInfo){
		
		startTime =  new Date().getTime();
		
		List<ServiceUpdateInfo> serviceUpdateInfoList = null;
		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_SP_IVR_SERVICE_UPDATION);
			spq.setParameter(Constants.ApplicationName, serviceUpdateInfo.getAppName());
			spq.setParameter(Constants.IPaddress, serviceUpdateInfo.getIPaddress());
			spq.execute();
			
			/*if(logger.isDebugEnabled())logger.debug(spq.getOutputParameterValue("ErrorCode: "+Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(spq.getOutputParameterValue("ErrorDescription: "+Constants.o_ErrorDescription));*/
			
			/*Storing resultset to list of bean*/
			serviceUpdateInfoList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ServiceUpdateInfo to IVR:"+serviceUpdateInfo.toString());
			
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime =  new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_SP_IVR_SERVICE_UPDATION, startTime, endTime);
		
		return Utils.getServiceUpdateInfoHashTable(serviceUpdateInfoList);
		
	}
	
	public ServiceUpdateInfo updateServiceUpdateInfo(Logger logger, ServiceUpdateInfo serviceUpdateInfo){
		
		startTime =  new Date().getTime();
		
		try {
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.SP_IVR_SERVICE_UPDATION_Status);
			spq.registerStoredProcedureParameter(Constants.ApplicationName, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.ServiceName, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.UPDATE_STATUS, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.IPaddress, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.Flag, String.class, ParameterMode.OUT);
			spq.setParameter(Constants.ApplicationName, serviceUpdateInfo.getAppName());
			spq.setParameter(Constants.ServiceName, serviceUpdateInfo.getServiceName());
			spq.setParameter(Constants.UPDATE_STATUS, serviceUpdateInfo.getStatus());
			spq.setParameter(Constants.IPaddress, serviceUpdateInfo.getIPaddress());
			spq.execute();
			
			serviceUpdateInfo.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ServiceUpdateInfo to IVR:"+serviceUpdateInfo.toString());
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime =  new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_SERVICE_UPDATION_Status, startTime, endTime);
		
		return serviceUpdateInfo;
		
	}
	
	/**
	 * 
	 * @param logger
	 * @param 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, List<IVRVasInfo>>> queryIVRVASInfo(Logger logger, IVRVasInfo ivrVasInfo){
		
		startTime = new Date().getTime();
		
		List<IVRVasInfo> ivrVasInfoList = null;
		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_IVR_VAS);
			
			/*Setting input parameter*/
			spq.setParameter(Constants.ApplicationName, ivrVasInfo.getAppName());
			spq.execute();
			
			/*Storing result set*/
			ivrVasInfoList = spq.getResultList();
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRVasInfo to IVR:"+ivrVasInfoList.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_VAS, startTime, endTime);
		return Utils.getapplicationIVRVasInfoHashTable(ivrVasInfoList);
		
	}
	
	
	@SuppressWarnings("unchecked")
	public TariffChangeDetail queryTariffChangeInfo(IVRDataBean ivrDataBean, TariffChangeDetail tariffChangeDetail){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		
		
		List<TariffChangeDetail> tariffChangeDetailList = null;
		try {
			
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_SPSVN_GetMDNTarriffChangeDetail);
			
			/*Setting input parameter*/
			spq.setParameter(Constants.MDN, tariffChangeDetail.getMdn());
			spq.setParameter(Constants.CircleCode, tariffChangeDetail.getCircleId());
			spq.setParameter(Constants.Language, tariffChangeDetail.getLanguageid());
			spq.execute();
		
			/*Storing result set*/
			tariffChangeDetailList = spq.getResultList();
			try {
				tariffChangeDetail = tariffChangeDetailList.get(0);
				if(logger.isDebugEnabled())logger.debug(sessionId+" : TariffChangeDetail to IVR:"+tariffChangeDetail.toString());
			} catch (Exception e) {
				tariffChangeDetail.setTariffDetailPhrase(null);
			}
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), Constants.PROC_SPSVN_GetMDNTarriffChangeDetail, startTime, endTime);
		
		return tariffChangeDetail;
		
	}
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param crmCountInfo
	 * @return
	 *//*
	public CRMCountInfo queryCRMCountInfo(IVRDataBean ivrDataBean, CRMCountInfo crmCountInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		
		
		List<CRMCountInfo> crmCountInfoList = null;
		try {
			
			
			Calling Stored procedure
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetCRMPostpaidCount);
			
			Setting input parameter
			spq.setParameter(Constants.MDN, crmCountInfo.getMdn());
			spq.execute();
						
			Storing result set
			try {
				crmCountInfoList = spq.getResultList();
				if(logger.isDebugEnabled())logger.debug(sessionId+" : TariffChangeDetail to IVR:"+crmCountInfoList.toString());
			} catch (Exception e) {
				crmCountInfo.setCategory1Count("0");
				crmCountInfo.setCategory2Count("0");
				crmCountInfo.setCategory3Count("0");
				crmCountInfo.setCategory4Count("0");
			}
			
			if(logger.isDebugEnabled())logger.debug(sessionId+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			Storing count value from each object of list to straight bean
			try {
				crmCountInfo.setCategory1Count(crmCountInfoList.get(0).getCount());
			} catch (Exception e) {
				crmCountInfo.setCategory1Count("0");
			}
			try {
				crmCountInfo.setCategory2Count(crmCountInfoList.get(1).getCount());
			} catch (Exception e) {
				crmCountInfo.setCategory2Count("0");
			}
			try {
				crmCountInfo.setCategory3Count(crmCountInfoList.get(2).getCount());
			} catch (Exception e) {
				crmCountInfo.setCategory2Count("0");
			}
			try {
				crmCountInfo.setCategory4Count(crmCountInfoList.get(3).getCount());
			} catch (Exception e) {
				crmCountInfo.setCategory2Count("0");
			}
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : CRMCountInfo to IVR:"+crmCountInfoList.toString());
			
		} catch (Exception e) {
			Utils.printStackTrace(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), Constants.PROC_spsvn_GetCRMPrepaidCount, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_GetCRMPrepaidCount, Constants.spsvn_GetCRMPrepaidCount, dateFormat.format(startTime), crmCountInfo.getMdn(), crmCountInfo.toString(), response, response, dateFormat.format(endTime));
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), Constants.PROC_spsvn_GetCRMPrepaidCount, startTime, endTime);
		
		return crmCountInfo;
		
	}*/
	
	@SuppressWarnings("unchecked")
	public Hashtable<String, Hashtable<String, PushSMSInfo>> queryPushSMSInfo(Logger logger, PushSMSInfo pushSMSInfo){
		
		startTime = new Date().getTime();
		List<PushSMSInfo> pushSMSInfoList = null;
		try {
			
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_SPSVN_GetSMSKeyword);
			
			/*Setting input parameter*/
			spq.setParameter(Constants.ApplicationName, pushSMSInfo.getAppName());
			spq.execute();
			
			/*Storing result set*/
			pushSMSInfoList = spq.getResultList();

			if(logger.isDebugEnabled())logger.debug(sessionId+" : CRMCountInfo to IVR:"+pushSMSInfoList.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_SPSVN_GetSMSKeyword, startTime, endTime);
		
		return Utils.getPushSMSInfoHashTable(pushSMSInfoList);
		
	}
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param crmPackInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public CRMPackInfo queryCRMPackInfo(IVRDataBean ivrDataBean, CRMPackInfo crmPackInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		
		
		List<CRMPackInfo> crmPackInfoList = null;
		try {
			
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRReturnPackInfo);
			
			/*Setting input parameter*/
			spq.setParameter(Constants.MDN, crmPackInfo.getMdn());
			spq.execute();
						
			/*Storing result set*/
			crmPackInfoList = spq.getResultList();
			
			System.out.println(crmPackInfoList.toString());
			crmPackInfo = crmPackInfoList.get(0);
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : CRMPackInfo to IVR:"+crmPackInfoList.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			
		} catch (Exception e) {
			Utils.printStackTrace(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), e);
		}
		
		endTime = new Date().getTime();
		Utils.getConnectionTime(ivrDataBean.getLogger(), ivrDataBean.getSessionID(), Constants.PROC_spsvn_IVRReturnPackInfo, startTime, endTime);
		
		return crmPackInfo;
		
	}

	/**
	 * 
	 * @param ivrDataBean
	 * @param dobInfo
	 * @return DOBInfo
	 */
	public DOBInfo queryDOBInfo(IVRDataBean ivrDataBean, DOBInfo dobInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try{
			
			/*Calling stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRGetDobForPostpaidMDN);
			
			/*Assigning input for stored procedure*/
			spq.setParameter(Constants.MDN, dobInfo.getMdn());
			spq.execute();
			
			/*Store the values returned from stored procedure to bean*/
			dobInfo.setDob((String)spq.getOutputParameterValue(Constants.DOB));
			dobInfo.setErrorCode((String)spq.getOutputParameterValue(Constants.o_ErrorCode));
			dobInfo.setErrorDescription((String)spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : DOBInfo to IVR:" +dobInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:" +spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:" +spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		}catch(Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRGetDobForPostpaidMDN, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRGetDobForPostpaidMDN, Constants.spsvn_IVRGetDobForPostpaidMDN, dateFormat.format(startTime), dobInfo.getMdn(), dobInfo.toString(), response, response, dateFormat.format(endTime));
			
		}
		
		
		return dobInfo;
	}
	
	/**
	 * 
	 * @param ivrDataBean
	 * @param barringInfo
	 * @return BarringInfo
	 */
	public BarringInfo queryBarringInfo(IVRDataBean ivrDataBean, BarringInfo barringInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try{
			
			/*Calling stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRGetBarringTypeForPostpaidMDN);
			
			/*Assigning input for stored procedure*/
			spq.setParameter(Constants.MDN, barringInfo.getMdn());
			spq.execute();
			
			/*Store the values returned from stored procedure to bean*/
			barringInfo.setBarringType((String)spq.getOutputParameterValue(Constants.BarringType));
			barringInfo.setErrorCode((String)spq.getOutputParameterValue(Constants.o_ErrorCode));
			barringInfo.setErrorDescription((String)spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : BarringInfo to IVR:" +barringInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:" +spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:" +spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		}catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRGetBarringTypeForPostpaidMDN, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRGetBarringTypeForPostpaidMDN, Constants.spsvn_IVRGetBarringTypeForPostpaidMDN, dateFormat.format(startTime), barringInfo.getMdn(), barringInfo.toString(), response, response, dateFormat.format(endTime));
		}
		
		return barringInfo;
	}
	
	public PromiseToPayInfo queryPromiseToPayInfo(IVRDataBean ivrDataBean, PromiseToPayInfo promiseToPayInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try{
			
			/*Calling stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRGetPromiseToPayInfo);
			
			/*Assigning input for stored procedure*/
			spq.setParameter(Constants.MDN, promiseToPayInfo.getMdn());
			spq.execute();
			
			/*Store the values returned from stored procedure to bean*/
			
			promiseToPayInfo.setPtpRequestDate((String)spq.getOutputParameterValue(Constants.PtpRequestDate));
			promiseToPayInfo.setErrorCode((String)spq.getOutputParameterValue(Constants.o_ErrorCode));
			promiseToPayInfo.setErrorDescription((String)spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : PromiseToPayInfo to IVR:" +promiseToPayInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:" +spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:" +spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		}catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRGetPromiseToPayInfo, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRGetPromiseToPayInfo, Constants.spsvn_IVRGetPromiseToPayInfo, dateFormat.format(startTime), promiseToPayInfo.getMdn(), promiseToPayInfo.toString(), response, response, dateFormat.format(endTime));
		}
		
		return promiseToPayInfo;
	}
	
	public PostpaidCRMCountInfo quetyPostpaidCRMCountInfo(IVRDataBean ivrDataBean, PostpaidCRMCountInfo postpaidCRMCountInfo){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try{
			
			/*Calling stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_GetIVRInteractionHistory_Postpaid);
			
			/*Assigning input for stored procedure*/
			spq.setParameter(Constants.MDN, postpaidCRMCountInfo.getMdn());
			spq.execute();
			
			/*Store the values returned from stored procedure to bean*/
			
			postpaidCRMCountInfo.setFreeUnitCount((String)spq.getOutputParameterValue(Constants.FreeUnitCount));
			postpaidCRMCountInfo.setUnbilledCount((String)spq.getOutputParameterValue(Constants.UnbilledCount));
			postpaidCRMCountInfo.setBilledCount((String)spq.getOutputParameterValue(Constants.BilledCount));
			postpaidCRMCountInfo.setPaymentCount((String)spq.getOutputParameterValue(Constants.PaymentCount));
			postpaidCRMCountInfo.setBillDeliveryCount((String)spq.getOutputParameterValue(Constants.BillDeliveryCount));
			postpaidCRMCountInfo.setErrorCode((String)spq.getOutputParameterValue(Constants.o_ErrorCode));
			postpaidCRMCountInfo.setErrorDescription((String)spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : PostpaidCRMCountInfo to IVR:" +postpaidCRMCountInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:" +spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:" +spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		}catch(Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_GetIVRInteractionHistory_Postpaid, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_GetIVRInteractionHistory_Postpaid, Constants.spsvn_GetIVRInteractionHistory_Postpaid, dateFormat.format(startTime), postpaidCRMCountInfo.getMdn(), postpaidCRMCountInfo.toString(), response, response, dateFormat.format(endTime));
		}
				
		return postpaidCRMCountInfo;
	}
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param dndInfo
	 * @return DNDInfo
	 */
	public DNDInfo queryDNDInfo(IVRDataBean objIVRDataBean, DNDInfo dndInfo){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();
		
		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRDNDInfo);
			spq.setParameter(Constants.MDN, dndInfo.getMdn());
			spq.execute();

			/*Storing output to bean*/
			dndInfo.setActivationDate((String) spq.getOutputParameterValue(Constants.ActivationDate));
			dndInfo.setDeactivationDate((String) spq.getOutputParameterValue(Constants.DeActivationDate));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : DNDInfo to IVR:"+dndInfo.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRDNDInfo, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRDNDInfo, Constants.spsvn_IVRDNDInfo, dateFormat.format(startTime), dndInfo.getMdn(), dndInfo.toString(), response, response, dateFormat.format(endTime));
		}
		
		return dndInfo;
	}
	
	public ValidateMobileNumber queryCSPToValidateMDN(IVRDataBean ivrDataBean, ValidateMobileNumber validateMobileNumber){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRCSPValidateMDN);
			spq.setParameter(Constants.MDN, validateMobileNumber.getMdn());
			spq.execute();

			/*Storing output to bean*/
			validateMobileNumber.setServiceType((String) spq.getOutputParameterValue(Constants.ServiceType));
			validateMobileNumber.setPlanType((String) spq.getOutputParameterValue(Constants.PlanType));
			validateMobileNumber.setValidationFlag((String) spq.getOutputParameterValue(Constants.ValidationFlag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ValidateMobileNumber to IVR:"+validateMobileNumber.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRCSPValidateMDN, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRCSPValidateMDN, Constants.spsvn_IVRCSPValidateMDN, dateFormat.format(startTime), validateMobileNumber.getMdn(), validateMobileNumber.toString(), response, response, dateFormat.format(endTime));
		}

		
		return validateMobileNumber;
		
	}
	
	public RegisterCallBack insertCallBackReuqest(IVRDataBean ivrDataBean, RegisterCallBack registerCallBack){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		
		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRInsertCallbackInfo);
			spq.setParameter(Constants.MDN, registerCallBack.getMdn());
			spq.setParameter(Constants.Circle, registerCallBack.getCircle());
			spq.setParameter(Constants.Language, registerCallBack.getLangugage());
			spq.setParameter(Constants.ApplicationName, registerCallBack.getApplicationName());
			spq.setParameter(Constants.Category, registerCallBack.getCategory());
			spq.execute();

			/*Storing output to bean*/
			registerCallBack.setFlag((String) spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : Register Call back to IVR:"+registerCallBack.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRInsertCallbackInfo, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRInsertCallbackInfo, Constants.spsvn_IVRInsertCallbackInfo, dateFormat.format(startTime), registerCallBack.getMdn(), registerCallBack.toString(), response, response, dateFormat.format(endTime));
		}

		
		return registerCallBack;
		
	}
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param validateCWG
	 * @return
	 */
	public ValidateCWG queryCWGTable(IVRDataBean objIVRDataBean, ValidateCWG validateCWG){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {
			
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVRValidateCWGMDN);
			spq.setParameter(Constants.MDN, validateCWG.getMdn());
			spq.execute();
			
			/*Storing output to bean*/
			validateCWG.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			System.out.println(spq.getOutputParameterValue(Constants.Flag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode:"+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription:"+spq.getOutputParameterValue(Constants.o_ErrorDescription));

		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}finally{
			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_Online_Payment, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRValidateCWGMDN, Constants.spsvn_IVRValidateCWGMDN, dateFormat.format(startTime), validateCWG.getMdn(), validateCWG.getFlag(), response, response, dateFormat.format(endTime));
		}

		return validateCWG;

	}
	
	
	public MDNHotFlashInfo queryMDNHotFlashTable(IVRDataBean objIVRDataBean, MDNHotFlashInfo MDNhotflash){

		startTime = new Date().getTime();
		logger = objIVRDataBean.getLogger();
		sessionId = objIVRDataBean.getSessionID();
		getReportObject = objIVRDataBean.getGetReportObject();

		try {

			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createStoredProcedureQuery(Constants.PROC_MDN_HOTFLASH);
			spq.registerStoredProcedureParameter(Constants.MDN, String.class, ParameterMode.IN);
			spq.registerStoredProcedureParameter(Constants.P_MDN_MSG_OUT, String.class, ParameterMode.OUT);
			
			spq.setParameter(Constants.MDN, MDNhotflash.getMdn());
			spq.execute();
			
			//Storing output to bean*/
			MDNhotflash.setP_MDN_MSG_OUT((String) spq.getOutputParameterValue(Constants.P_MDN_MSG_OUT));
			
			
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : MDNhotflash to IVR:"+MDNhotflash.toString());
			
		} catch (Exception e) {
			Utils.printStackTrace(logger, sessionId, e);
		}
		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.IVR_MDN_PROC_HOTFLASH, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.IVR_MDN_PROC_HOTFLASH, Constants.PROC_MDN_HOTFLASH, dateFormat.format(startTime), MDNhotflash.getMdn(), MDNhotflash.getP_MDN_MSG_OUT(), response, response, dateFormat.format(endTime));
		
		return MDNhotflash;
	}
	//-------------Low ARPU changes-------
	
		public LowARPUInfo queryLowARPU(IVRDataBean objIVRDataBean, LowARPUInfo LowARPU ){
			
			startTime = new Date().getTime();
			logger = objIVRDataBean.getLogger();
			sessionId = objIVRDataBean.getSessionID();
			getReportObject = objIVRDataBean.getGetReportObject();
			
			try {

				/*calling Stored procedure*/
				StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_Check_LowARPU);
				
				/*Assigning Input for stored procedure*/
				spq.setParameter(Constants.MDN, LowARPU.getMdn());
				spq.execute();
				
				/*Stored the values returned to the bean*/
				LowARPU.setARPUStatus((String) spq.getOutputParameterValue(Constants.ARPUStatus));
				
			
				if(logger.isDebugEnabled())logger.debug(sessionId+" : LowARPUInfo to IVR:"+LowARPU.toString());
				

			} catch (Exception e) {
				response = Constants.FAILURE;
				Utils.printStackTrace(logger, sessionId, e);
			} 

			endTime = new Date().getTime();
			Utils.getConnectionTime(logger, sessionId, Constants.PROC_Check_LowARPU, startTime, endTime);
			Utils.generateReport(getReportObject, Constants.PROC_Check_LowARPU, Constants.PROC_Check_LowARPU, dateFormat.format(startTime), LowARPU.getMdn(), LowARPU.getARPUStatus(), response, response, dateFormat.format(endTime));
			
			return LowARPU;
		}
		

}

