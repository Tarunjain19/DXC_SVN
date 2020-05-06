package com.servion.rcom.hostinterface.view;

import java.util.ArrayList;


public class ResLastRechargeDetails{

	private String responseCode = null;
	private ArrayList<RechargeDetails> rechargeDetailsList = new ArrayList<RechargeDetails>();
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public ArrayList<RechargeDetails> getRechargeDetailsList() {
		return rechargeDetailsList;
	}
	public void setRechargeDetailsList(
			ArrayList<RechargeDetails> rechargeDetailsList) {
		this.rechargeDetailsList = rechargeDetailsList;
	}
	
}
