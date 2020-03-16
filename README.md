# Eclispe
coding...
package arogyabhadratha.org;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pargeneration {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","/home/sivaramakrishna/Downloads/chromedriver_linux64 (3)/chromedriver");
        WebDriver driver=new ChromeDriver();
        //WebDriver driver=new FirefoxDriver();                      
        //Explicit wait
        WebDriverWait wait =new WebDriverWait(driver, 20);
        driver.get("http://192.168.7.5/bhadrathabeta");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='login-btn pull-right']//span[i]")).click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //Excel file
        FileInputStream fi=new FileInputStream("/home/sivaramakrishna/Documents/Upload.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fi);
        XSSFSheet sheet=wb.getSheet("Sheet3");
        
        DataFormatter formatter = new DataFormatter();

    	int norows = sheet.getLastRowNum();
    	System.out.println(norows);
    	
        for( int i=1; i<=norows; i++)
        {	
        	String username=formatter.formatCellValue(sheet.getRow(i).getCell(0));
        	driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys(username);
        	String Password=formatter.formatCellValue(sheet.getRow(i).getCell(1));
        	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(Password);
        	driver.findElement(By.xpath("//button[@type='submit']")).click();
        	
        	driver.findElement(By.xpath("//section[@class='content']//p[contains(text(),'Member Verification &')]")).click();
        	String B_num=formatter.formatCellValue(sheet.getRow(i).getCell(2));
        	
        	driver.findElement(By.xpath("//input[@id='BhadhrathaNum']")).sendKeys(B_num);
        	
        	driver.findElement(By.xpath("//input[@value='Verify']")).click();
        	//Thread.sleep(3000);
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Verify & Generate PARform']")));
        	driver.findElement(By.xpath(sheet.getRow(i).getCell(23).getStringCellValue())).click();
        	
        /*	Select dropdown=new Select(driver.findElement(By.xpath("//select[@id='ServiceTypes_35258']")));
        	dropdown.selectByVisibleText("Inpatient");                */
        	
        	String service_type=formatter.formatCellValue(sheet.getRow(i).getCell(3));
        	//driver.findElement(By.xpath("//select[@id='ServiceTypes_35258']")).sendKeys(service_type);
        	driver.findElement(By.xpath(sheet.getRow(i).getCell(24).getStringCellValue())).sendKeys(service_type);
        	driver.findElement(By.xpath("//input[@value='Verify & Generate PARform']")).click();
        	//Details form
        	String Ip_num=formatter.formatCellValue(sheet.getRow(i).getCell(4));
        	driver.findElement(By.xpath("//input[@id='InPatientNumber']")).sendKeys(Ip_num);
        	
        	//date picker
        	driver.findElement(By.xpath("//input[@placeholder='Enter Admission Date']")).click();
      //String Adm_date=formatter.formatCellValue(sheet.getRow(i).getCell(5));
        
            WebElement Admission_date = driver.findElement(By.xpath("//a[contains(@class,'ui-state-highlight')]"));
            js.executeScript("arguments[0].click();",Admission_date );
        	Thread.sleep(2000);
        	//Time picker
        	driver.findElement(By.xpath("//input[@placeholder='Enter Admission Time']")).click();
        	String Adm_Time=formatter.formatCellValue(sheet.getRow(i).getCell(6));
        	WebElement Admission_Time = driver.findElement(By.xpath("//ul[@class='ui-timepicker-viewport']"));
        	List<WebElement> Time=Admission_Time.findElements(By.tagName("li"));

        	for (WebElement cell: Time)
        	{
        	   if (cell.getText().equals(Adm_Time))
        	   {
        	      cell.findElement(By.linkText(Adm_Time)).click();
        	      break;
        	   }
        	}
        	/*driver.findElement(By.xpath("//input[@value='10']")).click();
        	driver.findElement(By.xpath("//input[@value='20']")).click();
        	driver.findElement(By.xpath("//input[@value='30']")).click();*/
        	driver.findElement(By.xpath("//input[@value='40']")).click();
        	//driver.findElement(By.xpath("//input[@value='50']")).click();
        	Thread.sleep(2000);
        	String Num=formatter.formatCellValue(sheet.getRow(i).getCell(7));
        	driver.findElement(By.xpath("//input[@id='Number']")).sendKeys(Num);
        	Thread.sleep(2000);
        	String dpt=formatter.formatCellValue(sheet.getRow(i).getCell(8));
        	Select departments=new Select(driver.findElement(By.xpath("//select[@id='ddldepmt']")));
        	departments.selectByVisibleText(dpt);
        	Thread.sleep(2000);
        	String Apr_days=formatter.formatCellValue(sheet.getRow(i).getCell(9));
        	driver.findElement(By.xpath("//input[@id='ApproxDays']")).sendKeys(Apr_days);
        	Thread.sleep(2000);
        	String Present_compl=formatter.formatCellValue(sheet.getRow(i).getCell(10));
        	driver.findElement(By.xpath("//textarea[@id='PresentComplaints']")).sendKeys(Present_compl);
        	Thread.sleep(2000);
        	String G_con=formatter.formatCellValue(sheet.getRow(i).getCell(11));
        	driver.findElement(By.xpath("//textarea[@id='GeneralCondition']")).sendKeys(G_con);
        	Thread.sleep(2000);
        	String Diagn=formatter.formatCellValue(sheet.getRow(i).getCell(12));
        	driver.findElement(By.xpath("//textarea[@id='Diagnosis']")).sendKeys(Diagn);
        	Thread.sleep(2000);
        	String Trt_pln=formatter.formatCellValue(sheet.getRow(i).getCell(13));
        	driver.findElement(By.xpath("//textarea[@id='PreferredTreatment']")).sendKeys(Trt_pln);
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//input[@id='btnSaveNext']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='ParDlg']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog1']//button[contains(text(),'Ok')]")).click();
        	Thread.sleep(2000);
        	
        	//Add doctor
        	driver.findElement(By.xpath("//input[@id='AddDoctor']")).click();
        	String Dct=formatter.formatCellValue(sheet.getRow(i).getCell(14));
        	driver.findElement(By.xpath("//select[@id='DoctorID']")).sendKeys(Dct);
        /*	Select doctor=new Select(driver.findElement(By.xpath("//select[@id='DoctorID']")));
        	departments.selectByVisibleText(Dct);
        */	Thread.sleep(2000);
        	String Dct_type=formatter.formatCellValue(sheet.getRow(i).getCell(15));
        	driver.findElement(By.xpath("//select[@id='DrpDocType']")).sendKeys(Dct_type);
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//button[@id='doct_btn_submit']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='ParDoctorDlg']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog1']//button[contains(text(),'Ok')]")).click();
        	Thread.sleep(2000);
        	
        	//Investigation tab
        	driver.findElement(By.xpath("//a[contains(text(),'Non-routine Investigations')]")).click();
        	driver.findElement(By.xpath("//input[@value='Add Investigation']")).click();
        	String Invest_name=formatter.formatCellValue(sheet.getRow(i).getCell(16));
        	driver.findElement(By.xpath("//input[@placeholder='Enter Investigation Name']")).sendKeys(Invest_name);
        	String Invst_typ=formatter.formatCellValue(sheet.getRow(i).getCell(17));
        	driver.findElement(By.xpath("//select[@id='InvestigationTypeID']")).sendKeys(Invst_typ);
        
        	//driver.findElement(By.xpath("//form[@id='report_form']//input[@type='file']")).click();
        	driver.findElement(By.xpath("//form[@id='report_form']//input[@type='file']")).sendKeys("/home/sivaramakrishna/Downloads/sample.pdf");
        	driver.findElement(By.xpath("//button[@id='InvestigationSave']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='InvestigationDlg']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog']//button[contains(text(),'Ok')]")).click();
        	Thread.sleep(2000);
        	
        	//Add treatment
        	driver.findElement(By.xpath("//a[contains(text(),'Treatment Advised')]")).click();
        	driver.findElement(By.xpath("//input[@value='Add Treatment']")).click();
        	String trt_name=formatter.formatCellValue(sheet.getRow(i).getCell(18));
        	driver.findElement(By.xpath("//input[@id='TreatmentName']")).sendKeys(trt_name);
        	String trt_plan=formatter.formatCellValue(sheet.getRow(i).getCell(19));
        	driver.findElement(By.xpath("//textarea[@placeholder='Enter Treatment Advised']")).sendKeys(trt_plan);
        	//driver.findElement(By.xpath("//form[@id='treatment_form']//input[@type='file']")).click();
        	driver.findElement(By.xpath("//form[@id='treatment_form']//input[@type='file']")).sendKeys("/home/sivaramakrishna/Downloads/sample.pdf");
        	driver.findElement(By.xpath("//button[@id='TreatmentSave']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='InvestigationDlg']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog']//button[contains(text(),'Ok')]")).click();
        	Thread.sleep(2000);
        	
        	//Treatment images
        	driver.findElement(By.xpath("//a[contains(text(),'Treatment Images')]")).click();
        	driver.findElement(By.xpath("//input[@value='Add Treatment Image']")).click();
        	String Dgn_nam=formatter.formatCellValue(sheet.getRow(i).getCell(20));
        	driver.findElement(By.xpath("//input[@placeholder='Enter Diagnosis Name']")).sendKeys(Dgn_nam);
        	driver.findElement(By.xpath("//input[@id='UploadTreatmentFile']")).sendKeys("/home/sivaramakrishna/Downloads/sample.pdf");
        	driver.findElement(By.xpath("//button[@id='PARTreatmentImageSave']")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='PARTreatmentDlg']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog']//button[contains(text(),'Ok')]")).click();
        	Thread.sleep(2000);
        	
        	//Estimation cost
        	driver.findElement(By.xpath("//a[contains(text(),'Estimation Cost')]")).click();
        	String est_cost=formatter.formatCellValue(sheet.getRow(i).getCell(21));
        	driver.findElement(By.xpath("//input[@id='TotalEstimatedCost']")).sendKeys(est_cost);
        	driver.findElement(By.xpath("//input[@value='Add']")).click();
        	String Ot_cst=formatter.formatCellValue(sheet.getRow(i).getCell(22));
        	driver.findElement(By.xpath("//input[@id='OtherCost']")).sendKeys(Ot_cst);
        	driver.findElement(By.xpath("//button[@id='submit_billing']")).click();
        	driver.findElement(By.xpath("//div[@aria-describedby='ConformDialog']//button[contains(text(),'Yes')]")).click();
        	Thread.sleep(2000);
        	driver.findElement(By.xpath("//div[@aria-describedby='CommonDialog']//button[contains(text(),'Ok')]")).click();
        	
        }
        	
	}

}
