package pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Insurance {

	WebDriver driver;
	private By inputfiled = By.xpath("//input[@type='text']");
	private By proceedBTN = By.xpath("//*[contains(text(),'Proceed to Pay')]");
	private By insuranceCompany = By.xpath("//div[@class='_3xI1']//ul//li");
	
	private By policyNumber= By.xpath("//div[@class='_3_cL ']//input[@type='text']");
	

	public Insurance(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void submitpayment() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(proceedBTN));
		driver.findElement(inputfiled).click();
		
		List<WebElement> allEle =driver.findElements(insuranceCompany);
		
		for(WebElement singlename : allEle) {
			System.out.println(singlename.getText());
			if(singlename.getText().equalsIgnoreCase("SBI Life Insurance")) {
				singlename.click();
				break;
				
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(policyNumber));
		
		driver.findElement(policyNumber).sendKeys("7465455444");
	}
	
	public void selectDOB() {

	    // Month
	    WebElement monthDropdown = driver.findElement(By.id("dropdown-month"));
	    Select month = new Select(monthDropdown);
	    month.selectByVisibleText("Apr");

	    // Day
	    WebElement dayDropdown = driver.findElement(By.id("dropdown-day"));
	    Select day = new Select(dayDropdown);
	    day.selectByIndex(9);

	    // Year
	    WebElement yearDropdown = driver.findElement(By.id("dropdown-year"));
	    Select year = new Select(yearDropdown);
	    year.selectByVisibleText("2023");
	}


}
