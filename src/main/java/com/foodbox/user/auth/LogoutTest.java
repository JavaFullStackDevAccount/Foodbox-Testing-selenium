package com.foodbox.user.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutTest {

	private WebDriver webDriver;

	public LogoutTest(WebDriver webDriver) {
	
		this.webDriver = webDriver;
		
		logoutTest();
	
	}

	private void logoutTest() {

		try {

			if (!this.webDriver.getCurrentUrl().equals("http://localhost:4200"))
				this.webDriver.navigate().to("http://localhost:4200");
			
			this.webDriver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-navbar/nav[1]/div/div/p/a[4]")).click();
			
			WebDriverWait wait = new WebDriverWait(this.webDriver, 5);
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			this.webDriver.switchTo().alert().accept();
			
			wait.until(ExpectedConditions.urlToBe("http://localhost:4200/login"));
			
			System.out.println("[TEST] Logout test passed");
			

		} catch (Exception e) {

			System.out.println("[TEST] Logout test failed !!");
			
			e.printStackTrace();
			
		}

	}

}
