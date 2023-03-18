package selenium_TestNG_Examples;

import org.testng.annotations.Test;

public class HomePage {
  @Test(groups= {"smoke"})  
  public void start() {
	  System.out.println("test1");
  }
  @Test
  public void home() {
	  System.out.println("test2");
  }
}
