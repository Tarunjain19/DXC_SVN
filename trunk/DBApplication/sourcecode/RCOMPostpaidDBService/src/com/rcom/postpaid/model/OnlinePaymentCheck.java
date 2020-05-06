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
@NamedStoredProcedureQuery(name = Constants.PROC_IVR_Online_Payment, procedureName = Constants.SP_IVR_Online_Payment,
parameters = {
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.Circle, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.OnlinePaymentFlag, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorCode, type = String.class),
		@StoredProcedureParameter(mode = ParameterMode.OUT, name = Constants.o_ErrorDescription, type = String.class)
})
public class OnlinePaymentCheck implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.Circle)
	private String circleId;
	//@Column(name = Constants.OnlinePaymentFlag)
	@Transient
	private String status;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCircleId() {
		return circleId;
	}
	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", Circle:"+circleId);
		builder.append(", Status:"+status+"]");
		return builder.toString();
	}
	

}
