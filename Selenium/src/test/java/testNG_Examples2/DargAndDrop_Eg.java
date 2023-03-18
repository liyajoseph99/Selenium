package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class DargAndDrop_Eg {
	WebDriver driver;
	
  @Test
  public void f() {
	  WebElement source=driver.findElement(By.xpath("//a[text()=' BANK ']"));
	  WebElement destination=driver.findElement(By.id("bank"));
	  Actions obj=new Actions(driver);
	  obj.dragAndDrop(source, destination);
	  
	  WebElement source1=driver.findElement(By.xpath("//a[text()=' 5000 ']"));
	  WebElement destination1=driver.findElement(By.id("amt7"));
	  obj.dragAndDrop(source1, destination1);
	  
	  WebElement source2=driver.findElement(By.xpath("//a[text()=' SALES ']"));
	  WebElement destination2=driver.findElement(By.id("loan"));
	  obj.dragAndDrop(source2, destination2);
	  
	  obj.perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/drag_drop.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
