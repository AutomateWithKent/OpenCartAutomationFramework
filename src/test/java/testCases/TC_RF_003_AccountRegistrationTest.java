package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountConfirmationPage;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;
import utilities.RandomStringUtils;

public class TC_RF_003_AccountRegistrationTest extends BaseTest{
	
	@Test(groups= {"regression", "master"})
	public void Validate_registering_an_account_by_providing_all_the_fields()
	{
		String domainEmail = "@gmail.com";
		
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickRegister();
		
		AccountRegistrationPage register = new AccountRegistrationPage(driver);
		register.setFirstName(RandomStringUtils.generateRandomAlphabetic(9));
		register.setLastName(RandomStringUtils.generateRandomAlphabetic(10));
		register.setEmail(RandomStringUtils.generateRandomAlphabetic(12) + domainEmail);
		register.setTelephone("09"+ RandomStringUtils.generateRandomAlphaNumeric(9));
		String password = RandomStringUtils.generateRandomAlphaNumeric(13);
		register.setPassword(password);
		register.setConfirmPassword(password);
		register.clickBtnSubscribeYes();
		register.clickPrivacyPolicy();
		register.clickContinueButton();
		
		AccountConfirmationPage confirmationPage = new AccountConfirmationPage(driver);
		String actualConfirmationMessage = confirmationPage.getAccountConfirmationMessage();
		String expectedConfirmationMessage = "Your Account Has Been Created!";
		try {
		Assert.assertEquals(expectedConfirmationMessage, actualConfirmationMessage);
		}
		catch(AssertionError ae)
		{
			System.out.println("Assertion failed: " + ae.getMessage());
			Assert.fail();
		}
	}
	
}
