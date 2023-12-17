package javaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class DynamicStringExtraction {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String name = "rahul";

		//To launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\sonal\\\\Software\\\\chromedriver-win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String password = getPassword(driver); //declare a variable password which will be store value returned by the getPassword method

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);

		System.out.println(driver.findElement(By.tagName("p")).getText());
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();

		}

		public static String getPassword(WebDriver driver) throws Exception{
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText =driver.findElement(By.cssSelector("form p")).getText(); //create passwordText variable to get the text 
		//i.e. passwordText = Please use temporary password 'rahulshettyacademy' to Login. this is the main string we need to extract only password section from this string

		String[] passwordArray = passwordText.split("'"); //use split function

		// This split function divides string in two parts i.e. here it will be acted as an array and create 2 indexes: 
		//0th index - Please use temporary password and 1st index - rahulshettyacademy' to Login.
		
		

		String password = passwordArray[1].split("'")[0]; //here again 0th index - rahulshettyacademy and 1st index - to Login.
		
		//Another method: String[] passwordArray2 = passwordArray[1].split("'");
				// passwordArray2[0]
		return password;
		}
}	
