import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameExample {

	
	public static void main(String[] args) {
		
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		//driver.switchTo().frame(1);
		
		//driver.switchTo().frame("_mN_main_224278574_0_n");
		
		WebElement element=driver.findElement(By.xpath("//iframe[contains(@id,'_mN_main_')]"));
		
		driver.switchTo().frame(element);
		
		driver.findElement(By.linkText("Data Science Courses")).click();
		
		driver.switchTo().defaultContent();
		
/*		
		
		driver.switchTo().parentFrame().switchTo().frame("1");
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();*/
		
		
		driver.findElement(By.linkText("Insurance Project")).click();

		
		String currentWindow=driver.getWindowHandle();
		System.out.println(currentWindow);
		
		Set<String> allWindows=driver.getWindowHandles();
		
		System.out.println(allWindows);
		
		
		for(String eachWindow:allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
				driver.findElement(By.xpath("//div[@class='adwraps']//p[contains(text(),'Become a')]")).click();
				break;
			}
		}
		
		//driver.switchTo().window(currentWindow);
		
		
		
		
		
		
		
	}
}
