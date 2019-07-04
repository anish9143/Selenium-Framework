package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPModelVolatilityPage {

	
	@FindBy(xpath="//*/div/table/tbody/tr/td[5]/div[1]")
	WebElement ModelVolProgressbar;

	public IPModelVolatilityPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickModelVolProgressbar()
	{
		ModelVolProgressbar.click();
	}
	
}
