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
import com.Infrahedge.PomPages.ExceptionsPages.TEPage;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifyPortfolioTEUIEntities extends BaseTest {

	TEPage TEPage = new TEPage(driver);
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

	@Test(priority = 1, description = "TEProgress page")
	public void tesTEProgress() throws InterruptedException {
		TEPage = new TEPage(driver);
		TEPage.clickPortfolioTEProgressbar();
		Thread.sleep(5000);

	}

	@Test(priority = 2, description = "Verify column name for IP1 in Portfolio categories and KPI is TE")
	public void verfiyIP1Portfolio() throws InterruptedException {

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "Portfolio Category has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 3, description = "Verify column name for IP2 in Portfolio categories and KPI is TE")
	public void verfiyIP2Portfolio() throws InterruptedException {

		//riskProfile = "IP2";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP2']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in IP2 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in IP2 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 4, description = "Verify column name for IP3 in Portfolio categories and KPI is TE")
	public void verfiyIP3Portfolio() throws InterruptedException {

		//riskProfile = "IP3";

		clickRiskProfileDropDown();
		Thread.sleep(3000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP3']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in IP3 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in IP3 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 5, description = "Verify column name for IP4 in Portfolio categories and KPI is TE")
	public void verfiyIP4Portfolio() throws InterruptedException {

		// riskProfile = "IP4";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP4']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in IP4 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in IP4 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 6, description = "Verify column name for IP5 in Portfolio categories and KPI is TE")
	public void verfiyIP5Portfolio() throws InterruptedException {

		// riskProfile = "IP5";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP5']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in IP5 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in IP5 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 7, description = "Verify column name for Charities in Portfolio categories and KPI is TE")
	public void verfiyCharitiesPortfolio() throws InterruptedException {

		// riskProfile = "Charities";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Charities']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in Charities has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in Charities has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 8, description = "Verify column name for Dynamic in Portfolio categories and KPI is TE")
	public void verfiyDynamicPortfolio() throws InterruptedException {

		// riskProfile = "Dynamic";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Dynamic']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");
		categoryColumnNames.add("Portfolio TE to TAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 9, description = "Verify column name for GAF in Portfolio categories and KPI is TE")
	public void verfiyGAFPortfolio() throws InterruptedException {

		// riskProfile = "GAF";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='GAF']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Fund Benchmark");
		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in GAF has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in GAF has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 10, description = "Verify column name for IMP in Portfolio categories and KPI is TE")
	public void verfiyIMPPortfolio() throws InterruptedException, IOException {

		// riskProfile = "IMP";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IMP']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Fund Benchmark");
		categoryColumnNames.add("IMP Name");
		categoryColumnNames.add("TE to SAA");
		categoryColumnNames.add("Associated SAA");
		categoryColumnNames.add("Associated TAA");
		categoryColumnNames.add("Associated Model");
		categoryColumnNames.add("Portfolio");
		categoryColumnNames.add("Portfolio TE to SAA");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Portfolio Category in IMP has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Portfolio Category in IMP has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);
		// Take screen shot
		String path = concatenate + takeScreenshot(driver, "In IMP Category");
		test.addScreenCaptureFromPath(path);
//						click Exceptions SUMMARY 		
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);

	}

}
