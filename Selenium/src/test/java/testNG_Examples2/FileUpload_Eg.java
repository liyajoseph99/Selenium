package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class FileUpload_Eg {
	WebDriver driver;
	
  @Test
  public void imageUpload() {
	  WebElement chooseImage=driver.findElement(By.id("uploadPicture"));
	  chooseImage.sendKeys("C:\\Users\\ASUS\\Downloads\\sampleFile (1).jpeg");  //shift-rightclick-copy as path
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demoqa.com/automation-practice-form");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
