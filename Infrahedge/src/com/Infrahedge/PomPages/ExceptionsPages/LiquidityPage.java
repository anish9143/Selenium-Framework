package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Infrahedge.generic.BaseTest;

public class LiquidityPage extends BaseTest{
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Model' and @data-valuedim2='Liquidity'])[1]")
	WebElement liquiModelProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio' and @data-valuedim2='Liquidity'])[1]")
	WebElement liquiPortfolioProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='MM' and @data-valuedim2='Liquidity'])[1]")
	WebElement liquiRFProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='TAA' and @data-valuedim2='TE'])[1]")
	WebElement TETAAProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Model' and @data-valuedim2='TE'])[1]")
	WebElement TEModelProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio' and @data-valuedim2='TE'])[1]")
	WebElement TEPortfolioProgressBar;
	
	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-danger' and @data-valuetop1='MM' and @data-valuedim2='TE'])[1]")
	WebElement TERFProgressBar;

	public LiquidityPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickModelLiquiProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(liquiModelProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			liquiModelProgressBar.click();
		}

	}

	public void clickPortfolioLiquiProgressBar() {
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(liquiPortfolioProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			liquiPortfolioProgressBar.click();
		}
	}

	public void clickRFLiquiProgressBar() {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.visibilityOf(liquiRFProgressBar)).click();;

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			liquiRFProgressBar.click();
		}
	}
	
	public void clickTETAAProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(TETAAProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			TETAAProgressBar.click();
		}

	}
	
	public void clickTEModelProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(TEModelProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			TEModelProgressBar.click();
		}

	}
	
	public void clickTEPortfolioProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(TEPortfolioProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			TEPortfolioProgressBar.click();
		}

	}
	
	public void clickTERFProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			wait.until(ExpectedConditions.visibilityOf(TERFProgressBar)).click();

			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			driver.navigate().refresh();
			TERFProgressBar.click();
		}

	}
	
}
