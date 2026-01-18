package demo.pageobject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaHome {

	WebDriver driver;

	public DemoqaHome(WebDriver driver) {
		this.driver = driver;
	}

	private By ElementButton = By.xpath("//h5[contains(text(),'Element')]");
	private By FormBTN = By.xpath("//h5[contains(text(),'Forms')]");
	private By AlertFrameBTN = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
	private By WidgetBTN = By.xpath("//h5[contains(text(),'Widgets')]");

	// Element section
	private By links = By.id("item-5");
	private By internalLinks = By.xpath("//*[@id='linkWrapper']//a");

	public void VerifyAllLinks() {
		driver.findElement(ElementButton).click();
		driver.findElement(By.id("item-5")).click();

		List<WebElement> anchorTagsList = driver.findElements(By.tagName("a"));
		for (WebElement link : anchorTagsList) {
			String url = link.getDomAttribute("href");

			if (isValidLink(url)) {
				verifyLink(url);
			}
		}

	}

	private boolean isValidLink(String url) {
		return url != null && !url.isEmpty() && !url.startsWith("javascript") && !url.equals("#");
	}

	public static void verifyLink(String url) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

			connection.setConnectTimeout(3000);
			connection.setReadTimeout(3000);
			connection.setRequestMethod("HEAD");
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode >= 400) {
				System.out.println(url + " --> BROKEN (" + responseCode + ")");
			} else {
				System.out.println(url + " --> OK (" + responseCode + ")");
			}

		} catch (Exception e) {
			System.out.println(url + " --> EXCEPTION");
		}
	}
}
