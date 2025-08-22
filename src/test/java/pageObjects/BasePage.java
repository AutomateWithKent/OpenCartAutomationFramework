package pageObjects;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	public void sendKeysWithRetry(By locator, String text) {
	    int attempts = 0;
	    while (attempts < 3) {   // retry up to 3 times
	        try {
	            WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            inputBox.clear(); // optional if you want to clear before typing
	            inputBox.sendKeys(text);
	            return; // success → exit method
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Retrying due to stale element: " + e.getMessage());
	        }
	        attempts++;
	    }
	    throw new RuntimeException("Failed to send keys after retries: " + locator);
	}
	
	public void clickWithRetry(By locator, String expectedUrlFragment, By alertLocator) {
	    int attempts = 0;
	    while (attempts < 3) {
	        try {
	            if (alertLocator != null) {
	                wait.until(ExpectedConditions.visibilityOfElementLocated(alertLocator));
	            }

	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

	            try {
	                element.click();
	            } catch (ElementClickInterceptedException ice) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	            }

	            if (expectedUrlFragment != null) {
	                wait.until(ExpectedConditions.urlContains(expectedUrlFragment));
	            }
	            return;

	        } catch (StaleElementReferenceException | TimeoutException e) {
	            System.out.println("Retrying click: " + e.getMessage());
	        }
	        attempts++;
	    }
	    throw new RuntimeException("Failed to click element after retries: " + locator);
	}
	
	
}
