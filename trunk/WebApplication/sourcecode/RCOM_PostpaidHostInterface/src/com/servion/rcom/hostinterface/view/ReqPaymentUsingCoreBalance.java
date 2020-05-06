package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


//TODO : Pending Response Parameters for this service
public class ReqPaymentUsingCoreBalance {

	private String MDN = null;
	private String packName = null;
	
	public void setMDN(String MDN){
		this.MDN = MDN;
	}
	public String getMDN(){
		return MDN;
	}
	public String getPackName() {
		return packName;
	}
	public void setPackName(String packName) {
		this.packName = packName;
	}
	public String getParamValue()
	{
		return "MDN : " +this.MDN + HostConstants.PIPE + "Pack name : " +this.packName;
	}
}
