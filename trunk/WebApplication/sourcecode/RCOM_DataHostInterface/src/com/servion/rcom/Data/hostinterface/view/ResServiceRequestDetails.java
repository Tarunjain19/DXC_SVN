package com.servion.rcom.Data.hostinterface.view;

public class ResServiceRequestDetails {
	
	private String responseCode = null;
	private boolean isServiceRequestAvailable = false;
	private String serviceRequestID = null;
	private String serviceRequestCreationDate = null;
	private String serviceRequestType = null;
	private String serviceRequestStatus = null;
	private String serviceRequestSLADate = null;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isServiceRequestAvailable() {
		return isServiceRequestAvailable;
	}
	public void setServiceRequestAvailable(boolean isServiceRequestAvailable) {
		this.isServiceRequestAvailable = isServiceRequestAvailable;
	}
	public String getServiceRequestID() {
		return serviceRequestID;
	}
	public void setServiceRequestID(String serviceRequestID) {
		this.serviceRequestID = serviceRequestID;
	}
	public String getServiceRequestCreationDate() {
		return serviceRequestCreationDate;
	}
	public void setServiceRequestCreationDate(String serviceRequestCreationDate) {
		this.serviceRequestCreationDate = serviceRequestCreationDate;
	}
	public String getServiceRequestType() {
		return serviceRequestType;
	}
	public void setServiceRequestType(String serviceRequestType) {
		this.serviceRequestType = serviceRequestType;
	}
	public String getServiceRequestStatus() {
		return serviceRequestStatus;
	}
	public void setServiceRequestStatus(String serviceRequestStatus) {
		this.serviceRequestStatus = serviceRequestStatus;
	}
	public String getServiceRequestSLADate() {
		return serviceRequestSLADate;
	}
	public void setServiceRequestSLADate(String serviceRequestSLADate) {
		this.serviceRequestSLADate = serviceRequestSLADate;
	}
	
}