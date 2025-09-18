package com.mahaboob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class HandleHtmlControls {
	public static void main(String[] args) {
		// Setup ChromeDriver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			// Open your form (replace with your actual page URL or local HTML file path)
			driver.get("file:///C:/Users/DELL/Desktop/form.html");
			driver.manage().window().maximize();

			// Create explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// === TextBox (Username) ===
			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			username.clear();
			username.sendKeys("mahaboob123");
			System.out.println("Entered Username: " + username.getAttribute("value"));

			// === Password Box ===
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("mypassword");

			// === Radio Button (Male) ===
			WebElement male = driver.findElement(By.id("male"));
			if (!male.isSelected()) {
				male.click();
			}

			// === Checkbox (Terms) ===
			WebElement terms = driver.findElement(By.id("terms"));
			if (!terms.isSelected()) {
				terms.click();
			}

			// === Dropdown (Country) ===
			WebElement countryElement = driver.findElement(By.id("country"));
			Select country = new Select(countryElement);
			country.selectByVisibleText("India");

			// === Button (Register) ===
			WebElement registerBtn = driver.findElement(By.id("register"));
			registerBtn.click();

			// === Link (Help) ===
			WebElement helpLink = driver.findElement(By.id("helpLink"));
			helpLink.click();

			System.out.println("✅ All controls handled successfully!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("⚠️ Could not locate one of the elements. Check locator.");
		} finally {
			// Close browser
			driver.quit();
		}
	}
}
