package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement myAccountHeader;
	
	@FindBy(xpath= "//div[@class='list-group']//a[text()='Logout']")
	private WebElement lnkLogout;
	
	private By txtSearchLocator = By.xpath("//input[@name='search']");
	
	@FindBy(xpath="//div[@id='search']//button")
	private WebElement btnSearchProduct;
	
	public boolean isMyAccountDisplayed()
	{
		waitForElement(myAccountHeader);
		return (myAccountHeader.isDisplayed());
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	public void setProduct(String product)
	{
		WebElement txtSearch = wait.until(ExpectedConditions.elementToBeClickable(txtSearchLocator));
		txtSearch.sendKeys(product);
	}
	
	public void clickSearch()
	{
		waitForElementToBeClickable(btnSearchProduct);
		btnSearchProduct.click();
	}
}
