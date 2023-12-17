package selenium;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {

		//Setting Chrome browser behavior 
		ChromeOptions options = new ChromeOptions();   //created object of the class to access the methods present under it
		options.setAcceptInsecureCerts(true);  //bypass insecure certifications like privacy error
		
		//Proxy set-up
		Proxy proxy =new Proxy();
		proxy.setHttpProxy("ipaddress:4444"); //get this link from project support team
		options.setCapability("proxy", proxy);

		Map<String, Object> prefs = new HashMap<String, Object>();

		prefs.put("download.default_directory", "/directory/path");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);   //pass the options object as an argument so that selenium understand the Chrome browser behavior
		driver.manage().window().maximize();
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
