package com.rcom.dnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.dnd.resource.Constants;


/**
 * 
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_SRC_Count_Update, procedureName = Constants.IVR_SRC_Count_Update,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.Flag, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class SRCInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String flag;
	@Transient
	private String circleId;
	@Transient
	private String appname;
	
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
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", Circle:"+circleId);
		builder.append(", Appname :"+appname);
		builder.append("Flag:"+flag+"]");
		return builder.toString();
	}


}
