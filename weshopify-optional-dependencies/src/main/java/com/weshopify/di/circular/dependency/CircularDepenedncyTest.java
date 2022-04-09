package com.weshopify.di.circular.dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CircularDepenedncyTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer);
		System.out.println(customer.getAccount());
		System.out.println(customer.getAccount().getCustomer());
	}
}
