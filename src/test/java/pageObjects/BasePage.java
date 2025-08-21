package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//PageFactory.initElements(driver, this);		
	}
	
	public WebElement waitForElement(By locator, int timeout, int polling) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(polling))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(d -> {
                    WebElement element = d.findElement(locator);
                    return (element.isDisplayed() && element.isEnabled()) ? element : null;
                });
    }
	
	public void safeClick(By locator, int timeout, int polling) {
        WebElement element = waitForElement(locator, timeout, polling);
        element.click();
    }
	
}
