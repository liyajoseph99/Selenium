package handsOn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CheckBox_OT {
  
	WebDriver driver;
	
  @Test(groups = {"smoke"})
  public void checkBoxValidations() {
	  WebElement chkbx1=driver.findElement(By.xpath("//label[@class='form-check-label']"));
	  chkbx1.click();
	  String expected="Success - Check box is checked";
	  String actual=driver.findElement(By.xpath("//div[contains(@id,'message-one')]")).getText();
	  Assert.assertEquals(actual, expected);
  }
  
  @Test
  public void multiplecheckBoxValidations() {
	WebElement button=driver.findElement(By.cssSelector("input[class='btn btn-primary']")); 
	List<WebElement>chkbx=driver.findElements(By.xpath("//input[@class='check-box-list']"));
	String btnmsg=button.getAttribute("value");

	if(btnmsg.equalsIgnoreCase("Select All")) {
		for(int i=0;i<4;i++) {
			chkbx.get(i).click();
		}
	}
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	  driver.manage().window().maximize();  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
