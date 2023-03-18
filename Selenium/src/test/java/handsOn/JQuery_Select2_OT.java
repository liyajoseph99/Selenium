package handsOn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class JQuery_Select2_OT {
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  WebElement slctbx=driver.findElement(By.xpath("//span[@class='select2-selection__arrow']"));
	  slctbx.click();
	  driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Hawaii");
	  Actions obj=new Actions(driver);
	  Thread.sleep(2000);
	  obj.keyDown(Keys.ENTER);
	  
	  Thread.sleep(2000);
	  WebElement slctbx2=driver.findElement(By.xpath("//span[@class='select2-selection select2-selection--multiple']"));
	  slctbx2.sendKeys("Hawaii");
	  obj.keyDown(Keys.ENTER);
	  Thread.sleep(2000);
	  slctbx2.sendKeys("Mississippi");
	  obj.keyDown(Keys.ENTER);
	  
	  System.out.println(slctbx.getText());
	  System.out.println(slctbx2.getText());
	  
	  obj.perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/jquery-select.php");
	  driver.manage().window().maximize();  
  }

  @AfterTest
  public void afterTest() {
  }

}
