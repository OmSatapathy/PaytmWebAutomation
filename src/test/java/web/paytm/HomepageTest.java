package web.paytm;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.Insurance;

import io.github.bonigarcia.wdm.WebDriverManager;


public class HomepageTest {
	
	By inputfiled = By.xpath("//input[@type='text']");
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws FileNotFoundException {
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--headless=new");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--window-size=1920,1080");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		System.out.println(driver.getTitle());
		
		System.out.println("*****");
	}
	
	@Test(priority = 1)
	public void verifyRechage() {
		Homepage hm = new Homepage(driver);
		hm.findLinks();
		hm.clickRecharge();
		hm.windowHandle();
		
	}
	
	
	@Test(priority = 2)
	public void verifyInsurancePage() {
		Insurance obj = new Insurance(driver);
		obj.submitpayment();
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement company =
		            wait.until(ExpectedConditions.visibilityOfElementLocated(inputfiled));
		String actComapnyname =driver.findElement(inputfiled).getDomAttribute("value");
		Assert.assertEquals(actComapnyname, "SBI Life Insurance");
	}
	
	
	@Test(priority = 3)
	public void payInsurancePremium() {
		Insurance obj = new Insurance(driver);
		obj.selectDOB();
		System.out.println("selected!!!");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
