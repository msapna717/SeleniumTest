package fileUplaodDownlaod;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadingWithAppleScript {
	static WebDriver driver;

	@Test
	public static void fileUploadWithAppleScriptTest() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/upload");
		// String filePath = "/Users/sapnamishra/Desktop/testFiles/upload.scpt";
		driver.findElement(By.id("file-upload")).click();
		Runtime.getRuntime().exec("osascript " + "/Users/sapnamishra/Desktop/testFiles/upload.scpt");
		Thread.sleep(3000);
//		driver.findElement(By.id("file-submit")).click();

//		System.out.println("------File uploaded successfully-----");
		// driver.quit();

	}
}