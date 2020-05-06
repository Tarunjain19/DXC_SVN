package com.servion.rcom.hostinterface.view;

public class ResLatestBillGenDetails {

	private String responseCode = null;
	private boolean isValidAccount = false;
	private String latestBillGenerationDate = null;
	private String latestBillAmount = null;
	private String dueDate = null;
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
	public String getLatestBillGenerationDate() {
		return latestBillGenerationDate;
	}
	public void setLatestBillGenerationDate(String latestBillGenerationDate) {
		this.latestBillGenerationDate = latestBillGenerationDate;
	}
	public String getLatestBillAmount() {
		return latestBillAmount;
	}
	public void setLatestBillAmount(String latestBillAmount) {
		this.latestBillAmount = latestBillAmount;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
