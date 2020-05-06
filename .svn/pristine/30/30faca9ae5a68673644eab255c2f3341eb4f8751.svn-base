package com.rcom.red.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.red.resource.Constants;


@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_IVROtherCallFlowRED, procedureName = Constants.spsvn_IVROtherCallFlowRED,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name=Constants.MDN, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name=Constants.DataType, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name=Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.Flag, type = String.class)
	
})
public class ValidateRedMDN {
	
	@Id
	@Transient
	private String appName;
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String flag;
	@Transient
	private String dataType;
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ApplicationName:"+appName);
		builder.append(", MDN:"+mdn);
		builder.append(", DataType:"+dataType);
		builder.append(", ValidationFlag:"+flag+"]");
		return builder.toString();
	}

}
