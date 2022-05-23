package com.weshopify.feature.customers.autowire;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Controller
@RestController
@Service
@Repository
public class CustomerAutowiredBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4626408313006044324L;

	//@Autowired
	
	private HomeLoanAccount homeLoanAccount;

	/*
	 * @Autowired
	 * public void setHomeLoanAccount(HomeLoanAccount homeLoanAccount) {
	 * this.homeLoanAccount = homeLoanAccount; }
	 */

	public HomeLoanAccount getHomeLoanAccount() {
		return homeLoanAccount;
	}

	@Autowired
	public CustomerAutowiredBean(HomeLoanAccount homeLoanAccount) {
		super();
		this.homeLoanAccount = homeLoanAccount;
	}
}
