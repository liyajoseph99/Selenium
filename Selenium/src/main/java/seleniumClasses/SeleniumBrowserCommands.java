package seleniumClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBrowserCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");  //value,path
		WebDriver driver=new EdgeDriver();
		driver.get("https://selenium.obsqurazone.com/index.php");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.close();
		driver.quit();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\New\\geckodriver-v0.32.0-win64\\geckodriver.exe");
		WebDriver driver2=new FirefoxDriver(); 
		driver2.get("https://www.google.co.in");
		System.out.println(driver2.getTitle());
		driver2.close();
		driver2.quit();*/
		

		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\New\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver1=new ChromeDriver(); 
		driver1.get("https://www.google.co.in");
		System.out.println(driver1.getTitle());
		driver1.close();
		driver1.quit();
		
	}

}
