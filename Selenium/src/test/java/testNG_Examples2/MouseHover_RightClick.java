package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class MouseHover_RightClick {
	WebDriver driver;
  @Test
  public void f() {
	  WebElement home=driver.findElement(By.xpath("//a[text()='Home']"));
	  WebElement flights=driver.findElement(By.xpath("//a[text()='Flights']"));
	  WebElement hotels=driver.findElement(By.xpath("//a[text()='Hotels']"));
	  
	  Actions obj=new Actions(driver);
	  obj.moveToElement(home).moveToElement(flights).moveToElement(hotels);
	  obj.contextClick(home);
	  
	  WebElement username=driver.findElement(By.xpath("//input[@name='userName']"));
	  obj.doubleClick(username);
	  
	  obj.perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
