package com.rcom.postpaid.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import com.rcom.postpaid.resource.Constants;

/**
 * 
 * @author deepanyuvaraja.r
 *
 */

@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetPlanVoucherDenomination, procedureName = Constants.spsvn_GetPlanVoucherDenomination, resultClasses = com.rcom.postpaid.model.RechargePlanInfo.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class RechargePlanInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Id
	@Column(name = Constants.LanguageCode)
	private String language;
	@Column(name = Constants.DenominationPhrase)
	private String denominationPhrase;
	@Column(name = Constants.RupeesPhrase)
	private String amountPhrase;
	@Column(name = Constants.DaysPhrase)
	private String validityPhrase;
	@Id
	@Column(name = Constants.MenuOption)
	private String menuOption;
	@Column(name = Constants.IsActive)
	private String status;
	@Column(name = Constants.TalkTimePhrase)
	private String talkTimePhrase;
	@Column(name = Constants.MRP)
	private String mrp;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDenominationPhrase() {
		return denominationPhrase;
	}
	public void setDenominationPhrase(String denominationPhrase) {
		this.denominationPhrase = denominationPhrase;
	}
	public String getAmountPhrase() {
		return amountPhrase;
	}
	public void setAmountPhrase(String amountPhrase) {
		this.amountPhrase = amountPhrase;
	}
	public String getValidityPhrase() {
		return validityPhrase;
	}
	public void setValidityPhrase(String validityPhrase) {
		this.validityPhrase = validityPhrase;
	}
	public String getMenuOption() {
		return menuOption;
	}
	public void setMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getTalkTimePhrase() {
		return talkTimePhrase;
	}
	public void setTalkTimePhrase(String talkTimePhrase) {
		this.talkTimePhrase = talkTimePhrase;
	}
	public String getMrp() {
		return mrp;
	}
	public void setMrp(String mrp) {
		this.mrp = mrp;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(",CircleID:"+circleId);
		builder.append(",Denomination:"+denominationPhrase);
		builder.append(",Amount:"+amountPhrase);
		builder.append(", Validity:"+validityPhrase);
		builder.append(", TalkTime:"+talkTimePhrase);
		builder.append(", MRP:"+mrp);
		builder.append(", ActiveStatus:"+status+"]");
		return builder.toString();
	}
	
	
	
}
