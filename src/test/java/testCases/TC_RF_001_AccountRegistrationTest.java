package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.AccountConfirmationPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.RandomStringUtils;

public class TC_RF_001_AccountRegistrationTest extends BaseTest{
	
	/*
	@AfterMethod
	public void logoOut()
	{
		AccountConfirmationPage accountConfirmation = new AccountConfirmationPage(driver);
		accountConfirmation.clickMyAccount();
		accountConfirmation.clickLogOut();
	}
	
	@BeforeMethod
	public void goToHomePage()
	{
		driver.get(properties.getProperty("apprUrl"));
	}
	*/
	
	@Test(groups = {"sanity","master"})
	public void validate_Registering_an_Account_by_providing_only_the_Mandatory_fields()
	{
		logger.info("**** Starting Test on TC_001_AccountRegistrationTest ****");
		logger.info("Opening Browser ");
		HomePage home = new HomePage(driver);
		logger.info("Clicked on My Account Link ");
		home.clickMyAccount();
		logger.info("Clicked on Register Link ");
		home.clickRegister();
		String emailDomain = "@gmail.com";
		
		logger.info("Navigating to Account Registration Page ");
		AccountRegistrationPage register = new AccountRegistrationPage(driver);
		
		logger.info("Inputting data on registration fields ");
		register.setFirstName(RandomStringUtils.generateRandomAlphabetic(9));
		register.setLastName(RandomStringUtils.generateRandomAlphabetic(12));
		
		String email = RandomStringUtils.generateRandomAlphabetic(7) + emailDomain;
		register.setEmail(email);
		logger.info("Inputting email on email field: " + email);
		register.setTelephone(RandomStringUtils.generateRandomNumeric(11));
		
		
		String password = RandomStringUtils.generateRandomAlphaNumeric(15);
		logger.info("Inputting password & confirm password: " + password);
		register.setPassword(password);
		register.setConfirmPassword(password);
		
		logger.info("Clicking 'Yes' Subscribe Button");
		register.clickBtnSubscribeYes();
		
		logger.info("Clicked on Privacy Policy Checkbox");
		register.clickPrivacyPolicy();
		
		logger.info("Clicked on Continue Button");
		register.clickContinueButton();
		
		logger.info("Navigating to Account Confirmation Page");
		AccountConfirmationPage confirmationPage = new AccountConfirmationPage(driver);
		String actualConfirmationText = confirmationPage.getAccountConfirmationMessage();
		String expectedConfirmationText = "Your Account Has Been Created!";
		try {
		Assert.assertEquals(actualConfirmationText, expectedConfirmationText);
		logger.info("Test passed");
		}
		catch(AssertionError ae)
		{
			logger.error("Test failed, AssertionError caught: " + ae.getMessage());
			Assert.fail();
		}
		logger.info("**** Test Completed on TC_001_AccountRegistrationTest ****");
	}

}
