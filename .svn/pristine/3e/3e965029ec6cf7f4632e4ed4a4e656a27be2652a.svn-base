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
@NamedStoredProcedureQuery(name=Constants.PROC_spsvn_GetIntelligentLayer, procedureName = Constants.spsvn_GetIntelligentLayer, resultClasses = com.rcom.prepaid.model.IntelligentLayerInfo.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class IntelligentLayerInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.CircleCode)
	private String circleId;
	@Column(name = Constants.IsActive)
	private String status;
	
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", CircleID:"+circleId);
		builder.append(", Status:"+status+"]");
		return builder.toString();
	}


}
