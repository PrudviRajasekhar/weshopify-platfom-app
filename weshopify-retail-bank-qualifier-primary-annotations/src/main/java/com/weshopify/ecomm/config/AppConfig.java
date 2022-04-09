package com.weshopify.ecomm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.weshopify.ecomm.beans.HomeLoan;
import com.weshopify.ecomm.beans.Loan;
import com.weshopify.ecomm.beans.PersonalLoan;

@Configuration
@ComponentScan(basePackages = "com.weshopify.ecomm")
public class AppConfig {
	
	/*
	 * @Bean
	 * 
	 * @Primary public Loan personalLoan() { Loan loan = new PersonalLoan(); return
	 * loan; }
	 * 
	 * @Bean
	 * 
	 * public Loan homeLoan() { Loan loan = new HomeLoan(); return loan; }
	 */
}
