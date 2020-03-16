package pom_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pom_pages.Homepage;
import pom_pages.Loginpage;

public class Testlogin 
{
	String driverPath = "/home/sivaramakrishna/drivers/chromedriver_linux64 (4)/chromedriver";   
    WebDriver driver;
    Loginpage objLogin;
    Homepage objHomepage;
    
    @BeforeTest
    public void setup()
    {
    	System.setProperty("webdriver.chrome.driver", driverPath);       
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://192.168.7.5/bhadrathabeta");
        driver.manage().window().maximize();
        
    }
    @Test
    	public void test_Home_Page_Appear_Correct(){
    	objLogin = new Loginpage(driver);
    	String loginpageTitle = objLogin.getLoginTitle();
    	//Assert.assertTrue(loginpageTitle.toCharArray().toString().contains("Bhadratha And Aroghya Bhadratha"));	
    	objLogin.logintopage("169132", "Admin.321");
    	objHomepage = new Homepage(driver);
    	//Assert.assertTrue(objHomepage.gethomepageuser().toCharArray().toString().contains("Bhdratha TS Police"));
    }
 
}
