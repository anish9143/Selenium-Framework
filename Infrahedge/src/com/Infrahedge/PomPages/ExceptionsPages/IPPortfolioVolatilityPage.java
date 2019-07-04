package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPPortfolioVolatilityPage extends BaseTest {

	@FindBy(xpath = "(//*[@class='progress-bar progress-bar-success' and @data-valuetop1='Portfolio'])[1]")
	WebElement PortfolioVolProgressbar;

	public IPPortfolioVolatilityPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void clickPortfolioVolProgressbar() {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOf(PortfolioVolProgressbar));


			PortfolioVolProgressbar.click();
			System.out.println("clicked on ProgressBar");
		} catch (Exception e) {
			//driver.navigate().refresh();
			driver.findElement(By.xpath("//input[@name='radioB' and @value = 'BUK']")).click();
			PortfolioVolProgressbar.click();
		}

	}

}
