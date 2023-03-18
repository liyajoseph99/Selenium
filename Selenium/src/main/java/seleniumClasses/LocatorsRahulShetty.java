package seleniumClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LocatorsRahulShetty {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.driver", "C:\\Drivers\\New\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("inputUsername"));
		username.sendKeys("rahul");
		WebElement password=driver.findElement(By.name("inputPassword"));
		password.sendKeys("rahul");
		
		WebElement signin=driver.findElement(By.className("signInBtn"));
		signin.click();
		Thread.sleep(2000);
		WebElement error=driver.findElement(By.cssSelector("p.error"));   //tag.class attribute value
		System.out.println(error.getText());
		
		WebElement forgotPassword=driver.findElement(By.linkText("Forgot your password?"));
		forgotPassword.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahul123@gmail.com"); //tag[attribute='value']
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahul.official@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("34325466");     //xpath is selected using index.lease preferred method.
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();                 //cssselector-tagname.classname ..... .classname is also unique here
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();     //parent-xpath/child-tagname
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");   //tagname#id  or #id
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");  //dynamic attribute value
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();  //contains()
	}

}
