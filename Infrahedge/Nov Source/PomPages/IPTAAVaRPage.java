package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPTAAVaRPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[4]/div)[2]")
	WebElement tAAVaRProgressbar;

	public IPTAAVaRPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clicktAAVaRProgressbar()
	{
		tAAVaRProgressbar.click();
	}
	
}
