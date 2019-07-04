package com.Infrahedge.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
//import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

public class BaseTest implements IAutoConstant {
	public static WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static com.aventstack.extentreports.ExtentReports extent;
	public static com.aventstack.extentreports.ExtentTest test;
	public static String concatenate=".";

	// Setting the driver properties
	static {
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(IE_KEY, IE_VALUE);
	}

	// Launching the Application

	@org.testng.annotations.BeforeClass
	// @Parameters("browsers")
	// String browsers
	public void openApplication() {
		//reporter = new ExtentHtmlReporter(".\\Reports\\myreport.html");

		reporter = new ExtentHtmlReporter(".\\Reports\\" +getClass().getSimpleName() +".html");
		extent = new com.aventstack.extentreports.ExtentReports();
		extent.attachReporter(reporter);
		test = extent.createTest(this.getClass().getSimpleName());
		test.log(Status.INFO, "Welcome to Automated Report ! Please see the test's description and ScreenShots for status of each test !!!");
		

		// if(browsers.equalsIgnoreCase("chrome"))
		// {
		driver = new ChromeDriver();

//		}

//		else {
//			
//			driver = new InternetExplorerDriver();
//		}
		driver.manage().window().maximize();
		//test.log(Status.INFO, "Browser Launched !!");

		String url = Library.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		String ITO = Library.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeoutPeriod = Integer.parseInt(ITO);
		driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
	}
	
	
	
	@BeforeMethod
	
	public void getCurrentTestMethodName(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test = extent.createTest(methodName,result.getMethod().getDescription());
		
		
	}

	// Closing the Application
	
	
	@AfterMethod
	
	public void tearDown(ITestResult result) throws IOException, InterruptedException
	{
		if (ITestResult.FAILURE == result.getStatus()) {
			test.log(Status.FAIL, "Test case failed");
			String temp=concatenate+takeScreenshot(driver,result.getMethod().getMethodName());
			test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
			else if(ITestResult.SUCCESS == result.getStatus())
			{
				Thread.sleep(5000);
				test.log(Status.PASS, "Test case Passed");
				String temp=concatenate+takeScreenshot(driver,result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(temp);
			}
			
		
		extent.flush();
	}

	@AfterSuite
	public void closeApplication() throws InterruptedException {
		// Thread.sleep(60000);

	

		
		extent.flush();
		// driver.close();
		test.log(Status.INFO, "Browser is closed !!!");
	}

	// Capture ScreenShot

	public static String  takeScreenshot(WebDriver driver, String screenshotName) {
		//Date d = new Date();
		//String currentdate = d.toString().replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
/*		String path=System.getProperty("user.dir")+"\\screenshots\\"+testName+System.currentTimeMillis()+".png";
		//String fileName=testName+System.currentTimeMillis()+".png";
		//File destFile = new File(".\\screenshots\\" + currentdate + "\\" + testname + "_screenshot.png");
		File destFile= new File(path);		*/
		
		String imagePath="./Reports/Screenshots/"+screenshotName+ ".png";
		File path= new File(imagePath);
		
		
		try {
			FileUtils.copyFile(srcFile, path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}
}
