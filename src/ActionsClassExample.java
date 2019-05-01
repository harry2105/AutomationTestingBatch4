import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("https://www.amazon.in/");
		
	Actions actions=new Actions(driver);
	
	actions.moveToElement(driver.findElement(By.id("nav-link-shopall"))).build().perform();
	
	actions.moveToElement(driver.findElement(By.xpath("//span[text()='TV, Appliances, Electronics']"))).build().perform();
	
	driver.findElement(By.xpath("//span[text()='Televisions']")).click();
	
	
	}

}
