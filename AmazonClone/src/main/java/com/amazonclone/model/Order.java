package com.amazonclone.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	private LocalDateTime date;

	private String status;

	private double totalAmount;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> items;

	public Order() {
	}

	public Order(User user, LocalDateTime date, String status, double totalAmount, List<OrderItem> items) {
		this.user = user;
		this.date = date;
		this.status = status;
		this.totalAmount = totalAmount;
		this.items = items;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public String getStatus() {
		return status;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
}
