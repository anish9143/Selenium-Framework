package com.Infrahedge.generic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Infrahedge.Scripts.WebTable_Reader;

public class Library extends BaseTest implements IAutoConstant {
	public static Workbook wb;
	static Library lib = new Library();
	static int l;

	// Picking data from config file

	public static String getProperty(String CONFIG_PATH, String key) {
		String property = "";
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			property = prop.getProperty(key);
		} catch (Exception e) {
		}
		return property;
	}

	//// Picking data from Excel Sheet
	public static String getCellValue(String EXCEL_PATH, String sheet, int row, int column) {
		String value = "";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			value = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e) {
		}
		return value;
	}

	// Writing into Excel File

	public static void writeIntoExcel(String sheet, int row, int column, String value) {
		try {
			wb = WorkbookFactory
					.create(new FileInputStream("D:\\Workspace\\Infrahedge\\TestData\\InfraHedgeVolIP1.xlsx"));

			wb.createSheet(sheet).createRow(row).createCell(column).setCellValue(value);

			FileOutputStream outputFile = new FileOutputStream(
					"D:\\Workspace\\Infrahedge\\TestData\\InfraHedgeVolIP1.xlsx");

			wb.write(outputFile);
		} catch (Exception e) {
		}
	}

	// Getting total number of available rows in Excel Sheet
	public static int getRowCount(String EXCEL_PATH, String sheet) {
		int rowCount = 0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
		}
		return rowCount;
	}

	// Reading the webtable values from UI

	public void WT_Reader() {

		// Fetch the excel input sheet and write
		String profiles = driver
				.findElement(By
						.xpath("(//div[contains(@class,'col-md-8 navBarClass')]//div[contains(@class,'navsubClass ng-binding')])[1]"))
				.getText();
		String kpi = driver.findElement(By.cssSelector("div.navKPIClass.ng-binding")).getText();
		kpi = kpi.replaceAll("[^a-zA-Z0-9]", "");
		String xlWorkBookName = profiles + kpi;
		System.out.println(xlWorkBookName);
		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(
				"D:\\Workspace\\Infrahedge\\TestData\\" + xlWorkBookName + ".xlsx");

		// Get sheet name
		String sheetName = driver.findElement(By.cssSelector("div.col-md-8.navBarClass"))
				.getText();
		sheetName = (sheetName.replaceAll("[^a-zA-Z0-9]", "")).substring(17);
		System.out.println(sheetName + "#############");
		reader.addSheet(sheetName);

		// Fetch the total number of rows
		List rows = driver.findElements(By.xpath("//table/tbody[1]/tr"));
		System.out.println("No of rows are : " + rows.size());

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		// Column names fetching dynamically
		List<String> colNames = new ArrayList<>();
		for (int i = 1; i < columns.size(); i++) {
			WebElement colName = driver.findElement(By.xpath("//table/tbody/tr[1]/th[" + i + "]"));
			if (!colName.getText().isEmpty()) {
				// Pass it column names
				System.out.println(colName.getText());
				colNames.add(colName.getText());
				reader.addColumn(sheetName, colName.getText());
			}
		}

		// Fetching table values for selected Profile

		System.out.println(colNames);
		for (int k = 1; k < rows.size(); k++) {
			for (int j = 1; j <= colNames.size(); j++) {
				String colData = driver.findElement(By.xpath("//table/tbody/tr[" + k + "]/td[" + j + "]/div/div/span"))
						.getText();
				System.out.println(colData);
				reader.setCellData(sheetName, colNames.get(j - 1), k + 1, colData);
			}
		}
	}

	// Webtable read values from scroll implemented table
	public void WT_Scroll_Reader(int rows) {

		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);
		// Get sheet name
		String sheetName = driver.findElement(By.cssSelector("div.col-md-8.navBarClass"))
				.getText();
		sheetName = (sheetName.replaceAll("[^a-zA-Z0-9]", "")).substring(17);
		System.out.println(sheetName + "#############");

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		// Column names fetching dynamically
		List<String> colNames = new ArrayList<>();
		for (int i = 1; i <columns.size(); i++) {
			WebElement colName = driver.findElement(By.xpath("//table/tbody/tr[1]/th[" + i + "]"));
			if (!colName.getText().isEmpty()) {
				// Pass it column names
				System.out.println(colName.getText());
				colNames.add(colName.getText());
				// reader.addColumn(sheetName, colName.getText());
			}
		}

		// Fetching table values for selected Profile

		System.out.println(colNames);

		for (int j = 1; j <= colNames.size(); j++) {
			String colData = driver.findElement(By.xpath("//table/tbody/tr[17]/td[" + j + "]/div/div/span")).getText();
			System.out.println(colData);
			reader.setCellData(sheetName, colNames.get(j - 1), rows, colData);
		}

	}
	
	

	// Webtable read values from scroll implemented table
	public void WT_Scroll_Last_Value_Reader(int rows) {

		com.Infrahedge.generic.Xls_Reader reader = new com.Infrahedge.generic.Xls_Reader(EXCEL_PATH);
		// Get sheet name
		String sheetName = driver.findElement(By.cssSelector("div.col-md-8.navBarClass"))
				.getText();
		sheetName = (sheetName.replaceAll("[^a-zA-Z0-9]", "")).substring(17);
		System.out.println(sheetName + "#############");

		// Column number
		List<WebElement> columns = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		System.out.println("******** COL NUM=" + columns.size());

		// Column names fetching dynamically
		List<String> colNames = new ArrayList<>();
		for (int i = 1; i <columns.size(); i++) {
			WebElement colName = driver.findElement(By.xpath("//table/tbody/tr[1]/th[" + i + "]"));
			if (!colName.getText().isEmpty()) {
				// Pass it column names
				System.out.println(colName.getText());
				colNames.add(colName.getText());
				// reader.addColumn(sheetName, colName.getText());
			}
		}

		// Fetching table values for selected Profile

		System.out.println(colNames);

		for (int j = 1; j <= colNames.size(); j++) {
			String colData = driver.findElement(By.xpath("//table/tbody/tr[18]/td[" + j + "]/div/div/span")).getText();
			System.out.println(colData);
			reader.setCellData(sheetName, colNames.get(j - 1), rows, colData);
		}

	}
	
	
	
	// reading the 1st level WT data

	static public void readWriteProfileCatagories(ArrayList<String> profiles, String KPI)
			throws InterruptedException, AWTException {
		// Get all the ranges
		List<WebElement> allRanges = driver.findElements(By.xpath("//*[contains(@class, 'progress-bar')]"));

		// Select Profiles dynamically
		WebTable_Reader wt = new WebTable_Reader();

		driver.findElement(By.cssSelector("div.topLeftProgress")).click();
		// Select Risk Profiles

		ArrayList<String> riskProfile = new ArrayList<String>(profiles);

		// profiles[] proVal =profiles.values();
		for (String Pro : riskProfile) {
			Thread.sleep(2000);
			// Selecting Profiles dynamically
			clickProfileDropDown();
			Thread.sleep(2000);
			// click categories
			if(Pro!="IP1"){
			WebElement PRO = driver.findElement(By.xpath("//*[text()='"+Pro+"']"));
			PRO.click();
			}
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.topLeftProgress")).click();
			// Setting the sheet name and columns
			wt.WT_Reader();

			// Select all the ranges
			for (int i = 2; i >= 0; i--) {
				allRanges.get(i).click();
				Thread.sleep(2000);
				try {
					driver.findElement(By.xpath("//table/tbody/tr/td")).isDisplayed();
					Thread.sleep(2000);
					wt.readWebtableValues();

				} catch (org.openqa.selenium.NoSuchElementException e) {
					System.out.println("No data present in the webtable");
				} finally {
					System.out.println("No data present in the webtable");
				}
				// If scroll is present
				System.out.println("Check Scroll present");
				try {
					WebElement scrollBar = driver.findElement(By.xpath(
							"//div[@class='scrollbar-animation scrollbar-track ng-scope ng-isolate-scope vertical']//div[starts-with(@class,'scrollbar-thumb')]"));
					Actions actions = new Actions(driver);
					actions.moveToElement(scrollBar).build().perform();
					actions.click(scrollBar).build().perform();

					Robot robot = new Robot();
					int count = 19;
					if (KPI == "Model") {
						l = 3;
					} else if (KPI == "Portfolio") {
						l = 4;
					}
					WebElement secondLastElement = driver
							.findElement(By.xpath("//table/tbody/tr[18]/td[" + l + "]/div/div/span"));
					String text17 = secondLastElement.getText();
					System.out.println("last but one number----" + text17);

					for (int i1 = 19; i1 <= count; i1++) {
						actions.moveToElement(scrollBar).build().perform();
						actions.click(scrollBar);
						// Thread.sleep(2000);
						System.out.println("Key down");
						robot.keyPress(KeyEvent.VK_DOWN);
						System.out.println("Scroll arrow down key pressed");
						// scrollBar.isEnabled();

						Thread.sleep(2000);
						WebElement lasElement = driver
								.findElement(By.xpath("//table/tbody/tr[18]/td[" + l + "]/div/div/span"));
						String text18 = lasElement.getText();
						System.out.println("last number----" + text18);

						if (text17 != text18) {
							System.out.println("Scrolled number " + count);
							lib.WT_Scroll_Reader(i1);
							count++;
							System.out.println("Last Number ---" + text18);
							text17 = text18;

						}

						else {
							lib.WT_Scroll_Last_Value_Reader(i1);
							System.out.println("Scroll completed breaked on matching values");
							break;
						}

						// String text1 = element1.getText();

					}

				}

				catch (Exception e) {
					System.out.println("Catch message>>Scroll is not present");
				}

			}
		}

	}

	// Click Categories Dropdown button
	static public void clickCategoriesDropDown() {
		WebElement catdropdown = driver.findElement(By.xpath(
				"(//div[contains(@class,'col-md-8 navBarClass')]//div[contains(@class,'navsubClass ng-binding')])[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(catdropdown).perform();
		catdropdown.click();
	}

	// Click Profile Dropdown button
	static public void clickProfileDropDown() throws InterruptedException {
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath(
				"(//div[contains(@class,'col-md-8 navBarClass')]//div[contains(@class,'navsubClass ng-binding')])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(dropdown).perform();
		dropdown.click();

	}

}
