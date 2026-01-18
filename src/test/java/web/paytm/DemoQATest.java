package web.paytm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.pageobject.DemoqaHome;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoQATest {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless=new"); options.addArguments("--no-sandbox");
		 * options.addArguments("--disable-dev-shm-usage");
		 * options.addArguments("--disable-gpu");
		 * options.addArguments("--window-size=1920,1080");
		 */

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		System.out.println(driver.getTitle());
	}
	
	
	@Test
	public void verifyLinks() {
		DemoqaHome dm = new DemoqaHome(driver);
		dm.VerifyAllLinks();
		
	}
}
