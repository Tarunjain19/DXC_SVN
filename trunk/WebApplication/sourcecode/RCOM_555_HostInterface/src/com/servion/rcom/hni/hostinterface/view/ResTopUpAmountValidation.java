package com.servion.rcom.hni.hostinterface.view;


//TODO : Pending Response Parameters for this service
public class ResTopUpAmountValidation {

	private String responseCode = null;
	private String currentTopupAmountTalktime = null;
	private String minVal = null;
	private String minValTalktime = null;
	private String maxVal = null;
	private String maxValTalktime = null;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getCurrentTopupAmountTalktime() {
		return currentTopupAmountTalktime;
	}
	public void setCurrentTopupAmountTalktime(String currentTopupAmountTalktime) {
		this.currentTopupAmountTalktime = currentTopupAmountTalktime;
	}
	public String getMinVal() {
		return minVal;
	}
	public void setMinVal(String minVal) {
		this.minVal = minVal;
	}
	public String getMinValTalktime() {
		return minValTalktime;
	}
	public void setMinValTalktime(String minValTalktime) {
		this.minValTalktime = minValTalktime;
	}
	public String getMaxVal() {
		return maxVal;
	}
	public void setMaxVal(String maxVal) {
		this.maxVal = maxVal;
	}
	public String getMaxValTalktime() {
		return maxValTalktime;
	}
	public void setMaxValTalktime(String maxValTalktime) {
		this.maxValTalktime = maxValTalktime;
	}
}
