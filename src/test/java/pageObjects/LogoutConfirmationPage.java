package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutConfirmationPage extends BasePage{
	
	WebDriver driver;
	
	public LogoutConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Continue']")
	WebElement btnContinue;
	
	public void clickContinue()
	{
		waitForElement(btnContinue);
		btnContinue.click();
	}
	
}
