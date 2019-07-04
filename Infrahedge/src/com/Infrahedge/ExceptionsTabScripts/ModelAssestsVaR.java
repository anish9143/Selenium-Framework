package com.Infrahedge.ExceptionsTabScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.ExceptionsPages.IPModelVaRPage;
import com.Infrahedge.PomPages.ExceptionsPages.IPModelVolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class ModelAssestsVaR extends BaseTest {

	public void readassetSubAssetValue(String Pro, String category, String kpi)
			throws InterruptedException, AWTException {
		String sheetName = category + "Asset" + kpi + Pro;

		WebTable_Reader webtableReader = new WebTable_Reader();
		// Selecting Profiles dynamically
		Thread.sleep(2000);
		Library.clickProfileDropDown();
		Thread.sleep(2000);
		// click categories
		if(Pro!="IP1") {
		WebElement PRO = driver.findElement(By.xpath("//*[text()='" + Pro + "']"));
		PRO.click();
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div.topLeftProgress")).click();

		// Add column in list
		ArrayList<String> columnList = new ArrayList<String>();
		columnList.add(category + " Values");
		columnList.add("Asset");
		columnList.add("Model Weight");
		columnList.add("Model CVaR");

		// Add Column names for Asset SubAsset for excel book
		webtableReader.addColumnAssetSubAssetSheet(sheetName, category, kpi, Pro, columnList);

		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.topLeftProgress")).click();
		List<WebElement> catRows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[3]"));
		System.out.println("Asset count=" + catRows.size());
		// Get all the ranges
				List<WebElement> allRanges = driver.findElements(By.xpath("//div[@class='topLeftProgress']//*[contains(@class, 'progress-bar')]"));
			
			// Select all the ranges
			for (int j = 2; j >= 0; j--) {
				allRanges.get(j).click();
				Thread.sleep(2000);
				try{
		// getting all values from category
		for (int i = 1; i <= catRows.size(); i++) {
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[3]"));

			element.click();

			Thread.sleep(5000);
			WebElement expandAll = driver
					.findElement(By.xpath("//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse']"));

			expandAll.click();
			Thread.sleep(1000);
			webtableReader.getAssetSubAssetwithCol(sheetName, category, columnList);

			// navigates to previous page
			WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Model'])[2]"));
			assetDropDown.click();

			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.topLeftProgress")).click();
			Thread.sleep(2000);

		}

	}
				catch (org.openqa.selenium.NoSuchElementException e) {
					System.out.println("No data present in the webtable");
				} 
			}
				  }
	@Test
	public void fecthModelssets() throws InterruptedException, IOException, AWTException {

		// Click on the VaR progress bar
	ValidLogin login = new ValidLogin();
	login.testLogin();
		IPModelVaRPage vaRprogress= new IPModelVaRPage(driver);
		vaRprogress.clickModelVaRProgressbar();
		

		// KPI
		String kpi = "VaR";
		String category = "Model";
		String ip1 = "IP1";
		readassetSubAssetValue(ip1, category, kpi);
	 //String ip2="IP2";
		// readassetSubAssetValue(ip2,category,kpi);
//		String ip3="IP3";
//		readassetSubAssetValue(ip3,category,kpi);
// 		String ip4="IP4";
//		readassetSubAssetValue(ip4,category,kpi);
//		String ip5="IP5";
//		readassetSubAssetValue(ip5,category,kpi);

//		click BREACH SUMMARY 		
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
