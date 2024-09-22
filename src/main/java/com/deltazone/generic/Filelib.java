package com.deltazone.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Filelib {
	public String getExcelData(String sheetName,int Row,int Cell) throws IOException 
	{
		FileInputStream fis=new FileInputStream("C:\\\\Users\\\\Sridhar\\\\Delta-workspace\\\\deltazone\\\\data\\\\Testscript\\\\Login.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(Row).getCell(Cell).getStringCellValue();
		return data;

	}
	public void setExcelvalue(String sheetName,int Row,int cell,String value) throws EncryptedDocumentException, IOException 
	{
	FileInputStream fis1=new FileInputStream("C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx");
	Workbook wb1=WorkbookFactory.create(fis1);
	wb1.getSheet("sheet1").getRow(3).getCell(3).setCellValue("hai");
	FileOutputStream fos=new FileOutputStream("C:\\Users\\Sridhar\\Delta-workspace\\deltazone\\data\\Testscript\\Login.xlsx");
	wb1.write(fos);
	wb1.close();
}
}