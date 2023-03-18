package testNG_Assignments;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class PracticeForm_Scroll {
	
	WebDriver driver;
	
  @Test
  public void f() throws InterruptedException, AWTException {
	  	driver.findElement(By.id("firstName")).sendKeys("Liya");
		driver.findElement(By.id("lastName")).sendKeys("Joseph");
		driver.findElement(By.id("userEmail")).sendKeys("liyajoseph99@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		driver.findElement(By.id("userNumber")).sendKeys("24564658");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		WebElement sub=driver.findElement(By.id("subjectsInput"));
		sub.click();
		sub.sendKeys("Hindi");
		//sub.sendKeys(Keys.TAB);
		Robot r=new Robot();					//robot class.keyboard actions.
		r.keyPress(KeyEvent.VK_TAB);
		
		WebElement hobbies=driver.findElement(By.xpath("//label [@for='hobbies-checkbox-1' and @class='custom-control-label']"));
		hobbies.click();
		WebElement pic=driver.findElement(By.id("uploadPicture"));
		pic.sendKeys("C:\\Users\\ASUS\\Downloads\\sampleFile (1).jpeg"); 
		WebElement addr=driver.findElement(By.id("currentAddress"));
		addr.sendKeys("Test, Sample 01, 007");
		
		js.executeScript("window.scrollBy(0,-500)");
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();    
	  driver=new EdgeDriver();
	  driver.get("https://demoqa.com/automation-practice-form");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
