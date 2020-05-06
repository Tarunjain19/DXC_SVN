package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;

public class PackDetails {

	private String name;
	private String code;
	private String validity;
	private String amount;
	
	private String expiryDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return name + HostConstants.PIPE + code + HostConstants.PIPE
				+ validity + HostConstants.PIPE + amount + HostConstants.PIPE
				+ expiryDate;
	}
}
