package youtubeVideo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Youtube {
	WebDriver driver;

	@Test
	public void youtubeVideoTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		WebElement search = driver.findElement(By.cssSelector("#search"));
		search.sendKeys("selenium");
		driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[2]")).click();
		driver.findElement(By.xpath(
				"//a[@title='Selenium Tutorial For Beginners | What Is Selenium? | Selenium Automation Testing Tutorial | Edureka']"))
				.click();
		Thread.sleep(4000);
		// sliding
		WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
		WebElement slider = driver.findElement(By.xpath("//div[@class='ytp-scrubber-container']"));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(slider, 350, 0).build().perform();
		Thread.sleep(3000);
		System.out.println("You have moved the slider");
		builder.dragAndDropBy(slider, -250, 0).build().perform();
		// Assertion
		String initialTimer = "0:00 of 2:32:33";
		String currentTimer = driver.findElement(By.xpath("//div[@aria-label='Seek slider']"))
				.getAttribute("aria-valuetext");
		if (currentTimer.equals(initialTimer)) {
			System.out.println("-----Video not playing------");

		} else
			System.out.println("Video is playing");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
