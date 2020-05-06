package com.servion.rcom.hni.hostinterface.view;

import java.util.ArrayList;

public class ResLastThreeTransactions {

	private String responseCode = null;
	private ArrayList<TransactionDetails> transactionDetailsList = new ArrayList<TransactionDetails>();

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public ArrayList<TransactionDetails> getTransactionDetailsList() {
		return transactionDetailsList;
	}

	public void setTransactionDetailsList(
			ArrayList<TransactionDetails> transactionDetailsList) {
		this.transactionDetailsList = transactionDetailsList;
	}
	
}
