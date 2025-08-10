package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccountHeader;
	
	@FindBy(xpath= "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	public boolean isMyAccountDisplayed()
	{
		waitForElement(myAccountHeader);
		return (myAccountHeader.isDisplayed());
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
}
