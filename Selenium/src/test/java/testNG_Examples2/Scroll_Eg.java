package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class Scroll_Eg {
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,1000)");		//scroll y-axis down
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(0,-1000)");		//scroll y-axis up
	  Thread.sleep(2000);
	  js.executeScript("window.scrollBy(1000,0)");		//scroll x-axis
	  Thread.sleep(2000);
	  WebElement vbscript=driver.findElement(By.xpath("//a[text()='VBScript']"));  //scroll until the webelement is found
	  js.executeScript("arguments[0].scrollIntoView()", vbscript);
  }
  
  @BeforeTest
  public void beforeTest() {
	 // System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  WebDriverManager.edgedriver().setup();    //add dependency WebDriverManager
	  driver=new EdgeDriver();
	  driver.get("http://demo.guru99.com/test/guru99home/scrolling.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
