package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import testBase.BaseTest;

public class TC_005_AddToCartTest extends BaseTest{

	@Test(groups = {"regression", "master"})
	public void testAddToCart()
	{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
			
		LoginPage login = new LoginPage(driver);
		login.setEmailAddress(properties.getProperty("email"));
		login.setPassword(properties.getProperty("password"));
		login.clickLogin();
		
		MyAccountPage accountPage = new MyAccountPage(driver);
		accountPage.setProduct(properties.getProperty("productSearch"));
		accountPage.clickSearch();
		
		SearchProductPage searchProduct = new SearchProductPage(driver);
		searchProduct.clickAddToCart(properties.getProperty("productSearch"));
		
		String actualAlertMessage = searchProduct.getAlertAddToCartMessage();
		
		String expectedAlertMessage = "Success: You have added "+properties.getProperty("productSearch")+" to your shopping cart!";
		
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
	
		/*
		boolean alertConfirmationIsDisplayed = searchProduct.alertAddToCartIsDisplayed();
	
		Assert.assertTrue(alertConfirmationIsDisplayed);
		*/
	}
	
}
