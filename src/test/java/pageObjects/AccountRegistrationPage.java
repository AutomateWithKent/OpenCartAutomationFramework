package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private By chkPrivacyPolicyLocator = By.xpath("//input[@name='agree']");
	private By btnContinueLocator = By.xpath("//input[@value='Continue']");
	
	//action methods
	
	public void setFirstName(String firstName)
	{
		WebElement txtFirstName = wait.until(ExpectedConditions.elementToBeClickable(txtFirstNameLocator));
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		WebElement txtLastName = wait.until(ExpectedConditions.elementToBeClickable(txtLastNameLocator));
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		WebElement txtEmail = wait.until(ExpectedConditions.elementToBeClickable(txtEmailLocator));
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		WebElement txtTelephone = wait.until(ExpectedConditions.elementToBeClickable(txtTelephoneLocator));
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		WebElement txtPassword = wait.until(ExpectedConditions.elementToBeClickable(txtPasswordLocator));
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		WebElement txtConfirmPassword = wait.until(ExpectedConditions.elementToBeClickable(txtConfirmPasswordLocator));
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickPrivacyPolicy()
	{
		WebElement chkPrivacyPolicy = wait.until(ExpectedConditions.elementToBeClickable(chkPrivacyPolicyLocator));
		chkPrivacyPolicy.click();
	}
	
	public void clickContinueButton()
	{
		WebElement btnContinue = wait.until(ExpectedConditions.elementToBeClickable(btnContinueLocator));
		btnContinue.click();
	}

	
}
