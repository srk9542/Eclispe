package pom_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage 
{
	WebDriver driver;
	By login=By.xpath("//div[@class='login-btn pull-right']//span[i]");
	By uname=By.xpath("//input[@id='UserName']");
	By pwd=By.xpath("//input[@id='Password']");
	By submit=By.xpath("//button[@type='submit']");
    By Titletext =By.xpath("//head/title");

	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void Login()
	{
		driver.findElement(login).click();
	}
	public void setuname(String struname)
	{
		driver.findElement(uname).sendKeys(struname);
	}
	public void setpwd(String strpwd)
	{
		driver.findElement(pwd).sendKeys(strpwd);
	}
	public void clicklogin()
	{
		driver.findElement(submit).click();
	}
	public String getLoginTitle()
	{
	    return    driver.findElement(Titletext).getText();
	}
	public void logintopage(String struname,String strpwd)
	{
		this.Login();
		this.setuname(struname);
		this.setpwd(strpwd);
		this.clicklogin();
		
	}
	
}
