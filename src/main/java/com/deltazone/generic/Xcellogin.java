package com.deltazone.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Xcellogin {
	
	public static void main(String[]args) throws IOException, InterruptedException {
		  ChromeOptions options = new ChromeOptions();
	  		options.addArguments("--remote-allow-origins=*");
	  		WebDriver driver = new ChromeDriver(options);
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		driver.get("https://my.deltazone.dev/search");
	  		FileInputStream fis=new FileInputStream("C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheet("sheet1");
			 int rowcount = sheet.getLastRowNum();
			 int colcount = sheet.getRow(1).getLastCellNum();
			for (int i= 1; i <= rowcount; i++) {
				XSSFRow celldata = sheet.getRow(i);	
		    String url=celldata.getCell(0).getStringCellValue();
			String un=celldata.getCell(1).getStringCellValue();
			String pw=celldata.getCell(2).getStringCellValue();
			driver.findElement(By.id("login-email")).sendKeys(un);
			driver.findElement(By.id("login-password")).sendKeys(pw);
			driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
			driver.close();
			
			
			 }
			}
			
			
}
	         
	
