package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","/home/sivaramakrishna/drivers/chromedriver_linux64 (4)/chromedriver");
        WebDriver driver=new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, 20);
        driver.get("http://192.168.7.5/bhadrathabeta");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='login-btn pull-right']//span[i]")).click();
        
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("129132");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Admin.321");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String HomepageTitle=driver.getTitle();
        System.out.println(HomepageTitle);
        

	}

}
