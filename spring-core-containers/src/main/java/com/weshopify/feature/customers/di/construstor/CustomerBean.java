package com.weshopify.feature.customers.di.construstor;

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
    List<String> accounts;
    Set<String> loanTypes;
    Map<String, String> loanCodes;
    
    private HomeLoanAccount homeLoan;
    
    public HomeLoanAccount getHomeLoan() {
		return homeLoan;
	}

	Properties customerMessages;
    
	public Properties getCustomerMessages() {
		return customerMessages;
	}

	public CustomerBean(int customerId, String firstName, String lastName, String email, String mobileNumber,
			List<String> accounts,Set<String> loanTypes,Map<String, String> loanCodes,
			Properties customerMessages,HomeLoanAccount homeLoan) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.accounts =accounts;
		this.loanTypes = loanTypes;
		this.loanCodes=loanCodes;
		this.customerMessages=customerMessages;
		this.homeLoan = homeLoan;
	}

	/*
	 * @Override public String toString() { return "CustomerBean [customerId=" +
	 * customerId + ", firstName=" + firstName + ", lastName=" + lastName +
	 * ", email=" + email + ", mobileNumber=" + mobileNumber + ", accounts=" +
	 * accounts + ", loanTypes=" + loanTypes + ", loanCodes=" + loanCodes +
	 * ", customerMessages=" + customerMessages + "]"; }
	 */
	
	
	
	
	
   }
