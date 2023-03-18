package handsOn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class IFrame_RahulShetty {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement iframe=driver.findElement(By.id("courses-iframe"));
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
	  WebElement login=driver.findElement(By.xpath("//a[@class='theme-btn register-btn']"));
	  login.click();
  }
  
  @AfterMethod
  public void afterMethod(ITestResult r) throws IOException {  						//ITestResult pull cheyyan- get the details of @Test used before
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
	  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
