import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ToolQAExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		
		driver.findElement(By.name("firstname")).sendKeys("Hari");
		
		driver.findElement(By.name("lastname")).sendKeys("Gupta");
		
		clickRadio_checkBox(driver,"sex", "Male");
		
		clickRadio_checkBox(driver,"exp", "7");
		
		driver.findElement(By.id("datepicker")).sendKeys("11/12/2018");
		
		clickRadio_checkBox(driver,"profession", "Automation Tester");
		
		clickRadio_checkBox(driver,"profession", "Manual Tester");
		
		
		clickRadio_checkBox(driver,"tool", "Selenium Webdriver");
		
		// select for single select dropdown
		
		WebElement element=driver.findElement(By.id("continents"));
		
		Select select=new Select(element);
		System.out.println(select.isMultiple());
		select.selectByIndex(1);
		
		//select.selectByValue(arg0);
		
		select.selectByVisibleText("Australia");
		
		List<WebElement> list=select.getOptions();
		String expectedContinents="Asia,Europe,Africa,Australia,South America,North America,Antartica";
		String actualContinents="";
		for(int i=0;i<list.size();i++){
			String textValue=list.get(i).getText();
			System.out.println(textValue);
			actualContinents=actualContinents+","+textValue;
		}
		
		
		
		
		actualContinents=actualContinents.substring(1);
		
		System.out.println(actualContinents);
		
		
		
		if(expectedContinents.equals(actualContinents)){
			System.out.println("All the expected continents are present");
		}else{
			System.out.println("All the expected continents are not present");
		}
		
		
		//multi select dropdown
		
		WebElement multiSelectElement=driver.findElement(By.id("selenium_commands"));
		
		Select multiSelect=new Select(multiSelectElement);
		System.out.println(multiSelect.isMultiple());
		multiSelect.selectByVisibleText("Navigation Commands");
		multiSelect.selectByVisibleText("Wait Commands");
		multiSelect.selectByVisibleText("WebElement Commands");
		
		List<WebElement> list1=multiSelect.getAllSelectedOptions();
	
		if(list1.contains("Navigation Commands") && list1.contains("Wait Commands") && list1.contains("WebElement Commands")){
			System.out.println("All expected values are selected");
		}else{
			System.out.println("All expected values are not selected");
		}
		
		multiSelect.deselectByVisibleText("Wait Commands");
		
		multiSelect.deselectAll();

	}
	
	
	public static void clickRadio_checkBox(WebDriver driver,String name,String value){
		
		String elementLocator="//input[@name='"+name+"' and @value='"+value+"']";
		
		driver.findElement(By.xpath(elementLocator)).click();
		
		
	}

}
