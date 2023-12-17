package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class VerifyDisabledItem {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://corporate.spicejet.com/Default.aspx");
		//return date enable/disabled state can be checked by style attribute where the opacity value is 1 for enabled and 0.5 for disabled
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //by default on launching the site , one way option is selected where return date option is disabled
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();         //Selecting round trip radio button
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style")); //checking enabled return date option
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))

		{

		System.out.println("its enabled");
		Assert.assertTrue(true);
		}
		else
		{
		Assert.assertTrue(false);
		}
		
	}

}
