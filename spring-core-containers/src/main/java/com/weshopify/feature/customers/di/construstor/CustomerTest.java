package com.weshopify.feature.customers.di.construstor;

import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class CustomerTest {

	public static void main(String[] args) {
		
		  //1. does spring bean creates in jvm
		  Resource res = new ClassPathResource("customer-beans-constructor-definition.xml");
		 // BeanFactory factory = new XmlBeanFactory(res);
		 
		  ApplicationContext context = new ClassPathXmlApplicationContext("customer-beans-constructor-definition.xml");
		 
		CustomerBean custBean = (CustomerBean) context.getBean("",CustomerBean.class);
		 System.out.println(custBean.toString());
		 System.out.println(custBean.hashCode());
		 Properties props = custBean.getCustomerMessages();
		 Set<Object> propkeys = props.keySet();
		 for(Object obj : propkeys) {
			 System.out.println(props.get(obj));
		 }
		  
		//System.out.println("Home Loan Take is Rs.:\t"+custBean.getHomeLoan().toString());
		  
	}

}
