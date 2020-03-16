package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DDT1
{
	public static void main(String[]args) throws Exception
	{
	    System.setProperty("webdriver.chrome.driver", "/home/sivaramakrishna/drivers/chromedriver_linux64 (4)/chromedriver");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://192.168.7.5/bhadrathabeta");
	    driver.manage().window().maximize();	  
	    driver.findElement(By.xpath("//div[@class='login-btn pull-right']//span[i]")).click();
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    File src=new File("/home/sivaramakrishna/Documents/Upload.xlsx");
	    FileInputStream finput = new FileInputStream(src);
	    XSSFWorkbook workbook= new XSSFWorkbook(finput);
	    XSSFSheet sheet= workbook.getSheet("Sample");
	    XSSFCell cell;
	    DataFormatter formatter = new DataFormatter();

    	int norows = sheet.getLastRowNum();
    	System.out.println(norows);
    	
	 /*   ArrayList data = new ArrayList();
	    Iterator itr = sheet.iterator();
	     while (itr.hasNext()) 
	     {
	         Row rowitr = (Row) itr.next();
	         Iterator cellitr = rowitr.cellIterator();
	         while(cellitr.hasNext()) 
	         {
	             Cell celldata = (Cell) cellitr.next();
	             switch(celldata.getCellType()) 
	             {
	             case STRING:
	                 data.add(celldata.getStringCellValue());
	                 break;
	         /*    case NUMERIC:
	                 data.add(celldata.getNumericCellValue());
	                 break;
	             case BOOLEAN:
	                 data.add(celldata.getBooleanCellValue());
	                 break;
	           }
	         	}
	        }    */  
	     for(int i=1; i<=norows; i++)
	     {
	         cell = sheet.getRow(i).getCell(0);
	         driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(cell.getStringCellValue());
	         cell = sheet.getRow(i).getCell(1);
	         driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(cell.getStringCellValue());
	         driver.findElement(By.xpath("//button[@type='submit']")).click();
	     
	         FileOutputStream foutput=new FileOutputStream(src);
	         String message = "Data Imported Successfully.";
	         sheet.getRow(i).createCell(3).setCellValue(message);
	         FileOutputStream fileOutput = new FileOutputStream(src);
	         workbook.write(fileOutput);
	         fileOutput.close();
	             
	     }
	 } 
	
}
