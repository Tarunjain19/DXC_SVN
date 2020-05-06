package com.rcom.postpaid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_SPSVN_GetSMSKeyword, procedureName = Constants.SPSVN_GetSMSKeyword, resultClasses = com.rcom.postpaid.model.PushSMSInfo.class,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class PushSMSInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Id
	@Column(name = Constants.SMSKeyword)
	private String smsKeyword;
	@Id
	@Column(name = Constants.SuccessText)
	private String smsText;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getSmsKeyword() {
		return smsKeyword;
	}
	public void setSmsKeyword(String smsKeyword) {
		this.smsKeyword = smsKeyword;
	}
	public String getSmsText() {
		return smsText;
	}
	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ApplicationName:"+appName);
		builder.append("CircleId:"+circleId);
		builder.append(", SMSKeyword:"+smsKeyword);
		builder.append(", SMSText:"+smsText+"]");
		return builder.toString();
	}

}
