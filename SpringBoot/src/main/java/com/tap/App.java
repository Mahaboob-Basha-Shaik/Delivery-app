package com.tap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Employee emp = (Employee) context.getBean("employee");
		System.out.println(emp);
	}
}
