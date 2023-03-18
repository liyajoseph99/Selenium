package assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Ass2_NavigationCommands {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("http://www.opesmount.in/grocerystore1");
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}

}
