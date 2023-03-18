package seleniumClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsObsqura {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
		
		WebElement msg=driver.findElement(By.id("single-input-field"));
		msg.sendKeys("Hello");
		
		WebElement msgText=driver.findElement(By.id("message-one"));
		System.out.println(msgText.getText());
		
		WebElement id=driver.findElement(By.id("button-one"));
		id.click();
		
		WebElement valueA=driver.findElement(By.id("value-a"));
		valueA.sendKeys("10");
		
		WebElement valueB=driver.findElement(By.id("value-b"));
		valueB.sendKeys("20");
		
		WebElement total=driver.findElement(By.id("button-two"));
		total.click();
	}

}
