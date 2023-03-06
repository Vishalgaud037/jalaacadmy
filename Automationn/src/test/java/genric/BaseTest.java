package genric;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public static String configPath = "./config.properties";
	public static String testData = "./data/TestDataJ.xlsx";

	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {

		String appURL = Utility.getProperty(configPath, "URL");
		Reporter.log("AppURL: " + appURL);

		String strITO = Utility.getProperty(configPath, "ITO");
		int intITO = Integer.parseInt(strITO);

		String strETO = Utility.getProperty(configPath, "ETO");
		int intETO = Integer.parseInt(strETO);

		String browser = Utility.getProperty(configPath, "BROWSER");
	
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			Reporter.log("opening chrome browser",true);
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			Reporter.log("opening edge browser",true);
		}
		else if(browser.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver= new FirefoxDriver();
				Reporter.log("opening firefox browser",true);
		}
		else
		{
			Reporter.log("invalid browser");
			
		}
		
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intETO));
		wait= new WebDriverWait(driver, Duration.ofSeconds(intETO));
		
		
	
	}
	@AfterMethod
	public void closeApp() {
		driver.quit();
	}

}
