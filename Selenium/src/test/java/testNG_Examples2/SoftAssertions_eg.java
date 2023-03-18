package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class SoftAssertions_eg {
	
	WebDriver driver;
	
  @Test
  public void validateTitleUrl() {
	  
	  SoftAssert s=new SoftAssert();
	  
	  String actualResult=driver.getTitle();
	  s.assertEquals(actualResult, "Obsqura ");
	 
	  System.out.println("line after assertion failure");
	  
	  String actualUrl=driver.getCurrentUrl();
	  s.assertEquals(actualUrl, "https://selenium.obsqurazone.com/index.php");
	  
	  s.assertNotNull(driver);
	  
	  s.assertAll(); // If we don't use softAssert.assertAll(), then the test case will be marked as passed even in case of assertion failure
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\New\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver(); 
	  driver.get("https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
