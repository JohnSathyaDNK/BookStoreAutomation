package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import org.junit.Assert;

public class BookStorePage extends BasePage{

	@FindBy(xpath="//*[@id=\"searchBox\"]")
	WebElement txtSearchBox;

	@FindBy(xpath="//div[@role='row' and @class='rt-tr -odd']")
	WebElement lblSearchItem;

	@FindBy(xpath="//span[@class='mr-2']/a")
	WebElement lnkBookName;
	
	@FindBy(xpath="//span[@class='mr-2']/a")
	List<WebElement> lnkBookNames;

	@FindBy(xpath="//*[text()='Add To Your Collection']")
	WebElement btnAddToCollection;

	@FindBy(xpath="//*[text()='Back To Book Store']")
	WebElement btnBackToBookStore;
	
	@FindBy(xpath="//span[text()='Profile']")
	WebElement lnkProfile;
	
	@FindBy(xpath="(//button[text()='Delete All Books'])[1]")
	WebElement btnDeleteAllBooks;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement btnOkPopUp;
	
	public BookStorePage(){
		System.out.println("BookStorePage");
		PageFactory.initElements(driver, this);		
	}

	public void searchAndClick(String str){
		tools.setTextBoxValue(txtSearchBox, str);
		tools.clickLinkByContainsValue(lnkBookName,str);
		tools.alertAccept();
	}

	public void addToCollection() throws InterruptedException{
		tools.clickButton(btnAddToCollection);	
		tools.alertAccept();
	}

	public void clickBookName(String bookName) throws InterruptedException{
		tools.clickLinkByValueList(lnkBookNames,bookName);
		addToCollection();
		tools.clickButton(btnBackToBookStore);
	}
	
	public void clickProfile() throws InterruptedException{
		tools.clickButton(lnkProfile);
	}
	
	public void verifyBookList() throws InterruptedException{				
		Assert.assertFalse("Expected 4 books to be added but found only "+lnkBookNames.size(), lnkBookNames.size()!=4);
	}
	
	public void clickDeleteAllBooks() throws InterruptedException{
		if(lnkBookNames.size()>1) {
			tools.clickButtonJS(btnDeleteAllBooks);
			clickOKPopUp();
			tools.alertAccept();
		}	
	}
	
	public void clickOKPopUp() throws InterruptedException{
		tools.clickButtonJS(btnOkPopUp);
	}
}
