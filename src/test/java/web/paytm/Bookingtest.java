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
import pageobject.Homepage;
import pageobject.PaymentService;
import pageobject.PaymentService;

public class Bookingtest {

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
	}

	@Test
	public void flightBook() {
		FlightBooking fb = new FlightBooking(driver);
		fb.ticketBooking();

	}

	@Test
	public void verifyFooter() {
		Homepage hm = new Homepage(driver);
		hm.verifyFooter();
	}

	@Test
	public void paymentServicetest() {
		PaymentService pm = new PaymentService(driver);
		pm.mouseOverPaymentServices();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
