package com.rcom.dnd.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rcom.dnd.model.DNDInfo;
import com.rcom.dnd.model.IVRRoutingInfo;
import com.rcom.dnd.model.TransferVDNInfo;
import com.rcom.dnd.resource.Constants;
import com.rcom.dnd.util.Utils;
import com.rcom.dnd.model.SRCInfo;
import com.servion.prepaid.report.GetReportObject;
import com.servion.util.IVRDataBean;

@Repository
public class IVRDBDaoRepository extends GenericEntityManager {
	
	private long startTime;
	private long endTime;
	Logger logger = null;
	String response = Constants.SUCCESS;
	String sessionId = "Load on Start UP";
	GetReportObject getReportObject = null;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
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
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_DNISRouting, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.SP_IVR_DNISRouting, Constants.SP_IVR_DNISRouting, dateFormat.format(startTime), ivrRoutingInfo.getDnis(), ivrRoutingInfo.getCircle()+Constants.PIPE+ivrRoutingInfo.getDefaultLanguage(), response, response, dateFormat.format(endTime));

		return ivrRoutingInfo;

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
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			response = Constants.FAILURE;
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_IVR_VDNTransfer, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.PROC_IVR_IVR_VDNTransfer, Constants.SP_IVR_IVR_VDNTransfer, dateFormat.format(startTime), transferVDNInfo.getAppName()+Constants.PIPE+transferVDNInfo.getCircle()+Constants.PIPE+transferVDNInfo.getLanguage()+Constants.PIPE+Constants.TransferReasonCode, transferVDNInfo.getTransferVDN1()+Constants.PIPE+transferVDNInfo.getTransferVDN2(), response, response, dateFormat.format(endTime));

		
		return transferVDNInfo;
	}
	
	/**
	 * 
	 * @param objIVRDataBean
	 * @param transferVDNInfo
	 * @return
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
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVRDNDInfo, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRDNDInfo, Constants.spsvn_IVRDNDInfo, dateFormat.format(startTime), dndInfo.getMdn(), dndInfo.getActivationDate()+Constants.PIPE+dndInfo.getDeactivationDate(), response, response, dateFormat.format(endTime));
		//Utils.generateReport(getReportObject, Constants.PROC_spsvn_IVRDNDInfo, Constants.spsvn_IVRDNDInfo, dateFormat.format(startTime), dndInfo.getMdn(), dndInfo.getActivationDate()+, response, dateFormat.format(endTime));

		
		return dndInfo;
	}
	
	
	// 	//SRC Barring info & counter update 21-Mar16
	
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
			Utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		Utils.getConnectionTime(logger, sessionId, Constants.SP_IVR_SRC_Check, startTime, endTime);
		Utils.generateReport(getReportObject, Constants.SP_IVR_SRC_Check, Constants.IVR_SRC_Count_Update, dateFormat.format(startTime), srcInfo.getMdn(), srcInfo.getFlag(), response, response, dateFormat.format(endTime));
		
		return srcInfo;
	}
}
