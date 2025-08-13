package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	//page elements
	private By lnkMyAccountLocator = By.xpath("//span[text()='My Account']");
	private By lnkRegisterLocator = By.xpath("//a[text()='Register']");
	private By lnkLoginLocator = By.xpath("//a[text()='Login']");
	
	//action methods
	public void clickMyAccount()
	{
		WebElement lnkMyAccount = wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccountLocator));
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		WebElement lnkRegister = wait.until(ExpectedConditions.elementToBeClickable(lnkRegisterLocator));
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		WebElement lnkLogin = wait.until(ExpectedConditions.elementToBeClickable(lnkLoginLocator));
		lnkLogin.click();
	}
	

}
