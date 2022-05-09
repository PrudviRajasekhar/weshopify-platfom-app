package com.weshopify.platform.features.customers;

import java.io.Serializable;

public class CustomerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3392255258797133035L;
	
	private String userName;
	private String email;
	private String password;
	private String mobileNumber;
	public String getUserName() {
		return userName;
	}
	@Override
	public String toString() {
		return "CustomerBean [userName=" + userName + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + "]";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
