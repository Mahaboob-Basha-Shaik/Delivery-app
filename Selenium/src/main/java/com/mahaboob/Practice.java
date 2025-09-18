package com.mahaboob;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;

public class Practice {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://github.com/login");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		// ID locator
		highlight(driver, driver.findElement(By.id("login_field")));
		Thread.sleep(2000);

		// NAME locator
		highlight(driver, driver.findElement(By.name("password")));
		Thread.sleep(2000);

		// CSS Selector for GitHub logo (new locator)
		highlight(driver, driver.findElement(By.cssSelector("a[href='https://github.com/'] svg")));
		Thread.sleep(2000);

		// LINK TEXT locator
		highlight(driver, driver.findElement(By.linkText("Forgot password?")));
		Thread.sleep(2000);

		// PARTIAL LINK TEXT locator
		highlight(driver, driver.findElement(By.partialLinkText("Create an")));
		Thread.sleep(2000);

		// TAG NAME locator
		highlight(driver, driver.findElement(By.tagName("h1")));
		Thread.sleep(2000);

		// XPATH locator
		highlight(driver, driver.findElement(By.xpath("//label[contains(text(),'Username or email address')]")));
		Thread.sleep(2000);

		// CSS SELECTOR locator
		highlight(driver, driver.findElement(By.cssSelector("input[name='commit']")));
		Thread.sleep(2000);

		driver.quit();
	}

	public static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
}
