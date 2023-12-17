package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSAlertsHandelling {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Rahul");
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		//Grab the text present on alert and accept javaScript alert
		System.out.println(driver.switchTo().alert().getText()); //switchTo and alert methods are used to switch to alerts from driver
		driver.switchTo().alert().accept();                 //accept is a positive select e.g. Ok
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();  //dismiss is a negative select e.g. cancel
		
	}

}
