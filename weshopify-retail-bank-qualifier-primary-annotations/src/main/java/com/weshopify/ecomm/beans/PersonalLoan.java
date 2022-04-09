package com.weshopify.ecomm.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PersonalLoan implements Loan {

	@Override
	public String getLoanAccountNumber() {
		return "PL-100";
	}

}
