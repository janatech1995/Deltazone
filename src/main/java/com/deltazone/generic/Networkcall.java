package com.deltazone.generic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;


public class Networkcall {
	   public static void main(String[] args) {
	        // Set the path to your ChromeDriver executable
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        // Create a DevTools instance
	        DevTools devTools = ((ChromeDriver) driver).getDevTools();
	        devTools.createSession();

	        // Enable the Network domain
	        devTools.send(Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));

	        // Add event listeners to capture network data
	        devTools.addListener(Network.requestWillBeSent(), requestEvent -> {
	            Request request = requestEvent.getRequest();
	            //System.out.println("Request URL: " + request.getUrl());
	            System.out.println("Request Method: " + request.getMethod());
	            String req = request.getMethod();
	            String filePath = "C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx";
	        	// Load the Excel file
	        	FileInputStream fis = null;
				try {
					fis = new FileInputStream(new File(filePath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	Workbook wb = null;
				try {
					wb = new XSSFWorkbook(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	XSSFSheet sheet1=(XSSFSheet) wb.getSheet("sheet1");
	        	Sheet sheet = wb.getSheet("Sheet1");
	        	int rowIndex = 1; // Row index (0-based)
	        	int cellIndex = 3; // Cell index (0-based)

	        	Row row = sheet.getRow(rowIndex);
	        	if (row == null) {
	        	    row = sheet.createRow(rowIndex);
	        	}
	        	Cell cell = row.createCell(cellIndex);
	        	String dataToWrite = req;
	        	cell.setCellValue(dataToWrite);
	        	FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(new File(filePath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					wb.write(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           // System.out.println("Request Headers: " + request.getHeaders());
	        });
	        devTools.addListener(Network.responseReceived(), responseEvent -> {
	            Response response = responseEvent.getResponse();
	          //  System.out.println("Response URL: " + response.getUrl());
	            System.out.println("Response Status: " + response.getStatus());
	            Integer res = response.getStatus();
	            String filePath = "C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx";
	        	// Load the Excel file
	        	FileInputStream fis = null;
				try {
					fis = new FileInputStream(new File(filePath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	Workbook wb = null;
				try {
					wb = new XSSFWorkbook(fis);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	XSSFSheet sheet1=(XSSFSheet) wb.getSheet("sheet1");
	        	Sheet sheet = wb.getSheet("Sheet1");
	        	int rowIndex = 1; // Row index (0-based)
	        	int cellIndex = 4; // Cell index (0-based)

	        	Row row = sheet.getRow(rowIndex);
	        	if (row == null) {
	        	    row = sheet.createRow(rowIndex);
	        	}
	        	Cell cell = row.createCell(cellIndex);
	        	Integer dataToWrite = res;
	        	cell.setCellValue(dataToWrite);
	        	FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(new File(filePath));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					wb.write(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					wb.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	           // System.out.println("Request Headers: " + request.getHeaders());
	        });
	           // System.out.println("Response Headers: " + response.getHeaders());

	        // Navigate to a website
	        driver.get("https://my.deltazone.dev/search");
	        driver.findElement(By.id("login-email")).sendKeys("janamech4312+delta2@gmail.com");
	        driver.findElement(By.id("login-password")).sendKeys("Jana@1995");
	        driver.findElement(By.id("submit-login")).click();

	        // Perform actions on the web page

	        // Close the WebDriver
	        driver.quit();
	    }
}


