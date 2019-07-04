package com.Infrahedge.PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IPModelTEPage {

	
	@FindBy(xpath="(//*/div/table/tbody/tr/td[5]/div)[3]")
	WebElement ModelTEProgressbar;

	public IPModelTEPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickModelTEProgressbar()
	{
		ModelTEProgressbar.click();
	}
	
}
