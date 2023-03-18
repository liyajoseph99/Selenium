package handsOn;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class ImplicitWait {
	
	WebDriver driver;
	
  @Test
  public void f()  {
	 	  
	  WebElement start=driver.findElement(By.cssSelector("[id='start'] button"));
	  start.click();
	  WebElement helloworld=driver.findElement(By.cssSelector("[id='finish'] h4"));
	  
	  //Thread.sleep(5000);
	  System.out.println(helloworld.isDisplayed());
	  System.out.println(helloworld.getText());
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
