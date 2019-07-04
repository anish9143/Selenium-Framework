package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPPortfolioVaRPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[6]/div)[2]")
	WebElement PortfolioVaRProgressbar;

	public IPPortfolioVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickPortfolioVaRProgressbar()
	{
		PortfolioVaRProgressbar.click();
	}
	
}
