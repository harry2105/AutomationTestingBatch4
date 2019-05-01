import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartExample {
	
	
	public static void main(String[] args) {
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("https://www.flipkart.com/");
		
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='✕']")));
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		Actions actions =new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Men')]"))).build().perform();
		
		
		List<WebElement> list=driver.findElements(By.xpath("(//li[@class='Wbt_B2 _1YVU3_'])[3]//a"));
		
		System.out.println(list.size());
		
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getAttribute("href"));
		}
		
	}

}
