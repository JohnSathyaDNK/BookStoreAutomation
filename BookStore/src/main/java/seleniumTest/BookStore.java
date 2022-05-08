package seleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BookStore {

		// TODO Auto-generated method stub

			private static WebDriver driver;
			
			public static void main(String[] args) throws InterruptedException {
				
				ChromeOptions chromeOptions = new ChromeOptions();
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver(chromeOptions);
				
				// Navigate to the demoqa website
				driver.get("https://demoqa.com/");
				
				
				driver.manage().window().maximize();
				driver.quit();
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//				driver.navigate().to("https://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
//
//			
//				List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
//				items.get(0).click();
//				
//				WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
//				addToCart.click();
	}

}
