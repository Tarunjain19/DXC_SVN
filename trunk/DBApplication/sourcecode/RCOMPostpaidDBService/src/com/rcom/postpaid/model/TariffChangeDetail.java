package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_SPSVN_GetMDNTarriffChangeDetail, procedureName = Constants.SPSVN_GetMDNTarriffChangeDetail, resultClasses = com.rcom.postpaid.model.TariffChangeDetail.class, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.CircleCode, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Language, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class TariffChangeDetail {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Column(name = Constants.TariffDetailPhrase)
	private String tariffDetailPhrase;
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Column(name = Constants.LanguageCode)
	private String languageid;
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getTariffDetailPhrase() {
		return tariffDetailPhrase;
	}
	public void setTariffDetailPhrase(String tariffDetailPhrase) {
		this.tariffDetailPhrase = tariffDetailPhrase;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getLanguageid() {
		return languageid;
	}
	public void setLanguageid(String languageid) {
		this.languageid = languageid;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", CircleId:"+circleId);
		builder.append(", Language:"+languageid);
		builder.append(", TariffDetailPhrase:"+tariffDetailPhrase+"]");
		return builder.toString();
	}

}
