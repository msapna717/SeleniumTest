package fileUplaodDownlaod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploading {
	static WebDriver driver;

	@Test
	public static void fileUploadTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/upload");
		System.out.println("--- Url launched ---");
		String filePath = "/Users/sapnamishra/Documents/Selenium/screenshots/test.png";
		WebElement chooseFile = driver.findElement(By.id("file-upload"));
		chooseFile.click();
		chooseFile.sendKeys(filePath);
		driver.findElement(By.id("file-submit")).click();
		Thread.sleep(3000);
		System.out.println("------ File uploaded successfully -----");
		driver.quit();

	}
}