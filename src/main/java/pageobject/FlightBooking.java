package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(ticketBooking)).build().perform();
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
