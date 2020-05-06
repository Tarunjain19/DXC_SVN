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
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_IVR_DNISRouting, procedureName = Constants.SP_IVR_DNISRouting, resultClasses = com.rcom.postpaid.model.IVRRoutingInfo.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name=Constants.DNIS, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.TrunkGroup, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.Circle, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.Languages, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name=Constants.DefaultLanguage, type = String.class)
	
})
public class IVRRoutingInfo {
	
	@Id
	@Column(name = Constants.DNIS)
	private String dnis;
	@Transient
	private String trunkGroup;
	@Transient
	private String circle;
	@Transient
	private String language;
	@Transient
	private String defaultLanguage;
	
	public String getDnis() {
		return dnis;
	}
	public void setDnis(String dnis) {
		this.dnis = dnis;
	}
	public String getTrunkGroup() {
		return trunkGroup;
	}
	public void setTrunkGroup(String trunkGroup) {
		this.trunkGroup = trunkGroup;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDefaultLanguage() {
		return defaultLanguage;
	}
	public void setDefaultLanguage(String defaultLanguage) {
		this.defaultLanguage = defaultLanguage;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[DNIS:"+dnis);
		builder.append(", TrunkGroup:"+trunkGroup);
		builder.append(", Circle:"+circle);
		builder.append(", DefaultLanguage:"+defaultLanguage);
		builder.append(", Languages:"+language+"]");
		return builder.toString();
	}
	

}
