package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utilities.TestUtil;

public class LoginPage extends BasePage{
	//TestUtil tools = new TestUtil();
	
	@FindBy(id="userName")
	WebElement txtUsername;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login")
	WebElement Btnlogin;
	
	//Initializing the Page Objects:
	public LoginPage(){
		super();
		initialization();
		PageFactory.initElements(driver, this);
	}
	

	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		tools.setTextBoxValue(txtUsername, un);
		tools.setTextBoxValue(txtPassword, pwd);
		tools.clickButton(Btnlogin);
		    	
		return new HomePage();
	}
	
}
