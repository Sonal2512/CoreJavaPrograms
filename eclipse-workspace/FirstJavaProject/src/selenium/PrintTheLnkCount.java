package selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTheLnkCount {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://qaclickacademy.com/practice.php");
		
		//Print a link count present in the entire page
		System.out.println(driver.findElements(By.tagName("a")).size());
		//A link has specific attribute "a" for anchor in html
		
		//Print a link count present in the footer section by limiting WebDriver scope
		WebElement footerDriver= driver.findElement(By.id("gf-BIG")); //this footerDriver will act as driver but its scope is limited to footer section only
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//Print a link count present in the first column of the footer section
		WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //used absolute xpath to move to the 1st column of the table
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//Check if links in the column are getting opened. Here open the links in separate tab by using Ctrl+click to avoid the steps like clicking back button to get back to main page to click next link. This is called code optimization
		//skip 1st link because it gets opened in the same tab
		
		int count = columnDriver.findElements(By.tagName("a")).size();
		for(int i=1;i<count;i++) {
			
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER); //to achieve Ctrl+click in the sequence
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);   //keyboard events are passed by sendKeys method
			
		}	
		
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while(it.hasNext()) {                  //it will check till it has next window
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
		}
		
}


