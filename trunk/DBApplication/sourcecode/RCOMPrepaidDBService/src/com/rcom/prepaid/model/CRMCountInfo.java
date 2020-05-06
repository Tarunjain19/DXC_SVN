package com.rcom.prepaid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.prepaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetCRMPrepaidCount, procedureName = Constants.spsvn_GetCRMPrepaidCount, resultClasses = com.rcom.prepaid.model.CRMCountInfo.class, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class CRMCountInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	

	@Column(name = Constants.MDN)
	private String mdn;
	@Id
	@Column(name = Constants.Category)
	private String category;
	@Column(name = Constants.Count)
	private String count;
	@Transient
	private String category1Count;
	@Transient
	private String category2Count;
	@Transient
	private String category3Count;
	@Transient
	private String category4Count;
	
	
	public String getCategory1Count() {
		return category1Count;
	}
	public void setCategory1Count(String category1Count) {
		this.category1Count = category1Count;
	}
	public String getCategory2Count() {
		return category2Count;
	}
	public void setCategory2Count(String category2Count) {
		this.category2Count = category2Count;
	}
	public String getCategory3Count() {
		return category3Count;
	}
	public void setCategory3Count(String category3Count) {
		this.category3Count = category3Count;
	}
	public String getCategory4Count() {
		return category4Count;
	}
	public void setCategory4Count(String category4Count) {
		this.category4Count = category4Count;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", Category1Count:"+category1Count);
		builder.append(", Category2Count:"+category2Count);
		builder.append(", Category3Count:"+category3Count);
		builder.append(", Category4Count:"+category4Count);
		builder.append(", Count:"+count+"]");
		return builder.toString();
	}

}
