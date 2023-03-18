package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class WebTableHandling_singleCellReading_Eg2 {
	WebDriver driver;
	
  @Test
  public void f() {
	  //static webtable- no.of rows and columns fixed
	  //dynamic webtable
	  List<WebElement> column=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));  //absolute xpath of column
	  int sizeC=column.size();
	  System.out.println(sizeC);
	  
	  List<WebElement> row=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr")); //absolute xpath of a row
	  int sizeR=row.size();
	  System.out.println(sizeR);
	  
	  //for(int i=0;i<sizeR;i++) {
		  List<WebElement> currentRow=row.get(2).findElements(By.tagName("td")); // getting the contents of the ith row in the List currentRow
		 // for(int j=0;j<sizeC;j++) {
			  String s=currentRow.get(2).getText();	//getting each(jth) coulmn value from currentRow
			  System.out.print(s);
		 // }
		  System.out.println();
		  System.out.println(".........................................");
	  //}
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();    //add dependency WebDriverManager
	  driver=new EdgeDriver();
	  driver.get("https://demo.guru99.com/test/web-table-element.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
