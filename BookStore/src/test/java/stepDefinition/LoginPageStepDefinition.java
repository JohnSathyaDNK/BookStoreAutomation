package stepDefinition;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;


public class LoginPageStepDefinition extends BasePage {
	
	LoginPage loginPage=new LoginPage();
	
	@Given("User is on demoQA page")
    public void pageTitleValidation() {		
        // Verify login page text
        String loginPageTitle = loginPage.validateLoginPageTitle();
        Assert.assertTrue(loginPageTitle.contains("ToolsQA"));
 
    }
	
	@Given("User enters the credentials and be able to login successfully")
    public void enterCredentials() throws InterruptedException {
        // Verify login page text
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
 
    }
	
	@When("User logsout")
	public void logOut(){
		
		driver.quit();	
	}
	
	@After
	public void teardown(){
		driver.quit();	
	}
}
