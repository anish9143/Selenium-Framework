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

import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.DatabaseConnectivity;
import com.Infrahedge.generic.Library;

public class IPTAAVaR extends BaseTest {

	@Test()

	public void fetch_IP_TAA_VaR() throws InterruptedException, IOException, AWTException {

		ValidLogin login = new ValidLogin();
		login.testLogin();
		Thread.sleep(4000);

		// Click on the Vol progress bar
		System.out.println("click on ProgressBar");
		Thread.sleep(2000);

		// Click on the Vol progress bar
		com.Infrahedge.PomPages.ExceptionsPages.IPTAAVaRPage ipTAAVaR = new com.Infrahedge.PomPages.ExceptionsPages.IPTAAVaRPage(
				driver);
		ipTAAVaR.clicktAAVaRProgressbar();

		Thread.sleep(2000);

		ArrayList<String> riskProfileList = new ArrayList<String>();

		riskProfileList.add("IP1");
		riskProfileList.add("IP2");
		riskProfileList.add("IP3");
		riskProfileList.add("IP4");
		riskProfileList.add("IP5");

		String TAA = "TAA";

		// Click on Vol and read write excel
		Library.readWriteProfileCategories(riskProfileList, TAA);
		Thread.sleep(1000);

		// click BREACH SUMMARY
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
