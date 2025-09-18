package com.mahaboob;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandlingExample {
	public static void main(String[] args) throws InterruptedException {
		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open demo alert page
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.manage().window().maximize();

		// Switch to iframe where button is located
		driver.switchTo().frame("iframeResult");

		// Click the button to trigger alert
		driver.findElement(By.tagName("button")).click();

		// Switch to alert
		Alert alert = driver.switchTo().alert();

		// Get alert text
		System.out.println("Alert message: " + alert.getText());

		// Accept alert (click OK)
		alert.accept();

		// Pause to see result
		Thread.sleep(2000);

		driver.quit();
	}
}
