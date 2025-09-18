package com.tap;

public class Employee {

	private String name;
	private String email;
	private String department;
	private int salary;

	public Employee() {
	}

	public Employee(String name, String email, String department, int salary) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee : [" + name + " , " + email + " , " + department + " , " + salary + "]";
	}

}
