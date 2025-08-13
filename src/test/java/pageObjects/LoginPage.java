package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By txtEmailAddressLocator = By.xpath("//input[@id='input-email']");
	private By txtPasswordLocator = By.xpath("//input[@id='input-password']");
	private By btnLoginLocator = By.xpath("//input[@value='Login']");
	private By alertInvalidLoginLocator = By.xpath("//div[normalize-space()='Warning: No match for E-Mail Address and/or Password.']");
	
	public void setEmailAddress(String email)
	{
		WebElement txtEmailAddress = wait.until(ExpectedConditions.elementToBeClickable(txtEmailAddressLocator));
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		WebElement txtPassword = wait.until(ExpectedConditions.elementToBeClickable(txtPasswordLocator));
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		WebElement btnLogin = wait.until(ExpectedConditions.elementToBeClickable(btnLoginLocator));
		btnLogin.click();
	}
	
	public boolean alertInvalidLoginIsDisplayed()
	{
		WebElement alertInvalidLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(alertInvalidLoginLocator));
		return alertInvalidLogin.isDisplayed();
	}
	
	public void clearLoginFields()
	{
		WebElement txtEmailAddress = wait.until(ExpectedConditions.elementToBeClickable(txtEmailAddressLocator));
		txtEmailAddress.clear();
		WebElement txtPassword = wait.until(ExpectedConditions.elementToBeClickable(txtPasswordLocator));
		txtPassword.clear();
	}
}
