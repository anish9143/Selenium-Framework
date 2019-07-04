package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Infrahedge.generic.BaseTest;

public class IPPortfolioVaRPage extends BaseTest {

	
	@FindBy(xpath="//*[@id=\"QV018\"]/section/div/table/tbody[2]/tr/td[6]/div/div[1]")
	WebElement PortfolioVaRProgressbar;

	public IPPortfolioVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPortfolioVaRProgressbar()
	{
		WebDriverWait wait = new WebDriverWait(driver, 12);
try {
        WebElement element = wait.until(ExpectedConditions.visibilityOf(PortfolioVaRProgressbar)); 
		PortfolioVaRProgressbar.click();
}
catch(Exception e)
{
	System.out.println("Element not found");
}

		
	}
	
}
