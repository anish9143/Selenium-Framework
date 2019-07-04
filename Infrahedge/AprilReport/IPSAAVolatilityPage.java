package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPSAAVolatilityPage extends BaseTest{

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[3]/div)[1]")
	WebElement sAAVolProgressbar;

	public IPSAAVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicksAAVolProgressbar()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
	        WebElement element = wait.until(ExpectedConditions.visibilityOf(sAAVolProgressbar)); 
	        
	        //JavascriptExecutor executor= (JavascriptExecutor) driver;
	        //executor.executeScript("arguments[0].click;", portfolioLiquidityProgressbar);
	        sAAVolProgressbar.click();
	        System.out.println("clicked on ProgressBar");
	}
	catch(Exception e)
	{
		driver.navigate().refresh();
		sAAVolProgressbar.click();
	}
	}
	
}
