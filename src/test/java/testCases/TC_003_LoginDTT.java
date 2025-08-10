package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutConfirmationPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC_003_LoginDTT extends BaseTest{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups = "datadriven")
	public void verifyLoginDTT(String email, String password, String expectedResult)
	{
		logger.info("**** Starting Test on TC_003_LoginDTT ****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		login.setEmailAddress(email);
		login.setPassword(password);
		login.clickLogin();
		
		if(expectedResult.equalsIgnoreCase("Valid"))
		{
			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean myAccountHeaderIsDisplayed = myAccountPage.isMyAccountDisplayed();
			myAccountPage.clickLogout();
			LogoutConfirmationPage logoutPage = new LogoutConfirmationPage(driver);
			logoutPage.clickContinue();
			
			Assert.assertTrue(myAccountHeaderIsDisplayed);
		}
		else
		{
			boolean alertInvalidLoginIsDisplayed = login.alertInvalidLoginIsDisplayed();
			login.clearLoginFields();
			Assert.assertTrue(alertInvalidLoginIsDisplayed);
		}
		
		logger.info("**** Test Completed on TC_003_LoginDTT ****");
	}
	
}
