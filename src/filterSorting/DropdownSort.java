package filterSorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownSort {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chrome2.46/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://seleniumpractise.blogspot.com/");
	}

	@Test(priority = 1, description = "Testcase 1: Verify sorting of already sorted data")
	public void ddTest() {

		Select tools = new Select(driver.findElement(By.id("tools")));
		List actualList = new ArrayList();
		List<WebElement> myTools = tools.getOptions();
		for (WebElement ele : myTools) {
			String data = ele.getText();
			actualList.add(data);
		}
		System.out.println("Actual list is " + actualList);
		List temp = new ArrayList();
		temp.addAll(actualList);
		Collections.sort(temp);
		System.out.println("Sorted list is " + temp);
		Assert.assertTrue(actualList.equals(temp), "List is sorted");
	}

	@Test(priority = 2, description = "Testcase 2: Verify sorting of unsorted data")
	public void ddTest1() {

		Select tools = new Select(driver.findElement(By.id("tools1")));
		List actualList = new ArrayList();
		List<WebElement> myTools = tools.getOptions();
		for (WebElement ele : myTools) {
			String data = ele.getText();
			actualList.add(data);
		}
		System.out.println("Actual list is " + actualList);
		List temp = new ArrayList();
		temp.addAll(actualList);
		Collections.sort(temp);
		System.out.println("Sorted list is " + temp);
		Assert.assertTrue(actualList.equals(temp), "List is sorted");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}