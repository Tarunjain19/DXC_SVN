package com.rcom.prepaid.model;

import java.io.Serializable;

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
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetIVRHotFlash, procedureName = Constants.spsvn_GetIVRHotFlash, resultClasses = com.rcom.prepaid.model.HotFlashInfo.class, 
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class HotFlashInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = Constants.StartDate)
	private String startDate;
	@Column(name = Constants.EndDate)
	private String endDate;
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CallFlowNodeId)
	private String nodeId;
	@Id
	@Column(name = Constants.LanguageCode)
	private String language;
	@Id
	@Column(name = Constants.CircleCode)
	private String circle;
	@Column(name = Constants.IsActive)
	private String enabledFlag;
	@Column(name = Constants.PhraseName)
	private String phraseId;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getEnabledFlag() {
		return enabledFlag;
	}
	public void setEnabledFlag(String enabledFlag) {
		this.enabledFlag = enabledFlag;
	}
	public String getPhraseId() {
		return phraseId;
	}
	public void setPhraseId(String phraseId) {
		this.phraseId = phraseId;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[appName:"+appName);
		builder.append(", NodeId:"+nodeId);
		builder.append(", Language:"+language);
		builder.append(", Circle:"+circle);
		builder.append(", EnabledFlag:"+enabledFlag);
		builder.append(", PhraseId:"+phraseId+"]");
		return builder.toString();
	}
	

}
