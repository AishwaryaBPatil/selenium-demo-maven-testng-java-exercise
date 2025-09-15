package com.SeleniumProject.seleniumdemo;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
	
	@Test
	public void addtocart() throws InterruptedException
	{
		AddToCart add=new AddToCart(driver);
		add.clickproduct();
		add.addtocartclick();
		Thread.sleep(3000);
	}
	
	public void acceptalert()
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}

}
