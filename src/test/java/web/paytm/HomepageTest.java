package web.paytm;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Homepage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HomepageTest {
	
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void verifyRechage() {
		Homepage hm = new Homepage(driver);
		hm.findLinks();
		hm.clickRecharge();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
