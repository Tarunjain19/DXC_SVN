package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;

public class ReqVoiceOffers {

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