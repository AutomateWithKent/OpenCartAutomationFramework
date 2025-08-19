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
	
	public List<String> getProducts()
	{
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
}
