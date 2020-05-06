package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_IVR_VDNTransfer, procedureName = Constants.SP_IVR_IVR_VDNTransfer,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Language, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Circle, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.CustomerSegment, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.CallType, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.TransferReasonCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.TransferVDN1, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.TransferVDN2, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.SkillName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class TransferVDNInfo {

	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Column(name = Constants.Language)
	private String language;
	@Column(name = Constants.Circle)
	private String circle;
	@Column(name = Constants.CustomerSegment)
	private String customerSegment;
	@Column(name = Constants.CallType)
	private String callType;
	@Column(name = Constants.TransferVDN1)
	private String transferVDN1;
	@Column(name = Constants.TransferVDN2)
	private String transferVDN2;
	@Column(name = Constants.SkillName)
	private String skillName;
	@Column(name = Constants.TransferReasonCode)
	private String transferReasonCode;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getCustomerSegment() {
		return customerSegment;
	}
	public void setCustomerSegment(String customerSegment) {
		this.customerSegment = customerSegment;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	public String getTransferVDN1() {
		return transferVDN1;
	}
	public void setTransferVDN1(String transferVDN1) {
		this.transferVDN1 = transferVDN1;
	}
	public String getTransferVDN2() {
		return transferVDN2;
	}
	public void setTransferVDN2(String transferVDN2) {
		this.transferVDN2 = transferVDN2;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getTransferReasonCode() {
		return transferReasonCode;
	}
	public void setTransferReasonCode(String transferReasonCode) {
		this.transferReasonCode = transferReasonCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", Language:"+language);
		builder.append(", Circle:"+circle);
		builder.append(", CustomerSegment:"+customerSegment);
		builder.append(", CallType:"+callType);
		builder.append(", TransferReasonCode:"+transferReasonCode);
		builder.append(", TransferVDN1:"+transferVDN1);
		builder.append(", TransferVDN2:"+transferVDN2);
		builder.append(", SkillName:"+skillName+"]");
		return builder.toString();
	}
	
}
