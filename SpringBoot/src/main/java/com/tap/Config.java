package com.tap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean("employee")
	public Employee emp1() {
		return new Employee("Alex", "alex@gmail.com", "HR", 60000);
	}

}
