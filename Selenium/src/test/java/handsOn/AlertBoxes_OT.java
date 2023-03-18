package handsOn;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class AlertBoxes_OT {
	
	WebDriver driver;
	SoftAssert s;
	
  @Test(groups = {"smoke"})
  public void simpleAlertValidations() {
	  
	  driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	  // driver.switchTo().alert().accept();   OR
	  Alert alert=driver.switchTo().alert();
	  alert.accept();
  }
  
  @Test
  public void confirmationAlertValidations() throws InterruptedException {
	  
	  WebElement button=driver.findElement(By.cssSelector("button[class='btn btn-warning']"));
	  button.click();
	  
	  Alert alert=driver.switchTo().alert();
	  Thread.sleep(2000);
	  alert.accept();
	  
	  WebElement msg=driver.findElement(By.id("confirm-demo"));
	  String expected="You pressed OK!";
	  String actual=msg.getText();
	  //Assert.assertEquals(actual, expected);
	  
	  s.assertEquals(actual, expected);
	  
	  button.click();
	  Thread.sleep(2000);
	  alert.dismiss();
	  String expected1="You pressed Cancel!";
	  String actual1=msg.getText();
	  s.assertEquals(actual1, expected1);
	  
	  s.assertAll();  // If we don't use softAssert.assertAll(), then the test case will be marked as passed even in case of assertion failure
  }
  
  @Test
  public void promtAlertValidations() throws InterruptedException {
	  WebElement btn=driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger')]"));
	  btn.click();
	  String text="Test";
	  
	  Thread.sleep(2000);
	  Alert alert=driver.switchTo().alert();
	  alert.sendKeys(text);
	  Thread.sleep(2000);
	  alert.accept();
	  WebElement msg=driver.findElement(By.id("prompt-demo"));
	  String acual=msg.getText();
	  String expected="You have entered "+"'"+text+"'"+" !";
	  //System.out.println(expected);
	  
	  s.assertEquals(acual, expected);
	  s.assertAll();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	  driver.manage().window().maximize();
	  s=new SoftAssert();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
