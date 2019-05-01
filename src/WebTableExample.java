import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		
		driver.get("https://money.rediff.com/indices?src=moneyhome_bseIndices_more");
		
		driver.findElement(By.id("showMoreLess")).click();
		
		//WebElement tableElement=driver.findElement(By.xpath("//table[@id='dataTable']//tbody"));
		
		List<WebElement> TableRowsList=driver.findElements(By.xpath("//table[@id='dataTable']//tbody//tr"));
		
		
		System.out.println(TableRowsList.size());
		
		for(int i=0;i<TableRowsList.size();i++){
			
			List<WebElement>  tableColumnList=TableRowsList.get(i).findElements(By.tagName("td"));
			
			String indices=tableColumnList.get(0).findElement(By.tagName("a")).getText();
			
			if(indices.equals("S&P BSE MidCap")){
				String lastTraded=tableColumnList.get(2).getText();
				
				if(lastTraded.equals("15382.56")){
					System.out.println("Last traded value is matching as expected");
				}else{
					System.out.println("Last traded value is not matching as expected");
				}
				
				break;
			}
			
		}
		

	}

}
