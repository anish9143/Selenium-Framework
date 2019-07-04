package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPModelLiquidityPage extends BaseTest{

	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[4]/tr/td[5]")
	WebElement modelLiquidityProgressbar;

	public IPModelLiquidityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickmodelLiquidityProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(modelLiquidityProgressbar)); 
        modelLiquidityProgressbar.click();
        System.out.println("clicked on ProgressBar");
}
catch(Exception e)
{
	driver.navigate().refresh();
	modelLiquidityProgressbar.click();
}

		
	}
	
	
}
