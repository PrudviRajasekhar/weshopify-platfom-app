package com.weshopify.di;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public class Customer implements Serializable {

	private int customerId;
	private String name;
	
	
	private List<Integer> accountNumbers;
	
	private Map<Integer, String> accountsMap;
	
	/*
	 * private Account account;
	 * 
	 * public Account getAccount() { return account; } public void
	 * setAccount(Account account) { this.account = account; }
	 */
	
	@Autowired
	private Set<Account> accountList;
	
	@Autowired
	private Map<String, Account> accountMap;
	
	public Map<String, Account> getAccountMap() {
		return accountMap;
	}
	
	public void setAccountMap(Map<String, Account> accountMap) {
		this.accountMap = accountMap;
	}
	
	public Set<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(Set<Account> accountList) {
		this.accountList = accountList;
	}
	public List<Integer> getAccountNumbers() {
		return accountNumbers;
	}
	public void setAccountNumbers(List<Integer> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
