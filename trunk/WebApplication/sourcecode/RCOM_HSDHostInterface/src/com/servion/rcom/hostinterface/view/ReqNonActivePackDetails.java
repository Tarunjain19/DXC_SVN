package com.servion.rcom.hostinterface.view;

public class ReqNonActivePackDetails {
	
	private String MDN = null;;

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
