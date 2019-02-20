import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicXpath {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/kendo-ui/grid/checkbox-selection");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//td[contains(text(),'Aniseed Syrup')]//parent::tr[@data-uid='02a5c269-d884-4edb-9c00-8803965b59e4']//preceding::td[@role='gridcell']//input[@id='f5bb605c-a2f8-483b-8015-57cfb8743596']")));
		el.click();
		driver.quit();

	}
}
