package com.servion.rcom.ppp.hostinterface.view;

//TODO : Pending Response Parameters for this service
public class ReqGPRSSettingsDownload {

	private String MDN = null;
	
	
	public String getMDN() {
		return MDN;
	}
	public void setMDN(String MDN) {
		this.MDN = MDN;
	}
	public String getParamValue()
	{
		return "MDN : " +this.MDN;
	}
	
}
