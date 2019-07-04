package com.Infrahedge.PomPages.ExceptionsPages;

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

public class IPModelLiquidity extends BaseTest {

	LiquidityPage lPage = new LiquidityPage(driver);
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

	@Test(priority = 1, description = "LiquidityProgress page")
	public void tesVarProgress() throws InterruptedException {
		lPage = new LiquidityPage(driver);
		lPage.clickModelLiquiProgressBar();
		Thread.sleep(3000);

	}

	@Test(priority = 2, description = "Verify column name for IP1 in Model categories and KPI is Liquidity")
	public void verfiyIP1Model() throws InterruptedException {

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "Model Category has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 3, description = "Verify column name for IP2 in SAA categories and KPI is Liquidity")
	public void verfiyIP2Model() throws InterruptedException {

		//riskProfile = "IP2";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP2']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in IP2 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model category in IP2 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 4, description = "Verify column name for IP3 in Model categories and KPI is Liquidity")
	public void verfiyIP3Model() throws InterruptedException {

		//riskProfile = "IP3";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP3']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table/tbody/tr[1]/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		System.out.println(columnNames.size());

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in IP3 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model Category in IP3 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 5, description = "Verify column name for IP4 in SAA categories and KPI is Liquidity")
	public void verfiyIP4Model() throws InterruptedException {

		//riskProfile = "IP4";

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

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

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

	@Test(priority = 6, description = "Verify column name for IP5 in Model categories and KPI is VaR")
	public void verfiyIP5Model() throws InterruptedException {

		//riskProfile = "IP5";

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

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in IP5 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model Category in IP5 has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 7, description = "Verify column name for Charities in Model categories and KPI is Liquidity")
	public void verfiyCharitiesModel() throws InterruptedException {

		//riskProfile = "Charities";

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

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in Charities has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model Category in Charities has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 8, description = "Verify column name for Dynamic in Model categories and KPI is Liquidity")
	public void verfiyDynamicModel() throws InterruptedException {

		//riskProfile = "Dynamic";

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

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}

	@Test(priority = 9, description = "Verify column name for GAF in Model categories and KPI is Liquidity")
	public void verfiyGAFModel() throws InterruptedException {

		//riskProfile = "GAF";

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

		categoryColumnNames.add("Category");
		categoryColumnNames.add("Model");
		categoryColumnNames.add("Normal Liquidity 1 day");
		categoryColumnNames.add("Normal Liquidity 3 day");
		categoryColumnNames.add("Normal Liquidity 5 day");
		categoryColumnNames.add("Normal Liquidity 10 day");
		categoryColumnNames.add("Normal Liquidity 20 day");
		categoryColumnNames.add("Normal Illiquid");
		categoryColumnNames.add("Stressed Liquidity 1 day");
		categoryColumnNames.add("Stressed Liquidity 3 day");
		categoryColumnNames.add("Stressed Liquidity 5 day");
		categoryColumnNames.add("Stressed Liquidity 10 day");
		categoryColumnNames.add("Stressed Liquidity 20 day");
		categoryColumnNames.add("Stressed Illiquid");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("Model Category in GAF has " + columnCount + "Columns Displayed");
		test.log(Status.INFO,
				"Model Category in GAF has  " + columnCount + " Columns Displayed as : \n" + categoryColumnNames);

	}


}

