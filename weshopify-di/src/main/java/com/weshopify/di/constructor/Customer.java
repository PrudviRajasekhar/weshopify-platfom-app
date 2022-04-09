package com.weshopify.di.constructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer implements Serializable {

	private int customerId;
	private String name;
	
	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public Customer(int customerId, String name,Account account) {
		this.customerId = customerId;
		this.name = name;
		this.account = account;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}
	
}
