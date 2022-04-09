package com.weshopify.ecomm.beans;

import java.io.Serializable;

public class ProductBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7162140824535373459L;
	private int id;
	private String name;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
