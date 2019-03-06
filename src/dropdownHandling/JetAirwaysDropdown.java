package dropdownHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class JetAirwaysDropdown {
	WebDriver driver;

	@Test
	public void jetAirwaysDropdownHandling() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.jetairways.com/en/in/planyourtravel/flight-update.aspx");
		System.out.println("-----url launched------");
		WebElement planYourTravel = driver.findElement(By.xpath("(//a[contains(text(),'PLAN YOUR TRAVEL')])[2]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(planYourTravel).build().perform();
		Thread.sleep(3000);
		System.out.println(planYourTravel.getAttribute("href"));
		WebElement subElement = driver.findElement(By.xpath("(//a[contains(text(),'Top Flight Routes')])[2]"));
		builder.moveToElement(planYourTravel).moveToElement(subElement).build().perform();
		Thread.sleep(3000);
		WebElement List1Driver = driver
				.findElement(By.cssSelector("#Menu-PLANYOURTRAVEL > div > div:nth-child(1) > ul"));

		List<WebElement> L1 = List1Driver.findElements(By.xpath("li/a"));
		System.out.println(L1.size());
		for (int i = 0; i < L1.size(); i++) {
			System.out.println(L1.get(i).getText());

		}
		System.out.println("-------");
		List<WebElement> L2 = List1Driver.findElements(By.xpath("li/ul"));
		// System.out.println(L2.size());
		for (int j = 0; j < L2.size(); j++) {
			// System.out.println(L1.get(i).getText());
			WebElement DEF = L2.get(j);
			List<WebElement> L2SubList = DEF.findElements(By.xpath("li/a"));
			System.out.println(L2SubList.size());
			for (int k = 0; k < L2SubList.size(); k++) {
				System.out.println(L2SubList.get(k).getText());
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
