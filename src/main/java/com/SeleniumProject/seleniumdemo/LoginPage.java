    package com.SeleniumProject.seleniumdemo;
	import java.time.Duration;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LoginPage {
		 WebDriver driver;
		
		@FindBy(id="login2")
		WebElement enterlogin;
		
		@FindBy(id="loginusername")
		WebElement usernamefeild;
		
		@FindBy(id="loginpassword")
		WebElement passwordfeild;
		
		@FindBy(xpath="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
		WebElement Login;
		
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			  PageFactory.initElements(driver, this);
		}
	     public void clicklogin() throws InterruptedException
	     {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	         wait.until(ExpectedConditions.elementToBeClickable(enterlogin)).click();

	         
	         wait.until(ExpectedConditions.visibilityOf(usernamefeild));
	    

	 		
	     }
		
		public void username(String username)
		{
			usernamefeild.sendKeys(username);
		}
		public void password(String password)
		{
			passwordfeild.sendKeys(password);
		}
		public void loginbutton() throws InterruptedException
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
	        } catch (Exception e) {
	            // fallback to JS click if intercepted
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();", Login);
	        }

	      
	       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
	        //commit
	        
	    }
		
			
	}




