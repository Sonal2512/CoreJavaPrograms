package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		//Identify the frames
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		//Drag a frame and drop into another frame
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();
		
		//Important to return to normal page from page
		driver.switchTo().defaultContent();
		
	}

}
