package com.SeleniumProject.seleniumdemo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	WebDriver driver;
	
	@FindBy(xpath="//a[@class='hrefch'and text()='Samsung galaxy s6']")
	WebElement productImage;
	
	@FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")
	WebElement addtocartbutton;
	
	public void clickproduct()
	{
		System.out.println("hello");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(productImage)).click();
		
		//productImage.click();
	}
	public void addtocartclick()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton)).click();
		
	}
	
	public AddToCart(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
	
}
