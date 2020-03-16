package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestCase 
{
	public static void main(String[] args) 
	{
	    // declaration and instantiation of objects/variables  
		System.setProperty("webdriver.chrome.driver","/home/sivaramakrishna/Downloads/chromedriver_linux64 (3)/chromedriver");
		WebDriver driver=new ChromeDriver();  
		
	   // Launch website  
	    driver.navigate().to("http://www.google.com/");  
	    driver.manage().window().maximize();
	          
	    // Click on the search text box and send value  
	    driver.findElement(By.xpath("//input[@name='q']")).sendKeys("javatpoint tutorials");  
	          
	    // Click on the search button  
	    //driver.findElement(By.name("btnK")).click();  
	    driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);

	}
}
