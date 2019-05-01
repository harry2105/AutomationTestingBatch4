import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		WebDriverWait wait =new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		driver.findElement(By.xpath("//a[@title='author profile']")).click();
		
//		
//		WebDriverWait wait1 =new WebDriverWait(driver, 120);
//		wait1.until(ExpectedConditions.attributeContains(locator, attribute, value))
//		wait1.until(ExpectedConditions.attributeContains(element, attribute, value))
//		
//		wait1.until(ExpectedConditions.)
	
	}

}
