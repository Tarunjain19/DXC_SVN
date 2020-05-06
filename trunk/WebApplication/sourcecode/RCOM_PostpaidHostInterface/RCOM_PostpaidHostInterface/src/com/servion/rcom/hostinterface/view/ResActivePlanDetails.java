package com.servion.rcom.hostinterface.view;

import java.util.ArrayList;

public class ResActivePlanDetails {

	
	private String responseCode = null;
	private String messageText = null;
	private ArrayList<PlanDetails> planDetailsList = new ArrayList<PlanDetails>();

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public ArrayList<PlanDetails> getPlanDetailsList() {
		return planDetailsList;
	}

	public void setPlanDetailsList(ArrayList<PlanDetails> planDetailsList) {
		this.planDetailsList = planDetailsList;
	}
	
	
}
