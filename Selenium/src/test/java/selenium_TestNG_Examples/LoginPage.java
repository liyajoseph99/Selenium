package selenium_TestNG_Examples;

import org.testng.annotations.Test;

public class LoginPage {
  @Test(groups= {"smoke"})
  public void email() {
	  System.out.println("email");
  }
  
  @Test
  public void phoneNumber() {
	  System.out.println("phoneNumber"); 
  }
}
