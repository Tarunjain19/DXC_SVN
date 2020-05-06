package com.servion.rcom.hostinterface.view;

public class ReqRegisterNoSupplyComplaint {

	private String accountNo = null;
	private boolean individual = false;
	private String MDN = null;
	private boolean complaintByAccNo = false;
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public boolean isIndividual() {
		return individual;
	}
	public void setIndividual(boolean individual) {
		this.individual = individual;
	}
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String mDN) {
		MDN = mDN;
	}
	public boolean isComplaintByAccNo() {
		return complaintByAccNo;
	}
	public void setComplaintByAccNo(boolean complaintByAccNo) {
		this.complaintByAccNo = complaintByAccNo;
	}
	
}
