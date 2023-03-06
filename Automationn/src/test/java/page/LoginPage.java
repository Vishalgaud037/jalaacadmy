package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPage {

	@FindBy(id="UserName")
	private WebElement unTB;
	
	@FindBy(name="Password")
	private WebElement pwTB;
	
	@FindBy(id="btnLogin")
	private WebElement BTNLogin;
	
	@FindBy(xpath="//div[text()='Invalid Email address or Password.']")
	private WebElement errMsg;
	
	@FindBy(xpath="//a[@href='/Account/ForgotPassword']")
	private WebElement ForgotPassword;
	

	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String un)
	{
		unTB.sendKeys(un);
	}
	public void setPassword(String pwd)
	{
		pwTB.sendKeys(pwd);
	}
	public void clickBTN()
	{
		BTNLogin.click();
	}
	
	public void clickForgotPass() {
		ForgotPassword.click();
	}
	public boolean errMsgIsDisplayed(WebDriverWait wait){
		
		try {
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("error msg is displayed",true);
			
		} catch (Exception e) {
	Reporter.log("error msg is not displayed",true);
		}
		return false;
	}
}
