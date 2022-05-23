package com.weshopify.feature.customers;

import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.weshopify.feature.customers.di.construstor.CustomerBeanProxy;

public class CustomerTest {

	public static void main(String[] args) {
		
		  //1. does spring bean creates in jvm
		  Resource res = new ClassPathResource("customer-beans-definition.xml");
		  BeanFactory factory = new XmlBeanFactory(res); 
		  
		 
		  
		
		  CustomerBean customerBean = (CustomerBean) factory.getBean("",CustomerBean.class);
		  System.out.println(customerBean.hashCode());
		  System.out.println(customerBean.toString());
		  System.out.println(customerBean.getLoansList());
		  System.out.println(customerBean.getAccountSet());
		  Set custData = customerBean.getCustomerData().entrySet();
		  System.out.println(custData);
		  
		  Properties props = customerBean.getAdditionalInfo();
		  props.entrySet().forEach(entry->{
			  System.out.println(entry.getKey()+"\t"+entry.getValue());
		  });
		  
		  HomeLoanAccount hla = customerBean.getHomeLoanAccount();
		  
		  CustomerBean proxy = new CustomerBeanProxy();
		  System.out.println(proxy.getEmail());
		  
		  //System.out.println(hla.getLoanAmount());
		  
		/*
		 * HomeLoanAccount homeLoanAccount = factory.getBean(HomeLoanAccount.class);
		 * System.out.println(homeLoanAccount.hashCode());
		 * System.out.println(homeLoanAccount.getLoanAmount());
		 */
		 
		 
		 
		/*
		 * System.out.println(
		 * "=======================================================================");
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("customer-beans-definition.xml");
		 */
		
		

	}

}
