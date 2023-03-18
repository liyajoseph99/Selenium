package testNG_Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class ActionClass {
	
	WebDriver driver;
	
  @Test
  public void assignment_actionclass() throws InterruptedException {
	
	/* WebElement support=driver.findElement(By.xpath("//a[text()='Support']"));
	  Actions act=new Actions(driver);
	  act.moveToElement(support);
	 
	  Thread.sleep(2000);
	  WebElement learningCenter=driver.findElement(By.xpath("//a[text()='Learning Center']"));
	  act.moveToElement(learningCenter).click();
	  Thread.sleep(2000);
	  act.perform();
	  
	 driver.navigate().to("http://jqueryui.com/droppable/");
	 System.out.println(driver.getTitle());*/
	  
	 // Thread.sleep(2000);
	  Actions act=new Actions(driver);
	  
	 // driver.switchTo().frame(0);
	  WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));  //explicit wait
	  wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));     //iframe handling
			  
	  WebElement source=driver.findElement(By.cssSelector("div[id='draggable']"));
	  WebElement destination=driver.findElement(By.cssSelector("div[id='droppable']"));
	  act.dragAndDrop(source, destination);
	  act.perform();
		  
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("http://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
