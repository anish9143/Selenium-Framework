package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPPortfolioTEPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[6]/div)[3]")
	WebElement PortfolioTEProgressbar;

	public IPPortfolioTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPortfolioTEProgressbar()
	{
		PortfolioTEProgressbar.click();
	}
	
}
