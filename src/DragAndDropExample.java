import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDriver bd=new BaseDriver();
		WebDriver driver=bd.getDriver("chrome");
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement sourceElement=driver.findElement(By.id("draggable"));
		
		WebElement destElement=driver.findElement(By.id("droppable"));
		
		int x=driver.findElement(By.id("droppable")).getRect().getX();
		int y=driver.findElement(By.id("droppable")).getRect().getY();
		
		
		
		Actions actions=new Actions(driver);
		
		//actions.dragAndDrop(sourceElement, destElement).build().perform();
		
		actions.dragAndDropBy(sourceElement, x, y).build().perform();
		
		
	
				
	}

}
