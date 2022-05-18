package com.weshopify.platform.features.customers.commons;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.weshopify.platform.features.customers.service.CustomerServicesUtil;

public class EmailDomainValidatorConstraint implements ConstraintValidator<EmailDomainValid, String> {

	private static final Logger logger = LoggerFactory.getLogger(EmailDomainValidatorConstraint.class);
	
	@Autowired
	private CustomerServicesUtil customerServicesUtil;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		logger.info("inside the email domainn Validate method");
		return customerServicesUtil.isValidEmailDomina(value);
	}

}
