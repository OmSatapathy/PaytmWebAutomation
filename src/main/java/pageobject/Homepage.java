package pageobject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	private By header = By.xpath("//li[@class='_2Szju']");
	private By recharge = By.xpath("//span[contains(text(),'View All Products')]");
	private By allRechageLinks = By.xpath("//div[@class='_1eKJM _752WG']//span");

	public void findLinks() {
		List<WebElement> allheader = driver.findElements(header);
		for (WebElement head : allheader) {
			System.out.println(head.getText());
		}

	}

	public void clickRecharge() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(recharge));
		driver.findElement(recharge).click();

		List<WebElement> allRechageItems = driver.findElements(allRechageLinks);
		for (int i = 0; i < allRechageItems.size(); i++) {
			System.out.println(allRechageItems.get(i).getText());
		}
	}

}
