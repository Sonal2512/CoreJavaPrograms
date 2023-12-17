package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingCompleteCode{

	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://corporate.spicejet.com/Default.aspx");
		//Departure City
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);                                               //important to add wait here because it takes some time to open To dropdown options
	    //Arrival City
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		Thread.sleep(2000); 
		//Depart date
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-active ui-state-hover']")).click();
		Thread.sleep(2000); 
		//Verify Arrival Date is disabled
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
		System.out.println("its disabled");
		Assert.assertTrue(true);
		}
		else
		{
		Assert.assertTrue(false);
		}
		//add 5 adults
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		WebElement staticDropdown= driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
		
		Select dropdown =new Select(staticDropdown); //defining object for select class but it needs argument WebElement
		dropdown.selectByValue("5");
		
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}

}
