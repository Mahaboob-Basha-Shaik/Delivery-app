package com.mahaboob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Open W3Schools dropdown example
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		driver.manage().window().maximize();

		// Switch to iframe
		driver.switchTo().frame("iframeResult");

		// Locate dropdown
		WebElement dropdown = driver.findElement(By.id("cars"));
		Select select = new Select(dropdown);

		// Select options
		select.selectByVisibleText("Saab");
		select.selectByValue("opel");
		select.selectByIndex(2);

		// Print selected option
		System.out.println("Selected: " + select.getFirstSelectedOption().getText());

		driver.quit();
	}
}
