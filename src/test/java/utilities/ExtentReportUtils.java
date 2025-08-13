package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseTest;

public class ExtentReportUtils implements ITestListener{
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	String reportName;
	

	
	public void onStart(ITestContext context) 
		{
		String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());	
		reportName = "Report_Test-" + currentDateTime + ".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\" + reportName);
		sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
		sparkReporter.config().setReportName("OpenCart Functional Test");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Automation Engineer", System.getProperty("user.name"));
		extent.setSystemInfo("Operating System", context.getCurrentXmlTest().getParameter("os"));
		extent.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		
		List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		}
	

	 public void onFinish(ITestContext context) {
		   extent.flush();
		   
		   String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+reportName;
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			} catch (IOException e) {
				e.printStackTrace();
			}
		  }
	
	 public void onTestSuccess(ITestResult result) {
		 		test = extent.createTest(result.getTestClass().getName());
		 		test.assignCategory(result.getMethod().getGroups());
		 		test.log(Status.PASS, result.getName() + " is successfully executed");
		  }
	
	 public void onTestFailure(ITestResult result) {
		    	test = extent.createTest(result.getTestClass().getName());
		    	test.assignCategory(result.getMethod().getGroups());
		    	test.log(Status.FAIL, result.getName() + " is failed");
		    	test.info(result.getThrowable().getMessage());
		    	
		    	try {
		    		BaseTest baseTest = (BaseTest) result.getInstance();
		    		
					String imgPath = baseTest.captureScreenshot(result.getName());
					test.addScreenCaptureFromPath(imgPath);
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
		  }

	 public void onTestSkipped(ITestResult result) {
		 		test = extent.createTest(result.getTestClass().getName());
		 		test.assignCategory(result.getMethod().getGroups());
		 		test.log(Status.SKIP, result.getName() + " is skipped");
		  }
	 
	
	 
	 
	 
}
