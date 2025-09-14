package Util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
private static ExtentReports  extent;
	
	public static ExtentReports getInstance()
	{
		if(extent == null)
		{
			//String link=System.getProperty("C:\\Users\\AISHWARYA\\eclipse-workspace\\eSeleniumFolderFramework\\selenium")+"/target/surefire-reports/ExtentReport.html";
			String reportPath = System.getProperty("user.dir") + "/target/ExtentReport.html";

			ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
			reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Aishwarya");
            extent.setSystemInfo("Environment", "QA");

		}
		return extent;
		
	}

}
