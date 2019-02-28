package fileUplaodDownlaod;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileDownload {
	public static WebDriver driver;
	static File folder;

	@BeforeMethod
	public void setup() {

		// create new file generate random uuid and convert it into string
		folder = new File(UUID.randomUUID().toString());
		folder.mkdir();

		// chrome
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		ChromeOptions options = new ChromeOptions();

		// Creating hashmap object to store key and value
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popup", 0); // dont show any popup
		prefs.put("download.default_directory", folder.getAbsolutePath());

		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("/Users/sapnamishra/Documents/WebDriver/chromedriver"))
				.usingAnyFreePort().build();
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(service, options);
		driver.manage().window().maximize();

	}

	@Test
	public static void fileDownloadingTest() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.cssSelector("a[href*='some-file.txt']")).click();
		Thread.sleep(2000);
		File listOfFiles[] = folder.listFiles();
		// make sure directory is not empty
		// Assert.assertEquals(listOfFiles.length, is(not(0)));//hamcrest assertion
		Assert.assertTrue(listOfFiles.length > 0);
		for (File file : listOfFiles) {
			// Assert.assertEquals(file.length(), is(not((long) 0)));
			Assert.assertTrue(file.length() > 0);

		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		for (File file : folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}

}
