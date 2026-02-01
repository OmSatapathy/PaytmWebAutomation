package web.paytm;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.Dthrechange;

public class ScreenshootTest {
	
	WebDriver driver;
	
	@Test
	public void verifyScrrenShot() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		
		WebElement ele =driver.findElement(By.xpath("(//li[@class='_2Szju'])[1]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("C:\\Users\\pc\\eclipse-workspace\\paytm\\screenshot\\1.png"));
		
		
	}
	
	@Test(dependsOnMethods = {"verifyScrrenShot"})
	public void verifyRecharge() {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		try {
			Dthrechange dth= new Dthrechange(driver);
			dth.verifyRechagePge();
			FileUtils.copyFile(fs, new File("C:\\Users\\pc\\eclipse-workspace\\paytm\\screenshot\\22.png"));
			
			dth.allItemas();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}
