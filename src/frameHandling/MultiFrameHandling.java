package frameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultiFrameHandling {
	static WebDriver driver;

	@Test
	public static void frameWithinFrame() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// clicking on button
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		// prints the total number of frames
		int size = driver.findElements(By.id("Multiple")).size();
		System.out.println("toatl frames : " + size);
		// Switching the Outer Frame
		WebElement outerFrame = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
		driver.switchTo().frame(outerFrame);
		System.out.println("Outer Frame");
		// Switching the inner Frame
		WebElement innerFrame = driver
				.findElement(By.xpath("//iframe[contains(text(),'<p>Your browser does not support iframes.</p>')]"));
		driver.switchTo().frame(innerFrame);
		System.out.println("Inner Frame");
// Printing the text in inner frame
		WebElement textbox = driver.findElement(By.xpath("//input[@type='text']"));
		textbox.sendKeys("text entered in inner frame textbox");
		System.out.println("text entered successfully");
		driver.switchTo().defaultContent();

		driver.quit();
	}
}