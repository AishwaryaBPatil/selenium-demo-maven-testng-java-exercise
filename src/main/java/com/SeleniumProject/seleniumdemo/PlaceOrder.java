package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
	WebDriver driver;
	       @FindBy(id="cartur")
	       WebElement cartbutton;
	       
	       @FindBy(xpath="//button[@class='btn btn-success']")
	       WebElement placeorderbutton;
	       
	       public void placeorderofproduct()
	       {
	    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait.until(ExpectedConditions.elementToBeClickable(cartbutton)).click();
	    	  
	    	   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait1.until(ExpectedConditions.elementToBeClickable(placeorderbutton)).click();
	    	   
	       }
	       
	       
	       public  PlaceOrder(WebDriver driver)
	       {
	    	   this.driver=driver;
	 		  PageFactory.initElements(driver, this);
	       }
	       

}
