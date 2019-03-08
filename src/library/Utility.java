package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static String captureScreenshot(WebDriver driver, String screenshotName) {

		TakesScreenshot ts = (TakesScreenshot) driver;// TakesScreenshot is interface so we cannot create object of
		// it. hence we are doing typecasting to get the object
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + screenshotName + System.currentTimeMillis()
				+ ".png";
		File destFile = new File(path);
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("screenshot taken");
		} catch (Exception e) {
			System.out.println("Exceptioon while taking screenshot: " + e.getMessage());
		}
		return path;
	}
}
