package com.Infrahedge.ExceptionsTabScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.ExceptionsPages.LiquidityPage;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifyRFTEAssetsUIEntities extends BaseTest {

	LiquidityPage lPage = new LiquidityPage(driver);

	ValidLogin login = new ValidLogin();

	public static void clickRiskProfileDropDown() {

		WebElement riskProfileDropdown = driver.findElement(By.xpath("(//div[@class='navsubClass ng-binding'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(riskProfileDropdown).perform();
		riskProfileDropdown.click();
	}

	@Test(priority = 0, description = "Test LogIn Page")
	public void testLogin() throws InterruptedException, IOException, AWTException {
		login.testLogin();

	}

	@Test(priority = 1, description = "TE Progress")
	public void testVolProgress() {
		lPage = new LiquidityPage(driver);
		lPage.clickTERFProgressBar();
	}

	@Test(priority = 2, description = "Verify Assets UI elements for IP1 In RF category and KPI is TE")
	public void verifyIP1RFAssets() throws InterruptedException, IOException {

		Thread.sleep(3000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		Thread.sleep(3000);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());
		Thread.sleep(3000);
		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");
		

		for (int i = 0, j = 0; i < columnNames.size() && j < categoryColumnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}

		System.out.println(readColNames);
		System.out.println("RF Category in IP1 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in IP1 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}

	@Test(priority = 3, description = "Verify Assets UI elements for IP2 In RF category and KPI is TE")
	public void verifyIP2RFAssets() throws InterruptedException, IOException {

		String riskProfile = "IP2";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in IP2 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in IP2 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	@Test(priority = 4, description = "Verify Assets UI elements for IP3 In RF category and KPI is TE")
	public void verifyIP3RFAssets() throws InterruptedException, IOException {

		String riskProfile = "IP3";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in IP3 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in IP3 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	@Test(priority = 5, description = "Verify Assets UI elements for IP4 In RF category and KPI is TE")
	public void verifyIP4RFAssets() throws InterruptedException, IOException {

		String riskProfile = "IP4";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in IP4 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in IP4 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	@Test(priority = 5, description = "Verify Assets UI elements for IP5 In RF category and KPI is TE")
	public void verifyIP5RFAssets() throws InterruptedException, IOException {

		String riskProfile = "IP5";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in IP5 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in IP5 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	
	@Test(priority = 6, description = "Verify Assets UI elements for IP5 In RF category and KPI is TE")
	public void verifyDynamicRFAssets() throws InterruptedException, IOException {

		String riskProfile = "Dynamic";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	
	@Test(priority = 7, description = "Verify Assets UI elements for IP5 In RF category and KPI is TE")
	public void verifyGAFRFAssets() throws InterruptedException, IOException {

		String riskProfile = "GAF";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	
	@Test(priority = 8, description = "Verify Assets UI elements for IP5 In RF category and KPI is TE")
	public void verifyIMPRFAssets() throws InterruptedException, IOException {

		String riskProfile = "IMP";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
	
	@Test(priority = 9, description = "Verify Assets UI elements for IP5 In RF category and KPI is TE")
	public void verifyCharitiesRFAssets() throws InterruptedException, IOException {

		String riskProfile = "Charities";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='" + riskProfile + "']"));
		profile.click();
		Thread.sleep(3000);
		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		Thread.sleep(2000);
		WebElement tAAElement = driver.findElement(By.xpath("//*[@id='QV019']//table/tbody/tr/td[2]"));

		tAAElement.click();
		Thread.sleep(3000);
		// Selecting From Settings Button
		WebElement settingsIcon = driver.findElement(By.xpath("(//*[@class='navSettingClass'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(settingsIcon).perform();
		Thread.sleep(3000);
		settingsIcon.click();
		String path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);
		List<WebElement> settingsColumns = driver
				.findElements(By.xpath("//input[@type='checkbox' and @ng-checked='0']")); // /following-sibling::label
		System.out.println(settingsColumns.size());
		for (WebElement column : settingsColumns) {
			System.out.println(column.findElement(By.xpath("./following-sibling::label")).getText());
			column.findElement(By.xpath("./following-sibling::label")).click();
		}

		// To come out of Settings

		WebElement collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));
		collpaseAll.click();

		Thread.sleep(3000);

		// Verifying Column Names in Asset Page
		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("SAA Weight");
		categoryColumnNames.add("TAA Weight");
		categoryColumnNames.add("Weight");
		categoryColumnNames.add("SAA Selection");
		categoryColumnNames.add("SAA Allocation");
		categoryColumnNames.add("TAA Selection");
		categoryColumnNames.add("TAA Allocation");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().trim().isEmpty())) {

				readColNames.add(columnNames.get(i).getText().toString());
				// System.out.println(columnNames.get(i));
				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println(readColNames);
		System.out.println("RF Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "RF Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		// Verifying Expand All Button
		Thread.sleep(5000);
		WebElement expandAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]"));

		expandAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		Thread.sleep(5000);
		collpaseAll = driver
				.findElement(By.xpath("(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]"));

		collpaseAll.click();

		path = concatenate + takeScreenshot(driver, "In RF Category");
		test.addScreenCaptureFromPath(path);

		// navigates to previous page
		WebElement assetDropDown = driver.findElement(By.xpath("(//*[text()='Regulated Fund'])[2]"));
		assetDropDown.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();

	}
}
