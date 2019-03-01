package fileUplaodDownlaod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailAttachFile {
	static WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String url = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		driver.get(url);

	}

	@Test
	public static void fileAttachTest() throws Exception {
		// String filepath = "/Users/sapnamishra/Desktop/testFiles/butterfly.jpeg";
		WebElement username = driver.findElement(By.xpath("//input[@id='identifierId']"));
		username.sendKeys(" testSB2000@gmail.com");

		WebElement next = driver.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(),'Next')]"));
		next.click();
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("Testing@79");
		boolean staleElement = true;
		while (staleElement) {
			try {
				driver.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(),'Next')]")).click();
				staleElement = false;

			} catch (StaleElementReferenceException e) {
				staleElement = true;
			}
		}
//		WebElement nextAgain = driver
//				.findElement(By.xpath("//span[@class='RveJvd snByac' and contains(text(),'Next')]"));
//		nextAgain.click();

		WebElement compose = driver.findElement(By.cssSelector(".aic .z0 div"));
		compose.click();

		WebElement to = driver.findElement(By.cssSelector(".oj div textarea"));
		to.sendKeys("sapna.mishra@sourcebits.com");

		WebElement subject = driver.findElement(By.cssSelector(".aoD.az6 input"));
		subject.sendKeys("Test email");
		WebElement BodyofEmail = driver.findElement(By.cssSelector(".Ar.Au div"));
		BodyofEmail.sendKeys("Test email with file attachment");
		WebElement attachClip = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		attachClip.click();
		Runtime.getRuntime().exec("osascript " + "/Users/sapnamishra/Desktop/testFiles/upload.scpt");
		WebElement Send = driver.findElement(By.cssSelector("tr.btC td:nth-of-type(1) div:nth-of-type(2)"));
		Send.click();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
