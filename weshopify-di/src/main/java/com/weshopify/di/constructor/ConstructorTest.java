package com.weshopify.di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		 * Customer customer = context.getBean(Customer.class);
		 * System.out.println(customer.getCustomerId());
		 * System.out.println(customer.getName());
		 * System.out.println(customer.getAccount().getAccType());
		 */
		
		for(String name: context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
		
		//Customer2 customer = context.getBean(Customer2.class);
		//System.out.println(customer.getAccount().getAccType());
		//System.out.println(customer.getCc().getCardHolderName());

	}

}
