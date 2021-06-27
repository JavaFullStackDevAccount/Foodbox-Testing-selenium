package com.foodbox.feature.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFoodItemTest {

	private WebDriver webDriver;

	public AddFoodItemTest(WebDriver webDriver) {

		this.webDriver = webDriver;

		navigateToAddFoodItem();

		addFoodItem();

	}

	private WebElement getElement(String xPath) {

		return this.webDriver.findElement(By.xpath(xPath));
	}

	private void navigateToAddFoodItem() {

		WebDriverWait wait = new WebDriverWait(this.webDriver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-dashboard/a")));

		getElement("/html/body/app-root/app-dashboard/a").click();

	}

	private void addFoodItem() {

		try {
			
			
			WebElement foodTitleField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[1]/div[1]/mat-form-field/div/div[1]/div[3]/input");
			
			WebElement foodPriceField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[1]/div[2]/mat-form-field/div/div[1]/div[3]/input");
			
			WebElement foodCuisineField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[2]/div[1]/mat-form-field/div/div[1]/div[3]/mat-select");
			
			WebElement foodDiscountField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[2]/div[2]/mat-form-field/div/div[1]/div[3]/input");
			
			WebElement foodImageUrlField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[3]/div[1]/mat-form-field/div/div[1]/div[3]/input");
			
			WebElement foodRatingsField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[3]/div[2]/mat-form-field/div/div[1]/div[3]/mat-select");
			
			WebElement foodDescriptionField = this.getElement("/html/body/app-root/app-manage-food/form/div/div[3]/div[3]/mat-form-field/div/div[1]/div[3]/textarea");
			
			WebElement addFoodButton = this.getElement("/html/body/app-root/app-manage-food/form/div/div[4]/button");
			
			
			foodTitleField.sendKeys("Sample food by test");
			
			Thread.sleep(2000);
			
			foodPriceField.sendKeys("900");
			
			Thread.sleep(2000);
			
			foodCuisineField.sendKeys("Veg");
			
			Thread.sleep(2000);
			
			foodDiscountField.sendKeys("10");
			
			Thread.sleep(2000);
			
			foodImageUrlField.sendKeys("https://images2.minutemediacdn.com/image/upload/c_crop,h_1126,w_2000,x_0,y_181/f_auto,q_auto,w_1100/v1554932288/shape/mentalfloss/12531-istock-637790866.jpg");
			
			Thread.sleep(2000);
			
			foodRatingsField.sendKeys("4");
			
			Thread.sleep(2000);
			
			foodDescriptionField.sendKeys("This is a test food item added by the selnium test case for AddFoodItemTest");
			
			Thread.sleep(2000);
			
			addFoodButton.click();
			
			WebDriverWait wait = new WebDriverWait(this.webDriver, 30);

			wait.until(ExpectedConditions.alertIsPresent());
			
			assert this.webDriver.switchTo().alert().getText().equals("Added new food item") : "[TEST] Add food item test failed !!!";
			
			this.webDriver.switchTo().alert().accept();
			
			System.out.println("[TEST] Add food item test passed");
			
			
			
		} catch(Exception e){
			
			
			System.out.println("[TEST] Add food item failed !!");
			
			e.printStackTrace();

			
		}
		
	}

}
