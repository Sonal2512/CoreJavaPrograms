package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropDown {

	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		//To get list of the all suggested items use 'findElements'and return type of it is List<WebElement> so we have to create a list variable to store the list
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); 
		Thread.sleep(2000);
		for(WebElement option:options)  //Enhanced for loop: It will check all the options one by one and store the value in 'option' for that particular iteration
		{
			if(option.getText().equalsIgnoreCase("India")) //get text of the option and compare it to the expected output
			{
				option.click();            //click on the option when it gets matches and break the loop
				 break;
			}
		}
	}

}
