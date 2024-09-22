package deltazone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CopyDirectory {
	
	@SuppressWarnings("deprecation")
	@Test
	public void copyDirecory() throws InterruptedException, IOException {
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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
		Thread.sleep(10000);
		String crturl= driver.getCurrentUrl();
		 Assert.assertEquals(crturl, url);
		driver.findElement(By.xpath("//a[contains(text(),'File Manager')]//i")).click();
      driver.findElement(By.xpath("//div//div//button[2]")).click();
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[6]/div[2]/div[2]/table/tbody/tr[5]/td[1]/div/span/span[1]/input")).click();
	    driver.findElement(By.xpath("//div//div//button[2]")).click();
	    driver.findElement(By.xpath("//div//li[contains(text(),'Copy')]")).click();
	    driver.findElement(By.xpath(("//span[contains(text(),'React/')]"))).click();
	    driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	     Alert a = driver.switchTo().alert();
	     a.accept();
	   //  driver.findElement(By.xpath("//span[contains(text(),'ok')]")).click();
	     //driver.quit();
		}
}
}