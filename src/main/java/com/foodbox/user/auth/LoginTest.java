package com.foodbox.user.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest {
	
	private WebDriver webDriver;

	private String userName;
	
	private boolean asAdmin;
	
	public LoginTest(WebDriver webDriver, String userName) {
		
		this.webDriver = webDriver;
		
		this.userName = userName;
		
		this.webDriver.navigate().to("http://localhost:4200/login");
		
		attemptLogin();
	}
	
	public LoginTest(WebDriver webDriver) {
		
		this.webDriver = webDriver;
		
		this.asAdmin = true;
		
		this.webDriver.navigate().to("http://localhost:4200/login");
		
		attemptLogin();
	}
	
	private WebElement getElement(String xPath) {
		
		return this.webDriver.findElement(By.xpath(xPath));
	
	}

	
	private void attemptLogin() {
		
		try {
			
			WebElement userNameField = this.getElement("/html/body/app-root/app-login/div/form/div/div[2]/mat-form-field/div/div[1]/div[3]/input");
	
			WebElement passwordField = this.getElement("/html/body/app-root/app-login/div/form/div/div[3]/mat-form-field/div/div[1]/div[3]/input");

			userNameField.sendKeys((this.asAdmin) ? ("first@user.com"):(this.userName));

			Thread.sleep(2000);
			
			passwordField.sendKeys("12345");
			
			Thread.sleep(2000);
			
			this.clickLogin();
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
			System.out.println("[TEST] Login test failed");
			
		}
		
	}
	
	private void clickLogin() {
		
		try {
			
			WebElement loginButton = this.getElement("/html/body/app-root/app-login/div/form/div/div[4]/button");

			loginButton.click();
			
			Thread.sleep(2000);
			
			this.webDriver.switchTo().alert().accept();
			
		} catch(Exception e) {
			
			System.out.println("[TEST] Login test passed");
			
			
		}
	}
	
	
	
	
	
	
	
	
	

}
