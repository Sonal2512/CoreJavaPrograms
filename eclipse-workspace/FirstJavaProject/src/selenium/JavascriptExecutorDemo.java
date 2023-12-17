package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://qaclickacademy.com/practice.php");
		
		//Scroll-down the page
		JavascriptExecutor jse = (JavascriptExecutor)driver;  //Casting the driver into JavascriptExecutor
		jse.executeScript("window.scrollBy(0,600)");   //check the coordinates by hit and try method
		
		//Scroll within the table
		Thread.sleep(2000);
		jse.executeScript("document.querySelector('.tableFixHead').scrollTop=100"); //use console window to check JS selectors
		
		//Calculate sum of the all values under Amount column
		//user parent child method to retrieve the values by cssSelector [parent child]
		List<WebElement> values= driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)")); //list of the all the values
		//In above statement parent is main table class name and child is 4th column of the table
		
		//Iterate through the value and get sum
		int sum=0;
		for(int i=0;i<values.size();i++) {
			
			int amount=Integer.parseInt(values.get(i).getText()); //Type casting string to integer
			sum=sum+amount;
		}
		System.out.println(sum);
		
		int total= Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
		
	}

}
