package com.tap;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {

		int a;
		int b;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter a number : ");
			a = scanner.nextInt();

			System.out.println("Enter b number : ");
			b = scanner.nextInt();
		}

		int res = a + b;
		System.out.println(a + " + " + b + " = " + res);
	}
}
