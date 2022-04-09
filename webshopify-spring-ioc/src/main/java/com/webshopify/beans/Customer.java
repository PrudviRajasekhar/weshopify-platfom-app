package com.webshopify.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webshopify.beans.javaconfig.LoanAccount;

public class Customer implements Serializable {

	private int id;
	private String name;

	private LoanAccount loanAccount;

	public LoanAccount getLoanAccount() {
		return loanAccount;
	}

	public void setLoanAccount(LoanAccount loanAccount) {
		this.loanAccount = loanAccount;
	}


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
		System.out.println("name is:\t" + this.name);
		return this.name;
	}

}