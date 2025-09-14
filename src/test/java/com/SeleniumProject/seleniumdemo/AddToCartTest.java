package com.SeleniumProject.seleniumdemo;

import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass {
	@Test
	public void addtocart()
	{
		AddToCart add=new AddToCart(driver);
		add.clickproduct();
	}

}
