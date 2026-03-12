package com.SeleniumProject.seleniumdemo;
import Util.ExelUtil;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import Util.ExelUtil;
@Listeners(Util.Listeners.class)


public class LoginTest extends BaseClass {
	
	@DataProvider(name="login")
	public Object[][] getdata() throws Exception
	{
		 System.out.println("DataProvider running...");
	    return ExelUtil.getTestData();
	}

	@Test(dataProvider="login")
	public void validlogintest(String username, String password) throws InterruptedException 
	{
	   
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage login=new LoginPage(driver);
		System.out.println("sfxuwscxz");
		login.clicklogin();
		login.username(username);
		login.password(password);
		System.out.println(username+" "+password);
		login.loginbutton();
		

		
		

		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement welcomeMsg = wait1.until(ExpectedConditions
		            .visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));

		    Assert.assertTrue(welcomeMsg.isDisplayed(), "Login passed welcome message found");
		    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    wait1.until(ExpectedConditions
		            .elementToBeClickable(By.xpath("//*[@id=\"logout2\"]"))).click();
		   
		    try {
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			    wait.until(ExpectedConditions.alertIsPresent());
			    driver.switchTo().alert().accept();
			} catch (Exception e) {
			    System.out.println("No alert found");
			}
		
	}

@Test
public void verifyUIloginpage()
{
	LoginPage lo=new LoginPage(driver);
	String expectedcolor="whitee";
	String actualcolor=lo.loginbuttoncolor();
	Assert.assertEquals(expectedcolor, actualcolor,"Message if color is not same");
	
	}
	@Test(priority=2)
	public void invalidlogintest() throws InterruptedException
	{
	
		
	   
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage login1=new LoginPage(driver);
		login1.clicklogin();
		login1.username("seleniumpractice");
		login1.password("selenium");
		login1.loginbutton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	     
		boolean error=alert.getText().contains("Wrong password.");
		Assert.assertTrue(error, "Login failed with wrong password");
		Thread.sleep(3000);

	}
	

}
