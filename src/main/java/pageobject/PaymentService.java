package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentService {

	WebDriver driver;

	private By paymentServiceMenu = By.xpath("//a[contains(@href,'payment') or contains(text(),'Payment')]");

	private By onlinePayment = By.xpath("//span[normalize-space()='Online Payments']/ancestor::a");
	private By offlinePayment = By.xpath("//span[normalize-space()='Offline Payments']/ancestor::a");
	private By businessSoftware = By.xpath("//span[normalize-space()='Business Software']/ancestor::a");

	public PaymentService(WebDriver driver) {
		this.driver = driver;
	}

	public void mouseOverPaymentServices() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Actions actions = new Actions(driver);

		WebElement paymentMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentServiceMenu));
		actions.moveToElement(paymentMenu).perform();

		// 2️⃣ Wait for submenu
		WebElement onlinePaymentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(onlinePayment));
		actions.moveToElement(onlinePaymentLink).perform();

		WebElement offlinePaymentLink = wait.until(ExpectedConditions.visibilityOfElementLocated(offlinePayment));
		actions.moveToElement(offlinePaymentLink).perform();
	}

}
