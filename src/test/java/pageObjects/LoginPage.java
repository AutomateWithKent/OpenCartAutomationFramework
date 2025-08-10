package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']")
	WebElement alertInvalidLogin;
	
	public void setEmailAddress(String email)
	{
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public boolean alertInvalidLoginIsDisplayed()
	{
		waitForElement(alertInvalidLogin);
		return alertInvalidLogin.isDisplayed();
	}
	
	public void clearLoginFields()
	{
		txtEmailAddress.clear();
		txtPassword.clear();
	}
}
