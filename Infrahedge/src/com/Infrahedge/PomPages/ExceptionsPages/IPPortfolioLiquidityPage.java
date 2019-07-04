package com.Infrahedge.PomPages.ExceptionsPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPPortfolioLiquidityPage extends BaseTest{

	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[4]/tr/td[6]/div/div[1]")
	WebElement portfolioLiquidityProgressbar;

	public IPPortfolioLiquidityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickportfolioLiquidityProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(portfolioLiquidityProgressbar)); 
        
        //JavascriptExecutor executor= (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
      portfolioLiquidityProgressbar.click();
        System.out.println("clicked on ProgressBar");
}
catch(Exception e)
{
	driver.navigate().refresh();
	 portfolioLiquidityProgressbar.click();
}

		
	}
	
	
}
