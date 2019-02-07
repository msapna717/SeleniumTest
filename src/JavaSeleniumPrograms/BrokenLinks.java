package JavaSeleniumPrograms;

import java.util.List;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Security;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException, IOException {

		System.setProperty("webdriver.chrome.driver", "/Users/sapnamishra/Documents/WebDriver/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://www.mercury-tours.com/");
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		List<WebElement> links= driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("size of all links and image links"+links.size());
		
		 List<WebElement> activeLinks= new ArrayList<WebElement>();
		 //iterate list: Exclude all links which doesnt have href value
		 for (int i = 0; i < links.size(); i++) {
			if(links.get(i).getAttribute("href")!=null && (!links.get(i).getAttribute("href").contains("javascript"))) {
				activeLinks.add(links.get(i));
			}
		}
		 //get size of active links
		 System.out.println("size of active links and images"+activeLinks.size());
		 
		 //check href url with httpConnection api
		 for (int j = 0; j < activeLinks.size(); j++) {
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			//System.out.println("connection=   "+connection);
			connection.connect();
			String responce= connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+"---->"+responce);
		}
		 driver.quit();
		 }
	}
 

