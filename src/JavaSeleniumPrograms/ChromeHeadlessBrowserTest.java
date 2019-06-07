package JavaSeleniumPrograms;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessBrowserTest {
	static WebDriver driver;

	public static void main(String args[]) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
		search.sendKeys("Testing");
		List<WebElement> list = driver
				.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']//span"));
		System.out.println("total number of suggestionsin search box are:  " + list.size());
		Thread.sleep(3000);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("testing life cycle")) {
				list.get(i).click();
				break;
			}
		}
		driver.quit();
	}
}