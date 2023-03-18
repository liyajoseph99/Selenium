package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.Sheet;
import jxl.Cell;
public class ParameterizationExcel_Eg {
	WebDriver driver;
		
  @Test(dataProvider = "dp")  //data provider name is dp(), dp() contains the values from object[][]
  public void login(String username,String password) {			//passing the values from object[][],@Test will run until all the data from object[][] is read
	  WebElement user=driver.findElement(By.xpath("//input[@name='userName']"));
	  user.sendKeys(username);
	  WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));
	  pass.sendKeys(password);
	  WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
	  submit.click();
	  
	  WebElement login=driver.findElement(By.xpath("//td/h3"));
	  String actual=login.getText();
	  String expected="Login Successfully";
	  Assert.assertEquals(actual, expected, "Invalid usrname or password");
  }
  
  //datadriven framework - reading data from excel
  
  @DataProvider
  public Object[][] dp() throws IOException, BiffException {		                   //import jxl,add dependency-org.apache.servicemix.bundles.jexcelapi,poi-ooxml-schemas,poi-scratchpad
	 FileInputStream f=new FileInputStream("C:\\Users\\ASUS\\Desktop\\testdata.xls");  //save as Excel 97-2003 worksheet , reading the file from the path
	 Workbook w=Workbook.getWorkbook(f);  				//getting the workbook from the file
	 Sheet s=w.getSheet("Sheet1");	  	  				//getting sheet from the workbook
	 int r=s.getRows();									//getting rows and columns
	 int c=s.getColumns();
	 String input[][]=new String[r][c];					//2d array input[][] with same size as excel.
	 for(int i=0;i<r;i++) {								//reading rows and columns
		 for(int j=0;j<c;j++) {
			 Cell cc=s.getCell(j, i);
			 input[i][j]=cc.getContents();
		 }		 
	 }
	 return input;										//returning input[][] to object[][] in dp()
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
