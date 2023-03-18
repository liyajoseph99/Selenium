package testNG_Examples2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class RadioButton_Dropdown_Eg {
	WebDriver driver;
  @Test
  public void radioButton_checkBox_dropDown() {
	  
	  //RadioButton
	  List<WebElement>obj=driver.findElements(By.xpath("//input[@name='tripType']"));//return all the elements.if radiobuttons having same xpath.
	  obj.get(0).click();
	  
	  //Dropdown
	  
	  WebElement passenger=driver.findElement(By.xpath("//select[@name='passCount']"));
	  Select obj1=new Select(passenger);
	  obj1.selectByIndex(1);                 //index starts from 0
	  
	  WebElement depart=driver.findElement(By.xpath("//select[@name='fromPort']"));
	  Select obj2=new Select(depart);
	  obj2.selectByValue("London");          //value=""
	  
	  WebElement month=driver.findElement(By.xpath("//select[@name='fromMonth']"));
	  Select obj3=new Select(month);
	  obj3.selectByVisibleText("June");      //the value which we see in the dropdown
	  
	  //getting all the dropdown values of month
	  List<WebElement>allData=obj3.getOptions();
	  int a=allData.size();
	  System.out.println("size:"+a);
	  for(int i=0;i<a;i++) {
		  String s=allData.get(i).getText();
		  System.out.println(s);
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/newtours/reservation.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
