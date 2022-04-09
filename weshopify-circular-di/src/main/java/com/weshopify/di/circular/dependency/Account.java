package com.weshopify.di.circular.dependency;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = true)
public class Account implements Serializable {

	//@Autowired
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}

	public Account(Customer customer) {
		this.customer = customer;

	}

}
