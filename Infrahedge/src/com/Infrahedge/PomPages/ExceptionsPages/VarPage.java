package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class VarPage extends BaseTest {
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='SAA' and @data-valuedim2='VaR'])[1]")
	WebElement varSAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='TAA' and @data-valuedim2='VaR'])[1]")
	WebElement varTAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Model' and @data-valuedim2='VaR'])[1]")
	WebElement varModelProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio' and @data-valuedim2='VaR'])[1]")
	WebElement varPortfolioProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='MM' and @data-valuedim2='VaR'])[1]")
	WebElement varRFProgressBar;

	public VarPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickSAAVarProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(varSAAProgressBar)).click();

			
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			//driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']"));
			varSAAProgressBar.click();
		}

	}

	public void clickTAAVarProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(varTAAProgressBar)).click();

			
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			
			varTAAProgressBar.click();
		}

	}

	public void clickModelVarProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(varModelProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			varModelProgressBar.click();
		}

	}

	public void clickPortfolioVarProgressBar() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(varPortfolioProgressBar)).click();

			
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			varPortfolioProgressBar.click();
		}
	}

	public void clickRFVarProgressBar() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(varRFProgressBar)).click();

			
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			varRFProgressBar.click();
		}
	}

}
