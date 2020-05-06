package com.servion.rdtv.hostservice;



//TODO : Pending Request Parameters for this service

public class ReqPushSMS{

	private String MDN = null;
	private String messageText = null;


	public String getMDN() {
		return MDN;
	}

	public void setMDN(String MDN) {
		this.MDN = MDN;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	@Override
	public String toString() {
		return "ReqPushSMS :: MDN=" + MDN + ", messageText=" + messageText ;
	}
	
	
}
