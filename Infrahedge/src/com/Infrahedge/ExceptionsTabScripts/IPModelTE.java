package com.Infrahedge.ExceptionsTabScripts;

import org.testng.annotations.Test;
import java.awt.AWTException;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Infrahedge.GenericPomPages.LogInPage;
import com.Infrahedge.PomPages.ExceptionsPages.ExceptionSummaryPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelTEPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVaRPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPSAAVolatilityPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPTAAVolatilityPage;
import com.Infrahedge.generic.BaseTest;

import com.Infrahedge.generic.Library;

public class IPModelTE extends BaseTest {

	// public static WebDriver driver;
	// DatabaseConnectivity connect=new DatabaseConnectivity();
	@Test()

	public void fetch_IP_Model_TE() throws InterruptedException, IOException, AWTException {

		ValidLogin login = new ValidLogin();
		login.testLogin();
		Thread.sleep(4000);

		// Click on the TE progress bar
		IPModelTEPage ipModelTE = new IPModelTEPage(driver);
		ipModelTE.clickModelTEProgressbar();

		Thread.sleep(2000);

		ArrayList<String> riskProfileList = new ArrayList<String>();

//		riskProfileList.add("IP1");
//		riskProfileList.add("IP2");
		riskProfileList.add("IP3");
//		riskProfileList.add("IP4");
//		riskProfileList.add("IP5");
//		riskProfileList.add("Dynamic");
//		riskProfileList.add("Charities");

		String Model = "Model";

		// Click on TE and read write excel
		Library.readWriteProfileCategories(riskProfileList, Model);
		Thread.sleep(1000);

		// click BREACH SUMMARY
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
