package com.rcom.postpaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Transient;

import com.rcom.postpaid.resource.Constants;

@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_CSP, procedureName = Constants.SP_IVR_CSP,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.SERVICE, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.HNIPRE, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.BARRINGLIST, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.PREFLANG, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.RTN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.DOB, type = String.class)
		
})
public class IVRCspInfo {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Transient
	private String service;
	@Transient
	private String hnipre;
	@Transient
	private String barringList;
	@Column(name = Constants.PREF_LANG)
	private String preLang;
	@Transient
	private String strRTN;
	private String errorDescription;
	private String errorCode;
	private String flag;
	private String dob;
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getHnipre() {
		return hnipre;
	}
	public void setHnipre(String hnipre) {
		this.hnipre = hnipre;
	}
	public String getBarringList() {
		return barringList;
	}
	public void setBarringList(String barringList) {
		this.barringList = barringList;
	}
	public String getPreLang() {
		return preLang;
	}
	public void setPreLang(String preLang) {
		this.preLang = preLang;
	}
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getStrRTN() {
		return strRTN;
	}
	public void setStrRTN(String strRTN) {
		this.strRTN = strRTN;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[MDN:"+mdn);
		builder.append(", BarringList:"+barringList);
		builder.append(", Service:"+service);
		builder.append(", PreLang:"+preLang);
		builder.append(", HniPre:"+hnipre);
		builder.append(", UpdateFlag:"+flag);
		builder.append(", Retention:"+strRTN);
		builder.append(", DOB:"+dob);
		builder.append(", ErrorCode:"+errorCode);
		builder.append(", ErrorDescription:"+errorDescription+"]");
		return builder.toString();
	}
	

}
