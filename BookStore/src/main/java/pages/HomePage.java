package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//*[@id='gotoStore']")
	WebElement btnGoToStore;
	
	@FindBy(id="searchBox")
	WebElement txtSearchBox;
	
	@FindBy(xpath="//div[@role='row' and @class='rt-tr -odd']")
	WebElement lblSearchItem;
	
	@FindBy(xpath="//span[@class='mr-2']/a")
	WebElement lnkBookName;
	
	@FindBy(id="addNewRecordButton")
	WebElement btnAddToCollection;
	
	
	public HomePage(){
		System.out.println("HomePage");
	}
	
	public void clickGoToBookStore() throws InterruptedException{
		
		js = (JavascriptExecutor)driver;	
		js.executeScript("document.getElementById('gotoStore').click()");
			
	}
}
