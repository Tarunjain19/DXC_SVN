package com.servion.rcom.hostinterface.view;

public class ResDuplicateBillRequest {

	private String responseCode = null;
	private String serviceRequestNumber = null;
	private boolean orderAlreadyPlaced = false;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getServiceRequestNumber() {
		return serviceRequestNumber;
	}
	public void setServiceRequestNumber(String serviceRequestNumber) {
		this.serviceRequestNumber = serviceRequestNumber;
	}
	public boolean isOrderAlreadyPlaced() {
		return orderAlreadyPlaced;
	}
	public void setOrderAlreadyPlaced(boolean orderAlreadyPlaced) {
		this.orderAlreadyPlaced = orderAlreadyPlaced;
	}
	
}
