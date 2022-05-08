package stepDefinition;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import base.BasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookStorePage;

import utilities.TestUtil;


public class BookStoreStepDefinition extends BasePage {
	
	BookStorePage bookStore=new BookStorePage();
	
	@When("User searches for the book {string} in book store")
    public void bookSearch(String str) {		
		bookStore.searchAndClick(str);
    }
		
	@When("User clicks on the Add to Collection button")
    public void addToCollection() throws InterruptedException {		
		bookStore.addToCollection();		
    }
		
	@When("User clicks on bookname and adds to collection")
    public void clickBookAddToCollection(io.cucumber.datatable.DataTable arg1) throws InterruptedException {	
		List<String> bookName = arg1.asList();
		for(int i=0;i<bookName.size();i++) {
			System.out.println(bookName.get(i).toString());
			bookStore.clickBookName(bookName.get(i));		
		}	
    }
	
	@Then("User verifies the collection list")
    public void verifyUserCollection() throws InterruptedException {		
		bookStore.clickProfile();	
		bookStore.verifyBookList();
    }
	
	@When("User deletes available books in collection")
    public void deleteUserCollection() throws InterruptedException {		
		bookStore.clickDeleteAllBooks();
    }
}
