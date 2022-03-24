package com.weshopify.ecommerce.tightcoupling;

import java.io.Serializable;

import com.weshopify.ecommerce.Accounts;
import com.weshopify.ecommerce.AccountsImpl;

public class Customer implements Serializable {
	
	private int id;
	private String name;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public boolean payCreditCardBill(double cardBill) {
		Accounts acounts = new AccountsImpl();
		return acounts.doPayment(cardBill);
	}
	
	public boolean payLoanEMI(double emiBill) {
		LoanAccount loanAcount = new LoanAccount();
		return loanAcount.doPayment(emiBill);
	}
	
	
}