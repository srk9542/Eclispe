package practice;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CaptureScreenshot 
{
	public static void main(String[]args) throws Exception
	{
		
		//browser open
		System.setProperty("webdriver.chrome.driver","/home/sivaramakrishna/Downloads/chromedriver_linux64 (3)/chromedriver");
		WebDriver driver=new ChromeDriver();
								
		//Explicit wait
		WebDriverWait wait =new WebDriverWait(driver, 20);
		
		//enter url
		driver.get("http://192.168.7.7/bhadrathaqa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//get screenshot
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("/home/sivaramakrishna/Desktop/SRK/Screenshot/bhadratha.png") );
		
	}
}
