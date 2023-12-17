package selenium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companion/");
		Thread.sleep(2000);
		
		//Scroll down the page to see the booking section
		JavascriptExecutor jse = (JavascriptExecutor)driver; //casting the driver into JavascriptExecutor
		jse.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(2000);
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		while(!driver.findElement(By.cssSelector("span.cur-month")).getText().contentEquals("January"))
		{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
		}
		
		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab the common attribute-->Put into a date and iterate to get expected result		
		int count = driver.findElements(By.className("flatpickr-day")).size();
		for(int i=0;i<count;i++) {
			String text= driver.findElements(By.className("flatpickr-day")).get(i).getText();
			if(text.equalsIgnoreCase("3")) {
				driver.findElements(By.className("flatpickr-day")).get(i).click();
				break;
			}
		}
		

	}

}
