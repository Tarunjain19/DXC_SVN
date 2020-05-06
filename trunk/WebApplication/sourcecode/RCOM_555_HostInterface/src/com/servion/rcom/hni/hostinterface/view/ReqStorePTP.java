package com.servion.rcom.hni.hostinterface.view;

public class ReqStorePTP {

	private String MDN = null;
	private boolean ptpByCash = false;
	private boolean ptpByCheque = false;
	private boolean ptpByCreditCard = false;
	private boolean ptpByDebitCard = false;
	private String ptpAmount = null;
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String mDN) {
		MDN = mDN;
	}
	public boolean isPtpByCash() {
		return ptpByCash;
	}
	public void setPtpByCash(boolean ptpByCash) {
		this.ptpByCash = ptpByCash;
	}
	public boolean isPtpByCheque() {
		return ptpByCheque;
	}
	public void setPtpByCheque(boolean ptpByCheque) {
		this.ptpByCheque = ptpByCheque;
	}
	public boolean isPtpByCreditCard() {
		return ptpByCreditCard;
	}
	public void setPtpByCreditCard(boolean ptpByCreditCard) {
		this.ptpByCreditCard = ptpByCreditCard;
	}
	public boolean isPtpByDebitCard() {
		return ptpByDebitCard;
	}
	public void setPtpByDebitCard(boolean ptpByDebitCard) {
		this.ptpByDebitCard = ptpByDebitCard;
	}
	public String getPtpAmount() {
		return ptpAmount;
	}
	public void setPtpAmount(String ptpAmount) {
		this.ptpAmount = ptpAmount;
	}
	
}
