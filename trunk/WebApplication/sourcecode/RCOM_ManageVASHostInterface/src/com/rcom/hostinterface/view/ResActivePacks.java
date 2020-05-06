package com.rcom.hostinterface.view;

public class ResActivePacks {

	String PackCodes;
	String PackNames;
	String ResponseCode;
	String ResponseMessage;
	public String getResponseMessage() {
		return ResponseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		ResponseMessage = responseMessage;
	}
	public String getPackCodes() {
		return PackCodes;
	}
	public void setPackCodes(String packCodes) {
		PackCodes = packCodes;
	}
	public String getPackNames() {
		return PackNames;
	}
	public void setPackNames(String packNames) {
		PackNames = packNames;
	}
	public String getResponseCode() {
		return ResponseCode;
	}
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	@Override
	public String toString() {
		return "ResActivePacks [PackCodes=" + PackCodes + ", PackNames="
				+ PackNames + ", ResponseCode=" + ResponseCode + "]";
	}
	
	
}
