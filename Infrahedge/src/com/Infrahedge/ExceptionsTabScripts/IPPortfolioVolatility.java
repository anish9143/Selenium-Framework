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

public class IPPortfolioVolatility extends BaseTest {

	@Test()

	public void fetch_IP_Portfolio_Vol() throws InterruptedException, IOException, AWTException {

		ValidLogin login = new ValidLogin();
		login.testLogin();
		Thread.sleep(4000);

		// Click on the Vol progress bar
		System.out.println("click on ProgressBar");
		Thread.sleep(2000);

		// Click on the Vol progress bar
		com.Infrahedge.PomPages.ExceptionsPages.IPPortfolioVolatilityPage ipPortfolioVol = new com.Infrahedge.PomPages.ExceptionsPages.IPPortfolioVolatilityPage(
				driver);
		ipPortfolioVol.clickPortfolioVolProgressbar();

		Thread.sleep(2000);

		ArrayList<String> riskProfileList = new ArrayList<String>();

		/*riskProfileList.add("IP1");
		riskProfileList.add("IP2");
		riskProfileList.add("IP3");*/
		riskProfileList.add("IP4");
		riskProfileList.add("IP5");
		riskProfileList.add("Dynamic");

		String Portfolio = "Portfolio";

		// Click on Vol and read write excel
		Library.readWriteProfileCategories(riskProfileList, Portfolio);
		Thread.sleep(1000);

		// click BREACH SUMMARY
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
