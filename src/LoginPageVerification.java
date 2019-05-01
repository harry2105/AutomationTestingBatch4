import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebDriver;

public class LoginPageVerification {

	public static void main(String[] args) throws AWTException   {
		// TODO Auto-generated method stub
		
	// invalid username valid [password	
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("http://demo.testfire.net/login.jsp");

		try{
			
		Dimension dimension_username=driver.findElement(By.id("uid")).getSize();
		Dimension dimension_password=driver.findElement(By.id("passw")).getSize();
		
		
		
		if(driver.findElement(By.id("uid")).getAttribute("type").equals("text")){
			
		}
		
		
		driver.findElement(By.id("uid")).getCssValue("color");
		
		//driver.findElement(By.id("uid")).
		if(dimension_username.getWidth()==154){
			System.out.println("Pass");
		}else{
		System.out.println("fail");
		}
		System.out.println(dimension_username);
		System.out.println(dimension_password);
		
		driver.findElement(By.id("uid")).sendKeys("hari");
		driver.findElement(By.id("passw")).sendKeys("Demo1234");
		
		driver.findElement(By.name("btnSubmit")).click();
		
		String expectedErrorMessage="Login Failed: We're sorry, but  username or password was not found in our system. Please try again.";
		
		String strActualErrorMessage=driver.findElement(By.id("_ctl0__ctl0_Content_Main_message")).getText();
		
		System.out.println(strActualErrorMessage);
		if(expectedErrorMessage.equals(strActualErrorMessage)){
			System.out.println("Invalid login scenrio passed");
		}else{
			System.out.println("Invalid login scenrio Failed");
		}
	
		CaptureScreenshot.captureScreenshot(driver, "InvalidUsername");
		
	// Testcase2 - Blank username/blank password	
		driver.findElement(By.id("uid")).clear();
		driver.findElement(By.id("passw")).clear();
		
		driver.findElement(By.id("uid")).sendKeys("");
		driver.findElement(By.id("passw")).sendKeys("");
		driver.findElement(By.name("btnSubmit")).click();
	
			Thread.sleep(2000);
		 
		Alert alert=driver.switchTo().alert();
		String expectedAlertText="You must enter a valid username";
		String actualAlert=alert.getText();
		
		if(expectedAlertText.equals(actualAlert)){
			System.out.println("Alert Testcase paased");
		}else{
			System.out.println("Alert Testcase failed");
		}
		
		CaptureScreenshot.captureScreenShotWithAlert("BlankUsernameBlankPassword");
		alert.accept();
		
		
	
		
		
	
		
	}catch(NoSuchElementException e){
		
		e.printStackTrace();
		
	}catch(ElementNotVisibleException e1){
		e1.printStackTrace();
	}catch(ElementNotSelectableException e2){
		e2.printStackTrace();
	}catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch(ElementClickInterceptedException e){
		e.printStackTrace();
	}
		
		
	}
}
