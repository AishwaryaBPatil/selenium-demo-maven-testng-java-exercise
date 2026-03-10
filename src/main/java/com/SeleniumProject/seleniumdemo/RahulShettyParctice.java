package com.SeleniumProject.seleniumdemo;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RahulShettyParctice {

	WebDriver driver;
	
	
	@FindBy(id="dropdown-class-example")
	WebElement dropdown;
	
	@FindBy(id="dropdown-class-example")
	List<WebElement> dropdownlist;
	
	@FindBy(id="openwindow")
	WebElement parentwind;
	
	@FindBy(id="opentab")
	WebElement newtab;
	 
	@FindBy(xpath="//input[@value='Alert']")
	WebElement alertbutn;
	
	public void dropdownclick() throws InterruptedException
	{
		//dropdown.click();
		//Select s=new Select(dropdown);
		//s.selectByIndex(2);
		//s.selectByValue("Option1");
		/*for(WebElement drop:dropdownlist)
		{
			System.out.println(drop.getText());
		}*/
		
		//window handle
	/*	String parent = driver.getWindowHandle();
		parentwind.click();
		Set<String> multi=driver.getWindowHandles();
		for(String window:multi)
		{
			driver.switchTo().window(window);
		}
		
		driver.switchTo().parentFrame();
	}*/
		
		/*String parent=driver.getWindowHandle();
		newtab.click();
		
		Set<String> tab=driver.getWindowHandles();
		for(String tabs:tab)
		{
			if(!tabs.equals(parent))
			{
				driver.switchTo().window(tabs);
			}
		}
		
		driver.switchTo().parentFrame();*/
		/*alertbutn.click();
		Alert a=driver.switchTo().alert();
		a.dismiss();*/
		
		/*List<WebElement> rows=driver.findElements(By.xpath("//table[@id='product']//tr"));	
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> col=rows.get(i).findElements(By.tagName("td"));
			
			for(WebElement co:col)
			{
				System.out.println(co.getText());
			}
			
					
		}*/
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
	/*	Actions a=new Actions(driver);
		WebElement mousehover=driver.findElement(By.id("mousehover"));
		a.moveToElement(mousehover);
		Thread.sleep(200);*/
		
		WebElement frmae=driver.findElement(By.id("courses-iframe"));
		driver.switchTo().frame(frmae);
		driver.findElement(By.xpath("//a[contains(text(),'All Access plan')]")).click();
		driver.switchTo().defaultContent();
	}
	
	
	public RahulShettyParctice(WebDriver driver)
	{
		this.driver=driver;
		  PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	

}
