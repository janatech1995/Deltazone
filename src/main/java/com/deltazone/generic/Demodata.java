package com.deltazone.generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
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

public class Demodata {
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
         String excelFilePath = "C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx";
        // Load the Excel file
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream);
        // Specify the sheet where your data is located (index 0 represents the first sheet)
        Sheet sheet = workbook.getSheetAt(0);
        // Example: Read data from the first row and first column (0-based index)
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        String cellValue = cell.getStringCellValue();
        System.out.println("Value from Excel: " + cellValue);
           inputStream.close();
        // Write data to Excel (assuming you want to update the same cell)
        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        cell.setCellValue("url"); // Update the cell with the new value
        workbook.write(outputStream);
        outputStream.close();
        // Close the WebDriver
        driver.quit();
    }
	}
}
