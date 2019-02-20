package dropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//selecting dropdown element without using select class
public class DropdownHandeling2 {
	@Test
	public void dropDownWithoutSelectTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		List<WebElement> dropdownElementslist = driver.findElements(By.xpath("//select[@id='dropdown']//option"));
		System.out.println(dropdownElementslist.size());
		for (int i = 0; i < dropdownElementslist.size(); i++) {
			System.out.println(dropdownElementslist.get(i).getText());

		}
		driver.quit();
	}

}
