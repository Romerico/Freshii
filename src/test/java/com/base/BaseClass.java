package com.base;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;



public class BaseClass 
{
	static ReadConfig  readconfig = new ReadConfig(); // Creating object
	// Integrating data from ReadConfig
	public static String baseURL=readconfig.getApplicationURL(); 
	public String username1=readconfig.getUsername1();
	public String password=readconfig.getPassword(); 
	public  String browser=readconfig.getbrowser();
	public static ChromeOptions handlingSSL = new ChromeOptions();
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public  void setup()
	{	
		if(browser.equalsIgnoreCase("chrome")) {
			 //Create instance of ChromeOptions Class
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver107.exe");
			driver = new ChromeDriver(handlingSSL);
		// Initialization // Logger initiated within the setup method
		logger=Logger.getLogger("Freshii");// Project Name
		PropertyConfigurator.configure("log4j.properties"); // Added Logger
		logger.setLevel(Level.DEBUG); // to get the debug log
		logger.debug("Debug logging has started ");
		
		
		}
		driver.get(baseURL);
        driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}



	public static String randomestring() 
	{
		String generatedString1 = RandomStringUtils.randomAlphabetic(5); // generate random char string with the specified values passed 
		return (generatedString1);										 
	}

	public static String randomeNum() 
	{
		String generatedString2 = RandomStringUtils.randomNumeric(4);// generate random digits with the specified values passed
		return (generatedString2);
	}
	
}