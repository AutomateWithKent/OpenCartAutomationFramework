package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountConfirmationPage extends BasePage{
	
	public AccountConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By hdrAccountConfirmationLocator = By.xpath("//div[@id='content']//h1[text()='Your Account Has Been Created!']");
	private By btnContinueLocator = By.xpath("//a[text()=\\\"Continue\\\"]");
	
	public String getAccountConfirmationMessage()
	{
		WebElement hdrAccountConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(hdrAccountConfirmationLocator));
		String accountConfirmationMessage = hdrAccountConfirmation.getText();
		return accountConfirmationMessage;
	}
}
