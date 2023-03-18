package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ass1_BrowserCommands {

	public static void main(String[] args) {
		
		boolean flag=false;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\New\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(); 
		driver.get("http://www.opesmount.in/grocerystore1");	
			
		//**** Verify the url of the page    ****//
		
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="http://www.opesmount.in/grocerystore1";
		
		if(actualUrl.equalsIgnoreCase(expectedUrl)) {
			flag=true;
		}
		if(flag==true) {
			System.out.println("The url of the page is matched");
		}
		else {
			System.out.println("The url of the page is not matched");
		}
	}

}
