package com.amazonclone.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;

	private String password;
	private String address;
	private String role; // e.g., CUSTOMER, ADMIN

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<CustomerOrder> orders = new ArrayList<>();

	// Constructors
	public User() {
	}

	public User(String name, String email, String password, String address, String role) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
	}

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CustomerOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<CustomerOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", role=" + role + "]";
	}
}
