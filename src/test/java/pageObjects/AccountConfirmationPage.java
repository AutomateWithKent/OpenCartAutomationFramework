package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountConfirmationPage extends BasePage{
	
	public AccountConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h1[text()='Your Account Has Been Created!']")
	WebElement lblConfirmationMessage;
	
	@FindBy(xpath="//a[text()=\"Continue\"]")
	WebElement btnContinue;
	
	public String getAccountConfirmationMessage()
	{
		try 
		{
		
		String accountConfirmationMessage = lblConfirmationMessage.getText();
		return accountConfirmationMessage;
		}
		catch(Exception e)
			{
			return e.getMessage();
			}		
	}
}
