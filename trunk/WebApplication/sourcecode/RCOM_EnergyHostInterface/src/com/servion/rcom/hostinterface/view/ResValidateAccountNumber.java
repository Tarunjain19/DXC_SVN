package com.servion.rcom.hostinterface.view;

public class ResValidateAccountNumber {

	private String responseCode = null;
	private boolean isValidAccount = false;
	private String consumerName = null;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isValidAccount() {
		return isValidAccount;
	}
	public void setValidAccount(boolean isValidAccount) {
		this.isValidAccount = isValidAccount;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	
	
}
