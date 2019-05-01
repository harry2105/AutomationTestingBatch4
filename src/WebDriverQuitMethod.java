import org.openqa.selenium.WebDriver;

public class WebDriverQuitMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("https://www.naukri.com/");
		// This method close all the windows which are refrenced to driver
		driver.quit();
		

	}

}
