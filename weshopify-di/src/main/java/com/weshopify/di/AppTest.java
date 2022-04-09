package com.weshopify.di;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Customer customer = context.getBean(Customer.class);
		System.out.println(customer.getCustomerId());
		System.out.println(customer.getName());
		
		/*
		 * Set<Account> accList = customer.getAccountList(); for(Account acc : accList)
		 * { System.out.println(acc.getAccNumber());
		 * 
		 * }
		 */
		
		Map accountsMap = customer.getAccountMap();
		for(Object key : accountsMap.keySet()) {
			System.out.println("key is:\t"+key);
			System.out.println("value is:\t"+accountsMap.get(key));
			System.out.println("===================================");
		}
	}

}
