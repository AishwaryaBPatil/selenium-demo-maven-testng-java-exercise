package com.SeleniumProject.seleniumdemo;

import org.testng.annotations.Test;

public class RahulShettyParcticetest extends BaseClass {

	@Test
	public void dropdown() throws InterruptedException
	{
		RahulShettyParctice r=new RahulShettyParctice(driver);
		r.dropdownclick();
	}

}
