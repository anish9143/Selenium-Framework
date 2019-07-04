package com.Infrahedge.ExceptionUIScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.ExceptionsPages.VarPage;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifyRFVarUIEntities extends BaseTest {

	VarPage varPage = new VarPage(driver);
	ValidLogin login = new ValidLogin();

	public void clickRiskProfileDropDown() {

		WebElement riskProfileDropdown = driver.findElement(By.xpath("(//div[@class='navsubClass ng-binding'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(riskProfileDropdown).perform();
		riskProfileDropdown.click();
	}

	@Test(priority = 0, description = "testlogin page")
	public void testLogin() throws InterruptedException, IOException, AWTException {
		login.testLogin();

	}

	@Test(priority = 1, description = "VarProgress page")
	public void tesVarProgress() throws InterruptedException {
		varPage = new VarPage(driver);
		varPage.clickRFVarProgressBar();
		Thread.sleep(5000);

	}

	@Test(priority = 2, description = "Verify column name for IP1 in RF categories and KPI is VaR")
	public void verfiyIP1RF() throws InterruptedException {

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 3, description = "Verify column name for IP2 in SAA categories and KPI is VaR")
	public void verfiyIP2RF() throws InterruptedException {

		String riskProfile = "IP2";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP2']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(3000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP2 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in IP2 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 4, description = "Verify column name for IP3 in RF categories and KPI is VaR")
	public void verfiyIP3RF() throws InterruptedException {

		String riskProfile = "IP3";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP3']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(3000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP3 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in IP3 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 5, description = "Verify column name for IP4 in SAA categories and KPI is VaR")
	public void verfiyIP4RF() throws InterruptedException {

		String riskProfile = "IP4";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP4']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(3000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP4 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in IP4 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 6, description = "Verify column name for IP5 in RF categories and KPI is VaR")
	public void verfiyIP5RF() throws InterruptedException {

		String riskProfile = "IP5";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP5']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(3000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP5 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in IP5 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 7, description = "Verify column name for Charities in RF categories and KPI is VaR")
	public void verfiyCharitiesRF() throws InterruptedException {

		String riskProfile = "Charities";

		clickRiskProfileDropDown();
		Thread.sleep(7000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Charities']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(7000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in Charities has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in Charities has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 8, description = "Verify column name for Dynamic in RF categories and KPI is VaR")
	public void verfiyDynamicRF() throws InterruptedException {

		String riskProfile = "Dynamic";

		clickRiskProfileDropDown();
		Thread.sleep(5000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Dynamic']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(5000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("TAA VaR");
		categoryColumnNames.add("VaR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 9, description = "Verify column name for GAF in RF categories and KPI is VaR")
	public void verfiyGAFRF() throws InterruptedException {

		String riskProfile = "GAF";

		clickRiskProfileDropDown();
		Thread.sleep(5000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='GAF']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(5000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Currency");
		categoryColumnNames.add("RPF / GAF");
		categoryColumnNames.add("SAA VaR");
		categoryColumnNames.add("GAF VAR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in GAF has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in GAF has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 10, description = "Verify column name for IMP in RF categories and KPI is VaR")
	public void verfiyIMPRF() throws InterruptedException, IOException {

		String riskProfile = "IMP";

		clickRiskProfileDropDown();
		Thread.sleep(5000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IMP']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(5000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("IMP Name");
		categoryColumnNames.add("SAA VAR");
		categoryColumnNames.add("IMP VAR");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IMP has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"SAA Category in IMP has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);
		// Take screen shot
		String path = concatenate + takeScreenshot(driver, "In IMP Category");
		test.addScreenCaptureFromPath(path);
//						click Exceptions SUMMARY 		
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(3000);

	}

}
