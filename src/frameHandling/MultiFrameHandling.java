package frameHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
		driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
		driver.findElement(By.id("Multiple")).click();
		// prints the total number of frames
		int size = driver.findElements(By.id("Multiple")).size();
		System.out.println("toatl frames : " + size);
		// Switching the Outer Frame
		driver.switchTo().frame(0);
		// Printing the text in outer frame
		System.out.println(driver.findElement(By.id("Multiple")).getText());
		// prints the total number of frames inside outer frame
		size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames --" + size);
		// Switching to innerframe
		driver.switchTo().frame(0);
		// Printing the text in inner frame
		// System.out.println(driver.findElement(By.xpath("xpath of the inner element
		// ")).getText());
		// printing text in textbox
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sapna mishra");
		// Switching to defaultContent
		driver.switchTo().defaultContent();

//		for (int i = 0; i <= size; i++) {
//			driver.switchTo().frame(i);
//			int total = driver.findElements(By.id("Multiple")).size();
//			System.out.println(total);
//			driver.switchTo().defaultContent();
//		}
//		driver.switchTo().frame(0);
//		driver.switchTo().frame(1);
//		// driver.findElement(By.xpath("(//iframe[@src='MultipleFrames.html'])")).click();
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sapna mishra");
//		System.out.println("You have entered text in frame text box");
		driver.quit();
	}
}