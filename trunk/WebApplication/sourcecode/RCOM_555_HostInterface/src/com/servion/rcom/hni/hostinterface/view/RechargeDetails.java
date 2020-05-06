package com.servion.rcom.hni.hostinterface.view;

import com.servion.rcom.hni.hostinterface.util.HostConstants;

public class RechargeDetails {

	private String amount;
	private String talktime;
	private String date; 
	private String type;
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTalktime() {
		return talktime;
	}
	public void setTalktime(String talktime) {
		this.talktime = talktime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return amount + HostConstants.PIPE
				+ talktime + HostConstants.PIPE
				+ date + HostConstants.PIPE
				+ type;
	}
	
}
