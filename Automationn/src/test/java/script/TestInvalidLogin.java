package script;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genric.BaseTest;
import genric.Utility;
import page.LoginPage;

public class TestInvalidLogin extends BaseTest {

	@Test
	public void RunByInvalidData() throws IOException {
		String un1 = Utility.getData(testData, "Sheet1", 2, 0);
		String pwd1 = Utility.getData(testData, "Sheet1", 2, 1);

		LoginPage InValidloginpage = new LoginPage(driver);
		InValidloginpage.setUserName(un1);
		InValidloginpage.setPassword(pwd1);
		InValidloginpage.clickBTN();
	
			
		if(InValidloginpage.errMsgIsDisplayed(wait)
				) {
			Reporter.log("error msg is displayed");
		}
		else
		{
			Reporter.log("error msg is not displayed");
		}
		}

}

