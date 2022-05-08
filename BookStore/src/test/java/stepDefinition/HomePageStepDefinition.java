package stepDefinition;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import base.BasePage;
import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;


public class HomePageStepDefinition extends BasePage {
	
	HomePage homePage=new HomePage();
	
	@Given("User clicks on goToBookStore")
    public void goToBookStore() throws InterruptedException {		
		homePage.clickGoToBookStore();
 
    }
		
}
