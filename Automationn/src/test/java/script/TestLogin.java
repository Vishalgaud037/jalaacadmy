package script;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genric.BaseTest;
import genric.Utility;
import page.HomePage;
import page.LoginPage;

public class TestLogin extends BaseTest {
	@Test

	public void RunByValidData() throws IOException {
		// get data from excel file
		String un = Utility.getData(testData, "Sheet1", 1, 0);
		String pwd = Utility.getData(testData, "Sheet1", 1, 1);
		//open the browser
		LoginPage loginPage = new LoginPage(driver);
		//enter username
		loginPage.setUserName(un);
		//enter the password
		loginPage.setPassword(pwd);
		//click on login button
		loginPage.clickBTN();
			// verify that home page is displayed 
		HomePage hPage= new HomePage(driver);
		boolean result = hPage.verifyHomeIsDisplayed(wait);		
		
		
		String title = driver.getTitle();
		Reporter.log("TITLE :" + title,true);
	}
}
