package com.SeleniumProject.seleniumdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTest extends BaseClass {
	@Test(priority=1, enabled=false)
	public void validplaceyourorder()
	{
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		    System.out.println("Alert text: " + alert.getText());
		    alert.accept();
		} catch (TimeoutException e) {
		    System.out.println("No alert present.");
		}
		PlaceOrder order=new PlaceOrder(driver);
		order.placeorderofproduct();

		
	}
	
	@Test(priority=2,enabled=false)
	public void requiredmessageerror() throws InterruptedException
	{
		PlaceOrder order1=new PlaceOrder(driver);
		order1.requirederrorplaceorderofproduct();
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
		Alert alert=wait1.until(ExpectedConditions.alertIsPresent());
		boolean al=alert.getText().contains("Please fill out Name and Creditcard.");
		Assert.assertTrue(al,"Not entered required info");
		alert.accept();
		
		
	}
	

}
