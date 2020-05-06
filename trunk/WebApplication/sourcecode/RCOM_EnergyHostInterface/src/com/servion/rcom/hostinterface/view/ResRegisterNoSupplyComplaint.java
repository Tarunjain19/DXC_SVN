package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants.ComplaintStatus;

public class ResRegisterNoSupplyComplaint {

	private String responseCode = null;
	private boolean isValidAccount = false;
	private boolean knownOutage = false;
	private boolean stationDown = false;
	private String TAT = null;
	private ComplaintStatus complaintStatus = null;
	private String complaintNumber = null;
	private boolean response_93_Or_53 = false;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public boolean isValidAccount() {
		return isValidAccount;
	}
	public void setValidAccount(boolean isValidAccount) {
		this.isValidAccount = isValidAccount;
	}
	public boolean isKnownOutage() {
		return knownOutage;
	}
	public void setKnownOutage(boolean knownOutage) {
		this.knownOutage = knownOutage;
	}
	public boolean isStationDown() {
		return stationDown;
	}
	public void setStationDown(boolean stationDown) {
		this.stationDown = stationDown;
	}
	public String getTAT() {
		return TAT;
	}
	public void setTAT(String tAT) {
		TAT = tAT;
	}
	public ComplaintStatus getComplaintStatus() {
		return complaintStatus;
	}
	public void setComplaintStatus(ComplaintStatus complaintStatus) {
		this.complaintStatus = complaintStatus;
	}
	public String getComplaintNumber() {
		return complaintNumber;
	}
	public void setComplaintNumber(String complaintNumber) {
		this.complaintNumber = complaintNumber;
	
	}
	
	public boolean get_Response_93_53(){// getting the value for response code 93 or 53.
		return response_93_Or_53;
	}


    public void Set_Response_93_53(boolean response) {//Setting the response code 93 or 53 to true to handle in the IVR.
	this.response_93_Or_53 =  response;
    }
}
