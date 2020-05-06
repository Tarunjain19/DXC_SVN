package com.servion.rcom.hni.hostinterface.view;

public class ReqLastThreeTransactions {

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
