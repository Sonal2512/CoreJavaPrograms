package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrockenLinkValidation {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Get all URL tide up to the links
		
		List<WebElement> links= driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			//Use Java method to call URLs and get the status code
			//URL class is a predefined Java class and openConnections method present under it. In below step create an object to call the method openConnection
			//Return type of the method openConnection is the URLConnection or we can use parent of it HttpURLConnection
			
			HttpURLConnection conn=(HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			
			//Here we are not clicking on the link, just taking URL and status code to check if it is broken or not
			
			a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
		}
		
		   a.assertAll(); //if asset has stored any failure this test will fail ow pass
		
	}

}
