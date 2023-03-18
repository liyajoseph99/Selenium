package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class ParameterizationXML_Eg {
	
	WebDriver driver;
	
  @Test
  @Parameters({"username1","password1"})
  public void f(String username,String password) {
	  
	  WebElement user=driver.findElement(By.xpath("//input[@name='userName']"));
	  user.sendKeys(username);
	  WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
	  pass.sendKeys(password);
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();    //add dependency WebDriverManager
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
