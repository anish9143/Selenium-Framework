package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class VolatilityPage extends BaseTest {

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='SAA'])[1]")
	WebElement volSAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='TAA'])[1]")
	WebElement volTAAProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Model'])[1]")
	WebElement volModelProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio'])[1]")
	WebElement volPortfolioProgressBar;

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='MM'])[1]")
	WebElement volMMProgressBar;

	@FindBy(xpath = "(//*[@class='lui-icon lui-icon--plus gray pivot-expand-colapse'])[1]")
	WebElement expandAll;

	@FindBy(xpath = "(//*[@class='lui-icon lui-icon--minus gray pivot-expand-colapse'])[1]")
	WebElement collpaseAll;

	@FindBy(xpath = "//*[@class='lui-icon lui-icon--sheet navSettingClass']")
	WebElement graphIcon;

	@FindBy(xpath = "(//*[@class='navSettingClass'])[1]")
	WebElement settingsIcon;

	public VolatilityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSAAVolProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(volSAAProgressBar));

			// JavascriptExecutor executor= (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
			volSAAProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			// driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			volSAAProgressBar.click();
		}
	}

	public void clickTAAVolProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(volTAAProgressBar));

			// JavascriptExecutor executor= (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
			volTAAProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			volTAAProgressBar.click();
		}

	}

	public void clickModelVolProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(volModelProgressBar));

			// JavascriptExecutor executor= (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
			volModelProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			volModelProgressBar.click();
		}

	}

	public void clickPortfolioVolProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(volPortfolioProgressBar));

			// JavascriptExecutor executor= (JavascriptExecutor) driver;
			// executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
			volPortfolioProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			volPortfolioProgressBar.click();
		}

	}

	public void clickMMVolProgressBar() {

		WebDriverWait wait = new WebDriverWait(driver, 15);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(volMMProgressBar));

			volMMProgressBar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			volMMProgressBar.click();
		}

	}

}
