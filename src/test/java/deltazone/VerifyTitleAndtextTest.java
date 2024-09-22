package deltazone;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class VerifyTitleAndtextTest {
	@Test
	public void titletest() {
      
	 ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String URL1 = "https://my.deltazone.dev/search";
		driver.get("https://my.deltazone.dev/search");
		 driver.findElement(By.id("login-email")).sendKeys("janamech4312+delta2@gmail.com");
	     driver.findElement(By.id("login-password")).sendKeys("Jana@1995");
	     driver.findElement(By.id("submit-login")).click();
		String expectedtext = "search icon";
		 String t = driver.getCurrentUrl();
		 Assert.assertEquals(t, URL1);
		 Reporter.log("login", true);
		 String actual = driver.findElement(By.xpath("//*[@id=\\\"nav-menu-icons\\\"]")).getAttribute("class");
		Assert.assertEquals(actual, expectedtext, "Text Verification failed");
		 driver.close();
}
}