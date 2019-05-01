import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParentFrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://chercher.tech/practice/frames-example-selenium-webdriver
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		// findElement
		// return type will be single webElement
		// NoSuch Element Exception
		// it will always return first webElement
		
		//findElements
		// return type will be List of webElement
		// if no Element is found then list size will be 0
		//it will store all the webElement
		
	}

}
