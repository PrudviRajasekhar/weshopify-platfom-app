package com.weshopify.feature.customers.di.construstor;

import java.io.Serializable;

public class HomeLoanAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loanNumber;
	private long loanAmount;
	private CustomerBean customerBean;

	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	/*
	 * public HomeLoanAccount(String loanNumber, long loanAmount) { super();
	 * this.loanNumber = loanNumber; this.loanAmount = loanAmount; }
	 */

	public CustomerBean getCustomerBean() {
		return customerBean;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	
	  public void setLoanNumber(String loanNumber) { this.loanNumber = loanNumber;
	  }
	 

	public long getLoanAmount() {
		return loanAmount;
	}

	
	  public void setLoanAmount(long loanAmount) { this.loanAmount = loanAmount; }
	 

}
