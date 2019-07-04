package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class TEPage extends BaseTest {
	// @FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and
	// @data-valuetop1='SAA' and @data-valuedim2='TE'])[1]")
	// WebElement teSAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='TAA' and @data-valuedim2='TE'])[1]")
	WebElement teTAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Model' and @data-valuedim2='TE'])[1]")
	WebElement teModelProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio' and @data-valuedim2='TE'])[1]")
	WebElement tePortfolioProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-danger' and @data-valuetop1='MM' and @data-valuedim2='TE'])[1]")
	WebElement teRFProgressBar;

	public TEPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickTAATEProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(teTAAProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			teTAAProgressBar.click();
		}

	}

	public void clickModelTEProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(teModelProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			teModelProgressBar.click();
		}

	}

	public void clickPortfolioTEProgressbar() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(tePortfolioProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			tePortfolioProgressBar.click();
		}
	}

	public void clickRFTEProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(teRFProgressBar)).click();

			teRFProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			teRFProgressBar.click();
		}
	}

}
