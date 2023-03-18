package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;

public class FluentWait_Eg {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  WebElement start=driver.findElement(By.cssSelector("[id='start'] button"));
	  start.click();
	  
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30))		//max. amount of time to wait for the condition-30s
		       .pollingEvery(Duration.ofSeconds(5))		//frequency with which to check the condition - in every 5 sec
		       .ignoring(NoSuchElementException.class);	//ignore the exception while search for the element foo is happening

		   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {	   
		     public WebElement apply(WebDriver driver) {					//method apply returns the webelement , parameter passed is driver
		    	 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){	// searching for the webelement
		    		 return driver.findElement(By.cssSelector("[id='finish'] h4"));		    		 
		    	 }
		    	 else {
		    		 return null;		       
		        }
		     }
		   });
		   
		   System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
