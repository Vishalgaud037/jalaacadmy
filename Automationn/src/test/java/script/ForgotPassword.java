package script;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genric.BaseTest;
import page.LoginPage;

public class ForgotPassword extends BaseTest {

	@Test
	public void clickFrtPass()
{
		
		LoginPage login= new LoginPage(driver);
		login.clickForgotPass();
		
		if(driver.getTitle().equals("Forgot your password?")) {
			
			//Assert.assertEquals(true, driver);
		
			Reporter.log("pass",true);
		}
		else
			Reporter.log("fail");
	}
}
