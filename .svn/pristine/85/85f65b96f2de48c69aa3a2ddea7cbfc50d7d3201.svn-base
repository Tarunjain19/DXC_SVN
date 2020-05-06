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
 * @author Tarun Jain
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_MDN_HOTFLASH, procedureName = Constants.IVR_MDN_PROC_HOTFLASH,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.P_MDN_MSG_OUT, type = String.class)
})

public class MDNHotFlashInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String P_MDN_MSG_OUT;
	
	
	
	public String getMdn() {
		return mdn;
	}



	public void setMdn(String mdn) {
		this.mdn = mdn;
	}



	



	public String getP_MDN_MSG_OUT() {
		return P_MDN_MSG_OUT;
	}



	public void setP_MDN_MSG_OUT(String p_MDN_MSG_OUT) {
		P_MDN_MSG_OUT = p_MDN_MSG_OUT;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append("P_ERR_MSG_OUT:"+P_MDN_MSG_OUT+"]");
		return builder.toString();
	}


}
