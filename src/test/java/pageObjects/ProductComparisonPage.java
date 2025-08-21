package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductComparisonPage extends BasePage{
	
	public ProductComparisonPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By productNameLocator = By.xpath("//table/thead/following-sibling::tbody[1]/tr[1]/td/a");
	
	public List<String> getProductList()
	{
		List<String> productList = new ArrayList<String>();
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productNameLocator, 0));
		List<WebElement> products = driver.findElements(productNameLocator);
		
		for(WebElement product : products)
		{
			productList.add(product.getText());
		}
		
		return productList;
	}
}
