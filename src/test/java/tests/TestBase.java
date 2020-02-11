package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

	public static WebDriver driver;
	public static String downloadPath = System.getProperty("user.dir") + "\\downloads";

	public ChromeOptions chromeOptions ()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		return options;
	}

	public FirefoxOptions firefoxOptions()
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList",2);
		option.addPreference("browser.download.dir",downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting",false);
		return option;
	}



	@BeforeSuite
	@Parameters({"browser"})
	public void SetUpEnvironment(@Optional("chrome") String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			String ChromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",ChromePath);
			driver = new ChromeDriver(chromeOptions());
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			String firefoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",firefoxPath);
			driver = new FirefoxDriver(firefoxOptions());
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			String iePath = System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver",iePath);
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.saucedemo.com/index.html");
	}

	@AfterSuite
	public void TearDown()
	{
		driver.quit();
	}

}
