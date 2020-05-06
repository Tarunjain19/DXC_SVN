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
@NamedStoredProcedureQuery(name = Constants.PROC_spsvn_IVRInsertCallbackInfo, procedureName = Constants.spsvn_IVRInsertCallbackInfo, resultClasses =com.rcom.postpaid.model.RegisterCallBack.class,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Circle, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Language, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Category, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class RegisterCallBack {
	
	@Transient
	private String applicationName;
	@Transient
	private String langugage;
	@Transient
	private String category;
	@Transient
	private String circle;
	@Id
	@Column(name = Constants.ApplicationName)
	private String mdn;
	@Transient
	private String flag;
	
	public String getApplicationName() {
		return applicationName;
	}
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	public String getLangugage() {
		return langugage;
	}
	public void setLangugage(String langugage) {
		this.langugage = langugage;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
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
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("[ApplicationName:"+applicationName);
		builder.append(", Circle:"+circle);
		builder.append(", Language:"+langugage);
		builder.append(", MDN:"+mdn);
		builder.append(", Category:"+category);
		builder.append(", Flag:"+flag+"]");
		
		return builder.toString();
	}
	
	
}
