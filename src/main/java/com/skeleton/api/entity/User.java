package com.skeleton.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "`user`", schema = "dbo")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String role;
	
	protected User() {}
	
	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;		
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
	}	
	
}
