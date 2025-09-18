package com.mahaboob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Navigate to Google
		driver.get("https://www.google.com");
		Thread.sleep(2000);

		// Navigate to YouTube
		driver.navigate().to("https://www.youtube.com");
		Thread.sleep(2000);

		driver.navigate().to("https://www.instagram.com");
		Thread.sleep(2000);

		// Back to Google
		driver.navigate().back();
		Thread.sleep(2000);

		// Forward to YouTube
		driver.navigate().forward();
		Thread.sleep(2000);

		// Refresh the page
		driver.navigate().refresh();
		Thread.sleep(2000);

		driver.quit();
	}
}
