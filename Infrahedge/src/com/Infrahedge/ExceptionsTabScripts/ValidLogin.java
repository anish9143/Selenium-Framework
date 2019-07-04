package com.Infrahedge.ExceptionsTabScripts;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xslf.usermodel.XSLFSheet;

//import org.dom4j.io.XPP3Reader;
import org.eclipse.jetty.util.LazyList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Infrahedge.GenericPomPages.LogInPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Strings;
import com.aventstack.extentreports.ExtentReports;


public class ValidLogin extends BaseTest {

	@Test(description="Test Infrahedge Login")
	public void testLogin() throws InterruptedException, IOException, AWTException {

		LogInPage l = new LogInPage(driver);
		// test.info("LogIn Page Displayed !!");
		String un = "Anish.Thakur";

		String pw = "May@2019";

		l.setUsername(un);
		// test.info("Fill the user name");
		l.setPassword(pw);
		// test.info("Fill the password");
		Thread.sleep(3000);
		String path = concatenate+takeScreenshot(driver, "LogIn");
		test.addScreenCaptureFromPath(path);
		l.clickLogin(driver);
		//test.log(Status.INFO, "Logged in Successfully !!");
		Thread.sleep(2000);

		l.clickAgreeButton(driver);

		Thread.sleep(3000);
		 path = concatenate+takeScreenshot(driver, "BarclaysReport");
		test.addScreenCaptureFromPath(path);
		l.clickBarclaysReport(driver);
		Thread.sleep(2000);
		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
			driver.manage().window().maximize();
		}

		String title = driver.getTitle();
		System.out.println("title is-->" + title);
		
		Assert.assertEquals(title, "Barclays IRF");
		
		Thread.sleep(3000);
		l.clickCalendar();
		l.datePicker();

	}
}
