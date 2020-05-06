package com.servion.rcom.hni.hostinterface.view;

import com.servion.rcom.hni.hostinterface.util.HostConstants;

public class PlanDetails {

	private String ratePlan;
	private String montlyRentalCharge;
	public String getRatePlan() {
		return ratePlan;
	}
	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}
	public String getMontlyRentalCharge() {
		return montlyRentalCharge;
	}
	public void setMontlyRentalCharge(String montlyRentalCharge) {
		this.montlyRentalCharge = montlyRentalCharge;
	}
	
	@Override
	public String toString() {
		return this.ratePlan+HostConstants.PIPE+this.getMontlyRentalCharge();
	}
	
}
