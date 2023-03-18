package seleniumClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Xpath_Axes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://demo.guru99.com/test/newtours/reservation.php");
		driver.manage().window().maximize();
		//self,child,parent,following-sibling,following,preceding-sibling,preceding -departing from,on(date)
		
		//https://selenium.obsqurazone.com/select-input.php- ancestor,descendant
		
	}

}
