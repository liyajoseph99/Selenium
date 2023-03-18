package testNG_Examples2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class WindowHandle_Eg {
	WebDriver driver;
  @Test
  public void f() throws AWTException, InterruptedException {
	  Robot r=new Robot();					//robot class.keyboard actions.
	  r.keyPress(KeyEvent.VK_CONTROL);		//cntrl+T new Tab
	  r.keyPress(KeyEvent.VK_T);
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_T);
	  Thread.sleep(2000);
	  
	  String p=driver.getWindowHandle();      //parent-windowhandle id
	  System.out.println(p);
	  Set<String>l=driver.getWindowHandles(); //opened windows-handle id
	  Iterator<String>i=l.iterator();		  //iterating the list using iterator()
	  while(i.hasNext()) {					  //checking fr the next windowhandle id
		  String c=i.next();				  //the next window handle id in c
		  System.out.println(c);
		  if(!(p.equals(c))) {				  //if parent-window handle id != child-window handle id, then switch to child window
			  driver.switchTo().window(c);		
			  driver.get("https://mvnrepository.com/");
			  Thread.sleep(2000);
		  }
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();    //add dependency WebDriverManager
	  driver=new EdgeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
