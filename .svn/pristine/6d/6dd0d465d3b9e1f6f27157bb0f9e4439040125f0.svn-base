package com.rcom.postpaid.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.postpaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_IVRCSPValidateMDN, procedureName = Constants.spsvn_IVRCSPValidateMDN,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name=Constants.MDN, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.ServiceType, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.PlanType, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.ValidationFlag, type = String.class)
	
})
public class ValidateMobileNumber {
	
	@Id
	private String mdn;
	@Transient
	private String serviceType;
	@Transient
	private String planType;
	@Transient
	private String validationFlag;
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getPlanType() {
		return planType;
	}
	public void setPlanType(String planType) {
		this.planType = planType;
	}
	public String getValidationFlag() {
		return validationFlag;
	}
	public void setValidationFlag(String validationFlag) {
		this.validationFlag = validationFlag;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", ServiceType:"+serviceType);
		builder.append(", PlanType:"+planType);
		builder.append(", ValidationFlag:"+validationFlag+"]");
		return builder.toString();
	}

}
