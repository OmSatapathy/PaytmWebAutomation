package web.paytm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import demo.pageobject.DemoqaAlert;

public class DemoA {
	
	WebDriver driver;
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browser) {
		driver =   DriverFactory.getDriver(browser);
		 driver.manage().window().maximize();
		 driver.get("https://demoqa.com/");
		
	}
	
	
	
	@Test
	public void verifyAlerts() {
		DemoqaAlert obj = new DemoqaAlert(driver);
		obj.alertOperation();
		
	}

}
