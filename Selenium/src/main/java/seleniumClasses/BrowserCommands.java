package seleniumClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserCommands {

	public static void main(String[] args) {
		
		Boolean flag=false;
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.co.in");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		//System.out.println(driver.getPageSource());
		//driver.close();
		//driver.quit();
		
		String expected=driver.getTitle();
		String actual  ="Google";
		if(expected.equalsIgnoreCase(actual)) {
			flag=true;
		}
		
		if(flag==true) {
			System.out.println("Title matches");
		}
		else {
			System.out.println("Title mismatches");
		}
	}

}
