package com.servion.rcom.hni.hostinterface.view;

import java.util.ArrayList;

public class ResFreeUnitInfo {

	private String responseCode = null;
	private ArrayList<FreeUnitDetails> freeUnitDetailsList = new ArrayList<FreeUnitDetails>();
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public ArrayList<FreeUnitDetails> getFreeUnitDetailsList() {
		return freeUnitDetailsList;
	}
	public void setFreeUnitDetailsList(
			ArrayList<FreeUnitDetails> freeUnitDetailsList) {
		this.freeUnitDetailsList = freeUnitDetailsList;
	}
	
}
