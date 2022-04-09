package com.webshopify.beans.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webshopify.beans.Customer;
import com.webshopify.beans.WeShopifyAppConfiguration;

public class CustomerTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(WeShopifyAppConfiguration.class);
		
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer.getName());
		System.out.println(customer.getLoanAccount());
		
		

	}

}
