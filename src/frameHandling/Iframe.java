package frameHandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Iframe {
	static WebDriver driver;

	@Test
	public static void IframeHandlingTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String parent = driver.getWindowHandle();
//		Set<String> pops = driver.getWindowHandles();
//		{
//			Iterator<String> it = pops.iterator();
//			while (it.hasNext()) {
//
//				String popupHandle = it.next().toString();
//				if (!popupHandle.contains(parent)) {
//					driver.switchTo().window(popupHandle);
//					System.out.println("Popu Up Title: " + driver.switchTo().window(popupHandle).getTitle());
//					driver.close();
//				}
//			}

		int toatalFrames = driver.findElements(By.tagName("iFrame")).size();
		System.out.println("total frames on page are: " + toatalFrames);
//			WebDriverWait wait = new WebDriverWait(driver, 40);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("iFrame"))).click();
//			 driver.findElement(By.id("iFrame")).click();

		driver.switchTo().frame("globalSqa");
		List<WebElement> liElementList = driver.findElements(
				By.xpath("//body[@class='home page-template-default page page-id-1397 custom-background']"));

		for (WebElement webElement : liElementList) {
			System.out.println(liElementList);
		}
		driver.findElement(By.xpath("//a[@title='Trainings']")).click();
//			driver.findElement(By.xpath(
//					"//body[@class='home page-template-default page page-id-1397 custom-background']//input[@id='s']]"))
//					.click();
		System.out.println("You have clicked on link");
		driver.quit();
	}
}
