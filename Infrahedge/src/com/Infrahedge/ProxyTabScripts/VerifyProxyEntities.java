package com.Infrahedge.ProxyTabScripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Infrahedge.ExceptionsTabScripts.ValidLogin;
import com.Infrahedge.PomPages.ProxyPages.ProxyPage;
import com.Infrahedge.generic.BaseTest;
import com.aventstack.extentreports.Status;

public class VerifyProxyEntities extends BaseTest {

	ProxyPage proxy = new ProxyPage(driver);

	ValidLogin login = new ValidLogin();

	@Test(priority = 0, description = "Test LogIn Page")
	public void testLogin() throws InterruptedException, IOException, AWTException {
		login.testLogin();
	}

	@Test(priority = 1, description = "Verify Proxy link_Dashboard_03")
	public void testProxyLink() throws InterruptedException {
		proxy = new ProxyPage(driver);
		proxy.clickProxyTab();

	}

	@Test(priority = 2, description = "Test AUM Element")
	public void testAUMElement() {
		// proxy = new ProxyPage(driver);
		proxy.verifyAUMElement();
	}

	@Test(priority = 3, description = "Test Accounts Element")
	public void testAccountsElement() {
		// proxy = new ProxyPage(driver);
		proxy.verifyAccountselement();
	}

	@Test(priority = 4, description = "Test Weekly Proxy Report Button")
	public void testWeeklyProxyReportButton() {
		proxy.verifyWeeklyProxyReportButton();
		WebElement newProxyElement = driver.findElement(By.xpath("//*[contains(text(),'New Proxy')]"));

		if (newProxyElement.isDisplayed()) {
			System.out.println("New Proxy is available in Weekly Proxy Report");
			test.log(Status.INFO, "New Proxy is available in Weekly Proxy Report");
		} else {
			System.out.println("New Proxy is not available in Weekly Proxy Report");
			test.log(Status.INFO, "New Proxy is not available in Weekly Proxy Report");
		}

		//Fetch New Proxy Columns	
		
		List<WebElement> newProxyHeaderNames = driver
				.findElements(By.xpath("//table[@class='table table-fixed']/thead/tr/th"));
		int newProxyColumnCount = 0;
		ArrayList<String> newProxyColumnNames = new ArrayList<String>();
		// ArrayList<String> readColNames = new ArrayList<String>();

		newProxyColumnNames.add("EXTERNAL ID");
		newProxyColumnNames.add("MM/DPM");
		newProxyColumnNames.add("IS MODEL");
		newProxyColumnNames.add("SEDOL");
		newProxyColumnNames.add("SECURITY DESCRIPTION");
		newProxyColumnNames.add("TV PROXY");
		newProxyColumnNames.add("IH PROXY");
		newProxyColumnNames.add("IH PROXY NAME");
		newProxyColumnNames.add("IH COMMENTS");
		newProxyColumnNames.add("MKT VALUE");
		newProxyColumnNames.add("ACTION");
		newProxyColumnNames.add("COMMENTS");
		System.out.println("New Proxy HeaderNames are:" + newProxyHeaderNames);

		for (int i = 0, j = 0; i < newProxyHeaderNames.size(); i++) {
			if (!(newProxyHeaderNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				newProxyHeaderNames.get(i).getText().equalsIgnoreCase(newProxyColumnNames.get(j));
				j++;
				newProxyColumnCount++;
				continue;
			}

		}

		System.out.println("The New Proxy Table has " + newProxyColumnCount + "Columns Displayed");
		test.log(Status.INFO,
				"New Proxy Table has  " + newProxyColumnCount + "Columns Displayed as : \n" + newProxyColumnNames);
		

		WebElement activeProxyElement = driver.findElement(By.xpath("//*[contains(text(),'Active Proxy')]"));

		if (activeProxyElement.isDisplayed()) {
			System.out.println("Active Proxy is available in Weekly Proxy Report");
			test.log(Status.INFO, "Active Proxy is available in Weekly Proxy Report");
		} else {
			System.out.println("Active Proxy is not available in Weekly Proxy Report");
			test.log(Status.INFO, "Active Proxy is not available in Weekly Proxy Report");
		}

	// Fetch Active Proxy Columns	
		
		List<WebElement> activeProxyHeaderNames = driver.findElements(By.xpath("//table[@dir='ltr']/tbody/tr/th"));
		int activeProxyColumnCount = 0;
		ArrayList<String> activeProxyColumnNames = new ArrayList<String>();
		ArrayList<String> readColNames = new ArrayList<String>();

		activeProxyColumnNames.add("External ID");
		activeProxyColumnNames.add("MM/DPM");
		activeProxyColumnNames.add("Is Model");
		activeProxyColumnNames.add("Security Descripsion");
		activeProxyColumnNames.add("Sedol");
		activeProxyColumnNames.add("Mkt Value");
		activeProxyColumnNames.add("Proxy Curve Name");
		activeProxyColumnNames.add("Comments");

		for (int i = 0, j = 0; i < activeProxyHeaderNames.size(); i++) {
			if (!(activeProxyHeaderNames.get(i).getText().isEmpty())) {

				// readColNames.add(web.getText());

				activeProxyHeaderNames.get(i).getText().equalsIgnoreCase(activeProxyColumnNames.get(j));
				j++;
				activeProxyColumnCount++;
				continue;
			}

		}

		System.out.println("The Active Proxy Table has " + activeProxyColumnCount + "Columns Displayed");
		test.log(Status.INFO, "Active Proxy Table has  " + activeProxyColumnCount + " Columns Displayed as : \n"
				+ activeProxyColumnNames);

	}

	@Test(priority = 5, description = "Verify when user clicks on tick mark (Approve)  button_PROXYPAGE_14")
	public void testNewProxyAcceptButton() throws IOException, InterruptedException {
		
		//try {
		WebElement actionAcceptButton = driver
				.findElement(By.xpath("//*[@id=\"yFNpbUhtableFixHead\"]/table/tbody/tr[1]/td[11]/div[4]/div[1]"));
		actionAcceptButton.click();
		String path = concatenate+takeScreenshot(driver, "Test New Proxy Action Acceptance Button");
		test.addScreenCaptureFromPath(path);
		
		WebElement textAreaInCommentSection = driver.findElement(By.xpath("//*[@id=\"proxy_new\"]/div/article/div[1]/div/div/div/div[2]/div/div[2]/div[1]/textarea"));
		textAreaInCommentSection.sendKeys("test Acceptance comments automatically");
		Thread.sleep(2000);
		path = concatenate+takeScreenshot(driver, "Test New Proxy Action Acceptance Comments");
		test.addScreenCaptureFromPath(path);
		Thread.sleep(2000);		
		WebElement submitButton = driver.findElement(By.xpath("//*[text()='Submit' and @id='yFNpbUhcomments-submit']"));
		submitButton.click();
		Thread.sleep(3000);
		path = concatenate+takeScreenshot(driver, "Test New Proxy Action Acceptance Comments");
		test.addScreenCaptureFromPath(path);
		//}
/*		catch(Exception e)
		{
			System.out.println(" Accept/Reject button not found");	
		}*/
		
	}

	@Test(priority = 6, description = "Test Regulated Fund Button")
	public void testQuarterlyProxyReportButton() throws IOException 
	{
		proxy.verifyQuarterlyProxyReportButton();
		String path = concatenate+takeScreenshot(driver, "Test Quarterly Proxy Report  Button");
		test.addScreenCaptureFromPath(path);
		WebElement actionAcceptButton = driver
				.findElement(By.xpath("//*[@id=\"yFNpbUhtableFixHead\"]/table/tbody/tr[1]/td[11]/div[4]/div[1]"));
		actionAcceptButton.click();
	}
}
