package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPPortfolioVolatilityPage {

	
	@FindBy(xpath="//*/div/table/tbody/tr/td[6]/div[1]")
	WebElement PortfolioVolProgressbar;

	public IPPortfolioVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPortfolioVolProgressbar()
	{
		PortfolioVolProgressbar.click();
	}
	
}
