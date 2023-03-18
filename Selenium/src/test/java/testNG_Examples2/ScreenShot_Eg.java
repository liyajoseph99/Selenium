package testNG_Examples2;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ScreenShot_Eg {
	WebDriver driver;
	
  @Test
  public void screenshotMethod() {
	  driver.findElement(By.id("username")).sendKeys("admin");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  WebElement submit=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	  submit.click();
	  WebElement endTour=driver.findElement(By.xpath("//button[text()='End tour']"));
      WebElement userManagement=driver.findElement(By.xpath("//span[text()='User Management']"));		
      WebElement users=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
      System.out.println(endTour.getTagName());
	  endTour.click();	
	  System.out.println(userManagement.getTagName());
	  userManagement.click();
  }
  
  @AfterMethod
  public void afterMethod(ITestResult r) throws IOException {  //ITestResult pull cheyyan- get the details of @Test used before
	  if(ITestResult.SUCCESS==r.getStatus()) {
		//checking the status of the @Test is same as ITestResult.SUCCESS or not.
		  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(f, new File("C:\\Users\\ASUS\\Desktop\\screenshots\\"+r.getName()+".jpeg"));
	  }
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://qalegend.com/billing/public/login");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
