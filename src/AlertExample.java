import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		
		try{
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(1000);
		Alert alert=driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
		driver.findElement(By.linkText("Home")).click();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	

}
