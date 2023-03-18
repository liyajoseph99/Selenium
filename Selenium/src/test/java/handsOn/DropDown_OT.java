package handsOn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class DropDown_OT {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  WebElement clr=driver.findElement(By.id("single-input-field"));
	  Select obj=new Select(clr);
	  obj.selectByIndex(1);
	  obj.selectByValue("Red");
	  obj.selectByVisibleText("Green");
	  
	  WebElement clrs=driver.findElement(By.id("multi-select-field"));
	  Select obj1=new Select(clrs);
	  obj1.selectByValue("Red");
	  obj1.selectByValue("Yellow");
	 // System.out.println(obj1.getAllSelectedOptions());
	 // System.out.println(obj1.getFirstSelectedOption());
	  obj1.deselectAll();
	  Boolean flag=obj1.isMultiple();
	  System.out.println(flag);
	  
	 // List<WebElement> clrss=driver.findElements(By.id("multi-select-field"));
	 // clrss.get(0).click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/select-input.php");
	  driver.manage().window().maximize();  
  }

  @AfterTest
  public void afterTest() {
	  
  }

}
