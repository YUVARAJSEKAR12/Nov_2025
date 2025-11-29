package com.app.enc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	 public static void main(String[] args) throws Exception {
	        ConfigLoader cfg = new ConfigLoader("src/test/resources/TestData/config.properties");
	        String username = cfg.getUsername();
	        String password = cfg.getDecryptedPassword();

	        WebDriver driver = new ChromeDriver();
	        try {
	            driver.get("https://adactinhotelapp.com");
	            driver.findElement(By.id("username")).sendKeys(username);
	            driver.findElement(By.id("password")).sendKeys(password);
	            driver.findElement(By.id("loginBtn")).click();
	        } finally {
	            // driver.quit();
	        }
	    }
}
