package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlaceOrder {
	WebDriver driver;
	AddToCart addtocart;
	       @FindBy(id="cartur")
	       WebElement cartbutton;
	       
	       @FindBy(xpath="//button[@class='btn btn-success']")
	       WebElement placeorderbutton;
	       
	       @FindBy(xpath="//input[@id='name']")
	       WebElement entername;
	       
	       @FindBy(xpath="//input[@id='country']")
	       WebElement entercountry;
	       
	       @FindBy(xpath="//input[@id='city']")
	       WebElement entercity;
	       
	       @FindBy(xpath="//input[@id='card']")
	       WebElement entercard;
	       
	       @FindBy(xpath="//input[@id='month']")
	       WebElement entermonth;
	       
	       @FindBy(xpath="//input[@id='year']")
	       WebElement enteryear;
	       
	       @FindBy(xpath="//button[@class='btn btn-primary' and text()='Purchase']")
	       WebElement purchasebutton;
	       
	       @FindBy(xpath="/html/body/div[10]/div[7]/div")
	       WebElement Thankyoualert;
	       
	       @FindBy(xpath="//*[@id=\"orderModal\"]/div/div/div[3]/button[1]")
	       WebElement closebutton;
	       public  PlaceOrder(WebDriver driver)
	       {
	    	   this.driver=driver;
	    	   this.addtocart=new AddToCart(driver);
	 		  PageFactory.initElements(driver, this);
	       }
	       
	       
	       public void placeorderofproduct()
	       {
	    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait.until(ExpectedConditions.elementToBeClickable(cartbutton)).click();

	    	  
	    	   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait1.until(ExpectedConditions.elementToBeClickable(placeorderbutton)).click();
	    	   
	    	   entername.sendKeys("selenium");
	    	   entercountry.sendKeys("Indiana");
	    	   entercity.sendKeys("boston");
	    	   entercard.sendKeys("5679432108");
	    	   entermonth.sendKeys("march");
	    	   enteryear.sendKeys("1987");
	    	   purchasebutton.click();
	    	   Thankyoualert.click();
	    	   WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait.until(ExpectedConditions.elementToBeClickable(closebutton)).click();
	    	   
	    	   
	    	   
	       }
	       
	       public void requirederrorplaceorderofproduct() throws InterruptedException
	       {
	    	   addtocart.clickproduct();
	    	   addtocart.addtocartclick();
	    	   
	    	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait.until(ExpectedConditions.elementToBeClickable(cartbutton)).click();

	    	  
	    	   WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
	    	   wait1.until(ExpectedConditions.elementToBeClickable(placeorderbutton)).click();
	    	  
	    	   
	    	   entername.sendKeys("selenium");
	    	   entercountry.sendKeys("Indiana");
	    	   Thread.sleep(2000);
	    	   purchasebutton.click();
	    	 
	    	   
	    	   
	    	   
	    	   
	    	   
	    	   
	       }
	       
	       
	    

}
