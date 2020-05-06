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
@NamedStoredProcedureQuery(name = Constants.PROC_spsvn_IVRDNDInfo, procedureName = Constants.spsvn_IVRDNDInfo, parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN,  type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.ActivationDate, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.DeActivationDate, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class DNDInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String activationDate;
	@Transient
	private String deactivationDate;
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}
	public String getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(String deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(",ActivationDate:"+activationDate);
		builder.append("DeactivationDate:"+deactivationDate+"]");
		return builder.toString();
	}
}
