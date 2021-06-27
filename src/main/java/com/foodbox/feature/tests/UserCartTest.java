package com.foodbox.feature.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCartTest {

	private WebDriver webDriver;

	private static final String FOOD_CARD_BASE_PATH = "/html/body/app-root/app-dashboard/div/div";

	private static final String CART_ITEMS_BASE_PATH = "/html/body/app-root/app-food-item-cart/div[2]/div/div[1]/ul/li[*]";

	private static final int MAX_ITEMS_TO_ADD_IN_CART = 5;

	public UserCartTest(WebDriver webDriver) {

		this.webDriver = webDriver;

		webDriver.navigate().to("http://localhost:4200");

		addToCartTest();

		verifyItemsAddedInCart();
	}

	private WebElement getFoodCardToAddToCart() {

		int randomDivIndex = (int) (this.getFoodCardCount() * Math.random());

		while (randomDivIndex == 0) {
			randomDivIndex = (int) (this.getFoodCardCount() * Math.random());
		}

		return this.webDriver.findElement(By.xpath((FOOD_CARD_BASE_PATH + "/div[" + (randomDivIndex)
				+ "]/app-food-card/mat-card/mat-card-actions/button")));

	}

	private int getFoodCardCount() {

		return webDriver
				.findElements(By.xpath(FOOD_CARD_BASE_PATH + "/div[*]/app-food-card/mat-card/mat-card-actions/button"))
				.size();

	}

	private void addToCartTest() {

		WebDriverWait wait = new WebDriverWait(this.webDriver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(webDriver.findElements(
				By.xpath(FOOD_CARD_BASE_PATH + "/div[*]/app-food-card/mat-card/mat-card-actions/button"))));

		for (int i = 0; i < MAX_ITEMS_TO_ADD_IN_CART; i++) {

			this.getFoodCardToAddToCart().click();

			WebDriverWait waitForAddedToCartAlert = new WebDriverWait(webDriver, 5);

			waitForAddedToCartAlert.until(ExpectedConditions.alertIsPresent());

			assert webDriver.switchTo().alert().getText().equals("Item added to cart")
					: "[TEST] Add to cart test failed";

			webDriver.switchTo().alert().accept();

		}

	}

	private void verifyItemsAddedInCart() {

		this.webDriver.findElement(By.xpath("/html/body/app-root/app-dashboard/app-navbar/nav[1]/div/div/p/a[2]"))
				.click();

		assert this.webDriver.findElements(By.xpath(CART_ITEMS_BASE_PATH)).size() >= 5
				: "[TEST] Add to cart test failed !!!";

		System.out.println("[TEST] Add to cart test passed");

	}

}
