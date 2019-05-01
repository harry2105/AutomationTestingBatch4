import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooDataDriven {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String strFileName="TestData.xlsx";
		File file=new File(strFileName);
		
		FileInputStream fis=new FileInputStream(file);

		Workbook workbook = null;
		
		if(strFileName.contains(".xlsx")){
			workbook=new XSSFWorkbook(fis);
		}else if(strFileName.contains(".xls")){
			workbook=new HSSFWorkbook(fis);
		}
		
		
		Sheet sheet=workbook.getSheet("TestData");
		
		int rowCount=sheet.getLastRowNum();
		
		System.out.println(rowCount);
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		
		
		for(int i=1;i<=rowCount;i++){
			
			Row row=sheet.getRow(i);
			int columnCount=row.getLastCellNum();
			
			String firstName=row.getCell(0).getStringCellValue();
			String lastName=row.getCell(1).getStringCellValue();
			String emailId=row.getCell(2).getStringCellValue();
			String password=row.getCell(3).getStringCellValue();
			Cell cell_MobNo=row.getCell(4);
			cell_MobNo.setCellType(CellType.STRING);
			String mobNo=cell_MobNo.getStringCellValue();
			String month=row.getCell(5).getStringCellValue();
			String day=row.getCell(6).getStringCellValue();
			Cell cell_Year=row.getCell(7);
			cell_Year.setCellType(CellType.STRING);
			String year=cell_Year.getStringCellValue();
			String gender=row.getCell(8).getStringCellValue();
			driver.get("https://login.yahoo.com/account/create?src=fpctx&intl=in&lang=en-IN&done=https%3A%2F%2Fin.yahoo.com&specId=yidReg");
			
			driver.findElement(By.id("usernamereg-firstName")).sendKeys(firstName);
			
			driver.findElement(By.id("usernamereg-lastName")).sendKeys(lastName);
			
			driver.findElement(By.id("usernamereg-yid")).sendKeys(emailId);
			
			driver.findElement(By.id("usernamereg-password")).sendKeys(password);
			
			driver.findElement(By.id("usernamereg-phone")).sendKeys(mobNo);
			
			WebElement element=driver.findElement(By.id("usernamereg-month"));
			
			Select select=new Select(element);
			
			select.selectByVisibleText(month);
			
			driver.findElement(By.id("usernamereg-day")).sendKeys(day);
			driver.findElement(By.id("usernamereg-year")).sendKeys(year);
			
			driver.findElement(By.id("usernamereg-freeformGender")).sendKeys(gender);
			
			driver.findElement(By.id("reg-submit-button")).click();
			
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h2[@class='heading']")));
			boolean isDisplayed=driver.findElement(By.xpath("//h2[@class='heading']")).isDisplayed();
			
			if(isDisplayed==true){
				System.out.println("registration successfull");
			}else{
				System.out.println("registration unsuccessfull");
			}
			
		}
		
		
}
	
}
