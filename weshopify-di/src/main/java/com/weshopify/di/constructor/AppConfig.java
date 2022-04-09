package com.weshopify.di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.weshopify.di")
public class AppConfig {

	
	  @Autowired private Account account;
	  
	  @Autowired
	  private CreditCard cc;
	 
	
	/*
	 * @Bean public Customer customer() { Customer customer = new Customer(100,
	 * "Jack",account); return customer; }
	 */
	
	/*
	 * @Bean public Customer2 customer() { Customer2 customer = new
	 * Customer2(account); return customer; }
	 */
	
	/*
	 * @Bean public Account account() { Account account = new Account();
	 * account.setAccNumber(1000); account.setAccType("Savings"); return account; }
	 */
	@Bean
	public Customer2 customer1() {
		Customer2 customer = new Customer2(account);
		return customer;
	}
	
	@Bean
	public Customer2 customer2() {
		Customer2 customer = new Customer2(cc,account);
		return customer;
	}
	
	@Bean
	public Customer2 customer3() {
		Customer2 customer = new Customer2();
		return customer;
	}
	
}
