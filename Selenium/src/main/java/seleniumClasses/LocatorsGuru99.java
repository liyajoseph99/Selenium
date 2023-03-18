package seleniumClasses;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsGuru99 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		
		WebElement username=driver.findElement(By.name("userName"));
		username.sendKeys("tutorial");
		System.out.println(username.getTagName());					//tagname of the webelement username
				
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("tutorial");
		System.out.println(password.getAttribute("name"));       //value of name attribute
				
		WebElement submitBtn=driver.findElement(By.name("submit"));
		Point q=submitBtn.getLocation();
		System.out.println("Location of X :"+ q.getX()+ "," +"Location of Y :" +q.getY());
		submitBtn.click();
			
		WebElement success=driver.findElement(By.tagName("h3"));
		System.out.println(success.getText());
		
	/*	WebElement register=driver.findElement(By.linkText("REGISTER"));
		register.click();*/
	}

}
