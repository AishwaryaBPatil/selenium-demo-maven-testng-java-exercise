package com.SeleniumProject.seleniumdemo;



	import java.time.Duration;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Parameters;
	import io.github.bonigarcia.wdm.WebDriverManager;

	public class BaseClass  {
		 static WebDriver driver;
		
		@Parameters("browser")
		@BeforeClass
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
		
		@AfterClass
		public void tearDown()
		{
			
			if (driver != null) {
	            driver.quit();
	            driver=null;
	        }
			
		}
		


	}


