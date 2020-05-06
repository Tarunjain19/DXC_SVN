package com.servion.rcom.hostinterface.view;


//TODO : Pending Response Parameters for this service
public class ReqDataBalance{

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
