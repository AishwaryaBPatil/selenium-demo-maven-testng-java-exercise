package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseClass {
	@Test
	public void placeyourorder()
	{
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    System.out.println("Alert text: " + alert.getText());
		    alert.accept(); // or alert.dismiss();
		} catch (TimeoutException e) {
		    System.out.println("No alert present.");
		}
		PlaceOrder order=new PlaceOrder(driver);
		order.placeorderofproduct();
		
	}

}
