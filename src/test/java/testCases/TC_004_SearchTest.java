package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchProductPage;
import testBase.BaseTest;

public class TC_004_SearchTest extends BaseTest{
	
	@Test(groups= {"sanity","master"})
	
	public void testSearchProduct() throws InterruptedException
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
	
		List<String> products = searchProduct.getProducts();
		int totalProductSearchResult = products.size();
		int totalProductMatched = 0;
		
		for(String product: products)
		{
			if(product.toLowerCase().contains(properties.getProperty("productSearch").toLowerCase()))
			{
				totalProductMatched++;
			}
		}
		System.out.println("Total product size: " + totalProductSearchResult);
		System.out.println("Total product matched: " + totalProductMatched);
		
		Assert.assertEquals(totalProductSearchResult, totalProductMatched);
		
	}
	
}
