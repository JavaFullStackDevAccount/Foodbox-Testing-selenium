package com.foodbox.feature.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageFoodItemTest {

	private WebDriver webDriver;

	public ManageFoodItemTest(WebDriver webDriver) {
		this.webDriver = webDriver;

		deleteItem();
	}

	private int getTotalNumberOfFoodCards() {

		return this.webDriver
				.findElements(By.xpath("html/body/app-root/app-dashboard/div/div/div[*]/app-food-card/mat-card"))
				.size();
	}

	private WebElement findNewlyAddedFoodItem() {

		for (int itr = 1; itr <= this.getTotalNumberOfFoodCards(); itr++) {

			WebElement foodCard = this.webDriver.findElement(
					By.xpath("html/body/app-root/app-dashboard/div/div/div[" + itr + "]/app-food-card/mat-card"));

			if (foodCard.getText().contains("Sample food by test"))

				return foodCard;

		}

		return null;

	}

	private void deleteItem() {

		try {

			WebDriverWait wait = new WebDriverWait(webDriver, 30);

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("html/body/app-root/app-dashboard/div/div/div[*]/app-food-card/mat-card")));

			WebElement foodCardAddedByTest = this.findNewlyAddedFoodItem();

			if (foodCardAddedByTest != null) {

				WebElement deleteButton = foodCardAddedByTest.findElement(By.className("delete-food-button")); 
				
				if(deleteButton != null) {
					
					deleteButton.click();
					
					wait.until(ExpectedConditions.alertIsPresent());
					
					this.webDriver.switchTo().alert().accept();
					
					System.out.println("[TEST] Manage food item test passed");
					
					
				} else {
					
					throw new NoSuchElementException("No food card found, added by test !! ");
					
				}

			} else {

				throw new NoSuchElementException("No food card found, added by test !! ");
			}

		} catch (Exception e) {

			System.out.println("[TEST] Manage food item test failed !!!");

		}

	}

}
