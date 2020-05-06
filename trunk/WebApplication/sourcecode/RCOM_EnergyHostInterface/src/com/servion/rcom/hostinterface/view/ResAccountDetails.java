package com.servion.rcom.hostinterface.view;

public class ResAccountDetails {

	private String responseCode = null;
	private boolean isValidMDN = false;
	private boolean isSingleAccountFound = false;
	private boolean isNoAccFound = false;
	private boolean isMulAccFound = false;
	private String accountNumber = null;
	private String consumerName = null;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isValidMDN() {
		return isValidMDN;
	}
	public void setValidMDN(boolean isValidMDN) {
		this.isValidMDN = isValidMDN;
	}
	public boolean isSingleAccountFound() {
		return isSingleAccountFound;
	}
	public void setSingleAccountFound(boolean isSingleAccountFound) {
		this.isSingleAccountFound = isSingleAccountFound;
	}
	public boolean isNoAccFound() {
		return isNoAccFound;
	}
	public void setNoAccFound(boolean isNoAccFound) {
		this.isNoAccFound = isNoAccFound;
	}
	public boolean isMulAccFound() {
		return isMulAccFound;
	}
	public void setMulAccFound(boolean isMulAccFound) {
		this.isMulAccFound = isMulAccFound;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	
}
