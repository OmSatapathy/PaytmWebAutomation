package demo.pageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoqaAlert {
	
	 public DemoqaAlert(WebDriver driver) {
	        this.driver = driver;
	    }
	
	 WebDriver driver;
	
	private By alertLink = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"); 
	private By allAlertLink = By.xpath("//span[@class='text' and contains(text(),'Alerts')]");
	
	private By firstAlert = By.xpath("//button[@id='alertButton' and contains(text(),'Click me')]");
	private By secondAlert = By.xpath("//button[@id='timerAlertButton' and contains(text(),'Click me')]");
	
	private By confirmButton = By.xpath("//button[@id='confirmButton' and contains(text(),'Click me')]");
	



	public  void alertOperation() {
		driver.findElement(alertLink).click();
		driver.findElement(allAlertLink).click();
		driver.findElement(firstAlert).click();
		
		
		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
		driver.findElement(confirmButton).click();
	    alt = driver.switchTo().alert();
		System.out.println(alt.getText());
		alt.accept();
		
	}
	

}
