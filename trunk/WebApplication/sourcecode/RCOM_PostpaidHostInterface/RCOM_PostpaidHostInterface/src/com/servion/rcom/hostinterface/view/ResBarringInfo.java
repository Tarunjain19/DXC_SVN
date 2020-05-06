package com.servion.rcom.hostinterface.view;

public class ResBarringInfo {

	private String responseCode = null;
	private boolean barred = false;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isBarred() {
		return barred;
	}
	public void setBarred(boolean barred) {
		this.barred = barred;
	}
	
}
