package dropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BootstrapDropboxHandling {
	static WebDriver driver;

	@Test
	public static void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/jquery/demo.php?ex=152.0_1");
		driver.findElement(By.id("btndropdown")).click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//label"));
		System.out.println("list size is: " + list.size());
		System.out.println("list elements are:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().contains("HTML")) {
				list.get(i).click();
				break;
			}

		}

		// how to select all dropdown element
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			list.get(i).click();
//		}
		// how to select specific element eg. HTML
		Thread.sleep(3000);
		driver.quit();

	}

}
