package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage{
	
	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By productLocator = By.xpath("//div[@class='table-responsive']/table/tbody/tr/td[2]/a");
	
	public List<String> getProductInCart()
	{
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productLocator, 0));

		List<WebElement> productElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
		
		List<String> products = new ArrayList<>();
		
		for(WebElement productElement : productElements)
		{
			products.add(productElement.getText());
		}
		
		return products;
		
	}
}
