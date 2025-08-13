package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{
	
	//constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	//page elements
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement chkPrivacyPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement btnContinue;
	
	//action methods
	
	public void setFirstName(String firstName)
	{
		
		txtFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		txtConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickPrivacyPolicy()
	{
		chkPrivacyPolicy.click();
	}
	
	public void clickContinueButton()
	{
		btnContinue.click();
	}

	
}
