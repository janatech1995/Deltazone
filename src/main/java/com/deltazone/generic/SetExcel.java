package com.deltazone.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetExcel {
	public static void main(String[] args) throws IOException {
		 ChromeOptions options = new ChromeOptions();
	  		options.addArguments("--remote-allow-origins=*");
	  		WebDriver driver = new ChromeDriver(options);
	  		driver.manage().window().maximize();
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		driver.get("https://my.deltazone.dev/search");
	  		FileInputStream fis=new FileInputStream("C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet1=wb.getSheet("sheet1");
			 int rowcount = sheet1.getLastRowNum();
			 int colcount = sheet1.getRow(1).getLastCellNum();
			for (int i= 1; i <= rowcount; i++) {
				XSSFRow celldata = sheet1.getRow(i);	
		    String url=celldata.getCell(0).getStringCellValue();
			String un=celldata.getCell(1).getStringCellValue();
			String pw=celldata.getCell(2).getStringCellValue();
			driver.findElement(By.id("login-email")).sendKeys(un);
			driver.findElement(By.id("login-password")).sendKeys(pw);
			driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        String data = element.getText();
        driver.quit();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Report");

        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Jana");
        row.createCell(1).setCellValue("Vinoth");

        // Add the scraped data to the Excel report
        Row dataRow = sheet.createRow(1);
        dataRow.createCell(0).setCellValue(data);

        FileOutputStream outputStream = new FileOutputStream("report.xlsx");
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
	}
}
