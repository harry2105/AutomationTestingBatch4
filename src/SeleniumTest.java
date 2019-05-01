import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	//
	//static String ChromeDriverPath = "C:\\jarsandexes\\chromedriver_win32\\chromedriver.exe";
	public static void main(String[] args) throws InterruptedException, IOException {
		
			PropertyFileReader p=new PropertyFileReader();
			Properties properties=p.readPropertyFile("Data.properties");
			String strUserName=properties.getProperty("username");
			String password=properties.getProperty("password");
			String expectedResult=properties.getProperty("expectedResult");
			Properties properties1=p.readPropertyFile("Data1.properties");
			
		  System.out.println("Open Chrome Browser");
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://login.salesforce.com");
	      driver.findElement(By.id("username")).sendKeys(strUserName); //give your ID
		  driver.findElement(By.id("password")).sendKeys(password); //Give your password
		  driver.findElement(By.id("Login")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.id("tryLexDialogX")).click();
		  
		  driver.findElement(By.id("userNavLabel")).click();
		  
	
		  
		  List<WebElement> list=driver.findElement(By.id("userNav-menuItems")).findElements(By.tagName("a"));
		  
		  for(int i=0;i<list.size();i++){
			  
			  String actualResult=list.get(i).getText();
			  	if(expectedResult.contains(actualResult)){
				  System.out.println(actualResult+ " link is displayed under user menu");
				  }else{
					  System.out.println(actualResult+ " link is not displayed under user menu"); 
				  }
			  
		  }
		  
		  //int[] a= new int[5];
		 // List<Integer> list1=new ArrayList<>();
		  // Array & Array List
		  // When we declare an array we have define length of array
		  // ArrayList -> we dont have to define size of arraylist
		  


}
	
}
