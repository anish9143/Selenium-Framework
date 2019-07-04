package com.Infrahedge.ExposureTabScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.ExposurePages.ExposurePage;
import com.Infrahedge.generic.BaseTest;

public class VerifyExposureBIEntity extends BaseTest {

	ExposurePage exposure = new ExposurePage(driver);
	
	ValidLogin login = new ValidLogin();
	
	String nameofCurrMethod = new Exception() 
            .getStackTrace()[0] 
            .getMethodName();
	
	@Test(priority = 0,description="Test LogIn Page")
	
	public void testLogin() throws InterruptedException, IOException, AWTException
	{
		login.testLogin();
	}

	@Test(priority = 1,description="Test Exposure Link")
	public void testExposureLink() throws InterruptedException, IOException {
		exposure= new ExposurePage(driver);
		exposure.clickExposureTab();
		String path = concatenate+takeScreenshot(driver, "Exposure Tab");
		test.addScreenCaptureFromPath(path);
		

	}

	@Test(priority = 2,description="Check for AUM element on the page")
	public void testAUMElement() {
		exposure.verifyAUMElement();
		
	}

	@Test(priority = 3,description="Check for Accounts element on the page")
	public void testAccountsElement() {
		exposure.verifyAccountselement();
		
	}

	@Test(priority = 4,description="Test BI Button")
	public void testBIButton() {
		exposure.verifyBIbutton();
		
	}

	@Test(priority = 5,description="Test Filter Icon")
	public void testFilterIcon() {

		exposure.verifyfilterICon();
		
	}

	@Test(priority = 6,description="Check Exposure SubTab")
	public void testExposureSubTab() {
		exposure.exposureSubTab();
		
	}

	@Test(priority = 7,description="Check Search Sub Tab")
	public void testSearchSubTab() {
		exposure.searchSubTab();
	}

	@Test(priority = 8,description="Report Published Date")

	public void testLastRunServerDate() {
		exposure.lastRunServerDate();
	}

	@Test(priority = 9,description="Check Filter Options Available")

	public void testModelAndAccounNumberElements() {
		exposure.clickFilterIcon();
		exposure.verifyModelElement();
		exposure.verifyAccountNumberElement();
	}

	@Test(priority = 10,description="Check List of Models available in filter")
	public void testModelList() throws InterruptedException, IOException {
		exposure.clickModelElement();

		List<WebElement> modelData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		System.out.println(modelData.size());
		String current;
		WebElement webElement;
		
	/*	try
		{*/
		for ( int i =0 ; i<modelData.size();i++) {
			webElement = modelData.get(i);
			System.out.println(modelData.indexOf(webElement));
			current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();
			
			System.out.println(current);
			// if(current==)
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			Thread.sleep(6000);
			String path = concatenate+takeScreenshot(driver, "Model Options");
			test.addScreenCaptureFromPath(path);
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			//Thread.sleep(5000);
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			Thread.sleep(5000);
			modelData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		
		}
	/*	}
		catch(Exception e)
		{
			System.out.println("No further elements found");
			
		}*/
		Thread.sleep(10000);
		exposure.clickClearAll();
	}
	
	@Test(priority = 11,description="Check List of Account Number available in filter")
	public void testAccountList() throws InterruptedException
	{
		exposure.clickFilterIcon();
		exposure.clickAccountNumberElement();
		List<WebElement> accountNumberData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		System.out.println(accountNumberData.size());
		String current;
		WebElement webElement;
		
		
		try
		{
		for ( int i =0 ; i<accountNumberData.size();i++) {
			webElement = accountNumberData.get(i);
			System.out.println(accountNumberData.indexOf(webElement));
			current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();
			
			System.out.println(current);
			// if(current==)
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			Thread.sleep(6000);
			
			
			String path = concatenate+takeScreenshot(driver, "AccountNumber Options");
			test.addScreenCaptureFromPath(path);
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			//Thread.sleep(5000);
			webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
			Thread.sleep(5000);
			accountNumberData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		
		}
		}
		catch(Exception e)
		{
			System.out.println("No further elements found");
			
		}
		Thread.sleep(10000);
		exposure.clickClearAll();
	}
	
	@Test(priority = 12, description = "Check list of Accounts In SearchSubTab filter options")
	public void testSearchSubTabAccountOption() throws IOException, InterruptedException {
		exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement accountOption = driver.findElement(By.xpath("//*[text()='Account' and @title='Account']"));

		accountOption.click();

		List<WebElement> accountOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		System.out.println(accountOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < accountOptionData.size(); i++) {
				webElement = accountOptionData.get(i);
				System.out.println(accountOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Account Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				// Thread.sleep(5000);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				accountOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();
	}

	@Test(priority = 13, description = "Check list of Sectors In SearchSubTab filter options")
	public void testSearchSubTabSectorOption() throws IOException, InterruptedException {

		// exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement sectorOption = driver.findElement(By.xpath("//*[text()='Sector' and @title='Sector']"));

		sectorOption.click();
		
		List<WebElement> sectorOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		System.out.println(sectorOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < sectorOptionData.size(); i++) {
				webElement = sectorOptionData.get(i);
				System.out.println(sectorOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Sector Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				// Thread.sleep(5000);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				sectorOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();

	}
	@Test(priority = 14, description = "Check list of Country In SearchSubTab filter options")
	public void testSearchSubTabCountryOption() throws IOException, InterruptedException 
	{
		// exposure.clickSearchSubTab();
				String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
				test.addScreenCaptureFromPath(path);
				exposure.clickFilterIcon();

				WebElement countryOption = driver.findElement(By.xpath("//*[text()='Country' and @title='Country']"));

				countryOption.click();
				List<WebElement> countryOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				System.out.println(countryOptionData.size());
				String current;
				WebElement webElement;

				try {
					for (int i = 0; i < countryOptionData.size(); i++) {
						webElement = countryOptionData.get(i);
						System.out.println(countryOptionData.indexOf(webElement));
						current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
						// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

						System.out.println(current);
						// if(current==)
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);

						driver.findElement(By.xpath("//*[text()='Submit']")).click();
						// *[text()='Submit']
						Thread.sleep(5000);
						path = concatenate+takeScreenshot(driver, "Country Options");
						test.addScreenCaptureFromPath(path);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						// Thread.sleep(5000);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);
						countryOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));

					}
				} catch (Exception e) {
					System.out.println("No further elements found");

				}
				Thread.sleep(10000);
				exposure.clickClearAll();
	}
	
	
	@Test(priority = 15, description = "Check list of Credit Rating In SearchSubTab filter options")
	public void testSearchSubTabCreditRatingOption() throws InterruptedException, IOException
	
	{

		// exposure.clickSearchSubTab();
				String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
				test.addScreenCaptureFromPath(path);
				exposure.clickFilterIcon();

				WebElement creditRatingOption = driver.findElement(By.xpath("//*[text()='Credit Rating' and @title='Credit Rating']"));

				creditRatingOption.click();
				List<WebElement> creditRatingOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				System.out.println(creditRatingOptionData.size());
				String current;
				WebElement webElement;

				try {
					for (int i = 0; i < creditRatingOptionData.size(); i++) {
						webElement = creditRatingOptionData.get(i);
						System.out.println(creditRatingOptionData.indexOf(webElement));
						current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
						// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

						System.out.println(current);
						// if(current==)
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);

						driver.findElement(By.xpath("//*[text()='Submit']")).click();
						// *[text()='Submit']
						Thread.sleep(5000);
						path = concatenate+takeScreenshot(driver, "Credit Rating");
						test.addScreenCaptureFromPath(path);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);
						path = concatenate+takeScreenshot(driver, "Model Options");
						test.addScreenCaptureFromPath(path);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(10000);
						creditRatingOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
						path = concatenate+takeScreenshot(driver, "Credit Rating");
						test.addScreenCaptureFromPath(path);

					}
				} catch (Exception e) {
					System.out.println("No further elements found");

				}
				Thread.sleep(10000);
				exposure.clickClearAll();
	
	}
	@Test(priority = 16, description = "Check list of Region In SearchSubTab filter options")
	public void testSearchSubTabRegionOption() throws IOException, InterruptedException
	{


		// exposure.clickSearchSubTab();
				String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
				test.addScreenCaptureFromPath(path);
				exposure.clickFilterIcon();

				WebElement regionOption = driver.findElement(By.xpath("//*[text()='Region' and @title='Region']"));

				regionOption.click();
				List<WebElement> regionOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				System.out.println(regionOptionData.size());
				String current;
				WebElement webElement;

				try {
					for (int i = 0; i < regionOptionData.size(); i++) {
						webElement = regionOptionData.get(i);
						System.out.println(regionOptionData.indexOf(webElement));
						current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
						// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

						System.out.println(current);
						// if(current==)
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);

						driver.findElement(By.xpath("//*[text()='Submit']")).click();
						// *[text()='Submit']
						Thread.sleep(5000);
						path = concatenate+takeScreenshot(driver, "Region");
						test.addScreenCaptureFromPath(path);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(5000);
						path = concatenate+takeScreenshot(driver, "Region Options");
						test.addScreenCaptureFromPath(path);
						webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
						Thread.sleep(10000);
						regionOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
						path = concatenate+takeScreenshot(driver, "Region");
						test.addScreenCaptureFromPath(path);

					}
				} catch (Exception e) {
					System.out.println("No further elements found");

				}
				Thread.sleep(10000);
				exposure.clickClearAll();
	
	
	}
	@Test(priority = 17, description = "Check list of ISIN In SearchSubTab filter options")
	public void testSearchSubTabISINOption() throws IOException, InterruptedException {

		// exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement ISINOption = driver.findElement(By.xpath("//*[text()='ISIN' and @title='ISIN']"));

		ISINOption.click();
		List<WebElement> ISINOptionData = driver.findElements(By.xpath("//li[@tabindex='-1'][2]"));
		System.out.println(ISINOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < ISINOptionData.size(); i++) {
				webElement = ISINOptionData.get(i);
				System.out.println(ISINOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "ISIN");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "ISIN Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(10000);
				ISINOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				path = concatenate+takeScreenshot(driver, "ISIN");
				test.addScreenCaptureFromPath(path);

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();

	}
	@Test(priority = 18, description = "Check list of SEDOL In SearchSubTab filter options")
	public void testSearchSubTabSEDOLOption() throws IOException, InterruptedException {

		//exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement SEDOLOption = driver.findElement(By.xpath("//*[text()='SEDOL' and @title='SEDOL']"));

		SEDOLOption.click();
		List<WebElement> SEDOLOptionData = driver.findElements(By.xpath("//li[@tabindex='-1'][2]"));
		System.out.println(SEDOLOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < SEDOLOptionData.size(); i++) {
				webElement = SEDOLOptionData.get(i);
				System.out.println(SEDOLOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "SEDOL");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "SEDOL Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(10000);
				SEDOLOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				path = concatenate+takeScreenshot(driver, "SEDOL");
				test.addScreenCaptureFromPath(path);

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();

	}
	
	
	@Test(priority = 19, description = "Check list of Ticker In SearchSubTab filter options")
	public void testSearchSubTabTickerOption() throws IOException, InterruptedException {

		// exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement TickerOption = driver.findElement(By.xpath("//*[text()='Ticker ' and @title='Ticker ']"));

		TickerOption.click();
		List<WebElement> TickerOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
		System.out.println(TickerOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < TickerOptionData.size(); i++) {
				webElement = TickerOptionData.get(i);
				System.out.println(TickerOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Ticker");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Ticker Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(10000);
				TickerOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				path = concatenate+takeScreenshot(driver, "Ticker");
				test.addScreenCaptureFromPath(path);

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();

	}

	
	@Test(priority = 20, description = "Check list of Holdings In SearchSubTab filter options")
	public void testSearchSubTabHoldingsOption() throws IOException, InterruptedException {

		//exposure.clickSearchSubTab();
		String path = concatenate+takeScreenshot(driver, "In SearchSubTab");
		test.addScreenCaptureFromPath(path);
		exposure.clickFilterIcon();

		WebElement HoldingsOption = driver.findElement(By.xpath("//*[text()='Holdings' and @title='Holdings']"));

		HoldingsOption.click();
		List<WebElement> HoldingsOptionData = driver.findElements(By.xpath("//li[@tabindex='-1'][2]"));
		System.out.println(HoldingsOptionData.size());
		String current;
		WebElement webElement;

		try {
			for (int i = 0; i < HoldingsOptionData.size(); i++) {
				webElement = HoldingsOptionData.get(i);
				System.out.println(HoldingsOptionData.indexOf(webElement));
				current = webElement.findElement(By.xpath(".//div[2]//span[1]")).getAttribute("title");
				// current = webElement.findElement(By.xpath(".//div[2]//span/span")).getText();

				System.out.println(current);
				// if(current==)
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[text()='Submit']")).click();
				// *[text()='Submit']
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Holdings");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(5000);
				path = concatenate+takeScreenshot(driver, "Holdings Options");
				test.addScreenCaptureFromPath(path);
				webElement.findElement(By.xpath(".//div[2]//span[1]")).click();
				Thread.sleep(10000);
				HoldingsOptionData = driver.findElements(By.xpath("//li[@tabindex='-1']"));
				path = concatenate+takeScreenshot(driver, "Holdings");
				test.addScreenCaptureFromPath(path);

			}
		} catch (Exception e) {
			System.out.println("No further elements found");

		}
		Thread.sleep(10000);
		exposure.clickClearAll();

	}

	
	
}
