package com.SeleniumProject.seleniumdemo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Test(enabled = false)
public class AddToCartTest extends BaseClass {
	@Test
	public void selectcatagory()
	{
		AddToCart add2=new AddToCart(driver);
		add2.select_catagory();
	}
	@Test
	public void listlaptop()
	{
		AddToCart a=new AddToCart(driver);
		a.selectmultiplelaptop();
				
	}
	@Test
	public void listmonitor()
	{
		AddToCart aa=new AddToCart(driver);
		aa.selectMultiplemonitorbtn();
	}
	@Test
	public void addtocart() throws InterruptedException
	{
		AddToCart add=new AddToCart(driver);
		add.clickproduct();
		add.addtocartclick();
	 
		
	}
	@Test
	public void clicknextpage()
	{
		AddToCart add1=new AddToCart(driver);
		Wait<WebDriver> wait=new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		
		
		add1.clickNextbutton();
	}
	
	
	
}


