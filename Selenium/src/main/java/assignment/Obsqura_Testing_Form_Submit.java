package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Obsqura_Testing_Form_Submit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\\\Drivers\\\\New\\\\edgedriver_win64\\\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://selenium.obsqurazone.com/form-submit.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[class='form-control']:nth-child(2)")).sendKeys("Liya"); //using indexing in cssSelector
		driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys("Joseph");            //using basic xpath
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("liyajoseph");        //using parent-child
		driver.findElement(By.xpath("//input[contains(@type,'text') and @placeholder='City']")).sendKeys("India");                  //contains() and AND
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'State') or @id='validationCustom04' ]")).sendKeys("Kerala");  //starts-with() and OR
		driver.findElement(By.cssSelector("input#validationCustom05")).sendKeys("2355657");              //cssSelector - #id
		driver.findElement(By.cssSelector("input[class='form-check-input']")).click();                   //cssSelector tag[attribute='value']
		WebElement submit=driver.findElement(By.xpath("//button[text()='Submit form']"));				//using text()
		submit.click();
		WebElement msg=driver.findElement(By.id("message-one"));
		System.out.println(msg.getText());
	}

}
