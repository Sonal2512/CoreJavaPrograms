package javaPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown1 {

	public static void main(String[] args) throws Exception {
		
				//launch browser
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				
				//Add implicit wait
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//Go to URL
				driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
				
				//Drop down with select tag i.e. static drop down. Use Select class to handle static drop down
				WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")); //returns web element stored in staticDropdown 
				
				Select dropdown =new Select(staticDropdown); //defining object for select class but it needs argument WebElement
				dropdown.selectByIndex(3);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				Thread.sleep(1000);
				dropdown.selectByValue("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText()); //this dropdown does not support deselect option
				Thread.sleep(1000);
				dropdown.selectByVisibleText("AED");
				System.out.println(dropdown.getFirstSelectedOption().getText());
				
				//verify Passenger dropdown
				
				driver.findElement(By.id("divpaxinfo")).click();
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				//select 2 adults (1 adult is already selected)
				Thread.sleep(1000);
				driver.findElement(By.id("hrefIncAdt")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("btnclosepaxoption")).click();
				System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
				
				//Select 5 adults using while loop (1 adult is already selected)
				/*driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(1000);
				
				int i=1;
				while(i<5) {
					driver.findElement(By.id("hrefIncAdt")).click();
					i++;
				}
				Thread.sleep(1000);
				driver.findElement(By.id("btnclosepaxoption")).click();
				
				//Select 5 adults using for loop (1 adult is already selected)
				driver.findElement(By.id("divpaxinfo")).click();
				Thread.sleep(1000);
				
				for(i=1; i<5; i++) {
					driver.findElement(By.id("hrefIncAdt")).click();
				}
				Thread.sleep(1000);
				driver.findElement(By.id("btnclosepaxoption")).click();*/
	}

}
