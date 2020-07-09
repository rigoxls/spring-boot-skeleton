package com.skeleton.api.repository;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

import com.skeleton.api.dto.UserDTO;

@Entity
@Table(name = "`user`")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String lastname;
	private String email;
	private String address;
	private String phone;
	private int role;
	private int status;
	
	protected UserEntity() {}
		
	public UserEntity(UserDTO newUser) {
		super();
		this.name = newUser.name;
		this.lastname = newUser.lastname;
		this.email = newUser.email;
		this.address = newUser.address;
		this.phone = newUser.phone;
		this.role = newUser.role;
		this.status = newUser.status;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setAll(UserDTO userToUpdate) {
		this.name = userToUpdate.name;
		this.lastname = userToUpdate.lastname;
		this.email = userToUpdate.email;
		this.address = userToUpdate.address;
		this.phone = userToUpdate.phone;
		this.role = userToUpdate.role;
		this.status = userToUpdate.status;			
	}
	
	public HashMap<String, Object> getPublicData() {
		HashMap<String, Object> user = new HashMap<>();
		user.put("name", getName());
		user.put("lastname", getLastname());
		user.put("email", getEmail());
		user.put("address", getAddress());
		user.put("phone", getPhone());
		user.put("role", getRole());   
	    return user;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", role=" + role + ", status=" + status + "]";
	}
	
}
