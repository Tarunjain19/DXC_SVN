package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;

public class ResBillInfo {

	private String responseCode = null;
	private String billIssueDate = null;
	private String invoiceAmount = null;
	private String accountBalance = null;
	private String paymentDueDate = null;
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getBillIssueDate() {
		return billIssueDate;
	}
	public void setBillIssueDate(String billIssueDate) {
		this.billIssueDate = billIssueDate;
	}
	public String getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getPaymentDueDate() {
		return paymentDueDate;
	}
	public void setPaymentDueDate(String paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	@Override
	public String toString() {
		return    billIssueDate
				+ HostConstants.PIPE + invoiceAmount
				+ HostConstants.PIPE + accountBalance
				+ HostConstants.PIPE + paymentDueDate;
	}
	
	
}
