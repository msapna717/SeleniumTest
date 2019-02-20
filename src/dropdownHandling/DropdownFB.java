package dropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownFB {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("u_0_j")).sendKeys("komal");
		driver.findElement(By.id("u_0_l")).sendKeys("sinha");
		driver.findElement(By.id("u_0_o")).sendKeys("4234252626");
		driver.findElement(By.id("u_0_v")).sendKeys("12345678");
		String day_xpath = "//select[@id='day']//option";
		String month_xpath = "//select[@id='month']//option";
		String year_xpath = "//select[@id='year']//option";
		selectValueFromDropdown(day_xpath, "30");
		selectValueFromDropdown(month_xpath, "Jun");
		selectValueFromDropdown(year_xpath, "1994");
		WebElement radiobox_female = driver.findElement(By.id("u_0_9"));
		WebElement radiobox_male = driver.findElement(By.id("u_0_a"));
		radiobox_female.click();
		driver.findElement(By.id("u_0_11")).click();
		Thread.sleep(4000);
		driver.quit();
	}

	public static void selectValueFromDropdown(String xpathValue, String value) {

		List<WebElement> ddlist = driver.findElements(By.xpath(xpathValue));

		System.out.println("Dropdown list size is " + ddlist.size());
		for (int i = 0; i < ddlist.size(); i++) {
			System.out.println(ddlist.get(i).getText());// to print all dropdown values
			if (ddlist.get(i).getText().equals(value)) {
				ddlist.get(i).click();// to get spicific element from dropdown
				break;
			}
		}
	}

}
