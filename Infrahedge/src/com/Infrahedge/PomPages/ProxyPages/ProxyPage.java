package com.Infrahedge.PomPages.ProxyPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

public class ProxyPage extends com.Infrahedge.generic.BaseTest {

	@FindBy(xpath = "//div['current-selections']//preceding-sibling::span[text()='Proxy']")
	WebElement proxyTab;

	@FindBy(xpath = "//*[text()='AUM']")
	WebElement AUMelement;

	@FindBy(xpath = "//*[text()='Accounts']")
	WebElement Accountselement;

	@FindBy(xpath = "//*[@class='fa fa-filter']")
	WebElement filterICon;

	@FindBy(xpath = "//*[@id='selected_date']")
	WebElement lastRunServerDate;

	@FindBy(xpath = "//*[text()='Clear All']")
	WebElement clearAll;
	
	@FindBy(xpath = "//input[@name='radioB' and @value = 'weekly']")
	WebElement weeklyProxyReportButton;
	
	@FindBy(xpath = "//input[@name='radioB' and @value = 'quarterly']")
	WebElement quarterlyProxyReportButton;
	

	public ProxyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickProxyTab() throws InterruptedException {
		
		Thread.sleep(10000);
		// WebDriverWait wait = new WebDriverWait(driver, 1);
		String title = driver.getTitle();
		System.out.println("title++++" + title);
		System.out.println(proxyTab.isDisplayed());
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", proxyTab);
		test.log(Status.INFO, "Clicked on Proxy Tab !!");

	}

	public void verifyAUMElement() {
		if (AUMelement.isDisplayed()) {
			String text = driver.findElement(By.xpath("//*[text()='AUM']/following-sibling::span")).getText();
			System.out.println("AUM element is displayed !!");
			test.log(Status.INFO, "AUM element is displayed as : "  +text);
		}

		else {
			System.out.println("AUM element is not displayed !!");
			test.log(Status.INFO, "AUM element is not displayed !!");
		}
	}

	public void verifyAccountselement() {
		if (Accountselement.isDisplayed()) {
			String text = driver.findElement(By.xpath("//*[text()='Accounts']/following-sibling::span")).getText();
			System.out.println("Accounts element is displayed !!");
			test.log(Status.INFO, "Accounts element is displayed as : "  +text);
		}

		else {
			System.out.println("Accounts element is not displayed !!");
			test.log(Status.INFO, "Accounts element is not displayed !!");
		}
	}

	public void verifyfilterICon() {
		if (filterICon.isDisplayed()) {
			System.out.println("filterICon is displayed !!");
			test.log(Status.INFO, "filterICon is displayed !!");

		}

		else {
			System.out.println("filterICon is not displayed  !!");
			test.log(Status.INFO, "filterICon is not displayed !!");
		}
	}

	public void lastRunServerDate() {
		if (lastRunServerDate.isDisplayed()) {

			System.out.println("Report date is-->" + lastRunServerDate.getAttribute("day"));
			test.log(Status.INFO, "Report Published Date is:" + lastRunServerDate.getAttribute("day"));
		}

		else {
			System.out.println("lastRunServerDate is not displayed !!");
		}
	}

	public void clickFilterIcon() {
		filterICon.click();
		test.log(Status.INFO, "filterICon is clicked !!");

	}

	public void clickClearAll() {
		clearAll.click();

	}

	public void verifyWeeklyProxyReportButton()
	{
		if(weeklyProxyReportButton.isDisplayed())
		{
			System.out.println("Weekly Proxy Report is selected !!");
			test.log(Status.INFO, "Weekly Proxy Report is selected !!");
		}
		
		else
		{
			System.out.println("Weekly Proxy Report is not selected  !!");
			test.log(Status.INFO, "Weekly Proxy Report is selected by default !!");
		}
	}
	
	public void verifyQuarterlyProxyReportButton()
	{
/*		if(quarterlyProxyReportButton.isDisplayed())
		{*/
			quarterlyProxyReportButton.click();
			System.out.println("Quarterly Proxy Report is selected !!");
			test.log(Status.INFO, "Quarterly Proxy Report is selected !!");
		//}
		
/*		else
		{
			System.out.println("Quarterly Proxy Report is not selected  !!");
			test.log(Status.INFO, "Quarterly Proxy Report is not selected !!");
		}*/
	}
	
}
