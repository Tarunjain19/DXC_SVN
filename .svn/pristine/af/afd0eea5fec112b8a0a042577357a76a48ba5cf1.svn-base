package com.rcom.prepaid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.prepaid.resource.Constants;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_PREF_LANG_Insert_Update, procedureName = Constants.SP_IVR_PREF_LANG_Insert_Update,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.MDN, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.LanguageCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.Flag, type = String.class)
})
public class UpdateLanguage {
	
	@Id
	@Column(name = Constants.MDN)
	private String mdn;
	@Column(name = Constants.LanguageCode)
	private String languageCode;
	@Column(name = Constants.Flag)
	private String flag;
	
	public String getMdn() {
		return mdn;
	}
	public void setMdn(String mdn) {
		this.mdn = mdn;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
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
		builder.append(", LanguageCode:"+languageCode);
		builder.append(", Flag:"+flag+"]");
		return builder.toString();
	}

}
