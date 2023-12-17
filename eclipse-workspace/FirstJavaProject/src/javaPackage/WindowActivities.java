package javaPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sonal\\\\Software\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com"); //it will wait until all the page components are fully loaded
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("asdf"); //To delete specific cookie		
		driver.navigate().to("https://www.facebook.com"); //it will not wait to load page fully 
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().refresh();
		driver.navigate().forward();
		driver.close();
	}

}
