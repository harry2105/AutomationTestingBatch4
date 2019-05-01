
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SeleniumWebDriverExample extends BaseDriver{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// firefox
		// Upcasting
		
		SeleniumWebDriverExample se=new SeleniumWebDriverExample();
		WebDriver driver=se.getDriver("Chrome");
		
		driver.get("https://www.google.com/");
		
		// methods in webDriver
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getPageSource());
		
		System.out.println(driver.getCurrentUrl());
		
	// navigation commands
		
		//driver.navigate().back();
		
		//Thread.sleep(2000);
		//driver.navigate().forward();
		
		//driver.navigate().refresh();
		
		//driver.navigate().to("https://mail.google.com");
		
		//driver.manage().deleteAllCookies();
		
		
		
		// findElement 
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//h3[text()='Selenium - Web Browser Automation']")).click();
		
		driver.findElement(By.linkText("Documentation")).click();
		
		String expectedTitle="Selenium Documentation — Selenium Documentation";
		
		String actualTitle=driver.getTitle();
		
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Testcase passed");
		}else{
			System.out.println("Testcase failed");
		}
		
		// it close current browser
		//driver.close();
		
		
			
		

	}

}
