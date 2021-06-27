package com.foodbox.feature.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutTest {

	private WebDriver webDriver;

	public CheckoutTest(WebDriver webDriver) {

		this.webDriver = webDriver;

		clickCheckOut();

		fillCardDetailsAndPlaceOrder();

	}

	private void clickCheckOut() {

		try {

			WebDriverWait wait = new WebDriverWait(this.webDriver, 10);

			wait.until(ExpectedConditions.visibilityOf(this.webDriver.findElement(By.xpath(
					"/html/body/app-root/app-food-item-cart/div[2]/div/div[2]/mat-card/mat-card-content/ul/li[*]/app-checkout/button"))));

			this.webDriver.findElement(By.xpath(
					"/html/body/app-root/app-food-item-cart/div[2]/div/div[2]/mat-card/mat-card-content/ul/li[*]/app-checkout/button"))
					.click();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private WebElement getElement(String xPath) {

		return this.webDriver.findElement(By.xpath(xPath));
	}

	private void fillCardDetailsAndPlaceOrder() {

		try {

			WebDriverWait wait = new WebDriverWait(this.webDriver, 5);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/iframe[2]")));

			this.webDriver.switchTo().frame(this.webDriver.findElement(By.xpath("/html/body/iframe[2]")));

			WebElement cardNumberField = this.getElement(
					"/html/body/div[2]/section/span[2]/div/div/main/form/div/div/div/div/div/div[1]/div[2]/fieldset/div[1]/div[1]/span/span[1]/div/div[1]/input");

			WebElement cardExpieryDateField = this.getElement(
					"/html/body/div[2]/section/span[2]/div/div/main/form/div/div/div/div/div/div[1]/div[2]/fieldset/div[1]/div[2]/div[1]/div[1]/input");

			WebElement cardCVVField = this.getElement(
					"/html/body/div[2]/section/span[2]/div/div/main/form/div/div/div/div/div/div[1]/div[2]/fieldset/div[1]/div[2]/div[2]/div[1]/input");

			WebElement payButton = this
					.getElement("/html/body/div[2]/section/span[2]/div/div/main/form/nav/div/div/div/button");

			cardNumberField.sendKeys("5555555555554444");

			Thread.sleep(1000);

			cardExpieryDateField.sendKeys("1223");

			Thread.sleep(1000);

			cardCVVField.sendKeys("123");

			Thread.sleep(1000);

			payButton.click();

			this.webDriver.switchTo().defaultContent();

			wait.until(ExpectedConditions.alertIsPresent());

			assert this.webDriver.switchTo().alert().getText().equals("Payment Successfull !!")
					: "[TEST] Payment failed !!!";

			this.webDriver.switchTo().alert().accept();

			System.out.println("[TEST] Checkout test passed ");

		} catch (Exception e) {

			e.printStackTrace();

			System.out.println("[TEST] Checkout test failed !!!");

		}

	}

}
