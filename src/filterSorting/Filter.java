package filterSorting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Filter {
	WebDriver driver;

	@Test
	public void filterTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/grid/examples/functionality/filtering/basic-filtering/defaultcs.aspx");
		System.out.println("-----Application Launched------");
		driver.findElement(By
				.xpath("//input[@name='ctl00$ContentPlaceholder1$RadGrid1$ctl00$ctl02$ctl02$FilterTextBox_ShipName']"))
				.sendKeys("QUICK-Stop");
		Thread.sleep(3000);
		driver.quit();
	}

}
