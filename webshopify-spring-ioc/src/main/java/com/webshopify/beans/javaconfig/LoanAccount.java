package com.webshopify.beans.javaconfig;

import java.io.Serializable;

import org.springframework.stereotype.Component;

//@Component
public class LoanAccount implements Serializable {

	private int loadId;
	private double loanAmount;
	private String accountType = "Loan Account";

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getLoadId() {
		return loadId;
	}

	public void setLoadId(int loadId) {
		this.loadId = loadId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

}
