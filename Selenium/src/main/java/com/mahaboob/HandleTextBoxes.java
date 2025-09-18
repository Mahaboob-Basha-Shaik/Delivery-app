package com.mahaboob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleTextBoxes {
	public static void main(String[] args) {
		// Setup browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://example.com/login");

		// Locate textboxes
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));

		// Clear and type values
		username.clear();
		username.sendKeys("mahaboob123");

		password.clear();
		password.sendKeys("mypassword");

		// Get and print entered text (only works for username, not password usually)
		System.out.println("Username entered: " + username.getAttribute("value"));

		// Submit the form
		password.submit();

		driver.quit();
	}
}
