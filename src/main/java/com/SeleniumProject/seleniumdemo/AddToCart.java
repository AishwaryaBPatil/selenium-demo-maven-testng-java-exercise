package com.SeleniumProject.seleniumdemo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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
	
	@FindBy(id="next2")
	WebElement nextButton;
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Laptops']")
	WebElement laptopbutton;
	
	@FindBy(xpath="//div[@class='row' and @id='tbodyid']") 
	List<WebElement> multiplelaptop;
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Monitors']")
	WebElement monitorbutton;
	
	@FindBy(xpath="//div[@class='row' and @id='tbodyid']")
	List<WebElement> listmonitor;
	
	public void select_catagory()
	{
		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(10));
		waitt.until(ExpectedConditions.elementToBeClickable(laptopbutton)).click();;
	}
	public void selectmultiplelaptop()
	{
		laptopbutton.click();
		
		for(WebElement lap:multiplelaptop)
		{
			System.out.println(lap.getText());
		}
		
		
	}
	
	public void selectMultiplemonitorbtn()
	{
		monitorbutton.click();
		System.out.println("not");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		for(WebElement moni:listmonitor)
		{
			System.out.println("not solved");
			System.out.println(moni.getText());
		}
		
	}
	public void clickproduct()
	{
		//System.out.println("hello");
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.elementToBeClickable(productImage)).click();
		
		//productImage.click();
	}
	public void addtocartclick()
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton)).click();
		   try {
		        WebDriverWait wa = new WebDriverWait(driver, Duration.ofSeconds(10));
		        Alert alert = wa.until(ExpectedConditions.alertIsPresent());
		        System.out.println("Alert text: " + alert.getText());
		        alert.accept();
		    } catch (TimeoutException e) {
		        System.out.println("No alert present.");
		    }
		}
		
	public void clickNextbutton()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		nextButton.click();
	}
	
	public AddToCart(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
	

}
