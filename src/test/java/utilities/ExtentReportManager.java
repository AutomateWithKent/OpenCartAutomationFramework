package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
	    sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\extentReport.html");
	    sparkReporter.config().setDocumentTitle("AutomationReport");
	    sparkReporter.config().setReportName("Functional Test");
	    sparkReporter.config().setTheme(Theme.DARK);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    String currentUser = System.getProperty("user.name");
	    extent.setSystemInfo("Computer", currentUser);
	    
	    String browserName = context.getCurrentXmlTest().getParameter("browser");
	    
	    extent.setSystemInfo("Browser", browserName);
	    extent.setSystemInfo("Operating System", "Windows 11");
	    extent.setSystemInfo("Automation Tester", "AutomationByK");
	    extent.setSystemInfo("Environment", "DEV");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test is PASSED for: " + result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test is FAILED for: " + result.getName());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test is SKIPPED for: " + result.getName());
	}

	  public void onFinish(ITestContext context) {
	    extent.flush();
	  }
}
