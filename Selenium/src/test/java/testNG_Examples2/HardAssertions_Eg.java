package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HardAssertions_Eg {
	
	WebDriver driver;
	
  @Test
  public void validateTitle() {
	  String actualtitle=driver.getTitle();
	  Assert.assertEquals(actualtitle, "Obsqura");
	  
	  String actualUrl=driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, "https://selenium.obsqurazone.com/index.php");
	  
	  Assert.assertNotNull(driver);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
