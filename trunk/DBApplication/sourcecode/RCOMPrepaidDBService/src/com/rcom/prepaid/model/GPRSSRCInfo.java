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
@NamedStoredProcedureQuery(name = Constants.PROC_COUNTER_BARRING, procedureName = Constants.IVR_GPRS_PROC_COUNTER_BARRING,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.P_LOB_ID, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.P_COUNTER_SEGMENT_IN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.P_BMBAR_STATUS, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.P_SUCC_FAIL_MSG_OUT, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.P_ERR_MSG_OUT, type = String.class)
})

public class GPRSSRCInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String P_BMBAR_STATUS;
	@Transient
	private String P_LOB_ID;
	@Transient
	private String P_COUNTER_SEGMENT_IN;
	@Transient
	private String P_SUCC_FAIL_MSG_OUT;
	@Transient
	private String P_ERR_MSG_OUT;
	
	
	
	public String getMdn() {
		return mdn;
	}



	public void setMdn(String mdn) {
		this.mdn = mdn;
	}



	public String getP_BMBAR_STATUS() {
		return P_BMBAR_STATUS;
	}



	public void setP_BMBAR_STATUS(String p_BMBAR_STATUS) {
		P_BMBAR_STATUS = p_BMBAR_STATUS;
	}



	public String getP_LOB_ID() {
		return P_LOB_ID;
	}



	public void setP_LOB_ID(String p_LOB_ID) {
		P_LOB_ID = p_LOB_ID;
	}



	public String getP_COUNTER_SEGMENT_IN() {
		return P_COUNTER_SEGMENT_IN;
	}



	public void setP_COUNTER_SEGMENT_IN(String p_COUNTER_SEGMENT_IN) {
		P_COUNTER_SEGMENT_IN = p_COUNTER_SEGMENT_IN;
	}



	public String getP_SUCC_FAIL_MSG_OUT() {
		return P_SUCC_FAIL_MSG_OUT;
	}



	public void setP_SUCC_FAIL_MSG_OUT(String p_SUCC_FAIL_MSG_OUT) {
		P_SUCC_FAIL_MSG_OUT = p_SUCC_FAIL_MSG_OUT;
	}



	public String getP_ERR_MSG_OUT() {
		return P_ERR_MSG_OUT;
	}



	public void setP_ERR_MSG_OUT(String p_ERR_MSG_OUT) {
		P_ERR_MSG_OUT = p_ERR_MSG_OUT;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", P_LOB_ID:"+P_LOB_ID);
		builder.append(", P_COUNTER_SEGMENT_IN :"+P_COUNTER_SEGMENT_IN);
		builder.append("P_BMBAR_STATUS:"+P_BMBAR_STATUS+"]");
		return builder.toString();
	}


}
