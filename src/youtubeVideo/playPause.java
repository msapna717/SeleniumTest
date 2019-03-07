package youtubeVideo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class playPause {
	WebDriver driver;

	@Test
	public void youtubeVideoTest() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get("https://www.youtube.com/");
		WebElement search = driver.findElement(By.cssSelector("#search"));
		search.sendKeys("selenium");
		driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-searchbox'])[2]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(
				"//a[@title='Selenium Tutorial For Beginners | What Is Selenium? | Selenium Automation Testing Tutorial | Edureka']"))
				.click();
		WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
		WebElement slider = driver.findElement(By.xpath("//div[@class='ytp-scrubber-container']"));
		Actions action = new Actions(driver);
		action.moveToElement(playButton).build().perform();
		action.moveToElement(playButton).dragAndDropBy(slider, 250, 0);

		String excpectedButtonTitle = "Play (k)";
		String actualButtonTitle = playButton.getAttribute("title");
		System.out.println(actualButtonTitle);
		if (actualButtonTitle.equals(excpectedButtonTitle)) {
			System.out.println("testcase passed: button title" + actualButtonTitle);
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
