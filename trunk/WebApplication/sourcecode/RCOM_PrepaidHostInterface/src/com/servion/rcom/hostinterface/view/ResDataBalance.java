package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


//TODO : Pending Response Parameters for this service
public class ResDataBalance {
	
	private String responseCode = null;
	
	private String threeGNetBalance = null;
	private String threeGNetBalanceExpiryDate = null;
	private String threeGFairUsageBalance = null;
	private String threeGFairUsageBalanceExpiryDate = null;
	
	private String twoGNetBalance = null;
	private String twoGNetBalanceExpiryDate = null;
	private String cdmaDataBalance = null;
	private String cdmaDataBalanceExpiryDate = null;
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getThreeGNetBalance() {
		return threeGNetBalance;
	}
	public void setThreeGNetBalance(String threeGNetBalance) {
		this.threeGNetBalance = threeGNetBalance;
	}
	public String getThreeGNetBalanceExpiryDate() {
		return threeGNetBalanceExpiryDate;
	}
	public void setThreeGNetBalanceExpiryDate(String threeGNetBalanceExpiryDate) {
		this.threeGNetBalanceExpiryDate = threeGNetBalanceExpiryDate;
	}
	public String getThreeGFairUsageBalance() {
		return threeGFairUsageBalance;
	}
	public void setThreeGFairUsageBalance(String threeGFairUsageBalance) {
		this.threeGFairUsageBalance = threeGFairUsageBalance;
	}
	public String getThreeGFairUsageBalanceExpiryDate() {
		return threeGFairUsageBalanceExpiryDate;
	}
	public void setThreeGFairUsageBalanceExpiryDate(
			String threeGFairUsageBalanceExpiryDate) {
		this.threeGFairUsageBalanceExpiryDate = threeGFairUsageBalanceExpiryDate;
	}
	public String getTwoGNetBalance() {
		return twoGNetBalance;
	}
	public void setTwoGNetBalance(String twoGNetBalance) {
		this.twoGNetBalance = twoGNetBalance;
	}
	public String getTwoGNetBalanceExpiryDate() {
		return twoGNetBalanceExpiryDate;
	}
	public void setTwoGNetBalanceExpiryDate(String twoGNetBalanceExpiryDate) {
		this.twoGNetBalanceExpiryDate = twoGNetBalanceExpiryDate;
	}
	public String getcdmaDataBalance() {
		return cdmaDataBalance;
	}
	public void setcdmaDataBalance(String twoGNetFairUsageBalance) {
		this.cdmaDataBalance = twoGNetFairUsageBalance;
	}
	public String getcdmaDataBalanceExpiryDate() {
		return cdmaDataBalanceExpiryDate;
	}
	public void setcdmaDataBalanceExpiryDate(
			String cdmaDataBalanceExpiryDate) {
		this.cdmaDataBalanceExpiryDate = cdmaDataBalanceExpiryDate;
	}
	@Override
	public String toString() {
		return threeGNetBalance
				+ HostConstants.PIPE + threeGNetBalanceExpiryDate
				+ HostConstants.PIPE + threeGFairUsageBalance
				+ HostConstants.PIPE + threeGFairUsageBalanceExpiryDate
				+ HostConstants.PIPE + twoGNetBalance
				+ HostConstants.PIPE + twoGNetBalanceExpiryDate
				+ HostConstants.PIPE + cdmaDataBalance
				+ HostConstants.PIPE + cdmaDataBalanceExpiryDate;
	}
	

}
