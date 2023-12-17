package javaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumprogram {

	public static void main(String[] args) throws InterruptedException {
		
		//launch browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Go to URL
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		//Enter user name and password
		driver.findElement(By.id("inputUsername")).sendKeys("Sonal");
		driver.findElement(By.name("inputPassword")).sendKeys("Satara1234");
		
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//form/h2")).getText()); //get text by xpath using tags only syntax: //parenttag/childtag
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Rohit");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("abcd@gmail.com"); //if no attribute is unique then we can use the common attribute with index to locate the element we want
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("xyz@gmail.com"); //sometimes index can differ due to hidden elements
		
		//to locate an element which does not have any attribute or value use only tag names like below
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("8976887943");  //by xpath
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText()); //for cssSelector syntax: Parenttag  childtag 
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); //for dynamic text, here we are taking some part of dynamic text which is stable 'pass'
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //for dynamic text, here we are taking some part of dynamic text which is stable 'submit'	
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Log Out']")).click(); //xpath by using text name of the button. here we can also use * instead of button in general
		driver.close();
		
	}

}
