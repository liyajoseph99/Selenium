package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Alert_Eg {
	
	WebDriver driver;
	
  @Test
  public void alertValidation() throws InterruptedException {
	 WebElement customerId=driver.findElement(By.xpath("//input[@name='cusid']"));
	 customerId.sendKeys("1234");
	 
	 
	 //Thread.sleep(2000);
	 
	 WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	 submit.click();
	 
	 Alert alert=driver.switchTo().alert();   // or direct driver.switchTo().alert().dismiss();
	 //Thread.sleep(2000);
	 alert.dismiss();
	 
	 WebElement reset=driver.findElement(By.xpath("//input[@name='res']"));
	 reset.click();
	 
	 customerId.sendKeys("4567");
	 //Thread.sleep(2000);
	 submit.click();
	 //Thread.sleep(2000);
	 alert.accept();
	 String s=alert.getText();
	 System.out.println(s);
	 alert.accept();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/delete_customer.php");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait
  }
  

  @AfterTest
  public void afterTest() {
  }

}
