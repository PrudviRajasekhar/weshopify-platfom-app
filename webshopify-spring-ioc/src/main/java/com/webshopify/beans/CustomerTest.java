package com.webshopify.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class CustomerTest {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("weshopify-beans.xml");
		BeanFactory beansFactory = new XmlBeanFactory(resource);
		Customer customer = beansFactory.getBean(Customer.class);
		
		
		
		  //System.out.println(customer.getName()); System.out.println(customer.getId());
		  //System.out.println("hash code:\t"+customer.hashCode());
		  
		  
		/*
		 * Customer customer1 = beansFactory.getBean(Customer.class);
		 * System.out.println(customer.getName()); System.out.println(customer.getId());
		 * System.out.println("hash code:\t"+customer1.hashCode());
		 */
		 
		 
		 
		
		
		
		

	}

}
