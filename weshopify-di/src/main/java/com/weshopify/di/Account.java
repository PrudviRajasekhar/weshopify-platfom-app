package com.weshopify.di;

import java.io.Serializable;

public class Account implements Serializable{

	private int accNumber;
	private String accType;
	
	public int getAccNumber() {
		return accNumber;
	}
	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
}
