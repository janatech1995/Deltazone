package com.deltazone.generic;

import java.io.File;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WriteDataInEmptyExcelcell {
	public static void main(String[]args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Specify the Excel file path
	String filePath = "C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx";

	// Load the Excel file
	FileInputStream fis = new FileInputStream(new File(filePath));
	Workbook wb = new XSSFWorkbook(fis);
	XSSFSheet sheet1=(XSSFSheet) wb.getSheet("sheet1");
	 int rowcount = sheet1.getLastRowNum();
	 int colcount = sheet1.getRow(1).getLastCellNum();
	for (int i= 1; i <= rowcount; i++) {
		XSSFRow celldata = sheet1.getRow(i);	
  //  String url=celldata.getCell(0).getStringCellValue();
	String un=celldata.getCell(1).getStringCellValue();
	String pw=celldata.getCell(2).getStringCellValue();
	driver.get("https://my.deltazone.dev/search");
	driver.findElement(By.id("login-email")).sendKeys(un);
	driver.findElement(By.id("login-password")).sendKeys(pw);
	driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
	driver.close();
	Sheet sheet = wb.getSheet("Sheet1");
	int rowIndex = 1; // Row index (0-based)
	int cellIndex = 3; // Cell index (0-based)

	Row row = sheet.getRow(rowIndex);
	if (row == null) {
	    row = sheet.createRow(rowIndex);
	}
	Cell cell = row.createCell(cellIndex);
	String dataToWrite = "jana";
	cell.setCellValue(dataToWrite);
	FileOutputStream fos = new FileOutputStream(new File(filePath));
	wb.write(fos);
	fos.close();
	wb.close();
	fis.close();
}}
}