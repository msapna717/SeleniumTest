package frameHandling;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NestedFrames {
	static WebDriver driver;

	@Test
	public static void nestedFramesHandling() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://way2automation.com/way2auto_jquery/frames-and-windows.php");
		driver.findElement(By.xpath("//a[contains(text(),'Signin')]")).click();
		driver.findElement(By.xpath("//div[@id='login']//input[@name='username']")).sendKeys("msapna717@gmail.com");
		driver.findElement(By.xpath("//div[@id='login']//input[@name='password']")).sendKeys("Testing@79");
		driver.findElement(By.xpath("//div[@id='login']//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Frames and Windows")).click();
		// total frames on parent window
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Toatal frames on parent window are: " + totalFrames);

		driver.findElement(By.xpath("(//a[contains(text(),'Frameset')])[1]")).click();
		driver.switchTo().frame(2);
		System.out.println("Inside frame");
		// Store and Print the name of the First window on the console
		String handle = driver.getWindowHandle();
		System.out.println(handle);

		// Click on the Button "New Message Window"
		WebElement frame = driver.findElement(By.xpath("//a[@href='frameset.html']"));
		System.out.println("inside frame text is: " + frame.getText());
		frame.click();
		Thread.sleep(3000);

		// Store and Print the name of all the windows open
		Set handles = driver.getWindowHandles();
		System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

		}

		System.out.println(driver.getCurrentUrl());
		// total frames on child window
		int totalFramesChild = driver.findElements(By.tagName("frame")).size();
		System.out.println("Toatal frames on child window are: " + totalFramesChild);
		// Closing Pop Up window
		driver.close();
		// Close Original window

		driver.quit();

	}
}
