package com.weshopify.ecomm.beans;

import org.springframework.stereotype.Component;

@Component
public class HomeLoan implements Loan {

	@Override
	public String getLoanAccountNumber() {
		return "HL-1000";
	}

}
