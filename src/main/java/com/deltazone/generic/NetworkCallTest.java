package com.deltazone.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;


public class NetworkCallTest {
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
	           // System.out.println("Request Headers: " + request.getHeaders());
	        });

	        devTools.addListener(Network.responseReceived(), responseEvent -> {
	            Response response = responseEvent.getResponse();
	          //  System.out.println("Response URL: " + response.getUrl());
	            System.out.println("Response Status: " + response.getStatus());
	           // System.out.println("Response Headers: " + response.getHeaders());
	        });

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
