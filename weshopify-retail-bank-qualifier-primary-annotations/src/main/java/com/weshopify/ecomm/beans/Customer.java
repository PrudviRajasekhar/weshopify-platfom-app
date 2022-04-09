package com.weshopify.ecomm.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Customer {

	@Autowired
	@Qualifier(value = "homeLoan")
	private Loan loanService;
	
	public Map<String, String> getCustomerDetails() {
		String loanAccNumber = loanService.getLoanAccountNumber();
		Map<String, String> customerDetails = new HashMap<>();
		customerDetails.put("name", "john");
		customerDetails.put("LoanAccNumber", loanAccNumber);
		return customerDetails;
	}
}
