package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC_002_LoginTest extends BaseTest{
	
	
	@Test(groups = {"regression", "master"})
	public void verify_login()
	{
		logger.info("**** Starting Test on TC_002_LoginTest ****");
		HomePage hp = new HomePage(driver);
		logger.info("Navigating to HomePage");
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link");
		hp.clickLogin();
		logger.info("Click on Login Button");
		
		LoginPage login = new LoginPage(driver);
		logger.info("Navigating to LoginPage");
		
		login.setEmailAddress(properties.getProperty("email"));
		logger.info("Inputting email address: " + properties.getProperty("email"));
		login.setPassword(properties.getProperty("password"));
		logger.info("Inputting password: " + properties.getProperty("password"));
		login.clickLogin();
		logger.info("Clicked on Login Button");
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		logger.info("Navigating to MyAccountPage");
		boolean isMyAccountDisplayed = myAccountPage.isMyAccountDisplayed();
		logger.info("Validating login");
		
		try {
			//Assert.fail();
			Assert.assertTrue(isMyAccountDisplayed);
		logger.info("Test passed");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.error(e.getMessage());
		}
		logger.info("**** Test Completed on TC_002_LoginTest ****");
	}
	
}
