package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseClass {
	@Test
	public void correctlogintest() throws InterruptedException
	{
	   System.out.println("hello");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage login=new LoginPage(driver);
		login.clicklogin();
		login.username("Demodata");
		login.password("demodata");
		login.loginbutton();
		System.out.println("Login test executed");
		Assert.assertTrue(true, "Login passed");
		Thread.sleep(3000);
	}

}
