package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPTAATEPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[4]/div)[3]")
	WebElement tAATEProgressbar;

	public IPTAATEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicktAATEProgressbar()
	{
		tAATEProgressbar.click();
	}

	
	
}
