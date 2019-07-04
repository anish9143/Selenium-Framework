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
import com.Infrahedge.PomPages.ExceptionsPages.VolatilityPage;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifySAAVolatilityUIEntities extends BaseTest {

	VolatilityPage volPage = new VolatilityPage(driver);

	ValidLogin login = new ValidLogin();

	public static void  clickRiskProfileDropDown() {

		WebElement riskProfileDropdown = driver.findElement(By.xpath("(//div[@class='navsubClass ng-binding'])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(riskProfileDropdown).perform();
		riskProfileDropdown.click();
	}
	

	

	@Test(priority = 0, description = "Test LogIn Page")
	public void testLogin() throws InterruptedException, IOException, AWTException {
		login.testLogin();
	}

	@Test(priority = 1, description = "Volatility Progress")
	public void testVolProgress() {
		volPage = new VolatilityPage(driver);
		volPage.clickSAAVolProgressBar();
	}

	@Test(priority = 2, description = "Verify Column Names for IP1 In SAA category and KPI is Volatility")
	public void verifyIP1SAA() throws InterruptedException {

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	}

	@Test(priority = 3, description = "Verify Column Names for IP2 In SAA category and KPI is Volatility")
	public void verfiyIP2SAA() throws InterruptedException {
		String riskProfile = "IP2";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='"+riskProfile+"']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP2 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in IP2 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	}
	
	@Test(priority = 4, description = "Verify Column Names for IP3 In SAA category and KPI is Volatility")
	public void verfiyIP3SAA() throws InterruptedException
	{

		String riskProfile = "IP3";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP3']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP3 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in IP3 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	
	
	@Test(priority = 5, description = "Verify Column Names for IP4 In SAA category and KPI is Volatility")
	public void verfiyIP4SAA() throws InterruptedException
	{

		String riskProfile = "IP4";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP4']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP4 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in IP4 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	
	@Test(priority = 6, description = "Verify Column Names for IP5 In SAA category and KPI is Volatility")
	public void verfiyIP5SAA() throws InterruptedException
	{

		String riskProfile = "IP5";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IP5']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IP5 has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in IP5 has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	@Test(priority = 7, description = "Verify Column Names for Charities In SAA category and KPI is Volatility")
	public void verfiyCharitiesSAA() throws InterruptedException
	{

		String riskProfile = "Charities";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Charities']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in Charities has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in Charities has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	@Test(priority = 8, description = "Verify Column Names for Dynamic In SAA category and KPI is Volatility")
	public void verfiyDynamicSAA() throws InterruptedException
	{

		String riskProfile = "Dynamic";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='Dynamic']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in Dynamic has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in Dynamic has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	
	@Test(priority = 9, description = "Verify Column Names for GAF In SAA category and KPI is Volatility")
	public void verfiyGAFSAA() throws InterruptedException
	{

		String riskProfile = "GAF";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='GAF']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("GAF Volatility");
		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in GAF has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in GAF has  " + columnCount + " Columns Displayed as : \n" + readColNames);

	
	}
	
	@Test(priority = 10, description = "Verify Column Names for IMP In SAA category and KPI is Volatility")
	public void verfiyIMPSAA() throws InterruptedException, IOException
	{

		String riskProfile = "IMP";

		clickRiskProfileDropDown();
		Thread.sleep(2000);
		WebElement profile = driver.findElement(By.xpath("//*[text()='IMP']"));
		profile.click();

		// to come out of Drop Down
		driver.findElement(By.xpath("//*[@class='topLeftProgress']")).click();
		Thread.sleep(2000);

		List<WebElement> columnNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int columnCount = 0;
		ArrayList<String> categoryColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		categoryColumnNames.add("IMP Name");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("IMP Volatility");
		categoryColumnNames.add("SAA");
		categoryColumnNames.add("SAA Volatility");
		categoryColumnNames.add("SAA AC Volatility");

		for (int i = 0, j = 0; i < columnNames.size(); i++) {
			if (!(columnNames.get(i).getText().isEmpty())) {

				readColNames.add(columnNames.get(i).getText());

				columnNames.get(i).getText().equalsIgnoreCase(categoryColumnNames.get(j));
				j++;
				columnCount++;
				continue;

			}
		}
		System.out.println("SAA Category in IMP has " + columnCount + "Columns Displayed");
		test.log(Status.INFO, "SAA Category in IMP has  " + columnCount + " Columns Displayed as : \n" + readColNames);

		String path = concatenate+takeScreenshot(driver, "In IMP Category");
		test.addScreenCaptureFromPath(path);
		
		
/*//		click Exceptions Summary 		
		driver.findElement(By.xpath("//*[text()='Exceptions Summary ']")).click();
		Thread.sleep(2000);*/
	
	}
	


}