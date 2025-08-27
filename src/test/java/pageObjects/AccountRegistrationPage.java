package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class AccountRegistrationPage extends BasePage{
	
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//page elements
	private By txtFirstNameLocator = By.xpath("//input[@id='input-firstname']");
	private By txtLastNameLocator = By.xpath("//input[@id='input-lastname']");
	private By txtEmailLocator = By.xpath("//input[@id='input-email']");
	private By txtTelephoneLocator = By.xpath("//input[@id='input-telephone']");
	private By txtPasswordLocator = By.xpath("//input[@id='input-password']");
	private By txtConfirmPasswordLocator = By.xpath("//input[@id='input-confirm']");
	private By rdbtnSubscribeYesLocator = By.xpath("//label[normalize-space()='Yes']");
	private By chkPrivacyPolicyLocator = By.xpath("//input[@name='agree']");
	private By btnContinueLocator = By.xpath("//input[@value='Continue']");
	
	//action methods
	
	public void setFirstName(String firstName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtFirstNameLocator)).sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtLastNameLocator)).sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtEmailLocator)).sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtTelephoneLocator)).sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtPasswordLocator)).sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		wait.until(ExpectedConditions.elementToBeClickable(txtConfirmPasswordLocator)).sendKeys(confirmPassword);
	}
	
	public void clickBtnSubscribeYesLocator()
	{
		wait.until(ExpectedConditions.elementToBeClickable(rdbtnSubscribeYesLocator)).click();
	}
	
	public void clickPrivacyPolicy()
	{
		wait.until(ExpectedConditions.elementToBeClickable(chkPrivacyPolicyLocator)).click();
	}
	
	public void clickContinueButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btnContinueLocator)).click();
	}

	
}
