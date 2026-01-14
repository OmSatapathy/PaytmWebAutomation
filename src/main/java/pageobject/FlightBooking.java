package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightBooking {
	
	WebDriver driver;
	
	public FlightBooking(WebDriver driver) {
		this.driver=driver;
	}
	
	private By ticketBooking = By.xpath("//li[contains(text(),'Ticket Booking')]");
	private By flightTicket = By.xpath("//a[normalize-space()='Flight Tickets']");
	private By trainTicket = By.xpath("//a[normalize-space()='Train Tickets']");
	private By busTicket = By.xpath("//a[normalize-space()='Bus Tickets']");
	
	
	
	public void ticketBooking() {
		String parentwindow = driver.getWindowHandle();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    WebElement menu = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//li[contains(@class,'_2Szju')][2]")
		        )
		    );
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement((By) menu)).perform();
		driver.findElement(flightTicket).click();
		
		for(String currentwindow: driver.getWindowHandles()) {
			if(!currentwindow.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(currentwindow);
				break;
			}
		}
		
		driver.switchTo().window(parentwindow);
		
		act.moveToElement(driver.findElement(ticketBooking)).build().perform();
		driver.findElement(trainTicket).click();
		
		for(String currentwindow: driver.getWindowHandles()) {
			if(!currentwindow.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(currentwindow);
				break;
			}
		}
		
		driver.switchTo().window(parentwindow);
		
	}
	

}
