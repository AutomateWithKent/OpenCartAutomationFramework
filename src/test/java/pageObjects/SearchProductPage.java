package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchProductPage extends BasePage{

	public SearchProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By productLocator = By.xpath("//div[@class='caption']/h4");
	
	private By addToCartLocator(String productName)
	{
		productName = productName.toLowerCase();
		return By.xpath("//a[translate(normalize-space(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='"+productName+"']/ancestor::div[@class='product-thumb']//span[normalize-space()='Add to Cart']");
	}
	
	private By addToCartAlertMessageLocator = By.xpath("//div[contains(@class,'alert alert-success alert-dismissible')]");
	private By lnkShoppingCart = By.xpath("//div[@id='top-links']//span[normalize-space()='Shopping Cart']");
	
	public List<String> getProducts()
	{
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productLocator, 0));
		
		List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
		
		List<String> products = new ArrayList<>();
		for(WebElement product: productElements)
		{
			products.add(product.getText());
		}
		return products;
	
	}
	
	public void clickAddToCart(String productName)
	{
		WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addToCartLocator(productName)));
		addToCart.click();
	}
	
	public boolean alertAddToCartIsDisplayed()
	{
		try {
		WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartAlertMessageLocator));
		return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	
	public String getAlertAddToCartMessage()
	{
		try {
		String alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartAlertMessageLocator)).getText();
		return alertMessage;
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
	public void clickShoppingCart()
	{
		WebElement shoppingCart = wait.until(ExpectedConditions.visibilityOfElementLocated(lnkShoppingCart));
		shoppingCart.click();
	}
}
