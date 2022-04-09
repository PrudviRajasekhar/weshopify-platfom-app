package com.weshopify.di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Customer customer() {
		Customer customer = new Customer();
		customer.setCustomerId(100);
		customer.setName("John");
		List<Integer> accountNum = new ArrayList<Integer>();
		accountNum.add(10001);
		customer.setAccountNumbers(accountNum);
		
		return customer;
	}
	
	@Bean
	public Account account1() {
		Account account = new Account();
		account.setAccNumber(1001);
		account.setAccType("savings");
		return account;
	}
	
	@Bean
	public Account account2() {
		Account account2 = new Account();
		account2.setAccNumber(1002);
		account2.setAccType("savings");
		return account2;
	}
	
	@Bean
	public Account account3() {
		Account account3 = new Account();
		account3.setAccNumber(1003);
		account3.setAccType("savings");
		return account3;
	}
}
