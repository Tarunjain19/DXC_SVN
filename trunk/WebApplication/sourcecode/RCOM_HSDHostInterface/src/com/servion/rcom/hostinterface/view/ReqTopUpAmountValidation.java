package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


//TODO : Pending Response Parameters for this service
public class ReqTopUpAmountValidation {

	private String MDN = null;
	private String MDNToBeRecharged = null;
	private String amount = null;
	
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String MDN) {
		this.MDN = MDN;
	}
	public String getMDNToBeRecharged() {
		return MDNToBeRecharged;
	}
	public void setMDNToBeRecharged(String mDNToBeRecharged) {
		MDNToBeRecharged = mDNToBeRecharged;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getParamValue()
	{
		return "MDN : " +this.MDN + HostConstants.PIPE + "MDN To be recharged" +this.MDNToBeRecharged + HostConstants.PIPE + "Amount : ***";  
	}
}
