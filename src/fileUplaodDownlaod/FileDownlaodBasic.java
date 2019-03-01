package fileUplaodDownlaod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileDownlaodBasic {
	public static WebDriver driver;

	@Test
	public static void fileDownloadingTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.cssSelector("a[href*='some-file.txt']")).click();

	}

}
