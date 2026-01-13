package web.paytm;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Homepage {
	
	
	WebDriver driver;
	
	@Test
	public void setUp() throws FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		System.out.println(driver.getTitle());
	}

}
