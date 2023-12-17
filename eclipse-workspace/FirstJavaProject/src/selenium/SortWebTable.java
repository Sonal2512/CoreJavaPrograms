package selenium;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SortWebTable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Add implicit wait
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait w= new WebDriverWait(driver, 5);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on heading of first column to sort the elements
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all the webElements from 1st column into a list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text of all the WebElements into new sorted list
		List<String> originalList= elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Perform sort operation on original list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//Compare originalList with sortedList
		Assert.assertTrue(sortedList.equals(originalList));
		
		//Use pagination Scan the 1st column of the table on each page with getText and if it is Rice capture its price, so apply loops
		//Here we are doing action first on the page and then pressing next so do-while loop can be used
		List<String> price;
		do{

		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a -> System.out.println(a));
		if(price.size()<1)
		{
		driver.findElement(By.cssSelector("[aria-label='Next']")).click(); //Click on next button
		}
		}while(price.size()<1);
	}		
	public static String getPriceVeggie(WebElement s)
	{
		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
		
	
		
}