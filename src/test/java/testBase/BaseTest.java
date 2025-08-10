package testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger; //log4j

public class BaseTest {
	
public WebDriver driver;
public Logger logger;
public Properties properties;

	@BeforeClass(groups = {"sanity","regression","master","datadriven"})
	@Parameters({"browser","os"})
	public void setup(String browser, String os) throws IOException, URISyntaxException
	{
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		properties = new Properties();
		properties.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
				if(os.equalsIgnoreCase("windows"))
					{
						capabilities.setPlatform(Platform.WIN11);
					}
				else if(os.equalsIgnoreCase("mac"))
					{
						capabilities.setPlatform(Platform.MAC);
					}
				else if(os.equalsIgnoreCase("linux"))
					{
						capabilities.setPlatform(Platform.LINUX);
					}
				else
				{
					System.out.println("No matching os: " + os );
					return;
				}
				
				switch(browser.toLowerCase())
				{
					case "chrome" : capabilities.setBrowserName("chrome"); break;
					case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
					case "firefox" : capabilities.setBrowserName("firefox"); break;
					default: System.out.println("No matching browser: " + browser); return;
				}
				driver = new RemoteWebDriver(new URI("http://192.168.1.6:4444/wd/hub").toURL(), capabilities);
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			default: System.out.println("Invalid browser"); return;
			}
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(properties.getProperty("apprUrl"));
	}
	
	@AfterClass(groups = {"sanity", "regression", "master","datadriven"})
	public void teardown() throws InterruptedException
	{
		//Thread.sleep(3000);
		driver.quit();
	}
	
	public String captureScreen(String fname) throws IOException
	{
		String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String filePath = System.getProperty("user.dir") + currentDateTime + "" + ".png";
		File targetFile = new File(filePath);
				
		sourceFile.renameTo(targetFile);
		
		return filePath;
	}	
	
	public String captureScreenshot(String tname) throws IOException {

		  String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date());
		    TakesScreenshot ts = (TakesScreenshot) driver;
		    File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		    String dir = System.getProperty("user.dir") + "\\screenshots\\";
		    File screenshotsDir = new File(dir);
		    if (!screenshotsDir.exists()) {
		        screenshotsDir.mkdirs();
		    }

		    String filePath = dir + tname + "_" + currentDateTime + ".png";
		    File targetFile = new File(filePath);

		    Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		    System.out.println("📸 Screenshot saved: " + filePath);

		    return filePath;
	}
}
		/*
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	*/
		
		 

