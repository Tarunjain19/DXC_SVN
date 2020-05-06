package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


//TODO : Pending Request Parameters for this service

public class ReqPaymentUsingCreditcard{

	private String MDN = null;
	private String MDNToBeRecharged = null;
	private String rcType = null;
	private String OTP = null;
	private String amount = null;
	private CreditCardDetails creditCardDetails = null;
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String mDN) {
		MDN = mDN;
	}
	public String getMDNToBeRecharged() {
		return MDNToBeRecharged;
	}
	public void setMDNToBeRecharged(String mDNToBeRecharged) {
		MDNToBeRecharged = mDNToBeRecharged;
	}
	public String getRcType() {
		return rcType;
	}
	public void setRcType(String rcType) {
		this.rcType = rcType;
	}
	public String getOTP() {
		return OTP;
	}
	public void setOTP(String oTP) {
		OTP = oTP;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public CreditCardDetails getCreditCardDetails() {
		return creditCardDetails;
	}
	public void setCreditCardDetails(CreditCardDetails creditCardDetails) {
		this.creditCardDetails = creditCardDetails;
	}
	public String getParamValue()
	{
		return "MDN : " +this.MDN + HostConstants.PIPE + "MDN To be recharged" +this.MDNToBeRecharged + HostConstants.PIPE + "RC Type : " +this.rcType
				+ HostConstants.PIPE + "Amount : " +this.amount +HostConstants.PIPE + "Card details : ***";  
	}
	
}
