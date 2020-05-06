package com.rcom.red.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.rcom.red.model.IVRRoutingInfo;
import com.rcom.red.model.TransferVDNInfo;
import com.rcom.red.model.ValidateRedMDN;
import com.rcom.red.resource.Constants;
import com.rcom.red.util.Utils;
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
	Utils utils = null;
	
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
		utils = new Utils();
		
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
			utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_DNISRouting, startTime, endTime);
		utils.generateReport(getReportObject, Constants.SP_IVR_DNISRouting, Constants.SP_IVR_DNISRouting, dateFormat.format(startTime), ivrRoutingInfo.getDnis(), ivrRoutingInfo.getCircle()+Constants.PIPE+ivrRoutingInfo.getDefaultLanguage(), response, response, dateFormat.format(endTime));

		return ivrRoutingInfo;

	}
	
	public ValidateRedMDN queryRedMDNHardCodingInfo(IVRDataBean ivrDataBean, ValidateRedMDN validateRedMDN){
		
		startTime = new Date().getTime();
		logger = ivrDataBean.getLogger();
		sessionId = ivrDataBean.getSessionID();
		getReportObject = ivrDataBean.getGetReportObject();
		utils = new Utils();
		
		try {
			/*Calling Stored procedure*/
			StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery(Constants.PROC_spsvn_IVROtherCallFlowRED);
			spq.setParameter(Constants.MDN, validateRedMDN.getMdn());
			spq.setParameter(Constants.DataType, validateRedMDN.getDataType());
			spq.setParameter(Constants.ApplicationName, validateRedMDN.getAppName());
			spq.execute();

			/*Storing output to the bean*/
			validateRedMDN.setFlag((String) spq.getOutputParameterValue(Constants.Flag));
			
			if(logger.isDebugEnabled())logger.debug(sessionId+" : IVRRoutingInfo to IVR:"+validateRedMDN.toString());
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorCode : "+spq.getOutputParameterValue(Constants.o_ErrorCode));
			if(logger.isDebugEnabled())logger.debug(sessionId+" : ErrorDescription : "+spq.getOutputParameterValue(Constants.o_ErrorDescription));
			
		} catch (Exception e) {
			utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		utils.getConnectionTime(logger, sessionId, Constants.PROC_spsvn_IVROtherCallFlow, startTime, endTime);
		utils.generateReport(getReportObject, Constants.PROC_spsvn_IVROtherCallFlowRED, Constants.spsvn_IVROtherCallFlowRED, dateFormat.format(startTime), validateRedMDN.getMdn(), validateRedMDN.getFlag(), response, response, dateFormat.format(endTime));
		
		return validateRedMDN;
		
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
		utils = new Utils();
		
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
			utils.printStackTrace(logger, sessionId, e);
		}

		endTime = new Date().getTime();
		utils.getConnectionTime(logger, sessionId, Constants.PROC_IVR_IVR_VDNTransfer, startTime, endTime);
		utils.generateReport(getReportObject, Constants.PROC_IVR_IVR_VDNTransfer, Constants.SP_IVR_IVR_VDNTransfer, dateFormat.format(startTime), transferVDNInfo.getAppName()+Constants.PIPE+transferVDNInfo.getCircle()+Constants.PIPE+transferVDNInfo.getLanguage()+Constants.PIPE+Constants.TransferReasonCode, transferVDNInfo.getTransferVDN1()+Constants.PIPE+transferVDNInfo.getTransferVDN2(), response, response, dateFormat.format(endTime));

		
		return transferVDNInfo;
	}
	
}
