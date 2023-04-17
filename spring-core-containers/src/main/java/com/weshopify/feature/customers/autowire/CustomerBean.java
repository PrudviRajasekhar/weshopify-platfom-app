package com.weshopify.feature.customers.autowire;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CustomerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626408313006044324L;
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    
    private List<String> loansList;
    private Set<String> accountSet;
    
    private Map<Integer, String> customerData;
    
    private HomeLoanAccount homeLoanAccount;
    
	/*
	 * public CustomerBean(HomeLoanAccount homeLoanAccount) { //super();
	 * this.homeLoanAccount = homeLoanAccount; }
	 */
	public HomeLoanAccount getHomeLoanAccount() {
		return homeLoanAccount;
	}

	
	  public void setHomeLoanAccount(HomeLoanAccount homeLoanAccount) {
	  this.homeLoanAccount = homeLoanAccount; }
	 
	public Properties getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(Properties additionalInfo) {
		this.additionalInfo = additionalInfo;
	}
	private Properties additionalInfo;
    
	public Map<Integer, String> getCustomerData() {
		return customerData;
	}
	public void setCustomerData(Map<Integer, String> customerData) {
		this.customerData = customerData;
	}
	public Set<String> getAccountSet() {
		return accountSet;
	}
	public void setAccountSet(Set<String> accountSet) {
		this.accountSet = accountSet;
	}
	public List<String> getLoansList() {
		return loansList;
	}
	public void setLoansList(List<String> loansList) {
		this.loansList = loansList;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobileNumber=" + mobileNumber + "]";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
