package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductComparisonPage;
import pageObjects.SearchProductPage;
import testBase.BaseTest;

public class TC_006_ProductCompareTest extends BaseTest{
	@Test
	public void testCompareProduct()
	{
		HomePage home = new HomePage(driver);
		home.clickMyAccount();
		home.clickLogin();
		
		LoginPage login = new LoginPage(driver);
		login.setEmailAddress(properties.getProperty("email"));
		login.setPassword(properties.getProperty("password"));
		login.clickLogin();
		
		MyAccountPage myAccount = new MyAccountPage(driver);
		myAccount.setProduct(properties.getProperty("productSearch"));
		myAccount.clickSearch();
		
		SearchProductPage searchProduct = new SearchProductPage(driver);
		searchProduct.clickCompareThisProduct(properties.getProperty("productSearch"));
		searchProduct.clickProductComparisonLink();
		
		ProductComparisonPage productCompare = new ProductComparisonPage(driver);
		List<String> productList = productCompare.getProductList();
		boolean isProductFound = false;
		
		for(String product : productList)
		{
			if(product.equalsIgnoreCase(properties.getProperty("productSearch")))
			{
				isProductFound = true;
				System.out.println("Product found on list: " + product);
				break;
			}
		}
		
		Assert.assertTrue(isProductFound);
	}
}
