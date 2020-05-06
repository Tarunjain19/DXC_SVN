package com.servion.rcom.hostinterface.view;

public class ReqRegisterFireAndShockComplaint {

	private String accountNo = null;
	private String MDN = null;
	private boolean complaintByAccNo = false;
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
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
