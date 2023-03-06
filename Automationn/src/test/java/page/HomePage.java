package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HomePage {

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement logout;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyHomeIsDisplayed(WebDriverWait wait) {
		try {
			wait.until(ExpectedConditions.visibilityOf(logout));
			Reporter.log("logout link is displayed", true);
		} catch (Exception e) {
			Reporter.log("Logout link is not displayed", true);
		}
		return false;
	}
}
