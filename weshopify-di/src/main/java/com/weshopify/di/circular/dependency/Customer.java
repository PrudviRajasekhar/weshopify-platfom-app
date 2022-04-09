package com.weshopify.di.circular.dependency;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer implements Serializable {

	private Account account;
	
	public Account getAccount() {
		return account;
	}

	public Customer(Account account) {
		this.account = account;
	}
	
}
