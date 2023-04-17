package com.weshopify.platform.features.customers.commons;

public enum CustomerSearchOptions {

	BY_EMAIL("ByEmail","email"),
	BY_UserName("ByUserName","userName"),
	BY_Mobile("ByMobile","mobileNumber");
	
	private String key;
	public String getKey() {
		return key;
	}

	private String value;
	
	private CustomerSearchOptions(String searchKey, String searchValue) {
		this.key=searchKey;
		this.value=searchValue;
	}
	
	public static String getSearchName(String searchKey) {
		//CustomerSearchOptions customerOption = CustomerSearchOptions.valueOf(CustomerSearchOptions.class, searchKey);
		for(CustomerSearchOptions customerOption: CustomerSearchOptions.values()) {
			if(customerOption.key.equals(searchKey)) {
				return customerOption.value;
			}
		}
		return null;
		
	}

	public static void main(String[] args) {
		System.out.println(CustomerSearchOptions.BY_EMAIL.getKey());
		
	}
}
