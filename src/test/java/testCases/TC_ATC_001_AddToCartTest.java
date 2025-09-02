package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseTest;

public class TC_ATC_001_AddToCartTest extends BaseTest{

	@Test(groups = {"regression", "master"})
	public void Validate_adding_the_product_to_Cart_from__Product_Display_Page()
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
		searchProduct.clickShoppingCart();
		
		Assert.assertTrue(actualAlertMessage.contains(expectedAlertMessage));
		
		ShoppingCartPage cart = new ShoppingCartPage(driver);
		cart.waitForUrlContains();
		List<String> products = cart.getProductInCart();
		boolean productIsFound = false;
		for(String product : products)
		{
			if(product.equalsIgnoreCase(properties.getProperty("productSearch")))
			{
				productIsFound = true;
				break;
			}
		}
		
		Assert.assertTrue(productIsFound);
		
		/*
		boolean alertConfirmationIsDisplayed = searchProduct.alertAddToCartIsDisplayed();
	
		Assert.assertTrue(alertConfirmationIsDisplayed);
		*/
	}
	
}
