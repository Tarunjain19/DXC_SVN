package com.servion.rcom.ppp.hostinterface.view;

public class ReqActivePlanDetails {

	private String MDN = null;
	
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String mDN) {
		MDN = mDN;
	}
	public String getParamValue()
	{
		return "MDN : " +this.MDN;
	}
}
