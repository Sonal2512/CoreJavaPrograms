package selenium;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart{

public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Add implicit wait
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait w= new WebDriverWait(driver, 5);
		

		String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded); //method calling
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Explicit wait
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//Explicit wait
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
}		

//Add all the logic in a method
public static  void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
			{
				String[] name=products.get(i).getText().split("-"); //split creates an array so now name should be string array
				//name[0]="Cucumber " and name[1]=" 1 Kg"
				String formattedName=name[0].trim(); //trim removes white spaces

	//format/trim it to get actual vegetable name
	//convert array into array list for easy search
	//check whether name you extracted is present in arrayList or not-

				List itemsNeededList = Arrays.asList(itemsNeeded);
				if(itemsNeededList.contains(formattedName))
				{
				j++;
				//click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); //do not reply on Add to cart text while setting locator because this button changes to added once the vegetable gets added
				if(j==itemsNeeded.length) //Use of j an this if loop is to stop checking further once the 3 items are added to the cart
				{
					break;
				}
				}
			}
	}
}


