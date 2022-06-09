package com.weshopify.platform.features.customers.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class UserRole implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6577213593067103879L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String role;
	private String description;
	
	@OneToMany
	//@JoinTable(name = "user_role_permissions",joinColumns = {})
	private List<UserPermissions> actions;
	

}
