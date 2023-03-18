package testNG_Assignments;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TitleReadAndValidate_ExcelRead {
	
	WebDriver driver;
	XSSFSheet sheet;
	File newfile;
	FileInputStream file;
	XSSFWorkbook workbook;
	Row row;
    Cell cell;
		
  @Test
  public void validateTitle() throws IOException { 
		
		newfile=new File("C:\\Users\\ASUS\\Desktop\\Obsqura Zone_Selenium+Java\\TestNG TestData\\testdata_validateTitle.xlsx");  //obtaining filepath(filepath:\\)
		file=new FileInputStream(newfile);	//obtains input bytes from a file
		workbook=new XSSFWorkbook(file);	//obtains workbook from the file
		sheet=workbook.getSheet("Sheet1");	//obtains sheet from workbook
		row=sheet.getRow(0);	            //obtains row from the sheet
	    cell=row.getCell(0);	            //obtains cell from the row
	 
	    String expectedResult=cell.getStringCellValue();	//receives the string value of 0th row,0th column (string data.for numeric data different logic)
		String actualResult=driver.getTitle();
	    Assert.assertEquals(actualResult, expectedResult);
	 
	    Assert.assertNotNull(driver);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
	  driver=new EdgeDriver();
	  driver.get("https://selenium.obsqurazone.com/index.php");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
