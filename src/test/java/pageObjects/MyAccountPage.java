package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By hdrMyAccountLocator = By.xpath("//h2[text()='My Account']");
	private By lnkLogoutLocator = By.xpath("//div[@class='list-group']//a[text()='Logout']");
	private By txtSearchLocator = By.xpath("//input[@placeholder='Search']");
	private By btnSearchProductLocator = By.xpath("//div[@id='search']//button");
	
	public boolean isMyAccountDisplayed()
	{
		WebElement lnkMyAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(hdrMyAccountLocator));
		return (lnkMyAccount.isDisplayed());
	}
	
	public void clickLogout()
	{
		WebElement lnkLogout = wait.until(ExpectedConditions.elementToBeClickable(lnkLogoutLocator));
		lnkLogout.click();
	}
	
	public void setProduct(String product)
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(txtSearchLocator));
		WebElement txtSearch = driver.findElement(txtSearchLocator);
		txtSearch.sendKeys(product);
	}
	
	public void clickSearch()
	{
		WebElement btnSearchProduct = wait.until(ExpectedConditions.elementToBeClickable(btnSearchProductLocator));
		btnSearchProduct.click();
	}
}
