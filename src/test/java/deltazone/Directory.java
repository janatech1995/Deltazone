package deltazone;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.deltazone.generic.Base;

public class Directory extends Base{
	   @BeforeMethod       
	   @Test(priority=1)
	   public void adddirectory() throws IOException
	           {   
        driver.findElement(By.xpath("//a[contains(text(),'File Manager')]//i")).click();
        driver.findElement(By.xpath("//div//div//button[2]")).click();
        driver.findElement(By.xpath("//div//li[contains(text(),'Add Directory')]")).click();
        driver.findElement(By.xpath("//input[@placeholder='Directory Name']")).sendKeys("Automation");
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'ok')]")).click();
        driver.quit();
}
	     @AfterMethod
	     public void teardown() {
	    	 closeBrowser();
	     }
	   }
