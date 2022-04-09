package com.weshopify.di.constructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer2 implements Serializable {

	@Autowired
	private Account account;
	
	@Autowired
	private CreditCard cc;
	
	@Autowired
	private DebitCard dc;

	public DebitCard getDc() {
		return dc;
	}

	public CreditCard getCc() {
		return cc;
	}

	public Account getAccount() {
		return account;
	}

	public Customer2() {
		System.out.println("default constructor");
	}
	
	public Customer2(Account account) {
		System.out.println("1 params constructor");
		this.account = account;
	}
	
	public Customer2(CreditCard cc, Account account) {
		System.out.println("2 params constructor");
		this.cc = cc;
		this.account = account;
	}
	
	public Customer2(CreditCard cc, DebitCard dc,Account account) {
		System.out.println("3 params constructor");
		this.cc = cc;
		this.dc=dc;
		this.account = account;
	}
	
}
