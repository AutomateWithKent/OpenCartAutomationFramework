package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutConfirmationPage extends BasePage{
	
	public LogoutConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	private By btnContinueLocator = By.xpath("//a[text()='Continue']");
	
	public void clickContinue()
	{
		WebElement btnContinue = wait.until(ExpectedConditions.elementToBeClickable(btnContinueLocator));
		btnContinue.click();
	}
	
}
