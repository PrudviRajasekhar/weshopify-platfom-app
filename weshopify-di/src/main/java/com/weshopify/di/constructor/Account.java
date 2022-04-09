package com.weshopify.di.constructor;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class Account implements Serializable{

	private int accNumber;
	private String accType="savings";
	
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
