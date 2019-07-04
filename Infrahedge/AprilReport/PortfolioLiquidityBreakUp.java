package com.Infrahedge.Scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.PomPages.IPModelLiquidityPage;
import com.Infrahedge.PomPages.IPPortfolioLiquidityPage;
import com.Infrahedge.generic.BaseTest;
import com.Infrahedge.generic.Library;

public class PortfolioLiquidityBreakUp extends BaseTest {

	static int l;
	static Library lib = new Library();

	public void readBreakUpData(String Pro, String category, String kpi) throws InterruptedException

	{
		String sheetName = Pro + category + kpi+"breakUpDat";
		WebTable_Reader webtableReader = new WebTable_Reader();
		// Selecting Profiles dynamically
		Thread.sleep(2000);
		Library.clickProfileDropDown();
		Thread.sleep(2000);
		// click categories
		if (Pro != "IP1") {
			WebElement PRO = driver.findElement(By.xpath("//*[text()='" + Pro + "']"));
			PRO.click();
		}
		Thread.sleep(2000);
		// driver.findElement(By.cssSelector("div.topLeftProgress")).click();
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

		// Add column in list
		ArrayList<String> columnList = new ArrayList<String>();
		// columnList.add(category+" Values");
		columnList.add("Model");
		columnList.add("Category");
		columnList.add("External ID");
		columnList.add("Security Name");
		columnList.add("CCY");
		columnList.add("Sub Industry");
		columnList.add("Dev / EM");

//Add Column names for Asset SubAsset for excel book	   
		webtableReader.addColumnAssetSubAssetSheet(sheetName, category, kpi, Pro, columnList);

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		List<WebElement> modelRows = driver.findElements(By.xpath("//*[@id='QV019']//table/tbody/tr/td[1]"));
		System.out.println("Asset count=" + modelRows.size());

// getting all top level values from Model category
		for (int i = 1; i <= modelRows.size(); i++) {
			Thread.sleep(2000);
			
			try {
			WebElement modelElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr[" + i + "]/td[1]"));

			modelElement.click();
			}
			catch(Exception e) {
				System.out.println("NO further elements ");
			}

			Thread.sleep(1000);
			readDrillDownValuesOfModel(sheetName, category, columnList);

			// navigates to previous page
			WebElement assetDropDown = driver.findElement(By.xpath("//div[text()='Portfolio' and @class='navsubClass ng-binding']"));
			assetDropDown.click();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
			Thread.sleep(2000);

		}

	}

	public void readDrillDownValuesOfModel(String sheetName, String category, ArrayList<String> columnList) {
		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);
		List rows = driver.findElements(By.xpath("//table/tbody[1]/tr"));
		System.out.println("No of rows are : " + rows.size());

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		int excelRow = reader.getRowCount(sheetName);
		System.out.println(excelRow);
		// excelRow++;
		try {
			for (int k = 1; k < 14; k++) {
				excelRow++;
				for (int j = 1; j <= columnList.size(); j++) {
					String colData = driver
							.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[" + j + "]/div/div/span")).getText();
					System.out.println(colData);
					System.out.println("++++++"+columnList.get(j - 1));
					reader.setCellData(sheetName, columnList.get(j - 1), excelRow, colData);

				}

			}
		} catch (Exception e) {
			System.out.println("Element not found");
		}
	}

	@Test

	public void fetch_IP_Model_Liquidity_BreakUp() throws InterruptedException, IOException, AWTException {
		ValidLogin login = new ValidLogin();
		login.testLogin();
		Thread.sleep(2000);

		// Click on the model progress bar
		System.out.println("click on ProgressBar");

		IPPortfolioLiquidityPage ipModelLiquid = new IPPortfolioLiquidityPage(driver);

		ipModelLiquid.clickportfolioLiquidityProgressbar();

		Thread.sleep(2000);
		String kpi = "Liquidity";
		String category = "Portfolio";
		String ip1 = "IP1";
		readBreakUpData(ip1, category, kpi);
//		String ip2="IP2";
//		readBreakUpData(ip2,category,kpi);
//		String ip3="IP3";
//		readassetSubAssetValue(ip3,category,kpi);
// 		String ip4="IP4";
// 		readBreakUpData(ip4,category,kpi);
//		String ip5="IP5";
//		readassetSubAssetValue(ip5,category,kpi);

//		click BREACH SUMMARY 		
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
