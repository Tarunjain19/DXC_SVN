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
@NamedStoredProcedureQuery (name = Constants.PROC_spsvn_GetIVRInteractionHistory_Postpaid, procedureName = Constants.spsvn_GetIVRInteractionHistory_Postpaid,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.FreeUnitCount, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.UnbilledCount, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.BilledCount, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.PaymentCount, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.BillDeliveryCount, type = String.class)
})

public class PostpaidCRMCountInfo {

	@Id
	@Column (name = Constants.MDN)
	private String mdn;
	@Transient
	private String errorCode;
	@Transient
	private String errorDescription;
	@Transient
	private String freeUnitCount;
	@Transient
	private String unbilledCount;
	@Transient
	private String billedCount;
	@Transient
	private String paymentCount;
	@Transient
	private String billDeliveryCount;
	
	
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
	public String getFreeUnitCount() {
		return freeUnitCount;
	}
	public void setFreeUnitCount(String freeUnitCount) {
		this.freeUnitCount = freeUnitCount;
	}
	public String getUnbilledCount() {
		return unbilledCount;
	}
	public void setUnbilledCount(String unbilledCount) {
		this.unbilledCount = unbilledCount;
	}
	public String getBilledCount() {
		return billedCount;
	}
	public void setBilledCount(String billedCount) {
		this.billedCount = billedCount;
	}
	public String getPaymentCount() {
		return paymentCount;
	}
	public void setPaymentCount(String paymentCount) {
		this.paymentCount = paymentCount;
	}
	public String getBillDeliveryCount() {
		return billDeliveryCount;
	}
	public void setBillDeliveryCount(String billDeliveryCount) {
		this.billDeliveryCount = billDeliveryCount;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("[MDN:" +mdn);
		builder.append("|Free Unit Count:" +freeUnitCount);
		builder.append("|Unbilled Count:" +unbilledCount);
		builder.append("|Billed Count:" +billedCount);
		builder.append("|Payment Count:" +paymentCount);
		builder.append("|BillDelivery Count:" +billDeliveryCount);
		builder.append("|ErrorCode:"+errorCode);
		builder.append("|ErrorDescription:"+errorDescription+"]");
	return builder.toString();
	}
	
	
}
