package web.paytm;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.FlightBooking;

public class Bookingtest {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws FileNotFoundException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		System.out.println(driver.getTitle());
	}

	@Test
	public void flightBook() {
		FlightBooking fb = new FlightBooking(driver);
		fb.ticketBooking();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
