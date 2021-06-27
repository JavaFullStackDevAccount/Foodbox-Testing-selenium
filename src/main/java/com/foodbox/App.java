package com.foodbox;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.foodbox.feature.tests.AddFoodItemTest;
import com.foodbox.feature.tests.CheckoutTest;
import com.foodbox.feature.tests.ManageFoodItemTest;
import com.foodbox.feature.tests.UserCartTest;
import com.foodbox.user.auth.LoginTest;
import com.foodbox.user.auth.LogoutTest;
import com.foodbox.user.auth.RegisterTest;
import com.foodbox.utils.CommonUtil;

public class App 
{
    public static void main( String[] args )
    {
    	
    	System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
    	
    	WebDriver driver  = new EdgeDriver();
    	
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	
    	//Testing admin features
    	
    	new LoginTest(driver);
    	
    	new AddFoodItemTest(driver);
    	
    	new ManageFoodItemTest(driver);
    	
    	new LogoutTest(driver);    	
    	
    	//Testing customer features
    	
    	String userName = CommonUtil.getUserName();
    	
    	new RegisterTest(driver, userName , CommonUtil.getPhoneNumber());
    	
    	new LoginTest(driver, userName);
    	
    	new UserCartTest(driver);
    	
    	//new CheckoutTest(driver);

    	new LogoutTest(driver);
    	
    	System.out.println("All tests completed !!");
    	
    }
}
