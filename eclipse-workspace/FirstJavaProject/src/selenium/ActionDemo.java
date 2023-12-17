package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		Actions a=new Actions(driver);
		
		//mouse hover and move to the specific element
		//In below step we have create a web element move because we are using it again and again in the code
		
		WebElement move= driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"));
		//In above statement, build command builds the action i.e. indicates it is ready to perform and perform command performs it
		
		//Right click/context click on the same element
		a.moveToElement(move).contextClick().build().perform();
		
		//Enter a word in capital letters in search box and select the word by double clicking it
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().perform();
		//in above text we have hold shift key to enter capital letters by using keyDown method and selected the word by using doubleClick method
		
		
	}

}
