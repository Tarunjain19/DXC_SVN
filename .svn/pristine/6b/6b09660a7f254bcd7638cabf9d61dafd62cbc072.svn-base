package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;


@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_IVRValidateCWGMDN, procedureName = Constants.spsvn_IVRValidateCWGMDN, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.Flag, type  = String.class)
})
public class ValidateCWG {

	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	private String flag;
	
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
		builder.append("[MDN:"+mdn);
		builder.append(", Flag:"+flag+"]");
		return builder.toString();
		
	}
	
}
