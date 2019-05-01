import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

public class ReadExcel {

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
			
			for(int j=0;j<columnCount;j++){
				
				Cell cell=row.getCell(j);
				cell.setCellType(org.apache.poi.ss.usermodel.CellType.STRING);
				System.out.println(cell.getStringCellValue());
			}
			
			
			
		}
		
		
		
		
		
		
		
	}

}
