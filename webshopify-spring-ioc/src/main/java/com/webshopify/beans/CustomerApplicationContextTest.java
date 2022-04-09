package com.webshopify.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("weshopify-beans.xml");
		System.out.println(context.getBeanDefinitionCount());
	}

}
