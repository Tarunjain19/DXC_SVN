package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.postpaid.resource.Constants;


@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_spsvn_IVRGetBarringTypeForPostpaidMDN, procedureName = Constants.spsvn_IVRGetBarringTypeForPostpaidMDN,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.BarringType, type = String.class)
})
public class BarringInfo {

	@Id
	@Column (name = Constants.MDN)
	private String mdn;
	@Transient
	private String errorCode;
	@Transient
	private String errorDescription;
	@Transient
	private String barringType;
	
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getBarringType() {
		return barringType;
	}
	public void setBarringType(String barringType) {
		this.barringType = barringType;
	}
	
	
	@Override
	public String toString() {
	
		StringBuilder builder = new StringBuilder(50);
		builder.append("[MDN:" +mdn);
		builder.append("|BarringType:" +barringType);
		builder.append("|ErrorCode:"+errorCode);
		builder.append("|ErrorDescription:"+errorDescription+"]");
	return builder.toString();
	}
	
	
	
}