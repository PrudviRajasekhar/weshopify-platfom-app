package com.weshopify.feature.customers.di.construstor;

import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class ApplicationContextCustomerTest {

	public static void main(String[] args) {
		
		  ApplicationContext context = new ClassPathXmlApplicationContext("customer-beans-constructor-definition.xml");

		/*
		 * CustomerBean custBean = context.getBean(CustomerBean.class);
		 * System.out.println(custBean.toString());
		 * System.out.println(custBean.hashCode()); Properties props =
		 * custBean.getCustomerMessages(); Set<Object> propkeys = props.keySet();
		 * for(Object obj : propkeys) { System.out.println(props.get(obj)); }
		 * 
		 * System.out.println("Home Loan Take is Rs.:\t"+custBean.getHomeLoan().toString
		 * ());
		 */
		  
		  HomeLoanAccount homeLoanAccont = (HomeLoanAccount) context.getBean("",HomeLoanAccount.class);
		  System.out.println(homeLoanAccont.getLoanAmount());
		  System.out.println(homeLoanAccont.getLoanNumber());
		  CustomerBean customer = homeLoanAccont.getCustomerBean();
		  System.out.println(customer.getCustomerMessages());
		  
	}

}
