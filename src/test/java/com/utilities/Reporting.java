package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.base.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static com.base.BaseClass.driver;


public class Reporting extends TestListenerAdapter
{

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html"; // Report name and time stamp in html format
		
		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
		htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report - given by the user
		htmlReporter.config().setReportName("Functional Testing"); // name of the report - given by the user
		htmlReporter.config().setTheme(Theme.DARK); //
	//	htmlReporter.config().setTheme(Theme.STANDARD); 
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		// System info can be any info defined by the User that comes in the report
		// populate the common details
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","busyQA");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Browser name","Chrome");
	}
	public void onTestSuccess (ITestResult result)
	{

		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		
		
		}

	public static String captureScreen(WebDriver driver, ITestResult result) throws  IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + result.getName() + ".png");
		String filepath = target.getAbsolutePath();
		FileUtils.copyFile(source, target);

		return filepath;

	}

	public void captureScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);

	}

	public void onTestFailure (ITestResult result)
	{

		test=extent.createTest(result.getName()); // create new entry in the report

		String screenshotPath=System.getProperty("user.dir")+ "//Screenshots" + result.getName() + ".png";
		try {
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreen(driver, result)).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath);


		test.fail("Test Case: " + result.getName() + " FAILED");
		test.log(Status.FAIL, "TEST CASE FAILED TO " + result.getThrowable());



	}
	public void onTestSkipped (ITestResult result)
	{
		test=extent.createTest(result.getName()); // create new entry in the report
		test.log(Status.SKIP, "Test Case SKIIPED  IS " + result.getName());

		
	}
	public void onFinish(ITestContext testContext)
	{
		
		extent.flush();
		
	}

}
