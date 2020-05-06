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
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetSpecialTraiffVoucher, procedureName = Constants.spsvn_GetSpecialTraiffVoucher, resultClasses = com.rcom.postpaid.model.SpecialTariffInfo.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class SpecialTariffInfo implements Serializable{
	
	private static final long serialVersionUID = -4983529728253944719L;
	
	@Id
	@Column(name =Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Id
	@Column(name = Constants.LanguageCode)
	private String language;
	@Column(name = Constants.STVCode)
	private String stvCode;
	@Id
	@Column(name = Constants.PackNamePhrase)
	private String packNamePhrase;
	@Id
	@Column(name = Constants.DenominationPhrase)
	private String denominationPhrase; 
	@Column(name = Constants.MRPPhrase)
	private String mrpPhrase; 
	@Column(name = Constants.AnnouncementPhrase)
	private String announcementPhrase;
	@Column(name = Constants.IsActive)
	private String status;
	@Column(name = Constants.PackMenuOption)
	private String PackMenuOption;
	@Column(name = Constants.DenominationMenuOption)
	private String denomiationMenuOption;
	
	
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
	public String getStvCode() {
		return stvCode;
	}
	public void setStvCode(String stvCode) {
		this.stvCode = stvCode;
	}
	public String getPackNamePhrase() {
		return packNamePhrase;
	}
	public void setPackNamePhrase(String packNamePhrase) {
		this.packNamePhrase = packNamePhrase;
	}
	public String getDenominationPhrase() {
		return denominationPhrase;
	}
	public void setDenominationPhrase(String denominationPhrase) {
		this.denominationPhrase = denominationPhrase;
	}
	public String getMrpPhrase() {
		return mrpPhrase;
	}
	public void setMrpPhrase(String mrpPhrase) {
		this.mrpPhrase = mrpPhrase;
	}
	public String getAnnouncementPhrase() {
		return announcementPhrase;
	}
	public void setAnnouncementPhrase(String announcementPhrase) {
		this.announcementPhrase = announcementPhrase;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public String getPackMenuOption() {
		return PackMenuOption;
	}
	public void setPackMenuOption(String packMenuOption) {
		PackMenuOption = packMenuOption;
	}
	public String getDenomiationMenuOption() {
		return denomiationMenuOption;
	}
	public void setDenomiationMenuOption(String denomiationMenuOption) {
		this.denomiationMenuOption = denomiationMenuOption;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[appName:"+appName);
		builder.append(", CircleId:"+circleId);
		builder.append(", Language:"+language);
		builder.append(", STVCode:"+stvCode);
		builder.append(", DenominationPhrase:"+denominationPhrase);
		builder.append(", AnnouncementPhrase:"+announcementPhrase);
		builder.append(", PackNamePhrase:"+packNamePhrase);
		builder.append(", MRPPhrase:"+mrpPhrase);
		builder.append(", PackMenuOption:"+getPackMenuOption());
		builder.append(", DenominationPackName:"+getDenomiationMenuOption());
		builder.append(", ActiveStatus:"+status+"]");

		return builder.toString();
	}

}
