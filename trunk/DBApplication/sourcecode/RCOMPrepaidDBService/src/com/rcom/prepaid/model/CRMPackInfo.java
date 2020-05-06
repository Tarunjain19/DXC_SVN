package com.rcom.prepaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.prepaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_IVRReturnPackInfo, procedureName = Constants.spsvn_IVRReturnPackInfo, resultClasses = com.rcom.prepaid.model.CRMPackInfo.class, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class CRMPackInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Column(name = Constants.PackName)
	private String packName;
	@Column(name = Constants.ExpiryDate)
	private String expiryDate;
	
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append("PackName:"+packName);
		builder.append("ExpiryDate:"+expiryDate+"]");
		return builder.toString();
	}
}
