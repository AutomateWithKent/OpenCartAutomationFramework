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
	private By lnkMyAccount = By.xpath("//span[normalize-space()='My Account']");
	private By lnkLogOut = By.xpath("//ul[contains(@class, 'dropdown-menu')]/li[normalize-space()='Logout']");
	
	public String getAccountConfirmationMessage()
	{
		WebElement hdrAccountConfirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(hdrAccountConfirmationLocator));
		String accountConfirmationMessage = hdrAccountConfirmation.getText();
		return accountConfirmationMessage;
	}
	
	public void clickMyAccount()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnkMyAccount)).click();
	}
	
	public void clickLogOut()
	{
		wait.until(ExpectedConditions.elementToBeClickable(lnkLogOut)).click();
	}
	
}
