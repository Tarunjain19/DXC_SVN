package com.servion.rcom.hostinterface.view;

import com.servion.rcom.hostinterface.util.HostConstants;


//TODO : Pending Response Parameters for this service
public class ResDataBalance {
	
	private String responseCode = null;
	
	private String coreBalance = null;
	private String coreBalanceExpiryDate = null;
	private String rconnectBalance = null;
	private String rconnectBalanceExpiryDate = null;
	private String promoBalance = null;
	private String promoBalanceExpiryDate = null;
	private String unlimitedBalance = null;
	private String unlimitedBalanceExpiryDate = null;
	
	
	public String getUnlimitedBalanceExpiryDate() {
		return unlimitedBalanceExpiryDate;
	}
	public void setUnlimitedBalanceExpiryDate(String unlimitedBalanceExpiryDate) {
		this.unlimitedBalanceExpiryDate = unlimitedBalanceExpiryDate;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public String getPromoBalance() {
		return promoBalance;
	}
	public void setPromoBalance(String promoBalance) {
		this.promoBalance = promoBalance;
	}
	public String getPromoBalanceExpiryDate() {
		return promoBalanceExpiryDate;
	}
	public void setPromoBalanceExpiryDate(String promoBalanceExpiryDate) {
		this.promoBalanceExpiryDate = promoBalanceExpiryDate;
	}
	public String getUnlimitedBalance() {
		return unlimitedBalance;
	}
	public void setUnlimitedBalance(String unlimitedBalance) {
		this.unlimitedBalance = unlimitedBalance;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	
	
	
	public String getCoreBalance() {
		return coreBalance;
	}
	public void setCoreBalance(String coreBalance) {
		this.coreBalance = coreBalance;
	}
	public String getCoreBalanceExpiryDate() {
		return coreBalanceExpiryDate;
	}
	public void setCoreBalanceExpiryDate(String coreBalanceExpiryDate) {
		this.coreBalanceExpiryDate = coreBalanceExpiryDate;
	}
	public String getRconnectBalance() {
		return rconnectBalance;
	}
	public void setRconnectBalance(String rconnectBalance) {
		this.rconnectBalance = rconnectBalance;
	}
	public String getRconnectBalanceExpiryDate() {
		return rconnectBalanceExpiryDate;
	}
	public void setRconnectBalanceExpiryDate(String rconnectBalanceExpiryDate) {
		this.rconnectBalanceExpiryDate = rconnectBalanceExpiryDate;
	}
	@Override
	public String toString() {
		return coreBalance
				+ HostConstants.PIPE + coreBalanceExpiryDate
				+ HostConstants.PIPE + rconnectBalance
				+ HostConstants.PIPE + rconnectBalanceExpiryDate
				+ HostConstants.PIPE +promoBalance
				+ HostConstants.PIPE + promoBalanceExpiryDate
				+ HostConstants.PIPE + unlimitedBalance
				+ HostConstants.PIPE + unlimitedBalanceExpiryDate;

	}
	

}
