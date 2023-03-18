package testNG_Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class RadioButton {
	WebDriver driver;
	
  @Test
  public void validate_RadioButton() {
	  int n,i;
	  boolean flag=false;
	  
	  List<WebElement>obj=driver.findElements(By.xpath("//input[@name='name']"));
	  
	  n=obj.size();
	  for(i=0;i<=n-1;i++) {
		  flag=obj.get(i).isSelected();
		//System.out.println(flag);
	  }
	  
	  Assert.assertFalse(flag); // Verify all the radiobuttons are deselected by default
	  
	  obj.get(1).click();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/ajax.html");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
