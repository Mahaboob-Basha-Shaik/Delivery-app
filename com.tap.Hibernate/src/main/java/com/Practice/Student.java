package com.Practice;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	int id;

	@Column(name = "name")
	String name;

	@Column(name = "email")
	String email;

	public Student() {
	}

	public Student(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
