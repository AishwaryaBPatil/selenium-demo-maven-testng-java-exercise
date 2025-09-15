package com.SeleniumProject.seleniumdemo;

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
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(Util.Listeners.class)


public class LoginTest extends BaseClass {
	 static WebDriver driver;
		
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	
	{
		 if (driver == null) {
			 if(browser.equalsIgnoreCase("chrome"))
			 {
				 WebDriverManager.chromedriver().setup();
				 driver=new ChromeDriver();
			 }
			 else
				 if(browser.equalsIgnoreCase("firefox"))
				 {
					 WebDriverManager.firefoxdriver().setup();
					 driver=new FirefoxDriver();
				 }
				 else
					 if(browser.equalsIgnoreCase("edge")) {
						 WebDriverManager.edgedriver().setup();
						 driver=new EdgeDriver();
					 }
					 else
					 {
						 throw new IllegalArgumentException("browser not supported" +browser);
					 }
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       System.out.println(driver.getTitle());
		 } 
	}
	@Test(priority=1)
	public void validlogintest() throws InterruptedException 
	{
	   
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage login=new LoginPage(driver);
		login.clicklogin();
		login.username("Demodata");
		login.password("demodata");
		login.loginbutton();
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.alertIsPresent());
		    driver.switchTo().alert().accept();
		} catch (Exception e) {
		    System.out.println("No alert found");
		}

		
		

		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement welcomeMsg = wait1.until(ExpectedConditions
		            .visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));

		    Assert.assertTrue(welcomeMsg.isDisplayed(), "Login passed welcome message found");
		    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
		    wait1.until(ExpectedConditions
		            .elementToBeClickable(By.xpath("//*[@id=\"logout2\"]"))).click();
		    
		
	}


	@Test(priority=2)
	public void invalidlogintest() throws InterruptedException
	{
	
		
	   
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		LoginPage login1=new LoginPage(driver);
		login1.clicklogin();
		login1.username("Demodata");
		login1.password("demodata1");
		login1.loginbutton();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	     
		boolean error=alert.getText().contains("Wrong password.");
		Assert.assertTrue(error, "Login failed with wrong password");
		Thread.sleep(3000);

	}
	
	@AfterMethod
	public void tearDown()
	{
		
		if (driver != null) {
            driver.quit();
            driver=null;
        }
	}
}
