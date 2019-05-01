import java.util.Set;

import org.openqa.selenium.WebDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		
		driver.get("https://www.naukri.com/");
		
		// refrence of current window
		String currentWindow=driver.getWindowHandle();
		System.out.println(driver.getTitle());
		// set of all the open windows refrences
		Set<String> allWindows=driver.getWindowHandles();
		
		for(String eachWindow: allWindows){
			
			if(!eachWindow.equals(currentWindow)){
				driver.switchTo().window(eachWindow);
				System.out.println(driver.getTitle());
				driver.close();
			}
			
		}
		
		driver.switchTo().window(currentWindow);
		
	}

}
