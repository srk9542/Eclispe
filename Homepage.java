package pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage 
{
	WebDriver driver;
	By Homepagename=By.xpath("//h4[contains(text(),'Bhadratha')]");
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String gethomepageuser()
	{
		return driver.findElement(Homepagename).getText();
	}
	
}
