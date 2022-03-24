package com.weshopify.ecommerce;

import com.weshopify.ecommerce.tightcoupling.Customer;

public class TestCustomnerAccounts {

	public static void main(String[] args) {
		Customer customer = new Customer();
		boolean isBillPaid = customer.payCreditCardBill(500);
		System.out.println("does payment done?:\t"+isBillPaid);
	}

}
