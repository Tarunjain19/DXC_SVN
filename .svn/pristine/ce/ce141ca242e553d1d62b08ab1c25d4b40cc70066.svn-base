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

/**
 * 
 * @author deepanyuvaraja.r
 *
 */
@Entity
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetOfferApplication, procedureName = Constants.spsvn_GetOfferApplication, resultClasses = com.rcom.prepaid.model.CircleOffersInfo.class, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.OfferType, type  = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class CircleOffersInfo implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	@Column(name = Constants.StartDate)
	private String startDate;
	@Column(name = Constants.EndDate)
	private String endDate;
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Id
	@Column(name = Constants.LanguageCode)
	private String language;
	@Transient
	private String offerType;
	@Id
	@Column(name = Constants.OfferCode)
	private String offerCode;
	@Column(name = Constants.IsActive)
	private String status;
	@Column(name = Constants.OfferCategoryPhrase)
	private String OfferCategoryPhrase;
	@Column(name  = Constants.OfferDetailPhrase)
	private String OfferDetailPhrase;
	@Id
	@Column(name = Constants.MenuOptionId)
	private String MenuOption;
	

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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getOfferType() {
		return offerType;
	}
	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOfferCategoryPhrase() {
		return OfferCategoryPhrase;
	}
	public void setOfferCategoryPhrase(String offerCategoryPhrase) {
		OfferCategoryPhrase = offerCategoryPhrase;
	}
	public String getOfferDetailPhrase() {
		return OfferDetailPhrase;
	}
	public void setOfferDetailPhrase(String offerDetailPhrase) {
		OfferDetailPhrase = offerDetailPhrase;
	}
	public String getMenuOption() {
		return MenuOption;
	}
	public void setMenuOption(String menuOption) {
		MenuOption = menuOption;
	}
	public String getOfferCode() {
		return offerCode;
	}
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", CircleId:"+circleId);
		builder.append(", StartDate:"+startDate);
		builder.append(", EndDate:"+endDate);
		builder.append(", Language:"+language);
		builder.append(", OfferType:"+offerType);
		builder.append(", OfferCode:"+offerCode);
		builder.append(", Status:"+status);
		builder.append(", OfferCategoryPhrase:"+OfferCategoryPhrase);
		builder.append(", OfferDetailPhrase:"+OfferDetailPhrase);
		builder.append(", MenuOptions:"+MenuOption+"]");
		return builder.toString();
	}
	
	
	
	


}
