package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;

public class TestUtil extends BasePage {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public boolean waitForElementToBeClickableBool(WebElement attributeValue, Duration waitTime) {	
		boolean flag = false;
		try{
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(attributeValue));
			flag=true;
			return flag;

		}catch(Exception Ex){
			return flag;
		}
	}

	public boolean waitForElementDisplayedBool(By attributeValue, Duration waitTime) {	
		boolean flag = false;
		try{
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.presenceOfElementLocated(attributeValue));
			flag=true;
			return flag;

		}catch(Exception Ex){
			return flag;
		}
	}

	public boolean waitForElementVisibleBool(WebElement attributeValue, Duration waitTime) {	
		boolean flag = false;
		try{
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.visibilityOf(attributeValue));
			flag=true;
			return flag;

		}catch(Exception Ex){
			return flag;
		}
	}

	public boolean waitForAlertVisibleBool(Duration waitTime) {	
		boolean flag = false;
		try{
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.alertIsPresent());
			flag=true;
			return flag;

		}catch(Exception Ex){
			return flag;
		}
	}

	public boolean waitForElementInvisible(WebElement attributeValue, Duration waitTime) {	
		boolean flag = false;
		try{
			new WebDriverWait(driver, waitTime).ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.invisibilityOf(attributeValue));
			flag=true;
			return flag;

		}catch(Exception Ex){
			return flag;
		}
	}

	public void setTextBoxValue(WebElement ele,String textValue) {

		if(waitForElementVisibleBool(ele,Duration.ofSeconds(20))) {
			ele.clear();
			ele.click();		
			ele.sendKeys(textValue);
		}			
	}

	public void clickButton(WebElement ele) throws InterruptedException {

		if(waitForElementToBeClickableBool(ele,Duration.ofSeconds(20))) {
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", ele);

			//Thread.sleep(3000);
			ele.click();
		}			
	}

	public void clickLinkByValue(WebElement ele,String linkValue) {

		if(waitForElementVisibleBool(ele,Duration.ofSeconds(20))) {
			if(ele.getText().equals(linkValue)) {
				ele.click();
			}
		}			
	}
	
	public void clickLinkByContainsValue(WebElement ele,String linkValue) {

		if(waitForElementVisibleBool(ele,Duration.ofSeconds(20))) {
			if(ele.getText().contains(linkValue)) {
				ele.click();
			}
		}			
	}


	public void clickLinkByValueList(List<WebElement> ele,String linkValue) {
		for(int i=0;i<ele.size();i++) {
			if(waitForElementVisibleBool(ele.get(i),Duration.ofSeconds(20))) {
				if(ele.get(i).getText().equals(linkValue)) {
					js.executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					ele.get(i).click();
				}
			}
		}
					
	}
	
	public WebElement returnEleBooKName(List<WebElement> ele,String linkValue) {
		for(int i=0;i<ele.size()-1;i++) {
			if(waitForElementVisibleBool(ele.get(i),Duration.ofSeconds(20))) {
				if(ele.get(i).getText().equals(linkValue)) {
					//js.executeScript("arguments[0].scrollIntoView(true);", ele.get(i));
					return ele.get(i);
				}
			}
		}
		return null;				
	}
	
	
	
	
	public void clickButtonJS(WebElement ele) {		
		//js = (JavascriptExecutor)driver;

		if(waitForElementToBeClickableBool(ele,Duration.ofSeconds(20))) {
			js.executeScript("arguments[0].click();", ele);
		}
		//js.executeScript("document.getElementById("+valueID+").click()");	
	}		


	public void alertAccept() {		

		if(waitForAlertVisibleBool(Duration.ofSeconds(10))) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText()); 
			alert.accept();
		}

	}


}
