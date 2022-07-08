package tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v101.cachestorage.model.Header;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";

	public static FirefoxOptions firefoxOption() {
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		option.addPreference("browser.download.manager.showWhenStarting", false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}

	public static ChromeOptions chromeOption() {
		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		//options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}


	@BeforeSuite 
	@Parameters({"browser"}) //the same name of parameter in the testing.xml.
	public void StartUp(@Optional("chrome")String browserName) throws InterruptedException
	{
		if(browserName.equalsIgnoreCase("firefox")) {System.setProperty("webdriver.gecko.driver", 
				System.getProperty("user.dir")+"//Drivers//geckodriver.exe");
		driver=new FirefoxDriver(firefoxOption());
		}
		else if(browserName.equalsIgnoreCase("chrome")) {System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"//Drivers//chromedrivernew.exe");
		driver=new ChromeDriver(chromeOption());

		}
		else if(browserName.equalsIgnoreCase("ie")) {System.setProperty("webdriver.ie.driver", 
				System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		}

		driver.manage().window().maximize();


		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://demo.nopcommerce.com/ ");

		Thread.sleep(3000);
	}
	//we convert it to FireFoxDriver Because there is a problem with ChromeDriver 



	@AfterSuite
	public void CloseUp() {
		driver.quit();
	}


	//to take a screenshot if the method fail 
	@AfterMethod
	public void screenShotOnFailure(ITestResult result) {
		if (result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking Screenshot ...");
			Helper.takeScreenShot(driver, result.getName());

		}
	} 

}
