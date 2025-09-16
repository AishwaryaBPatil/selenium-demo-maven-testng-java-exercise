package Util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	
	
		public static String takeScreenshot(WebDriver driver, String testName) {
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timeStamp + ".png";

	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File dest = new File(screenshotPath);
	        try {
	            FileHandler.copy(src, dest);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return screenshotPath;
	    }
		
	}


