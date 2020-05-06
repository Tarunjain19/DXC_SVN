package com.rcom.prepaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.prepaid.resource.Constants;


/**
 * 
 * @author Tarun Jain
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_FETCH_MDN_IVR4GSIM, procedureName = Constants.USP_FETCH_MDN_IVR4GSIM,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.HardCodeStatus, type = String.class),
		
})
public class FourGHardCodeInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String HardCode_status;

	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	
	public String getHardCode_status() {
		return HardCode_status;
	}
	public void setHardCode_status(String hardCode_status) {
		HardCode_status = hardCode_status;
	}

	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append("HardCode_status:"+HardCode_status+"]");
		return builder.toString();
	}


}
