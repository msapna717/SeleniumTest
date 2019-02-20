package dropdownHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownHandeling {
	@Test
	public void dropDownTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 2");
		select.selectByIndex(0);
		// selectValueFromDropdown(dropdown, "Option 1");
		System.out.println(select.isMultiple()); // do dropdown element have multiple value selection feature?
		List<WebElement> listDropdownElements = select.getOptions();
		System.out.print(select.isMultiple());
		int TotalElements = listDropdownElements.size() - 1;// to get size of dropdown
		System.out.println("Total Elements in dropdown are " + TotalElements);
		System.out.println("dropdown values are ");
		for (int i = 0; i < listDropdownElements.size(); i++) {
			String dropValues = listDropdownElements.get(i).getText();// to print all dropdown values
			System.out.println(dropValues);
			if (dropValues.equals("Option 1")) {
				listDropdownElements.get(i).click();// to get spicific element from dropdown
				break;
			}
		}

		driver.quit();

	}

	public void selectValueFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);

	}
}
