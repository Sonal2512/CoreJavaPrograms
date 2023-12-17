package javaPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DynamicDropdown {

	public static void main(String[] args)throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\Software\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://corporate.spicejet.com/Default.aspx");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='AMD']")).click();
		Thread.sleep(1000);                                               //important to add wait here because it takes some time to open To dropdown options
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();    //not recomeneded to use index. here index 2 is mentioned because same options are for departure and To dropdown and if index is not specified , it will directly take by default 1st index i.e. departure
	
		//Child -parent relationship can be used here which will be more accurate way
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();

	
	}

}
