package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.postpaid.resource.Constants;


/**
 * 
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_Check_LowARPU, procedureName = Constants.USP_FETCH_MDN_LowARPU,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.ARPUStatus, type = String.class),
		
})
public class LowARPUInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String arpu_status;

	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getARPUStatus() {
		return arpu_status;
	}
	public void setARPUStatus(String arpu_status) {
		this.arpu_status = arpu_status;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append("arpu_status:"+arpu_status+"]");
		return builder.toString();
	}


}
