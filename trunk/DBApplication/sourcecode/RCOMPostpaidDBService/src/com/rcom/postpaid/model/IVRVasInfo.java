package com.rcom.postpaid.model;

import java.io.Serializable;

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
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_VAS, procedureName = Constants.SP_IVR_VAS, resultClasses =com.rcom.postpaid.model.IVRVasInfo.class,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})

public class IVRVasInfo implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	//@Column(name = Constants.ID)
	@Transient
	private String id;
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.PackCode)
	private String packCode;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	//@Column(name = Constants.MenuOption)
	@Transient
	private String menuOption;
	@Id
	@Column(name = Constants.LanguageCode)
	private String languageCode;
	@Column(name = Constants.OfferCategoryPhrase)
	private String offerCategoryPhrase;
	@Column(name = Constants.OfferMessagePhrase)
	private String offerDetailPhrase;
	@Column(name = Constants.Res1)
	private String Price;
	@Column(name = Constants.Res2)
	private String Validiy_Type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	public String getMenuOption() {
		return menuOption;
	}
	public void setMenuOption(String menuOption) {
		this.menuOption = menuOption;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getOfferCategoryPhrase() {
		return offerCategoryPhrase;
	}
	public void setOfferCategoryPhrase(String offerCategoryPhrase) {
		this.offerCategoryPhrase = offerCategoryPhrase;
	}
	public String getOfferDetailPhrase() {
		return offerDetailPhrase;
	}
	public void setOfferDetailPhrase(String offerDetailPhrase) {
		this.offerDetailPhrase = offerDetailPhrase;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getPackCode() {
		return packCode;
	}
	public void setPackCode(String packCode) {
		this.packCode = packCode;
	}
	
	
	
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getValidiy_Type() {
		return Validiy_Type;
	}
	public void setValidiy_Type(String validiy_Type) {
		Validiy_Type = validiy_Type;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ApplicationName:"+appName);
		builder.append(", CircleId:"+circleId);
		builder.append(", LanguageId:"+languageCode);
		builder.append(", OfferCategoryPhrase:"+offerCategoryPhrase);
		builder.append(", OfferDetailPhrase:"+offerDetailPhrase);
		builder.append(", PackCode:"+getPackCode());
		builder.append(", Price:"+getPrice());
		builder.append(", Validity_Type:"+getValidiy_Type()+"]");
		return builder.toString();
	}
	
	
	
	
}
