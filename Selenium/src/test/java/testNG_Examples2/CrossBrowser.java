package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser {
	
	WebDriver driver;
	
  @Test
  public void crossbrowser() {	
	
	  driver.findElement(By.linkText("Click Here")).click();
  }
  
  @BeforeTest
  @Parameters({"browser"})
  public void beforeTest(String browser1) {
	  if(browser1.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver();
	  }
	  
	  else if(browser1.equalsIgnoreCase("chrome")) {
		/*  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();	*/	 
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\New\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver(); 
	  }	
	  
	  else if(browser1.equalsIgnoreCase("gecko")) {
		  /*WebDriverManager.firefoxdriver().setup();
		  driver=new FirefoxDriver();*/
		  System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\New\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		  driver=new FirefoxDriver();
	  }	
	  
	  driver.get("http://demo.guru99.com/popup.php");          //login
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(1000);
	  driver.close();
	  Thread.sleep(1000);
	  driver.quit();
  }

}
