package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	//constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	//page elements
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement lnkRegister;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement lnkLogin;
	
	//action methods
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	

}
