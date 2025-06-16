package com.tap;

public class Program1 {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class is Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
