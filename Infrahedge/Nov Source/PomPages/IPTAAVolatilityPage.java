package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPTAAVolatilityPage {

	
	@FindBy(xpath="//*/div/table/tbody/tr/td[4]/div[1]")
	WebElement tAAVolProgressbar;

	public IPTAAVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicktAAVolProgressbar()
	{
		tAAVolProgressbar.click();
	}
	
}
