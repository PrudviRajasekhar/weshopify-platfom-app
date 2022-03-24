package com.weshopify.ecommerce.tightcoupling;

import java.io.Serializable;

import com.weshopify.ecommerce.Accounts;

public class LoanAccount implements Serializable, Accounts{

	private int loadId;
	private double loanAmount;
	private String accountType="Loan Account";

	public boolean doPayment(double emi) {
		boolean isPaymentDone = false;
		if(emi != 0d) {
			
			isPaymentDone=true;
		}
		
		return isPaymentDone;
	}
	
	public String getAccountType() {
		return accountType;
	}

	
	  public void setAccountType(String accountType) { this.accountType =
	  accountType; }
	 

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
