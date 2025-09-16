package Util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.SeleniumProject.seleniumdemo.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {
WebDriver driver;
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);  // Store in ThreadLocal for thread-safe logging
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseClass) currentClass).getdriver();

        By loginBtn = By.id("login2"); 
        if (CommonUtil.isButtonClickable(driver, loginBtn)) {
            test.get().log(Status.INFO, "Login button is clickable ✅");
        } else {
            test.get().log(Status.WARNING, "Login button is NOT clickable ⚠️");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	  Object currentClass1 = result.getInstance();
    	    WebDriver driver = ((BaseClass) currentClass1).getdriver();

    	    String screenshotPath = ScreenShot.takeScreenshot(driver, result.getMethod().getMethodName());

    	    test.get().fail("❌ Test Failed: " + result.getThrowable(),
			        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
    }

   
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  
    }
}