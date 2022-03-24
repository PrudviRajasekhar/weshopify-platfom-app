package com.weshopify.ecommerce;

import com.weshopify.ecommerce.tightcoupling.CreditCardAccount;

public class AccountsImpl implements Accounts{
	
	//CreditCardAccount creditCard = new CreditCardAccount();
	//int cardNUmber = 1234;
	
	@Override
	public boolean doPayment(double bill) {
		
		//Accounts account = AccountsFactory
				        //  .getMyAccount(AccountsType.CREDIT_CARD_NUMBER.name());
		Accounts account = AccountsFactory.getMyCreditCardAccount();
		
		return account.doPayment(bill);
	}

}
