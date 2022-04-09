package com.weshopify.di.circular.dependency;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Account implements Serializable{

	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}

	public Account(Customer customer) {
		this.customer = customer;
				
	}
	
}
