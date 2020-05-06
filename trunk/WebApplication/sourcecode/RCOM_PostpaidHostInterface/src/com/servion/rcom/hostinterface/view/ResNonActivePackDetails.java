package com.servion.rcom.hostinterface.view;

import java.util.ArrayList;

public class ResNonActivePackDetails {
	
	private String responseCode = null;
	private ArrayList<PackDetails> packDetailsList = new ArrayList<PackDetails>();
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public ArrayList<PackDetails> getPackDetailsList() {
		return packDetailsList;
	}
	public void setPackDetailsList(ArrayList<PackDetails> packDetailsList) {
		this.packDetailsList = packDetailsList;
	}
	

}
