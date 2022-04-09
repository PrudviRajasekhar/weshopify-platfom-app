package com.weshopify.di.circular.dependency;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = true)
public class Customer implements Serializable {

	private Account account;
	
	private CreditCard cc;
	
	public CreditCard getCc() {
		return cc;
	}

	public Account getAccount() {
		return account;
	}
	
	public Customer(Account account, CreditCard cc) {
		this.account= account;
		this.cc =cc;
	}
}
