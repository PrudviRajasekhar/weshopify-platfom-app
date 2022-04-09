package com.webshopify.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.webshopify.beans.javaconfig.LoanAccount;

@Configuration
/*
 * @ComponentScan(basePackages = {"com.webshopify.beans"}, excludeFilters
 * = @ComponentScan.Filter(type = FilterType.REGEX, pattern =
 * "com.webshopify.beans.javaconfig.*"))
 */

@ComponentScan(basePackages = { "com.webshopify.beans" })
public class WeShopifyAppConfiguration {

	@Autowired
	private LoanAccount loanAccount;

	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		customer.setId(100);
		customer.setName("john");
		return customer;
	}

	@Bean
	public LoanAccount loanAccount() {
		LoanAccount loan = new LoanAccount();
		System.out.println("loan account is instainted");
		return loan;
	}
}
