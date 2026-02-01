package pageobject;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dthrechange {

	private By dthLink = By.xpath("//span[contains(text(),'DTH Recharge')]");
	private By inputfiled = By.xpath("//input[@type='text']");
	private By proceedBTN = By.xpath("//button['.Proceed to Recharge']");
	private By dthoperator = By.className("._19rm");

	WebDriver driver;

	public Dthrechange(WebDriver driver) {
		this.driver = driver;

	}

	public void verifyRechagePge() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(dthLink));
		driver.findElement(dthLink).click();

		String parentWindow = driver.getWindowHandle();

		Set<String> allwondow = driver.getWindowHandles();

		for (String single : allwondow) {

			if (single != parentWindow) {
				driver.switchTo().window(single);
			}
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(dthLink));
		driver.findElement(inputfiled).sendKeys("142442425555");
		driver.findElement(proceedBTN).click();

	}

	public void allItemas() {
		List<WebElement> lst = driver.findElements(By.className("._19rm"));
		for (int i = 0; i < lst.size(); i++) {
			  System.out.println(lst.get(i).getText());

		}
	}
}
