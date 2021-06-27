package com.foodbox.user.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterTest {

	private WebDriver webDriver;

	private String userName;
	
	private long password;
	
	public RegisterTest(WebDriver webDriver, String userName, long password) {
		this.webDriver = webDriver;
		this.userName = userName;
		this.password = password;
		
		try {
			navigateToRegisteration();
			populateFields();
			clickRegister();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	private WebElement getElement(String xPath) {
		return this.webDriver.findElement(By.xpath(xPath));
	}

	private void navigateToRegisteration() {
		this.webDriver.navigate().to("http://localhost:4200/register");
	}

	private void populateFields() throws Exception {

		WebElement nameField = this.getElement(
				"/html/body/app-root/app-register/div/form/div/div[2]/mat-form-field/div/div[1]/div[3]/input");
		WebElement phNumberField = this.getElement(
				"/html/body/app-root/app-register/div/form/div/div[3]/mat-form-field/div/div[1]/div[3]/input");
		WebElement userNameField = this.getElement(
				"/html/body/app-root/app-register/div/form/div/div[4]/mat-form-field/div/div[1]/div[3]/input");
		WebElement passwordField = this.getElement(
				"/html/body/app-root/app-register/div/form/div/div[5]/mat-form-field/div/div[1]/div[3]/input");
		WebElement addressField = this.getElement(
				"/html/body/app-root/app-register/div/form/div/div[6]/mat-form-field/div/div[1]/div[3]/textarea");

		nameField.sendKeys("Testinguser");
		Thread.sleep(2000);
		phNumberField.sendKeys("1234567899");
		Thread.sleep(2000);
		userNameField.sendKeys(this.userName);
		Thread.sleep(2000);
		passwordField.sendKeys("12345");
		Thread.sleep(2000);
		addressField.sendKeys("Test users test address");
		Thread.sleep(2000);
	}

	private void clickRegister() {

		this.getElement("/html/body/app-root/app-register/div/form/div/div[7]/button").click();

		WebDriverWait wait = new WebDriverWait(this.webDriver, 2);
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		assert this.webDriver.switchTo().alert().getText().equals("Registration successfull"): "[TEST] Registration test case failed";

		System.out.println("[TEST] Registration test case passed");
		
		this.webDriver.switchTo().alert().accept();
		
	}

}
