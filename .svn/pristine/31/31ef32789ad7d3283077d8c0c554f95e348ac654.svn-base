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
@NamedStoredProcedureQuery(name=Constants.PROC_SP_IVR_SERVICE_UPDATION, procedureName = Constants.SP_IVR_SERVICE_UPDATION, resultClasses = com.rcom.postpaid.model.ServiceUpdateInfo.class,
parameters = {
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.ApplicationName, type = String.class),
	@StoredProcedureParameter(mode = ParameterMode.IN, name = Constants.IPaddress, type = String.class)
})
public class ServiceUpdateInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = Constants.ApplicationName)
	private String appName;
	@Id
	@Column(name = Constants.ServiceName)
	private String serviceName;
	@Column(name = Constants.UPDATE_STATUS)
	private String status;
	@Transient
	private String IPaddress;
	@Transient
	private String Flag;
	
	
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFlag() {
		return Flag;
	}
	public void setFlag(String flag) {
		Flag = flag;
	}
	public String getIPaddress() {
		return IPaddress;
	}
	public void setIPaddress(String IPaddress) {
		this.IPaddress = IPaddress;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[AppName:"+appName);
		builder.append(", ServiceName:"+serviceName);
		builder.append(", IPaddress:"+IPaddress);
		builder.append(", Status:"+status+"]");
		return builder.toString();
	}
	

}
