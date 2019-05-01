import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseDriver {
	
	
	public WebDriver getDriver(String browserType){
		WebDriver driver = null;
		
		if(browserType.equalsIgnoreCase("CHROME")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions chromeoptions=new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			 driver=new ChromeDriver(chromeoptions);	
		} else if(browserType.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else if(browserType.equalsIgnoreCase("FIREFOX")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			 driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

}
