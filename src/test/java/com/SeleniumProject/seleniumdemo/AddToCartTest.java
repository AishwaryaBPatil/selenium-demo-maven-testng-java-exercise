package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
	
	@Test
	public void addtocart() throws InterruptedException
	{
		AddToCart add=new AddToCart(driver);
		add.clickproduct();
		add.addtocartclick();
	 
		
	}
	
	
}
